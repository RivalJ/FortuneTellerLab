import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FortuneTellerFrame extends JFrame {
    private JPanel top, middle, bottom;
    JTextArea textArea = new JTextArea(10,1);
    JButton readButton = new JButton("Read My Fortune!");
    JButton quitButton = new JButton("Quit");
    ArrayList<String> fortunes = new ArrayList<>();

    public FortuneTellerFrame() {
        super.setTitle("Fortune Teller");
        super.setSize(500, 300);
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
        label.setFont(new Font("Arial", Font.BOLD, 20));

        Image icon = new ImageIcon(getClass().getResource("fortune.jpg")).getImage();
        icon = icon.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        JLabel imageHolder = new JLabel(new ImageIcon(icon));


        top.add(label);
        top.add(imageHolder);
        super.add(top);
    }//FIXME: needs to dispaly the image above the text
    private void SetUpMiddlePanel(){
        middle = new JPanel();

        JScrollPane scrollPane = new JScrollPane(textArea);//create scroll pane and add the text area to it
        scrollPane.setPreferredSize(new Dimension(250,textArea.getFont().getSize()*10));
        textArea.setEditable(false);


        middle.add(scrollPane);
        super.add(middle);
    }//FIXME: needs a font
    private void SetUpBottomPanel(){
        bottom = new JPanel();

        readButton.addActionListener(e -> textArea.append("\n" +GetRandomFortune()));
        quitButton.addActionListener(e -> System.exit(0));

        bottom.add(readButton);
        bottom.add(quitButton);
        super.add(bottom);
    }//FIXME: needs a font

    private String GetRandomFortune(){
        return fortunes.get((int)(Math.random()*fortunes.size()));
    }//FIXME: needs to not return the same fortune twice in a row
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
