package com.ll.domain.base;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String action;
    private Map<String, Integer> query = new HashMap<>();
    Rq(String cmd) {
        String[] comBits = cmd.split("\\?", 2);
        action = comBits[0];
        if (comBits.length == 1) {
            return;
        }
        String[] queryString = comBits[1].split("&");
        for (int i = 0; i < queryString.length; i++) {
            String[] params = queryString[i].split("=");
            String param = params[0];
            try {
                int idNum = Integer.parseInt(params[1]);
                query.put(param, idNum);
            } catch (Exception e) {
                query.put(param, -1);
            }
        }
    }
    public String getAction() {
        //명령어 반환
        return action;
    }

    public int getId() {
        try {
            return query.get("id");
        } catch (Exception e) {
            return -1;
        }
    }
}