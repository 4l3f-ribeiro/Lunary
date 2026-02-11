package mtcc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomodoroClass {
    private int minutes = 0;
    private int seconds = 0;
    private Timer timer;
    private JLabel timerLabel;
    private JButton startButton;
    private JTextField minutesField, secondsField;

    public PomodoroClass() {
        JFrame frame = new JFrame("Pomodoro Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null);

        timerLabel = new JLabel("Tempo Restante: 00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        timerLabel.setBackground(Color.DARK_GRAY);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        minutesField = new JTextField(2);
        secondsField = new JTextField(2);
        startButton = new JButton("Começar Pomodoro");
        startButton.setBackground(new Color(30, 144, 255));
        startButton.setForeground(Color.white);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);

        startButton.addActionListener(e -> startTimer());

        inputPanel.add(new JLabel("Minutes: "));
        inputPanel.add(minutesField);
        inputPanel.add(new JLabel("Seconds: "));
        inputPanel.add(secondsField);
        inputPanel.add(startButton);

        frame.add(timerLabel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void startTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        try {
            minutes = Integer.parseInt(minutesField.getText());
            seconds = Integer.parseInt(secondsField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalido");
            return;
        }

        int totalSeconds = minutes * 60 + seconds + 1;
        timer = new Timer(1000, new ActionListener() {
            int count = totalSeconds;

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 0) {
                    int remainingMinutes = count / 60;
                    int remainingSeconds = count % 60;
                    timerLabel.setText(String.format("Tempo Restante: %02d:%02d", remainingMinutes, remainingSeconds));
                } else {
                    timer.stop();
                    timerLabel.setText("O tempo acabou!");
                }
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroClass::new);
    }
}
