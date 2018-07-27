package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck {
    
    List<PlayingCard> cards;

    public PlayingCardDeck() {
        this.cards = new ArrayList<>();

        this.cards.add(new PlayingCard("Spades", "Ace", false, 52));
        this.cards.add(new PlayingCard("Spades", "2", false, 4));
        this.cards.add(new PlayingCard("Spades", "3", false, 8));
        this.cards.add(new PlayingCard("Spades", "4", false, 12));
        this.cards.add(new PlayingCard("Spades", "5", false, 16));
        this.cards.add(new PlayingCard("Spades", "6", false, 20));
        this.cards.add(new PlayingCard("Spades", "7", false, 24));
        this.cards.add(new PlayingCard("Spades", "8", false, 28));
        this.cards.add(new PlayingCard("Spades", "9", false, 32));
        this.cards.add(new PlayingCard("Spades", "10", false, 36));
        this.cards.add(new PlayingCard("Spades", "Jack", false, 40));
        this.cards.add(new PlayingCard("Spades", "Queen", false, 44));
        this.cards.add(new PlayingCard("Spades", "King", false, 48));

        this.cards.add(new PlayingCard("Hearts", "Ace", false, 51));
        this.cards.add(new PlayingCard("Hearts", "2", false, 3));
        this.cards.add(new PlayingCard("Hearts", "3", false, 7));
        this.cards.add(new PlayingCard("Hearts", "4", false, 11));
        this.cards.add(new PlayingCard("Hearts", "5", false, 15));
        this.cards.add(new PlayingCard("Hearts", "6", false, 19));
        this.cards.add(new PlayingCard("Hearts", "7", false, 23));
        this.cards.add(new PlayingCard("Hearts", "8", false, 27));
        this.cards.add(new PlayingCard("Hearts", "9", false, 31));
        this.cards.add(new PlayingCard("Hearts", "10", false, 35));
        this.cards.add(new PlayingCard("Hearts", "Jack", false, 39));
        this.cards.add(new PlayingCard("Hearts", "Queen", false, 43));
        this.cards.add(new PlayingCard("Hearts", "King", false, 47));

        this.cards.add(new PlayingCard("Diamonds", "Ace", false, 50));
        this.cards.add(new PlayingCard("Diamonds", "2", false, 2));
        this.cards.add(new PlayingCard("Diamonds", "3", false, 6));
        this.cards.add(new PlayingCard("Diamonds", "4", false, 10));
        this.cards.add(new PlayingCard("Diamonds", "5", false, 14));
        this.cards.add(new PlayingCard("Diamonds", "6", false, 18));
        this.cards.add(new PlayingCard("Diamonds", "7", false, 22));
        this.cards.add(new PlayingCard("Diamonds", "8", false, 26));
        this.cards.add(new PlayingCard("Diamonds", "9", false, 30));
        this.cards.add(new PlayingCard("Diamonds", "10", false, 34));
        this.cards.add(new PlayingCard("Diamonds", "Jack", false, 38));
        this.cards.add(new PlayingCard("Diamonds", "Queen", false, 42));
        this.cards.add(new PlayingCard("Diamonds", "King", false, 46));

        this.cards.add(new PlayingCard("Clovers", "Ace", false, 49));
        this.cards.add(new PlayingCard("Clovers", "2", false, 1));
        this.cards.add(new PlayingCard("Clovers", "3", false, 5));
        this.cards.add(new PlayingCard("Clovers", "4", false, 9));
        this.cards.add(new PlayingCard("Clovers", "5", false, 13));
        this.cards.add(new PlayingCard("Clovers", "6", false, 17));
        this.cards.add(new PlayingCard("Clovers", "7", false, 21));
        this.cards.add(new PlayingCard("Clovers", "8", false, 25));
        this.cards.add(new PlayingCard("Clovers", "9", false, 29));
        this.cards.add(new PlayingCard("Clovers", "10", false, 33));
        this.cards.add(new PlayingCard("Clovers", "Jack", false, 37));
        this.cards.add(new PlayingCard("Clovers", "Queen", false, 41));
        this.cards.add(new PlayingCard("Clovers", "King", false, 45));

    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

//    public PlayingCard putCardInBottomOfDeck(PlayingCard card) {
//        this.cards.add(new PlayingCard(card));
//
//    }

    public PlayingCard getTopCard() {
        if (this.cards.size() <= 0) {
            return null;
        } else {
            return this.cards.get(0);
        }
    }
    public void removeCard(int index){
        this.cards.remove(index);

    }
}