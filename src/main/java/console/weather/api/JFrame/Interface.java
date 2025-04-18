package console.weather.api.JFrame;

import javax.swing.*;

public class Interface extends JFrame {
    public static void main(String[] args) {
        JFrame visual = new JFrame("Meteo");
        visual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        visual.setSize(400,300);
        JPanel panel=new JPanel();

        JLabel label=new JLabel("Input your city");
        JTextField textField=new JTextField(200);
        JButton button=new JButton("Press when you make your chose");

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        visual.add(panel);

        visual.setVisible(true);
    }
}
