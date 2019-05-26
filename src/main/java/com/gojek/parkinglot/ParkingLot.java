/**
 * Created by Tushar on 5/12/19.
 */
package com.gojek.parkinglot;

import java.util.*;

enum COLOR {
    RED,
    GREEN,
    BLUE,
    WHITE,
    BLACK
}

public class ParkingLot {
    int MAX_SIZE = 0;
    private class Car {
        String regNo;
        String color;
        public Car(String regNo, String color) {
            this.regNo = regNo;
            this.color = color;
        }
    }
    // Available slots list
    ArrayList<Integer> availableSlotList;
    // Map of Slot, Car
    Map<String, Car> mapSlots;
    // Map of RegNo, Slot
    Map<String, String> map2;
    // Map of Color, List of RegNo
    Map<String, ArrayList<String>> mapColRegNos;


    public void createParkingLot(int lotCount) {
        try {
            this.MAX_SIZE = lotCount;
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.MAX_SIZE; i++) {
            availableSlotList.add(i);
        }
        this.mapSlots = new HashMap<>();
        this.map2 = new HashMap<>();
        this.mapColRegNos = new HashMap<>();
        System.out.println("Created parking lot with " + lotCount + " slots");
        System.out.println();
    }

    public void parkCar(String regNo, String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapSlots.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            Car car = new Car(regNo, color);
            this.mapSlots.put(slot, car);
            this.map2.put(regNo, slot);
            if (this.mapColRegNos.containsKey(color)) {
                ArrayList<String> regNoList = this.mapColRegNos.get(color);
                //this.mapColRegNos.remove(color);
                regNoList.add(regNo);
                //this.mapColRegNos.put(color, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<>();
                regNoList.add(regNo);
                this.mapColRegNos.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    public void leave(String slotNo) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapSlots.size() > 0) {
            Car carToLeave = this.mapSlots.get(slotNo);
            if (carToLeave != null) {
                this.mapSlots.remove(slotNo);
                this.map2.remove(carToLeave.regNo);
                ArrayList<String> regNoList = this.mapColRegNos.get(carToLeave.color);
                if (regNoList.contains(carToLeave.regNo)) {
                    regNoList.remove(carToLeave.regNo);
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public void status() {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapSlots.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            Car car;
            for (int i = 1; i <= this.MAX_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.mapSlots.containsKey(key)) {
                    car = this.mapSlots.get(key);
                    System.out.println(i + "\t" + car.regNo + "\t" + car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public ArrayList<String> getRegistrationNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            return null;
        } else if (this.mapColRegNos.containsKey(color)) {
            return this.mapColRegNos.get(color);
        }

        return null;
    }

    public ArrayList<Integer> getSlotNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            return null;
        } else if (this.mapColRegNos.containsKey(color)) {
            ArrayList<String> regNoList = this.mapColRegNos.get(color);
            ArrayList<Integer> slotList = new ArrayList<>();
            for (String regNo: regNoList) {
                slotList.add(Integer.valueOf(this.map2.get(regNo)));
            }
            Collections.sort(slotList);
            return slotList;
        }

        return null;
    }

    public String getSlotNumberFromRegNo(String regNo) {
        if (this.MAX_SIZE == 0) {
            return null;
        } else if (this.map2.containsKey(regNo)) {
            return  this.map2.get(regNo);
        }

        return null;
    }
}
