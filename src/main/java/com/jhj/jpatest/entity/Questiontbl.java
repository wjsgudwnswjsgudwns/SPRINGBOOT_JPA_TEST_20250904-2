package com.jhj.jpatest.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 엔티티 클래스로 설정
@Table(name = "jpaquestiontbl") // 실제로 매핑될 데이터베이스의 테이블 이름 설정
@SequenceGenerator(
		name = "QUESTION_SEQ_GENERATOR", // JPA 내부 시퀀스 이름
		sequenceName =  "QUESTION_SEQ", // 실제 DB 시퀸스 이름
		initialValue = 1, // 시퀀스 초기값
		allocationSize = 1 // 시퀀스 증가치
		)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Questiontbl {
	
	@Id // 해당 테이블의 해당 필드를 기본키 필드로 설정
	@Column(name = "qnum") // 실제로 DB 테이블에 만들어질 필드 이름을 설정(생략가능)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQ_GENERATOR") // 시퀸스 자동증가
	private Long qnum; // 질문 번호(기본키+시퀀스로 자동증가)
	
	@Column(name = "qtitle", length = 20, nullable = false) // (필드 이름 , 길이 , null 허용 여부)
	private String qtitle; // 질문 제목
	
	@Column(name = "qcontent", length = 200, nullable = false)
	private String qcontent; // 질문 내용
	
	@CreationTimestamp // 자동으로 입력 (sysdate)
	private LocalDateTime qdate; // 질문 등록일 -> sysdate
	
	@UpdateTimestamp // 자동으로 입력 (sysdate)
	private LocalDateTime udate; // 수정 시간 자동 입력
}
