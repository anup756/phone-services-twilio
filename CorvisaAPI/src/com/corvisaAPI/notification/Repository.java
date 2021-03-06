package com.corvisaAPI.notification;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Repository {
    private String filePath;

    public Repository() {
        this.filePath = getClass().getClassLoader().getResource("administrators.json").getPath();
    }

    public Repository(String filePath) {
        this.filePath = filePath;
    }

    public Administrator[] getAdministrators() {
        try {
            return new Gson().fromJson(new FileReader(filePath), Administrator[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return new Administrator[0];
        }
    }
}
