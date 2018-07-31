package com.company;

import java.io.*;
import java.util.*;

public class PlayingCardGame {

    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Play game, press 1\nRead rules, press 2\nShow statics, press 3\nQuit game, press 0");
        int menu = input.nextInt();

        if (menu == 1) {
            play();
        } else if (menu == 2) {
            rules();
        } else if (menu == 3) {
            highscore();
        } else if (menu == 0) {
            quitGame();
        } else {
            backToMenu();
        }
    }

    private void play() {
        Scanner input = new Scanner(System.in);

        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffle();

        System.out.println("Your name: ");
        String playerName = input.nextLine();

        System.out.println("How many rounds do you wish to play? To quit press 0.");
        int numberOfRounds = input.nextInt();

        int count = 0;

        if (numberOfRounds > 0) {

            for (int i = 0; i < numberOfRounds; i++) {

                System.out.println("\n" + playerName + ", take the top card of the deck by pressing any key + enter.");
                input.next();

                PlayingCard card = deck.getTopCard();
                card.setHidden(false);
                deck.removeCard(0);
                deck.putCardInBottomOfDeck(card);
                System.out.println("Your card is: " + card + "\n");

                System.out.println("Press 1 to take your hidden card from the deck.");
                int hiddenCardChoice = input.nextInt();

                if (hiddenCardChoice == 1) {
                    PlayingCard hiddenCard = deck.getTopCard();
                    deck.removeCard(0);
                    deck.putCardInBottomOfDeck(hiddenCard);

                    System.out.println("\nIs your first card:\nHigher, press 1\nLower, press 2\nthan the hidden card?");
                    int guess = input.nextInt();

                    if (guess == 1) {
                        checkHigh(card, hiddenCard);

                    } else if (guess == 2) {
                        checkLow(card, hiddenCard);

                    }
                }
                count++;
            }

            System.out.println("\n" + playerName + ", you played: " + count + " rounds and this is added to the statics board.\n");

            writeToFile("textfiles\\statics.txt", playerName, count);

            backToMenu();

        } else if (numberOfRounds == 0) {
            quitGame();
        } else {
            System.out.println("Error");
        }
    }

    private void rules() {
        readFile("textfiles\\rules.txt");
        backToMenu();
    }

    private void highscore() {
        readFile("textfiles\\statics.txt");
        backToMenu();

    }

    private void writeToFile(String fileName, String playerName, int count) {

        try (FileWriter writer = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(playerName + ": " + count + " played rounds.");

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
            quitGame();
        } else {
            System.out.println("Error");
        }
    }

    private void checkHigh(PlayingCard card, PlayingCard hiddenCard) {
        if (card.getPrio() > hiddenCard.getPrio()) {
            hiddenCard.setHidden(false);
            System.out.println("Right! Your card was higher than the hidden card.\nThe hidden card was: " + hiddenCard);
        } else if (card.getPrio() < hiddenCard.getPrio()) {
            hiddenCard.setHidden(false);
            System.out.println("Wrong! Your card was lower than the hidden card.\nThe hidden card was: " + hiddenCard);
        }
    }

    private void checkLow(PlayingCard card, PlayingCard hiddenCard) {
        if (card.getPrio() < hiddenCard.getPrio()) {
            hiddenCard.setHidden(false);
            System.out.println("Right! Your card was lower than the hidden card.\nThe hidden card was: " + hiddenCard);
        } else if (card.getPrio() > hiddenCard.getPrio()) {
            hiddenCard.setHidden(false);
            System.out.println("Wrong! Your card was higher than the hidden card.\nThe hidden card was: " + hiddenCard);
        }
    }
    private void quitGame(){
        System.exit(1);
    }

}