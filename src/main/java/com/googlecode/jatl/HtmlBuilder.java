/**
 * Copyright (C) 2010 the original author or authors.
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

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Most of the XHTML tags and attributes are available as methods.
 * A rule of thumb is that most tags are zero parameter methods and attribute
 * methods are single parameter.
 * 
 * @author adamgent
 *
 * @param <T> See {@link MarkupBuilder} for how this should be parameterized.
 */
public abstract class HtmlBuilder<T> extends MarkupBuilder<T> {

	public HtmlBuilder(Writer writer) {
		super(writer);
	}
	
	public HtmlBuilder(MarkupBuilder<?> builder) {
		super(builder);
	}

	public HtmlBuilder(MarkupBuilder<?> builder, boolean nested) {
		super(builder, nested);
	}
	
	protected HtmlBuilder() {
		super();
	}

	

	public T checkbox() {
		return checkbox(false);
	}
	
	public T checkbox(boolean checked) {
		input();
		attr("type", "checkbox");
		if (checked)
			attr("checked", "checked");
		return getSelf();
	}
	
	
	public T option(String name, String value, boolean selected) {
		option();
		value(value);
		if (selected)
			selected("selected");
		text(name);
		end();
		return getSelf();
	}


	
	//Auto generated below

	/**
	 * content is "Inline" except that anchors shouldn't be nested <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T a() {
		return start("a", TagClosingPolicy.NORMAL);
	}

	/**
	 * abbreviation <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T abbr() {
		return start("abbr", TagClosingPolicy.NORMAL);
	}

	/**
	 * acronym <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T acronym() {
		return start("acronym", TagClosingPolicy.NORMAL);
	}

	/**
	 * information on author <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T address() {
		return start("address", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T applet() {
		return start("applet", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T area() {
		return start("area", TagClosingPolicy.SELF);
	}

	/**
	 * bold font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T b() {
		return start("b", TagClosingPolicy.NORMAL);
	}

	/**
	 * document base URI <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T base() {
		return start("base", TagClosingPolicy.SELF);
	}

	/**
	 * base font size <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T basefont() {
		return start("basefont", TagClosingPolicy.SELF);
	}

	/**
	 * I18N BiDi over-ride <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T bdo() {
		return start("bdo", TagClosingPolicy.NORMAL);
	}

	/**
	 * bigger font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T big() {
		return start("big", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T blockquote() {
		return start("blockquote", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T body() {
		return start("body", TagClosingPolicy.NORMAL);
	}

	/**
	 * forced line break <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T br() {
		return start("br", TagClosingPolicy.SELF);
	}

	/**
	 * Content is "Flow" excluding a, form and form controls <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T button() {
		return start("button", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T caption() {
		return start("caption", TagClosingPolicy.NORMAL);
	}

	/**
	 * center content <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T center() {
		return start("center", TagClosingPolicy.NORMAL);
	}

	/**
	 * citation <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T cite() {
		return start("cite", TagClosingPolicy.NORMAL);
	}

	/**
	 * program code <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T code() {
		return start("code", TagClosingPolicy.NORMAL);
	}

	/**
	 * col elements define the alignment properties for cells in
	 *       one or more columns.
	 * 
	 *       The width attribute specifies the width of the columns, e.g.
	 * 
	 *           width=64        width in screen pixels
	 *           width=0.5*      relative width of 0.5
	 * 
	 *       The span attribute causes the attributes of one
	 *       col element to apply to more than one column. <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T col() {
		return start("col", TagClosingPolicy.SELF);
	}

	/**
	 * colgroup groups a set of col elements. It allows you to group
	 *       several semantically related columns together. <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T colgroup() {
		return start("colgroup", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T dd() {
		return start("dd", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T del() {
		return start("del", TagClosingPolicy.NORMAL);
	}

	/**
	 * definitional <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T dfn() {
		return start("dfn", TagClosingPolicy.NORMAL);
	}

	/**
	 * multiple column list (DEPRECATED) <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T dir() {
		return start("dir", TagClosingPolicy.PAIR);
	}

	/**
	 * generic language/style container <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T div() {
		return start("div", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T dl() {
		return start("dl", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T dt() {
		return start("dt", TagClosingPolicy.NORMAL);
	}

	/**
	 * emphasis <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T em() {
		return start("em", TagClosingPolicy.NORMAL);
	}

	/**
	 * The fieldset element is used to group form fields.
	 *       Only one legend element should occur in the content
	 *       and if present should only be preceded by whitespace.
	 * 
	 *       NOTE: this content model is different from the XHTML 1.0 DTD,
	 *       closer to the intended content model in HTML4 DTD <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T fieldset() {
		return start("fieldset", TagClosingPolicy.PAIR);
	}

	/**
	 * local change to font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T font() {
		return start("font", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T form() {
		return start("form", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h1() {
		return start("h1", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h2() {
		return start("h2", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h3() {
		return start("h3", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h4() {
		return start("h4", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h5() {
		return start("h5", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T h6() {
		return start("h6", TagClosingPolicy.NORMAL);
	}

	/**
	 * content model is "head.misc" combined with a single
	 *       title and an optional base element in any order <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T head() {
		return start("head", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T hr() {
		return start("hr", TagClosingPolicy.SELF);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T html() {
		return start("html", TagClosingPolicy.PAIR);
	}

	/**
	 * italic font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T i() {
		return start("i", TagClosingPolicy.NORMAL);
	}

	/**
	 * inline subwindow <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T iframe() {
		return start("iframe", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T img() {
		return start("img", TagClosingPolicy.SELF);
	}

	/**
	 * form control <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T input() {
		return start("input", TagClosingPolicy.SELF);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T ins() {
		return start("ins", TagClosingPolicy.NORMAL);
	}

	/**
	 * single-line text input control (DEPRECATED) <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T isindex() {
		return start("isindex", TagClosingPolicy.SELF);
	}

	/**
	 * something user would type <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T kbd() {
		return start("kbd", TagClosingPolicy.NORMAL);
	}

	/**
	 * Each label must not contain more than ONE field
	 *       Label elements shouldn't be nested. <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T label() {
		return start("label", TagClosingPolicy.NORMAL);
	}

	/**
	 * fieldset label <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T legend() {
		return start("legend", TagClosingPolicy.NORMAL);
	}

	/**
	 * list item <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T li() {
		return start("li", TagClosingPolicy.NORMAL);
	}

	/**
	 * Relationship values can be used in principle:
	 * 
	 *       a) for document specific toolbars/menus when used
	 *          with the link element in document head e.g.
	 *            start, contents, previous, next, index, end, help
	 *       b) to link to a separate style sheet (rel="stylesheet")
	 *       c) to make a link to a script (rel="script")
	 *       d) by stylesheets to control how collections of
	 *          html nodes are rendered into printed documents
	 *       e) to make a link to a printable version of this document
	 *          e.g. a PostScript or PDF version (rel="alternate" media="print") <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T link() {
		return start("link", TagClosingPolicy.SELF);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T map() {
		return start("map", TagClosingPolicy.PAIR);
	}

	/**
	 * single column list (DEPRECATED) <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T menu() {
		return start("menu", TagClosingPolicy.PAIR);
	}

	/**
	 * generic metainformation <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T meta() {
		return start("meta", TagClosingPolicy.SELF);
	}

	/**
	 * alternate content container for non frame-based rendering <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T noframes() {
		return start("noframes", TagClosingPolicy.NORMAL);
	}

	/**
	 * alternate content container for non script-based rendering <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T noscript() {
		return start("noscript", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T object() {
		return start("object", TagClosingPolicy.PAIR);
	}

	/**
	 * Ordered (numbered) list <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T ol() {
		return start("ol", TagClosingPolicy.PAIR);
	}

	/**
	 * option group <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T optgroup() {
		return start("optgroup", TagClosingPolicy.PAIR);
	}

	/**
	 * selectable choice <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T option() {
		return start("option", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T p() {
		return start("p", TagClosingPolicy.NORMAL);
	}

	/**
	 * param is used to supply a named property value.
	 *       In XML it would seem natural to follow RDF and support an
	 *       abbreviated syntax where the param elements are replaced
	 *       by attribute value pairs on the object start tag. <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#SELF}
	 * @return this, never <code>null</code>  
	 */
	public T param() {
		return start("param", TagClosingPolicy.SELF);
	}

	/**
	 * content is "Inline" excluding 
	 *          "img|object|applet|big|small|sub|sup|font|basefont" <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T pre() {
		return start("pre", TagClosingPolicy.NORMAL);
	}

	/**
	 * inlined quote <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T q() {
		return start("q", TagClosingPolicy.NORMAL);
	}

	/**
	 * strike-through <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T s() {
		return start("s", TagClosingPolicy.NORMAL);
	}

	/**
	 * sample <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T samp() {
		return start("samp", TagClosingPolicy.NORMAL);
	}

	/**
	 * script statements, which may include CDATA sections <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T script() {
		return start("script", TagClosingPolicy.PAIR);
	}

	/**
	 * option selector <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T select() {
		return start("select", TagClosingPolicy.PAIR);
	}

	/**
	 * smaller font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T small() {
		return start("small", TagClosingPolicy.NORMAL);
	}

	/**
	 * generic language/style container <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T span() {
		return start("span", TagClosingPolicy.NORMAL);
	}

	/**
	 * strike-through <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T strike() {
		return start("strike", TagClosingPolicy.NORMAL);
	}

	/**
	 * strong emphasis <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T strong() {
		return start("strong", TagClosingPolicy.NORMAL);
	}

	/**
	 * style info, which may include CDATA sections <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T style() {
		return start("style", TagClosingPolicy.NORMAL);
	}

	/**
	 * subscript <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T sub() {
		return start("sub", TagClosingPolicy.NORMAL);
	}

	/**
	 * superscript <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T sup() {
		return start("sup", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T table() {
		return start("table", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T tbody() {
		return start("tbody", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T td() {
		return start("td", TagClosingPolicy.NORMAL);
	}

	/**
	 * multi-line text field <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T textarea() {
		return start("textarea", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T tfoot() {
		return start("tfoot", TagClosingPolicy.PAIR);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T th() {
		return start("th", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T thead() {
		return start("thead", TagClosingPolicy.PAIR);
	}

	/**
	 * The title element is not considered part of the flow of text.
	 *       It should be displayed, for example as the page header or
	 *       window title. Exactly one title is required per document. <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T title() {
		return start("title", TagClosingPolicy.NORMAL);
	}

	/**
	 *  <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T tr() {
		return start("tr", TagClosingPolicy.PAIR);
	}

	/**
	 * fixed pitch font <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T tt() {
		return start("tt", TagClosingPolicy.NORMAL);
	}

	/**
	 * underline <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T u() {
		return start("u", TagClosingPolicy.NORMAL);
	}

	/**
	 * Unordered list <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#PAIR}
	 * @return this, never <code>null</code>  
	 */
	public T ul() {
		return start("ul", TagClosingPolicy.PAIR);
	}

	/**
	 * variable <p>
	 * Tag Closing Policy: {@link MarkupBuilder.TagClosingPolicy#NORMAL}
	 * @return this, never <code>null</code>  
	 */
	public T var() {
		return start("var", TagClosingPolicy.NORMAL);
	}

	public T abbr(String value) {
		return attr("abbr", value);
	}

	public T accept(String value) {
		return attr("accept", value);
	}

	public T acceptCharset(String value) {
		return attr("accept-charset", value);
	}

	public T accesskey(String value) {
		return attr("accesskey", value);
	}

	public T action(String value) {
		return attr("action", value);
	}

	public T align(String value) {
		return attr("align", value);
	}

	public T alink(String value) {
		return attr("alink", value);
	}

	public T alt(String value) {
		return attr("alt", value);
	}

	public T archive(String value) {
		return attr("archive", value);
	}

	public T axis(String value) {
		return attr("axis", value);
	}

	public T background(String value) {
		return attr("background", value);
	}

	public T bgcolor(String value) {
		return attr("bgcolor", value);
	}

	public T border(String value) {
		return attr("border", value);
	}

	public T cellpadding(String value) {
		return attr("cellpadding", value);
	}

	public T cellspacing(String value) {
		return attr("cellspacing", value);
	}

	public T character(String value) {
		return attr("char", value);
	}

	public T charoff(String value) {
		return attr("charoff", value);
	}

	public T charset(String value) {
		return attr("charset", value);
	}

	public T checked(String value) {
		return attr("checked", value);
	}

	public T cite(String value) {
		return attr("cite", value);
	}

	public T clazz(String value) {
		return attr("clazz", value);
	}

	public T classid(String value) {
		return attr("classid", value);
	}

	public T clear(String value) {
		return attr("clear", value);
	}

	public T code(String value) {
		return attr("code", value);
	}

	public T codebase(String value) {
		return attr("codebase", value);
	}

	public T codetype(String value) {
		return attr("codetype", value);
	}

	public T color(String value) {
		return attr("color", value);
	}

	public T cols(String value) {
		return attr("cols", value);
	}

	public T colspan(String value) {
		return attr("colspan", value);
	}

	public T compact(String value) {
		return attr("compact", value);
	}

	public T content(String value) {
		return attr("content", value);
	}

	public T coords(String value) {
		return attr("coords", value);
	}

	public T data(String value) {
		return attr("data", value);
	}

	public T datetime(String value) {
		return attr("datetime", value);
	}

	public T declare(String value) {
		return attr("declare", value);
	}

	public T defer(String value) {
		return attr("defer", value);
	}

	public T dir(String value) {
		return attr("dir", value);
	}

	public T disabled(String value) {
		return attr("disabled", value);
	}

	public T enctype(String value) {
		return attr("enctype", value);
	}

	public T face(String value) {
		return attr("face", value);
	}

	public T forInput(String value) {
		return attr("for", value);
	}

	public T frame(String value) {
		return attr("frame", value);
	}

	public T frameborder(String value) {
		return attr("frameborder", value);
	}

	public T headers(String value) {
		return attr("headers", value);
	}

	public T height(String value) {
		return attr("height", value);
	}

	public T href(String value) {
		return attr("href", value);
	}

	public T hreflang(String value) {
		return attr("hreflang", value);
	}

	public T hspace(String value) {
		return attr("hspace", value);
	}

	public T httpEquiv(String value) {
		return attr("http-equiv", value);
	}

	public T id(String value) {
		return attr("id", value);
	}

	public T ismap(String value) {
		return attr("ismap", value);
	}

	public T label(String value) {
		return attr("label", value);
	}

	public T lang(String value) {
		return attr("lang", value);
	}

	public T language(String value) {
		return attr("language", value);
	}

	public T link(String value) {
		return attr("link", value);
	}

	public T longdesc(String value) {
		return attr("longdesc", value);
	}

	public T marginheight(String value) {
		return attr("marginheight", value);
	}

	public T marginwidth(String value) {
		return attr("marginwidth", value);
	}

	public T maxlength(String value) {
		return attr("maxlength", value);
	}

	public T media(String value) {
		return attr("media", value);
	}

	public T method(String value) {
		return attr("method", value);
	}

	public T multiple(String value) {
		return attr("multiple", value);
	}

	public T name(String value) {
		return attr("name", value);
	}

	public T nohref(String value) {
		return attr("nohref", value);
	}

	public T noshade(String value) {
		return attr("noshade", value);
	}

	public T nowrap(String value) {
		return attr("nowrap", value);
	}

	public T object(String value) {
		return attr("object", value);
	}

	public T onblur(String value) {
		return attr("onblur", value);
	}

	public T onchange(String value) {
		return attr("onchange", value);
	}

	public T onclick(String value) {
		return attr("onclick", value);
	}

	public T ondblclick(String value) {
		return attr("ondblclick", value);
	}

	public T onfocus(String value) {
		return attr("onfocus", value);
	}

	public T onkeydown(String value) {
		return attr("onkeydown", value);
	}

	public T onkeypress(String value) {
		return attr("onkeypress", value);
	}

	public T onkeyup(String value) {
		return attr("onkeyup", value);
	}

	public T onload(String value) {
		return attr("onload", value);
	}

	public T onmousedown(String value) {
		return attr("onmousedown", value);
	}

	public T onmousemove(String value) {
		return attr("onmousemove", value);
	}

	public T onmouseout(String value) {
		return attr("onmouseout", value);
	}

	public T onmouseover(String value) {
		return attr("onmouseover", value);
	}

	public T onmouseup(String value) {
		return attr("onmouseup", value);
	}

	public T onreset(String value) {
		return attr("onreset", value);
	}

	public T onselect(String value) {
		return attr("onselect", value);
	}

	public T onsubmit(String value) {
		return attr("onsubmit", value);
	}

	public T onunload(String value) {
		return attr("onunload", value);
	}

	public T profile(String value) {
		return attr("profile", value);
	}

	public T prompt(String value) {
		return attr("prompt", value);
	}

	public T readonly(String value) {
		return attr("readonly", value);
	}

	public T rel(String value) {
		return attr("rel", value);
	}

	public T rev(String value) {
		return attr("rev", value);
	}

	public T rows(String value) {
		return attr("rows", value);
	}

	public T rowspan(String value) {
		return attr("rowspan", value);
	}

	public T rules(String value) {
		return attr("rules", value);
	}

	public T scheme(String value) {
		return attr("scheme", value);
	}

	public T scope(String value) {
		return attr("scope", value);
	}

	public T scrolling(String value) {
		return attr("scrolling", value);
	}

	public T selected(String value) {
		return attr("selected", value);
	}

	public T shape(String value) {
		return attr("shape", value);
	}

	public T size(String value) {
		return attr("size", value);
	}

	public T span(String value) {
		return attr("span", value);
	}

	public T src(String value) {
		return attr("src", value);
	}

	public T standby(String value) {
		return attr("standby", value);
	}

	public T startAttr(String value) {
		return attr("start", value);
	}

	public T style(String value) {
		return attr("style", value);
	}

	public T summary(String value) {
		return attr("summary", value);
	}

	public T tabindex(String value) {
		return attr("tabindex", value);
	}

	public T target(String value) {
		return attr("target", value);
	}

	public T textAttr(String value) {
		return attr("text", value);
	}

	public T title(String value) {
		return attr("title", value);
	}

	public T type(String value) {
		return attr("type", value);
	}

	public T usemap(String value) {
		return attr("usemap", value);
	}

	public T valign(String value) {
		return attr("valign", value);
	}

	public T value(String value) {
		return attr("value", value);
	}

	public T valuetype(String value) {
		return attr("valuetype", value);
	}

	public T vlink(String value) {
		return attr("vlink", value);
	}

	public T vspace(String value) {
		return attr("vspace", value);
	}

	public T width(String value) {
		return attr("width", value);
	}
	//Auto generated above

	@Override
	protected String escapeMarkup(String raw) {
		return StringEscapeUtils.escapeHtml(raw);
	}

}
