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

    public void setColor(String color) {

        this.color = color;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public int getPrio() {

        return prio;
    }

    public void setPrio(int prio) {

        this.prio = prio;
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
