//package EX1;

import javax.swing.*;
import java.awt.event.*;

public class Converter{

    public static void main(String[] args) {
        
        String[] currencies = {"USD ($)","EUR (€)", "GBP (£)"};

        JLabel label = new JLabel("Enter the amount: ");
        
        JTextField field = new JTextField(50);

        JButton calButton = new JButton("Calculate conversion");

        JLabel label2 = new JLabel("Convert from: ");
        JComboBox comboBox1 = new JComboBox<>(currencies);

        JLabel label3 = new JLabel("Convert to: ");
        JComboBox comboBox2 = new JComboBox<>(currencies);

        JLabel label4 = new JLabel("Converted amount:");
        
        JLabel afterConversion = new JLabel();

        class Listener implements ActionListener{

            private String currency1;
            private String currency2;
            private double amount;

            public void actionPerformed(ActionEvent event){
                currency1 = (String) comboBox1.getSelectedItem();
                currency2 = (String) comboBox2.getSelectedItem();

                try {
                    Double.parseDouble(field.getText());
                    amount = Double.parseDouble(field.getText());
                    afterConversion.setText(calculateConversion(currency1, currency2, amount));
                } 
                catch (NumberFormatException e) {
                    afterConversion.setText("ERROR - Put valid amount!");
                }
            }

            private String calculateConversion(String c1, String c2, double amount){
                final double EURtoUSD = 1.18;
                final double EURtoGBP = 0.89;
                final double GBPtoUSD = 1.32;
                final double GBPtoEUR = 1.12;
                final double USDtoGBP = 0.76;
                final double USDtoEUR = 0.85;

                if(c1.equals("USD ($)") && c2.equals("USD ($)")){
                    return "INVALID";
                }
                else if(c1.equals("USD ($)") && c2.equals("EUR (€)")){
                    return String.valueOf((double)Math.round((amount*USDtoEUR)*100)/100)+"€";
                }
                else if(c1.equals("USD ($)") && c2.equals("GBP (£)")){
                    return String.valueOf((double)Math.round((amount*USDtoGBP)*100)/100)+"£";
                }
                else if(c1.equals("EUR (€)") && c2.equals("EUR (€)")){
                    return "INVALID";
                }
                else if(c1.equals("EUR (€)") && c2.equals("USD ($)")){
                    return String.valueOf((double)Math.round((amount*EURtoUSD)*100)/100)+"$";
                }
                else if(c1.equals("EUR (€)") && c2.equals("GBP (£)")){
                    return String.valueOf((double)Math.round((amount*EURtoGBP)*100)/100)+"£";
                }
                else if(c1.equals("GBP (£)") && c2.equals("GBP (£)")){
                    return "INVALID";
                }
                else if(c1.equals("GBP (£)") && c2.equals("EUR (€)")){
                    return String.valueOf((double)Math.round((amount*GBPtoEUR)*100)/100)+"€";
                }
                else if(c1.equals("GBP (£)") && c2.equals("USD ($)")){
                    return String.valueOf((double)Math.round((amount*GBPtoUSD)*100)/100)+"$";
                }
                else{
                    return "ERROR 404 - NOT FOUND!";
                }
            } 
        }


        ActionListener listener = new Listener();
        calButton.addActionListener(listener);
        
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(field);
        panel.add(label2);
        panel.add(comboBox1);
        panel.add(label3);
        panel.add(comboBox2);
        panel.add(calButton);
        panel.add(label4);
        panel.add(afterConversion);
        
        
        JFrame frame = new JFrame();
        frame.setSize(700, 300);
        frame.setTitle("Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
    }
    
}