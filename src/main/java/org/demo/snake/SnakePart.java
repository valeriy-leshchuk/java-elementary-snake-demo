package org.demo.snake;

import static org.demo.snake.Snake.INITIAL_DIRECTION;
import java.util.AbstractMap.SimpleEntry;

/**
 * SnakePart.
 *
 * @author alitvinov
 */
public class SnakePart {

    private Direction currentDirrection;

    private Direction nextDirection;

    private int numInSnake;

    private final AbstractGameField field;

    private int n;

    private int p;

    private SnakePart previous;
   

    public SnakePart(int numInSnake, AbstractGameField field, int n, int p, Direction direction, SnakePart previous) {
        this.numInSnake = numInSnake;
        currentDirrection = nextDirection = direction;
        this.field = field;
        SimpleEntry<Integer, Integer> position = field.setPositionOccupied(n, p, n, p);
        this.n = position.getKey();
        this.p = position.getValue();
        this.previous = previous;
    }

    public void move() {        
        SimpleEntry<Integer, Integer> e = field.setPositionOccupied(n, p, getNewPosition(n, true), getNewPosition(p, false));
        this.n = e.getKey();
        this.p = e.getValue();        
        if (previous != null) {
            previous.move();
        }
        if (currentDirrection != nextDirection) {            
            currentDirrection = nextDirection;
            shiftDirection(this);
        }
    }

    public void changeDirection(Direction d) {
        if (    numInSnake != 0
                || currentDirrection == d
                || (currentDirrection == Direction.LEFT && d == Direction.RIGHT)
                || (currentDirrection == Direction.RIGHT && d == Direction.LEFT)
                || (currentDirrection == Direction.UP && d == Direction.DOWN)
                || (currentDirrection == Direction.DOWN && d == Direction.UP)) {
            return;
        }        
        currentDirrection = nextDirection = d;
        shiftDirection(this);
    }
    
    private void shiftDirection(SnakePart snakePart) {        
        if (snakePart.previous != null) {
            snakePart.previous.nextDirection = snakePart.currentDirrection;            
            shiftDirection(snakePart.previous);
        }
    }

    private int getNewPosition(int pos, boolean horizontal) {
        if (horizontal) {
            if (currentDirrection == Direction.LEFT) {
                return pos - 1;
            } else if (currentDirrection == Direction.RIGHT) {
                return pos + 1;
            } else {
                return pos;
            }
        } else {
            if (currentDirrection == Direction.DOWN) {
                return pos + 1;
            } else if (currentDirrection == Direction.UP) {
                return pos - 1;
            } else {
                return pos;
            }
        }
    }
}
