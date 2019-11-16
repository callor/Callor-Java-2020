package com.callor.date.jdk7;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeEx_01 {

	public static void main(String[] args) {

		LocalDateTime local = LocalDateTime.now();	
		
		System.out.println(local.toString());
		System.out.println("올해:" + local.getYear());
		System.out.println("이달:" + local.getMonth());
		System.out.println("오늘:" + local.getDayOfYear());
		
		System.out.printf("%02d:%02d:%02d\n",
					local.getHour(),
					local.getMinute(),
					local.getDayOfYear()
				);

		local.plusDays(3);
		System.out.println(local.plusDays(3).toString()); // +3일
		System.out.println(local.minusDays(3).toString()); // -3일
		System.out.println(local.plusMonths(3).toString()); // +3월
		System.out.println(local.minusMonths(3).toString()); // -3월
		
		System.out.println(local.plusHours(3).toString()); // +3시간
		System.out.println(local.minusHours(3).toString()); //-3시간
		
		// 올해 첫날
		System.out.println(local
							.with(TemporalAdjusters.firstDayOfYear()));
		// 내년 첫날
		System.out.println(local
				.with(TemporalAdjusters.firstDayOfNextYear()));

		// 올해 마지막날
		System.out.println(local
				.with(TemporalAdjusters.lastDayOfYear()));

		// 이달의 첫날
		System.out.println(local
				.with(TemporalAdjusters.firstDayOfMonth()));

		// 이달의 마지막날
		System.out.println(local
				.with(TemporalAdjusters.lastDayOfMonth()));
		
		// 이달의 첫번째 월요일 날짜
		System.out.println(local
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		
		// 이달의 첫번재 일요일 날짜
		System.out.println(local
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));

		// 이번달의 마지막 일요일 날짜
		System.out.println(local
				.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));

		// 이번달의 마직막 금요일 날짜
		System.out.println(local
				.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		
		// 다음주 일요일
		System.out.println(local
				.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
		
		// 오늘 포함해서 다음주 일요일
		// 만약 오늘이 일요일이면 오늘날짜
		System.out.println(local
				.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
		
		// 지난주 일요일
		System.out.println(local
				.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));

		// 오늘 포함해서 지난주 일요일
		// 만약 오늘이 일요일이면 오늘날짜
		System.out.println(local
				.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)));

		// 임의의 시간 생성
		LocalDateTime makeDateTime = LocalDateTime.now();
		
		makeDateTime = makeDateTime.withYear(2000);
		makeDateTime = makeDateTime.withMonth(3);
		makeDateTime = makeDateTime.withDayOfMonth(29);
		
		makeDateTime = makeDateTime.withHour(10);
		makeDateTime = makeDateTime.withMinute(12);
		makeDateTime = makeDateTime.withSecond(22);
		System.out.println("시간생성:" + makeDateTime.toString());
		
		
		LocalDateTime t = LocalDateTime.now();
		int curMonth = t.getYear();
		int p3Month = t.plusYears(2).getYear();
		
		System.out.printf("%d - %d = %d",
					p3Month, curMonth, p3Month - curMonth);
		
	}
}
