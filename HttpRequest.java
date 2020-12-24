package com.codehacks.lab2;

public class HttpRequest {

    private String filename;

    public HttpRequest(String request) {
        //First level spliting
        String lines[] = request.split("\n");
        System.out.println(lines[0]);

        //Second level Splitting
        filename = lines[0].split(" ")[1];
        System.out.println(filename);
    }
    
    public String getFileName() {
        return filename;
    }
}
