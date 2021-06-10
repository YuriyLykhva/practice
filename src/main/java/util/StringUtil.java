package util;

import java.util.Random;

public class StringUtil {

    /**
     * Variables, constants
     */
    private static final String ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new Random();

    /**
     * Creating random gmail email
     * @param stringLength - defines the length of new user email
     * @return random email on gmail domain with desired length
     */
    public static String getRandomGmail(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALPHA_NUMERIC.charAt(random.nextInt(ALPHA_NUMERIC.length())));
        }
        return stringBuilder.toString() + "@GMAIL.COM";
    }
}
