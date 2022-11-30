import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import java.util.ArrayList;

public class Model implements ActionListener {
    int count; 
    Timer timer; 
    ArrayList<Controller> clients = new ArrayList<Controller>();
    ArrayList<Point> positions = new ArrayList<Point>();
    public Model(int delay) { 
        timer = new Timer(delay, this); 
    }
    public void actionPerformed(ActionEvent e) {
        this.count += 1; 
        // System.out.println("Model: " + this.count); 
        for (Controller c : this.clients) {
            c.setTime(this.count); 
        }
    }
    public void signalFrom(int id, int direction) {

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
}
