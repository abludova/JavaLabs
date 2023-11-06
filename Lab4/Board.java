import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
    //TODO: Список фигур и начальное положение всех фигур
    private Figure  fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);
    private char colorGaming;
    private Figure[][] previousBoardState;

    public Board() {
        previousBoardState = new Figure[8][8];
    }

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }
    public void undoMove() {
        if (previousBoardState != null) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    fields[row][col] = previousBoardState[row][col];
                }
            }
            previousBoardState = null;
        }
    }

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };

    }
    public void switchPlayerColor() {
        if (colorGaming == 'w') {
            colorGaming = 'b';
        } else {
            colorGaming = 'w';
        }
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public boolean move_figure(int row1, int col1, int row2, int col2) {
        Figure figure = this.fields[row1][col1];
        if (figure == null) {
            return false;
        }

        if (kingIsUnderAttack(row1, col1, row2, col2, figure.getColor())) {
            System.out.println("Шах!");
        }

        if (!isPathClear(row1, col1, row2, col2)) {
            return false;
        }

        this.fields[row2][col2] = figure;
        this.fields[row1][col1] = null;

        if (figure.canMove(row1, col1, row2, col2) && this.fields[row2][col2] == null) {
            System.out.println("move");
        } else if (figure.canAttack(row1, col1, row2, col2) && this.fields[row2][col2] != null && this.fields[row2][col2].getColor() != this.fields[row1][col1].getColor()) {
            System.out.println("attack");
            switch (this.fields[row2][col2].getColor()) {
                case 'w':
                    this.takeWhite.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
                    break;
                case 'b':
                    this.takeBlack.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
                    break;
            }
            this.fields[row2][col2] = figure;
            this.fields[row1][col1] = null;
        }
        if (isCheckmate(figure.getColor())) {
            System.out.println("Мат!");
        }

        return true;

    }
    private boolean isPathClear(int row1, int col1, int row2, int col2) {
        int deltaY = row2 - row1;
        int deltaX = col2 - col1;
        int rowDirection = Integer.signum(deltaY);
        int colDirection = Integer.signum(deltaX);

        int currentRow = row1 + rowDirection;
        int currentCol = col1 + colDirection;

        while (currentRow != row2 || currentCol != col2) {
            if (fields[currentRow][currentCol] != null) {
                return false;
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }

    private boolean kingIsUnderAttack(int row1, int col1, int row2, int col2, char currentColor) {
        Figure[][] tempBoard = new Figure[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tempBoard[i][j] = fields[i][j];
            }
        }

        Figure movedFigure = tempBoard[row1][col1];
        tempBoard[row2][col2] = movedFigure;
        tempBoard[row1][col1] = null;

        int kingRow = -1;
        int kingCol = -1;

        outerLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure piece = tempBoard[i][j];
                if (piece instanceof King && piece.getColor() == currentColor) {
                    kingRow = i;
                    kingCol = j;
                    break outerLoop;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure attacker = tempBoard[i][j];
                if (attacker != null && attacker.getColor() != currentColor) {
                    if (attacker.canAttack(i, j, kingRow, kingCol)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private boolean isCheckmate(char kingColor) {
        int kingRow = -1;
        int kingCol = -1;

        outerLoop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure piece = fields[i][j];
                if (piece instanceof King && piece.getColor() == kingColor) {
                    kingRow = i;
                    kingCol = j;
                    break outerLoop;
                }
            }
        }

        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = kingRow + rowOffsets[i];
            int newCol = kingCol + colOffsets[i];

            if (isValidMove(kingRow, kingCol, newRow, newCol, kingColor)) {

                return false;
            }
        }
        return true; // Мат
    }
    private static boolean isDraw(Board board) {
        for (int row1 = 0; row1 < 8; row1++) {
            for (int col1 = 0; col1 < 8; col1++) {
                Figure figure = board.getFigure(row1, col1);
                if (figure != null && figure.getColor() == 'w') {
                    for (int row2 = 0; row2 < 8; row2++) {
                        for (int col2 = 0; col2 < 8; col2++) {
                            if (board.move_figure(row1, col1, row2, col2)) {
                                board.undoMove();
                                return false;
                            }
                        }
                    }
                } else if (figure != null && figure.getColor() == 'b') {
                    for (int row2 = 0; row2 < 8; row2++) {
                        for (int col2 = 0; col2 < 8; col2++) {
                            if (board.move_figure(row1, col1, row2, col2)) {
                                board.undoMove();
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row1, int col1, int row2, int col2, char kingColor) {
        if (row2 < 0 || row2 > 7 || col2 < 0 || col2 > 7) {
            return false;
        }
        int rowDelta = Math.abs(row2 - row1);
        int colDelta = Math.abs(col2 - col1);

        if (rowDelta > 1 || colDelta > 1) {
            return false;
        }
        Figure destinationPiece = fields[row2][col2];
        if (destinationPiece != null && destinationPiece.getColor() == kingColor) {
            return false;
        }
        Figure[][] tempBoard = new Figure[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(fields[i], 0, tempBoard[i], 0, 8);
        }
        Figure movedKing = tempBoard[row1][col1];
        tempBoard[row2][col2] = movedKing;
        tempBoard[row1][col1] = null;

        if (kingIsUnderAttack(row2, col2, kingColor, tempBoard)) {
            return false;
        }

        return true;
    }
    public Figure getFigure(int row, int col) {
        return fields[row][col];
    }

    public boolean kingIsUnderAttack(int kingRow, int kingCol, char kingColor, Figure[][] board) {
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = kingRow + rowOffsets[i];
            int newCol = kingCol + colOffsets[i];
            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Figure attacker = board[newRow][newCol];

                if (attacker != null && attacker.getColor() != kingColor) {
                    if (attacker.canAttack(newRow, newCol, kingRow, kingCol)) {
                        return true;
                    }
                }
            }
        }
        int[] pawnRowOffsets = kingColor == 'w' ? new int[]{-1, -1} : new int[]{1, 1};
        int[] pawnColOffsets = {-1, 1};

        for (int i = 0; i < 2; i++) {
            int newRow = kingRow + pawnRowOffsets[i];
            for (int j = 0; j < 2; j++) {
                int newCol = kingCol + pawnColOffsets[j];

                if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                    Figure pawn = board[newRow][newCol];

                    if (pawn != null && pawn.getColor() != kingColor && pawn instanceof Pawn) {
                        return true;
                    }
                }
            }
        }
        int[] knightRowOffsets = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] knightColOffsets = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = kingRow + knightRowOffsets[i];
            int newCol = kingCol + knightColOffsets[i];

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Figure knight = board[newRow][newCol];

                if (knight != null && knight.getColor() != kingColor && knight instanceof Knight) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isCheckmate(char kingColor, Board board) {
        int kingRow = -1;
        int kingCol = -1;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.fields[row][col];
                if (figure instanceof King && figure.getColor() == kingColor) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }

        for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
            for (int colDelta = -1; colDelta <= 1; colDelta++) {
                int newRow = kingRow + rowDelta;
                int newCol = kingCol + colDelta;

                if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                    Figure destinationFigure = board.fields[newRow][newCol];

                    if (destinationFigure == null || destinationFigure.getColor() != kingColor) {
                        Figure originalDestinationFigure = destinationFigure;

                        board.fields[newRow][newCol] = board.fields[kingRow][kingCol];
                        board.fields[kingRow][kingCol] = null;
                        if (!board.kingIsUnderAttack(newRow, newCol, kingColor, board.fields)) {
                            board.fields[kingRow][kingCol] = board.fields[newRow][newCol];
                            board.fields[newRow][newCol] = originalDestinationFigure;
                            return false;
                        }
                        board.fields[kingRow][kingCol] = board.fields[newRow][newCol];
                        board.fields[newRow][newCol] = originalDestinationFigure;
                    }
                }
            }
        }
        return true;
    }
    private static boolean isStalemate(Board board) {
        char currentPlayerColor = board.getColorGaming();
        for (int row1 = 0; row1 < 8; row1++) {
            for (int col1 = 0; col1 < 8; col1++) {
                Figure figure = board.getFigure(row1, col1);
                if (figure != null && figure.getColor() == currentPlayerColor) {
                    for (int row2 = 0; row2 < 8; row2++) {
                        for (int col2 = 0; col2 < 8; col2++) {
                            if (board.move_figure(row1, col1, row2, col2)) {
                                board.undoMove();
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    private static boolean isCheck(char kingColor, Board board) {
        int kingRow = -1;
        int kingCol = -1;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(row, col);
                if (figure instanceof King && figure.getColor() == kingColor) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Figure figure = board.getFigure(row, col);
                if (figure != null && figure.getColor() != kingColor) {
                    if (figure.canAttack(row, col, kingRow, kingCol)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean isGameOver(Board board) {
        char currentPlayerColor = board.getColorGaming();
        if (isCheck(currentPlayerColor, board)) {
            if (isCheckmate(currentPlayerColor, board)) {
                System.out.println("Мат! Игрок " + (currentPlayerColor == 'w' ? "Белые" : "Черные") + " победили.");
                return true;
            } else {
                System.out.println("Шах!");
            }
        } else {
            if (isStalemate(board)) {
                System.out.println("Пат! Игра окончена вничью.");
                return true;
            } else if (isDraw(board)) {
                System.out.println("Ничья! Игра окончена вничью.");
                return true;
            }
        }
        return false;
    }
    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }
    }
}