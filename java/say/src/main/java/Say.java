public class Say {

    public static final String[] ONES = new String[]{
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public String say(long number) {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }

        if (number >= 1_000_000_000) {
            return doUnit(number, 1_000_000_000, "billion");
        }
        if (number >= 1_000_000) {
            return doUnit(number, 1_000_000, "million");
        }
        if (number >= 1_000) {
            return doUnit(number, 1_000, "thousand");
        }
        if (number >= 100) {
            return doUnit(number, 100, "hundred");
        }
        if (number >= 20) {
            String result = TENS[((int) number) / 10];
            long remainder = number % 10;
            if (remainder == 0) {
                return result;
            }
            return result + "-" + say(number % 10);
        } else {
            return ONES[(int) number];
        }
    }

    private String doUnit(long number, int unit, String unitAsText) {
        String result = say(number / unit) + " " + unitAsText;
        long remainder = number % unit;
        if (remainder == 0) {
            return result;
        }
        return result + " " + say(remainder);
    }
}
