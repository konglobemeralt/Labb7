package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Line3D implements Drawable3D {

    private Point3D p1, p2;

    public Line3D(Point3D p1, Point3D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw(Graphics g, int width, int height) {
        g.drawLine((int)(p1.getX()) + width/2, -(int)(p1.getY()) + height/2,
                (int)(p2.getX()) + width/2, -(int)(p2.getY()) + height/2);
    }

    public Line3D rotate(double xy_angle, double yz_angle) {
        return new Line3D(p1.rotate(xy_angle,yz_angle),
                p2.rotate(xy_angle,yz_angle));
    }

    public Line3D translate(double x, double y, double z) {
        return new Line3D(p1.translate(x,y,z),p2.translate(x,y,z));
    }

}
