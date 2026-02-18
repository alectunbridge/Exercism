import static java.lang.Math.*;

class ComplexNumber {

    private final double real;
    private final double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;

        this.imaginary = imaginary;
    }

    double getReal() {
        return real;
    }

    double getImaginary() {
        return imaginary;
    }

    double abs() {
        return pow(pow(real, 2) + pow(imaginary, 2), 0.5);
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.getReal(), imaginary + other.getImaginary());
    }

    ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.getReal(), imaginary - other.getImaginary());
    }

    ComplexNumber multiply(ComplexNumber other) {
        double a = real;
        double b = imaginary;
        double c = other.getReal();
        double d = other.getImaginary();
        double newReal = a * c - b * d;
        double newImaginary = b * c + a * d;
        return new ComplexNumber(newReal, newImaginary);
    }

    ComplexNumber divide(ComplexNumber other) {
        double a = real;
        double b = imaginary;
        double c = other.getReal();
        double d = other.getImaginary();
        double newReal = (a * c + b * d) / (pow(c, 2) + pow(d, 2));
        double newImaginary = (b * c - a * d) / (pow(c, 2) + pow(d, 2));
        return new ComplexNumber(newReal, newImaginary);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -1 * imaginary);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(pow(E, real) * cos(imaginary), pow(E, real) * sin(imaginary));
    }
}