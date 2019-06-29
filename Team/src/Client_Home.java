
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Client_Home extends javax.swing.JFrame {

    Socket sock = new Socket();
    DataOutputStream dos;
    DataInputStream dis;

    public Client_Home(Socket s) {
        this.sock = s;

        initComponents();
        Thread t = new Thread(new fetchscreenjob());
        t.start();
        setSize(500, 500);

        Thread t1 = new Thread(new FileReceiver());
        t1.start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int ans = JOptionPane.showConfirmDialog(Client_Home.this, "You are going to exit the live screen,are you sure to exit");
                if (ans == JOptionPane.YES_OPTION) {

                    try {
                        dos.writeBytes("exit\r\n");
                        dos.flush();
                        dispose();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        setVisible(true);
        setTitle("Client_Home");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clienthomelb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jScrollPane1.setViewportView(clienthomelb);

        getContentPane().add(jScrollPane1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class FileReceiver implements Runnable {

        File f;

        FileReceiver() 
        {
            f = new File(System.getProperty("user.home") + "\\test");

            if (!f.exists()) {
                f.mkdir();
            }

        }

        @Override
        public void run() {
            try {
                ServerSocket sersock = new ServerSocket(7000);

                System.out.println("File Receiver Started");

                while (true) {

                    Socket sock = sersock.accept();
                    PrintWriter pw = new PrintWriter(sock.getOutputStream());
                    DataInputStream dis = new DataInputStream(sock.getInputStream());

                    String res;
                    long filesize;
                    String filename;

                    res = dis.readLine();        //sending file
                    filesize = dis.readLong();   //12345678            
                    filename = dis.readLine();   //world.mp3

                    FileOutputStream fos = new FileOutputStream(f.getPath()+"\\"+filename);

                    int r;
                    byte b[] = new byte[10000];
                    long count = 0;

                    while (true)
                    {
                        r = dis.read(b, 0, 10000);
                        fos.write(b, 0, r);
                        count = count + r;

                        if (count == filesize)
                        {
                            break;
                        }
                    }
                    pw.write("File Received\r\n");
                    pw.flush();

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    /////////inner class//////
    class fetchscreenjob implements Runnable {

        @Override
        public void run() {

            try {
                dos = new DataOutputStream(sock.getOutputStream());
                dis = new DataInputStream(sock.getInputStream());

                while (true) {
                    long count = 0;

                    byte b[] = new byte[10000];

                    long size = dis.readLong();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    while (true) {
                        int r = dis.read(b, 0, b.length);
                        count = count + r;
                        baos.write(b, 0, r);
                        if (count == size) {

                            break;
                        }
                    }
                    dos.writeBytes("file received\r\n");
                    dos.flush();
                    byte[] imagedata = baos.toByteArray();
                    ImageIcon icon = new ImageIcon(imagedata);
                    clienthomelb.setIcon(icon);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    /////////////////////////
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clienthomelb;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
