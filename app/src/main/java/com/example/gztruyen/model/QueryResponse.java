package com.example.gztruyen.model;

import java.util.List;

public class QueryResponse<T> {
    private List<T> documents;

    public List<T> getDocuments() {
        return documents;
    }
    public void setDocuments(List<T> documents) {
        this.documents = documents;
    }
}
