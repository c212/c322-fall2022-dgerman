import java.util.*;

public class Controller {
    Model model;
    View view;
    int id; 
    public void setTime(int count) {
        view.showTime(count); 
    }
    public void move(int direction) {
        this.model.signalFrom(this.id, direction); 
    }
    public Controller(Model model) {
        this.model = model; 
        this.model.register(this); 
    }
    public void addView(View view) {
        this.view = view; 
        this.view.addController(this); 
    }
}
