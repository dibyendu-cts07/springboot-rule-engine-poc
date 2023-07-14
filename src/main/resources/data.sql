--COMPLAINCE RULE 1
INSERT INTO rules 
 (rule_namespace , rule_id, condition, 
 action, priority, description) 
VALUES (
 'COMPLAINCE',
 '1',
 'input.active == true && input.noOfGroups >= 20', 
 'output.ruleId = 1;output.message = "Account active but having more 20 groups.";',
 '1', 
 'Account active but having more 20 groups.'
);

--COMPLAINCE RULE 2
INSERT INTO rules 
 (rule_namespace , rule_id, condition, 
 action, priority, description) 
VALUES (
 'COMPLAINCE',
 '2',
 'input.passwordNeverExpired == true', 
 'output.ruleId = 2;output.message = "Account has set as password never expired.";',
 '1', 
 'Account has set as password never expired.'
);

--COMPLAINCE RULE 3
INSERT INTO rules 
 (rule_namespace , rule_id, condition, 
 action, priority, description) 
VALUES (
 'COMPLAINCE',
 '3',
 '(systimestamp.time - input.lastPasswordChanged.time)/(1000*60*60*24) >= 90', 
 'output.ruleId = 3;output.message = "Password has not reset in last 90 days.";',
 '1', 
 'Password has not reset in last 90 days.'
);
