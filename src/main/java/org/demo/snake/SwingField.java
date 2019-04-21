package org.demo.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class SwingField extends AbstractGameField{

    private final int coordinateFactor;
    private boolean gameIsPaused_;
    private MenuBar menuBar_;
    JFrame mainAppFrame_;

    final int xStart, yStart;

    {
        xStart = yStart = 0;
    }

    public SwingField(int xSize, int ySize, int coordinateFactor) {
        super(xSize, ySize);
        this.coordinateFactor = coordinateFactor;
        mainAppFrame_ = new JFrame("Demo Snake Game");
        mainAppFrame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xStart, yStart, xSize * coordinateFactor, ySize * coordinateFactor);
        this.setBackground(Color.white);
        mainAppFrame_.add(this);
        menuBar_ = new MenuBar();
        mainAppFrame_.setJMenuBar(menuBar_);
        setMenuMouseListeners();
        setMenuActionListeners();
        mainAppFrame_.setSize(this.getWidth(), this.getHeight());
        mainAppFrame_.setVisible(true);
        mainAppFrame_.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                setDirectionToSnake(symbol);
            }
        });
    }

    @Override
    public void redraw() {
        while (gameIsPaused_)
        {
            try{Thread.sleep(0);}
            catch (InterruptedException ex){}
        }
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

    private void setMenuActionListeners()
    {
        menuBar_.getExit().addActionListener(e -> System.exit(0));
        menuBar_.getPreferences().addActionListener(e -> openPreferencesDialog());
    }

    private void openPreferencesDialog()
    {
        JDialog prefFrame = new JDialog(mainAppFrame_, "Preferences", true);
        prefFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        prefFrame.setSize(100, 240);
        prefFrame.setResizable(false);
        prefFrame.setContentPane(new PreferencesEditorPanel());
        gameIsPaused_ = true;
        prefFrame.setVisible(true);
        gameIsPaused_ = false;
    }

    private void setMenuMouseListeners()
    {
        menuBar_.addMouseListener(new MenuMouseListener());
        for (MenuElement elem : menuBar_.getSubElements())
        {
            ((JMenu) elem).addMouseListener(new MenuMouseListener());
        }
        for (JMenuItem item : menuBar_.getAllMenuItems())
        {
            item.addMouseListener(new MenuMouseListener());
        }
    }

    private class MenuMouseListener implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            gameIsPaused_ = true;
        }

        @Override
        public void mousePressed(MouseEvent e){}

        @Override
        public void mouseReleased(MouseEvent e){}

        @Override
        public void mouseEntered(MouseEvent e)
        {
            gameIsPaused_ = true;
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            gameIsPaused_ = false;
        }
    }
}
