package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    
    JSONArray nurses = getAll();

    @PostMapping("/login")
    public boolean login(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
        for (int i = 0; i < nurses.length(); i++) {
            JSONObject nurse = nurses.getJSONObject(i);
            if (nurse.getString("name").equals(name) && nurse.getString("password").equals(password)) {
                return true;
            }
        }

        return false;
    }

    private JSONArray getAll() {
        return new JSONArray();
    }
    
}
