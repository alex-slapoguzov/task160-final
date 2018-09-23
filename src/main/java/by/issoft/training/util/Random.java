package by.issoft.training.util;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Random {

	public static String randomizeSubject(String subject) {
		return subject + randomAlphanumeric(20);
	}

	public static int randomNumberFromList(List list) {
		return nextInt(0, list.size());
	}
}
