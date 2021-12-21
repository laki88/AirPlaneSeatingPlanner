package org.laki;

import org.laki.beans.SeatGroup;
import org.laki.frontend.ConsolePresenter;
import org.laki.frontend.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=================================================");
        Scanner scanner = new Scanner(System.in);
        List<SeatGroup> seatGroups = new ArrayList<>();
        String continueStr;
        int i = 1;
        do {
            if (i%10 == 1) {
                System.out.println("Enter Rows and columns for "+ i + "st seat group");
            } else if (i%10 == 2) {
                System.out.println("Enter Rows and columns for "+ i + "nd seat group");
            } else if (i%10 == 3) {
                System.out.println("Enter Rows and columns for "+ i + "rd seat group");
            } else {
                System.out.println("Enter Rows and columns for "+ i + "th seat group");
            }

            System.out.print("Rows : ");
            int rows = scanner.nextInt();
            System.out.print("Columns : ");
            int columns = scanner.nextInt();
            seatGroups.add(new SeatGroup(rows, columns));
            i++;
            System.out.println("Enter enter key to add more seat groups or Enter x for exit");
            scanner.nextLine();
            continueStr = scanner.nextLine();
        } while(continueStr.isEmpty());

        System.out.print("Enter number of passengers to seat : ");
        int numOfPassengers = scanner.nextInt();

        AirPlane airPlane = new AirPlane();

        airPlane.setSeatGroups(seatGroups);
        airPlane.fillSeats(numOfPassengers);

        Presenter presenter = new ConsolePresenter();
        presenter.printSeatingArrangement(airPlane.getSeatGroups());
    }
}
