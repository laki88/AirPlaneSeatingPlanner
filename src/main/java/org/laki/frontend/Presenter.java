package org.laki.frontend;

import org.laki.beans.SeatGroup;

import java.util.List;

public interface Presenter {
    void printSeatingArrangement(List<SeatGroup> seats);
}
