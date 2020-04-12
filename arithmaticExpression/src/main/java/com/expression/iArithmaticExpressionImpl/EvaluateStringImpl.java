package com.expression.iArithmaticExpressionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expression.h2.repo.ExpressionEvalRepo;
import com.expression.iArithmaticExpression.EvaluateString;
import com.expression.model.ExpressionEval;
import com.expression.pojo.ExpressionEvalPojo;

@Service
public class EvaluateStringImpl implements EvaluateString {

	@Autowired
	ExpressionEvalRepo repo;

	@Override
	public ExpressionEval insertExpression(ExpressionEvalPojo pojo) {

		ExpressionEval expressionEval = convertDtoToModel(pojo);
		repo.save(expressionEval);
		return expressionEval;
	}

	private ExpressionEval convertDtoToModel(ExpressionEvalPojo expressionEvalPojo) {
		int evalOuput = 0;
		ExpressionEval expr = new ExpressionEval();
		if (expressionEvalPojo.getId() != null) {
			expr.setId(expressionEvalPojo.getId());
		}
		expr.setInput(expressionEvalPojo.getInput());
		evalOuput = evaluateExp(expressionEvalPojo.getInput());
		expr.setOutput(evalOuput);
		return expr;
	}

	@Override
	public List<ExpressionEval> getExpression() {
		List<ExpressionEval> expression = new ArrayList<>();
		repo.findAll().forEach(expr -> expression.add(expr));
		return expression;
	}

	private int evaluateExp(String expression) {

		Stack<Integer> numbers = new Stack<>();

		Stack<Character> operations = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (Character.isDigit(c)) {
					num = num * 10 + (c - '0');
					i++;
					if (i < expression.length())
						c = expression.charAt(i);
					else
						break;
				}
				i--;
				numbers.push(num);
			} else if (c == '(') {
				operations.push(c);
			} else if (c == ')') {
				while (operations.peek() != '(') {
					int output = performOperation(numbers, operations);
					numbers.push(output);
				}
				operations.pop();
			} else if (isOperator(c)) {
				while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
					int output = performOperation(numbers, operations);
					numbers.push(output);
				}
				operations.push(c);
			}
		}

		while (!operations.isEmpty()) {
			int output = performOperation(numbers, operations);
			numbers.push(output);
		}
		return numbers.pop();
	}

	static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	private int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
		int a = numbers.pop();
		int b = numbers.pop();
		char operation = operations.pop();
		switch (operation) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			if (a == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return b / a;
		}
		return 0;
	}

	private boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
	}

}
