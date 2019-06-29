
import java.awt.event.*;
import java.sql.*;

public class editemppanel extends javax.swing.JPanel 
{
      Manager_Home m;
      Employee emp;
   
    public editemppanel(Manager_Home mh,Employee e) 
    {
         m=mh;
         emp=e;
        initComponents();
        editempnametf.setText(e.name);
        editempdestf.setText(e.designation);
        editempphonetf.setText(e.phone_no);
        editempemailtf.setText(e.email);
        
        
        savebt.addActionListener(new save());
        cancelbt.addActionListener(new save());
    }
    class save implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==savebt)
            { 
                Connection conn;
                Statement stmt;
                 ResultSet rs;
            
        
            try
            {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs=stmt.executeQuery("select * from manage_employee where emp_phone='"+emp.phone_no+"'");
                        if(rs.next())
                                {
                                    rs.updateString("emp_name",editempnametf.getText());
                                   rs.updateString("emp_designation",editempdestf.getText());
                                   rs.updateString("emp_phone",editempphonetf.getText());
                                   rs.updateString("emp_email",editempemailtf.getText());
                                   rs.updateRow(); 
                                   new Thread(m.new employeetabledata()).start();
                                    m.d2.dispose();
                                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
    }
            else if(e.getSource()==cancelbt)
            {
                m.d2.dispose();
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editempnamelb = new javax.swing.JLabel();
        editempdeslb = new javax.swing.JLabel();
        editempphonelb = new javax.swing.JLabel();
        editempemaillb = new javax.swing.JLabel();
        savebt = new javax.swing.JButton();
        cancelbt = new javax.swing.JButton();
        editempnametf = new javax.swing.JTextField();
        editempdestf = new javax.swing.JTextField();
        editempphonetf = new javax.swing.JTextField();
        editempemailtf = new javax.swing.JTextField();

        setLayout(null);

        editempnamelb.setText("Name");
        add(editempnamelb);
        editempnamelb.setBounds(50, 40, 140, 30);

        editempdeslb.setText("Designation");
        add(editempdeslb);
        editempdeslb.setBounds(50, 90, 140, 30);

        editempphonelb.setText("Phone No.");
        add(editempphonelb);
        editempphonelb.setBounds(50, 140, 130, 30);

        editempemaillb.setText("email");
        add(editempemaillb);
        editempemaillb.setBounds(50, 190, 130, 30);

        savebt.setText("Save");
        add(savebt);
        savebt.setBounds(100, 270, 100, 40);

        cancelbt.setText("Cancel");
        add(cancelbt);
        cancelbt.setBounds(220, 270, 100, 40);
        add(editempnametf);
        editempnametf.setBounds(200, 40, 160, 30);
        add(editempdestf);
        editempdestf.setBounds(200, 90, 160, 30);
        add(editempphonetf);
        editempphonetf.setBounds(200, 140, 160, 30);
        add(editempemailtf);
        editempemailtf.setBounds(200, 190, 160, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbt;
    private javax.swing.JLabel editempdeslb;
    private javax.swing.JTextField editempdestf;
    private javax.swing.JLabel editempemaillb;
    private javax.swing.JTextField editempemailtf;
    private javax.swing.JLabel editempnamelb;
    private javax.swing.JTextField editempnametf;
    private javax.swing.JLabel editempphonelb;
    private javax.swing.JTextField editempphonetf;
    private javax.swing.JButton savebt;
    // End of variables declaration//GEN-END:variables

    }