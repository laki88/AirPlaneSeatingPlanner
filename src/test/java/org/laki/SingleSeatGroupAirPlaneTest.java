package org.laki;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.laki.beans.SeatGroup;
import org.laki.beans.SeatType;
import org.laki.frontend.ConsolePresenter;
import org.laki.frontend.Presenter;

import java.util.ArrayList;
import java.util.List;

public class SingleSeatGroupAirPlaneTest {
    AirPlane airPlane = new AirPlane();

    @Before
    public void init() {

        List<SeatGroup> seatsToAdd = new ArrayList<>();
        seatsToAdd.add(new SeatGroup(3, 2));
        airPlane.setSeatGroups(seatsToAdd);
        airPlane.fillSeats(5);
    }

    @Test
    public void airPlaneGetSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(3, seatsInAirPlane.get(0).getRowCount());
        Assert.assertEquals(2, seatsInAirPlane.get(0).getColumnCount());

    }


    @Test
    public void seatingLabelTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[0][1].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][0].getSeatType());
        Assert.assertEquals(SeatType.MIDDLE_SEAT, seatsInAirPlane.get(0).getSeats()[1][1].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[2][0].getSeatType());
        Assert.assertEquals(SeatType.WINDOW_SEAT, seatsInAirPlane.get(0).getSeats()[2][1].getSeatType());

    }


    @Test
    public void PassengerSeatingTest() {

        List<SeatGroup> seatsInAirPlane = airPlane.getSeatGroups();

        Assert.assertEquals(1, seatsInAirPlane.get(0).getSeats()[0][0].getPassenger().getSeqNo());
        Assert.assertEquals(3, seatsInAirPlane.get(0).getSeats()[0][1].getPassenger().getSeqNo());
        Assert.assertEquals(5, seatsInAirPlane.get(0).getSeats()[1][0].getPassenger().getSeqNo());
        Assert.assertNull(seatsInAirPlane.get(0).getSeats()[1][1].getPassenger());
        Assert.assertEquals(2, seatsInAirPlane.get(0).getSeats()[2][0].getPassenger().getSeqNo());
        Assert.assertEquals(4, seatsInAirPlane.get(0).getSeats()[2][1].getPassenger().getSeqNo());

        Presenter presenter = new ConsolePresenter();
        presenter.printSeatingArrangement(seatsInAirPlane);
    }
}
