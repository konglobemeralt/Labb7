package tda548;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    private static final int DELAY = 50;

    private class DemoPanel extends JPanel {

        private LabAnimate la;

        public DemoPanel(LabAnimate la) { this.la = la; }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.WHITE);
            la.draw(g,getWidth(),getHeight());
        }

    }

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600); setLocation(50,50);

        int w = 15;
        int h = 15;

        Labyrinth l = new Lab(w,h);
        LabList ll = new LabList(l);
        LabSolver.findPath(0,0,w-1,h-1,ll);
        LabAnimate la = new LabAnimate(ll);

        DemoPanel panel = new DemoPanel(la);
        add(panel); setVisible(true);
        ActionListener al = (e -> { panel.repaint(); la.tick(); });
        Timer t = new Timer(DELAY,al); t.start();
    }
    public static void main(String[] args) {
        Main f = new Main();
    }
}
