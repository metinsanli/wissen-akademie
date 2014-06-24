/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.plugins;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**

 @author metin
 */
@SuppressWarnings("all")
public class Test_AutoCompleteDecorator extends JFrame {

    public Test_AutoCompleteDecorator (String p_title) {
        this.setTitle(p_title);
        JPanel pan = new JPanel();
        JTextComponent jtf = new JTextField();
        ((JTextField) jtf).setColumns(20);
        List items = new ArrayList();
        items.add("Metin");
        items.add("Mert");
        items.add("Ahmet");
        items.add("Ali");
        items.add("Nazli");
        items.add("Eda");
        AutoCompleteDecorator.decorate(jtf, items, false); // 
        pan.add(jtf);
        this.setContentPane(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(280, 150, 500, 200);
    }

    public static void main (String[] args) {
        Test_AutoCompleteDecorator tsx = new Test_AutoCompleteDecorator("helloo swingx");
        tsx.setVisible(true);
    }

}
