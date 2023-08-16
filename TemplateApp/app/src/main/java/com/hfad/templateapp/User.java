package com.hfad.templateapp;

public class User {
    private String name;
    private int IdResource;

    public User(String name, int idResource) {
        this.name = name;
        IdResource = idResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdResource() {
        return IdResource;
    }

    public void setIdResource(int idResource) {
        IdResource = idResource;
    }
}
