package org.laki.frontend;

import org.laki.beans.SeatGroup;

import java.util.List;

public interface Presenter {
    /**
     * print seat groups
     * @param seats seat groups to print
     */
    void printSeatingArrangement(List<SeatGroup> seats);
}
