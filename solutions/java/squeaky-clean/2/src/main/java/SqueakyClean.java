class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean toUpper = false;
        for (char c : identifier.toCharArray()) {
            if (toUpper) {
                result.append(Character.toUpperCase(c));
                toUpper = false;
                continue;
            }
            switch (c) {
                case ' ' -> result.append('_');
                case '-' -> toUpper = true;
                case '0' -> result.append('o');
                case '1' -> result.append('l');
                case '3' -> result.append('e');
                case '4' -> result.append('a');
                case '7' -> result.append('t');
                default -> {
                    if (Character.isAlphabetic(c)) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
