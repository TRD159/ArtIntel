import javax.swing.*;
import java.awt.*;

public class Connect {

}

class Frame extends JFrame {
    Frame(String name) {
        super(name);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();

        Insets i = getInsets();

        setSize(getWidth() + (i.left + i.right), getHeight() + (i.top + i.bottom));
        pack();
        setVisible(true);
    }
}

class Panel extends JPanel {
    Panel(Dimension d) {
        super();
        this.setSize(d);
    }
}
