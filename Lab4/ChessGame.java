import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();
        board.setColorGaming('w');
        board.init();

        boolean gameIsRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameIsRunning) {
            board.print_board();
            System.out.println("Команды:");
            System.out.println("----- exit: Завершить игру");

            char currentPlayerColor = board.getColorGaming();
            System.out.println("Ход " + (currentPlayerColor == 'w' ? "Белых" : "Черных") + ":");

            String move = scanner.nextLine();

            if (move.equals("exit")) {
                gameIsRunning = false;
                System.out.println("Игра завершена.");
            } else {
                int[] moveCoords = parseMove(move);
                int row1 = moveCoords[0];
                int col1 = moveCoords[1];
                int row2 = moveCoords[2];
                int col2 = moveCoords[3];

                currentPlayerColor = board.getColorGaming();

                if (board.isValidMove(row1, col1, row2, col2, currentPlayerColor)) {
                    boolean successfulMove = board.move_figure(row1, col1, row2, col2);

                    if (successfulMove) {
                        if (board.isGameOver(board)) {
                            gameIsRunning = false;
                            System.out.println("Игра завершена.");
                        } else {
                            board.switchPlayerColor();
                        }
                    } else {
                        System.out.println("Недопустимый ход. Повторите ход.");
                    }
                } else {
                    System.out.println("Недопустимый ход. Повторите ход.");
                }
            }
        }
        scanner.close();
    }
    private static int[] parseMove(String move) {
        String[] parts = move.split(" ");

        if (parts.length != 2) {
            return null;
        }
        String fromSquare = parts[0];
        String toSquare = parts[1];

        int col1 = fromSquare.charAt(0) - 'a';
        int row1 = 7 - (fromSquare.charAt(1) - '1');
        int col2 = toSquare.charAt(0) - 'a';
        int row2 = 7 - (toSquare.charAt(1) - '1');

        return new int[]{row1, col1, row2, col2};
    }
}
