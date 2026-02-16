import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {
    private JPanel top, middle, bottom;
    JTextArea textArea = new JTextArea(10,1);
    JButton readButton = new JButton("Read My Fortune!");
    JButton quitButton = new JButton("Quit");
    ArrayList<String> fortunes = new ArrayList<>();
    private int previousFortune;

    public FortuneTellerFrame() {
        Dimension baseScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension applicationSize = new Dimension(baseScreenSize.width/3,baseScreenSize.height/3);

        super.setTitle("Fortune Teller");
        super.setSize(applicationSize.width, applicationSize.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());

        SetUpTopPanel();
        SetUpMiddlePanel();
        SetUpBottomPanel();
        CreateFortunes();

        super.setLocationRelativeTo(null);
    }

    private void SetUpTopPanel(){
        top = new JPanel();
        JLabel label = new JLabel("Fortune Teller");
        label.setFont(new Font("Arial", Font.BOLD, 25));

        Image icon = new ImageIcon(getClass().getResource("fortune.jpg")).getImage();
        icon = icon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel imageHolder = new JLabel(new ImageIcon(icon));

        top.setLayout(new GridBagLayout());//display the image and text in column instead of row
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.gridx = 0;

        top.add(label,constraints);
        top.add(imageHolder,constraints);
        super.add(top);
    }
    private void SetUpMiddlePanel(){
        middle = new JPanel();

        JScrollPane scrollPane = new JScrollPane(textArea);//create scroll pane and add the text area to it
        scrollPane.setPreferredSize(new Dimension(250,textArea.getFont().getSize()*10));
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.ITALIC, 15));

        middle.add(scrollPane);
        super.add(middle);
    }//FIXME: needs a font
    private void SetUpBottomPanel(){
        bottom = new JPanel();

        readButton.addActionListener(e -> textArea.append("\n" +GetRandomFortune()));
        quitButton.addActionListener(e -> System.exit(0));
        Font bottomFont = new Font("Dialog", Font.BOLD, 10);

        readButton.setFont(bottomFont);
        quitButton.setFont(bottomFont);

        bottom.add(readButton);
        bottom.add(quitButton);
        super.add(bottom);
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
