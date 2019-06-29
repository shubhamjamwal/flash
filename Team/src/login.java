
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class login extends JFrame
{
    
    Connection conn;
    ResultSet rs;
    Statement stmt;
    
    public login() 
    {
        initComponents();
        
        login.addActionListener(new mylistener());
        try
        {     
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting","root","system");
        stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        setSize(600,500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        p1 = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        mlb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Login");
        getContentPane().setLayout(null);

        email.setText("email");
        getContentPane().add(email);
        email.setBounds(75, 74, 70, 30);

        Password.setText("Password");
        getContentPane().add(Password);
        Password.setBounds(74, 144, 70, 30);

        tf1.setText("pratikshagautam011@gmail.com");
        getContentPane().add(tf1);
        tf1.setBounds(170, 80, 250, 30);
        getContentPane().add(p1);
        p1.setBounds(170, 140, 250, 30);

        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(230, 233, 120, 50);

        mlb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mlb.setText("    MANAGER LOGIN");
        getContentPane().add(mlb);
        mlb.setBounds(200, 10, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    class mylistener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
        {
            String s1,s2;
            s1=tf1.getText();
            s2=new String(p1.getPassword());
            
            rs=stmt.executeQuery("select email,password from manager where email='"+s1+"'and password='"+s2+"'");
           // rs=stmt.executeQuery("select email,password from manager where email='shwetagautam@gmail.com'and password='123456'");
            
            //****************************//
            if(rs.next())
            {
                JOptionPane.showMessageDialog( login.this,"Login Successful!!!");
                dispose();
                new Manager_Home(s1).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(login.this,"Login Failed!!!");
            } 
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
           
        }
    }
    public static void main(String args[]) 
    {
      //  login obj=new login();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JLabel email;
    private javax.swing.JButton login;
    private javax.swing.JLabel mlb;
    private javax.swing.JPasswordField p1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables


}
