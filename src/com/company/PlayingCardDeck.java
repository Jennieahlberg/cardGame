package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingCardDeck {
    
    List<PlayingCard> cards;

    public PlayingCardDeck() {
        this.cards = new ArrayList<>();

        this.cards.add(new PlayingCard("Spades", "Ace", true, 52));
        this.cards.add(new PlayingCard("Spades", "2", true, 4));
        this.cards.add(new PlayingCard("Spades", "3", true, 8));
        this.cards.add(new PlayingCard("Spades", "4", true, 12));
        this.cards.add(new PlayingCard("Spades", "5", true, 16));
        this.cards.add(new PlayingCard("Spades", "6", true, 20));
        this.cards.add(new PlayingCard("Spades", "7", true, 24));
        this.cards.add(new PlayingCard("Spades", "8", true, 28));
        this.cards.add(new PlayingCard("Spades", "9", true, 32));
        this.cards.add(new PlayingCard("Spades", "10", true, 36));
        this.cards.add(new PlayingCard("Spades", "Jack", true, 40));
        this.cards.add(new PlayingCard("Spades", "Queen", true, 44));
        this.cards.add(new PlayingCard("Spades", "King", true, 48));

        this.cards.add(new PlayingCard("Hearts", "Ace", true, 51));
        this.cards.add(new PlayingCard("Hearts", "2", true, 3));
        this.cards.add(new PlayingCard("Hearts", "3", true, 7));
        this.cards.add(new PlayingCard("Hearts", "4", true, 11));
        this.cards.add(new PlayingCard("Hearts", "5", true, 15));
        this.cards.add(new PlayingCard("Hearts", "6", true, 19));
        this.cards.add(new PlayingCard("Hearts", "7", true, 23));
        this.cards.add(new PlayingCard("Hearts", "8", true, 27));
        this.cards.add(new PlayingCard("Hearts", "9", true, 31));
        this.cards.add(new PlayingCard("Hearts", "10", true, 35));
        this.cards.add(new PlayingCard("Hearts", "Jack", true, 39));
        this.cards.add(new PlayingCard("Hearts", "Queen", true, 43));
        this.cards.add(new PlayingCard("Hearts", "King", true, 47));

        this.cards.add(new PlayingCard("Diamonds", "Ace", true, 50));
        this.cards.add(new PlayingCard("Diamonds", "2", true, 2));
        this.cards.add(new PlayingCard("Diamonds", "3", true, 6));
        this.cards.add(new PlayingCard("Diamonds", "4", true, 10));
        this.cards.add(new PlayingCard("Diamonds", "5", true, 14));
        this.cards.add(new PlayingCard("Diamonds", "6", true, 18));
        this.cards.add(new PlayingCard("Diamonds", "7", true, 22));
        this.cards.add(new PlayingCard("Diamonds", "8", true, 26));
        this.cards.add(new PlayingCard("Diamonds", "9", true, 30));
        this.cards.add(new PlayingCard("Diamonds", "10", true, 34));
        this.cards.add(new PlayingCard("Diamonds", "Jack", true, 38));
        this.cards.add(new PlayingCard("Diamonds", "Queen", true, 42));
        this.cards.add(new PlayingCard("Diamonds", "King", true, 46));

        this.cards.add(new PlayingCard("Clovers", "Ace", true, 49));
        this.cards.add(new PlayingCard("Clovers", "2", true, 1));
        this.cards.add(new PlayingCard("Clovers", "3", true, 5));
        this.cards.add(new PlayingCard("Clovers", "4", true, 9));
        this.cards.add(new PlayingCard("Clovers", "5", true, 13));
        this.cards.add(new PlayingCard("Clovers", "6", true, 17));
        this.cards.add(new PlayingCard("Clovers", "7", true, 21));
        this.cards.add(new PlayingCard("Clovers", "8", true, 25));
        this.cards.add(new PlayingCard("Clovers", "9", true, 29));
        this.cards.add(new PlayingCard("Clovers", "10", true, 33));
        this.cards.add(new PlayingCard("Clovers", "Jack", true, 37));
        this.cards.add(new PlayingCard("Clovers", "Queen", true, 41));
        this.cards.add(new PlayingCard("Clovers", "King", true, 45));

    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public void putCardInBottomOfDeck(PlayingCard card) {
        this.cards.add(new PlayingCard(card.getColor(), card.getValue(), card.isHidden(), card.getPrio()));

    }

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