package org.com.howtodo.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    private Integer id;

    private String name;

    private User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
