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

	public static void readScientificArticles() {
		ClassLoader classLoader = CovidSciDiscoveries.class.getClassLoader();
		URL resource = classLoader.getResource("ScientificArticles");
		File f = new File(resource.getFile());
		File[] listOfFiles = f.listFiles();
		for (File file : listOfFiles) {
			readPdfFile(file);
		}
		//testing
		for(ScientificArticle article: articleList) {
			System.out.println(article.toString());
		}
	}

}
