package com.naldojesse.stackoverflow.controllers;

import com.naldojesse.stackoverflow.models.Question;
import com.naldojesse.stackoverflow.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {

    private final QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/questions")
    public String questions(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("curr_question") Question curr_question) {
        return "newQuestion.jsp";
    }

    @RequestMapping("/questions/create")
    public String createQuestion(@Valid @ModelAttribute("curr_question") Question question, BindingResult result, Model model) {
//        System.out.println(tags);
        if (result.hasErrors()) {
            System.out.println("has errors");
            return "newQuestion.jsp";
        } else  {

            System.out.println("result has no errors");
            try {
                questionService.addQuestion(question);

            } catch (DataIntegrityViolationException ex) {
                System.out.println("Tag was found not to be unique");
                model.addAttribute("error", "You entered a tag that was not unique!");
                return "newQuestion.jsp";
            }
        }

        return ":redirect/questions";
    }

//    @RequestMapping("/questions/create/errors")
//    public String NotUniqueError(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("error", "You entered a tag that was not unique!");
//        return "redirect"
//    }
}
