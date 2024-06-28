package Practicefile;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.ReadablePartial;
import org.joda.time.Years;

 class DateUtil {
	 public static int getAge(final Date dob, final Date referenceDt) {
	        return getAge(dob, "NEARESTBIRTHDAY", referenceDt);
	    }
	    
	    public static int getAge(final Date dob, final String ageCalculationBasis, final Date referenceDt) {
	        final Years years = Years.yearsBetween((ReadablePartial)new LocalDate((Object)dob), (ReadablePartial)new LocalDate((Object)referenceDt));
	        if (ageCalculationBasis.equals("LASTBIRTHDAY")) {
	            return years.getYears();
	        }
	        if (ageCalculationBasis.equals("NEXTBIRTHDAY")) {
	            if (new LocalDate((Object)dob).getDayOfMonth() == new LocalDate((Object)referenceDt).getDayOfMonth() && new LocalDate((Object)dob).getMonthOfYear() == new LocalDate((Object)referenceDt).getMonthOfYear()) {
	                return years.getYears();
	            }
	            return years.getYears() + 1;
	        }
	        else {
	            final Months months = Months.monthsBetween((ReadablePartial)new LocalDate((Object)dob), (ReadablePartial)new LocalDate((Object)referenceDt));
	            if (months.getMonths() % 12 < 6) {
	                return years.getYears();
	            }
	            return years.getYears() + 1;
	        }
	    }
}
