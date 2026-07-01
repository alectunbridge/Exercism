public class Say {

    private static final long MAX_VALUE = 999_999_999_999L;
    private static final String[] SMALL = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public String say(long number) {
        if (number < 0 || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        return sayChunked(number);
    }

    private String sayChunked(long number) {
        if (number < 1_000) {
            return sayBelowOneThousand((int) number);
        }
        if (number < 1_000_000) {
            return joinScale(number, 1_000, "thousand");
        }
        if (number < 1_000_000_000) {
            return joinScale(number, 1_000_000, "million");
        }
        return joinScale(number, 1_000_000_000, "billion");
    }

    private String joinScale(long number, long scale, String label) {
        String left = sayChunked(number / scale) + " " + label;
        long remainder = number % scale;
        if (remainder == 0) {
            return left;
        }
        return left + " " + sayChunked(remainder);
    }

    private String sayBelowOneThousand(int number) {
        if (number < 20) {
            return SMALL[number];
        }
        if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            if (ones == 0) {
                return TENS[tens];
            }
            return TENS[tens] + "-" + SMALL[ones];
        }

        int hundreds = number / 100;
        int remainder = number % 100;
        String prefix = SMALL[hundreds] + " hundred";
        if (remainder == 0) {
            return prefix;
        }
        return prefix + " " + sayBelowOneThousand(remainder);
    }
}
