package ulpgc.es.diu_p8_1;

import java.awt.Dimension;
import java.io.File;

public class InternalWindow extends javax.swing.JInternalFrame {
   private File file;
    public InternalWindow() {
        initComponents();
        this.setPreferredSize(new Dimension(100,80));
        this.setMaximizable(Boolean.TRUE);
        this.setIconifiable(Boolean.TRUE);
        this.setClosable(Boolean.TRUE);
        this.setResizable(Boolean.TRUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new ulpgc.es.diu_p8_1.canvast();

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void setImage(File selectedFile) {
        imagePanel.setImage(selectedFile);
        file = selectedFile;
    }
    public File getFile(){
        return file;
    }
    void setThreshold(int th) {
        imagePanel.setUmbral(th);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ulpgc.es.diu_p8_1.canvast imagePanel;
    // End of variables declaration//GEN-END:variables

    
}
