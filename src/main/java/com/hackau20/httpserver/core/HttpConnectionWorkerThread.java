package com.hackau20.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {

    private final  static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private  Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


        InputStream inputStream=null;
        OutputStream outputStream=null;
        try {


            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

//            int _byte;
//
//            while( (_byte = inputStream.read()) >= 0)
//            {
//                System.out.print((char)_byte);
//            }



            LOGGER.info("Good Connected");
            // reading
            System.out.println("Connected ");
            // writing

            String anstest  ="{t1:123, t2:123} ";
            final String CRLF = "\n\r";


            String response = "HTTP/1.1 200 OK" + CRLF +
                    "Content-Length: " + anstest.getBytes().length + CRLF + CRLF + anstest + CRLF + CRLF; // TODO
            outputStream.write(anstest.getBytes());



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
