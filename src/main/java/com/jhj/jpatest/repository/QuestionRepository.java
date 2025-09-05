package com.jhj.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	// JPA SQL문 직접 쓰기
	@Query("SELECT q FROM Questiontbl q WHERE q.qnum= :qnum")
	public Questiontbl findQuestionByQnum(@Param("qnum") Long qnum);
	
	// 질문 제목에 특정 문자가 들어간 JPA SQL문 직접 쓰기
	@Query("SELECT q FROM Questiontbl q WHERE q.qtitle LIKE %:qtitle%")
	public Questiontbl findQuestionByQtitle(@Param("qtitle") String qtitle);
	
	// 질문글 번호가 특정값보다 큰 질문 번호 호출 JPA SQL문 직접 쓰기
	@Query("SELECT q FROM Questiontbl q WHERE q.qnum > :number")
	public Questiontbl findQuestionByQnumber(@Param("number") Long number);
		
	// Native SQL문
	@Query(value = "SELECT * FROM jpaquestiontbl WHERE qnum= :qnum", nativeQuery =  true)
	public Questiontbl findQuestionNativeByQnum(@Param("qnum") Long qnum);
	
	// Qnum이 존재하는 번호면 true 반환
	public boolean existsByQnum(Long qnum);
	
	// 특정값보다 큰 레코드 조회
	public List<Questiontbl> findByQnumGreaterThanEqual(Long qnum);
	
	// 질문 내용 update
	@Transactional
	@Modifying
	@Query("UPDATE Questiontbl q SET q.qcontent= :qcontent WHERE q.qnum= :qnum")
	public int updateQcontentByQnum(@Param("qcontent") String qcontent, @Param("qnum") Long qnum);
	
	@Modifying
	@Query(value = "UPDATE jpaquestiontbl q SET q.qcontent= :qcontent WHERE q.qnum= :qnum", nativeQuery =  true)
	public int updateNativeQcontentByQnum(@Param("qcontent") String qcontent, @Param("qnum") Long qnum);
}
