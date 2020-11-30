package com.tia.overflow.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tia.overflow.models.Answer;
import com.tia.overflow.models.Question;
import com.tia.overflow.models.Tag;
import com.tia.overflow.services.TagService;

@Controller
public class MainController {

	@Autowired
	private TagService tagService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/question")
	public String index(Model model, @ModelAttribute("question")Question question) {
		model.addAttribute("allQuestions", tagService.allTags());
		return "question.jsp";
	}
	@PostMapping("/question")
	public String create(@RequestParam("tag")String tag,@ModelAttribute("question")Question question, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors().get(0));
			return"question.jsp";
		}
		Question quest = tagService.createQuestion(question);
		Tag tag1 = new Tag();
		tag1.setName(tag);
		
		Tag tagged = tagService.createTag(tag1);
		System.out.println(tagged.getName());
		List<Tag> tags = new ArrayList <Tag>();
		
		tags.add(tagged);
		quest.setTags(tags);
		tagService.save(quest);
		
		return "redirect:/";
	}
	
	@RequestMapping("/question/{id}")
	public String view(@ModelAttribute("answer")Answer answer,@PathVariable("id")Long id, Model model, BindingResult result) {
		Question quest = tagService.findQuestion(id);
		Tag tagged = tagService.findTag(id);
		Answer ans = tagService.createAnswer(answer);
		
		
		ans.setQuestion(tagService.findQuestion(id));
		tagService.save(answer);
		
		model.addAttribute("question", quest);
		return "viewquestion.jsp";
	}
	
	@PostMapping("/question/{id}")
	public String addAnswer(@RequestParam("answer")String answer, @PathVariable("id")Long id, Model model) {
		Answer ans1 = new Answer();
		ans1.setAnswer(answer);
		
		Answer ans = tagService.createAnswer(ans1);
		tagService.addAnswerToQuestion(ans, tagService.findQuestion(id));
		
		
		
		model.addAttribute("allAnswers", tagService.allAnswers());
		return "redirect:/question/" + id;
	}
	
	
	@RequestMapping("/dashboard")
	public String dash(Model model, @ModelAttribute("question")Question question) {
		model.addAttribute("allQuestions", tagService.allQuestions());
		model.addAttribute("allTags", tagService.allTags());
		return "dash.jsp";
	}

	//Q obj contain list onf answer, get q, get answer, add answr to list of questoins
	
}
