import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntegerInputVerifier extends JFrame {
    private JLabel messageLabel;
    private JTextField textField;

    public IntegerInputVerifier() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Integer Input Verifier");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the components
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter an integer:");
        textField = new JTextField(10);
        JButton verifyButton = new JButton("Verify");
        JButton cancelButton = new JButton("Cancel");
        messageLabel = new JLabel("");

        // add the components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(verifyButton);
        panel.add(cancelButton);
        panel.add(messageLabel);

        // add action listeners to the buttons
        verifyButton.addActionListener(new VerifyButtonListener());
        cancelButton.addActionListener(new CancelButtonListener());

        // add the panel to the frame
        add(panel);

        setVisible(true);
    }

    private class VerifyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = textField.getText();
            try {
                int value = Integer.parseInt(input);
                messageLabel.setText(input + " is an integer.");
            } catch (NumberFormatException ex) {
                messageLabel.setText(input + " is not an integer.");
            }
        }
    }

    private class CancelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new IntegerInputVerifier().setVisible(true);
        });
    }
}

