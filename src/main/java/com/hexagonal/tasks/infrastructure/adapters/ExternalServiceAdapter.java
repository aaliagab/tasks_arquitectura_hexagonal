package com.hexagonal.tasks.infrastructure.adapters;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//https://jsonplaceholder.typicode.com/todos/
//https://jsonplaceholder.typicode.com/users/
public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }
    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/"+taskId;
        ResponseEntity<JsonPlaceHolderTodo> responseTodo =
                restTemplate.getForEntity(apiUrl,JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = responseTodo.getBody();
        if(todo==null)
            return null;
        apiUrl = "https://jsonplaceholder.typicode.com/users/"+todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseUser =
                restTemplate.getForEntity(apiUrl,JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = responseUser.getBody();
        if (user == null) {
            return null;
        }
        return new AdditionalTasksInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;
    }

    @Getter
    private static class JsonPlaceHolderUser{
        private Long id;
        private String name;
        private String email;
    }
}
