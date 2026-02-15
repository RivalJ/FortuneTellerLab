import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {
    private JLabel fortuneLabel;
    private JButton tellFortuneButton;
    private JPanel top, middle, bottom;

    public FortuneTellerFrame() {
        super.setTitle("Fortune Teller");
        super.setSize(300, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());

        SetUpTopPanel();
        SetUpMiddlePanel();
        SetUpBottomPanel();

        super.setLocationRelativeTo(null);
    }

    private void SetUpTopPanel(){
        top = new JPanel();
        JLabel label = new JLabel("Fortune Teller");//FIXME: this needs to have an image attached somehow

        top.add(label);
        super.add(top);
    }
    private void SetUpMiddlePanel(){
        middle = new JPanel();
        JTextArea textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.add(textArea);//create scroll pane and add the text area to it

        middle.add(scrollPane);
        super.add(middle);
    }
    private void SetUpBottomPanel(){
    }
}
