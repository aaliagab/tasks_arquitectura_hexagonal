package com.hexagonal.tasks.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;
    private boolean completed;

}
