package com.company;

public class PlayingCard {

    private String color;
    private String value;
    private int prio;
    private boolean hidden;

    public PlayingCard(String color, String value, boolean hidden, int prio) {
        this.color = color;
        this.value = value;
        this.hidden = hidden;
        this.prio = prio;
    }

    public String getColor() {

        return color;
    }

    public String getValue() {

        return value;
    }

    public int getPrio() {

        return prio;
    }

    public boolean isHidden() {

        return hidden;
    }

    public void setHidden(boolean hidden) {

        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
