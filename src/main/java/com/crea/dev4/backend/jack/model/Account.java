package com.crea.dev4.backend.jack.model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private int id;
    private String email;
    private String name;

    private String password;

    public Account() {
        this(0, "", "", "");
    }

}
