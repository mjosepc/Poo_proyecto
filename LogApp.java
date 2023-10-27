import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LogApp {
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    private Map<String, String> userDatabase; // Almacena usuarios y contraseñas

    public LogApp() {
        frame = new JFrame("Login and Signup");
        panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        signupButton = new JButton("Sign Up");

        userDatabase = new HashMap<>();
        userDatabase.put("usuario1", "contrasena1");
        userDatabase.put("usuario2", "contrasena2");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });

        frame.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Login failed. Invalid username or password.");
        }
    }

    private void signup() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (!userDatabase.containsKey(username)) {
            userDatabase.put(username, password);
            JOptionPane.showMessageDialog(frame, "Sign up successful! You can now login.");
        } else {
            JOptionPane.showMessageDialog(frame, "Username already exists. Try a different username.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LogApp();
            }
        });
    }
}
