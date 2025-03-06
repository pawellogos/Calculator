
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH = 350;
    public static final int HEIGHT = 400;
    public static final String[] buttons = {"%","CE","C","back","1/x","x^2","sqrt(x)","/","7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","="};
    public GUI(){
        setTitle("Calculator");
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Top section - label button
        JButton label_button = new JButton("Calculator PaulR");
        label_button.setEnabled(false);


        //Middle section - TextFields for inputs and output
        JPanel mid = new JPanel(new GridLayout(2,1));
        JTextField input = new JTextField();
        JTextField output = new JTextField();
        input.setEditable(false);
        output.setEditable(false);
        mid.add(input,output);

        //Bottom section - buttons
        JPanel bottom = new JPanel(new GridLayout(6,4));
        for (String button : buttons){
            JButton but = new JButton(button);
            bottom.add(but);
        }

        //Add all sections to the frame
        add(label_button,BorderLayout.NORTH);
        add(mid,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        setVisible(true);
    }
}

