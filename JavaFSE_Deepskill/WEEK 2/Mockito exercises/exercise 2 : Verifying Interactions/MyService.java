package com.example1.Mockito1;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public boolean processAndSave(String input) {
        String processed = input.toUpperCase();
        return api.saveData(processed);
    }
}
