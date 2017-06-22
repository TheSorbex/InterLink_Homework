package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.print(writeDayWithColor(date,today));
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
            }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }

    public static String writeDayWithColor(LocalDate date, int today){
        String color;
        String spaces;

        if (date.getDayOfMonth() + 1 < 11){
            spaces = "   ";
        } else {
            spaces = "  ";
        }

        if (date.getDayOfMonth() == today){
            color = "34";
        } else if (date.getDayOfWeek().getValue() % 7 != 6 && date.getDayOfWeek().getValue() % 7 != 0){
            color = "30";
        } else {
            color = "31";
        }
        return (char) 27 + "[" + color + "m"  +(date.getDayOfMonth()) + (char) 27 + "[0m" + spaces;
    }
}
