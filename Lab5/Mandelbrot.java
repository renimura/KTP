package com.company;
import java.awt.geom.Rectangle2D;
public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y) {
        int iteration = 0;
        double zreal = 0;
        double zimaginary = 0;

        while (iteration < MAX_ITERATIONS && zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrupdate = zreal * zreal - zimaginary * zimaginary + x;
            double zimupdate = 2 * zreal * zimaginary + y;
            zreal = zrupdate;
            zimaginary = zimupdate;
            iteration++;
        }

        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }
    public String toString()
    {
        return "Mandelbrot";
    }
}