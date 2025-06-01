package com.utility;

import com.constants.Env;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    public static String readProperty(Env env, String propertyName)  {

        FileInputStream fis = null;
        Properties properties =  new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"//config//" + env+".properties");
            try {
                properties.load(fis);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(propertyName.toUpperCase());
        return value;
    }
}

