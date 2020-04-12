/**
 * 
 */
package com.expression.iArithmaticExpression;

import java.util.List;

import com.expression.model.ExpressionEval;
import com.expression.pojo.ExpressionEvalPojo;

/**
 * @author gauriZ
 *
 */
public interface EvaluateString {
	
	ExpressionEval insertExpression(ExpressionEvalPojo pojo);
	List<ExpressionEval> getExpression();
}
