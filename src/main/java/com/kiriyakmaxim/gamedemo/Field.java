package com.kiriyakmaxim.gamedemo;

import java.util.Arrays;

class Field {
    private final String[] gameField = new String[9];

    public Field() {
        fillField();
    }

    public void showField() {
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + gameField[i] + " ");
            if (i == 2 || i == 5) System.out.println();
        }
        System.out.println();
    }

    private void fillField() {
        Arrays.fill(gameField, "*");

    }
    public String[] getField() {
        return gameField;
    }


    public void setSymbol(String symbol, int x) {
        gameField[x] = symbol;
    }
}
