/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author sandr
 */
public class DatabaseConfig {
    private static DatabaseConfig instance;
    private File dBConfigFile;
    BufferedReader br;
    Properties properties;

    private DatabaseConfig() {
        dBConfigFile = new File("config/dbconfig.properties");
        properties = new Properties();

    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public void postaviPodesavanja(String url, String username, String password) throws Exception{
        FileOutputStream fos = new FileOutputStream("config/dbconfig.properties");
        System.out.println(url);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
     
        properties.store(fos, "Properties file generated from Java program");
        fos.close();
    }
     
    public boolean getFileExists(){
        return dBConfigFile.exists();
    }
    
    public String getURL() throws Exception {
        properties.load(new FileInputStream("config/dbconfig.properties"));
        String url = properties.getProperty("url");
        return url;
    }

    public String getDataBaseUser() throws Exception {
        properties.load(new FileInputStream("config/dbconfig.properties"));
        String user = properties.getProperty("username");
        return user;
    }

    public String getDataBasePassword() throws Exception {
        properties.load(new FileInputStream("config/dbconfig.properties"));
        String password = properties.getProperty("password");
        return password;
    }
}
