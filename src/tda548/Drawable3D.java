package tda548;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public interface Drawable3D {

    public Drawable3D rotate(double xy_angle, double yz_angle);
    public void draw(Graphics g, int width, int height);
    public Drawable3D translate(double x, double y, double z);

}
