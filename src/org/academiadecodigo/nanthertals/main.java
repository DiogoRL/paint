package org.academiadecodigo.nanthertals;

import org.academiadecodigo.nanderthals.Movement;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        Movement movement = null;
        Grid grid = new Grid(20, 20, movement);
        Rectangle rec = new Rectangle();
        rec.draw();
        movement = new Movement(grid);

    }
}
