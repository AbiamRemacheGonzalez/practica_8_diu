package ulpgc.es.diu_p8_1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class canvast extends JPanel{
    private BufferedImage imagen = null; 
    private String imageFile = null;
    private Mat imagenUmbralizada;
    
    public canvast(){
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (imagen == null){
            g.drawString("No image has been selected", this.getWidth()/2-80, this.getHeight()/2);
        }else{
            g.drawImage(imagen, 0, 0, null);
        }
    }
    
    public void setImage(File file){
        try {
            imagen = ImageIO.read(file);
            imageFile = file.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(canvast.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
        repaint();
    }
    public void setUmbral(int umb){
        Mat currentMat = Imgcodecs.imread(imageFile);
        Mat umbMat = umbralizar(currentMat,umb);
        imagen = (BufferedImage) HighGui.toBufferedImage(umbMat);
        repaint();
    }
    
    private Mat umbralizar(Mat imagen_original, Integer umbral) {
        Mat imagenGris = new Mat(imagen_original.rows(),imagen_original.cols(),CvType.CV_8U);
        imagenUmbralizada = new Mat(imagen_original.rows(),imagen_original.cols(),CvType.CV_8U);
        Imgproc.cvtColor(imagen_original,imagenGris,Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(imagenGris,imagenUmbralizada,umbral,255,Imgproc.THRESH_BINARY);
        return imagenUmbralizada;
    }
}
