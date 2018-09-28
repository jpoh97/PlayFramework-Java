package domain.services.buildingattendantutil.implementation;

import domain.services.buildingattendantutil.BuildingCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BuildingCalendarImplementation implements BuildingCalendar {

    public Boolean isSundayToday() {
        DayOfWeek dayOfWeek = getCurrentDate().getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY;
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
