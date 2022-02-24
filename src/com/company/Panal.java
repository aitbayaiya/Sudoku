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
    public Panal() {
        initComponents();
        /*------------------------main panal  -------------------------------------*/
        center = new JPanel();  //main panel
        center.setLayout(new GridLayout(3, 3));     //grid for 3*3
        center.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(center);  //add main panel to frame

        boxes = new JTextField[9][9];
        paneles = new JPanel[3][3];
        passsLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        passsLabel.setForeground(Color.black);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        label.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paneles[i][j] = new JPanel();
                paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                paneles[i][j].setLayout(new GridLayout(3, 3));
                center.add(paneles[i][j]);
            }
        }
        /*------------------------text fildes in boxes-------------------------------------*/

        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = newtextfield();
                int fm = (n + 1) / 3;
                if ((n + 1) % 3 > 0) {
                    fm++;
                }
                int cm = (i + 1) / 3;
                if ((i + 1) % 3 > 0) {
                    cm++;
                }
                paneles[fm - 1][cm - 1].add(boxes[n][i]);   //add box to panel
            }
        }
        /*------------------------panal for buttons -------------------------------------*/

        bPanel = new JPanel();
        bPanel.setBackground(Color.decode("#AABFFF"));
        bPanel.setBorder(BorderFactory.createLineBorder(Color.black, 6, true));
        bPanel.setLayout(new GridLayout(4, 3, 0, 20));

        /*------------------------panal for new game button -------------------------------------*/
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                label.setText(TimeFormat(counter));
                counter++;

            }
        };

        /*------------------------panal for new game button -------------------------------------*/
        nBtn = new JButton("New Game");
        nbtn.setSize(20, 50);
        timer = new Timer(1000, action);
        nBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                timer.start();
                restgame();
                Sudoku.newGame();

            }
        });

        /*------------------------panal for check game button -------------------------------------*/
        cBtn = new JButton("Check Game +30s");

        cBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!boxes[i][j].isEditable()) {
                            continue;
                        } else if (boxes[i][j].getText().equals(String.valueOf(grid[i][j]))) {
                            boxes[i][j].setBackground(Color.decode("#C0DCD9"));
                        } else if (boxes[i][j].getText().isEmpty()) {
                            boxes[i][j].setBackground(Color.WHITE);
                            continue;
                        } else {
                            boxes[i][j].setBackground(Color.red);
                        }
                    }
                }
                counter += 30;
            }
        });
        /*------------------------panal for new Exit button -------------------------------------*/
        eBtn = new JButton("Exit");

        eBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*------------------------panal for new Hard button -------------------------------------*/
        easyBtn = new JButton("Hard");

        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(4);
                Sudoku.newGame();
            }
        });
        /*------------------------panal for new Hard button -------------------------------------*/
        midBtn = new JButton("Mideum");

        midBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(3);
                Sudoku.newGame();

            }
        });
        /*------------------------panal for new Hard button -------------------------------------*/
        hardBtn = new JButton("Easy");

        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restgame();
                counter = 0;
                timer.start();
                Sudoku.setlevel(2);
                Sudoku.newGame();
            }
        });
        /*------------------------panal for new Hard button -------------------------------------*/
        slove = new JButton("<-- slove Require Password ");

        slove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pass.getText().equals("mortadda")) {
                    timer.stop();
                    counter = 0;
                    label.setText(TimeFormat(counter));
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            boxes[i][j].setText(String.valueOf(grid[i][j]));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(center, "your password incorrect");
                }
            }
        });
        /*------------------------panal for new about button -------------------------------------*/
        about = new JButton("About");

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(center, "By mortadda jafar");
            }
        });
        /*------------------------panal for new about button -------------------------------------*/
        pass.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ((JPasswordField) e.getSource()).setText("");
            }
        });

        /*------------------------add button panal and butons to frame and panel -------------------------------------*/
        bPanel.add(hardBtn);   //add new game button to
        bPanel.add(midBtn);
        bPanel.add(easyBtn);
        bPanel.add(nBtn);   //add new game button to
        bPanel.add(cBtn);
        bPanel.add(eBtn);
        bPanel.add(passsLabel);
        bPanel.add(pass);
        bPanel.add(slove);
        bPanel.add(label);
        bPanel.add(about);

        add(bPanel, "South");   //add button panel to frame

    }

