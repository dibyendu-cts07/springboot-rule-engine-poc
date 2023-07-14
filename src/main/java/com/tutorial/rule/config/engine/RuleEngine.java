package com.tutorial.rule.config.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.rule.models.Rule;
import com.tutorial.rule.services.RuleService;

@Service
public class RuleEngine {

	@Autowired
	private RuleService ruleService;

	public Object run(InferenceEngine inferenceEngine, Object inputData) {
		String ruleNamespace = inferenceEngine.getRuleNamespace().toString();
		// TODO: Here for each call, we are fetching all rules from db. It should bes cache.
		List<Rule> allRulesByNamespace = ruleService.getAllRuleByNamespace(ruleNamespace);
		Object result = inferenceEngine.run(allRulesByNamespace, inputData);
		return result;
	}

}