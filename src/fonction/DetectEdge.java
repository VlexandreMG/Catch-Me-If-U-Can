package fonction;

import javax.swing.*;
import java.awt.*;
import jeu.*;

public class DetectEdge {
    Point point;
    JFrame frame;
    BorderCoordinates borderCoordinates = new BorderCoordinates(frame);

    public DetectEdge(Point point,JFrame frame) {
        this.point = point;
        this.frame = frame;
    }

    public void MooveBory(Point point,BorderCoordinates borderCoordinates) {
        if (point.getX() < this.borderCoordinates.getInnerBounds().x) {
            point.move(-point.x,point.y);
        } else if (point.getY() < this.borderCoordinates.getInnerBounds().y) {
            point.move(point.x,-point.y);
        }
        else if (point.getX() > this.borderCoordinates.getInnerBounds().width) {
            point.move(-point.x,point.y);
        } else if (point.getY() > this.borderCoordinates.getInnerBounds().height){
            point.move(point.x, -point.y);
        }
    }


}
