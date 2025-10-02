package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    
    JSONArray nurses = getAll();

    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String password = body.get("password");
        boolean answer = false;
        for (int i = 0; i < nurses.length(); i++) {
            JSONObject nurse = nurses.getJSONObject(i);
            if (nurse.getString("name").equals(name) && nurse.getString("password").equals(password)) {
                answer = true;
                break;
            }
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("response", answer);

        return ResponseEntity.ok(response);
    }
    
    private JSONArray getAll() {
        return new JSONArray();
    }
    
}
