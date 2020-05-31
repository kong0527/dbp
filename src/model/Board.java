package model;
//게시물 관리를 위해 필요한 도메인 클래스. Board 테이블과 대응됨
public class Board {
	private int boardno;
	private String title;
	private String id;
	private String answer;
	private String inquiry;
	private String date;
	
	public Board() { }
	
	public Board(int boardno, String title, String id, String inquiry, String answer, String date) {
		this.boardno = boardno;
		this.title = title;
		this.id = id;
		this.inquiry = inquiry;
		this.answer = answer;
		this.date = date;
	}
	
	public Board(int boardno, String id) {
		super();
		this.boardno = boardno;
		this.id = id;
	}

	public Board(String answer) {
		super();
		this.answer = answer;
	}
	
	public Board(String title, String inquiry) {
		super();
		this.title = title;
		this.inquiry = inquiry;
	}

	public Board(int boardno, String answer, String inquiry) {
		super();
		this.boardno = boardno;
		this.answer = answer;
		this.inquiry = inquiry;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getInquiry() {
		return inquiry;
	}

	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
