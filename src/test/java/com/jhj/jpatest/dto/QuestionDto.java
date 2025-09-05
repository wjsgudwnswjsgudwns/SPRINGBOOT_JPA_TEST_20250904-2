package com.jhj.jpatest.dto;

import java.time.LocalDateTime;

import com.jhj.jpatest.entity.Questiontbl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
	
	private Long qnum; // 질문 번호(기본키+시퀀스로 자동증가)
	private String qtitle; // 질문 제목
	private String qcontent; // 질문 내용
	private LocalDateTime qdate; // 질문 등록일 -> sysdate
	private LocalDateTime udate; // 수정 시간 자동 입력
	
	public Questiontbl getEntity() {
		Questiontbl question = new Questiontbl();
		question.setQtitle(qtitle);
		question.setQcontent(qcontent);
		
		return question;
	}
}
