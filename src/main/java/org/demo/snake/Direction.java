
package org.demo.snake;

/**
 * Direction.
 * 
 * @author alitvinov
 */
public enum Direction {
    
    UP, DOWN, LEFT, RIGHT;      
    
    public static Direction getDirection(char symbol) {
        switch(symbol) {
            case 'w':
                return UP;
            case 's':
                return DOWN;
            case 'a':
                return LEFT;
            case 'd':
                return RIGHT;
            default:
                return null;
        }
    }
}
