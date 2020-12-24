package com.codehacks.lab2;

import java.io.*;

public class HttpResponse {

    private HttpRequest request;
    private String response;
    private String root = "C:\\Users\\E238958\\Downloads\\Personals\\Code_experiment"; // root location for your web pages

    public HttpResponse(HttpRequest request) {
        this.request = request;
        File file = new File(root + request.getFileName());

        try {
            //To read the file for sending response
            FileInputStream fis = new FileInputStream(file);

            response = "HTTP/1.1 200 \r\n"; //version of http and 200 is status code which means all okay
            response += "Server: Our Java Server/1.0 \r\n";
            response += "Content-Type: text/html \r\n"; //response is in html format
            response += "Connection: close \r\n";
            response += "Content-Length: " + file.length() + " \r\n"; //length of response file
            response += "\r\n"; //after blank line we have to append file data

            int s;
            //Reading Html File..........
            while ((s = fis.read()) != -1) {
                response += (char) s;
            }
        } catch (FileNotFoundException e) {
            //If we do not get the file then error 404 
            response = response.replace("200", "404");
        } catch (Exception e) {
            //If any other error then 500 internal server error
            response = response.replace("200", "500");
        }
    }
    
    public String getResponse() {
        return response;
    }
    
    public HttpRequest getRequest() {
        return request;
    }
}
