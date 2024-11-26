import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex {

    private static float real;
    private static float imaginary;

    public Complex(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public float getReal() {
        return real;
    }

    public float getImag() {
        return imaginary;
    }

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

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        float newReal = this.real * other.real - this.imaginary * other.imaginary;
        float newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(newReal, newImaginary);
    }

    public Complex reciprocal() {
        float divisor = real * real + imaginary * imaginary;
        return new Complex(real / divisor, -imaginary / divisor);
    }

    public Complex negate() {
        return new Complex(-this.real, -this.imaginary);
    }

    public Complex divide(Complex other) {
        float divisor = other.real * other.real + other.imaginary * other.imaginary;
        float newReal = (this.real * other.real + this.imaginary * other.imaginary) / divisor;
        float newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / divisor;
        return new Complex(newReal, newImaginary);
    }

    // Note: These methods don't use complex numbers and remain unchanged

    public static float[] getColumn(float[][] array, int columnIndex) {
        // Validate input
        if (array == null || array.length == 0 || columnIndex < 0 || columnIndex >= array[0].length) {
            throw new IllegalArgumentException("Invalid array or column index.");
        }

        float[] column = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            column[i] = array[i][columnIndex]; // Extracting the column element
        }
        return column;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int max(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        }
        return n2;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "j";
    }
}