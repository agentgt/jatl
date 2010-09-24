package com.googlecode.jatl;

import static org.apache.commons.lang.Validate.isTrue;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public abstract class MarkupBuilder<T> {
	private Stack<Tag> tagStack = new Stack<Tag>();
	private Writer writer;
	private Map<String, String> attributes = createMap();

	private static final String q = "\"";
	
	
	public MarkupBuilder(Writer writer) {
		super();
		this.writer = writer;
	}
	
	protected abstract T getSelf();
	
	protected final Map<String, String> getAttributes() {
		return attributes;
	}

	public T text(String text) {
		if (text != null) {
			writeCurrentTag();
			write(escapeMarkup(text));
		}
		return getSelf();
	}
	
	public T raw(String text) {
		if (text != null) {
			writeCurrentTag();
			write(text);
		}
		return getSelf();
	}
	
	public T start(String tag) {
		return start(tag, TagClosingPolicy.NORMAL);
	}
	
	public T start(String tag, TagClosingPolicy policy) {
		writeCurrentTag();
		Tag t = new Tag(tag);
		t.closePolicy = policy;
		t.depth = tagStack.size();
		tagStack.push(t);
		return getSelf();
	}
	
	public T attr(String ... attrs ) {
		isTrue(attrs.length  % 2 == 0);
		for (int n = 0, v = 1; v < attrs.length; n+=2, v+=2) {
			getAttributes().put(attrs[n], attrs[v]);
		}
		return getSelf();
	}
	
	public T end(int i) {
		while ( i-- > 0 && ! tagStack.isEmpty() ) {
			end();
		}
		return getSelf();
	}
	
	public T end() {
		Tag t = tagStack.peek();
		writeStartTag(t);
		writeEndTag(t);
		tagStack.pop();
		attributes.clear();
		return getSelf();
	}
	
	public T endAll() {
		while( ! tagStack.isEmpty() ) {
			end();
		}
		return getSelf();
	}
	
	private void writeCurrentTag() {
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
			write(indent(t.depth, t.name));
			writeTag(t.name, t.isSelfClosing());
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
			int indent = t.depth;
			write(indent(indent, t.name));
			write("</" + t.name + ">");
			t.end = true;
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
			write(name + "=" + q(value));
		}		
	}
	private String q(String raw) {
		return q + escapeMarkup(raw) + q;
	}
	private void write(String raw) {
		try {
			writer.write(raw);
		} catch (IOException e) {
			throw new RuntimeException("Writer for HTML failed:", e);
		}
	}
	protected Map<String, String> createMap() {
		return new LinkedHashMap<String, String>();
	}
	
	protected abstract String escapeMarkup(String raw);
	
	protected abstract String indent(int depth, String tag);
	
	private static class Tag {
		
		public Tag(String name) {
			super();
			this.name = name;
		}
		public int depth = 0;
		public String name;
		public boolean empty = true;
		public boolean start = false;
		public boolean end = false;
		
		public TagClosingPolicy closePolicy = TagClosingPolicy.NORMAL;
		
		@Override
		public String toString() {
			return "Tag [depth=" + depth + ", name=" + name + ", empty="
					+ empty + ", closed=" + end + ", closePolicy="
					+ closePolicy + "]";
		}
		
		public boolean isSelfClosing() {
			return empty && closePolicy.isSelfClosing();
		}
		
	}
	
	public enum TagClosingPolicy {
		NORMAL,
		SELF,
		PAIR;
		
		public boolean isAlwaysSelfClosing() {
			return this == SELF;
		}
		
		public boolean isSelfClosing() {
			return this == SELF || this == NORMAL;
		}
		
		public boolean isPairClosing() {
			return this == PAIR || this == NORMAL;
		}
	}

}
