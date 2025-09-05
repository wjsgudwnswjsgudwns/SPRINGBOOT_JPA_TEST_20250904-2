package com.jhj.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jhj.jpatest.entity.Questiontbl;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Questiontbl, Long> { // Dao 클래스 역할
													//상속 <적용 시킬 엔티티 , 기본키의 클래스> 
	@Transactional
	public void deleteAllByQtitle(String qtitle); // 질문 제목으로 삭제
	
	// 최근 질문글이 위로 오도록 정렬
	public List<Questiontbl> findAllByOrderByQdateDesc();
	
	// 두개의 조건이 일치하는 질문글 조회하기
	public Questiontbl findByQnumAndQtitle(Long qnum, String qtitle);
	
	// 제목이 정확히 일치하는 질문글 조회
	public List<Questiontbl> findAllByQtitle(String qtitle);
	
	// 질문 제목에 특정 문자가 들어있는 게시글 조회 -> LIKE
	public List<Questiontbl> findAllByQtitleLikeOrderByQdateDesc(String keyword);
	
	// SQL문 직접 쓰기
	@Query("SELECT q FROM Questiontbl q WHERE q.qnum= :qnum")
	public Questiontbl findQuestionByQnum(@Param("qnum") Long qnum);
}
