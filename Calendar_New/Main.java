package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        TextStyle text = TextStyle.SHORT;
        Locale locale = Locale.ENGLISH;


        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        for (DayOfWeek day : DayOfWeek.values()){
            System.out.print(day.getDisplayName(text, locale)+ " ");
        }

        System.out.println();

        for(int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.print(writeDayWithColor(date,today));
            date = date.plusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY){
                System.out.println();
            }
            }
    }

    public static String writeDayWithColor(LocalDate date, int today){
        String color;
        String spaces;

        if (date.plusDays(1).getDayOfMonth() < 11){
            spaces = "   ";
        } else {
            spaces = "  ";
        }

        if (date.getDayOfMonth() == today){
            color = "34";
        } else if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY){
            color = "30";
        } else {
            color = "31";
        }
        return (char) 27 + "[" + color + "m"  +(date.getDayOfMonth()) + (char) 27 + "[0m" + spaces;
    }
}
