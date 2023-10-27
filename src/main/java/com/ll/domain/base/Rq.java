package com.ll.domain.base;

import java.util.Map;

public class Rq {
    private String action;
    private Map<String, Integer> query;
    Rq(String cmd) {
        String[] comBits = cmd.split("\\?", 2);
        action = comBits[0];
        if (comBits.length == 1) {
            return;
        }
        String[] queryString = comBits[1].split("&");
        for (int i = 0; i < query.size(); i++) {
            String[] params = queryString[i].split("=");
            String param = params[0];
            int idNum = Integer.parseInt(params[1]);
            query.put(param, idNum);
        }
    }
    public String getAction() {
        return action;
    }
}