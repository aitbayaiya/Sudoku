package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Panal extends javax.swing.JPanel {

    Sudoku game;
    private Timer timer;
    private JButton nbtn = new JButton("new game");
    private static JTextField[][] boxes;
    private JPasswordField pass = new JPasswordField("aitu2022javaNK");
    private JLabel label = new JLabel("      Timer :00 : 00 : 00");
    private JLabel passsLabel = new JLabel("            your password :");
    private JPanel[][] paneles;
    private JPanel center, bPanel, levelPanel;
    private JButton nBtn, cBtn, eBtn, hardBtn, midBtn, easyBtn, slove, about;
    private int[][] temp = new int[9][9];
    private int[][] grid = new int[9][9];
    private int counter = 0;
}


