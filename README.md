
# Java Anti-Template Language (JATL)

Is an extremely lightweight efficient Java library that generates XHTML or XML by using an a elegant [fluent styled](http://en.wikipedia.org/wiki/Fluent_interface) micro [DSL](http://en.wikipedia.org/wiki/Domain_specific_language).

I made this while developing my (now defunkt) [social taste recommendation engine](http://evocatus.com) and is heavily used in my [mobile recruiting](https://recruitinghop.com) company.

I find it particularly useful for creating complicated XML/HTML snippets programmatic-ly in Java that you can use as lambdas or helpers in [jMustache](https://github.com/samskivert/jmustache) or [Handlebars.java](https://github.com/jknack/handlebars.java) (respectively). Its also very good at creating extremely large XML documents while using very little memory.

Feel free to contact me on twitter: [@agentgt](http://twitter.com/agentgt).

## News

Yes JATL has not been touched for awhile. Not because its not useful or dead but rather there were no changes that were needed.

HOWEVER Java 8 is out and actually works!! Finally the oracle overlords have bequeathed us with elegant deferred logic and sort of traits. Consequently JATL will probably probably be changed dramatically as there were many things people wanted to do that were rather difficult or not very elegant with the anonymous classes.


### 0.3.0 Planned

 * ~~Full~~ Better HTML5 support (XML style HTML5).
 * Appendable instead of Writer (no need to wrap StringBuilder)
 * Better Indentation strategy documentation
 * Better escaping strategy (see [Issue #10](http://code.google.com/p/jatl/issues/detail?id=10))
 * Remove Commons Lang dependency (JATL will have no dependencies)
 * A generic concrete XML Builder and Writer (Issue #15).

### 0.2.2 Released

 * Issue #11 fixed. [New method of composition](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupWriter.html).
 * Issue #16 fixed.

### 0.2.1 Released

[Issue #10](http://code.google.com/p/jatl/issues/detail?id=10) fixed.

### 0.2.0 Released

Experimental indentation strategy is in and OSGI support.

#### Better Indentation Support (more to come later):

[Indenter Unit Test Example](http://code.google.com/p/jatl/source/browse/src/test/java/com/googlecode/jatl/HtmlBuilderTest.java#537)

[Indenter Javadoc... not done yet](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/Indenter.html)

## Download

Use Maven or its variants/emulators:

```xml
<dependency>
    <groupId>com.googlecode.jatl</groupId>
    <artifactId>jatl</artifactId>
    <version>0.2.2</version>
</dependency>
```

The jars are in the central repository http://repo1.maven.org/maven2/com/googlecode/jatl/jatl.

## Inspiration

Are  you tired of using !StringBuffer to generate Markup (HTML/XML) but don't want to use a templating language or some XML library?

Do you want to be able to generate HTML like [Groovy's Markup Builders](http://groovy.codehaus.org/GroovyMarkup) or [Haml](http://haml-lang.com/ Ruby's) but with Java.

I know I do.

There are lots of advantages for using Java as templating language instead of something like Velocity, Freemarker, and Jelly. If you are using an IDE such as Eclipse with JATL you can get syntax highlighting, code refactoring and content assistance for free. Not to mention you now have one less language to remember and deal with.


See my posting on stackoverflow that caused me to write this library:
http://stackoverflow.com/questions/3583846/java-html-builder-anti-template-library 

## Examples

```java
    @Test
    public void testExample() throws Exception {
        //From http://codemonkeyism.com/the-best-markup-builder-i-could-build-in-java/
        new Html(writer) {{
            bind("id", "foo");
            bind("coolName", "Awesomo");
            html();
                body();
                    h1().text("Name Games").end();
                    p().id("${id}").text("Hello ${coolName}, and hello").end();
                makeList("Kyle","Stan", "Eric", "${coolName}");
            endAll();
            done();
        }
            Html makeList(String ... names) {
                ul();
                for(String name : names) {
                    li().text(name).end();
                }
                return end();
            }
        };
        String result = writer.getBuffer().toString();
        String expected = "\n" + 
                "<html>\n" + 
                "    <body>\n" + 
                "        <h1>Name Games\n" + 
                "        </h1>\n" + 
                "        <p id=\"foo\">Hello Awesomo, and hello\n" + 
                "        </p>\n" + 
                "        <ul>\n" + 
                "            <li>Kyle\n" + 
                "            </li>\n" + 
                "            <li>Stan\n" + 
                "            </li>\n" + 
                "            <li>Eric\n" + 
                "            </li>\n" + 
                "            <li>Awesomo\n" + 
                "            </li>\n" + 
                "        </ul>\n" + 
                "    </body>\n" + 
                "</html>";
        assertEquals(expected, result);
    }
```

_Notice the double brace after the Html constructor. This is done on purpose._ Double braces on anonymous class definitions is how many libraries including JATL achieve a DSL.

*For more examples please browse the [unit test code](https://github.com/agentgt/jatl/blob/master/src/test/java/com/googlecode/jatl/HtmlBuilderTest.java).*

## Features

### Efficient

 * Stream/Writer based thus very memory friendly for large documents.
 * No unnecessary template preprocessing (parsing and AST building/walking).
 * No reflection used. Templating languages like Velocity use reflection heavily.
 * Very small footprint and only one dependency: commons-lang which most projects already have.

### Flexible and easy to learn

 * Its Java so you already know it.
 * Easy to extend: [Use regular Java inheritance](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupBuilder.html).
 * Composition is easy, [just keep adding methods JQuery plugin style](http://code.google.com/p/jatl/source/browse/src/test/java/com/googlecode/jatl/CustomHtmlBuilderTest.java) or use [deferred writers](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupWriter.html).
 * You can generate snippets or an entire document.
 * You can nest different markup builders (DSLs within DSL).
 * No more worrying about [HTML escaping as it is done automatically](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupBuilder.html#text(java.lang.String)).
 * Dreaded [Self Closing div tag](http://stackoverflow.com/questions/3907744/keep-jspx-from-creating-self-closing-tags-div-div-div) is no longer a problem with [flexible tag closing policy](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupBuilder.TagClosingPolicy.html)

### Elegant and Convenient

 * Use either fluent (`.method()`) style chaining or normal style (`method();`).
 * No more typing annoying `<`, `>`
 * No more grep'ing or searching for templates when they can be right in the controller.
 * The XML/XHTML generated is pretty printed to the way you would expect. No more weird whitespace.
 * [Fast variable expansion of `${...}`](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupBuilder.html#bind())
 * [Easy to close tags](http://site.jatl.googlecode.com/hg/apidocs/com/googlecode/jatl/MarkupBuilder.html#end()).

## Documentation

Please see [Javadoc](http://site.jatl.googlecode.com/hg/apidocs/index.html)
