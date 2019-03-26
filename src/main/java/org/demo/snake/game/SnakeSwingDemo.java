package org.demo.snake.game;

import org.demo.snake.Snake;
import org.demo.snake.SwingField;

/**
 * SnakeSwingDemo.
 *
 * @author alitvinov
 */
public class SnakeSwingDemo {

    public static void main(String[] args) throws Exception {

        int xSize = 30;
        int ySize = 30;
        int coordinateFactor = 30;

        SwingField gameField = new SwingField(xSize, ySize, coordinateFactor);

        int xPosition = 8;
        int yPosition = 8;
        int snakeParts = 8;

        Snake snake = new Snake(xPosition, yPosition, snakeParts, gameField);

        gameField.setSnake(snake);
        gameField.redraw();
        while (true) {
            Thread.sleep(1000);
            snake.move();
            gameField.redraw();
        }
    }

}
