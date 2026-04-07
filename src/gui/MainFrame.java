package gui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

import dish.*;
import decorator.*;

public class MainFrame extends JFrame {

    private JCheckBox hotSauce;
    private JCheckBox doubleMeat;
    private JCheckBox berries;
    private JCheckBox bread;

    private JTextArea output;

    public MainFrame() {
        setTitle("Нордское рагу");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel baseLabel = new JLabel("Основное блюдо: Нордское рагу");
        baseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel addLabel = new JLabel("Добавки:");
        addLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(baseLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(addLabel);

        add(topPanel, BorderLayout.NORTH);


        JPanel checkPanel = new JPanel(new GridLayout(4, 1));

        hotSauce = new JCheckBox("Огненный соус (+10)");
        doubleMeat = new JCheckBox("Двойное мясо (+20)");
        berries = new JCheckBox("Ягоды (+6)");
        bread = new JCheckBox("Лепешка (+7)");

        checkPanel.add(hotSauce);
        checkPanel.add(doubleMeat);
        checkPanel.add(berries);
        checkPanel.add(bread);

        add(checkPanel, BorderLayout.CENTER);


        JButton button = new JButton("Заказать");
        button.setPreferredSize(new Dimension(120, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        add(buttonPanel, BorderLayout.SOUTH);


        output = new JTextArea(8, 30);
        output.setEditable(false);

        add(new JScrollPane(output), BorderLayout.EAST);


        hotSauce.addActionListener(e -> updateCheckboxes());
        doubleMeat.addActionListener(e -> updateCheckboxes());
        berries.addActionListener(e -> updateCheckboxes());
        bread.addActionListener(e -> updateCheckboxes());


        button.addActionListener(e -> makeOrder());

        setVisible(true);
    }


    private void updateCheckboxes() {
        int count = 0;

        if (hotSauce.isSelected()) count++;
        if (doubleMeat.isSelected()) count++;
        if (berries.isSelected()) count++;
        if (bread.isSelected()) count++;

        boolean disable = count >= 3;

        if (!hotSauce.isSelected()) hotSauce.setEnabled(!disable);
        if (!doubleMeat.isSelected()) doubleMeat.setEnabled(!disable);
        if (!berries.isSelected()) berries.setEnabled(!disable);
        if (!bread.isSelected()) bread.setEnabled(!disable);
    }

    private void makeOrder() {
        Dish dish = new BaseRagy();

        if (hotSauce.isSelected()) {
            dish = new HotSauce(dish);
        }

        if (doubleMeat.isSelected()) {
            dish = new DoubleMeat(dish);
        }

        if (berries.isSelected()) {
            dish = new Berries(dish);
        }

        if (bread.isSelected()) {
            dish = new Bread(dish);
        }

        String time = LocalTime.now().withNano(0).toString();

        output.append(time + " | " +
                dish.getDescription() +
                " | " + dish.getCost() + " септимов\n");
    }
}