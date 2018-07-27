package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class PlayingCardGame {

    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Play game, press 1\nRead rules, press 2\nShow highscore, press 3\nQuit game, press 0");
        int menu = input.nextInt();

//        while (menu != 1 || menu != 2 || menu != 3 || menu != 0) {
            if (menu == 1) {
                play();
            } else if (menu == 2) {
                rules();
            } else if (menu == 3) {
                highscore();
            } else if (menu == 0) {
                System.exit(1);
            }
//        }
    }

    private void play() {
        Scanner input = new Scanner(System.in);

        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffle();

        System.out.println("Your name: ");
        String name = input.nextLine();

        System.out.println(name + ", take the top card of the deck by pressing 1, to quit press 0.");
        int cardChoice = input.nextInt();

        int count = 0;

        if (cardChoice == 1) {
//            for (int i = 0; i >= 10; i++) {
            PlayingCard card = deck.getTopCard();
            deck.removeCard(0);
            System.out.println(card);

            System.out.println("Press 1 to take your hidden card from the deck.");
            int hiddenCardChoice = input.nextInt();

            if (hiddenCardChoice == 1) {
                PlayingCard hiddenCard = deck.getTopCard();
                deck.removeCard(0);

                System.out.println("Is your first card:\nHigher, press 1\nLower, press 2\nthan the hidden card?");
                int guess = input.nextInt();

                if (guess == 1) {
                    if (card.getPrio() > hiddenCard.getPrio()) {
                        System.out.println("Your card was higher than the hidden card. You get one point.\nThe hidden card was: " + hiddenCard);
                        count++;
                    } else if (card.getPrio() < hiddenCard.getPrio()) {
                        System.out.println("Your card was lower than the hidden card. You get no point.\nThe hidden card was: " + hiddenCard);
                    }

                } else if (guess == 2) {
                    if (card.getPrio() < hiddenCard.getPrio()) {
                        System.out.println("Your card was lower than the hidden card. You get one point.\nThe hidden card was: " + hiddenCard);
                        count++;
                    } else if (card.getPrio() > hiddenCard.getPrio()) {
                        System.out.println("Your card was higher than the hidden card. You get no point.\nThe hidden card was: " + hiddenCard);
                    }
                }
//                }
                System.out.println(name + ", your total score is: " + count + " and is added to the highscore board. ");

                writeToFile("C:\\Users\\Administrator\\OneDrive\\JavaDrive\\CardGame\\src\\com\\company\\highscore.txt", name, count);

            }

        } else if (cardChoice == 2) {
            System.exit(1);
        } else {
            System.out.println("Error");
        }
    }

    private void rules() {
        try {
            Scanner input = new Scanner(new File("C:\\Users\\Administrator\\OneDrive\\JavaDrive\\CardGame\\src\\com\\company\\rules.txt"));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("\nBack to menu, press 1\nQuit game, press 0");
        int choice = scan.nextInt();

        if (choice == 1) {
            menu();
        } else if (choice == 0) {
            System.exit(1);
        } else {
            System.out.println("Error");
        }
    }

    private void highscore() {
        try {
            Scanner input = new Scanner(new File("C:\\Users\\Administrator\\OneDrive\\JavaDrive\\CardGame\\src\\com\\company\\highscore.txt"));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("\nBack to menu, press 1\nQuit game, press 0");
        int chioce = scan.nextInt();

        if (chioce == 1) {
            menu();
        } else if (chioce == 0) {
            System.exit(1);
        } else {
            System.out.println("Error");
        }
    }

    private void writeToFile(String fileName, String name, int count) {
        try {
            Writer writer = new FileWriter(fileName);

            writer.write(name + " " + count);

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}