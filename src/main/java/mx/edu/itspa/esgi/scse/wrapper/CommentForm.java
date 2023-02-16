package mx.edu.itspa.esgi.scse.wrapper;

public class CommentForm {
	private Integer id;
	private String comment;
	private Integer requestId;
	private Integer commentId;
	public CommentForm(Integer id, String comment, Integer requestId, Integer commentId) {
		super();
		this.id = id;
		this.comment = comment;
		this.requestId = requestId;
		this.commentId = commentId;
	}
	public CommentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
	
}
