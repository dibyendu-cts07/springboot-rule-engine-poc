package com.tutorial.rule.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tutorial.rule.data.entity.RuleEntity;
import com.tutorial.rule.models.Rule;
import com.tutorial.rule.models.RuleNamespace;
import com.tutorial.rule.repo.RulesRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuleService {

	@Autowired
	private RulesRepository rulesRepository;

	public List<Rule> getAllRules() {
		return rulesRepository.findAll().stream().map(
				ruleDbModel -> mapFromDbModel(ruleDbModel)
			)
			.collect(Collectors.toList());
	}

	@Cacheable("rules")
	public List<Rule> getAllRuleByNamespace(String ruleNamespace) {
		return rulesRepository.findByRuleNamespace(ruleNamespace).stream()
				.map(ruleDbModel -> mapFromDbModel(ruleDbModel)
						).collect(Collectors.toList());
	}

	private Rule mapFromDbModel(RuleEntity ruleDbModel) {
		RuleNamespace namespace = RuleNamespace.DEFAULT;
		try {
			namespace = RuleNamespace.valueOf(ruleDbModel.getRuleNamespace().toUpperCase());
		} catch (Exception e) {
			log.error("Invalid Rule namespace:" + ruleDbModel.getRuleNamespace(), e);
		}
		return Rule.builder()
				   .ruleNamespace(namespace)
				   .ruleId(ruleDbModel.getRuleId())
				   .condition(ruleDbModel.getCondition())
				   .action(ruleDbModel.getAction())
				   .description(ruleDbModel.getDescription())
				   .priority(ruleDbModel.getPriority())
				   .build();
	}
}