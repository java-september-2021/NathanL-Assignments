package com.nlangione.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.dojoOverflow.models.Answer;
import com.nlangione.dojoOverflow.models.Question;
import com.nlangione.dojoOverflow.models.Tag;
import com.nlangione.dojoOverflow.repositories.AnswerRepository;
import com.nlangione.dojoOverflow.repositories.QuestionRepository;
import com.nlangione.dojoOverflow.repositories.TagRepository;

@Service
public class AppService {

	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	public AppService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo) {
		this.qRepo = qRepo;
		this.aRepo = aRepo;
		this.tRepo = tRepo;
	}
	
	
	public Question createQuestion(Question newQuestion) {
		List <Tag> qTags = new ArrayList <Tag>();
		for (String subject : newQuestion.splitTags()) {
			Tag tagToAdd = this.tRepo.findBySubject(subject).orElse(null);
			if (tagToAdd == null) {
				tagToAdd = new Tag(subject);
				this.tRepo.save(tagToAdd);
				}
			if(!qTags.contains(tagToAdd)) {
				qTags.add(tagToAdd);
			}		
		}
		newQuestion.setTags(qTags);
		return this.qRepo.save(newQuestion);		
	}
	
	public Answer createAnswer(Answer newAnswer) {
		return this.aRepo.save(newAnswer);
	}
	

	public List <Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
			
	public Question getQuestionById(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public Answer getAnswerById(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
}
