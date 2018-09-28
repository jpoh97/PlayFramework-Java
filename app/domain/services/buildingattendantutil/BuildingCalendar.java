package domain.services.buildingattendantutil;

import java.time.LocalDate;

public interface BuildingCalendar {

    Boolean isSundayToday();

    LocalDate getCurrentDate();

}
