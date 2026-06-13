package ru.tolstov.hw10;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task19 {
    public boolean isValidJson(String json) {
        try {
            new ObjectMapper().readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
