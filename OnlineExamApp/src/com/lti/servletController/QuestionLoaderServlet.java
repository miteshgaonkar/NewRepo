package com.lti.servletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	private List<Question> questions;
	private int noOfQuestions;

	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionsOnJava();
		// this method will get invoked only once as we initialize the code once
		noOfQuestions = questions.size();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		Integer questionNo = (Integer) session.getAttribute("qNo");
		if(questionNo== null)
			questionNo=0;
		else
			questionNo++;
		if(questionNo>=noOfQuestions){
			response.sendRedirect("DisplayResultServlet");
		}
		else{
			session.setAttribute("qNo", questionNo);
			
			Question q = questions.get(questionNo);
			session.setAttribute("currentQs", q);
		// it's always good to mention the response browser will receive
		response.setContentType("text/html");// here we tell browser which type
												// of response it will receive
		PrintWriter out = response.getWriter();
		out.print("Question number :"+questionNo);
		out.print("<form action='CalculateScoreServlet'>");
		out.print("<h3>"+q.getQuestion()+"</h3>");
		int optionNo=0;
		//out.print("Question number :"+questionNo);
		for (Option o : q.getOptions()) {
			
			out.print("<h4><input type='radio'name='option'value='"+(optionNo++)+"'>"+o.getOption()+"</h4>");
		}
		if(questionNo!=noOfQuestions-1){
			out.print("<button type='submit'>Continue</button>");
		}else{
			out.print("<button type='submit'>Finish</button>");
		}
		
		out.print("</form");
	}
	}

}
