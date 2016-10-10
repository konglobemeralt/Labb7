package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Labyrinth3D implements Drawable3D {

    private Drawable3D shape;

    public Labyrinth3D(Labyrinth l) {
        shape = labToShape(l);
    }

    private double cellSize() {
        return 25;
    }

    private Drawable3D mark(int i, int j) {
        return new Many3D(new Line3D(new Point3D ((i+1) * cellSize(), j * cellSize(),cellSize()/3),
                new Point3D (i * cellSize(), (j+1) * cellSize(),cellSize()/3)),
                new Line3D(new Point3D (i * cellSize(), j * cellSize(),cellSize()/3),
                        new Point3D ((i+1) * cellSize(), (j+1) * cellSize(),cellSize()/3)));
    }

    private Drawable3D wallRight(int i, int j) {
        return new Surface3D(new Point3D ((i+1) * cellSize(), j * cellSize(),0),
                new Point3D ((i+1) * cellSize(), j * cellSize(),cellSize()),
                new Point3D ((i+1) * cellSize(), (j+1) * cellSize(),cellSize()),
                new Point3D ((i+1) * cellSize(), (j+1) * cellSize(),0));
    }

    private Drawable3D wallBelow(int i, int j) {
        return new Surface3D(new Point3D(i * cellSize(), (j+1) * cellSize(),0),
                new Point3D(i * cellSize(), (j+1) * cellSize(),cellSize()),
                new Point3D((i+1) * cellSize(), (j+1) * cellSize(),cellSize()),
                new Point3D((i+1) * cellSize(), (j+1) * cellSize(),0));
    }

    private Drawable3D labToShape(Labyrinth l) {
        Drawable3D d = new Empty3D();
        if (l == null) { return d; }
        int w = l.getWidth();
        int h = l.getHeight();
        for (int i=0; i < w; i++) {
            d = new Many3D(d,wallBelow(i,-1));
        }
        for (int i=0; i < h; i++) {
            d = new Many3D(d,wallRight(-1,i));
        }
        for (int i=0; i < w; i++) {
            for (int j=0; j < h; j++) {
                if (!l.canMove(Labyrinth.Direction.DOWN,i,j)) {
                    d = new Many3D(d,wallBelow(i,j));
                }
                if (!l.canMove(Labyrinth.Direction.RIGHT,i,j)) {
                    d = new Many3D(d,wallRight(i,j));
                }
                if (l.getMark(i,j)) {
                    d = new Many3D(d,mark(i,j));
                }
            }
        }
        return d.translate(-w * cellSize() / 2, -h * cellSize() / 2, 0);
    }

    public void draw(Graphics g, int width, int height) {
        shape.draw(g,width,height);
    }

    private Labyrinth3D() {}

    public Drawable3D rotate(double xy_angle, double yz_angle) {
        Labyrinth3D d = new Labyrinth3D();
        d.shape = shape.rotate(xy_angle,yz_angle);
        return d;
    }

    public Drawable3D translate(double x, double y, double z) {
        Labyrinth3D d = new Labyrinth3D();
        d.shape = shape.translate(x,y,z);
        return d;
    }

}
