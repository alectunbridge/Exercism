public class Say {

    public static final String[] ONES = new String[]{
            "",
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
    private static final String[] TENS = {"", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public String say(long number) {
        String result = "";

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }

        if (number == 0) {
            return "zero";
        }

        if (number >= 1_000_000_000) {
            result += say(number / 1000_000_000) + " billion";
            long remainder = number % 1000_000_000;
            if (remainder == 0) {
                return result;
            }
            return result + " " + say(remainder);
        }
        if (number >= 1000_000) {
            result += say(number / 1000_000) + " million";
            long remainder = number % 1000_000;
            if (remainder == 0) {
                return result;
            }
            return result + " " + say(remainder);
        }
        if (number >= 1000) {
            result += say(number / 1000) + " thousand";
            long remainder = number % 1000;
            if (remainder == 0) {
                return result;
            }
            return result + " " + say(remainder);
        }
        if (number >= 100) {
            result += ONES[((int) number) / 100] + " hundred";
            long remainder = number % 100;
            if (remainder == 0) {
                return result;
            }
            return result + " " + say(remainder);
        }
        if (number >= 20) {
            result += TENS[((int) number) / 10 - 1];
            long remainder = number % 10;
            if (remainder == 0) {
                return result;
            }
            return result + "-" + say(number % 10);
        } else {
            result += ONES[(int) number];
        }


        return result;
    }
}
