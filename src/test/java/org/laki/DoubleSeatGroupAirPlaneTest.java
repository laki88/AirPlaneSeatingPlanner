package org.laki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.laki.beans.SeatGroup;
import org.laki.beans.SeatType;

import java.util.ArrayList;
import java.util.List;

public class DoubleSeatGroupAirPlaneTest {
    AirPlane airPlane = new AirPlane();

    @Before
    public void init() {

        List<SeatGroup> seatsToAdd = new ArrayList<>();
        seatsToAdd.add(new SeatGroup(3, 3));
        seatsToAdd.add(new SeatGroup(2, 2));
        airPlane.setSeatGroups(seatsToAdd);
        airPlane.fillSeats(10);
    }

    @Test
    public void airPlaneGetSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(3, seatsInAirPlane.get(0).getRowCount());
        Assert.assertEquals(3, seatsInAirPlane.get(0).getColumnCount());
        Assert.assertEquals(2, seatsInAirPlane.get(1).getRowCount());
        Assert.assertEquals(2, seatsInAirPlane.get(1).getColumnCount());

    }


    @Test
    public void seatingLabelTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(0).getSeats()[2][2].getSeatType());

        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(1).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(1).getSeats()[1][1].getSeatType());

    }


    @Test
    public void PassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(6, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(8, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(10, seatsInAirPlane.get(0).getSeats()[0][2].getPassenger().getSeqNo());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][0].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][2].getPassenger());
        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[2][0].getPassenger().getSeqNo());
        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats()[2][1].getPassenger().getSeqNo());
        Assert.assertEquals(5, seatsInAirPlane.get(0).getSeats()[2][2].getPassenger().getSeqNo());

        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(4, seatsInAirPlane.get(1).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(7, seatsInAirPlane.get(1).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertEquals(9, seatsInAirPlane.get(1).getSeats()[1][1].getPassenger().getSeqNo());

    }
}
