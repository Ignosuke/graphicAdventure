package graphics;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Window extends JFrame{
    public Window(String name, DrawingSurface drawingSurface) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close app on closing window
        this.setTitle(name);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(drawingSurface, null);
        this.pack();                                            //adjust window's dimension to screen --> dimensions defined by the canvas 
        this.setLocationRelativeTo(null);                     //open window on center of the screen
        this.setVisible(true);                                //cmon, you know what this line does
    }
}
