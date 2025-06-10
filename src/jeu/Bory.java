package jeu;

import java.awt.Point;

public class Bory {
    Point position;

    public Bory(Point position) {
        this.position = new Point();
    }
    public double getX() {
        return this.position.x;
    }

    public double getY() {
        return this.position.y;
    }

    public Point getPosition() {
        return position;
    }
}
