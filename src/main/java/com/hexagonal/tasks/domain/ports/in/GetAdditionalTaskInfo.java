package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;

public interface GetAdditionalTaskInfo {
    AdditionalTasksInfo getAdditionalTasksInfo(Long id);
}
