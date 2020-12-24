package com.codehacks.lab2;

import java.net.*;

public class Application {

    private ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        Application app = new Application();
        app.runServer();
    }

    public void runServer() throws Exception {
        System.out.println("Jerry's Server has started");
        serverSocket = new ServerSocket(8876);
        acceptRequests();
    }

    private void acceptRequests() throws Exception {
        while (true) {
            Socket socket = serverSocket.accept();
            ConnectionHandler handler = new ConnectionHandler(socket);
            handler.start();
        }
    }
}
