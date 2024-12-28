package Mocks.view;

import Arquitecture.model.Toughness;
import Arquitecture.model.password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameExample extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Password evaluator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));


        JTextField textField = new JTextField();
        textField.setColumns(10);
        panel.add(new JLabel("Write a password:"));
        panel.add(textField);


        JButton button = new JButton("Check toughness");
        panel.add(button);


        JLabel responseLabel = new JLabel();
        responseLabel.setHorizontalAlignment(SwingConstants.CENTER);


        frame.add(panel, BorderLayout.CENTER);
        frame.add(responseLabel, BorderLayout.SOUTH);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText().trim();
                String response = String.valueOf(generateResponse(inputText));
                responseLabel.setText(response);
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }

    private static Toughness generateResponse(String inputText) {
        password password = new password(inputText);
        return password.getToughness();

    }
}