package ruanko.newspublish.entity;

import java.util.Date;

/**
 * 新闻文章<br>
 * 新闻即文章，文章即新闻，有点混了
 * 
 * @author
 *
 */
public class Article {

	/**
	 * 编号
	 */
	private int id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
