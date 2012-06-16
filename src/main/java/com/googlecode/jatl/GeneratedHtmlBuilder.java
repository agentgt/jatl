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

import java.io.Writer;

/**
 * Auto-Generated builder from schema: xhtml1-transitional.xsd
 */
abstract class GeneratedHtmlBuilder<T> extends MarkupBuilder<T> {

	public GeneratedHtmlBuilder(Writer writer) {
		super(writer);
	}
	
	public GeneratedHtmlBuilder(MarkupBuilder<?> builder) {
		super(builder);
	}

	public GeneratedHtmlBuilder(MarkupBuilder<?> builder, boolean nested) {
		super(builder, nested);
	}
	
	protected GeneratedHtmlBuilder() {
		super();
	}

	/**
	 * Starts the &lt;a&gt; tag.
	 * [content is "Inline" except that anchors shouldn't be nested]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T a() {
		return start("a", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;abbr&gt; tag.
	 * [abbreviation]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T abbr() {
		return start("abbr", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;acronym&gt; tag.
	 * [acronym]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T acronym() {
		return start("acronym", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;address&gt; tag.
	 * [information on author]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T address() {
		return start("address", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;applet&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T applet() {
		return start("applet", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;area&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T area() {
		return start("area", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;b&gt; tag.
	 * [bold font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T b() {
		return start("b", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;base&gt; tag.
	 * [document base URI]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T base() {
		return start("base", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;basefont&gt; tag.
	 * [base font size]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T basefont() {
		return start("basefont", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;bdo&gt; tag.
	 * [I18N BiDi over-ride]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T bdo() {
		return start("bdo", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;big&gt; tag.
	 * [bigger font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T big() {
		return start("big", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;blockquote&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T blockquote() {
		return start("blockquote", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;body&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T body() {
		return start("body", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;br&gt; tag.
	 * [forced line break]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T br() {
		return start("br", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;button&gt; tag.
	 * [Content is "Flow" excluding a, form and form controls]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T button() {
		return start("button", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;caption&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T caption() {
		return start("caption", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;center&gt; tag.
	 * [center content]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T center() {
		return start("center", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;cite&gt; tag.
	 * [citation]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T cite() {
		return start("cite", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;code&gt; tag.
	 * [program code]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T code() {
		return start("code", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;col&gt; tag.
	 * [col elements define the alignment properties for cells in,       one or more columns., ,       The width attribute specifies the width of the columns, e.g., ,           width=64        width in screen pixels,           width=0.5*      relative width of 0.5, ,       The span attribute causes the attributes of one,       col element to apply to more than one column.]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T col() {
		return start("col", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;colgroup&gt; tag.
	 * [colgroup groups a set of col elements. It allows you to group,       several semantically related columns together.]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T colgroup() {
		return start("colgroup", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;dd&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T dd() {
		return start("dd", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;del&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T del() {
		return start("del", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;dfn&gt; tag.
	 * [definitional]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T dfn() {
		return start("dfn", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;dir&gt; tag.
	 * [multiple column list (DEPRECATED)]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T dir() {
		return start("dir", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;div&gt; tag.
	 * [generic language/style container]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T div() {
		return start("div", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;dl&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T dl() {
		return start("dl", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;dt&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T dt() {
		return start("dt", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;em&gt; tag.
	 * [emphasis]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T em() {
		return start("em", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;fieldset&gt; tag.
	 * [The fieldset element is used to group form fields.,       Only one legend element should occur in the content,       and if present should only be preceded by whitespace., ,       NOTE: this content model is different from the XHTML 1.0 DTD,,       closer to the intended content model in HTML4 DTD]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T fieldset() {
		return start("fieldset", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;font&gt; tag.
	 * [local change to font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T font() {
		return start("font", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;form&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T form() {
		return start("form", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h1&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h1() {
		return start("h1", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h2&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h2() {
		return start("h2", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h3&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h3() {
		return start("h3", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h4&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h4() {
		return start("h4", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h5&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h5() {
		return start("h5", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;h6&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T h6() {
		return start("h6", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;head&gt; tag.
	 * [content model is "head.misc" combined with a single,       title and an optional base element in any order]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T head() {
		return start("head", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;hr&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T hr() {
		return start("hr", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;html&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T html() {
		return start("html", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;i&gt; tag.
	 * [italic font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T i() {
		return start("i", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;iframe&gt; tag.
	 * [inline subwindow]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T iframe() {
		return start("iframe", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;img&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T img() {
		return start("img", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;input&gt; tag.
	 * [form control]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T input() {
		return start("input", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;ins&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T ins() {
		return start("ins", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;isindex&gt; tag.
	 * [single-line text input control (DEPRECATED)]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T isindex() {
		return start("isindex", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;kbd&gt; tag.
	 * [something user would type]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T kbd() {
		return start("kbd", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;label&gt; tag.
	 * [Each label must not contain more than ONE field,       Label elements shouldn't be nested.]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T label() {
		return start("label", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;legend&gt; tag.
	 * [fieldset label]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T legend() {
		return start("legend", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;li&gt; tag.
	 * [list item]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T li() {
		return start("li", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;link&gt; tag.
	 * [Relationship values can be used in principle:, ,       a) for document specific toolbars/menus when used,          with the link element in document head e.g.,            start, contents, previous, next, index, end, help,       b) to link to a separate style sheet (rel="stylesheet"),       c) to make a link to a script (rel="script"),       d) by stylesheets to control how collections of,          html nodes are rendered into printed documents,       e) to make a link to a printable version of this document,          e.g. a PostScript or PDF version (rel="alternate" media="print")]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T link() {
		return start("link", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;map&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T map() {
		return start("map", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;menu&gt; tag.
	 * [single column list (DEPRECATED)]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T menu() {
		return start("menu", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;meta&gt; tag.
	 * [generic metainformation]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T meta() {
		return start("meta", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;noframes&gt; tag.
	 * [alternate content container for non frame-based rendering]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T noframes() {
		return start("noframes", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;noscript&gt; tag.
	 * [alternate content container for non script-based rendering]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T noscript() {
		return start("noscript", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;object&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T object() {
		return start("object", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;ol&gt; tag.
	 * [Ordered (numbered) list]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T ol() {
		return start("ol", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;optgroup&gt; tag.
	 * [option group]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T optgroup() {
		return start("optgroup", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;option&gt; tag.
	 * [selectable choice]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T option() {
		return start("option", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;p&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T p() {
		return start("p", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;param&gt; tag.
	 * [param is used to supply a named property value.,       In XML it would seem natural to follow RDF and support an,       abbreviated syntax where the param elements are replaced,       by attribute value pairs on the object start tag.]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code> 
	 */
	public T param() {
		return start("param", TagClosingPolicy.SELF);
	}

	/**
	 * Starts the &lt;pre&gt; tag.
	 * [content is "Inline" excluding ,          "img|object|applet|big|small|sub|sup|font|basefont"]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T pre() {
		return start("pre", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;q&gt; tag.
	 * [inlined quote]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T q() {
		return start("q", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;s&gt; tag.
	 * [strike-through]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T s() {
		return start("s", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;samp&gt; tag.
	 * [sample]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T samp() {
		return start("samp", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;script&gt; tag.
	 * [script statements, which may include CDATA sections]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T script() {
		return start("script", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;select&gt; tag.
	 * [option selector]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T select() {
		return start("select", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;small&gt; tag.
	 * [smaller font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T small() {
		return start("small", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;span&gt; tag.
	 * [generic language/style container]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T span() {
		return start("span", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;strike&gt; tag.
	 * [strike-through]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T strike() {
		return start("strike", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;strong&gt; tag.
	 * [strong emphasis]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T strong() {
		return start("strong", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;style&gt; tag.
	 * [style info, which may include CDATA sections]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T style() {
		return start("style", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;sub&gt; tag.
	 * [subscript]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T sub() {
		return start("sub", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;sup&gt; tag.
	 * [superscript]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T sup() {
		return start("sup", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;table&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T table() {
		return start("table", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;tbody&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T tbody() {
		return start("tbody", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;td&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T td() {
		return start("td", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;textarea&gt; tag.
	 * [multi-line text field]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T textarea() {
		return start("textarea", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;tfoot&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T tfoot() {
		return start("tfoot", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;th&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T th() {
		return start("th", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;thead&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T thead() {
		return start("thead", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;title&gt; tag.
	 * [The title element is not considered part of the flow of text.,       It should be displayed, for example as the page header or,       window title. Exactly one title is required per document.]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T title() {
		return start("title", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;tr&gt; tag.
	 * []
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T tr() {
		return start("tr", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;tt&gt; tag.
	 * [fixed pitch font]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T tt() {
		return start("tt", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;u&gt; tag.
	 * [underline]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T u() {
		return start("u", TagClosingPolicy.NORMAL);
	}

	/**
	 * Starts the &lt;ul&gt; tag.
	 * [Unordered list]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code> 
	 */
	public T ul() {
		return start("ul", TagClosingPolicy.PAIR);
	}

	/**
	 * Starts the &lt;var&gt; tag.
	 * [variable]
	 * <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code> 
	 */
	public T var() {
		return start("var", TagClosingPolicy.NORMAL);
	}

	/**
	 * Sets the <code>abbr</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T abbr(String value) {
		return attr("abbr", value);
	}

	/**
	 * Sets the <code>accept</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T accept(String value) {
		return attr("accept", value);
	}

	/**
	 * Sets the <code>accept-charset</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T acceptCharset(String value) {
		return attr("accept-charset", value);
	}

	/**
	 * Sets the <code>accesskey</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T accesskey(String value) {
		return attr("accesskey", value);
	}

	/**
	 * Sets the <code>action</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T action(String value) {
		return attr("action", value);
	}

	/**
	 * Sets the <code>align</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T align(String value) {
		return attr("align", value);
	}

	/**
	 * Sets the <code>alink</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T alink(String value) {
		return attr("alink", value);
	}

	/**
	 * Sets the <code>alt</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T alt(String value) {
		return attr("alt", value);
	}

	/**
	 * Sets the <code>archive</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T archive(String value) {
		return attr("archive", value);
	}

	/**
	 * Sets the <code>axis</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T axis(String value) {
		return attr("axis", value);
	}

	/**
	 * Sets the <code>background</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T background(String value) {
		return attr("background", value);
	}

	/**
	 * Sets the <code>bgcolor</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T bgcolor(String value) {
		return attr("bgcolor", value);
	}

	/**
	 * Sets the <code>border</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T border(String value) {
		return attr("border", value);
	}

	/**
	 * Sets the <code>cellpadding</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T cellpadding(String value) {
		return attr("cellpadding", value);
	}

	/**
	 * Sets the <code>cellspacing</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T cellspacing(String value) {
		return attr("cellspacing", value);
	}

	/**
	 * Sets the <code>char</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T charAttr(String value) {
		return attr("char", value);
	}

	/**
	 * Sets the <code>charoff</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T charoff(String value) {
		return attr("charoff", value);
	}

	/**
	 * Sets the <code>charset</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T charset(String value) {
		return attr("charset", value);
	}

	/**
	 * Sets the <code>checked</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T checked(String value) {
		return attr("checked", value);
	}

	/**
	 * Sets the <code>cite</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T cite(String value) {
		return attr("cite", value);
	}

	/**
	 * Sets the <code>class</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T classAttr(String value) {
		return attr("class", value);
	}

	/**
	 * Sets the <code>classid</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T classid(String value) {
		return attr("classid", value);
	}

	/**
	 * Sets the <code>clear</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T clear(String value) {
		return attr("clear", value);
	}

	/**
	 * Sets the <code>code</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T code(String value) {
		return attr("code", value);
	}

	/**
	 * Sets the <code>codebase</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T codebase(String value) {
		return attr("codebase", value);
	}

	/**
	 * Sets the <code>codetype</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T codetype(String value) {
		return attr("codetype", value);
	}

	/**
	 * Sets the <code>color</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T color(String value) {
		return attr("color", value);
	}

	/**
	 * Sets the <code>cols</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T cols(String value) {
		return attr("cols", value);
	}

	/**
	 * Sets the <code>colspan</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T colspan(String value) {
		return attr("colspan", value);
	}

	/**
	 * Sets the <code>compact</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T compact(String value) {
		return attr("compact", value);
	}

	/**
	 * Sets the <code>content</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T content(String value) {
		return attr("content", value);
	}

	/**
	 * Sets the <code>coords</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T coords(String value) {
		return attr("coords", value);
	}

	/**
	 * Sets the <code>data</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T data(String value) {
		return attr("data", value);
	}

	/**
	 * Sets the <code>datetime</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T datetime(String value) {
		return attr("datetime", value);
	}

	/**
	 * Sets the <code>declare</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T declare(String value) {
		return attr("declare", value);
	}

	/**
	 * Sets the <code>defer</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T defer(String value) {
		return attr("defer", value);
	}

	/**
	 * Sets the <code>dir</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T dir(String value) {
		return attr("dir", value);
	}

	/**
	 * Sets the <code>disabled</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T disabled(String value) {
		return attr("disabled", value);
	}

	/**
	 * Sets the <code>enctype</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T enctype(String value) {
		return attr("enctype", value);
	}

	/**
	 * Sets the <code>face</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T face(String value) {
		return attr("face", value);
	}

	/**
	 * Sets the <code>for</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T forAttr(String value) {
		return attr("for", value);
	}

	/**
	 * Sets the <code>frame</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T frame(String value) {
		return attr("frame", value);
	}

	/**
	 * Sets the <code>frameborder</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T frameborder(String value) {
		return attr("frameborder", value);
	}

	/**
	 * Sets the <code>headers</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T headers(String value) {
		return attr("headers", value);
	}

	/**
	 * Sets the <code>height</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T height(String value) {
		return attr("height", value);
	}

	/**
	 * Sets the <code>href</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T href(String value) {
		return attr("href", value);
	}

	/**
	 * Sets the <code>hreflang</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T hreflang(String value) {
		return attr("hreflang", value);
	}

	/**
	 * Sets the <code>hspace</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T hspace(String value) {
		return attr("hspace", value);
	}

	/**
	 * Sets the <code>http-equiv</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T httpEquiv(String value) {
		return attr("http-equiv", value);
	}

	/**
	 * Sets the <code>id</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T id(String value) {
		return attr("id", value);
	}

	/**
	 * Sets the <code>ismap</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T ismap(String value) {
		return attr("ismap", value);
	}

	/**
	 * Sets the <code>label</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T label(String value) {
		return attr("label", value);
	}

	/**
	 * Sets the <code>lang</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T lang(String value) {
		return attr("lang", value);
	}

	/**
	 * Sets the <code>language</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T language(String value) {
		return attr("language", value);
	}

	/**
	 * Sets the <code>link</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T link(String value) {
		return attr("link", value);
	}

	/**
	 * Sets the <code>longdesc</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T longdesc(String value) {
		return attr("longdesc", value);
	}

	/**
	 * Sets the <code>marginheight</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T marginheight(String value) {
		return attr("marginheight", value);
	}

	/**
	 * Sets the <code>marginwidth</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T marginwidth(String value) {
		return attr("marginwidth", value);
	}

	/**
	 * Sets the <code>maxlength</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T maxlength(String value) {
		return attr("maxlength", value);
	}

	/**
	 * Sets the <code>media</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T media(String value) {
		return attr("media", value);
	}

	/**
	 * Sets the <code>method</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T method(String value) {
		return attr("method", value);
	}

	/**
	 * Sets the <code>multiple</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T multiple(String value) {
		return attr("multiple", value);
	}

	/**
	 * Sets the <code>name</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T name(String value) {
		return attr("name", value);
	}

	/**
	 * Sets the <code>nohref</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T nohref(String value) {
		return attr("nohref", value);
	}

	/**
	 * Sets the <code>noshade</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T noshade(String value) {
		return attr("noshade", value);
	}

	/**
	 * Sets the <code>nowrap</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T nowrap(String value) {
		return attr("nowrap", value);
	}

	/**
	 * Sets the <code>object</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T object(String value) {
		return attr("object", value);
	}

	/**
	 * Sets the <code>onblur</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onblur(String value) {
		return attr("onblur", value);
	}

	/**
	 * Sets the <code>onchange</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onchange(String value) {
		return attr("onchange", value);
	}

	/**
	 * Sets the <code>onclick</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onclick(String value) {
		return attr("onclick", value);
	}

	/**
	 * Sets the <code>ondblclick</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T ondblclick(String value) {
		return attr("ondblclick", value);
	}

	/**
	 * Sets the <code>onfocus</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onfocus(String value) {
		return attr("onfocus", value);
	}

	/**
	 * Sets the <code>onkeydown</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onkeydown(String value) {
		return attr("onkeydown", value);
	}

	/**
	 * Sets the <code>onkeypress</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onkeypress(String value) {
		return attr("onkeypress", value);
	}

	/**
	 * Sets the <code>onkeyup</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onkeyup(String value) {
		return attr("onkeyup", value);
	}

	/**
	 * Sets the <code>onload</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onload(String value) {
		return attr("onload", value);
	}

	/**
	 * Sets the <code>onmousedown</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onmousedown(String value) {
		return attr("onmousedown", value);
	}

	/**
	 * Sets the <code>onmousemove</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onmousemove(String value) {
		return attr("onmousemove", value);
	}

	/**
	 * Sets the <code>onmouseout</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onmouseout(String value) {
		return attr("onmouseout", value);
	}

	/**
	 * Sets the <code>onmouseover</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onmouseover(String value) {
		return attr("onmouseover", value);
	}

	/**
	 * Sets the <code>onmouseup</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onmouseup(String value) {
		return attr("onmouseup", value);
	}

	/**
	 * Sets the <code>onreset</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onreset(String value) {
		return attr("onreset", value);
	}

	/**
	 * Sets the <code>onselect</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onselect(String value) {
		return attr("onselect", value);
	}

	/**
	 * Sets the <code>onsubmit</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onsubmit(String value) {
		return attr("onsubmit", value);
	}

	/**
	 * Sets the <code>onunload</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T onunload(String value) {
		return attr("onunload", value);
	}

	/**
	 * Sets the <code>profile</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T profile(String value) {
		return attr("profile", value);
	}

	/**
	 * Sets the <code>prompt</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T prompt(String value) {
		return attr("prompt", value);
	}

	/**
	 * Sets the <code>readonly</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T readonly(String value) {
		return attr("readonly", value);
	}

	/**
	 * Sets the <code>rel</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T rel(String value) {
		return attr("rel", value);
	}

	/**
	 * Sets the <code>rev</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T rev(String value) {
		return attr("rev", value);
	}

	/**
	 * Sets the <code>rows</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T rows(String value) {
		return attr("rows", value);
	}

	/**
	 * Sets the <code>rowspan</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T rowspan(String value) {
		return attr("rowspan", value);
	}

	/**
	 * Sets the <code>rules</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T rules(String value) {
		return attr("rules", value);
	}

	/**
	 * Sets the <code>scheme</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T scheme(String value) {
		return attr("scheme", value);
	}

	/**
	 * Sets the <code>scope</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T scope(String value) {
		return attr("scope", value);
	}

	/**
	 * Sets the <code>scrolling</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T scrolling(String value) {
		return attr("scrolling", value);
	}

	/**
	 * Sets the <code>selected</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T selected(String value) {
		return attr("selected", value);
	}

	/**
	 * Sets the <code>shape</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T shape(String value) {
		return attr("shape", value);
	}

	/**
	 * Sets the <code>size</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T size(String value) {
		return attr("size", value);
	}

	/**
	 * Sets the <code>span</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T span(String value) {
		return attr("span", value);
	}

	/**
	 * Sets the <code>src</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T src(String value) {
		return attr("src", value);
	}

	/**
	 * Sets the <code>standby</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T standby(String value) {
		return attr("standby", value);
	}

	/**
	 * Sets the <code>start</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T startAttr(String value) {
		return attr("start", value);
	}

	/**
	 * Sets the <code>style</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T style(String value) {
		return attr("style", value);
	}

	/**
	 * Sets the <code>summary</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T summary(String value) {
		return attr("summary", value);
	}

	/**
	 * Sets the <code>tabindex</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T tabindex(String value) {
		return attr("tabindex", value);
	}

	/**
	 * Sets the <code>target</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T target(String value) {
		return attr("target", value);
	}

	/**
	 * Sets the <code>text</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T textAttr(String value) {
		return attr("text", value);
	}

	/**
	 * Sets the <code>title</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T title(String value) {
		return attr("title", value);
	}

	/**
	 * Sets the <code>type</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T type(String value) {
		return attr("type", value);
	}

	/**
	 * Sets the <code>usemap</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T usemap(String value) {
		return attr("usemap", value);
	}

	/**
	 * Sets the <code>valign</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T valign(String value) {
		return attr("valign", value);
	}

	/**
	 * Sets the <code>value</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T value(String value) {
		return attr("value", value);
	}

	/**
	 * Sets the <code>valuetype</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T valuetype(String value) {
		return attr("valuetype", value);
	}

	/**
	 * Sets the <code>vlink</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T vlink(String value) {
		return attr("vlink", value);
	}

	/**
	 * Sets the <code>vspace</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T vspace(String value) {
		return attr("vspace", value);
	}

	/**
	 * Sets the <code>width</code> attribute on the last started tag that 
	 * has not been closed.
	 *
	 * @param value the value to set, maybe <code>null</code>
	 * @return this, never <code>null</code>
	 */
	public T width(String value) {
		return attr("width", value);
	}

}