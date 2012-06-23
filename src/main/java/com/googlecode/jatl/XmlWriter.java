package com.googlecode.jatl;


public abstract class XmlWriter extends XmlBuilderWriter<XmlWriter> {

	@Override
	protected XmlWriter getSelf() {
		return this;
	}

}
