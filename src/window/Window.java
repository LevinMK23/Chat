package window;

import javafx.scene.layout.Border;

import javax.swing.*;
import javax.swing.text.LayoutQueue;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world!");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LayoutManager layoutManager = new ScrollPaneLayout();
        ScrollPane panel = new ScrollPane();
        panel.setLayout(layoutManager);
        for (int i = 0; i < 15; i++) {
            panel.add(new JButton());
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}
