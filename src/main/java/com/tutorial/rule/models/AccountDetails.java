package com.tutorial.rule.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {
    String id;
    String type;
    String ownerName;
    Date lastPasswordChanged;
    boolean active;
    Date creationDate;
    Date reviewDate;
    Date lastLoginDate;
    boolean passwordNeverExpired;
    int noOfGroups;
}