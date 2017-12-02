package com.mycompany.app;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Source:
// https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
public class EchoClient {

    public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println( "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
        try (
            Socket s = new Socket(hostName, portNumber);
            // For writing to the socket (sent over channel to server)
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            // For reading from the socket (what's received from server)
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // For reading user input from stdin
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                // Write a line of user input to the socket
                printMsg("sending: " + userInput);
                out.println(userInput);
                // Wait for the response from the server, and print it
                printMsg("receiving: " + in.readLine() + "\n");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } 
    }


    private static void printMsg(String msg) {
        System.out.println(ts() + ": " + msg);
    }
    private static long ts() {
        return System.currentTimeMillis() / 1000L;
    }
}
