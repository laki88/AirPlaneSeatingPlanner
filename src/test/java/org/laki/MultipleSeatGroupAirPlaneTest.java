package org.laki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipleSeatGroupAirPlaneTest {

    AirPlane airPlane = new AirPlane();

    @Before
    public void init() {

        List<SeatGroup> seatsToAdd = new ArrayList<>();
        seatsToAdd.add(new SeatGroup(3, 2));
        seatsToAdd.add(new SeatGroup(4, 3));
        seatsToAdd.add(new SeatGroup(2, 3));
        seatsToAdd.add(new SeatGroup(3, 4));
        airPlane.setSeatGroups(seatsToAdd);
        airPlane.fillSeats(30);
    }

    @Test
    public void airPlaneGetSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(3, seatsInAirPlane.get(0).getRowCount());
        Assert.assertEquals(2, seatsInAirPlane.get(0).getColumnCount());
        Assert.assertEquals(4, seatsInAirPlane.get(1).getRowCount());
        Assert.assertEquals(3, seatsInAirPlane.get(1).getColumnCount());
        Assert.assertEquals(2, seatsInAirPlane.get(2).getRowCount());
        Assert.assertEquals(3, seatsInAirPlane.get(2).getColumnCount());
        Assert.assertEquals(3, seatsInAirPlane.get(3).getRowCount());
        Assert.assertEquals(4, seatsInAirPlane.get(3).getColumnCount());

    }


    @Test
    public void seatingLabelTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());

        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[1][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(1).getSeats()[2][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[3][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[3][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(1).getSeats()[3][2].getSeatType());

        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(2).getSeats()[1][2].getSeatType());

        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(3).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(3).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(3).getSeats()[0][2].getSeatType());
        Assert.assertEquals(SeatType.AISLE_SEAT, seatsInAirPlane.get(3).getSeats()[0][3].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(3).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(3).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(3).getSeats()[1][2].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(3).getSeats()[1][3].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(3).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(3).getSeats()[2][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(3).getSeats()[2][2].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(3).getSeats()[2][3].getSeatType());
    }


    @Test
    public void PassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(19, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(21, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(25, seatsInAirPlane.get(0).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertEquals(29, seatsInAirPlane.get(0).getSeats()[1][1].getPassenger().getSeqNo());
        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[2][0].getPassenger().getSeqNo());
        Assert.assertEquals(7, seatsInAirPlane.get(0).getSeats()[2][1].getPassenger().getSeqNo());

        Assert.assertEquals(2, seatsInAirPlane.get(1).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(8, seatsInAirPlane.get(1).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(13, seatsInAirPlane.get(1).getSeats()[0][2].getPassenger().getSeqNo());
        Assert.assertEquals(26, seatsInAirPlane.get(1).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertEquals(30, seatsInAirPlane.get(1).getSeats()[1][1].getPassenger().getSeqNo());
        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[1][2].getPassenger());
        Assert.assertEquals(27, seatsInAirPlane.get(1).getSeats()[2][0].getPassenger().getSeqNo());
        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[2][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(1).getSeats()[2][2].getPassenger());
        Assert.assertEquals(3, seatsInAirPlane.get(1).getSeats()[3][0].getPassenger().getSeqNo());
        Assert.assertEquals(9, seatsInAirPlane.get(1).getSeats()[3][1].getPassenger().getSeqNo());
        Assert.assertEquals(14, seatsInAirPlane.get(1).getSeats()[3][2].getPassenger().getSeqNo());

        Assert.assertEquals(4, seatsInAirPlane.get(2).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(10, seatsInAirPlane.get(2).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(15, seatsInAirPlane.get(2).getSeats()[0][2].getPassenger().getSeqNo());
        Assert.assertEquals(5, seatsInAirPlane.get(2).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertEquals(11, seatsInAirPlane.get(2).getSeats()[1][1].getPassenger().getSeqNo());
        Assert.assertEquals(16, seatsInAirPlane.get(2).getSeats()[1][2].getPassenger().getSeqNo());

        Assert.assertEquals(6, seatsInAirPlane.get(3).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(12, seatsInAirPlane.get(3).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(17, seatsInAirPlane.get(3).getSeats()[0][2].getPassenger().getSeqNo());
        Assert.assertEquals(18, seatsInAirPlane.get(3).getSeats()[0][3].getPassenger().getSeqNo());
        Assert.assertEquals(28, seatsInAirPlane.get(3).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][1].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][2].getPassenger());
        Assert.assertNull(seatsInAirPlane.get(3).getSeats()[1][3].getPassenger());
        Assert.assertEquals(20, seatsInAirPlane.get(3).getSeats()[2][0].getPassenger().getSeqNo());
        Assert.assertEquals(22, seatsInAirPlane.get(3).getSeats()[2][1].getPassenger().getSeqNo());
        Assert.assertEquals(23, seatsInAirPlane.get(3).getSeats()[2][2].getPassenger().getSeqNo());
        Assert.assertEquals(24, seatsInAirPlane.get(3).getSeats()[2][3].getPassenger().getSeqNo());
    }

}
