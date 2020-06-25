package tictactoe;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    char[][] matr = new char[3][3];
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    boolean gameEnd = false;

    public static void main(String[] args) {

        Main t = new Main();
        t.getParameters();
        t.showField();

        while (t.gameEnd == false) {
            t.getAnswers();
            t.showField();
            t.checkFieldStatus();
        }
    }

    public void getParameters(){
        
        char[] arr = {'_', '_', '_', '_', '_', '_', '_', '_', '_'};

        int item1 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matr[i][j] = arr[item1];
                item1++;
            }
        }
    }

    public void showField() {
        System.out.println("---------");
        System.out.print("| ");
        System.out.print(matr[0][0] + " ");
        System.out.print(matr[0][1] + " ");
        System.out.print(matr[0][2] + " ");
        System.out.println("|");
        System.out.print('|');
        System.out.print(' ');
        System.out.print(matr[1][0] + " ");
        System.out.print(matr[1][1] + " ");
        System.out.print(matr[1][2] + " ");
        System.out.println('|');
        System.out.print('|');
        System.out.print(' ');
        System.out.print(matr[2][0] + " ");
        System.out.print(matr[2][1] + " ");
        System.out.print(matr[2][2] + " ");
        System.out.println("|");
        System.out.println("---------");
    }

    public void getAnswers() {
        boolean coordIntered = false;

        loop1: while (!coordIntered) {
            int coordinat1;
            int coordinat2;

            System.out.print("Enter the coordinates: ");

            loop2: if (scan.hasNextInt()) {
                coordinat1 = scan.nextInt();
                if (scan.hasNextInt()) {
                    coordinat2 = scan.nextInt();
                    if(coordinat1 < 1 || coordinat1 > 3 || coordinat2 < 1 || coordinat2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (matr[3 - coordinat2][coordinat1 - 1] == 'O' ||
                            matr[3 - coordinat2][coordinat1 - 1] == 'X') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if(count1 > count2) {
                            matr[3 - coordinat2][coordinat1 - 1] = 'O';
                        } else if (count1 <= count2) {
                            matr[3 - coordinat2][coordinat1 - 1] = 'X';
                        }
                        coordIntered = true;
                        break;
                    }
                } else {
                    scan.nextLine();
                    System.out.println("You should enter numbers1!");
                    break loop2;
                }
            } else {
                scan.nextLine();
                System.out.println("You should enter numbers2!");
                break loop2;
            }
        }
    }

    public void countFieldItems() {
        count1 = 0;
        count2 = 0;
        count3 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matr[i][j] == 'X') {
                    count1++;
                } else if (matr[i][j] == 'O') {
                    count2++;
                } else if (matr[i][j] == '_') {
                    count3++;
                }
            }
        }
    }

    public void checkFieldStatus() {
        countFieldItems();

        boolean vinX = false;
        boolean vinO = false;

        for (int i = 0; i < 3; i++) {
            if (matr[i][0] == 'X' && matr[i][1] == 'X' && matr[i][2] == 'X' ||
                    matr[0][i] == 'X' && matr[1][i] == 'X' && matr[2][i] == 'X' ||
                    matr[0][0] == 'X' && matr[1][1] == 'X' && matr[2][2] == 'X' ||
                    matr[0][2] == 'X' && matr[1][1] == 'X' && matr[2][0] == 'X') {
                vinX = true;
            }
            if (matr[i][0] == 'O' && matr[i][1] == 'O' && matr[i][2] == 'O' ||
                    matr[0][i] == 'O' && matr[1][i] == 'O' && matr[2][i] == 'O' ||
                    matr[0][0] == 'O' && matr[1][1] == 'O' && matr[2][2] == 'O' ||
                    matr[0][2] == 'O' && matr[1][1] == 'O' && matr[2][0] == 'O' ) {
                vinO = true;
            }
        }

        if (vinO) {
            System.out.println("O wins");
            gameEnd = true;
        } else if (vinX) {
            System.out.println("X wins");
            gameEnd = true;
        } else if (count1 + count2 == 9) {
            System.out.println("Draw");
            gameEnd = true;
        } else if ((count1 - count2 > 1) || (count2 - count1 > 1)) {
            System.out.println("Impossible");
            gameEnd = true;
        }

    }
}
