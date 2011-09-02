package com.googlecode.jatl;

import java.io.IOException;

import com.googlecode.jatl.MarkupBuilder.TagClosingPolicy;


public interface Indenter {
	
	public void indentTag(
			Appendable a,
			int innerDepth, 
			int outerDepth, 
			TagIndentSpot spot, 
			String tag, TagClosingPolicy p, boolean empty) throws IOException;
	
	public static enum TagIndentSpot {
		BEFORE_START_TAG,
		AFTER_START_TAG,
		BEFORE_END_TAG,
		AFTER_END_TAG
	}
}
