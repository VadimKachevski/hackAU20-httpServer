package com.hackau20.httpserver;

import com.hackau20.httpserver.config.Configuration;
import com.hackau20.httpserver.config.ConfigurationManager;
import com.hackau20.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class httpServer {

    private final  static Logger LOGGER = LoggerFactory.getLogger(httpServer.class);

    public static void main(String[] args) {
        System.out.println("Server starting...");
        LOGGER.info("Server Starting");
        ConfigurationManager.getInstance().loadConfFile("src/main/resources/http.json");

        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using port:" + conf.getPort() );
        LOGGER.info("Using port:" + conf.getPort() );
        System.out.println("Using WebRoot:" + conf.getWebroot() );
        LOGGER.info("Using WebRoot:" + conf.getWebroot() );
        try
        {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
