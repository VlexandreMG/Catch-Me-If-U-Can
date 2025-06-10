package jeu;

import javax.swing.*;
import java.awt.*;

public class BorderCoordinates {
    private final JFrame frame;

    public BorderCoordinates(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Récupère le rectangle de la zone interne (sans les bordures)
     * @return Rectangle avec les coordonnées et dimensions de la zone utile
     */
    public Rectangle getInnerBounds() {
        Insets insets = frame.getInsets();
        return new Rectangle(
                insets.left,
                insets.top,
                frame.getWidth() - insets.left - insets.right,
                frame.getHeight() - insets.top - insets.bottom
        );
    }

    /**
     * Récupère les coordonnées absolues des 4 coins de la bordure
     * @return Tableau de 4 Points dans l'ordre: [haut-gauche, haut-droit, bas-gauche, bas-droit]
     */
    public Point[] getBorderCorners() {
        Point frameLocation = frame.getLocationOnScreen();
        Insets insets = frame.getInsets();

        int x = frameLocation.x;
        int y = frameLocation.y;
        int width = frame.getWidth();
        int height = frame.getHeight();

        return new Point[] {
                new Point(x, y),  // Haut-gauche (début de la bordure)
                new Point(x + width - insets.right, y),  // Haut-droit
                new Point(x, y + height - insets.bottom),  // Bas-gauche
                new Point(x + width - insets.right, y + height - insets.bottom)  // Bas-droit
        };
    }
}
