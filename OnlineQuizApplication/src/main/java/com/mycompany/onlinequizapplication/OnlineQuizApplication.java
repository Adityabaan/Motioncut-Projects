/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.onlinequizapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author ADITYA
 */
public class OnlineQuizApplication extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton[] radioButtons = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0,x = 1, y = 1, now = 0;
    int m[] = new int[10];
    
    OnlineQuizApplication(String S){
        super(S);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i = 0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add (radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,20);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(300,250);
        
        
        
    }

    void setData(){
        radioButtons[4].setSelected(true);
        if(current == 0){
            label.setText("Q1. Which is the official language for Android Development");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("C++");
            radioButtons[3].setText("JavaScript");
        }
        if(current == 1){
            label.setText("Q2. What is the size of boolean variable");
            radioButtons[0].setText("8 bit");
            radioButtons[1].setText("16 bit");
            radioButtons[2].setText("32 bit");
            radioButtons[3].setText("not known");
        }
        if(current == 2){
            label.setText("Q3. What is the default value of long variable");
            radioButtons[0].setText("0");
            radioButtons[1].setText("0.0");
            radioButtons[2].setText("0L");
            radioButtons[3].setText("not known");
        }
        if(current == 3){
            label.setText("Q4. What kind of variable can a class consist of ");
            radioButtons[0].setText("Class variable , Instance variable");
            radioButtons[1].setText("Class variable, local variable, Instance variable");
            radioButtons[2].setText("Class Variable");
            radioButtons[3].setText("Local Variable");
        }
        if(current == 4){
            label.setText("Q5. What is function overloading");
            radioButtons[0].setText("Method with same name but different parameter");
            radioButtons[1].setText("Method with same name and same parameter");
            radioButtons[2].setText("Both of these");
            radioButtons[3].setText("None of these");
        }
        if(current == 5){
            label.setText("Q6. What was the name of the first computer virus?");
            radioButtons[0].setText("Rabbit");
            radioButtons[1].setText("Elk Cloner");
            radioButtons[2].setText("SCA Virus");
            radioButtons[3].setText("Creeper Program");
        }
        if(current == 6){
            label.setText("Q7. Which of the following is a thread safe");
            radioButtons[0].setText("StringBuilder");
            radioButtons[1].setText("StringBuffer");
            radioButtons[2].setText("Both of these");
            radioButtons[3].setText("None of these");
        }
        if(current == 7){
            label.setText("Q8. What was the first web browser invented in 1990?");
            radioButtons[0].setText("WorldWideWeb");
            radioButtons[1].setText("Internet Explorer");
            radioButtons[2].setText("Nexus");
            radioButtons[3].setText("Conda");
        }
        if(current == 8){
            label.setText("Q9. What was the first search engine on the Internet?");
            radioButtons[0].setText("Archie");
            radioButtons[1].setText("Google");
            radioButtons[2].setText("Bing");
            radioButtons[3].setText("Yahoo");
        }
        if(current == 9){
            label.setText("Q10. The most valuable company IT Company in the world");
            radioButtons[0].setText("NVDIA");
            radioButtons[1].setText("AWS");
            radioButtons[2].setText("Kaspersky");
            radioButtons[3].setText("Intel");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0; i<=90; i+=30,j++){
               radioButtons[j].setBounds(50,80+i,200,20);
        }
    }
    
    boolean checkAns(){
        if(current == 0){
            return(radioButtons[1].isSelected());
        }
        if(current == 1){
            return(radioButtons[1].isSelected());
        }
        if(current == 2){
            return(radioButtons[2].isSelected());
        }
        if(current == 3){
            return(radioButtons[1].isSelected());
        }
        if(current == 4){
            return(radioButtons[0].isSelected());
        }
        if(current == 5){
            return(radioButtons[3].isSelected());
        }
        if(current == 6){
            return(radioButtons[1].isSelected());
        }
        if(current == 7){
            return(radioButtons[1].isSelected());
        }
        if(current == 8){
            return(radioButtons[0].isSelected());
        }
        if(current == 9){
            return(radioButtons[0].isSelected());
        }
        
        return false;
    }
    
    
    public static void main(String[] args){
        new OnlineQuizApplication("Simple Online Quiz Application");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNext){
            if(checkAns())
                count = count+1;
            current++;
            setData();
            if(current == 9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count = count+1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers are"+count);
            System.exit(0);
        }
        
    }
}
