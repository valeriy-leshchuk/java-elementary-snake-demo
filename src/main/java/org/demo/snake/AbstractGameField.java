package org.demo.snake;

import java.util.AbstractMap.SimpleEntry;
import javax.swing.JPanel;

/**
 * AbstractGameField.
 *
 * @author alitvinov
 */
public abstract class AbstractGameField extends JPanel {

    private final int xSize;

    private final int ySize;

    private byte[][] fieldGrid;

    protected Snake snake;

    public AbstractGameField(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        fieldGrid = new byte[ySize][xSize];
    }

    public SimpleEntry<Integer, Integer> setPositionOccupied(int xPrevious, int yPrevious, int x, int y) {
        int xOld_ = correct(xPrevious, false);
        int yOld_ = correct(yPrevious, true);
        fieldGrid[yOld_][xOld_] = 0;

        x = correct(x, false);
        y = correct(y, true);
        fieldGrid[y][x] = 1;
        return new SimpleEntry<>(x, y);
    }

    public abstract void redraw();

    private int correct(int n, boolean vertical) {
        if (!vertical) {
            if (n < 0) {
                n = xSize - 1;
            } else if (n >= xSize) {
                n = 0;
            }
        } else {
            if (n < 0) {
                n = ySize - 1;
            } else if (n >= ySize) {
                n = 0;
            }
        }
        return n;
    }

    public byte[][] getFieldGrid() {
        return fieldGrid;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

}
