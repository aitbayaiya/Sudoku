package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;

public class Sudoku {

    static JFrame frame;
    static Panal p;
    private static int[][] grid;
    private static int[][] temp;
    private static Random ran = new Random();
    private static int level = 2;

    public static void main(String[] args) {

        grid = new int[9][9];
        temp = new int[9][9];
        frame = new JFrame();
        frame.setResizable(false);
        frame.setLocation(320, 40);
        frame.setSize(650, 650);
        frame.setTitle("</Sudoku Game/>");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Panal();
        frame.setContentPane(p);
        frame.setVisible(true);
    }

    public static ArrayList<Integer> getRandomNum() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (Integer i = 1; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public static void setlevel(int lev) {
        level = lev;
    }
}
