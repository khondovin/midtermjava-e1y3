
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        try{
            JFrame frame = new JFrame("Lock Class E6");
            JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnEnter;
            JLabel passwordForInput;
            JPasswordField textpassword;
            JPanel gridPanel = new JPanel();
            JPanel controlPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(3,3));

            btnClear = new JButton("Clear");
            btnEnter = new JButton("Enter");
            passwordForInput = new JLabel("Enter Password");
            textpassword = new JPasswordField(15);

            controlPanel.add(btnClear);
            controlPanel.add(textpassword);
            controlPanel.add(btnEnter);
            controlPanel.add(passwordForInput);

            for (int i = 1; i <= 9; i++) {
                JButton buttonForInput = new JButton(String.valueOf(i));
                buttonForInput.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textpassword.setText(textpassword.getText() + buttonForInput.getText());
                    }
                });
                gridPanel.add(buttonForInput);
            }

            btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textpassword.setText("");
                }
            });

            btnEnter.addActionListener(new ActionListener() {
                String savedPassword = "";
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredPassword = textpassword.getText();

                    if (savedPassword.equals("")) {
                        savedPassword = enteredPassword;
                        passwordForInput.setText("Password Set");
                    } else {
                        if (enteredPassword.equals(savedPassword)) {
                            passwordForInput.setText("Correct Password");
                        } else {
                            passwordForInput.setText("Incorrect Password");
                        }
                    }
                    textpassword.setText("");
                }
            });

            frame.setLayout(new BorderLayout());
            frame.add(gridPanel,BorderLayout.NORTH);
            frame.add(controlPanel,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600,400);
            frame.setVisible(true);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}