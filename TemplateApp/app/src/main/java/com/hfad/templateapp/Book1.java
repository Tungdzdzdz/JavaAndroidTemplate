package com.hfad.templateapp;

public class Book1 {
    private String name;
    private int IdResource, viewType;

    public Book1(String name, int idResource) {
        this.name = name;
        IdResource = idResource;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public Book1(String name, int idResource, int viewType) {
        this.name = name;
        IdResource = idResource;
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
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
