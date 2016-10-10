package tda548;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Empty3D implements Drawable3D {

    public Drawable3D rotate(double xy_angle, double yz_angle) {
        return this;
    }

    public Drawable3D translate(double x, double y, double z) {
        return this;
    }

    public void draw(Graphics g, int width, int height) {}

}
