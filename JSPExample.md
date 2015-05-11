# Introduction #

An advantage of JSP over JATL is that JSP reloads and fits in with other view/mvc technologies.

However you can still use JATL from JSP to get the best of both worlds.
The trick is to get the JSP printer writer and hand it off to JATL.

# Examples #

JSPX example:

```
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1">
<jsp:directive.page import="com.googlecode.jatl.Html"/>
<jsp:directive.page import="com.evocatus.product.data.AttributeValue"/>
<jsp:directive.page import="com.evocatus.domain.Product"/>

<jsp:scriptlet>
//<![CDATA[
    final Product p = (Product) request.getAttribute("product");
	new Html(out) {{
           for (AttributeValue v : p.summaryAttributeValues()) {
        	   p();
        	   	strong().text(v.getLabel()).end();
        	   	text(": " + v.getValue());
        	   endAll();
           }
	}};
//]]>
</jsp:scriptlet>

</jsp:root>
```