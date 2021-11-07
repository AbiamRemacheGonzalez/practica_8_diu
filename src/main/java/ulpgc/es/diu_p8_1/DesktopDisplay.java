package ulpgc.es.diu_p8_1;

import java.awt.Point;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DesktopDisplay extends javax.swing.JFrame {
    JFileChooser jfc = new JFileChooser();
    FileNameExtensionFilter filtro = null;
    InternalWindow mainWindow;
    private boolean opened = false;
    Point ini;
    public DesktopDisplay() {
        filtro = new FileNameExtensionFilter("Images","jpg","png","jpeg");
        jfc.addChoosableFileFilter(filtro);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        thresholdMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);
        jMenu1.add(jSeparator1);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        thresholdMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        thresholdMenu.setText("Threshold");
        thresholdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdMenuActionPerformed(evt);
            }
        });
        jMenu2.add(thresholdMenu);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        aboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutMenu.setText("About");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        jMenu3.add(aboutMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        // TODO add your handling code here:
        int res = jfc.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            JInternalFrame [] vector = escritorio.getAllFrames();
            for (JInternalFrame ventana : vector) {
                ventana.dispose();
            }
            mainWindow = new InternalWindow();
            mainWindow.setImage(jfc.getSelectedFile());
            mainWindow.setTitle(jfc.getSelectedFile().getName());
            escritorio.add(mainWindow);
            ini = new Point(mainWindow.getX(),mainWindow.getY());
            mainWindow.setVisible(Boolean.TRUE);
            opened = true;
        }
        if(res == JFileChooser.CANCEL_OPTION) System.out.println("Cancelar");
    }//GEN-LAST:event_openMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Do you want to exit the aplication?", "Exit", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
                System.exit(0);
        }
    }//GEN-LAST:event_exitMenuActionPerformed

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Welcome! \nThis application will help you set a threshold on images on the grey scale, you must first select an image using File>Open and then set a threshold using Edit>Threshold. \nFinally, you can save your image using File>save and if you want to exit the app, you can use File>Exit.", "Help", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_aboutMenuActionPerformed

    private void thresholdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdMenuActionPerformed
        // TODO add your handling code here:
        if(opened){
            String res = JOptionPane.showInputDialog(rootPane, "Threshold:", "Threshold", JOptionPane.QUESTION_MESSAGE);
            int th = Integer.parseInt(res);
            InternalWindow iw = new InternalWindow();
            double x = ini.getX()+40.0;
            double y = ini.getY()+40.0;
            ini = new Point((int)x,(int)y);
            iw.setImage(mainWindow.getFile());
            iw.setThreshold(th);
            iw.setTitle(mainWindow.getFile().getName()+" ==> Threshold = "+th);
            iw.setLocation(ini);
            escritorio.add(iw);
            iw.setVisible(Boolean.TRUE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "An image must be selected opened", "No image opened", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_thresholdMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem thresholdMenu;
    // End of variables declaration//GEN-END:variables
}
