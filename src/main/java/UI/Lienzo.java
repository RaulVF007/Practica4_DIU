/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author raulv
 */
public class Lienzo extends JPanel{
    private Color colorFondo;
    private Color colorPincel;
    private List<Point> points = new ArrayList<>();

    public Lienzo() {
        this.colorFondo = Color.WHITE;
        this.colorPincel = Color.BLACK;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setColorFondo(colorFondo);
        this.setColorPincel(colorPincel);
        for (Point p : points){
            g.fillOval(p.x, p.y, 5, 5);
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setColorFondo(Color colorFondo) {
        this.setBackground(colorFondo);
        this.colorFondo = colorFondo;
    }

    public void setColorPincel(Color colorPincel) {
        this.setForeground(colorPincel);
        this.colorPincel = colorPincel;
    }

    public void addPoint(Point point) {
        points.add(0,point);
    }
    
    public void getLeadPoints() {
        if (points.size() > 5) {
            points = new ArrayList<>(points.subList(0,4));
        }
    }
}
