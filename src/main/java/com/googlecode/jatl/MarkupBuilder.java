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

package com.googlecode.jatl;

import static com.googlecode.jatl.InternalValidationUtils.isBlank;
import static com.googlecode.jatl.InternalValidationUtils.isTrue;
import static com.googlecode.jatl.InternalValidationUtils.notEmpty;
import static com.googlecode.jatl.InternalValidationUtils.notNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import com.googlecode.jatl.Indenter.TagIndentSpot;

/**
 * <a href="http://en.wikipedia.org/wiki/Fluent_interface">Fluent styled</a> 
 * markup builder that writes to a {@link Writer}.
 * 
 * <h2>Description</h2>
 * Writes XML markup to a {@link Writer}.
 * The Builder part of the name is somewhat misleading as
 * this class does not store or keep track of all the markup objects created but rather
 * writes using the writer as soon as it can.
 * Thus the order of operations performed on this class is very important and should 
 * follow the order that you would write the markup.
 * 
 * <h2>Usage</h2>
 * You should not use this class directly but rather one of its subclasses
 * that is parameterized with itself (see Extending). You generally define the markup you want to write
 * using Java anonymous classes that extend either a {@link MarkupBuilder} or {@link MarkupWriter}. 
 * Markup builders write immediately to a writer where as a markup writer 
 * writes when told to. But again in both cases you generally define the markup with an anonymous class.
 * <p>
 * For examples of use its best to see {@link Html} for an XHTML builder which will write XHTML 
 * markup immediatly or {@link HtmlWriter} which allows you to define XHTML markup then write it later.
 * <p>
 * {@link MarkupWriter Markup writers} are more useful for MVC frameworks and {@link MarkupBuilder builders}
 * are more for convenience.
 * 
 * <h2>Extending</h2>
 * If you would you would like to make your own builder you should subclass 
 * this class or a subclass that has generic parameter (&lt;T&gt;).
 * <p>
 * <em>The custom builder should be parameterized to itself to support fluent style.</em>
 * <p>
 * <strong>Example:</strong>
 * <pre>
public class MyMarkup extends MarkupBuilder&lt;MyMarkup&gt; {

	public MyMarkup(Writer builder) {
		super(builder);
	}
	protected MyMarkup getSelf() {
		return this;
	}
	
	public MyMarkup myTag() {
		return start("myTag");
	}
}
 * </pre>
 * <h2>Composition</h2>
 * Besides the extending method above you can achieve composition of markup builders by using MarkupWriter's instead.
 * See {@link MarkupWriter}. <p>
 * See {@link #write(MarkupWriter...)}.
 * 
 * <h2>Writing tags and attributes</h2>
 * See {@link #start(String)} and {@link #end()} for writing tags.
 * See {@link #attr(String...)} for writting attributes.
 * 
 * <h2>Variable expansion</h2>
 * Simple named variable replacements are supported through the <pre>${...}</pre> notation.
 * See {@link #bind(String, Object)}, and {@link #text(String)}.
 * 
 * <h2>Pretty Printing aka Indenting</h2>
 * See #indent  {@link Indenter}. For most cases you can use {@link SimpleIndenter}
 * 
 * <h2>Namespaces</h2>
 * You can either manually maintain namespaces and namespace prefixes by setting the correct attributes and 
 * then writing tags with the namespace prefix. Example: {@code start("prefix:tagName")}.
 * Or you can use the namespace methods: {@link #ns()}, {@link #ns(String)}, {@link #xmlns(String, String)}
 * The following Nested builders are very helpful for working with multiple XML schemas.
 * 
 * <h2>Nested builders</h2>
 * Nested builders are an easy way to allow different markup styles to coexist elegantly.
 * An example might be HTML with in XSL. You would have an HTML builder nested inside
 * the XSL builder.<p>
 * <strong>Example:</strong>
 * <pre>
 * new Xslt(writer) {{
 * 	ns("xsl");
 * 	template().match("stuff");
 * 		new Html(writer) {{
 * 			html().body().done();
 * 		}}
 * 	done();
 * }}
 * </pre>
 * See {@link #MarkupBuilder(MarkupBuilder)}.
 * 
 * <h2>Thread safety</h2>
 * <em>This class and subclasses are not thread safe.</em>
 * One way to make a builder thread safe is to synchronize on the passed in writer:
 * <pre>
 * synchronize(writer) {
 *    new SomeBuilder(writer) {{ }}; 
 * }
 * </pre>
 * <h2>Efficiency and Validation</h2>
 * To keep the builder efficient and elegant there is very little XML validation.
 * There is no guarantee that the markup generated will always be well formed.
 * Generally {@link #text(String) Text} will be escaped appropriately.
 * <p>
 * <em>For those seriously concerned with performance an appropriate implementation of 
 * {@link Writer} should be given to the builder.</em>
 * <p>
 * For example: In a single threaded environment where you are writing to memory 
 * <a href="http://commons.apache.org/io/apidocs/org/apache/commons/io/output/StringBuilderWriter.html">
 * Commons IO StringBuilderWriter
 * </a> is a good choice over {@link StringWriter}.
 * <p>
 * On the other hand if you are writing very large XML document to a file 
 * or network socket {@link PrintWriter} is probably a better choice.
 * 
 * @author adamgent
 * @param <T> This should always be parameterized with the exact same 
 * class that is extending the {@link MarkupBuilder} to support fluent style.
 * @see TagClosingPolicy
 * @see #start(String, TagClosingPolicy)
 * @see #attr(String...)
 * @see #end()
 * @see #done()
 */
public abstract class MarkupBuilder<T> {
	private Stack<Tag> tagStack = new Stack<Tag>();
	private Writer writer;
	private Map<String, String> attributes = createMap();
	private Map<String, Object> bindings = new HashMap<String, Object>();
	private MarkupBuilder<?> previousBuilder = null;
	private int depth = 0;
	private String namespacePrefix = null;
	private Indenter previousIndenter = indentOn;
	private Indenter indenter = indentOn;

	private static final String q = "\"";
	
	/**
	 * Create a builder using the given writer.
	 * @param writer never <code>null</code>.
	 */
	public MarkupBuilder(Writer writer) {
		super();
		notNull(writer, "writer");
		this.writer = writer;
	}
	
	/**
	 * Create a nested builder from given builder.
	 * Make sure {@link #done()} is called when finished with the
	 * nested builder so that the parent builder can resume using the writer.
	 * 
	 * @param builder parent builder, never <code>null</code>. 
	 * @see #done()
	 */
	public MarkupBuilder(MarkupBuilder<?> builder) {
		this(builder, true);
	}
	
	/**
	 * Use for deferred writer.
	 * The writer should be {@link #setWriter(Writer) set} before 
	 * the builder is used.
	 * 
	 * @see #setWriter(Writer)
	 * @see MarkupWriter
	 */
	protected MarkupBuilder() {
		
	}
	
	/**
	 * Create a nested builder from a builder or resume from a builder.
	 * @param builder never <code>null</code>.
	 * @param nested <code>true</code> means nested, <code>false</code> means resuming.
	 */
	public MarkupBuilder(MarkupBuilder<?> builder, boolean nested) {
		builder.checkWriter();
		if (nested)
			builder.writeCurrentTag();
		if (nested && ! builder.tagStack.isEmpty()) {
			Tag t = builder.tagStack.peek();
			this.depth = 1 + t.depth + builder.depth;
		}
		else {
			this.depth = builder.depth;
		}
		this.writer = builder.writer;
		builder.writer = null;
		
		if (nested) {
			//Clone the previous builders binding
			this.previousBuilder = builder;
			this.bindings = new HashMap<String, Object>(builder.bindings);
		}
		else {
			this.tagStack = builder.tagStack;
			this.bindings = builder.bindings;
			this.attributes = builder.attributes;
		}
	}
	
	/**
	 * Needed for fluent style and Java parameterization limitations. 
	 * Almost all public methods should return whatever this method returns.
	 * <p>
	 * Most implementations only have to do:
	 * <pre>
	 * return this;
	 * </pre>
	 * @return the current builder which is usually <code>this</code> object.
	 */
	protected abstract T getSelf();
	
	
	/**
	 * Restores the current namespace prefix
	 * to whatever the surrounding tags prefix is.
	 * To set the namespace to the default namespace call:
	 * <p>
	 * {@code ns(null);}
	 * @return maybe <code>null</code>.
	 * @see #ns(String)
	 */
	public final T ns() {
		if (tagStack.isEmpty()) {
			return ns(null);
		}
		return ns(tagStack.peek().prefix);
	}

	/**
	 * Sets the current namespace prefix. If a tag is started when
	 * the prefix is set to a non-null non-empty string, the prefix will
	 * be added in front of the tag.
	 * <p>
	 * <strong>Example:</strong>
	 * </p>
	 * <pre>
	 * ns("html").div().end();
	 * </pre>
	 * <p>
	 * <strong>Result:</strong>
	 * </p>
	 * <pre>
	 * &lt;html:div&gt;&lt;/html:div&gt;
	 * </pre>
	 * @param prefix maybe <code>null</code>
	 * @return this, not <code>null</code>.
	 */
	public final T ns(String prefix) {
		this.namespacePrefix = prefix;
		return getSelf();
	}

	/**
	 * Sets the writer after the builder has been created.
	 * Only useful with the empty constructor.
	 * @param writer never <code>null</code>
	 * @throws IllegalArgumentException if the writer has already been set or the given writer is null.
	 */
	public final void setWriter(Writer writer) {
		isTrue(this.writer == null, "Writer is already set.");
		notNull(writer, "writer");
		this.writer = writer;
	}
	
	/**
	 * Sets the indent depth after the builder has been created.
	 * Only useful with the empty constructor.
	 * @param depth should greater than or equal <code>0</code>
	 */	
	public final void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Sets the indenter.
	 * @param indenter if <code>null</code> reverts to the previous builder.
	 * @return the builder.
	 * @see #indentOn
	 * @see #indentOff
	 * @see #indentSameLine
	 */
	public T indent(Indenter indenter) {
		if (indenter == null) 
			this.indenter = previousIndenter;
		else {
			this.previousIndenter = this.indenter;
			this.indenter = indenter;
		}
		return getSelf();
	}
	
	private final Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * Writes variable expanded escaped text inside a tag.
	 * 
	 * @param text the text will be escaped and variables will be expanded.
	 * @return never <code>null</code>.
	 * @see #raw(String)
	 * @see #bind(String, Object)
	 */
	public final T text(String text) {
		if (text != null) {
			writeCurrentTag();
			write(escapeElementMarkup(expand(text)));
		}
		return getSelf();
	}
	
	/**
	 * Write text with out escaping or variable expansion.
	 * @param text text to be directly written with escaping or expansion (be careful).
	 * @return never <code>null</code>.
	 * @see #raw(String, boolean)
	 */
	public final T raw(String text) {
	    return raw(text, false);
	}
	/**
	 * Writes text with out escaping.
	 * @param text maybe <code>null</code>, a <code>null</code> is a no operation.
	 * @param expand <code>true</code> does variable expansion.
	 * @return never <code>null</code>.
	 */
	public final T raw(String text, boolean expand) {
		if (text != null) {
			writeCurrentTag();
			text = expand ? expand(text) : text;
			write(text);
		}
		return getSelf();
	}
	
	/**
	 * Binds a named variables to be used for expansion in {@link #attr(String...) attributes} 
	 * and {@link #text(String) text}. Variables are represented with by <code>${...}</code>.
	 * <p>
	 * <strong>Example</strong>
	 * </p>
	 * <pre>
	 * bind("name", "Ferris");
	 * text("${name}");
	 * </pre>
	 * <p>
	 * <em>Variables are expanded in order and can be referred in a later binding.</em>
	 * </p>
	 * <pre>
	 * bind("firstName", "Adam");
	 * bind("lastName", "Gent");
	 * bind("fullName", "${firstName} ${lastName}");
	 * </pre>
	 * @param name never <code>null</code> or empty.
	 * @param value maybe <code>null</code>.
	 * @return never <code>null</code>.
	 */
	public final T bind(String name, Object value) {
		notEmpty(name, "name");
		Object v = value != null && value instanceof String ? expand(value.toString()) : value;
	    bindings.put(name, v);
	    return getSelf();
	}
	
	/**
	 * Removes a binding.
	 * There is no failure if the binding does not exist.
	 * @param name maybe <code>null</code>.
	 * @return never <code>null</code>.
	 * @see #bind(String, Object)
	 */
	public final T unbind(String name) {
		if (bindings.containsKey(name))
			bindings.remove(name);
	    return getSelf();
	}
	
	/**
	 * Convenience for {@link #bind(String, Object)}
	 * @param nvps never <code>null</code>.
	 * @return never <code>null</code>.
	 */
	public final T bind(Collection<Entry<String, Object>> nvps) {
	    for (Entry<String,Object> nvp : nvps) {
	        bind(nvp.getKey(), nvp.getValue());
	    }
	    return getSelf();
	}

	/**
	 * Starts a tag using the default closing policy {@link TagClosingPolicy#NORMAL}.
	 * <p>
	 * Equivalent to: {@code start("tag", TagClosingPolicy.NORMAL)}.
	 * </p>
	 * @param tag the name of the tag, should never be <code>null</code>.
	 * @return this, never <code>null</code>.
	 * @see #start(String, TagClosingPolicy)
	 */
	public final T start(String tag) {
		return start(tag, TagClosingPolicy.NORMAL);
	}
	
	/**
	 * Starts a tag but does not immediately write it till the next
	 * tag is started.
	 * The {@link TagClosingPolicy} dictates whether or not the tag 
	 * needs to be  {@link #end() closed}. Thus {@link #end()} does not need to be called
	 * for all tags.
	 * 
	 * @param tag never <code>null</code> or empty.
	 * @param policy never <code>null</code>.
	 * @return never <code>null</code>.
	 * @see #end()
	 */
	public final T start(String tag, TagClosingPolicy policy) {
		writeCurrentTag();
		Tag t = new Tag(tag);
		t.closePolicy = policy;
		t.depth = tagStack.size();
		t.prefix = this.namespacePrefix;
		tagStack.push(t);
		return getSelf();
	}
	
	/**
	 * Adds attributes to the last {@link #start(String) start tag}.
	 * Attributes do not need an {@link #end()} call.
	 * @param attrs name value pairs. Its invalid for an odd number of arguments.
	 * @return never <code>null</code>.
	 * @throws IllegalArgumentException odd number of arguments.
	 * @throws IllegalStateException if there are no open start tags.
	 */
	public final T attr(String ... attrs ) {
		isTrue(attrs.length  % 2 == 0, "attributes should be multiple of 2 (name=value)");
		if (tagStack.isEmpty() || (tagStack.peek().start)) {
			throw new IllegalStateException("There are no open tags to add attributes too. " +
					"Markup attributes should only be added " +
					"immediatly after starting a tag.");
		}
		checkWriter();
		for (int n = 0, v = 1; v < attrs.length; n+=2, v+=2) {
			getAttributes().put(attrs[n], attrs[v]);
		}
		return getSelf();
	}
	
	/**
	 * Sets the default namespace on the last started tag.
	 * @param uri if <code>null</code> nothing will happen.
	 * @return this, never <code>null</code>.
	 * @see #xmlns(String, String)
	 */
	public final T xmlns(String uri) {
		return xmlns(uri, null);
	}
	
	/**
	 * Sets an XML namespace.
	 * @param uri if <code>null</code> nothing will happen.
	 * @param prefix if <code>null</code> or blank will act 
	 * 	like the default namespace and no prefix. 
	 * @return this, never <code>null</code>.
	 */
	public final T xmlns(String uri, String prefix) {
		if (isBlank(uri)) return getSelf();
		String n = isBlank(prefix) ? "xmlns" : prefix + ":xmlns";
		return attr(n, uri);
	}
	
	/**
	 * Closes the inputed number of open tags.
	 * @param i less than zero will do nothing.
	 * @return never <code>null</code>.
	 * @see #end()
	 */
	public final T end(int i) {
		while ( i-- > 0 && ! tagStack.isEmpty() ) {
			end();
		}
		return getSelf();
	}
	/**
	 * Closes the last {@link #start(String) start tag}.
	 * This is equivalent to <code>&lt;/tag&gt;</code> or <code>&lt;tag/&gt;</code> depending
	 *  on the {@link TagClosingPolicy}.
	 * @return never <code>null</code>.
	 * @see #start(String, TagClosingPolicy)
	 * @see #endAll()
	 * @see #done()
	 */
	public final T end() {
		checkWriter();
		Tag t = tagStack.peek();
		writeStartTag(t);
		writeEndTag(t);
		tagStack.pop();
		attributes.clear();
		return getSelf();
	}
	
	/**
	 * Closes all open tags.
	 * @return never <code>null</code>.
	 * @see #end()
	 */
	public final T endAll() {
		while( ! tagStack.isEmpty() ) {
			end();
		}
		return getSelf();
	}
	
	/**
	 * Call when completely done with the builder.
	 * This is required for nested builders.
	 * <p>
	 * If a builder is used again after {@code done()} is called
	 * an exception (usually {@link IllegalArgumentException}) will be thrown.
	 */
	public final void done() {
		endAll();
		if (previousBuilder != null) {
			isTrue(previousBuilder.writer == null, 
					"The previous builder has its writer set. It should not.");
			previousBuilder.writer = writer;
		}
		this.writer = null;
	}
	
	/**
	 * Writes immediately by passing the writer to each {@link MarkupWriter} 
	 * in the order passed in.
	 * @param writers never <code>null</code>, null elements passed in are ignored.
	 * @return never <code>null</code>.
	 * @since 0.2.2
	 */
	public final T write(MarkupWriter... writers) {
		checkWriter();
		int depth = 1 + (tagStack.isEmpty() ? 0 : tagStack.peek().depth);
		writeCurrentTag();
		notNull(writers, "writers");
		for (MarkupWriter w : writers) {
			if (w != null && w instanceof MarkupBuilderWriter) {
				((MarkupBuilderWriter)w).write(this.writer, this.depth + depth);
			}
			else if (w != null) {
				w.write(this.writer);
			}
		}
		
		return getSelf();
	}
	
	private void writeCurrentTag() {
		checkWriter();
		if ( ! tagStack.isEmpty() ) {
			Tag current = tagStack.peek();
			if ( current.empty && ! current.end ) {
				current.empty = current.closePolicy.isAlwaysSelfClosing();
				writeStartTag(current);
				if (current.closePolicy.isAlwaysSelfClosing()) {
					end();
				}
			}
		}
		attributes.clear();
	}
	
	private void writeStartTag(Tag t) {
		if ( ! t.end  && ! t.start) {
			writeIndent(t, TagIndentSpot.BEFORE_START_TAG);
			writeTag(t.getQualifiedName(), t.isSelfClosing());
			writeIndent(t, TagIndentSpot.AFTER_START_TAG);
			if (t.isSelfClosing()) {
				writeIndent(t, TagIndentSpot.AFTER_END_TAG);
			}
			t.end = t.isSelfClosing();
			t.start = true;
		}
	}
	
	private void writeTag(String tag, boolean close) {
		Map<String, String> attrs = getAttributes();
		write("<" + tag);
		if (attrs != null && ! attrs.isEmpty()) {
			write(" ");
			writeAttributes(attrs);
		}
		if (close)
			write("/>");
		else
			write(">");
	}
	
	private void writeEndTag(Tag t) {
		if ( ! t.end ) {
			writeIndent(t, TagIndentSpot.BEFORE_END_TAG);
			write("</" + t.getQualifiedName() + ">");
			t.end = true;
			writeIndent(t, TagIndentSpot.AFTER_END_TAG);
		}
	}
	
	private void writeAttributes(Map<String, String> attrs) {
		if (attrs == null) return;
		boolean space = false;
		for (Entry<String, String> attr : attrs.entrySet()) {
			String key = attr.getKey();
			String value = attr.getValue();
			if (space) {
				write(" ");
			}
			else {
				space = true;
			}
			writeAttr(key,value);
		}
	}
	private void writeAttr(String name, String value) {
		if (value != null && name != null) {
			write(expand(name + "=" + q(value)));
		}		
	}
	private String q(String raw) {
		return q + escapeAttributeMarkup(expand(raw)) + q;
	}
	
	private String expand(String text) {
	    InternalStrSubstitutor s = new InternalStrSubstitutor(bindings);
	    return s.replace(text);
	}
	
	private void write(String raw) {
		checkWriter();
		try {
			writer.write(raw);
		} catch (IOException e) {
			throw new RuntimeException("Writer for Builder failed:", e);
		}
	}
	private void checkWriter() {
		notNull(writer, "The writer has not been seet " +
				"or is in use by another builder.");
	}
	private Map<String, String> createMap() {
		return new LinkedHashMap<String, String>();
	}
	
	/**
	 * DEPRECATED.
	 * @param raw maybe <code>null</code>.
	 * @return maybe <code>null</code> if null for input.
	 * @see #text(String)
	 * @deprecated Please use {@link #escapeElementMarkup(String)} and {@link #escapeAttributeMarkup(String)}
	 */
	protected String escapeMarkup(String raw) {
		return MarkupUtils.escapeElementEntities(raw);
	}
	
	/**
	 * The strategy for escaping element markup. 
	 * The default is escape for XML.
	 * @param raw maybe <code>null</code>.
	 * @return maybe <code>null</code> if null for input.
	 * @see #text(String)
	 * @see #escapeAttributeMarkup(String)
	 */
	protected String escapeElementMarkup(String raw) {
		return escapeMarkup(raw);
	}
	
	/**
	 * The strategy for escaping attribute markup.
	 * The default escaping is XML. 
	 * Entities will be used for white space characters:
	 * <code>#xD, #xA, #x9</code><p>
	 * CR, newline, and tab, respectively.
	 * @param raw maybe <code>null</code>.
	 * @return maybe <code>null</code> if null for input.
	 */
	protected String escapeAttributeMarkup(String raw) {
		return MarkupUtils.escapeAttributeEntities(raw);
	}
	
	private void writeIndent(
			Tag t,
			TagIndentSpot spot) {
		try {
			indenter.indentTag(this.writer, t.depth, this.depth, 
					spot, t.name, t.closePolicy, t.empty);
		} catch (IOException e) {
			throw new RuntimeException("Builder Indenting failed:", e);
		}	
	}
	
	/**
	 * A default indenter that uses tabs.
	 */
	protected static Indenter indentOn = new SimpleIndenter("\n", "\t", "\n", "\t");
	/**
	 * An indenter that turns off indenting.
	 */
	protected static Indenter indentOff = new SimpleIndenter(null, null, null, null);
	/**
	 * Indents by keeping a tag pair on the same line. 
	 */
	protected static Indenter indentSameLine = new SimpleIndenter("\n", "\t", null, null);
	
	private static class Tag {
		
		public Tag(String name) {
			super();
			this.name = name;
		}
		public int depth = 0;
		public String name;
		public String prefix;
		public boolean empty = true;
		public boolean start = false;
		public boolean end = false;
		
		public TagClosingPolicy closePolicy = TagClosingPolicy.NORMAL;
		
		public String getQualifiedName() {
			return isBlank(this.prefix) || this.name.contains(":") ? this.name : 
				this.prefix + ":"  + this.name;
		}
		
		public boolean isSelfClosing() {
			return empty && closePolicy.isSelfClosing();
		}
		
	}
	
	/**
	 * Policy for how tags should be closed.
	 * @author adamgent
	 *
	 */
	public enum TagClosingPolicy {
		/**
		 * The tag can either be closed with a matching closing tag
		 * or self closing. It will be self closing if the tag contains
		 * no child tags or text.
		 * <ul>
		 * <li><code>&lt;tag/&gt;</code></li>
		 * <li><code>&lt;tag&gt;...&lt;/tag&gt;</code></li>
		 * </ul>
		 * <em>Unlike {@link #SELF self closing} tags a {@link #NORMAL} tag must be explicitly closed.</em>
		 */
		NORMAL,
		
		/**
		 * The tag is always a self closing tag.
		 * <ul>
		 * <li><code>&lt;tag/&gt;...</code></li>
		 * </ul>
		 * <p>
		 * <em>When a tag has this policy the tag can be implicitly closed 
		 * by {@link MarkupBuilder#start(String, TagClosingPolicy) starting the next tag}:</em>
		 * </p>
		 * <pre>
		 * start("self",TagClosingPolicy.SELF).start("next");
		 * </pre>
		 * <p>
		 * Result:
		 * </p>
		 * <pre>
		 * &lt;self/&gt;
		 * &lt;next&gt;
		 * ...
		 * </pre>
		 *
		 */
		SELF,
		/**
		 * The tag is always closed with a matching closing tag
		 * regardless if there is no child tag or text.
		 * <ul>
		 * <li><code>&lt;tag&gt;...&lt;/tag&gt;</code></li>
		 * <li><code>&lt;tag&gt;&lt;/tag&gt;</code></li>
		 * </ul>
		 */
		PAIR;
		
		public final boolean isAlwaysSelfClosing() {
			return this == SELF;
		}
		
		/**
		 * @return <code>true</code> if the tag is allowed to self close.
		 */
		public final boolean isSelfClosing() {
			return this == SELF || this == NORMAL;
		}
		
		/**
		 * @return <code>true</code> if the tag is allowed to close with a matching end tag (<code>&lt;/tag&gt;</code>).
		 */
		public final boolean isPairClosing() {
			return this == PAIR || this == NORMAL;
		}
	}

}
