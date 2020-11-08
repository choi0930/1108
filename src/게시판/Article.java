package 게시판;

public class Article {
	private int id;
	private String title;
	private String body;
	private String man;
	public Article(int id, String title, String body, String man) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.man = man;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
}
