package tda548;

import java.util.*;

public class LabList implements Labyrinth {

    private Labyrinth current;
    private List<Labyrinth> history;

    public LabList(Labyrinth initial) {
        current = initial;
        history = new LinkedList<Labyrinth>();
        history.add(current.clone());
    }

    public void setMark(int x, int y, boolean b) {
        current.setMark(x,y,b);
        history.add(current.clone());
    }

    public boolean canMove(Direction dir, int x, int y) {
        return current.canMove(dir,x,y);
    }

    public int getWidth() {
        return current.getWidth();
    }

    public int getHeight() {
        return current.getHeight();
    }

    public boolean getMark(int x, int y) {
        return current.getMark(x,y);
    }

    public String toString() {
        return current.toString();
    }

    public Labyrinth clone() {
        return current.clone();
    }

    public Iterator<Labyrinth> iterator() {
        return history.iterator();
    }

}
