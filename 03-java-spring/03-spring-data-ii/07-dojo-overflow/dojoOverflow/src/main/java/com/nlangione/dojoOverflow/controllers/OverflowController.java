package com.nlangione.dojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlangione.dojoOverflow.models.Answer;
import com.nlangione.dojoOverflow.models.Question;
import com.nlangione.dojoOverflow.services.AppService;

@Controller
public class OverflowController {
	@Autowired
	private AppService appService;

	// dashboard methods/routes
	@GetMapping("")
	public String root() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String index(Model model) {
		List <Question> questions = appService.getAllQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}

	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		else {
			appService.createQuestion(question);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/questions/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		
		Question questionSelected = appService.getQuestionById(id);
		
		model.addAttribute("question", questionSelected);
		
		return "viewQuestion.jsp";
	}
	
	@PostMapping("/questions/addAnswer")
	public String createQuestion(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "viewQuestion.jsp";
		}
		else {
			Answer newAnswer = appService.createAnswer(answer);
			return "redirect:/questions/"+newAnswer.getQuestion().getId();
		}
	}
}