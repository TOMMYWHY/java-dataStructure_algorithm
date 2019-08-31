package s01.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI test");


        JPanel panel = new JPanel();
        JButton button1 = new JButton("Yes");
        JButton button2 = new JButton("No");
        Label label = new Label("Do you love me ？");
        panel.add(label);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click btn");

                frame.setBounds(100,100,300,120);
            }
        };
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        button2.addActionListener(listener2);
        button1.addActionListener(listener1);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,300,300,120);

    }

}
