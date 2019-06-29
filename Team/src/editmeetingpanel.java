
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;


public class editmeetingpanel extends JPanel 
{
    Manager_Home mh;
    
    Connection  conn;
    Statement stmt;
    ResultSet  rs;
    int selrow;
    String phno;
    String employeefieldmeeting;
    
    public editmeetingpanel(Manager_Home m,int i)
    {
       initComponents();
      
       
            
           
       selrow=i;
       mh=m;
       String pno[];
       editmeetingsavebt.addActionListener(new editmeetingsaveListener());
       try
       {
           manage_meetings meeting=mh.al2.get(i);
       
       Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
               stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               rs = stmt.executeQuery("select * from meeting where mid='"+meeting.mid+"'");
                if(rs.next())
                        {
                            phno=rs.getString("employees");
                        }
                StringTokenizer st=new StringTokenizer(phno,",");
                int count=st.countTokens();
                pno=new String[count];
                for(int j=0;j<count;j++)
                {
                    
                   pno[j]=st.nextToken();
                        
                }
                int s[]=new int[count];
                for(int k=0;k<count;k++)
                {
                    Employee e=new Employee();
                    if(e.phone_no==pno[k])
                    {
                         s[k]=mh.al.indexOf(e);
                    }
                    
                }
                editmeetingtitletf.setText(meeting.title);
                editmeetingdesta.setText(meeting.description);
                
                
               String a[]=new String[mh.al.size()];
               for(int j=0;j<mh.al.size();j++)
               {
                     a[j]=mh.al.get(j).name;
               }
       
            
           editmeetingemployeeslt.setListData(a);
           editmeetingemployeeslt.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
           editmeetingemployeeslt.setSelectedIndices(s);
           
           
                
    }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editmeetingtitlelb = new javax.swing.JLabel();
        editmeetingdeslb = new javax.swing.JLabel();
        editmeetingemployeeslb = new javax.swing.JLabel();
        editmeetingdatetimelb = new javax.swing.JLabel();
        editmeetingtitletf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        editmeetingdesta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        editmeetingemployeeslt = new javax.swing.JList<>();
        editmeetingdatetimespinner = new javax.swing.JSpinner(new SpinnerDateModel());
        editmeetingsavebt = new javax.swing.JButton();
        editmeetingcancelbt = new javax.swing.JButton();

        setLayout(null);

        editmeetingtitlelb.setText("Title");
        add(editmeetingtitlelb);
        editmeetingtitlelb.setBounds(70, 40, 180, 30);

        editmeetingdeslb.setText("Description");
        add(editmeetingdeslb);
        editmeetingdeslb.setBounds(70, 100, 180, 30);

        editmeetingemployeeslb.setText("Employees");
        add(editmeetingemployeeslb);
        editmeetingemployeeslb.setBounds(70, 230, 180, 30);

        editmeetingdatetimelb.setText("Date_time");
        add(editmeetingdatetimelb);
        editmeetingdatetimelb.setBounds(70, 390, 180, 30);
        add(editmeetingtitletf);
        editmeetingtitletf.setBounds(270, 40, 210, 30);

        editmeetingdesta.setColumns(20);
        editmeetingdesta.setRows(5);
        jScrollPane1.setViewportView(editmeetingdesta);

        add(jScrollPane1);
        jScrollPane1.setBounds(270, 100, 210, 100);

        editmeetingemployeeslt.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(editmeetingemployeeslt);

        add(jScrollPane2);
        jScrollPane2.setBounds(270, 230, 170, 130);
        add(editmeetingdatetimespinner);
        editmeetingdatetimespinner.setBounds(270, 390, 210, 30);

        editmeetingsavebt.setText("Save");
        editmeetingsavebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editmeetingsavebtActionPerformed(evt);
            }
        });
        add(editmeetingsavebt);
        editmeetingsavebt.setBounds(160, 450, 90, 40);

        editmeetingcancelbt.setText("Cancel");
        editmeetingcancelbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editmeetingcancelbtActionPerformed(evt);
            }
        });
        add(editmeetingcancelbt);
        editmeetingcancelbt.setBounds(290, 450, 90, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void editmeetingsavebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editmeetingsavebtActionPerformed
         int ans;
            { 
                ans=JOptionPane.showConfirmDialog(editmeetingpanel.this, "Are You Sure You Want To Edit","warning",JOptionPane.YES_NO_CANCEL_OPTION);
                
            }
            
                 try
                
            {
                if(ans==JOptionPane.YES_OPTION)
                { Connection conn;
                Statement stmt;
                 ResultSet rs;
            
        
            
            
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs=stmt.executeQuery("select * from meeting");
                        if(rs.next())
                                {
                                   
                                     int n[]=editmeetingemployeeslt.getSelectedIndices();
                                 if(n.length==0)
                                 {
                                    JOptionPane.showMessageDialog(editmeetingpanel.this,"PLEASE SELECT EMPLOYEES FROM LIST"); 
                                    }
                                 else
                                 {
                                      rs.updateString("title",editmeetingtitletf.getText());
                                   rs.updateString("description",editmeetingdesta.getText());
                                   
                                  String s=new String();
                                  
                                   for(int j=0;j<n.length;j++)
                                {
                                     s=s+mh.al.get(n[j]).phone_no+",";
                                }
                                 
                                   rs.updateString("employees",s);
                                   rs.updateString("date_time",editmeetingdatetimespinner.getValue().toString());
                                   rs.updateRow(); 
                                   new Thread(mh.new meetingtabledata()).start();
                                   JOptionPane.showMessageDialog(editmeetingpanel.this,"Data Edited Successfully");
                                    
                                    mh.d4.dispose();
                                }
                                }
            }
            }
            
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
    
            
    
    }//GEN-LAST:event_editmeetingsavebtActionPerformed

    private void editmeetingcancelbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editmeetingcancelbtActionPerformed
        mh.d4.dispose();
    }//GEN-LAST:event_editmeetingcancelbtActionPerformed


    class editmeetingsaveListener implements ActionListener
            {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
        }
                
            }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editmeetingcancelbt;
    private javax.swing.JLabel editmeetingdatetimelb;
    private javax.swing.JSpinner editmeetingdatetimespinner;
    private javax.swing.JLabel editmeetingdeslb;
    private javax.swing.JTextArea editmeetingdesta;
    private javax.swing.JLabel editmeetingemployeeslb;
    private javax.swing.JList<String> editmeetingemployeeslt;
    private javax.swing.JButton editmeetingsavebt;
    private javax.swing.JLabel editmeetingtitlelb;
    private javax.swing.JTextField editmeetingtitletf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
