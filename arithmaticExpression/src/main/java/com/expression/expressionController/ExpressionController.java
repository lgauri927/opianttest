package com.expression.expressionController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.expression.iArithmaticExpressionImpl.EvaluateStringImpl;
import com.expression.model.ExpressionEval;
import com.expression.pojo.ExpressionEvalPojo;

@Controller
public class ExpressionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EvaluateStringImpl evaluateStringImpl;

	@PostMapping("/main")
	public String saveExpression(@ModelAttribute("expression") ExpressionEvalPojo pojo, Model model) {
		ExpressionEval expressionEval = evaluateStringImpl.insertExpression(pojo);
		model.addAttribute("output", expressionEval.getOutput());
		return "main";
	}

	@GetMapping("/")
	public String getMainPage(Model model) {
		model.addAttribute("expression", new ExpressionEvalPojo());
		return "main";
	}

	@GetMapping(value = "/evaluateString/getall")
	public List<ExpressionEval> getAll() {
		logger.info("Getting expressionEval details from the database.");
		return evaluateStringImpl.getExpression();
	}

}
