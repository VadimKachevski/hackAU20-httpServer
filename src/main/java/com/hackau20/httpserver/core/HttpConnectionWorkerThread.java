package com.hackau20.httpserver.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackau20.httpserver.dbClass.users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HttpConnectionWorkerThread extends Thread {

    String clientSentence;
    String capitalizedSentence;
    private final  static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private  Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


        DataInputStream inputStream=null;
        DataOutputStream outputStream=null;
        try {

            DataInputStream inFromClient =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream outToClient =
                    new DataOutputStream(socket.getOutputStream());
           String clientWord = inFromClient.readUTF();
            System.out.println(clientWord);
           // String toClinet = "PLEASE WORK";
            ArrayList<users> usersAL = dbConnector.getTest();
//            for (users us :
//                    usersAL) {
//                outToClient.write(us.Json().getBytes());
//            }
            ObjectMapper mapper = new ObjectMapper();
            try {
                outToClient.write(mapper.writeValueAsString(usersAL).getBytes());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
           // outToClient.write(toClinet.getBytes());



        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(inputStream!=null) {
                try {
                    inputStream.close();
                    LOGGER.info("input stream Disconnected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null) {
                try {
                    outputStream.close();
                    LOGGER.info("output stream Disconnected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                    LOGGER.info("socket stream Disconnected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            LOGGER.info("Good Disconnected");
        }
    }
}
