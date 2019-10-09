package by.ld.hw.ooptasks.task2.main;

import by.ld.hw.ooptasks.task2.bin.Calendar;

public class Main {

    public static void main(String[] args) {
        Calendar calendar;

        calendar = new Calendar(31, 12, 2019);

        calendar.setDayInfo(true, "New Year's Eve", false);
        System.out.println(calendar.toString());
    }
}
