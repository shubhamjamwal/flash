
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;

public class addmeetingpanel extends javax.swing.JPanel
{
    Manager_Home mh;
    
    public addmeetingpanel(Manager_Home m) 
    {
        mh=m;
        
        initComponents();
       
        String s[]=new String[mh.al.size()];
        for(int i=0;i<mh.al.size();i++)
        {
             s[i]=mh.al.get(i).name;
        }
       
       
           addmeetingemployeeslt.setListData(s);
           addmeetingemployeeslt.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       
        addmeetingaddbt.addActionListener(new addmeetingaddListener());
        addmeetingcancelbt.addActionListener(new addmeetingaddListener());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addmeetingtitlelb = new javax.swing.JLabel();
        addmeetingdeslb = new javax.swing.JLabel();
        addmeetingtitletf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addmeetingdesta = new javax.swing.JTextArea();
        addmeetingemployeeslb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addmeetingemployeeslt = new javax.swing.JList<>();
        addmeetingdatetimespinner = new JSpinner(new SpinnerDateModel());
        addmeetingdatetimelb = new javax.swing.JLabel();
        addmeetingaddbt = new javax.swing.JButton();
        addmeetingcancelbt = new javax.swing.JButton();

        setLayout(null);

        addmeetingtitlelb.setText("Title");
        add(addmeetingtitlelb);
        addmeetingtitlelb.setBounds(60, 30, 110, 30);

        addmeetingdeslb.setText("Description");
        add(addmeetingdeslb);
        addmeetingdeslb.setBounds(53, 90, 120, 30);
        add(addmeetingtitletf);
        addmeetingtitletf.setBounds(190, 30, 180, 30);

        addmeetingdesta.setColumns(20);
        addmeetingdesta.setRows(5);
        jScrollPane1.setViewportView(addmeetingdesta);

        add(jScrollPane1);
        jScrollPane1.setBounds(190, 90, 180, 96);

        addmeetingemployeeslb.setText("Employees");
        add(addmeetingemployeeslb);
        addmeetingemployeeslb.setBounds(60, 220, 120, 30);

        addmeetingemployeeslt.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(addmeetingemployeeslt);

        add(jScrollPane2);
        jScrollPane2.setBounds(190, 220, 180, 130);
        add(addmeetingdatetimespinner);
        addmeetingdatetimespinner.setBounds(190, 380, 170, 30);

        addmeetingdatetimelb.setText("Date_Time");
        add(addmeetingdatetimelb);
        addmeetingdatetimelb.setBounds(60, 384, 100, 20);

        addmeetingaddbt.setText("Add");
        add(addmeetingaddbt);
        addmeetingaddbt.setBounds(80, 450, 110, 40);

        addmeetingcancelbt.setText("Cancel");
        add(addmeetingcancelbt);
        addmeetingcancelbt.setBounds(230, 450, 100, 40);
    }// </editor-fold>//GEN-END:initComponents

    class addmeetingaddListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==addmeetingaddbt)
            {
                String s=new String();
                int n[]=addmeetingemployeeslt.getSelectedIndices();
                
               
                for(int j=0;j<n.length;j++)
            {
                s=s+mh.al.get(n[j]).phone_no+",";
            }
            if(n.length==0)
            {
               JOptionPane.showMessageDialog(addmeetingpanel.this,"PLEASE SELECT EMPLOYEES FROM LIST"); 
            }
            else
            {
                
            try
            {

                Connection  conn;
                //conn with manager,conn2 with manage_employee
                Statement stmt;
                ResultSet  rs,rs2;

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs=stmt.executeQuery("select * from meeting");
               if(!(addmeetingtitletf.getText().isEmpty()||addmeetingdesta.getText().isEmpty()||addmeetingdatetimespinner.getValue().toString().isEmpty()))
               { 
                   rs.moveToInsertRow();
                   rs.updateString("title",addmeetingtitletf.getText() );
                   rs.updateString("description",addmeetingdesta.getText());
                   rs.updateString("employees",s);
                   rs.updateString("date_time",addmeetingdatetimespinner.getValue().toString());
                   rs.insertRow();
                   int arr[]=addmeetingemployeeslt.getSelectedIndices();
                   String phno[]=new String[arr.length];
                   for(int i=0;i<arr.length;i++)
                   {
                        phno[i]=mh.al.get(arr[i]).phone_no;
                   }
                   String password=new String();
                   for(int j=0;j<arr.length;j++)
                   {
                       char a=(char)(65+26*Math.random());
                       int k= (int)(1000+8999*Math.random());
                       char b=(char)(97+26*Math.random());
                       
                       password = a+""+k+""+b;
                       
                       new SMSSender(phno[j],"Meeting Alert..topic: "+addmeetingtitletf.getText()+"and your password for this meeting is "+password,"text");
                       rs2=stmt.executeQuery("select * from manage_employee where emp_phone='"+phno[j]+"'");
                       if(rs2.next())
                       {
                           rs2.updateString("password",password);
                           rs2.updateRow();
                       }
                   }
                   new Thread( mh.new meetingtabledata()).start();
                   mh.d3.dispose();
            }
            
               else
               {
                   JOptionPane.showMessageDialog(addmeetingpanel.this,"ALL FIELDS ARE COMPULSORY");
               }
               
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
            
        
    }
            else if(e.getSource()==addmeetingcancelbt)
            {
                mh.d3.dispose();
            }
        
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addmeetingaddbt;
    private javax.swing.JButton addmeetingcancelbt;
    private javax.swing.JLabel addmeetingdatetimelb;
    private javax.swing.JSpinner addmeetingdatetimespinner;
    private javax.swing.JLabel addmeetingdeslb;
    private javax.swing.JTextArea addmeetingdesta;
    private javax.swing.JLabel addmeetingemployeeslb;
    private javax.swing.JList<String> addmeetingemployeeslt;
    private javax.swing.JLabel addmeetingtitlelb;
    private javax.swing.JTextField addmeetingtitletf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
