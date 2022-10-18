package Password_Generator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class PasswordGenerator implements ActionListener {
    static JTextField text;
    JFrame frame;
    JLabel l1;
    JTextField textlength;

    static JLabel label4;

    int len;
    PasswordGenerator(){
        frame = new JFrame("My Password Generator");
        frame.getContentPane().setBackground(Color.pink);
        frame.setSize(800,800);
        l1 = new JLabel("Random Password Generator");
        l1.setBounds(230,20,300,50);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(l1);
        text =new JTextField("Your Password will be generated here");
        text.setBounds(50,80,670,60);
        text.setFont(new Font("Arial",Font.BOLD,15));
        textlength =new JTextField("");
        textlength.setBounds(400,180,80,40);
        JLabel lengthl = new JLabel("Enter the Length of Password Required: ");
        lengthl.setBounds(60,190,350,20);
        lengthl.setFont(new Font("Arial",Font.BOLD,15));
        frame.add(lengthl);
        JLabel label1 = new JLabel("Include all the characters (Recommended)--> ");
        label1.setBounds(60,300,420,20);
        label1.setFont(new Font("Arial",Font.BOLD,18));
        frame.add(label1);
        JButton button1 = new JButton("Generate Password 1");
        button1.setBounds(540,280,160,50);
        button1.addActionListener(this);
        frame.add(button1);

        JLabel label2 = new JLabel("Include only upper and lower case characters --> ");
        label2.setBounds(60,410,500,20);
        label2.setFont(new Font("Arial",Font.BOLD,18));
        frame.add(label2);


        JButton button2 = new JButton("Generate Password 2");
        button2.setBounds(540,390,160,50);
        button2.addActionListener(this);
        frame.add(button2);


        JLabel label3 = new JLabel("Include only alphabets and numbers --> ");
        label3.setBounds(60,520,500,20);
        label3.setFont(new Font("Arial",Font.BOLD,18));
        frame.add(label3);


        JButton button3 = new JButton("Generate Password 3");
        button3.setBounds(540,500,160,50);
        button3.addActionListener(this);
        frame.add(button3);

        label4 = new JLabel("This is a random text");
        label4.setBounds(180,600,450,40);
        label4.setFont(new Font("San",Font.BOLD,25));
        label4.setVisible(false);
        frame.add(label4);





        frame.add(text);
        frame.add(textlength);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        PasswordGenerator g1 = new PasswordGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           String s= e.getActionCommand();
           if((s=="Generate Password 1" || s=="Generate Password 2" || s=="Generate Password 3") && (textlength.getText().equals(""))){
               text.setText("Enter Some Length First to Generate the Password");
               text.setFont(new Font("Arial",Font.PLAIN,15));
               text.setBackground(Color.red);
               l1.setText("Random Password Generator");
           }
           else if(s=="Generate Password 1"){

                   String ans= textlength.getText();
                   ans=GenerateRandomPassword(Integer.parseInt(ans));
                   text.setFont(new Font("Arial",Font.PLAIN,24));
                   text.setText(ans);
                   l1.setText("Password Generated Bro!!");
                   int strength=(checkpasswordstrength(ans));
                   setstrengthcolor(strength);

           }
           else if (s=="Generate Password 2") {

                   String ans= textlength.getText();
                   ans=GenerateRandomPasswordOnlyalphabets(Integer.parseInt(ans));
                   text.setFont(new Font("Arial",Font.PLAIN,24));
                   text.setText(ans);
                   text.setBackground(Color.GREEN);
                   l1.setText("Password Generated Bro!!");
               int strength=(checkpasswordstrength(ans));
               setstrengthcolor(strength);

           }
           else if (s=="Generate Password 3") {

                   String ans= textlength.getText();
                   ans=GenerateRandomPasswordalphabetsandnumbers(Integer.parseInt(ans));
                   text.setFont(new Font("Arial",Font.PLAIN,24));
                   text.setText(ans);
                   text.setBackground(Color.GREEN);
                   l1.setText("Password Generated Bro!!");
               int strength=(checkpasswordstrength(ans));
               setstrengthcolor(strength);
           }

    }

    public static String  GenerateRandomPassword(int len){
        int start=33;
        int end = 122;
        StringBuilder sb = new StringBuilder();
        while(len>0){
            int x=(int)(Math.random()*(end -start)+start);
            if((x>=64 && x<=93) || (x>=97 && x<=125) || (x>=35 && x<=38) || (x>=47 && x<=57)){
                char alpha =(char)x;
                sb.append(alpha);
                len--;
            }
        }
        return sb.toString();
    }

    public static String  GenerateRandomPasswordOnlyalphabets(int len){
        int start=33;
        int end = 122;
        StringBuilder sb = new StringBuilder();
        while(len>0){
            int x=(int)(Math.random()*(end -start)+start);
            if((x>=65 && x<=90) || (x>=97 && x<=122)){
                char alpha =(char)x;
                sb.append(alpha);
                len--;
            }
        }
        return sb.toString();
    }

    public static String  GenerateRandomPasswordalphabetsandnumbers(int len){
        int start=33;
        int end = 122;
        StringBuilder sb = new StringBuilder();
        while(len>0){
            int x=(int)(Math.random()*(end -start)+start);
            if((x>=65 && x<=90) || (x>=97 && x<=122) || (x>=48 && x<=57)){
                char alpha =(char)x;
                sb.append(alpha);
                len--;
            }
        }
        return sb.toString();
    }

    public static int checkpasswordstrength(String pass){
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<pass.length();i++){
            hs.add(pass.charAt(i));
        }
        int len =  hs.size();
        if(len<=5){
            return 1;
        }
        else if(len>=6 && len<=10){
            return 2;
        }
        else if(len>=11 && len<=16){
            return 3;
        }
        else {
            return 4;
        }
    }

    public static void setstrengthcolor(int strength){
        if(strength==1){
            label4.setText("Your Password Generated is Weak");
            label4.setForeground(Color.red);
            text.setBackground(Color.red);
        }
        else if(strength==2){
            label4.setText("Your Password Generated is OK");
            label4.setForeground(Color.red);
            text.setBackground(Color.red);
        }
        else if (strength==3) {
            label4.setText("Your Password Generated is Good");
            label4.setForeground(Color.yellow);
            text.setBackground(Color.yellow);
        }
        else if (strength==4) {
            label4.setText("Your Password Generated is Strong");
            label4.setForeground(Color.green);
            text.setBackground(Color.green);
        }

        label4.setVisible(true);
    }

}
