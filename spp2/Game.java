public class Game {
    public static void main(String[] args) {
        Model a = new Model(1000); 
        for (String name : args ) {
            Controller c = new Controller(a); 
            View view = new View(name); 
            c.addView(view); 
        }
        a.start(); 
    }
}
