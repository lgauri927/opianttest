package com.expression.h2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.expression.model.ExpressionEval;

@Repository
public interface ExpressionEvalRepo extends CrudRepository<ExpressionEval, Integer> {

}
