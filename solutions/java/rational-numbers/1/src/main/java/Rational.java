import java.util.Objects;

class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        int gcd = gcdByEuclidsAlgorithm(numerator, denominator);
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    Rational add(Rational r2) {
        int a1 = getNumerator();
        int b1 = getDenominator();
        int a2 = r2.getNumerator();
        int b2 = r2.getDenominator();
        int numerator = a1 * b2 + a2 * b1;
        int denominator = b1 * b2;
        return new Rational(numerator, denominator);
    }

    Rational subtract(Rational other) {
        return add(new Rational(-1 * other.getNumerator(), other.getDenominator()));
    }

    Rational multiply(Rational other) {
        int a1 = getNumerator();
        int b1 = getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();
        int numerator = a1 * a2;
        int denominator = b1 * b2;
        return new Rational(numerator, denominator);
    }

    Rational divide(Rational other) {
        int a1 = getNumerator();
        int b1 = getDenominator();
        int a2 = other.getNumerator();
        int b2 = other.getDenominator();
        int numerator = a1 * b2;
        int denominator = a2 * b1;
        return new Rational(numerator, denominator);
    }

    Rational abs() {
        return new Rational(Math.abs(getNumerator()), Math.abs(getDenominator()));
    }

    Rational pow(int power) {
        if (power < 0) {
            return new Rational((int) Math.pow(getDenominator(), Math.abs(power)), (int) Math.pow(getNumerator(), Math.abs(power)));
        }
        return new Rational((int) Math.pow(getNumerator(), power), (int) Math.pow(getDenominator(), power));
    }

    double exp(double exponent) {
        return Math.pow(exponent, (double) getNumerator()/getDenominator());
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rational other) {
            return this.getNumerator() == other.getNumerator()
                    && this.getDenominator() == other.getDenominator();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumerator(), this.getDenominator());
    }

    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return Math.abs(gcdByEuclidsAlgorithm(n2, n1 % n2));
    }
}
