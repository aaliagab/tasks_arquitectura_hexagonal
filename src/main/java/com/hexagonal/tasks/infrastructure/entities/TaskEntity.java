package com.hexagonal.tasks.infrastructure.entities;

import com.hexagonal.tasks.domain.models.Task;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;
    private boolean completed;

    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreateDate(),
                task.isCompleted()
        );
    }

    public Task toDomainModel(){
        return new Task(id,title,description,createDate,completed);
    }
}
