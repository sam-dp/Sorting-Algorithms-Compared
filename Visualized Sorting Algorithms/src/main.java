import java.util.*;
import javax.swing.*;
import java.awt.*;

class main {

    public main() {
        JFrame frame = new JFrame();
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Visualized Sorting Algorithms");
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.GRAY);

        //ImageIcon image = new ImageIcon("SOURCE TITLE");
        //frame.setIconImage(image.getImage());
    }


    public static void main (String[] args) {
        new main();
    }
}