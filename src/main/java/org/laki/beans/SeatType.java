package org.laki.beans;

public enum SeatType {
    WINDOW_SEAT("W"),
    MIDDLE_SEAT("M"),
    AISLE_SEAT("A");

    public final String label;

    SeatType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
