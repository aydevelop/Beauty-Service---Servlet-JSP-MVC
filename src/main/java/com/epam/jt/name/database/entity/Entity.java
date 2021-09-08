package com.epam.jt.name.database.entity;

import java.io.Serializable;

public class Entity implements Serializable {

    private static final long serialVersionUID = 8420204017000698715L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
