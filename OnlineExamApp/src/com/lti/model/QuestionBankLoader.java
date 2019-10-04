package com.lti.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public static List<Question> loadQuestionsOnJava() {
		QuestionBank qb = new QuestionBank();

		Subject s = new Subject();
		s.setName("Java");
		qb.addNewSubject(s);

		Question q = new Question();
		q.setQuestion("What is G1 in Java ?");

		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("G1 is a Garbage Collector", true));
		ops.add(new Option("G1 is another name for Jeevan", false));
		ops.add(new Option("G1 is the name of a spy agency", false));
		ops.add(new Option("G1 is SRK", false));
		q.setOptions(ops);

		 qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("Can static classes be inherited?");

		ops = new ArrayList<Option>();
		ops.add(new Option("No", true));
		ops.add(new Option("Yes", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("Parent class of checked exception ?");

		ops = new ArrayList<Option>();
		ops.add(new Option("Exception", true));
		ops.add(new Option("IO Exception", false));
		ops.add(new Option("Try- Catch", false));
		ops.add(new Option("Method", false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);


		q = new Question();
		q.setQuestion("What is servlet?");

		ops = new ArrayList<Option>();
		ops.add(new Option("Servlet is server side java code", true));
		ops.add(new Option("static HTML", false));
		ops.add(new Option("Try- Catch", false));
		ops.add(new Option("Method", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);
		return qb.getQuestionsFor(s);
	}
}
