package com.jhj.jpatest;

import java.util.List;
import java.util.Optional;

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

	
//	@Test
//	@DisplayName("질문 등록 테스트") 
//	public void writeQuestion() { 
//		//Questiontbl question = new Questiontbl(); 
//		//question.setQtitle("세번째 질문입니다.");
//		//question.setQcontent("내일은 토요일이 맞나요?");
//	
//		QuestionDto questionDto = new QuestionDto(); questionDto.setQtitle("홍길동");
//		questionDto.setQcontent("저는 홍길동입니다.");
//	
//		Questiontbl question = questionDto.getEntity(); // DTO -> ENTITY 변환
//	
//		// JPA 메소드는 entity 객체만 인자값으로 받을수 있음 
//		questionRepository.save(question); //insert문 실행 
//		
//	}
	

//	@Test
//	@DisplayName("질문 삭제 테스트")
//	public void deleteQuestion() {
//
//		// questionRepository.deleteById(3L); // Long 타입은 숫자+L
//		// 기본키가 qnum=3인 레코드를 찾아서 삭제
//
//		questionRepository.deleteAllByQtitle("홍길동"); // 질문 제목으로 삭제
//
//	}
	
//	@Test
//	@DisplayName("질문 조회 테스트")
//	public void searchQuestion() {
//		List<Questiontbl> questionAllList = questionRepository.findAll();
//		// findAll() = 모든 레코드 가져오기
//		
//		for(Questiontbl question : questionAllList ) {
//			System.out.println(question.getQnum());
//			System.out.println(question.getQtitle());
//			System.out.println(question.getQcontent());
//			System.out.println(question.getQdate());
//			System.out.println(question.getUdate());
//			System.out.println("-------------------------");
//		}
//		
//		// 가장 최근 질문이 위로 오도록 정렬
//		List<Questiontbl> questionOrderList = questionRepository.findAllByOrderByQdateDesc();
//		
//		for(Questiontbl question : questionOrderList ) {
//			System.out.println(question.getQnum());
//			System.out.println(question.getQtitle());
//			System.out.println(question.getQcontent());
//			System.out.println(question.getQdate());
//			System.out.println(question.getUdate());
//			System.out.println("-------------------------");
//		}
//	}
	
	@Test
	@DisplayName("특정 질문 조회 테스트")
	public void searchQuestionByField() {
//		Optional<Questiontbl> questionOption = questionRepository.findById(4L); // 기본키로 검색
//		 
//		//기본키로 검색 했을 경우 레코드가 1개 또는 존재하지 않는 경우 발생
//		//Optional<Questiontbl> 형태로 반환 타입을 정해야한다.
//		//isPresent()를 사용하면 Optional<Questiontbl> 내에 객체의 존재여부를 알수 있다. 
//		if(questionOption.isPresent()) { // 참이면 존재
//			Questiontbl question = questionOption.get(); // 해당 기본키를 가진 엔티티 반환
//			System.out.println(question.getQnum());
//			System.out.println(question.getQtitle());
//			System.out.println(question.getQcontent());
//			System.out.println(question.getQdate());
//			System.out.println(question.getUdate());
//			System.out.println("-------------------------");
//		 } else { // 거짓이면 해당 기본키를 가지고 있는 레코드가 존재하지 않는다.
//			 System.out.println("질문이 존재하지 않습니다"); 
//		 }
//		
//		// SELECT * FROM jpaquestiontbl WHERE qnum =1 AND qtitle='홍길동'
//		Questiontbl qOptional = questionRepository.findByQnumAndQtitle(1L, "홍길동");
		
//		// 제목이 정확히 일치하는 질문글 조회
//		List<Questiontbl> questions = questionRepository.findAllByQtitle("홍길동");
//		for(Questiontbl question : questions ) {;
//			System.out.println(question.getQtitle());
//			System.out.println("-------------------------");
//		}
		
		
		// 질문 제목에 특정 문자가 들어있는 게시글 조회 -> LIKE
		List<Questiontbl> likeQuestions = questionRepository.findAllByQtitleLikeOrderByQdateDesc("%질문%");
		for(Questiontbl question : likeQuestions ) {;
			System.out.println(question.getQnum());
			System.out.println(question.getQtitle());
			System.out.println("-------------------------");
		}
		
	}

	
	
}
