/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Writer;

public class Elem {
	String name;
	String type;
	String doc = "";
	public String toString() {
		return "{name: $name, type: $type, doc:$doc}";
	}
}

def xs = new groovy.xml.Namespace("http://www.w3.org/2001/XMLSchema", 'xs');
def schemaFile = "xhtml1-transitional.xsd";
def root = new XmlParser().parse(schemaFile);
//print root;
def elements = root[xs.element].findAll{ it.'@name' };

def es = [];
for (e in elements) {
	def type;
	if (e.'@name' in ['div', 'script', 'textarea', 'iframe'])
		type = "pair";
	else if (e[xs.complexType][xs.sequence])
		type = "pair";
	else if (e[xs.complexType][xs.choice])
		type = "pair";
	else if (e[xs.complexType].findAll { it.'@mixed' == 'true'})
		type = "normal";
	else
		type = "self";
	def et = new Elem();
	et.name = e.'@name';
	et.type = type;
	if (e[xs.annotation][xs.documentation])
		et.doc = e[xs.annotation][xs.documentation][0].text();
	es << et;
		
}
def attributes = root.breadthFirst().findAll { it.name() == "xs:attribute" }.collect { it.'@name' };
attributes = new ArrayList(new HashSet(attributes));
attributes.sort();
es.sort { a,b -> a.name.compareTo b.name};
//print elements;
def javaReserved = ["abstract","continue","for","new","switch","assert",
	"default","goto","package","synchronized","boolean","do","if","private",
	"this","break","double","implements","protected","throw","byte","else","import","public","throws",
	"case","enum","instanceof","return","transient","catch","extends","int","short","try","char","final",
	"interface","static","void","class","finally","long","strictfp","volatile","const","float","native","super","while",
	"null", "true", "false"]
def reserved = ['ns', 'xmlns', 'start', 'end', 'attr', 'raw', 'text', 'bind', 'unbind', 'getSelf'] + javaReserved;

def className = "GeneratedHtmlBuilder"
print """
package com.googlecode.jatl;

import java.io.Writer;

/**
 * Auto-Generated builder from schema: $schemaFile
 */
protected abstract class $className<T> extends MarkupBuilder<T> {

	public $className(Writer writer) {
		super(writer);
	}
	
	public $className(MarkupBuilder<?> builder) {
		super(builder);
	}

	public $className(MarkupBuilder<?> builder, boolean nested) {
		super(builder, nested);
	}
	
	protected $className() {
		super();
	}
"""

for (e in es) {
if ( ! e.name ) continue;
def name = e.name;
def t = e.name;
if (name in reserved) name = name+"Tag";
def type = e.type.toUpperCase();
def header = "Starts the &lt;" + t + "&gt; tag."
def lines = [header] + e.doc.split('\n') + ["<p>", "Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#$type}", 
	"@return this, never <code>null</code>"];
def doc = '/**\n\t * ' + lines.join('\n\t * ') + " \n\t */";

print """
	$doc
	public T $name() {
		return start("$t", TagClosingPolicy.$type);
	}
""";
}

for (a in attributes) {
	def name = a in reserved ? a + "Attr" : a;
print """
	/**
	 * Sets the <code>$a</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T $name(String value) {
		return attr("$a", value);
	}
""";
}

print """
}
""";



