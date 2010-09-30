
public class Elem {
	String name;
	String type;
	String doc = "";
	public String toString() {
		return "{name: $name, type: $type, doc:$doc}";
	}
}

def xs = new groovy.xml.Namespace("http://www.w3.org/2001/XMLSchema", 'xs');
def root = new XmlParser().parse("xhtml1-transitional.xsd");
//print root;
def elements = root[xs.element].findAll{ it.'@name' };

def es = [];
for (e in elements) {
	def type;
	if (e.'@name' in ['div', 'script'])
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

for (e in es) {
def name = e.name;
def type = e.type.toUpperCase();
def footer = " <p>\n * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#$type}\n * @return this, never <code>null</code> "
def doc = '/**\n * ' + e.doc.split('\n').join('\n * ') + footer + " \n */"; 
print """
$doc
public T $name() {
	return start("$name", TagClosingPolicy.$type);
}
""";
}

for (a in attributes) {
	def name = a == 'class' ? 'clazz' : a;
print """
public T $name(String value) {
	return attr("$name", value);
}
""";
}



