
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.*;

public class Manager_Home extends JFrame
{
    boolean startstopflag=false;
    boolean startstopsendingflag=false;
    boolean loginstatusflag=false;
    
    String email;
    JDialog d, d2, d3, d4;
    ArrayList<Employee> al = new ArrayList<>();
    ArrayList<manage_meetings> al2 = new ArrayList<>();
    meetingtabledatamodel tm2;
    employeetablemodel tm;
    meetingservertablemodel tm3;
    
    ClientHandler ch;
    MeetingServer meetingserver;
    
    JFileChooser jfc;
    
    

    
    ArrayList<ClientHandler> cl=new ArrayList<>();

    

//    public Manager_Home() {
//        tm = new tablemodel();
//
//        initComponents();
//        addempbt.addActionListener(new addempbtlistener());
//        emptable.setModel(tm);
//
//        
//
//        setSize(Toolkit.getDefaultToolkit().getScreenSize());
//    }
    public Manager_Home(String e)
    {
        tm = new employeetablemodel();
        tm2 = new meetingtabledatamodel();
        tm3=new meetingservertablemodel();
        
        initComponents();
        
        meetingserver=new MeetingServer();
        emptable.setModel(tm);
        
        meetingtable.setModel(tm2);
        meetingservertable.setModel(tm3);
        change.addActionListener(new changebtListener());
        deletebt.addActionListener(new deletebtListener());
        addempbt.addActionListener(new addempbtlistener());
        editempbt.addActionListener(new editempbtListener());
        meetingaddbt.addActionListener(new meetingaddListener());
        meetingdeletebt.addActionListener(new meetingdeleteListener());
        meetingdeleteallbt.addActionListener(new meetingdeleteallListener());
        meetingeditbt.addActionListener(new meetingeditListener());
        meetingserverstartbt.addActionListener(new meetingserverstartListener());
       
        
     
        
        new Thread(new employeetabledata()).start();
        new Thread(new meetingtabledata()).start();
        
        jfc=new JFileChooser("C://");

       // filebrowsebt.add(jfc);     
        

        email = e;
//        try {
//
//            new tabledata();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        setSize(700,700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startmeetingsendfilepanel = new javax.swing.JTabbedPane();
        changepwtb = new javax.swing.JPanel();
        opasslb = new javax.swing.JLabel();
        nwpasslb = new javax.swing.JLabel();
        conpasslb = new javax.swing.JLabel();
        opasspf = new javax.swing.JPasswordField();
        nwpasstf = new javax.swing.JTextField();
        conpasstf = new javax.swing.JTextField();
        change = new javax.swing.JButton();
        changepasslb = new javax.swing.JLabel();
        emptb = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emptable = new javax.swing.JTable();
        addempbt = new javax.swing.JButton();
        deletebt = new javax.swing.JButton();
        editempbt = new javax.swing.JButton();
        manageemppanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        meetingtable = new javax.swing.JTable();
        meetingaddbt = new javax.swing.JButton();
        meetingdeletebt = new javax.swing.JButton();
        meetingeditbt = new javax.swing.JButton();
        meetingdeleteallbt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        meetingserverstartbt = new javax.swing.JButton();
        meetingserverstopbt = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        meetingservertable = new javax.swing.JTable();
        startsendingscreenbt = new javax.swing.JButton();
        stopsendingscreenbt = new javax.swing.JButton();
        meetingserverdrawbt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sendfilepathtf = new javax.swing.JTextField();
        sendfilelb = new javax.swing.JLabel();
        filebrowsebt = new javax.swing.JButton();
        sendfilebt = new javax.swing.JButton();
        sendfileprogressbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Home");
        getContentPane().setLayout(new java.awt.CardLayout());

        startmeetingsendfilepanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        changepwtb.setLayout(null);

        opasslb.setText("Old Password");
        changepwtb.add(opasslb);
        opasslb.setBounds(99, 58, 100, 30);

        nwpasslb.setText("New Password");
        changepwtb.add(nwpasslb);
        nwpasslb.setBounds(100, 124, 100, 30);

        conpasslb.setText("Confirm Password");
        changepwtb.add(conpasslb);
        conpasslb.setBounds(100, 190, 120, 30);
        changepwtb.add(opasspf);
        opasspf.setBounds(260, 60, 240, 30);
        changepwtb.add(nwpasstf);
        nwpasstf.setBounds(260, 120, 240, 30);
        changepwtb.add(conpasstf);
        conpasstf.setBounds(260, 190, 240, 30);

        change.setText("Change Password");
        changepwtb.add(change);
        change.setBounds(410, 283, 140, 60);

        changepasslb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        changepasslb.setText("CHANGE PASSWORD");
        changepwtb.add(changepasslb);
        changepasslb.setBounds(210, 0, 160, 30);

        startmeetingsendfilepanel.addTab("Change Password", changepwtb);

        emptb.setLayout(null);

        emptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Designation", "Phone No.", "email"
            }
        ));
        jScrollPane1.setViewportView(emptable);

        emptb.add(jScrollPane1);
        jScrollPane1.setBounds(50, 30, 460, 210);

        addempbt.setText("Add Employee");
        addempbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addempbtActionPerformed(evt);
            }
        });
        emptb.add(addempbt);
        addempbt.setBounds(30, 350, 140, 60);

        deletebt.setText("Delete");
        deletebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtActionPerformed(evt);
            }
        });
        emptb.add(deletebt);
        deletebt.setBounds(210, 350, 140, 60);

        editempbt.setText("Edit");
        emptb.add(editempbt);
        editempbt.setBounds(390, 350, 130, 60);

        startmeetingsendfilepanel.addTab("Manage_Employees", emptb);

        manageemppanel.setLayout(null);

        meetingtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Description", "Date_time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(meetingtable);

        manageemppanel.add(jScrollPane2);
        jScrollPane2.setBounds(40, 50, 452, 130);

        meetingaddbt.setText("Add New");
        manageemppanel.add(meetingaddbt);
        meetingaddbt.setBounds(30, 350, 110, 50);

        meetingdeletebt.setText("Delete");
        manageemppanel.add(meetingdeletebt);
        meetingdeletebt.setBounds(160, 350, 110, 50);

        meetingeditbt.setText("Edit");
        manageemppanel.add(meetingeditbt);
        meetingeditbt.setBounds(290, 350, 110, 50);

        meetingdeleteallbt.setText("Delete All");
        manageemppanel.add(meetingdeleteallbt);
        meetingdeleteallbt.setBounds(420, 350, 100, 50);

        startmeetingsendfilepanel.addTab("Manage_Meetings", manageemppanel);

        jPanel1.setLayout(null);

        meetingserverstartbt.setText("Start Server");
        meetingserverstartbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetingserverstartbtActionPerformed(evt);
            }
        });
        jPanel1.add(meetingserverstartbt);
        meetingserverstartbt.setBounds(140, 30, 110, 40);

        meetingserverstopbt.setText("Stop Server");
        meetingserverstopbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetingserverstopbtActionPerformed(evt);
            }
        });
        jPanel1.add(meetingserverstopbt);
        meetingserverstopbt.setBounds(320, 30, 110, 40);

        meetingservertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ip Address", "Phone_No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(meetingservertable);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(100, 120, 300, 230);

        startsendingscreenbt.setText("Start Sending Screen");
        startsendingscreenbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startsendingscreenbtActionPerformed(evt);
            }
        });
        jPanel1.add(startsendingscreenbt);
        startsendingscreenbt.setBounds(50, 420, 160, 50);

        stopsendingscreenbt.setText("Stop Sending Screen");
        stopsendingscreenbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopsendingscreenbtActionPerformed(evt);
            }
        });
        jPanel1.add(stopsendingscreenbt);
        stopsendingscreenbt.setBounds(240, 420, 160, 50);

        meetingserverdrawbt.setText("Draw");
        meetingserverdrawbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetingserverdrawbtActionPerformed(evt);
            }
        });
        jPanel1.add(meetingserverdrawbt);
        meetingserverdrawbt.setBounds(430, 420, 150, 50);

        startmeetingsendfilepanel.addTab("Meeting_Server", jPanel1);

        jPanel2.setLayout(null);

        sendfilepathtf.setFocusable(false);
        jPanel2.add(sendfilepathtf);
        sendfilepathtf.setBounds(30, 90, 410, 30);

        sendfilelb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sendfilelb.setText("          SEND FILE");
        jPanel2.add(sendfilelb);
        sendfilelb.setBounds(20, 150, 420, 20);

        filebrowsebt.setText("Browse");
        filebrowsebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filebrowsebtActionPerformed(evt);
            }
        });
        jPanel2.add(filebrowsebt);
        filebrowsebt.setBounds(470, 90, 100, 30);

        sendfilebt.setText("Send");
        sendfilebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendfilebtActionPerformed(evt);
            }
        });
        jPanel2.add(sendfilebt);
        sendfilebt.setBounds(210, 390, 150, 60);

        sendfileprogressbar.setBackground(Color.WHITE);
        sendfileprogressbar.setForeground(Color.GREEN);
        sendfileprogressbar.setStringPainted(true);
        jPanel2.add(sendfileprogressbar);
        sendfileprogressbar.setBounds(110, 250, 320, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select File");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 44, 150, 30);

        startmeetingsendfilepanel.addTab("Send File", jPanel2);

        getContentPane().add(startmeetingsendfilepanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetingserverstartbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetingserverstartbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meetingserverstartbtActionPerformed

    private void meetingserverstopbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetingserverstopbtActionPerformed
        if (startstopflag)
        { try
        {
            System.out.println("Server Stopped");
            startstopflag=false;
            meetingserver.sersock.close();
            meetingserver=null;
            
            JOptionPane.showMessageDialog(this,"Server Stopped");
            
            
        } 
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
        else 
        {
            JOptionPane.showMessageDialog(Manager_Home.this, "Server Already Stopped");
        }
    }//GEN-LAST:event_meetingserverstopbtActionPerformed

    private void startsendingscreenbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startsendingscreenbtActionPerformed
        
        if(cl.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No Client Connected");
        }
        else
        {
            if(!startstopsendingflag)
        {
           startstopsendingflag=true;
           Thread t=new Thread(new screensendingjob());
           t.start();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Already Sending Screen");
        }
        }
    }//GEN-LAST:event_startsendingscreenbtActionPerformed

    private void stopsendingscreenbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopsendingscreenbtActionPerformed
        if(startstopsendingflag)
        {
            startstopsendingflag=false;
        }
       
    }//GEN-LAST:event_stopsendingscreenbtActionPerformed

    private void meetingserverdrawbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetingserverdrawbtActionPerformed
       new DrawingFrame();
    }//GEN-LAST:event_meetingserverdrawbtActionPerformed

    private void sendfilebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendfilebtActionPerformed
        new Thread(new FileSender()).start();
        
    }//GEN-LAST:event_sendfilebtActionPerformed

    private void filebrowsebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filebrowsebtActionPerformed
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.OPEN_DIALOG
                
                )
        {
            File f=jfc.getSelectedFile();
            sendfilepathtf.setText(f.getPath());
        }
        
    }//GEN-LAST:event_filebrowsebtActionPerformed

    private void addempbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addempbtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addempbtActionPerformed

    private void deletebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletebtActionPerformed

    class screensendingjob implements Runnable
    {   
        
        public void run()
        {
            try
                
            { 
                
            
                while(startstopsendingflag)
                   
                {   
                    Robot robot=new Robot();
                   BufferedImage screenshot=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                 
                 ByteArrayOutputStream baos=new ByteArrayOutputStream();
                 
              
                  ImageIO.write(screenshot,"png",baos);
                   byte imagedata[]=baos.toByteArray();
                   for(int i=0;i<cl.size();i++)
                           {
                               cl.get(i).dos.writeLong(imagedata.length);
                               cl.get(i).dos.write(imagedata);
                              // cl.get(i).dos.flush();
                           }
                   for(int j=0;j<cl.size();j++)
                   {
                       String clientmsg=cl.get(j).dis.readLine();
                       if(clientmsg.equals("exit"))
                       {
                           cl.remove(j);
                            Thread t=new Thread(new  meetingservertablemodel());
                            t.start();
                           //tm3.fireTableDataChanged();
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
    
    public class employeetabledata implements Runnable {
        //al=new ArrayList<Employee>();

        public void run() {

            try {

                Connection conn2;
                //conn with manager,conn2 with manage_employee
                Statement stmt2;
                ResultSet rs2;

                Class.forName("com.mysql.jdbc.Driver");
                conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs2 = stmt2.executeQuery("select * from manage_employee");

                al.clear();
                while (rs2.next()) {
                    Employee obj = new Employee();
                    obj.email = rs2.getString("emp_email");
                    obj.name = rs2.getString("emp_name");
                    obj.phone_no = rs2.getString("emp_phone");
                    obj.designation = rs2.getString("emp_designation");
                    al.add(obj);

                }
                tm.fireTableDataChanged();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    class employeetablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Employee obj = al.get(rowIndex);
            if (columnIndex == 0) {
                return (obj.name);
            } else if (columnIndex == 1) {
                return (obj.designation);
            } else if (columnIndex == 2) {
                return (obj.phone_no);
            } else if (columnIndex == 3) {
                return (obj.email);
            } else {
                return ("anything");
            }
        }

        @Override
        public String getColumnName(int pos) {
            String colname[] = {"Name", "Designation", "Phone_No", "email"};
            return colname[pos];

        }

    }

    class meetingtabledata implements Runnable {

        @Override
        public void run() {
            try {

                Connection conn;
                //conn with manager,conn2 with manage_employee
                Statement stmt;
                ResultSet rs;

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("select * from meeting order by date_time desc");

                al2.clear();
                while (rs.next()) {
                    manage_meetings obj = new manage_meetings();
                    obj.title = rs.getString("title");
                    obj.description = rs.getString("description");
                    obj.date_time = rs.getString("date_time");
                    obj.mid = rs.getInt("mid");
                    al2.add(obj);

                }
                tm2.fireTableDataChanged();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    class meetingtabledatamodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al2.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            manage_meetings obj = al2.get(rowIndex);
            if (columnIndex == 0) {
                return (obj.title);
            } else if (columnIndex == 1) {
                return (obj.description);
            } else if (columnIndex == 2) {
                return (obj.date_time);
            } else {
                return ("anything");
            }

        }

        @Override
        public String getColumnName(int pos) {
            String colname[] = {"Title", "Description", "Date_Time"};
            return colname[pos];

        }

    }

    class changebtListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String password = new String(opasspf.getPassword());
            String s1 = nwpasstf.getText();
            String s2 = conpasstf.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select email,password from manager where email='" + email + "'and password='" + password + "'");
                if (!(password.isEmpty() || s1.isEmpty() || s2.isEmpty())) {
                    if (rs.next()) {
                        if (s1.equals(s2)) {
                            rs.updateString("password", s1);
                            rs.updateRow();
                            JOptionPane.showMessageDialog(Manager_Home.this, "PASSWORD CHANGED SUCCESSFULLY");
                            opasspf.setText("");
                            nwpasstf.setText("");
                            conpasstf.setText("");

                        } else {
                            JOptionPane.showMessageDialog(Manager_Home.this, "CONFIRM AND NEW PASSWORD FIELDS DONT MATCH");
                        }

                    } else {
                        JOptionPane.showMessageDialog(Manager_Home.this, "INVALID OLD PASSWORD");
                    }
                } else {
                    JOptionPane.showMessageDialog(Manager_Home.this, "ALL FIELDS ARE COMPULSARY");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    class addempbtlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            d = new JDialog(Manager_Home.this, true);
            d.setSize(400, 400);
            d.add(new addemppanel(Manager_Home.this));
            d.setLocationRelativeTo(Manager_Home.this);
            d.show();

        }

    }

    class deletebtListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int n = emptable.getSelectedRow();
            if (n == -1) {
                JOptionPane.showMessageDialog(Manager_Home.this, "PLEASE SELECT ROW");
            } else {
                int ans = JOptionPane.showConfirmDialog(Manager_Home.this, "ARE YOU SURE YOU WANT TO DELETE ", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    Employee ed = al.get(n);
                    String phone = ed.phone_no;
                    al.remove(n);
                    tm.fireTableDataChanged();
                    Connection conn;
                    Statement stmt;
                    ResultSet rs;

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs = stmt.executeQuery("select * from manage_employee where emp_phone='" + phone + "'");
                        rs.next();
                        rs.deleteRow();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }

    }

    class editempbtListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int n = emptable.getSelectedRow();

            if (n == -1) {
                JOptionPane.showMessageDialog(Manager_Home.this, "PLEASE SELECT ROW");
            } else {
                Employee es = al.get(n);
                d2 = new JDialog(Manager_Home.this, true);
                d2.setSize(400, 400);
                d2.add(new editemppanel(Manager_Home.this, es));
                d2.setLocationRelativeTo(Manager_Home.this);
                d2.show();

            }

        }

    }

    class meetingaddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            d3 = new JDialog(Manager_Home.this, true);
            d3.setSize(600, 600);
            d3.add(new addmeetingpanel(Manager_Home.this));
            d3.setLocationRelativeTo(Manager_Home.this);
            d3.show();
        }

    }

    class meetingdeleteListener implements ActionListener {

        Connection conn;
        Statement stmt;
        ResultSet rs;

        @Override
        public void actionPerformed(ActionEvent e) {
            int n = meetingtable.getSelectedRow();

            if (n == -1) {
                JOptionPane.showMessageDialog(Manager_Home.this, "PLEASE SELECT ROW");
            } else {
                String dt = al2.get(n).date_time;
                int m = al2.get(n).mid;
                int ans = JOptionPane.showConfirmDialog(Manager_Home.this, "ARE YOU SURE YOU WANT TO DELETE ", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {

                    int i = meetingtable.getSelectedRow();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs = stmt.executeQuery("select * from meeting where mid='" + m + "'");
                        rs.next();
                        rs.deleteRow();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    al.remove(n);
                    new Thread(new meetingtabledata()).start();

                }
            }
        }
    }

    class meetingdeleteallListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                Connection conn;
                //conn with manager,conn2 with manage_employee
                Statement stmt;
                ResultSet rs;

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("select * from meeting ");
                while (rs.next()) {
                    rs.deleteRow();
                }
                new Thread(new meetingtabledata()).start();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    class meetingeditListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int n = meetingtable.getSelectedRow();
            if (n == -1) 
            {
                JOptionPane.showMessageDialog(Manager_Home.this, "PLEASE SELECT THE ROW");

            }
            else 
            {

                d4 = new JDialog(Manager_Home.this, true);
                d4.setSize(600, 700);
                d4.add(new editmeetingpanel(Manager_Home.this, n));
                d4.setLocationRelativeTo(Manager_Home.this);
                d4.show();

            }
        }

    }

    
    class meetingservertablemodel extends AbstractTableModel implements Runnable
    {

        @Override
        public int getRowCount() 
        {
            return cl.size();
        }

        @Override
        public int getColumnCount()
        {
           return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) 
        {
           
            if (columnIndex == 0) 
            {
                return (cl.get(rowIndex).ipAddress);
            }
            else if (columnIndex == 1) 
            {
                return (cl.get(rowIndex).phno);
            
        }
            else
            {
                return("nothing");
            }
          

        
        
    }
         @Override
        public String getColumnName(int pos)
        {
            String colname[] = {"ipAddress","Phone No."};
            return colname[pos];

    }

        @Override
        public void run()
        {
           tm3.fireTableDataChanged();
        }
    }
    class MeetingServer implements Runnable 
    {
        ServerSocket sersock;
        
        @Override
        public void run()
        {
            try {
                 sersock = new ServerSocket(7500);
                System.out.println("Server Started");

                while (true)
                {
                    Socket sock = sersock.accept();
                    System.out.println("Connected to client");
                    ClientHandler ch = new ClientHandler(sock);
                    Thread t = new Thread(ch);
                    t.start();

                }
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
    }

    class ClientHandler implements Runnable
    {
       String phno,password;
       String ipAddress;
        DataInputStream dis;
        DataOutputStream dos;
        Socket sock;
       
        ClientHandler(Socket s) 
        {
            ipAddress="127.0.0.2";
            try {
                sock = s;
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            try 
            {
                while (true) 
                {
                    if(!loginstatusflag)
                    {
                    String request = dis.readLine();

                    if (request.equals("Login Request")) 
                    {
                         phno = dis.readLine();
                         password = dis.readLine();
                       // System.out.println(phno + " " + password);

                        Connection conn;

                        Statement stmt;
                        ResultSet rs;

                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team_meeting", "root", "system");
                        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        rs = stmt.executeQuery("select * from manage_employee where emp_phone='" + phno + "' and password='" + password + "'");
                        if (rs.next())
                        {
                            dos.writeBytes("Login Successful\r\n");
                            dos.flush();
                            cl.add(this);
                            new Thread(new meetingservertablemodel()).start();
                        } 
                        else 
                        {
                            dos.writeBytes("fail\r\n");
                            dos.flush();
                            break;
                        }

                    }
                    
                    loginstatusflag=true;

                }
                   
                    
                    
                }

            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
            sendfilelb.setText("");

        }

    }

    class meetingserverstartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!startstopflag) 
            {
                Thread t = new Thread(new MeetingServer());
                t.start();
                startstopflag=true;

            }
            else 
            {
                JOptionPane.showMessageDialog(Manager_Home.this, "Server Already Started");
            }

        }

    }
    
    class FileSender implements Runnable
    {

        BufferedReader brn;
        
         
        @Override
        public void run()
        {
            int i;
            String ipAddr;
            for(i=0;i<cl.size();i++)
            {
               ipAddr=cl.get(i).ipAddress; 
               try
        {
            Socket sock = new Socket(ipAddr,7000); 
               brn=new BufferedReader(new InputStreamReader(sock.getInputStream()));
            DataOutputStream  dos=new DataOutputStream(sock.getOutputStream());
            
            File f=new File(sendfilepathtf.getText());
            FileInputStream   fis=new FileInputStream(f);
            
            byte b[]=new byte[10000];
            long count=0,filesize=f.length();
            int r;
            
            
            //send info about file
            dos.writeBytes("sending file\r\n");
            dos.writeLong(filesize);
            dos.writeBytes(f.getName()+"\r\n");
            
            
            sendfilelb.setText("Sending Fileto"+ipAddr);
            
            
            //send actual file
            while(true)
            {
                r=fis.read(b,0,10000);
                
                count=count+r;
                 float per = (count/filesize)*100;
                 
                sendfileprogressbar.setValue((int)per);
               
                sendfileprogressbar.setString((int)per+"% complete");
                dos.write(b,0,r);
                
                if(count==filesize)
                {
            
                    break;
                } 
                 String s=brn.readLine();
            
           
            
            }
            
            fis.close();
            //dos.close();
            
            
              
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
            
             
            }
            
               sendfilelb.setText("");
        }
        
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Manager_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addempbt;
    private javax.swing.JButton change;
    private javax.swing.JLabel changepasslb;
    private javax.swing.JPanel changepwtb;
    private javax.swing.JLabel conpasslb;
    private javax.swing.JTextField conpasstf;
    private javax.swing.JButton deletebt;
    private javax.swing.JButton editempbt;
    public javax.swing.JTable emptable;
    private javax.swing.JPanel emptb;
    private javax.swing.JButton filebrowsebt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel manageemppanel;
    private javax.swing.JButton meetingaddbt;
    private javax.swing.JButton meetingdeleteallbt;
    private javax.swing.JButton meetingdeletebt;
    private javax.swing.JButton meetingeditbt;
    private javax.swing.JButton meetingserverdrawbt;
    private javax.swing.JButton meetingserverstartbt;
    private javax.swing.JButton meetingserverstopbt;
    private javax.swing.JTable meetingservertable;
    private javax.swing.JTable meetingtable;
    private javax.swing.JLabel nwpasslb;
    private javax.swing.JTextField nwpasstf;
    private javax.swing.JLabel opasslb;
    private javax.swing.JPasswordField opasspf;
    private javax.swing.JButton sendfilebt;
    private javax.swing.JLabel sendfilelb;
    private javax.swing.JTextField sendfilepathtf;
    private javax.swing.JProgressBar sendfileprogressbar;
    private javax.swing.JTabbedPane startmeetingsendfilepanel;
    private javax.swing.JButton startsendingscreenbt;
    private javax.swing.JButton stopsendingscreenbt;
    // End of variables declaration//GEN-END:variables
}
