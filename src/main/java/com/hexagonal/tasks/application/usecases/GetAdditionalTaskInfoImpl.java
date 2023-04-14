package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;
    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long id) {
        return externalServicePort.getAdditionalTasksInfo(id);
    }
}
