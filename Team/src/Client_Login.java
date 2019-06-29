
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client_Login extends JFrame 
{

    
    DataOutputStream dos;
    DataInputStream dis;
    public Client_Login() 
    {
        initComponents();
        setSize(500, 500);
        clientloginbt.addActionListener(new clientloginListener());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientphonelb = new javax.swing.JLabel();
        clientpasswordlb = new javax.swing.JLabel();
        clientloginbt = new javax.swing.JButton();
        clientloginlb = new javax.swing.JLabel();
        clientpasswordpf = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        clientphonelb.setText("Phone No.");
        getContentPane().add(clientphonelb);
        clientphonelb.setBounds(80, 80, 80, 30);

        clientpasswordlb.setText("Password");
        getContentPane().add(clientpasswordlb);
        clientpasswordlb.setBounds(80, 130, 80, 30);

        clientloginbt.setText("Login");
        clientloginbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientloginbtActionPerformed(evt);
            }
        });
        getContentPane().add(clientloginbt);
        clientloginbt.setBounds(130, 200, 80, 40);

        clientloginlb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clientloginlb.setText("   USER LOGIN");
        getContentPane().add(clientloginlb);
        clientloginlb.setBounds(110, 20, 130, 30);
        getContentPane().add(clientpasswordpf);
        clientpasswordpf.setBounds(180, 130, 130, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 80, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientloginbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientloginbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientloginbtActionPerformed

    class clientloginListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String phno = jTextField1.getText();
            String password = clientpasswordpf.getText();
            
            
            
            if (password.isEmpty() || phno.isEmpty())
            {
                JOptionPane.showMessageDialog(Client_Login.this, "COMPULSORY FIELDS");
            }
            else
            {

                try {
                    Socket sock = new Socket(GlobalClass.ipAddress, 7500);
                    dos = new DataOutputStream(sock.getOutputStream());
                    dis = new DataInputStream(sock.getInputStream());
                    dos.writeBytes("Login Request\r\n");
                    dos.writeBytes(phno + "\r\n");
                    dos.writeBytes(password + "\r\n");
                    dos.flush();
                    String servermsg=dis.readLine();
                    System.out.println(servermsg);
                    if(servermsg.equals("Login Successful"))
                    {
                        JOptionPane.showMessageDialog(Client_Login.this,"LOGIN SUCCESSFUL!!!");
                        dispose();
                        new Client_Home(sock);
                        File f=new File("C://Employee");
                        if(!f.exists())
                        {
                            System.out.println(f.mkdir());
                        }
                        Thread t=new Thread(new FileReceiver(f));
                        t.start();
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(Client_Login.this,"INVALID PHONE NO.OR PASSWORD ");
                    }
                    System.out.println("Sent " + phno + "   " + password);
                    
                }  

               
                
       
                
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }

            }

        }

    }
    
    class FileReceiver implements Runnable
    {

         File file;
         
        FileReceiver(File f1)
        {
          file=f1;
        }
        
        
        @Override
        public void run() 
        {
           try
               
           {
               ServerSocket sersock=new ServerSocket(9000);
           
             System.out.println("File Receiver Started");
                    
            while(true)
         {
               
            Socket sock=sersock.accept();
            PrintWriter pw=new PrintWriter(sock.getOutputStream());
            DataInputStream dis=new DataInputStream(sock.getInputStream());
            
            String res;
            long filesize;
            String filename;
            
            
           
            
            res=dis.readLine();        //sending file
            filesize=dis.readLong();   //12345678            
            filename=dis.readLine();   //world.mp3
            
            FileOutputStream fos=new FileOutputStream(file.getPath());
            
            int r;
            byte b[]=new byte[10000];
            long count=0;
            
            while(true)
            {
                r=dis.read(b,0,10000);
                fos.write(b,0,r);
                count=count+r;
                
                if(count==filesize)
                {
                    break;
                }
            }
                
            }
           }
                
                
              
            
           
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            
            
        }
        
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientloginbt;
    private javax.swing.JLabel clientloginlb;
    private javax.swing.JLabel clientpasswordlb;
    private javax.swing.JPasswordField clientpasswordpf;
    private javax.swing.JLabel clientphonelb;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
