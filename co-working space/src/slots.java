

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class slots {

    protected int time, hour, minutes;

    protected String date;
    protected long fees;

    public slots() {
        this.time = 0;
        this.date = "Not assigned yet";
        this.fees = 0;
        this.hour = 0;
        this.minutes = 0;

    }


    public void setDate(int day, int month, int year, int hour, int minutes) {
            /*
            String Day = Integer.toString(day);
            String Month = Integer.toString(month);
            String Year = Integer.toString(year);
            String Hour = Integer.toString(hour);
            String Minutes = Integer.toString(minutes);

            date = String.format("%s-%s-%s %s:%s", Year, Month, Day, Hour, Minutes);
            */
        LocalDateTime dateee = LocalDateTime.of(year, month, day, hour, minutes);
        DateTimeFormatter revdate = DateTimeFormatter.ofPattern("EE dd/MM/yyyy H:mm");
        date = dateee.format(revdate);
    }


    public String getDate() {

            /*
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE dd-MM-yyyy H:mm");
            LocalDateTime RevDate = LocalDateTime.parse(date, dtf);
            // DayOfWeek DayInWeek = date.getDayOfWeek();
            return dtf.format(RevDate);
            */
        return date;
    }

    public void setDate(int day, int month, int year) {
        LocalDate dateee = LocalDate.of(year, month, day);
        DateTimeFormatter revdate = DateTimeFormatter.ofPattern("EE dd/MM/yyyy");
        date = dateee.format(revdate);

    }




     /*
       public void setDate(int day, int month, int year, int hour, int minutes) {

           LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minutes);
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd-MM-yyyy H:mm");
           date = dateTime.format(formatter);
       }

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE dd-MM-yyyy H:mm");
        LocalDateTime revDate = LocalDateTime.parse(date, dtf);
        return dtf.format(revDate);
    }
*/
}

