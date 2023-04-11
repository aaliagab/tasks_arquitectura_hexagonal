package com.hexagonal.tasks.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class AdditionalTasksInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;
}
