package main;



import graphics.DrawingSurface;
import graphics.Window;

public class App {
    private static boolean ejecuting = false;

    public static void main(String[] args) throws Exception {
        StartGame();
        if (ejecuting) {
            
        }
    }

    private static void StartGame() {
        ejecuting = true;

        Starter();
    }

    private static void Stop() {
        ejecuting = false;

        System.exit(0);
    }

    private static void Starter() {
        createWindow(800,600, "Fate's path");
    }

    private static void update() {
        
    }

    private static void draw() {
        
    }

    private static void mainIterator() {
        System.nanoTime();
        
        while(ejecuting) {
        
        }
    }

    private static void createWindow(int width, int height, String name) {
        DrawingSurface ds = new DrawingSurface(width, height);
        Window window = new Window(name, ds);
    }
}
