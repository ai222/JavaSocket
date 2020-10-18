package javaapplication;
import java.net.*;

public class Room {
    Socket client1;
    Socket client2;
    static int count=0;
    char [][]message;
    static int index=0;
    Room(){
        client1=null;
        client2=null;
        message=new char[100][100];
    }
    void addClient(Socket c){
        count++;
        if(count==1){
            client1=c;
        }
        else if(count==2){
            client2=c;
        }
    }
    void sendMessage(char []msg){
        message[index++] = msg;
    }
}
