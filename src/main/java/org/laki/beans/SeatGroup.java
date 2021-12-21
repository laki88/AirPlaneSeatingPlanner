package org.laki.beans;

public class SeatGroup {
    private int rowCount;
    private int columnCount;
    private Seat[][] seats;

    public SeatGroup(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        seats = new Seat[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }
}
