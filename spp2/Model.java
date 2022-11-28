import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import java.util.ArrayList;

public class Model implements ActionListener {
    Timer timer; 
    ArrayList<Controller> clients = new ArrayList<Controller>();
    ArrayList<Point> positions = new ArrayList<Point>();  
    public Model(int delay) { 
        timer = new Timer(delay, this); 
    }
    int count; 
    public void actionPerformed(ActionEvent e) {
        this.count += 1; 
        for (Controller c : this.clients) {
            c.setTime(this.count); 
        }
    }
    public void start() {
        timer.start(); 
    }
    public void register(Controller client) {
        int id = this.clients.size(); 
        int x = (int)(Math.random() * 200 - 50); 
        int y = (int)(Math.random() * 200 - 50); 
        this.positions.add(new Point(x, y)); 
        this.clients.add(client); 
        client.setId(id); 
    }
    public void signalFrom(int id, int direction) {
        if (direction == java.awt.event.KeyEvent.VK_UP) this.positions.get(id).y -= 1;  
        if (direction == java.awt.event.KeyEvent.VK_DOWN) this.positions.get(id).y += 1;  
        if (direction == java.awt.event.KeyEvent.VK_LEFT) this.positions.get(id).x -= 1;  
        if (direction == java.awt.event.KeyEvent.VK_RIGHT) this.positions.get(id).x += 1;  
        for (Controller c : this.clients) {
            c.update(this.positions); 
        }
    }
}
