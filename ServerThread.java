package javaapplication;

class Thread_server extends Thread 
{ 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Server " + 
                  Thread.currentThread().getId() + 
                  " Thread is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 
  
// Main Class 
public class ServerThread 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<n; i++) 
        { 
            Thread_server object = new Thread_server(); 
            object.start(); 
        } 
    }
} 
