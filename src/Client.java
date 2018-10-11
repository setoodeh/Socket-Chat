import java.io.*;
import java.net.*;
public class Client
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("192.168.1.103", 8000);
     // reading from keyboard 
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     // sending to server (write object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
     // receiving from server ( receiveRead  object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

     System.out.println("Start the chitchat, type and press Enter key");

     String receiveMessage, sendMessage;               
     while(true)
     {
    	 // reading input massage
        sendMessage = keyRead.readLine();  
        // sending to server
        pwrite.println(sendMessage);    
        // flush the data
        pwrite.flush();                 
        if((receiveMessage = receiveRead.readLine()) != null) 
        {
            System.out.println(receiveMessage);
        }         
      }               
    }                    
}                        