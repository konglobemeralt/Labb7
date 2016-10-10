package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class Surface3D implements Drawable3D {

    private Point3D p1, p2, p3, p4;

    public Surface3D(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public void draw(Graphics g, int width, int height) {
        int w2 = width / 2;
        int h2 = height / 2;
        int[] xs = { (int)(p1.getX()) + w2,
                (int)(p2.getX()) + w2,
                (int)(p3.getX()) + w2,
                (int)(p4.getX()) + w2 };
        int[] ys = { -(int)(p1.getY()) + h2,
                -(int)(p2.getY()) + h2,
                -(int)(p3.getY()) + h2,
                -(int)(p4.getY()) + h2 };
        g.drawPolygon(xs,ys,xs.length);
    }

    public Surface3D rotate(double xy_angle, double yz_angle) {
        return new Surface3D(p1.rotate(xy_angle,yz_angle),
                p2.rotate(xy_angle,yz_angle),
                p3.rotate(xy_angle,yz_angle),
                p4.rotate(xy_angle,yz_angle));
    }

    public Surface3D translate(double x, double y, double z) {
        return new Surface3D(p1.translate(x,y,z),
                p2.translate(x,y,z),
                p3.translate(x,y,z),
                p4.translate(x,y,z));
    }

}
