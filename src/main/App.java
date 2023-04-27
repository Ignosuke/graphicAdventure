package main;


import graphics.DrawingSurface;
import graphics.Window;

public class App {
    private static boolean ejecuting = false;

    private static int updates_per_second = 0;
    private static int frames_per_second = 0;

    private static DrawingSurface drawingSurface;
    private static Window window;

    public static void main(String[] args) throws Exception {
        StartGame();
        mainIterator();
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
        createWindow(1280,720, "Fate's path");
    }
    
    private static void createWindow(int width, int height, String name) {
        drawingSurface = new DrawingSurface(width, height);
        window = new Window(name, drawingSurface);
    }

    private static void update() {
        updates_per_second++;
    }

    private static void draw() {
        drawingSurface.draw();
        frames_per_second++;
    }

    private static void mainIterator() {
        final int NANOS_PER_SECOND = 1000000000;
        final int UPDATES_PER_SECOND_AIMED = 60;
        final double NANOS_PER_UPDATE = NANOS_PER_SECOND / UPDATES_PER_SECOND_AIMED;

        long referenceUpdateTime = System.nanoTime();
        long referenceUpdateCounter = System.nanoTime();

        double unprocessedTime;
        double delta = 0;
        
        while(ejecuting) {
            long starterTime = System.nanoTime();
            unprocessedTime = starterTime - referenceUpdateTime;
            referenceUpdateTime = starterTime;

            delta += unprocessedTime / NANOS_PER_UPDATE;

            while (delta >= 1) {
                update();
                delta = 0;
            }
            draw();

            if (System.nanoTime() - referenceUpdateCounter >= NANOS_PER_SECOND) {
                System.out.println("UPS: " + updates_per_second + " FPS: " + frames_per_second);
                window.setTitle("Fate's path FPS:" + frames_per_second + " UPS:" + updates_per_second);

                referenceUpdateCounter = System.nanoTime();

                updates_per_second = 0;
                frames_per_second = 0;
            }
        }
    }
}
