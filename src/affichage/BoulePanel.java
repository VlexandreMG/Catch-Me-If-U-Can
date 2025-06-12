package affichage;

import jeu.*;

import javax.swing.*;
import java.awt.*;

public class BoulePanel extends JPanel {
    Bory bory;
    int rayonBory = 10;
    int rayonMortel = 50;
    Timer timerDeplacement;
    boolean curseurDansZone = false;

    public BoulePanel(Bory bory) {
        this.bory = bory;
        setOpaque(true);

        timerDeplacement = new Timer(30, e -> {
            bory.getPosition().y -= 2;
            repaint();
        });
        timerDeplacement.setInitialDelay(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(new Color(255, 0, 0, 50));
        g2d.fillOval((int) bory.getX() - rayonMortel, (int) bory.getY() - rayonMortel, rayonMortel * 2, rayonMortel * 2);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillOval((int) bory.getX() - rayonBory, (int) bory.getY() - rayonBory, rayonBory * 2, rayonBory * 2);

        g2d.dispose();
    }

    public void verifieCursor(Point cursor) {
        double distance = bory.getPosition().distance(cursor);

        if (distance < rayonMortel) {
            if (!curseurDansZone) {
                curseurDansZone = true;
                System.out.println("Curseur dans la zone de Bory!");
                if (!timerDeplacement.isRunning()) {
                    timerDeplacement.start();
                }
            }
        } else {
            if (curseurDansZone) {
                curseurDansZone = false;
                System.out.println("Curseur hors de la zone de Bory");
                if (timerDeplacement.isRunning()) {
                    timerDeplacement.stop();
                }
            }
        }
    }
}
