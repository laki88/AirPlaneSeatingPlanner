package org.laki.frontend;

import org.laki.beans.Seat;
import org.laki.beans.SeatGroup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ConsolePresenter implements Presenter {

    @Override
    public void printSeatingArrangement(List<SeatGroup> seatGroups) {
        seatGroups.forEach(seatGroup -> {
            //todo add table printing here
        });
    }

}
