
public class Body {

	public static final String HTML_PAGE_HEAD = "<html lang=\"en\">" +
			"<head><title>Rob's Wholesale</title></head>" +
			"<body><h1>Rob's Wholesale</h1>";
	
	public static String LIST_CONTENT = "<div><table class=\"table\">" +
			"<thead id=\"table_head\">" + 
	        "<th>Item</th>" +
	        "<th>Quanity</th>" +
	        "<th>Price</th>" +
	        "</thead>" +
	        "<tbody id=\"sale_items\">";
	        

	public static String content = "<tr id=\"hep\">" +
	        "<td>h</td><td>a</td><td>h</td></tr>" +
	        "<tr><td>d</td><td>h</td><td>c</td></tr>";
	
	public static final String LIST_END = "</tbody>" +
	        "</table>" +
	        "</div>";
	
	public static final String HTML_PAGE_FOOTER = "</body></html>";
	
	public static String getHTMLPage(String entries)
	{
		if(entries == null)
		{
			entries = content;
		}
		String HTML = HTML_PAGE_HEAD + LIST_CONTENT + entries + LIST_END + HTML_PAGE_FOOTER;
		return HTML;
	}
}
