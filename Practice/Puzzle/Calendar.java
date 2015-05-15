public class Calendar {
    class Date {
        int year, month, day;
    }

    private static final int[] DAY_OF_MONTH_CUMUL = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    private static final int[] DAY_OF_MONTH = {31, 28, 31, 30,  31,  30,  31,  31,  30,  31,  30,  31};

    public int diffDate(Date a, Date b) {
        int dayDiff = daysOfYear(a) - daysOfYear(b); // may be negative
        int yearDiff = jjj

        
    }

    private int daysOfYear(Date a) {
        int res = DAY_OF_MONTH_CUMUL[a.month] + a.day;
        if(a.year % 4 == 0 && a.year % 100 != 0) {
            // うるう年
            if(a.month >= 3)
                res++;
        }

        return res;
    }
}
