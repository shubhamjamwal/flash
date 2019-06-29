
import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawingFrame extends javax.swing.JFrame {

    ArrayList<Point> al = new ArrayList<>();

    public DrawingFrame() 
    {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        JLabel lb = new JLabel()
        {
            public void paint(Graphics g) 
            {
                super.paint(g);
                g.setColor(Color.red);
                Graphics2D gg = (Graphics2D)g;
                BasicStroke bs = new BasicStroke(3);
                
                gg.setStroke(bs);
                for (int i = 0; i < al.size() - 1; i++) 
                {
                    if(al.get(i).x==-1 && al.get(i).y==-1  ||  al.get(i+1).x==-1 && al.get(i+1).y==-1)
                        continue;
                    g.drawLine(al.get(i).x, al.get(i).y, al.get(i + 1).x, al.get(i + 1).y);
                }
            }
        };

        lb.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) 
            {
                al.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
        lb.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                al.add(new Point(-1,-1));
            }
        });

        this.add(lb);

        try {
            Robot rbt = new Robot();
            Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bi = rbt.createScreenCapture(rect);
            lb.setIcon(new ImageIcon(bi));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
        if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)
        {
            int n=al.size();
            al.remove(n-1);
            repaint();
        }
    }//GEN-LAST:event_formKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new DrawingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
