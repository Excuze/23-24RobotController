package org.firstinspires.ftc.teamcode.excutil;

public class ExcMath {

    public static boolean approxEquals(int a, int b, int threshold) {
        return Math.abs(a - b) <= threshold;
    }

    public static boolean approxEquals(float a, float b, float threshold) {
        return Math.abs(a - b) <= threshold;
    }

    public static boolean approxEquals(double a, double b, double threshold) {
        return Math.abs(a - b) <= threshold;
    }

}
