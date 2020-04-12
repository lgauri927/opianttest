package com.expression.arithmaticExpression;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.expression.expressionController.ExpressionController;
import com.expression.h2.repo.ExpressionEvalRepo;
import com.expression.iArithmaticExpressionImpl.EvaluateStringImpl;
import com.expression.model.ExpressionEval;
import com.expression.pojo.ExpressionEvalPojo;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@SpringBootTest()
@WebAppConfiguration
public class TestExpressionEval {
	@Autowired
	EvaluateStringImpl evaluateString;

	@InjectMocks
	private ExpressionController expressionController;

	@Mock
	private ExpressionEvalRepo repo;

	@org.junit.Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRepo() {
		ExpressionEval exp = new ExpressionEval();
		exp.setInput("10-8");
		exp.setOutput(2);
		repo.save(exp);
		Assert.assertNotNull(exp.getId());
	}

	@Test
	public void testExpressionEval() {
		ExpressionEvalPojo exp = new ExpressionEvalPojo();
		exp.setId(1);
		exp.setInput("100+9");
		ExpressionEval expressionEval = evaluateString.insertExpression(exp);
		// when(repo.findById(1)).thenReturn(exp);
		assertEquals(109, expressionEval.getOutput());

	}

}
