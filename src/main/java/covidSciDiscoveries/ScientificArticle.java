package covidSciDiscoveries;

import java.util.ArrayList;

public class ScientificArticle {

	private String articleTitle;
	private String articleHyperlink;
	private String jounalName;
	private String publicationYear;
	private ArrayList<String> authorNames;
	
	public ScientificArticle(String articleTitle, String articleHyperlink, String jounalName, String publicationYear, ArrayList<String> authors) {
		this.articleTitle = articleTitle;
		this.articleHyperlink = articleHyperlink;
		this.jounalName = jounalName;
		this.publicationYear = publicationYear;
		this.authorNames = authors;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getJounalName() {
		return jounalName;
	}

	public void setJounalName(String jounalName) {
		this.jounalName = jounalName;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public ArrayList<String> getAuthors() {
		return authorNames;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authorNames = authors;
	}

	public String getArticleHyperlink() {
		return articleHyperlink;
	}

	public void setArticleHyperlink(String articleHyperlink) {
		this.articleHyperlink = articleHyperlink;
	}

	@Override
	public String toString() {
		return "ScientificArticle [articleTitle=" + articleTitle + ", articleHyperlink=" + articleHyperlink
				+ ", jounalName=" + jounalName + ", publicationYear=" + publicationYear + ", authorNames=" + authorNames
				+ "]";
	}
}
