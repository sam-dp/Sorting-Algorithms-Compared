import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MyFrame extends JFrame {
    
    MyFrame() {
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Visualized Sorting Algorithms");
        this.setVisible(true);

        this.getContentPane().setBackground(Color.GRAY);

        //ImageIcon image = new ImageIcon("SOURCE TITLE");
        //this.setIconImage(image.getImage());

        
    }

}
