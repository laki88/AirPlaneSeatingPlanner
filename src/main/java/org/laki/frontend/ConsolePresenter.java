package org.laki.frontend;

import de.vandermeer.asciitable.AsciiTable;
import org.laki.beans.Passenger;
import org.laki.beans.Seat;
import org.laki.beans.SeatGroup;

import java.util.*;
import java.util.stream.Stream;

public class ConsolePresenter implements Presenter {

    @Override
    public void printSeatingArrangement(List<SeatGroup> seatGroups) {
        printSeating(seatGroups);
    }

    private void printSeating(List<SeatGroup> seatGroups) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        List<String> insideBoxes = new ArrayList<>();
        for (SeatGroup seatGroup : seatGroups) {
            Seat[][] seats = seatGroup.getSeats();
            AsciiTable seatGroupAsciiTable = new AsciiTable();
            for (int i = 0; i < seats.length; i++) {
                List<String> rowInSeatGroup = new ArrayList<>();
                for (int j = 0; j < seats[i].length;j++) {
                    String seatLabel = seats[i][j].getSeatType().getLabel();
                    Passenger passenger = seats[i][j].getPassenger();
                    String seqNo = "";
                    if (passenger != null) {
                        seqNo += passenger.getSeqNo();
                    }
                    rowInSeatGroup.add(seatLabel + " : " + seqNo);
                }
                seatGroupAsciiTable.addRow(rowInSeatGroup);
            }
            insideBoxes.add(seatGroupAsciiTable.render());
        }
        at.addRow(insideBoxes);
        at.addRule();
        System.out.println(at.render());
    }

}
