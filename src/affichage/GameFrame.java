package affichage;

import jeu.Bory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameFrame extends JFrame {
    private Bory bory;
    private BoulePanel boulePanel;

    public GameFrame() {
        setTitle("Catch Me If You Can");
        setResizable(false);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Point point = new Point(400,300);
        bory = new Bory(point);
        boulePanel = new BoulePanel(bory);

        // Ajout du MouseMotionListener pour suivre en permanence la position
        boulePanel.addMouseMotionListener(new MouseMotionHandler());

        add(boulePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseMoved(MouseEvent e) {
            // Vérifie en permanence la position de la souris
            boulePanel.verifieCursor(e.getPoint());
        }

        @Override
        public void mouseDragged(MouseEvent e) {}
    }
}