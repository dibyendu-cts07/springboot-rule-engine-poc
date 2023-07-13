package com.tutorial.rule.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.rule.data.entity.RuleEntity;

import java.util.List;

@Repository
public interface RulesRepository extends JpaRepository<RuleEntity, Long> {
    List<RuleEntity> findByRuleNamespace(String ruleNamespace);
    List<RuleEntity> findAll();
}