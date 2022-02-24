package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;

public class Sudoku {

    static JFrame frame;
    static Panal p;
    private  static int[][] grid;
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


    public static boolean isAvaible(int i, int j, int[][] grid) {

        // Check   row
        for (int column = 0; column < 9; column++) {
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
        }

        // Check  column
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }

        // Check box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {//      i=5 ,j=2   || row =3  col=0   ||i=3  j=0
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (row != i && col != j && grid[row][col] == grid[i][j]) {
                    return false;
                }
            }
        }

        return true; //else return true
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

