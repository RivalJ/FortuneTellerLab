import javax.swing.*;
import java.util.ArrayList;

public class FortuneTeller {
    public FortuneTellerFrame frame;


    void main(String[] args){
        SwingUtilities.invokeLater(() -> frame = new FortuneTellerFrame());
    }
}
