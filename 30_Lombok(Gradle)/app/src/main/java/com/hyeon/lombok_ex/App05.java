package com.hyeon.lombok_ex;

import com.google.gson.Gson;
import com.hyeon.helpers.FileHelper;
import com.hyeon.model.Data05;

public class App05 {
    public static void main(String[] args) {
        
        String json = null;

        try {
            json = FileHelper.getInstance().readString("res/05.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Gson gson = new Gson();
        Data05 data = gson.fromJson(json, Data05.class);
        /* 
        System.out.println(data.getRss());
        System.out.println();
        System.out.println(data.getRss().getItem());
        */
        for (Data05.Rss.Item item : data.getRss().getItem()) {
            System.out.println(item);
        }
        
    }
}
