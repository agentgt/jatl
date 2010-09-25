package com.googlecode.jatl;

import java.io.Writer;

import org.apache.commons.lang.StringEscapeUtils;

public abstract class HtmlBuilder<T> extends MarkupBuilder<T> {


	public HtmlBuilder(Writer writer) {
		super(writer);
	}
	
	public T html() {
		return start("html", TagClosingPolicy.PAIR); 
	}
	
	public T body() {
		return start("body", TagClosingPolicy.PAIR); 
	}
	
	public T h1() {
		return start("h1", TagClosingPolicy.PAIR);
	}
	
	public T h2() {
		return start("h2", TagClosingPolicy.PAIR);
	}
	
	public T h3() {
		return start("h3", TagClosingPolicy.PAIR);
	}
	
	public T p() {
		return start("p", TagClosingPolicy.PAIR);
	}
	
	public T ul() {
		return start("ul", TagClosingPolicy.PAIR); 
	}
	
	public T ol() {
		return start("ol", TagClosingPolicy.PAIR); 
	}
	
	public T li() {
		return start("li", TagClosingPolicy.NORMAL); 
	}
	
	public T div() {
		return start("div", TagClosingPolicy.PAIR);
	}
	
	public T br() {
		start("br", TagClosingPolicy.SELF);
		return end();
	}
	
	public T span() {
		return start("span", TagClosingPolicy.PAIR);
	}
	
	public T form() {
		return start("form");
	}
	public T input() {
		return start("input", TagClosingPolicy.SELF);
	}
	public T value(String value) {
		return attr("value", value);
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
	
	public T select() {
		return start("select");
	}
	
	public T option() {
		return start("option");
	}
	
	public T script() {
		return start("script");
	}
	
	public T option(String name, String value, boolean selected) {
		start("option", TagClosingPolicy.PAIR);
		attr("value", value);
		if (selected)
			attr("selected", "selected");
		text(name);
		end();
		return getSelf();
	}
	
	public T clazz (String clazz) {
		return attr("class", clazz);
	}
	
	public T style(String style) {
		return attr("style", style);
	}
	
	public T title(String title) {
		return attr("title", title);
	}
	
	public T title() {
	    return start("title", TagClosingPolicy.PAIR);
	}
	
	public T id(String id) {
		return attr("id", id);
	}
	public T name(String name) {
		return attr("name", name);
	}

	@Override
	protected String escapeMarkup(String raw) {
		return StringEscapeUtils.escapeHtml(raw);
	}

}
