package javaapplication;

import java.net.*;
import java.io.*;

public class SocketServer 
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       = null;
    private Room            room     = null;

    // constructor with port
    public SocketServer(int port)
    {
        // starts server and waits for a connection
        try
        {
            room=new Room();
            server = new ServerSocket(port);
            System.out.println("Server started");
            for(int ind=0;ind<2;ind++){
                System.out.println("Waiting for a client ...");

                socket = server.accept();
                room.addClient(socket);
                System.out.println("Client accepted");

                // takes input from the client socket
                in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

                String line = "";

                // reads message from client until "Over" is sent
                while (!line.equals("Over"))
                {
                    try
                    {
                        line = in.readUTF();
                        System.out.println(line);

                    }
                    catch(IOException i)
                    {
                        System.out.println(i);
                    }
                }
                System.out.println("Closing connection");
                // close connection
                socket.close();
            }
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        SocketServer server = new SocketServer(1234);
    }
}
