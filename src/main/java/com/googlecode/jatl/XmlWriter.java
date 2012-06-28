package com.googlecode.jatl;

/**
 * For generic XML creation. If you want to generate HTML you might prefer {@link HtmlWriter}.
 * The {@link #toString()} on this class will do what you expect: generate the XML as a string.
 * @author agent
 *
 */
public abstract class XmlWriter extends XmlBuilderWriter<XmlWriter> {

	@Override
	protected XmlWriter getSelf() {
		return this;
	}

}
