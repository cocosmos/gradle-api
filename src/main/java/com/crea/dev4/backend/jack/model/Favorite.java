package com.crea.dev4.backend.jack.model;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Setter
@Getter
@AllArgsConstructor
@Entity
@IdClass(CompositeKey.class)
public class Favorite {
    @Id
    private int accountid;
    @Id
    private int productid;

    public Favorite() {
        this(0, 0);
    }
}
