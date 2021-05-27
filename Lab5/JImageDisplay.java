package com.company;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class JImageDisplay extends JComponent{
    public BufferedImage image;

    public JImageDisplay(int height, int width){
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Dimension dim = new Dimension(width, height);
        super.setPreferredSize(dim);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }
    public void clearImage (){
        image.setRGB(0,0,getWidth(),getHeight(),null,0,1);
    }
    public void drawPixel(int x, int y, int RGBcol){
        image.setRGB(x,y,RGBcol);
    }
}
