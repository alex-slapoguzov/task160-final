package by.issoft.training.util;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class Random {

	public static String randomizeSubject(String subject) {
		return subject + randomAlphanumeric(20);
	}
}
