package com.tutorial.rule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Enums;
import com.tutorial.rule.config.engine.RuleEngine;
import com.tutorial.rule.config.engine.compliance.ComplainceInferenceEngine;
import com.tutorial.rule.models.AccountDetails;
import com.tutorial.rule.models.ComplainceResult;
import com.tutorial.rule.models.Rule;
import com.tutorial.rule.models.RuleNamespace;
import com.tutorial.rule.services.RuleService;

@RestController
public class RuleEngineRestController {
    @Autowired
    private RuleService ruleService;
    @Autowired
    private RuleEngine ruleEngine;
    @Autowired
    private ComplainceInferenceEngine complainceInferenceEngine;

    @GetMapping(value = "/get-all-rules/{ruleNamespace}")
    public ResponseEntity<?> getRulesByNamespace(@PathVariable("ruleNamespace") String ruleNamespace) {
        RuleNamespace namespace = Enums.getIfPresent(RuleNamespace.class, ruleNamespace.toUpperCase()).or(RuleNamespace.DEFAULT);
        List<Rule> allRules = ruleService.getAllRuleByNamespace(namespace.toString());
        return ResponseEntity.ok(allRules);
    }

    @GetMapping(value = "/get-all-rules")
    public ResponseEntity<?> getAllRules() {
        List<Rule> allRules = ruleService.getAllRules();
        return ResponseEntity.ok(allRules);
    }

    @PostMapping(value = "/complaince")
    public ResponseEntity<?> postUserLoanDetails(@RequestBody AccountDetails accountDetails) {
        List<ComplainceResult> result = (List<ComplainceResult>) ruleEngine.run(complainceInferenceEngine, accountDetails);
        return ResponseEntity.ok(result);
    }

}