
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class addemppanel extends JPanel implements ActionListener
{

    Connection conn;
    //conn with manager,conn2 with manage_employee
    Statement stmt;
    ResultSet rs;
    Manager_Home managerHome;

    public addemppanel(Manager_Home mh)
    {
        this.managerHome = mh;
        initComponents();
        paneladdbt.addActionListener(this);
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from manage_employee");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelnamelb = new javax.swing.JLabel();
        paneldeslb = new javax.swing.JLabel();
        panelphonelb = new javax.swing.JLabel();
        panelemaillb = new javax.swing.JLabel();
        panelnametf = new javax.swing.JTextField();
        paneldestf = new javax.swing.JTextField();
        panelphonetf = new javax.swing.JTextField();
        panelemailtf = new javax.swing.JTextField();
        paneladdbt = new javax.swing.JButton();

        setLayout(null);

        panelnamelb.setText("Name");
        add(panelnamelb);
        panelnamelb.setBounds(40, 40, 110, 30);

        paneldeslb.setText("Designation");
        add(paneldeslb);
        paneldeslb.setBounds(40, 100, 110, 30);

        panelphonelb.setText("Phone No.");
        add(panelphonelb);
        panelphonelb.setBounds(40, 160, 120, 30);

        panelemaillb.setText("email");
        add(panelemaillb);
        panelemaillb.setBounds(40, 220, 110, 30);
        add(panelnametf);
        panelnametf.setBounds(170, 40, 170, 30);
        add(paneldestf);
        paneldestf.setBounds(170, 100, 170, 30);
        add(panelphonetf);
        panelphonetf.setBounds(170, 160, 170, 30);
        add(panelemailtf);
        panelemailtf.setBounds(170, 220, 170, 30);

        paneladdbt.setText("ADD");
        paneladdbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paneladdbtActionPerformed(evt);
            }
        });
        add(paneladdbt);
        paneladdbt.setBounds(140, 290, 100, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void paneladdbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paneladdbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paneladdbtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton paneladdbt;
    private javax.swing.JLabel paneldeslb;
    private javax.swing.JTextField paneldestf;
    private javax.swing.JLabel panelemaillb;
    private javax.swing.JTextField panelemailtf;
    private javax.swing.JLabel panelnamelb;
    private javax.swing.JTextField panelnametf;
    private javax.swing.JLabel panelphonelb;
    private javax.swing.JTextField panelphonetf;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s1, s2, s3, s4;
        s1 = panelnametf.getText();
        s2 = paneldestf.getText();
        s3 = panelphonetf.getText();
        s4 = panelemailtf.getText();
        if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"ALL FIELDS ARE COMPULSORY");
        }
        else
        {
        try 
        {
            rs.moveToInsertRow();
            rs.updateString("emp_name", s1);
            rs.updateString("emp_designation", s2);
            rs.updateString("emp_phone", s3);
            rs.updateString("emp_email", s4);
            rs.updateString("password", "nothing");
            rs.insertRow();

            new Thread(managerHome.new employeetabledata()).start();
            //managerHome.tm.fireTableDataChanged();
            managerHome.d.dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    }
}
