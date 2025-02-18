import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneTextArea;
    private ArrayList<String> fortunes;
    private String lastFortune = "";

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Top panel with JLabel and ImageIcon
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 48));
        titleLabel.setIcon(new ImageIcon("fortuneTellerImage.png"));
        topPanel.add(titleLabel);

        // Middle panel with JTextArea inside JScrollPane
        JPanel middlePanel = new JPanel();
        fortuneTextArea = new JTextArea(10, 40);
        fortuneTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane);

        // Bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.addActionListener((ActionEvent e) -> readFortune());
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // Add panels to the frame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes list
        fortunes = new ArrayList<>();
        fortunes.add("You will soon encounter a mysterious stranger.");
        fortunes.add("Beware of squirrels with hats.");
        fortunes.add("A fortune cookie will change your life.");
        fortunes.add("The secret to happiness is a good sandwich.");
        fortunes.add("Your next adventure involves a lot of cheese.");
        fortunes.add("You will find your destiny... in a sock drawer.");
        fortunes.add("Beware of the full moon... it’s actually a banana.");
        fortunes.add("You will soon discover a hidden talent for dancing.");
        fortunes.add("You will soon make a friend who loves pizza as much as you.");
        fortunes.add("A llama will play a pivotal role in your future.");
        fortunes.add("Your future involves a lot of rubber ducks.");
        fortunes.add("You will soon find the meaning of life in a crossword puzzle.");
    }

    private void readFortune() {
        Random rand = new Random();
        String newFortune;
        do {
            int index = rand.nextInt(fortunes.size());
            newFortune = fortunes.get(index);
        } while (newFortune.equals(lastFortune)); // Ensure fortune is not the same as the last one

        lastFortune = newFortune;
        fortuneTextArea.append(newFortune + "\n");
    }
}
