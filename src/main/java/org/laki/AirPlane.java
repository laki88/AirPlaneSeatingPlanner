package org.laki;

import org.laki.beans.Passenger;
import org.laki.beans.Seat;
import org.laki.beans.SeatGroup;
import org.laki.beans.SeatType;

import java.util.List;

public class AirPlane {

    private List<SeatGroup> seatGroups;

    public List<SeatGroup> getSeatGroups() {
        return seatGroups;
    }

    public void setSeatGroups(List<SeatGroup> seatGroups) {
        labelSeats(seatGroups);
        this.seatGroups = seatGroups;
    }

    private int getMaxColCountInSeatGroups(List<SeatGroup> seatGroups) {
        int maxColCountInSeatGroups = 0;
        for (SeatGroup seatGroup : seatGroups) {
            if (seatGroup.getSeats()[0].length > maxColCountInSeatGroups) {
                maxColCountInSeatGroups = seatGroup.getSeats()[0].length;
            }
        }
        return maxColCountInSeatGroups;
    }

    /**
     * Fill the seats with passengers
     *
     * @param numOfPassengers number of passengers to fill
     */
    public void fillSeats(int numOfPassengers) {
        int passengerCount = 1;
        int maxColCountInSeatGroups = getMaxColCountInSeatGroups(seatGroups);
        //fill aisle seats first
        for (int i = 0; i < maxColCountInSeatGroups; i++) {
            for (SeatGroup seatGroup : seatGroups) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.AISLE_SEAT.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }
        //second fill window seats
        for (int i = 0; i < maxColCountInSeatGroups; i++) {
            for (SeatGroup seatGroup : seatGroups) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.WINDOW_SEAT.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }
        //third fill center seats
        for (int i = 0; i < maxColCountInSeatGroups; i++) {
            for (SeatGroup seatGroup : seatGroups) {
                Seat[][] seats = seatGroup.getSeats();
                if (i < seats[0].length) {
                    for (Seat[] seat : seats) {
                        if (SeatType.MIDDLE_SEAT.equals(seat[i].getSeatType())) {
                            seat[i].setPassenger(new Passenger(passengerCount));
                            passengerCount++;
                            if (passengerCount > numOfPassengers) return;
                        }
                    }
                }
            }
        }
    }

    /**
     *  Label seats with a SeatType
     * @param seatGroups
     */
    private void labelSeats(List<SeatGroup> seatGroups) {

        SeatGroup FirstSeatGroup = seatGroups.get(0);
        Seat[][] seatsInFirstSeatGroup = FirstSeatGroup.getSeats();

        if (seatGroups.size() == 1) {
            for (int j = 0; j < seatsInFirstSeatGroup.length; j++) {
                for (int k = 0; k < seatsInFirstSeatGroup[j].length; k++) {
                    if (j == 0) {
                        seatsInFirstSeatGroup[j][k].setSeatType(SeatType.WINDOW_SEAT);
                    } else if (j != seatsInFirstSeatGroup.length - 1) {
                        seatsInFirstSeatGroup[j][k].setSeatType(SeatType.MIDDLE_SEAT);
                    } else {
                        seatsInFirstSeatGroup[j][k].setSeatType(SeatType.WINDOW_SEAT);
                    }
                }
            }
        } else {
            for (int j = 0; j < seatsInFirstSeatGroup.length; j++) {
                labelSeats(seatsInFirstSeatGroup, j, 0, seatsInFirstSeatGroup.length - 1);
            }

            SeatGroup LastSeatGroup = seatGroups.get(seatGroups.size() - 1);
            Seat[][] seatsInLastSeatGroup = LastSeatGroup.getSeats();
            for (int j = seatsInLastSeatGroup.length - 1; j >= 0; j--) {
                labelSeats(seatsInLastSeatGroup, j, seatsInLastSeatGroup.length - 1, 0);
            }
            if (seatGroups.size() > 2) {
                for (int i = 1; i < seatGroups.size() - 1; i++) {
                    SeatGroup seatGroup = seatGroups.get(i);
                    Seat[][] seatsInGroup = seatGroup.getSeats();
                    for (int j = 0; j < seatsInGroup.length; j++) {
                        for (int k = 0; k < seatsInGroup[j].length; k++) {
                            if (j == 0) {
                                seatsInGroup[j][k].setSeatType(SeatType.AISLE_SEAT);
                            } else if (j != seatsInGroup.length - 1) {
                                seatsInGroup[j][k].setSeatType(SeatType.MIDDLE_SEAT);
                            } else {
                                seatsInGroup[j][k].setSeatType(SeatType.AISLE_SEAT);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Label seat with SeatType
     */
    private void labelSeats(Seat[][] seatsInLastSeatGroup, int j, int a, int b) {
        for (int k = 0; k < seatsInLastSeatGroup[j].length; k++) {
            if (j == a) {
                seatsInLastSeatGroup[j][k].setSeatType(SeatType.WINDOW_SEAT);
            } else if (j != b) {
                seatsInLastSeatGroup[j][k].setSeatType(SeatType.MIDDLE_SEAT);
            } else {
                seatsInLastSeatGroup[j][k].setSeatType(SeatType.AISLE_SEAT);
            }
        }
    }

}
