package com.hyeon.gson_ex;

import java.util.List;

import com.google.gson.Gson;
import com.hyeon.helpers.FileHelper;
import com.hyeon.model.Data03;

public class App03 {
    public static void main(String[] args) {
        
        String json = null;

        try {
            json = FileHelper.getInstance().readString("res/03.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Gson gson = new Gson();
        Data03 data = gson.fromJson(json, Data03.class);
        System.out.println(data);

        List<String> items = data.getItem();
        System.out.println(items);
        /* 
        for (int i=0; i<items.size(); i++) {
            System.out.println(items.get(i));
        }
         */
        for (String item : items) {
            System.out.println(item);
        }
    }
}
