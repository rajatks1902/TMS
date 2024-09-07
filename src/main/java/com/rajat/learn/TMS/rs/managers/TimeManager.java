package com.rajat.learn.TMS.rs.managers;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

@Service
public class TimeManager {

    OffsetDateTime  getEndTime(String period) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate endDate;
        LocalDateTime endTime = null;

        switch (period.toUpperCase()) {
            case "TODAY":
                endTime = now.toLocalDate().atTime(23, 59, 59);  // End of today
                break;

            case "WEEK":
                endDate = now.toLocalDate().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                endTime = endDate.atTime(23, 59, 59);  // End of the week (Sunday 11:59:59 PM)
                break;

            case "MONTH":
                endDate = now.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
                endTime = endDate.atTime(23, 59, 59);  // End of the month (Last day 11:59:59 PM)
                break;

            default:
                throw new IllegalArgumentException("Invalid period: " + period);
        }
        return endTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }
}
