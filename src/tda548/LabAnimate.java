package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LabAnimate {

    Labyrinth l;
    Drawable3D shape;
    int s = 0;

    public LabAnimate(LabList ll) {
        this.l = ll;
        tick();
    }

    public void draw(Graphics g, int w, int h) {
        shape.draw(g,w,h);
    }

    public void tick() {
        shape = new Labyrinth3D(l);
        shape = shape.rotate(0.01 * s, 0.02 * s);
        s = s + 1;
    }

}
