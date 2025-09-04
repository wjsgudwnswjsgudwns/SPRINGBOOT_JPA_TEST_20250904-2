package com.jhj.jpatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jhj.jpatest.entity.Questiontbl;
import com.jhj.jpatest.repository.QuestionRepository;

@SpringBootTest
public class TestQuestion {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	@DisplayName("질문 등록 테스트")
	public void writeQuestion() {
		Questiontbl question = new Questiontbl();
		question.setQtitle("첫번째 질문입니다.");
		question.setQcontent("오늘은 목요일이 맞나요?");
		
		questionRepository.save(question); // insert문 실행
	}
	
}
