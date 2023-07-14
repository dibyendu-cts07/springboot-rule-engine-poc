package com.tutorial.rule.config.engine.compliance;

import org.springframework.stereotype.Service;

import com.tutorial.rule.config.engine.InferenceEngine;
import com.tutorial.rule.models.AccountDetails;
import com.tutorial.rule.models.ComplainceResult;
import com.tutorial.rule.models.RuleNamespace;

@Service
public class ComplainceInferenceEngine extends InferenceEngine<AccountDetails, ComplainceResult> {

	@Override
	protected RuleNamespace getRuleNamespace() {
		return RuleNamespace.COMPLAINCE;
	}

	@Override
	protected ComplainceResult initializeOutputResult() {
		return ComplainceResult.builder().build();
	}
}