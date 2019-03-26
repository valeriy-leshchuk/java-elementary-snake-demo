package org.demo.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class SwingField extends AbstractGameField {

    private final int coordinateFactor;

    final int xStart, yStart;

    {
        xStart = yStart = 0;
    }

    public SwingField(int xSize, int ySize, int coordinateFactor) {
        super(xSize, ySize);
        this.coordinateFactor = coordinateFactor;
        JFrame f = new JFrame("Demo Snake Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xStart, yStart, xSize * coordinateFactor, ySize * coordinateFactor);
        this.setBackground(Color.white);
        f.add(this);
        f.setSize(this.getWidth(), this.getHeight());
        f.setVisible(true);
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                setDirectionToSnake(symbol);
            }
        });
    }

    @Override
    public void redraw() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphicsProvider) {
        graphicsProvider.clearRect(xStart, yStart, getxSize() * coordinateFactor, getySize() * coordinateFactor);
        byte grid[][] = this.getFieldGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int x = j;
                int y = i;
                if (grid[i][j] != 0) {
                    graphicsProvider.fillRect(x * coordinateFactor, y * coordinateFactor, coordinateFactor, coordinateFactor);
                }
            }
        }
    }

    private void setDirectionToSnake(char directionSymbol) {
        if (snake != null) {
            this.snake.changeDirection(Direction.getDirection(directionSymbol));
        }
    }
}
