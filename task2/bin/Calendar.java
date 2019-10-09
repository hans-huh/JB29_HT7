package by.ld.hw.ooptasks.task2.bin;

/**
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить
 * информацию о выходных и праздничных днях.
 */

public class Calendar {
    private int year;
    private int month;
    private int day;
    private Day myDay;

    public Calendar(int day, int month, int year){
        myDay = new Day();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Calendar(){
        myDay = new Day();
        day = 1;
        month = 1;
        year = 2019;
    }

    private class Day{
        private boolean isWeekEnd;
        private boolean isHoliday;
        private String holidayName;

        public Day(){
            isHoliday = false;
            isWeekEnd = false;
            holidayName = "";
        }

        public boolean isWeekEnd() {
            return isWeekEnd;
        }

        public void setWeekEnd(boolean weekEnd) {
            isWeekEnd = weekEnd;
        }

        public boolean isHoliday() {
            return isHoliday;
        }

        public void setHoliday(boolean holiday) {
            isHoliday = holiday;
        }

        public String getHolidayName() {
            return holidayName;
        }

        public void setHolidayName(String holidayName) {
            this.holidayName = holidayName;
        }
    }

    public void setDayInfo(boolean isHoliday, boolean isWeekEnd){
        myDay.setHoliday(isHoliday);
        myDay.setWeekEnd(isWeekEnd);
    }

    public void setDayInfo(boolean isHoliday, String name, boolean isWeekEnd){
        myDay.setHoliday(isHoliday);
        myDay.setWeekEnd(isWeekEnd);
        myDay.setHolidayName(name);
    }


    @Override
    public String toString(){
        String output;

        output = day + "/" + month + "/" + year + ", weekEnd?(" + myDay.isWeekEnd() + "), holiday?(" + myDay.isHoliday() + ")";
        if(myDay.isHoliday()){
            output = output + ", name of the holiday = " + myDay.getHolidayName();
        }

        return output;
    }
}
