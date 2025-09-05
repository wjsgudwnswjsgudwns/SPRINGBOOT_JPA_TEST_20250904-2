package com.jhj.jpatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jhj.jpatest.dto.QuestionDto;
import com.jhj.jpatest.entity.Questiontbl;
import com.jhj.jpatest.repository.QuestionRepository;

@SpringBootTest
public class TestQuestion {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	@DisplayName("질문 등록 테스트")
	public void writeQuestion() {
		//Questiontbl question = new Questiontbl();
		//question.setQtitle("세번째 질문입니다.");
		//question.setQcontent("내일은 토요일이 맞나요?");
		
		QuestionDto questionDto = new QuestionDto();
		questionDto.setQtitle("네번째 질문입니다.");
		questionDto.setQcontent("내일부터 주말입니다.");
		
		Questiontbl question = questionDto.getEntity(); // DTO -> ENTITY 변환
		
		// JPA 메소드는 entity 객체만 인자값으로 받을수 있음
		questionRepository.save(question); // insert문 실행
	}
	
}
