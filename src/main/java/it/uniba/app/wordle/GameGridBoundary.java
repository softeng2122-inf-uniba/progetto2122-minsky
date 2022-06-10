package it.uniba.app.wordle;

import it.uniba.app.utility.AnsiColors;

public class GameGridBoundary {

    public static void showGrid(final GameGrid grid) {

        if (Word.getLength() >= Word.getMinLength()) {
            showGridHeader();

            showGridBody(grid);
        } else {
            throw new UnsupportedOperationException("Word.length must be greater than 2."); //TODO
        }
    }

    public static void showEmptyGrid() {

        if (Word.getLength() >= Word.getMinLength()) {
            showGridHeader();

            showEmptyGridBody();
        } else {
            throw new UnsupportedOperationException("Word.length must be greater than 2."); //TODO
        }
    }

    private static void showGridHeader() {
        int segmentNumber = (Word.getLength() * 4);
        int spaceNumber = ((Word.getLength() - 2) * 2) + 1;

        System.out.println(
                String.format("%-" + segmentNumber + "s", "┌")
                    .replace(' ', '─') + "┐");
        System.out.println(
                String.format("%-" + spaceNumber + "s", "│")
                    + "GRIGLIA" + String.format("%" + spaceNumber + "s", "│"));

        StringBuilder stringBuilder = new StringBuilder("├");

        for (int i = 0; i < Word.getLength() - 1; i++) {
            stringBuilder.append("───┬");
        }

        stringBuilder.append("───┤");

        System.out.println(stringBuilder);

    }

    private static void showGridRowsSeparator() {
        StringBuilder stringBuilder = new StringBuilder("├");

        for (int i = 0; i < Word.getLength() - 1; i++) {
            stringBuilder.append("───┼");
        }

        stringBuilder.append("───┤");

        System.out.println(stringBuilder);
    }

    private static void showGridBody(final GameGrid grid) {
        if (Game.getRunningGame().getCount() > 0) {
            System.out.println(AnsiColors.
                convertAttemptWordToGridRow(grid.getWord(0)));

            for (int i = 1; i < Game.getRunningGame().getCount(); i++) {
                showGridRowsSeparator();
                System.out.println(AnsiColors
                    .convertAttemptWordToGridRow(grid.getWord(i)));
            }

            if (Game.getRunningGame().getCount() < Game.getMaxGameAttempts()
                 && !Game.getRunningGame().getWin()) {
                showGridRowsSeparator();
                showEmptyGridRow();
            }

            showGridBottom();
        }
    }

    private static void showGridBottom() {
        StringBuilder stringBuilder = new StringBuilder("└");

        for (int i = 0; i < Word.getLength() - 1; i++) {
            stringBuilder.append("───┴");
        }

        stringBuilder.append("───┘");

        System.out.println(stringBuilder);
    }

    private static void showEmptyGridBody() {
        showEmptyGridRow();

        for (int i = 0; i < Game.getMaxGameAttempts() - 1; i++) {
            showGridRowsSeparator();
            showEmptyGridRow();
        }

        showGridBottom();
    }

    private static void showEmptyGridRow() {
        StringBuilder stringBuilder = new StringBuilder("│");

        for (int i = 0; i < Word.getLength(); i++) {
            stringBuilder.append("   │");
        }

        System.out.println(stringBuilder);
    }

}
