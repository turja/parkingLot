package com.gojek.parkinglot;

import java.util.ArrayList;

/**
 * Created by Tushar on 5/26/19.
 */
public class ParkingLotTest {
    public static void main(String[] agrs) {

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.createParkingLot(100);

        parkingLot.parkCar("a1", "RED");
        parkingLot.parkCar("a2", "GREEN");
        parkingLot.parkCar("a3", "WHITE");
        parkingLot.parkCar("a4", "RED");
        parkingLot.parkCar("a5", "GREEN");
        parkingLot.parkCar("a6", "WHITE");
        parkingLot.parkCar("a7", "RED");

        System.out.println("Slot Number: " + parkingLot.getSlotNumberFromRegNo("a1"));
        printParkStatus(parkingLot);


        parkingLot.leave(parkingLot.getSlotNumberFromRegNo("a4"));
        parkingLot.leave(parkingLot.getSlotNumberFromRegNo("a6"));
        parkingLot.parkCar("a8", "GREEN");
        parkingLot.parkCar("a9", "RED");

        printParkStatus(parkingLot);


    }

    static void printParkStatus(ParkingLot parkingLot) {
        ArrayList<Integer> slotList = parkingLot.getSlotNumbersFromColor("RED");
        System.out.print("List of slots with color RED: ");
        for (int j : slotList) {
            System.out.print(j);
            System.out.print(", ");
        }
        System.out.println();

        ArrayList<String> regList =parkingLot.getRegistrationNumbersFromColor("RED");
        System.out.print("List of slots with color RED: ");
        for (String str : regList) {
            System.out.print(str);
            System.out.print(", ");
        }
        System.out.println();
    }
}
