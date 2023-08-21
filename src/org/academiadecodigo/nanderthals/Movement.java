package org.academiadecodigo.nanderthals;

import org.academiadecodigo.nanthertals.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Movement implements KeyboardHandler {

    private Keyboard keyboard;
    private Rectangle rect;
    private Grid grid;
    private int x;
    private int y;
    private Rectangle rectangle;


    public int getX() {
        return rect.getX();
    }

    public int getY() {
        return rect.getY();
    }

    public Movement(Grid grid) {
        keyboard = new Keyboard(this);
        addKeyboard();
        rect = new Rectangle(10, 10, 10, 10);
        rect.fill();
        rect.getColor();
        this.grid = grid;

    }

    private void addKeyboard() {
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(39);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(37);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);


        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(40);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);


        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);


        KeyboardEvent printBlack = new KeyboardEvent();
        printBlack.setKey(32);
        printBlack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(printBlack);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKey(88);
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(delete);


    }


    public void moveRight() {
        if (rect.getX() < grid.getColumnToX(grid.getCols() - 1)) {
            //System.out.println(rect.getX());
            rect.translate(10, 0);
        }
    }

    public void moveLeft() {
        if (rect.getX() > Grid.PADDING) {
            rect.translate(-10, 0);
        }
    }

    public void moveDown() {
        if (rect.getY() < grid.getRowToY(grid.getRows() - 1)) {
            //System.out.println(rect.getY());
            rect.translate(0, 10);
        }
    }

    public void moveUp() {
        if (rect.getY() > Grid.PADDING) {
            rect.translate(0, -10);
        }
    }

    public void printBlack() {
        Rectangle[][] cells = this.grid.getCells();
        //System.out.println("out for");
        for (int i = 0; i < cells.length; i++) {
            //System.out.println("1st for : " + cells.length);
            for (int j = 0; j < cells[i].length; j++) {
                //System.out.println("2nd for : " + cells[i].length);
                if (rect.getX() == cells[i][j].getX()) {
                    //System.out.println("X IGUAL CARALHO");
                    if (rect.getY() == cells[i][j].getY()) {
                        System.out.println(" painting ");
                        cells[i][j].setColor(Color.BLACK);
                        cells[i][j].draw();
                        cells[i][j].fill();

                    }
                }
            }
        }
    }

    public void delete() {
        Rectangle[][] cells = this.grid.getCells();
        //System.out.println("out for");
        for (int i = 0; i < cells.length; i++) {
            //System.out.println("1st for : " + cells.length);
            for (int j = 0; j < cells[i].length; j++) {
                //System.out.println("2nd for : " + cells[i].length);
                if (rect.getX() == cells[i][j].getX()) {
                    //System.out.println("X IGUAL CARALHO");
                    if (rect.getY() == cells[i][j].getY()) {
                        System.out.println(" X E Y igual");
                        System.out.println("----->" + cells[i][j].isFilled());

                        if (cells[i][j].isFilled()) {
                            System.out.println("is filled");
                            cells[i][j].setColor(Color.WHITE);
                            cells[i][j].draw();
                            cells[i][j].fill();
                        }
                    }
                }
            }
        }
    }

    public void togglePaint(){
        Rectangle[][] cells = this.grid.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (rect.getX() == cells[i][j].getX()) {
                    if (rect.getY() == cells[i][j].getY()) {
                        if (!cells[i][j].isFilled()) {
                            cells[i][j].setColor(Color.BLACK);
                            //cells[i][j].draw();
                            cells[i][j].fill();
                            return;
                        }
                        cells[i][j].draw();
                    }
                }
            }
        }
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int keyPressed = keyboardEvent.getKey();

        if (keyPressed == 39) {
            moveRight();
            return;
        }

        if (keyPressed == 37) {
            moveLeft();
            return;
        }
        if (keyPressed == 40) {
            moveDown();
            return;
        }
        if (keyPressed == 38) {
            moveUp();
            return;
        }
        if (keyPressed == 32) {
            //printBlack();
            togglePaint();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

