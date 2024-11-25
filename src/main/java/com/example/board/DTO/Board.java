package com.example.board.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "cancer_board") // 데이터베이스 테이블 이름
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가
	@Column(name = "board_seq")
	private int boardSeq;

	@Column(name = "board_id", nullable = false) // 컬럼 매핑
	private String boardId;

	@Column(name = "board_title", nullable = false)
	private String boardTitle;

	@Column(name = "board_content", nullable = false)
	private String boardContent;

	@Column(name = "board_cnt", nullable = false)
	private int boardCnt;

	@Column(name = "board_create_dt")
	private LocalDateTime boardCreateDt;

	@Column(name = "board_update_dt")
	private LocalDateTime boardUpdateDt;

	@Column(name = "board_create_id")
	private String boardCreateId;

	@Column(name = "board_update_id")
	private String boardUpdateId;


	// Getters and Setters
	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getBoardCreateId() {
		return boardCreateId;
	}

	public void setBoardCreateId(String boardCreateId) {
		this.boardCreateId = boardCreateId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardCnt() {
		return boardCnt;
	}

	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

	public LocalDateTime getBoardCreateDt() {
		return boardCreateDt;
	}

	public void setBoardCreateDt(LocalDateTime boardCreateDt) {
		this.boardCreateDt = boardCreateDt;
	}

	public LocalDateTime getBoardUpdateDt() {
		return boardUpdateDt;
	}

	public void setBoardUpdateDt(LocalDateTime boardUpdateDt) {
		this.boardUpdateDt = boardUpdateDt;
	}
	public String getBoardUpdateId() {
		return boardUpdateId;
	}

	public void setBoardUpdateId(String boardUpdateId) {
		this.boardUpdateId = boardUpdateId;
	}
	@Override
	public String toString() {
		return "Board{" +
				"boardSeq=" + boardSeq +
				", boardId='" + boardId + '\'' +
				", boardTitle='" + boardTitle + '\'' +
				", boardContent='" + boardContent + '\'' +
				", boardCnt=" + boardCnt +
				", boardCreateDt=" + boardCreateDt +
				", boardUpdateDt=" + boardUpdateDt +
				", boardCreateId='" + boardCreateId + '\'' +
				", boardUpdateId='" + boardUpdateId + '\'' +
				'}';
	}
}