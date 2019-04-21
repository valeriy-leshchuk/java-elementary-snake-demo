package org.demo.snake;

import javax.swing.*;
import java.awt.*;

public class PreferencesEditorPanel extends JPanel
{
    private static final Insets defaultInsets_ = new Insets(0, 0, 0, 0);


    private final JLabel initSnakeSizeLabel_ = new JLabel("Init snake size");
    private final JTextField initSnakeSizeField_ = new JTextField();

    private final JLabel redrawFrequencyLabel_ = new JLabel("Redraw frequency");
    private final JTextField redrawFrequencyField_ = new JTextField();


    private JPanel keyLayoutPanel_;
    private final JLabel keyLayoutLabel_ = new JLabel("Key layout");

    private final JLabel moveUpLabel_ = new JLabel("\u2191");
    private final JTextField moveUpField_ = new JTextField();
    private final JLabel moveDownLabel_ = new JLabel("\u2193");
    private final JTextField moveDownField_ = new JTextField();
    private final JLabel moveLeftLabel_ = new JLabel("\u2190");
    private final JTextField moveLeftField_ = new JTextField();
    private final JLabel moveRightLabel_ = new JLabel("\u2192");
    private final JTextField moveRightField_ = new JTextField();



    public PreferencesEditorPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(initSnakeSizeLabel_);
        add(initSnakeSizeField_);
        add(redrawFrequencyLabel_);
        add(redrawFrequencyField_);
        add(keyLayoutLabel_);
        keyLayoutPanel_ = createKeyLayoutPanel(createKeyLayoutBlock(moveUpLabel_, moveUpField_),
                                                createKeyLayoutBlock(moveDownLabel_, moveDownField_),
                                                createKeyLayoutBlock(moveLeftLabel_, moveLeftField_),
                                                createKeyLayoutBlock(moveRightLabel_, moveRightField_)
        );
        add(keyLayoutPanel_);
    }


    private JPanel createKeyLayoutBlock(JLabel label, JTextField field)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(field);
        label.setPreferredSize(new Dimension(30,10));
        return panel;
    }

    private JPanel createKeyLayoutPanel(JPanel up, JPanel down, JPanel left, JPanel right)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(up, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        panel.add(left, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        panel.add(right, new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        panel.add(down, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, defaultInsets_, 0, 0));
        return panel;
    }
}
