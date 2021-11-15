package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = scanner.nextInt();
        char[][] sala = new char[numRows + 1][numSeats + 1];
        createRoom(sala, numRows, numSeats);
        showMenu(menu, sala, numRows, numSeats);
    }

    public static void createRoom(char[][] sala, int numRows, int numSeats) {
        sala[0][0] = ' ';
        char chrRow = '1';
        char chrColumn = '1';
        for (int i = 1; i <= numRows; i++) {
            sala[i][0] = chrRow;
            chrRow++;
        }
        for (int i = 1; i <= numSeats; i++) {
            sala[0][i] = chrColumn;
            chrColumn++;
        }
        for (int i = 1; i < numRows + 1; i++) {
            for (int j = 1; j < numSeats + 1; j++) {
                sala[i][j] = 'S';
            }
        }
    }

    public static void printRoom(char[][] sala, int numRows, int numSeats) {
        System.out.println("Cinema:");
        for (int i = 0; i < numRows + 1; i++) {
            for (int j = 0; j < numSeats + 1; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void buyTicket(char[][] sala, int numRows, int numSeats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        int price;
        sala[row][seat] = 'B';
        int frontHalf = numRows / 2;
        if (numRows * numSeats < 60) {
            price = 10;
        } else {
            if (numRows % 2 == 0) {
                if (row <= frontHalf) {
                    price = 10;
                } else {
                    price = 8;
                }
            } else if (row <= frontHalf) {
                price = 10;
            } else {
                price = 8;
            }
        }
        System.out.println("Ticket price: $" + price);
        System.out.println();
    }

    public static void showMenu(int menu, char[][] sala, int numRows, int numSeats) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            menu = scanner.nextInt();
            if (menu == 0) {
                break;
            } else if (menu == 1) {
                printRoom(sala, numRows, numSeats);
                continue;
            } else if (menu == 2) {
                buyTicket(sala, numRows, numSeats);
                continue;
            } else {
                System.out.println("");
                continue;
            }
        }
    }

}