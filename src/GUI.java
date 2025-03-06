
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener{
    public CalculatorLogic logic = new CalculatorLogic();
    public static final int WIDTH = 350;
    public static final int HEIGHT = 400;
    JTextField input = new JTextField();
    JTextField output = new JTextField();

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
        input.setEditable(false);
        output.setEditable(false);
        mid.add(input,output);

        //Bottom section - buttons
        JPanel bottom = new JPanel(new GridLayout(6,4));
        for (String button : buttons){
            JButton but = new JButton(button);
            bottom.add(but);
            but.addActionListener(this);
        }

        //Add all sections to the frame
        add(label_button,BorderLayout.NORTH);
        add(mid,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "C" -> input.setText("test");
            //case "9" -> input.setText(input.getText() + "testttt");
            default -> {
                if (command.matches("\\d")){ //(0-9)
                    input.setText(input.getText() + command);
                }
            }
        }
    }
}

