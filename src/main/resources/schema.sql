CREATE TABLE rules (
 rule_namespace varchar_ignorecase(256) not null, 
 rule_id varchar_ignorecase(512) not null, 
 condition varchar_ignorecase(2000), 
 action varchar_ignorecase(2000), 
 priority integer, 
 description varchar_ignorecase(1000), 
 PRIMARY KEY(rule_namespace, rule_id)
);