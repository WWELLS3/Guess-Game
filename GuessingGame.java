
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;

public class GuessingGame extends JFrame {

    private static final long serialVersionUID = 1L;
    public static Object prompt1;
    private JTextField userInput;
    private JLabel comment = new JLabel(" ");
    private JLabel comment2 = new JLabel(" ");
    private int randomNumber;
    private int counter = 0;

    // Constructor
    public GuessGame() {
        super("Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Content pane
        setLayout(new FlowLayout());
        Container c = getContentPane();

        // Create components
        JButton guessButton = new JButton("Try the number");
        JButton newGameButton = new JButton("New Game");
        JButton quitButton = new JButton("Quit");
        JLabel prompt1 = new JLabel("I have a number between 1 and 1000.");
        JLabel prompt2 = new JLabel("Can you guess the number?");
        JLabel prompt3 = new JLabel("Please enter your guess: ");
        comment = new JLabel(" ");
        comment2 = new JLabel(" ");
        userInput = new JTextField(5);

// Adding components to the pane
        c.add(prompt1);
        c.add(prompt2);
        c.add(prompt3);
        c.add(userInput);
        c.add(guessButton);
        c.add(newGameButton);
        c.add(quitButton);
        c.add(comment);
        c.add(comment2);

// Set the mnemonic
        guessButton.setMnemonic('T');
        newGameButton.setMnemonic('N');
        quitButton.setMnemonic('Q');

// Format pane
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initializeNumber();

// Create the button handlers
        GuessButtonHandler ghandler = new GuessButtonHandler(); // instantiate

        guessButton.addActionListener(ghandler); // add event listener

        NewButtonHandler nhandler = new NewButtonHandler();
        newGameButton.addActionListener(nhandler);

        QuitButtonHandler qhandler = new QuitButtonHandler();
        quitButton.addActionListener(qhandler);
    }

    private void initializeNumber() {
        randomNumber = new Random().nextInt(1000) + 1;
    }

    // GuessButton inner class
    private class GuessButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

// Declare class variables
            int getUserInput;
            int diff;
            int Difference;

            try {
                getUserInput = Integer.parseInt(userInput.getText().trim());
                counter++;

                if (getUserInput == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Correct! It took you "
                            + counter + " guesses", "Random Number: "
                            + randomNumber, JOptionPane.INFORMATION_MESSAGE);
                    initializeNumber();
                    return;
                }
                if (getUserInput > randomNumber) {
                    comment2.setText("The guess was too HIGH. Try a lower number.");
                    comment2.setForeground(Color.WHITE);
                    diff = getUserInput - randomNumber;
                    Difference = Math.abs(diff);
                } else {
                    comment2.setText("The guess was too LOW. Try a higher number.");
                    comment2.setForeground(Color.WHITE);
                    diff = randomNumber - getUserInput;
                    Difference = Math.abs(diff);
                }

                if (Difference >= 30) {
                    comment.setText("You are Cold. ");
                    comment.setForeground(Color.WHITE);
                    GuessGame.this.setBackgroundColor(Color.BLUE);
                }

                if (Difference <= 15) {
                    comment.setText("You are getting Warm");
                    comment.setForeground(Color.WHITE);
                    GuessGame.this.setBackgroundColor(Color.RED);
                }
            } catch (NumberFormatException ex) {
                comment.setText("Enter a VALID number!");
            }
        }
    }

    // NewButton inner class
    private class NewButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuessGame app = new GuessGame();

        }
    }

    // QuitButton inner class
    private class QuitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // Setting background color
    private void setBackgroundColor(Color RED) {
        getContentPane().setBackground(RED);
    }

    // Main method
    public static void main(String args[]) {
// instantiate GuessGame object
        GuessGame app = new GuessGame();

    }// End main method
}// Will Wells program 6
