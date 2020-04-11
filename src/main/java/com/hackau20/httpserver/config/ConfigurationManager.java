package com.hackau20.httpserver.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.hackau20.httpserver.util.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myConf;
    private ConfigurationManager()
    {

    }
    public static ConfigurationManager getInstance()
    {
        if(myConfigurationManager == null)
        {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     * Used to load configuration file
     * @param filePath
     */
    public void loadConfFile(String filePath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new httpConfigurationException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        while(true)
        {
            try {
                if (!((i = fileReader.read() ) != -1)) break;
            } catch (IOException e) {
                throw new httpConfigurationException(e);
            }
            sb.append((char)i);
        }
        JsonNode conf = null;
        try {
            conf = json.parse((sb.toString()));
        } catch (JsonProcessingException e) {
            throw new httpConfigurationException("error parsing the configuraion file", e);
        }
        try {
            myConf = json.fromJson(conf,Configuration.class);
        } catch (JsonProcessingException e) {
            throw new httpConfigurationException("error parsing the configuraion file internal", e);
        }
    }

    /**
     * returns the current configuration
     */
    public Configuration getCurrentConfiguration()
    {
    if(myConf == null)
    {
        throw new httpConfigurationException("no current configuration");
    }
    return myConf;
    }


}
