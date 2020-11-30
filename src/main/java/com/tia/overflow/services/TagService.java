package com.tia.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tia.overflow.models.Answer;
import com.tia.overflow.models.Question;
import com.tia.overflow.models.Tag;
import com.tia.overflow.repositories.AnswerRepository;
import com.tia.overflow.repositories.QuestionRepository;
import com.tia.overflow.repositories.TagQuestionRepository;
import com.tia.overflow.repositories.TagRepository;

@Service
public class TagService {
    

	@Autowired
    private TagRepository tagRepository;
    
    private QuestionRepository questionRepository;
    
    private TagQuestionRepository tagQuestionRepository;
    
    private AnswerRepository answerRepository;
    
    public TagService(TagRepository tagRepository, QuestionRepository questionRepository, TagQuestionRepository tagQuestionRepository, AnswerRepository answerRepository) {
        this.tagRepository = tagRepository;
        this.questionRepository = questionRepository;
        this.tagQuestionRepository = tagQuestionRepository;
        this.answerRepository = answerRepository;
    }
 
   
    // returns all the books
    public List<Tag> allTags() {
        return (List<Tag>) tagRepository.findAll();
    }
    public List<Question>allQuestions(){
    	return (List<Question>) questionRepository.findAll();
    }
    public List<Answer>allAnswers(){
    	return(List<Answer>) answerRepository.findAll();
    }
    // creates a book
    public Tag createTag(Tag b) {
        return tagRepository.save(b);
    }
    public Tag save(Tag b) {
    	return tagRepository.save(b);
    }
    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
    
    public Question createQuestion(Question question) {
    	return questionRepository.save(question);
    }
    public Question save(Question question) {
    	return questionRepository.save(question);
    }
    

    public Question findQuestion(Long id) {
    	Optional<Question> optionalQuestion = questionRepository.findById(id);
    	if(optionalQuestion.isPresent()) {
    		return optionalQuestion.get();
    	} else {
    		return null;
    	}
    }
    public Answer createAnswer(Answer c) {
    	return answerRepository.save(c);
    }
    public Answer save(Answer c) {
    	return answerRepository.save(c);
    }
    

    public Answer findAnswer(Long id) {
    	Optional<Answer> optionalAnswer = answerRepository.findById(id);
    	if(optionalAnswer.isPresent()) {
    		return optionalAnswer.get();
    	} else {
    		return null;
    	}
    }
    public void addAnswerToQuestion(Answer answer, Question question) {
    	answer.setQuestion(question);
    	answerRepository.save(answer);
    }
    

		
	

 
}