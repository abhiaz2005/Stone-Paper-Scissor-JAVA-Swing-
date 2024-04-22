import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game extends JFrame implements ActionListener {

    private JFrame jFrame;
    private JTextArea jTextArea;
    private JButton stone, paper, scissor, restart;
    private JLabel jLabel;
    int option, comp;
    int iter = 0;

    game() {
        jFrame = new JFrame("Rock-Paper-Scissor");
        jTextArea = new JTextArea("You can start here >>>");
        jLabel = new JLabel();
        // Instance of Buttons
        stone = new JButton("Stone");
        paper = new JButton("Paper");
        scissor = new JButton("Scissor");
        restart = new JButton("Restart");

        // size
        jTextArea.setBounds(60, 65, 300, 47);
        stone.setBounds(50, 140, 100, 60);
        paper.setBounds(160, 140, 100, 60);
        scissor.setBounds(270, 140, 100, 60);
        restart.setBounds(100, 230, 200, 50);
        jLabel.setBounds(50, 20, 300, 50);

        // setEditable
        jTextArea.setEditable(false);

        // actionlisteners
        ActionListeners();
        // add
        jFrame.add(stone);
        jFrame.add(paper);
        jFrame.add(scissor);
        jFrame.add(jTextArea);
        jFrame.add(jLabel);
        jFrame.add(restart);

        // Set font for JTextArea
        Font textAreaFont = new Font("Arial", Font.BOLD, 16); // Adjust size and style as needed
        jTextArea.setFont(textAreaFont);

        // Last Items
        jFrame.setLayout(null);
        jFrame.getContentPane().setBackground(Color.BLACK);
        jLabel.setForeground(Color.WHITE);
        jFrame.setSize(450, 450);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void ActionListeners() {
        stone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Stone) {
                option = 1;
                comp = randomNumbers();

                if (comp == 1) {
                    jLabel.setText(jLabel.getText() + " =");
                    jTextArea.setText("Comp: " + "Stone" + "\nYou: " + "Stone");
                } else if (comp == 2) {
                    jLabel.setText(jLabel.getText() + " \u2717");
                    jTextArea.setText("Comp: " + "Paper" + "\nYou: " + "Stone");
                } else {
                    jTextArea.setText("Comp: " + "Scissor" + "\nYou: " + "Stone");
                    jLabel.setText(jLabel.getText() + " \u2713");
                }
            }
        });

        paper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Paper) {
                option = 2;
                comp = randomNumbers();
                if (comp == 1) {
                    jLabel.setText(jLabel.getText() + " \u2713");
                    jTextArea.setText("Comp: " + "Stone" + "\nYou: " + "Paper");
                } else if (comp == 2) {
                    jLabel.setText(jLabel.getText() + " =");
                    jTextArea.setText("Comp: " + "Paper" + "\nYou: " + "Paper");
                } else {
                    jTextArea.setText("Comp: " + "Scissor" + "\nYou: " + "Paper");
                    jLabel.setText(jLabel.getText() + " \u2717");
                }
            }
        });

        scissor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Scissor) {
                option = 3;
                comp = randomNumbers();
                if (comp == 1) {
                    jLabel.setText(jLabel.getText() + " \u2717");
                    jTextArea.setText("Comp: " + "Stone" + "\nYou: " + "Scissor");
                } else if (comp == 2) {
                    jLabel.setText(jLabel.getText() + " \u2713");
                    jTextArea.setText("Comp: " + "Paper" + "\nYou: " + "Scissor");
                } else {
                    jTextArea.setText("Comp: " + "Scissor" + "\nYou: " + "Scissor");
                    jLabel.setText(jLabel.getText() + " =");
                }
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Scissor) {
                jTextArea.setText("");
                jLabel.setText("You can now begin >>>");
                jFrame.setVisible(false);
                new game();
            }
        });

    }

    // generate random number
    public int randomNumbers() {
        int rand = (int) (Math.random() * 3) + 1;
        if (rand == 1) {
            return 1;
        } else if (rand == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        new game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
