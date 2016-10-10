package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Many3D implements Drawable3D {

    private Drawable3D p1;
    private Drawable3D p2;

    public Many3D(Drawable3D p1, Drawable3D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Drawable3D rotate(double xy_angle, double yz_angle) {
        return new Many3D(p1.rotate(xy_angle,yz_angle),
                p2.rotate(xy_angle,yz_angle));
    }

    public void draw(Graphics g, int width, int height) {
        p1.draw(g,width,height);
        p2.draw(g,width,height);
    }

    public Drawable3D translate(double x, double y, double z) {
        return new Many3D(p1.translate(x,y,z),p2.translate(x,y,z));
    }

}
