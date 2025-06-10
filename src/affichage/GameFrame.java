package affichage;

import jeu.Bory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    Bory bory;
    BoulePanel boulePanel;

    public GameFrame() {
        setTitle("Catch Me If You Can");
        setResizable(false);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Point point = new Point(400,300);
        bory = new Bory(point);
        boulePanel = new BoulePanel(bory);

        add(boulePanel,BorderLayout.CENTER);

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                boulePanel.verifieCursor(e.getPoint());
                System.out.println("Dans le rayon.");
            }
        });
        setVisible(true);
    }
}
