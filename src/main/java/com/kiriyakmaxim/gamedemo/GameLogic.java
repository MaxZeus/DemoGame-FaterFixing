package com.kiriyakmaxim.gamedemo;

import java.util.Scanner;

public class GameLogic {
    private final Field field = new Field();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        while (!(isWin("X") || isWin("O"))) {
            field.showField();

            int firstUserInput = getUserInput();
            setSymbol("X", firstUserInput);

            if (isDraw()) break;

            int secondUserInput = getUserInput();
            setSymbol("O", secondUserInput);
        }
    }

    private int getUserInput() {
        System.out.println("Enter cell");
        int xAxis = sc.nextInt();

        while (!validateCoordinatesInput(xAxis)) {
            xAxis = sc.nextInt();
        }
        sc.reset();
        return xAxis;
    }

    private boolean validateCoordinatesInput(int input) {
        return input >= 0 && input <= 9;
    }

    private boolean isWin(String s) {
          for (int i = 0, j = 0; j < 3; i+= 3, j++) {
            return s.equals(field.getField()[i]) && s.equals(field.getField()[i + 1]) && s.equals(field.getField()[i + 2]) ||
                    s.equals(field.getField()[j]) && s.equals(field.getField()[j + 3]) && s.equals(field.getField()[j + 6]) ||
                    s.equals(field.getField()[j]) && s.equals(field.getField()[4]) && (s.equals(field.getField()[8]) || s.equals(field.getField()[6]));
          }
        return false;
    }
     // проверяем на ничью
    private boolean isDraw() {
        for (String s : field.getField()) {
            if (s.equals("*")) return false;
        }
        return true;
    }

    private void setSymbol(String symbol, int x) {
        if (field.getField()[x].equals("*")) {
            field.setSymbol(symbol, x);
        } else {
            System.out.println("The field is taken, please choose another cell:");
            setSymbol(symbol, sc.nextInt());
        }
    }
}
