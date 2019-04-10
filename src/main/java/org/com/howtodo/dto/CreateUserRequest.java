package org.com.howtodo.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private Integer id;

    private String name;

    public CreateUserRequest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreateUserRequest() {
    }
}
