package com.tutorial.rule.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rules")
@IdClass(RuleEntity.IdClass.class)
public class RuleEntity {

	@Id
	@Column(name = "rule_namespace")
	private String ruleNamespace;

	@Id
	@Column(name = "rule_id")
	private String ruleId;

	@Column(name = "condition")
	private String condition;

	@Column(name = "action")
	private String action;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "description")
	private String description;

	@Data
	static class IdClass implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5886173751904772534L;
		private String ruleNamespace;
		private String ruleId;
	}
}