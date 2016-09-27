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
