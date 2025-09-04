package com.jhj.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhj.jpatest.entity.Questiontbl;

public interface QuestionRepository extends JpaRepository<Questiontbl, Long> { // Dao 클래스 역할
													//상속 <적용 시킬 엔티티 , 키본키의 클래스> 
}
