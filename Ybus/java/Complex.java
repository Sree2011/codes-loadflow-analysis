import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class defines utility functions for handling complex numbers.
 * Functions:
 * - {@code Complex(float, float)}: The constructor
 * - {@code getReal()}, {@code getImag()}: the getter functions
 * - {@code fromString(String)}: Creates a complex number based on the input string
 */
public class Complex {

    private float real;
    private float imaginary;

    /**
     * Constructor of complex class.
     * @param real Real part of the complex number.
     * @param imaginary Imaginary part of the complex number.
     */
    public Complex(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    

    /**
     * Returns the real part of the complex number.
     * @return the real part of the complex number.
     */
    public float getReal() {
        return real;
    }

    /**
     * Returns the imaginary part of the complex number.
     * @return the imaginary part of the complex number.
     */
    public float getImag() {
        return imaginary;
    }

    /**
     * Creates an object of complex class using the input string.
     * The input string should be in the form `a+bj` where 'a' and 'b' are floats.
     * @param s Input string of the form a+bj.
     * @return a Complex object representing the complex number.
     * @throws IllegalArgumentException if the input string is not in the correct format.
     */
    public static Complex fromString(String s) {
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d+)([+-]\\d*\\.?\\d+)j");
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            float real = Float.parseFloat(matcher.group(1));
            float imaginary = Float.parseFloat(matcher.group(2));
            return new Complex(real, imaginary);
        } else {
            throw new IllegalArgumentException("Invalid complex number format");
        }
    }

    /**
     * Finds the maximum number in the array.
     * @param array the array to find the maximum number in.
     * @return the maximum number in the array.
     */
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Adds this complex number to another.
     * @param other the complex number to add.
     * @return the sum of this complex number and the other.
     */
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    /**
     * Subtracts another complex number from this one.
     * @param other the complex number to subtract.
     * @return the difference between this complex number and the other.
     */
    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    /**
     * Multiplies this complex number by another.
     * @param other the complex number to multiply by.
     * @return the product of this complex number and the other.
     */
    public Complex multiply(Complex other) {
        float newReal = this.real * other.real - this.imaginary * other.imaginary;
        float newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(newReal, newImaginary);
    }

    /**
     * Calculates the reciprocal of this complex number.
     * @return the reciprocal of this complex number.
     */
    public Complex reciprocal() {
        float divisor = real * real + imaginary * imaginary;
        return new Complex(real / divisor, -imaginary / divisor);
    }

    /**
     * Negates this complex number.
     * @return the negation of this complex number.
     */
    public Complex negate() {
        return new Complex(-this.real, -this.imaginary);
    }

    /**
     * Divides this complex number by another.
     * @param other the complex number to divide by.
     * @return the quotient of this complex number and the other.
     */
    public Complex divide(Complex other) {
        float divisor = other.real * other.real + other.imaginary * other.imaginary;
        float newReal = (this.real * other.real + this.imaginary * other.imaginary) / divisor;
        float newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / divisor;
        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fj", real, imaginary);
    }
}
