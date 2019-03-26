package org.demo.snake;

/**
 * Snake.
 *
 * @author alitvinov
 */
public class Snake {

    public final static Direction INITIAL_DIRECTION = Direction.RIGHT;

    private final SnakePart[] snakeParts;

    public Snake(int size, int xPos, int yPos, AbstractGameField gameField) {
        this.snakeParts = new SnakePart[size];
        xPos -= -size;
        for (int i = size - 1; i >= 0; i--) {
            snakeParts[i] = new SnakePart(i, gameField, xPos, yPos, INITIAL_DIRECTION, i == size - 1 ? null : snakeParts[i + 1]);
            //locate snake horizontally
            xPos += 1;
        }
    }

    public void move() {
        SnakePart head = snakeParts[0];
        head.move();
    }

    public void changeDirection(Direction d) {
        if (d != null) {
            SnakePart head = snakeParts[0];
            head.changeDirection(d);
        }
    }
}
