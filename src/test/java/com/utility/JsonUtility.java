package com.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {

    public static String readJSON(Env env)  {
        Gson gson= new Gson();
        File jsonFile= new File(System.getProperty("user.dir")+"/config/config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get(env);
        return environment.getUrl();

    }
}
