import javax.swing.*;
import java.awt.*;
import java.util.*; 
import java.awt.event.*; 

public class View extends JComponent implements KeyListener {
    int time; 
    ArrayList<Point> world;
    String name; 
    Controller c; 
    public View(String name) {
        this.name = name;
        JFrame a = new JFrame(name); 
        a.add(this); 
        a.setSize(400, 400);
        a.setVisible(true); 
        a.addKeyListener(this); 
    }
    public void paintComponent(Graphics g) {
        g.drawString("World time " + this.time, 10, 20); 
        if (this.world == null) {
            
        } else { 
            for (int i = 0; i < this.world.size(); i++) {
                int x = this.world.get(i).x;
                int y = this.world.get(i).y;
                g.drawOval(x - 10, y - 10, 20, 20); 
                if (i == this.c.id) {
                    g.drawString(name, x - 5, y); 
                }
            }
        }
    }
    public void showTime(int time) {
        this.time = time;
        this.repaint();
    }
    public void keyPressed(KeyEvent e) { 
        int direction = e.getKeyCode(); 
        c.move(direction);         
    } 
    public void keyTyped(KeyEvent e) { } 
    public void keyReleased(KeyEvent e) { }
    public void addController(Controller c) {
        this.c = c; 
    }
    public void draw(ArrayList<Point> world) {
        this.world = world;
        this.repaint(); 
    }
}

