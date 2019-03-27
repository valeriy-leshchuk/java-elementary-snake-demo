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
        int redrawPeriodInMills = 500;
        
        SwingField gameField = new SwingField(xSize, ySize, coordinateFactor);

        int xPosition = 29;
        int yPosition = 8;
        int snakeParts = 25;

        Snake snake = new Snake(snakeParts, xPosition, yPosition, gameField);

        gameField.setSnake(snake);
        gameField.redraw();
        while (true) {
            Thread.sleep(redrawPeriodInMills);
            snake.move();
            gameField.redraw();
        }
    }

}
