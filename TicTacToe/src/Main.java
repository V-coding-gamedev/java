import java.util.Scanner;
import java.util.Random;

// opponent = computer
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] board = {
                " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " ",
                " ", " ", " ", " ", " "};

        // Print out the board before start playing
        PrintBoard(board);

        System.out.print("Choose X or O: ");
        String player = " ";

        while (true){
            try {
                player = scanner.nextLine().toUpperCase();
                if (!player.equalsIgnoreCase("X") && !player.equalsIgnoreCase("O")){
                    throw new IllegalArgumentException("Invalid choice! Only choose X or O");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }

        String opponent;
        if (player.equalsIgnoreCase("X")) {
            opponent = "O";
        } else {
            opponent = "X";
        }

        String currentPlayer= " ";
        String takeFirstTurn;

        System.out.print("Do you want to take the first turn? ");
        while (true){
            try{
                takeFirstTurn = scanner.nextLine().toUpperCase();
                if (takeFirstTurn.equalsIgnoreCase("Y")){
                    currentPlayer = player;
                    break;
                } else if (takeFirstTurn.equalsIgnoreCase("N")){
                    currentPlayer = opponent;
                    break;
                } else {
                    throw new IllegalArgumentException("Enter only Y or N");
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }

        // Start the game loop
        boolean gameRunning = true;
        int chosenPos;
        while (gameRunning){
                // Display currentPlayer's turn
                System.out.println(currentPlayer + "'s turn");
                System.out.print("Input a board position: ");
                chosenPos = scanner.nextInt();

                int index = chosenPos - 1;

                // check if the entered position is blank or not
                if (IsValidPos(index, board)){
                    board[index] = currentPlayer;
                }
                System.out.println("Updated Board: ");
                PrintBoard(board);

                if (!CheckCol(board, currentPlayer)|| !CheckRow(board, currentPlayer) || !CheckDiag(board, currentPlayer)){
                    System.out.println("The winner is: " + currentPlayer);
                    break;
                }else if (!CheckTie(board)){ // success
                    System.out.println("The game is tie");
                    break;
                }
                currentPlayer = Switch(currentPlayer, player, opponent);
                System.out.println();
        }
    }

    public static void PrintBoard(String[] board){
        for (int i = 0; i < board.length; i++){
            System.out.print(board[i]);

            // Add a new line after the 5th, 10th element and so on
            if ((i+1) % 5 == 0){
                System.out.println();
                if (i < board.length - 1){
                    System.out.println("----------");
                }
            } else {
                System.out.print("|");
            }
        }
    }

    public static boolean IsValidPos(int index, String[] board){
        return board[index] == " ";
    }

    public static boolean CheckRow(String[] board, String currentPlayer){
        if (board[0].equalsIgnoreCase(currentPlayer) &&  board[1].equalsIgnoreCase(currentPlayer) &&
            board[2].equalsIgnoreCase(currentPlayer) &&  board[3].equalsIgnoreCase(currentPlayer) && board[4].equalsIgnoreCase(currentPlayer)){
            return false;
        } else if (board[5].equalsIgnoreCase(currentPlayer) &&  board[6].equalsIgnoreCase(currentPlayer) &&
                   board[7].equalsIgnoreCase(currentPlayer) &&  board[8].equalsIgnoreCase(currentPlayer) && board[9].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[10].equalsIgnoreCase(currentPlayer) &&  board[11].equalsIgnoreCase(currentPlayer) &&
                   board[12].equalsIgnoreCase(currentPlayer) &&  board[13].equalsIgnoreCase(currentPlayer) && board[14].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[15].equalsIgnoreCase(currentPlayer) &&  board[16].equalsIgnoreCase(currentPlayer) &&
                   board[17].equalsIgnoreCase(currentPlayer) &&  board[18].equalsIgnoreCase(currentPlayer) && board[19].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[20].equalsIgnoreCase(currentPlayer) &&  board[21].equalsIgnoreCase(currentPlayer) &&
                   board[22].equalsIgnoreCase(currentPlayer) &&  board[23].equalsIgnoreCase(currentPlayer) && board[24].equalsIgnoreCase(currentPlayer)) {
            return false;
        }
        return true;
    }

    public static boolean CheckCol(String[] board, String currentPlayer){
        // boolean gameRunning = true;
        if (board[0].equalsIgnoreCase(currentPlayer) &&  board[5].equalsIgnoreCase(currentPlayer) &&
                board[10].equalsIgnoreCase(currentPlayer) &&  board[15].equalsIgnoreCase(currentPlayer) && board[20].equalsIgnoreCase(currentPlayer)){
            return false;
        } else if (board[1].equalsIgnoreCase(currentPlayer) &&  board[6].equalsIgnoreCase(currentPlayer) &&
                board[11].equalsIgnoreCase(currentPlayer) &&  board[16].equalsIgnoreCase(currentPlayer) && board[21].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[2].equalsIgnoreCase(currentPlayer) &&  board[7].equalsIgnoreCase(currentPlayer) &&
                board[12].equalsIgnoreCase(currentPlayer) &&  board[17].equalsIgnoreCase(currentPlayer) && board[22].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[3].equalsIgnoreCase(currentPlayer) &&  board[8].equalsIgnoreCase(currentPlayer) &&
                board[13].equalsIgnoreCase(currentPlayer) &&  board[18].equalsIgnoreCase(currentPlayer) && board[23].equalsIgnoreCase(currentPlayer)) {
            return false;
        } else if (board[4].equalsIgnoreCase(currentPlayer) &&  board[9].equalsIgnoreCase(currentPlayer) &&
                board[14].equalsIgnoreCase(currentPlayer) &&  board[19].equalsIgnoreCase(currentPlayer) && board[24].equalsIgnoreCase(currentPlayer)) {
            return false;
        }
        return true;
    }

    public static boolean CheckDiag(String[] board, String currentPlayer){
        if (board[0].equalsIgnoreCase(currentPlayer) &&  board[6].equalsIgnoreCase(currentPlayer) &&
                board[12].equalsIgnoreCase(currentPlayer) &&  board[18].equalsIgnoreCase(currentPlayer) && board[24].equalsIgnoreCase(currentPlayer)){
            return false;
        } else if (board[4].equalsIgnoreCase(currentPlayer) &&  board[8].equalsIgnoreCase(currentPlayer) &&
                board[12].equalsIgnoreCase(currentPlayer) &&  board[16].equalsIgnoreCase(currentPlayer) && board[20].equalsIgnoreCase(currentPlayer)) {
            return false;
        }
        return true;
    }

    public static boolean CheckTie(String[] board){
        for (int i = 0; i < board.length; i++){
            if (board[i].equals(" ")){
                return true;
            }
        }
        return false;
    }

    public static String Switch(String currentPlayer, String player, String opponent){
        if (currentPlayer.equalsIgnoreCase(player)){
            currentPlayer =  opponent;
        } else if (currentPlayer.equalsIgnoreCase(opponent)){
            currentPlayer = player;
        }
        return currentPlayer;
    }
}