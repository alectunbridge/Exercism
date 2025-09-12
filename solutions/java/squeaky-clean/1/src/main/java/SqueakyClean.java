class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean toUpper = false;
        for (char c : identifier.toCharArray()) {
            if (c == ' ') {
                result.append('_');
            } else if (c == '-') {
                toUpper = true;
            } else if (toUpper) {
                result.append(Character.toUpperCase(c));
                toUpper = false;
            } else if (c == '3') {
                result.append('e');
            } else if (c == '0') {
                result.append('o');
            } else if (c == '4') {
                result.append('a');
            } else if (c == '1') {
                result.append('l');
            } else if (c == '7') {
                result.append('t');
            } else if (Character.isAlphabetic(c)){
                result.append(c);
            }
        }
        return result.toString();
    }
}
