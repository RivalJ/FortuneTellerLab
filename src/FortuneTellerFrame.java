import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {
    private JPanel top, middle, bottom;
    JTextArea textArea = new JTextArea(20,50);
    JButton readButton = new JButton("Read My Fortune!");
    JButton quitButton = new JButton("Quit");
    ArrayList<String> fortunes = new ArrayList<>();
    private int previousFortune;

    public FortuneTellerFrame() {
        Dimension baseScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        float applicationScaleFactor = 3f/4f;
        Dimension applicationSize = new Dimension(
                (int)(baseScreenSize.width * applicationScaleFactor),
                (int)(baseScreenSize.height * applicationScaleFactor)
        );

        super.setTitle("Fortune Teller");
        super.setSize(applicationSize.width, applicationSize.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());

        SetUpTopPanel();
        SetUpMiddlePanel();
        SetUpBottomPanel();
        CreateFortunes();

        super.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void SetUpTopPanel(){
        top = new JPanel();
        JLabel label = new JLabel("Fortune Teller");
        label.setFont(new Font("Arial", Font.BOLD, 48));

        Image icon = new ImageIcon(getClass().getResource("fortune.jpg")).getImage();
        icon = icon.getScaledInstance(100,100,Image.SCALE_SMOOTH);

        label.setIcon(new ImageIcon(icon));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        top.add(label);
        super.add(top, BorderLayout.PAGE_START);
    }
    private void SetUpMiddlePanel(){
        middle = new JPanel();

        Font middleFont = new Font("SansSerif", Font.ITALIC, 20);
        textArea.setFont(middleFont);
        JScrollPane scrollPane = new JScrollPane(textArea);//create scroll pane and add the text area to it
//        scrollPane.setPreferredSize(
//                new Dimension(
//                        middleFont.getSize()*20,
//                        middleFont.getSize()*10
//                )
//        );
        textArea.setEditable(false);

        middle.add(scrollPane);

        super.add(middle, BorderLayout.CENTER);
    }//FIXME: needs a font
    private void SetUpBottomPanel(){
        bottom = new JPanel();

        readButton.addActionListener(e -> textArea.append("\n" +GetRandomFortune()));
        quitButton.addActionListener(e -> System.exit(0));
        Font bottomFont = new Font("Dialog", Font.BOLD, 20);

        readButton.setFont(bottomFont);
        quitButton.setFont(bottomFont);

        bottom.add(readButton);
        bottom.add(quitButton);
        super.add(bottom, BorderLayout.PAGE_END);
    }//FIXME: needs a font

    private String GetRandomFortune(){
        String fortune;//the fortune we will return
        int randomIndex = (int)(Math.random()*fortunes.size());//a random index we use to select a fortune from our list
        if(previousFortune == randomIndex){//if our index is the same as last time
            if(randomIndex - 1 >= 0){//if the previous index is valid
                randomIndex--;//get that index
            }
            else{//if the previous index is invalid
                randomIndex++;//get the next index
            }
        }
        previousFortune = randomIndex;//save our previous index/fortune for next time
        fortune = fortunes.get(randomIndex);//get our fortune from the index
        return fortune;
    }
    private void CreateFortunes(){
        fortunes.add("You will have a great day!");
        fortunes.add("You will be happy!");
        fortunes.add("You will feel good!");
        fortunes.add("You will have a great time!");
        fortunes.add("You will walk in a circle 3 times!");
        fortunes.add("You will eat one big yummy egg!");
        fortunes.add("You will meet spiderman!");
        fortunes.add("You will meet batman!");
        fortunes.add("You will meet Homer Simpson!");
        fortunes.add("You will go to the store buy a thing!");
        fortunes.add("You will be a millionaire!");
        fortunes.add("You will be a superhero!");
        fortunes.add("You will be a rock star!");
        fortunes.add("You will be a supermodel!");
    }
}
