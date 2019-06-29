

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.*;

public class FileServer
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket sersock=new ServerSocket(9000);
            System.out.println("Server started");
            
            Socket sock=sersock.accept();
            System.out.println("Connection Accepted");
            
            BufferedReader    brn=new BufferedReader(new InputStreamReader(sock.getInputStream()));
            DataOutputStream dos=new DataOutputStream(sock.getOutputStream());
            
            File f=new File("c:\\my data2\\world.mp3");
            FileInputStream   fis=new FileInputStream(f);
            
            byte b[]=new byte[10000];
            long count=0,filesize=f.length();
            int r;
            
            //receive send file message
            String req=brn.readLine();
            
            //send info about file
            dos.writeBytes("sending file\r\n");
            dos.writeLong(filesize);
            dos.writeBytes(f.getName()+"\r\n");
            
            //send actual file
            while(true)
            {
                r=fis.read(b,0,10000);
                count=count+r;
                dos.write(b,0,r);
                
                if(count==filesize)
                {
                    break;
                }             
            }
            
            fis.close();
            //dos.close();
            
            System.out.println("File Sent Successfully");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
