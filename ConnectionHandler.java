package com.codehacks.lab2;

import java.io.*;
import java.net.*;

public class ConnectionHandler extends Thread {

    private Socket s;
    private PrintWriter pw;
    private BufferedReader br;

    public ConnectionHandler(Socket s) throws Exception {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String requestString = "";

            while (br.ready() || requestString.length() == 0) {
                requestString += (char) br.read();
            }
            System.out.println(requestString);

            //Passing the request String to Request class for processing
            HttpRequest request = new HttpRequest(requestString);

            //Sending Request Object to HttpResponse Class
            HttpResponse response = new HttpResponse(request);

            //write the final output to pw
            pw.write(response.getResponse().toCharArray());

            pw.close();
            br.close();
            s.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
