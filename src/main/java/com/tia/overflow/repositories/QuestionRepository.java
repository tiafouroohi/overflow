package com.tia.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tia.overflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();

}
