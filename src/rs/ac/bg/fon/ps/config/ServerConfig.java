/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandr
 */
public class ServerConfig {
    private static ServerConfig instance;
    private File serverConfigFile;
    Properties properties;

    private ServerConfig() {
        //serverConfigFile = new File("config/serverconfig.properties");
        serverConfigFile = new File("D:\\java projects\\myProjectServer\\config\\serverconfig.properties");
        properties = new Properties();
    }

    public static ServerConfig getInstance() {
        if (instance == null) {
            instance = new ServerConfig();
        }
        return instance;
    }

    public void postaviPodesavanja(String port) throws Exception{
        
        FileOutputStream fos = new FileOutputStream("D:\\java projects\\myProjectServer\\config\\serverconfig.properties");
     
        properties.setProperty("port", port);
     
        properties.store(fos, "Properties file generated from Java program");
        fos.close();
    }
    public boolean getFileExists(){
        return serverConfigFile.exists();
    }
    
    public String getServerPort() throws FileNotFoundException, IOException {
        properties.load(new FileInputStream("D:\\java projects\\myProjectServer\\config\\serverconfig.properties"));
        String port = properties.getProperty("port");
        return port;
    }
    
    public void setServerPort() {
        
    }

}
