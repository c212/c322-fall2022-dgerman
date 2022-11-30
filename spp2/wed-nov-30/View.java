import javax.swing.*;
import java.awt.*;
import java.util.*; 
import java.awt.event.*; 

public class View extends JComponent implements KeyListener {
    int time; 
    Controller c; 
    public void keyPressed(KeyEvent e) { 
        int direction = e.getKeyCode(); 
        c.move(direction);         
    } 
    public void keyTyped(KeyEvent e) { } 
    public void keyReleased(KeyEvent e) { }
    public void showTime(int time) {
        this.time = time;
        this.repaint();
        System.out.println( time ); 
    }
    public void addController(Controller c) {
        this.c = c; 
    }
}
