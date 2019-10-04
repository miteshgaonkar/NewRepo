package com.lti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {

	private Map<Subject, List<Question>> questionBank;

	public QuestionBank() {
		questionBank = new HashMap<>();
	}

	public void addNewSubject(Subject subject) {
		
		questionBank.put(subject, new ArrayList<>());
	}
	
	public void addNewQuestion(Subject subject, Question question){
		List<Question> questions = questionBank.get(subject);
		questions.add(question);
	}
	
	public List<Question> getQuestionsFor(Subject subject){
		return questionBank.get(subject);
	}
}
