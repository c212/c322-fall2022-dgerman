import java.util.*;

public class Controller {
    Model model;
    View view;
    int id; 
    public Controller(Model model) {
        this.model = model; 
        this.model.register(this); 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public void setTime(int count) {
        view.showTime(count); 
    }
    public void addView(View view) {
        this.view = view; 
        this.view.addController(this); 
    }
    public void move(int direction) {
        this.model.signalFrom(this.id, direction); 
    }
    public void update(ArrayList<Point> world) {
        this.view.draw(world); 
    }
}
