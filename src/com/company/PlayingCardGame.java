package com.company;

import java.io.*;
import java.util.Scanner;

public class PlayingCardGame {

    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Play game, press 1\nRead rules, press 2\nShow highscore, press 3\nQuit game, press 0");
        int menu = input.nextInt();

        if (menu == 1) {
            play();
        } else if (menu == 2) {
            rules();
        } else if (menu == 3) {
            highscore();
        } else if (menu == 0) {
            System.exit(1);
        } else {
            backToMenu();
        }

    }

    private void play() {
        Scanner input = new Scanner(System.in);

        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffle();

        System.out.println("Your name: ");
        String name = input.nextLine();

        System.out.println("How many rounds do you wish to play? To quit press 0.");
        int numberOfRounds = input.nextInt();

        int count = 0;

        if (numberOfRounds > 0 && numberOfRounds < 27) {

            for (int i = 0; i < numberOfRounds; i++) {

                System.out.println("\n" + name + ", take the top card of the deck by pressing 1.");
                int cardChoice = input.nextInt();

                PlayingCard card = deck.getTopCard();
                deck.removeCard(0);
                System.out.println("Your card is: " + card + "\n");

                System.out.println("Press 1 to take your hidden card from the deck.");
                int hiddenCardChoice = input.nextInt();

                if (hiddenCardChoice == 1) {
                    PlayingCard hiddenCard = deck.getTopCard();
                    deck.removeCard(0);

                    System.out.println("\nIs your first card:\nHigher, press 1\nLower, press 2\nthan the hidden card?");
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
                }
            }

            System.out.println("\n" + name + ", your total score is: " + count + " and is added to the highscore board.\n");

            writeToFile("textfiles\\highscore.txt", name, count, numberOfRounds);

            backToMenu();

        } else if (numberOfRounds == 2) {
            System.exit(1);
        } else if (numberOfRounds >= 27) {
            System.out.println("You can only play 26 rounds.");
        } else {
            System.out.println("Error");
        }
    }

    private void rules() {
        readFile("textfiles\\rules.txt");
        backToMenu();
    }

    private void highscore() {
        readFile("textfiles\\highscore.txt");
        backToMenu();

    }

    private void writeToFile(String fileName, String name, int count, int numberOfRounds) {

        try(FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(name + " " + count + " points, " + (count/numberOfRounds)*(100) + "%");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String fileName) {
        try {
            Scanner input = new Scanner(new File(fileName));

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void backToMenu() {
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
}