package covidSciDiscoveries;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;

import pl.edu.icm.cermine.ContentExtractor;
import pl.edu.icm.cermine.metadata.model.DateType;
import pl.edu.icm.cermine.metadata.model.DocumentAuthor;
import pl.edu.icm.cermine.metadata.model.DocumentMetadata;

public class CovidSciDiscoveries {

	private static ArrayList<ScientificArticle> articleList = new ArrayList<ScientificArticle>();
	
	public static String getCovidSciDicoveriesTable() {
		readScientificArticles();
		return createHTMLTable();
	}

	private static void readPdfFile(File file) {
		try {
			ContentExtractor extractor = new ContentExtractor();
			FileInputStream inputStream = new FileInputStream(file);
			extractor.setPDF(inputStream);
			DocumentMetadata result = extractor.getMetadata();
			ArrayList<String> authorList = new ArrayList<>();
			for (DocumentAuthor da : result.getAuthors()) {
				authorList.add(da.getName());
			}
			ScientificArticle article = new ScientificArticle(result.getTitle(), file.getAbsolutePath().toString(),
					result.getJournal(), result.getDate(DateType.PUBLISHED).getYear(), authorList);
			articleList.add(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readScientificArticles() {
		ClassLoader classLoader = CovidSciDiscoveries.class.getClassLoader();
		URL resource = classLoader.getResource("ScientificArticles");
		File f = new File(resource.getFile());
		File[] listOfFiles = f.listFiles();
		for (File file : listOfFiles) {
			readPdfFile(file);
		}
	}

	private static String createHTMLTable() {
		String html = "<head>\r\n" + 
				"<style>\r\n" + 
				"table {\r\n" + 
				"  font-family: arial, sans-serif;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td, th {\r\n" + 
				"  border: 1px solid #dddddd;\r\n" + 
				"  text-align: left;\r\n" + 
				"  padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even) {\r\n" + 
				"  background-color: #dddddd;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>" +
				"<body>" +
				"<h2>Covid19 Scientific Discoveries</h2>" +
				"<table>" +
				"<tr>\r\n" + 
				"<th>Article Title</th>\r\n" + 
				"<th>Journal name</th>\r\n" + 
				"<th>Publication year</th>\r\n" +
				"<th>Authors</th>\r\n" + 
				"</tr>";
		for(ScientificArticle article: articleList) {
			html += "<tr>\r\n" + 
					"<th <a href=\"" + article.getArticleHyperlink() + "\">" + article.getArticleTitle() + "</a></th>\r\n" + 
					"<th>" + article.getJounalName() + "</th>\r\n" + 
					"<th>"+ article.getPublicationYear() + "</th>\r\n" + 
					"<th>" + article.getAuthors() + "</th>\r\n" +
					"</tr>";
		}
		html+= "</table>\r\n" + 
				"</body>";
		return html;
	}
}
