package org.academiadecodigo.nanthertals;


import org.academiadecodigo.nanderthals.Movement;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid {

    private Movement movement;
    public static final int PADDING = 10;

    private int cellSize = 10;
    private int cols;
    private int rows;

    private Rectangle[][] cells;

    public Grid(int cols, int rows, Movement movement) {
        this.cols = cols;
        this.rows = rows;
        this.movement = movement;

        int width = cols * cellSize;
        int height = rows * cellSize;

        Rectangle field = new Rectangle(PADDING, PADDING, width, height);
        field.draw();

        cells = new Rectangle[cols][rows];
        createCells();
    }

    private void createCells() {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                int x = getColumnToX(col);
                int y = getRowToY(row);

                Rectangle cell = new Rectangle(x, y, cellSize, cellSize);
                cell.draw();

                cells[col][row] = cell;
            }
        }

    }

    public void printBlack(){
       int x = movement.getX();
       int y = movement.getY();
       Rectangle rectangle = new Rectangle(x, y, PADDING, PADDING);

    }

    public int getColumnToX(int column) {
        return PADDING + cellSize * column;
    }

    public int getRowToY(int row) {
        return PADDING + cellSize * row;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return cellSize;
    }

    public Rectangle[][] getCells() {
        return cells;
    }
}

