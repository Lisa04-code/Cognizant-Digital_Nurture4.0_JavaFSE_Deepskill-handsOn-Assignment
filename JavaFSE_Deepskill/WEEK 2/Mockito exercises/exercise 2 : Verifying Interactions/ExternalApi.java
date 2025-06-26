package com.example1.Mockito1;

public class ExternalApi {
    public String getData() {
        return "Real API Data";
    }

    public boolean saveData(String data) {
        
        return data != null;
    }
}
