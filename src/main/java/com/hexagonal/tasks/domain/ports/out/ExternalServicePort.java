package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;

public interface ExternalServicePort {
    AdditionalTasksInfo getAdditionalTasksInfo(Long taskId);
}
