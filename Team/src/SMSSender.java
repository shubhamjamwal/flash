

import java.net.*;
import java.io.*;
import java.sql.*;

public class SMSSender implements Runnable
{

    Socket sock;
    BufferedReader br, brn;
    InputStreamReader ins;
    PrintWriter pw;
    String s;
    int n;
    char ch[];
    String mobno;
    String msg;
    Statement stmt;
    ResultSet rs;

    String a1[] =
    {
        " ", "?", "!", "(", ")", "*", "&", "@", "+", "_", ";", ":", ",", "\'", "=", "$", "#", "<", ">", "."
    };
    String a2[] =
    {
        "%20", "%3F", "%21", "%28", "%29", "%2A", "%26", "%40", "%2B", "%5F", "%3B", "%3A", "%2C", "%60", "%3D", "%24", "%23", "%3C", "%3E", "%2E"
    };
    Thread t;
    String msgtype;

    public SMSSender(String mobilenumber, String message, String type)
    {
        mobno = mobilenumber;
        msg = message;
        msgtype = type;
    }

    public void run()
    {
        try
        {
            msg = msg.replace("%", "%25");
            for (int i = 0; i < a1.length; i++)
            {
                msg = msg.replace(a1[i], a2[i]);
            }
            System.out.println(msg);
            sock = new Socket("enterprise.smsgupshup.com", 80);
            pw = new PrintWriter(sock.getOutputStream());
            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            pw.println("Get /GatewayAPI/rest?method=SendMessage&send_to=" + mobno + "&msg=" + msg + "&msg_type=" + msgtype
                    + "&userid=2000036319&auth_scheme=plain&password=vsssmsserver&v=1.1&format=text HTTP/1.1");

//      sock=new Socket("sms.hypecreationz.com",80);
//    pw=new PrintWriter(sock.getOutputStream());
//    br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
//    pw.println("Get /vendorsms/pushsms.aspx?user=VMMEDU&password=123456@&msisdn=9646860043&sid=VMMEDU&msg=test%20message&fl=0 HTTP/1.1");
            pw.flush();
            pw.println("Accept: text/plain");
            pw.flush();
            pw.println("Accept-Language: en-us");
            pw.flush();
            pw.println("User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
            pw.flush();
            pw.println("Host: enterprise.smsgupshup.com");
            pw.flush();
            pw.println("Connection: Close");
            pw.flush();
            pw.println();
            pw.flush();

            while (true)
            {
                s = br.readLine();
                if (s.equals(""))
                {
                    break;
                }
                System.out.println(s);
                if (s.indexOf("Content-Length") != -1)
                {
                    n = Integer.parseInt(s.substring(16));
                }
            }
            ch = new char[n];
            br.read(ch, 0, n);
            System.out.println(ch);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        SMSSender obj = new SMSSender("8847480788", "hello this is test message !!!", "text");
        Thread t = new Thread(obj);
        t.start();
    }
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt;
    private javax.swing.JTextArea jta;
    private javax.swing.JTextField jtf;
    private javax.swing.JLabel response;
}
