
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;


public class GUI extends JFrame implements ActionListener{
    public CalculatorLogic logic = new CalculatorLogic();
    public static final int WIDTH = 350;
    public static final int HEIGHT = 400;
    JTextField input = new JTextField();
    JTextField output = new JTextField("output");

    public static final String[] buttons = {"^","Ans","C","back","!","x^2","sqrt(x)","/","7","8","9","*","4","5","6","-","1","2","3","+","","0",".","="};
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
        mid.add(input);
        mid.add(output);

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
    //action logic for specific buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "C" -> input.setText("");
            case "Ans" -> {
                input.setText(input.getText() + output.getText());
            }
            case "back" -> {
                String current_text = input.getText();
                if(!input.getText().isEmpty()){
                    input.setText(current_text.substring(0,current_text.length() - 1));
                }
            }
            case "=" -> {
                String[] parts = input.getText().trim().split(" ");

                try{
                    BigDecimal a = new BigDecimal(parts[0]);
                    String operator = parts[1];
                    BigDecimal result = null;

                    if(parts.length == 3){
                        BigDecimal b = new BigDecimal(parts[2]);
                        result = switch(operator){
                            case "+" -> logic.add(a,b);
                            case "-" -> logic.subtract(a,b);
                            case "*" -> logic.multiply(a,b);
                            case "/" -> {
                                if (b.equals(0)){
                                    String errormessage = "Invalid operation - Cant divide by 0";
                                    input.setText(errormessage);
                                    output.setText(errormessage);
                                }
                                yield logic.divide(a,b);
                            }
                            case "^" -> logic.power(a,b);

                            default -> throw new IllegalStateException("Unexpected value: " + operator);
                        };
                        output.setText(String.valueOf(result));
                    } else if (parts.length == 2) {
                        result = switch (operator){
                            case "^2" -> logic.second_pow(a);
                            case "^(1/2)" -> logic.sqrt_second(a);
                            case "!" -> logic.factorial(a);
                            default -> throw new IllegalStateException("Unexpected value: " + operator);
                        };
                        output.setText("= " + String.valueOf(result));
                    }

                }catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }
            case "." -> input.setText(input.getText() + command);
            case "x^2" -> input.setText(input.getText() + " ^2");
            case "sqrt(x)" -> input.setText(input.getText() + " ^(1/2)");
            default -> {
                if (command.matches("\\d")){
                    input.setText(input.getText() + command);
                }
                if (command.matches("[+\\-*/!^]")){
                    if (input.getText().isEmpty()){
                        input.setText("");
                    }else {
                        input.setText(input.getText() + " " + command + " ");
                    }
                }
            }
        }
    }
}

