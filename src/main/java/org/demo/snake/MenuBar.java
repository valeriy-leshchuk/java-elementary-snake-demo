package org.demo.snake;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar
{
    private JMenu gameMenu_ = new JMenu("Game");
    private JMenuItem start_ = new JMenuItem("Start");
    private JMenuItem reset_ = new JMenuItem("Reset");
    private JMenuItem exit_ = new JMenuItem("Exit");
    private JMenu settingsMenu_ = new JMenu("Settings");
    private JMenuItem preferences_ = new JMenuItem("Preferences");
    private JMenuItem speedUp_ = new JMenuItem("Speed up");
    private JMenuItem slowDown_ = new JMenuItem("Slow down");

    public MenuBar()
    {
        gameMenu_.add(start_);
        gameMenu_.add(reset_);
        gameMenu_.addSeparator();
        gameMenu_.add(exit_);
        add(gameMenu_);
        settingsMenu_.add(preferences_);
        settingsMenu_.addSeparator();
        settingsMenu_.add(speedUp_);
        settingsMenu_.add(slowDown_);
        add(settingsMenu_);
    }

    public JMenuItem getExit()
    {
        return exit_;
    }

    public JMenuItem getPreferences()
    {
        return preferences_;
    }


    //TODO:make it able to scan all inner elements automatically
    public JMenuItem[] getAllMenuItems()
    {
        return new JMenuItem[]{start_, reset_, exit_,preferences_,speedUp_,slowDown_};
    }

}
