package com.example.graincalculator;

public class Calculator {

    static final double PI = 3.141592653589793;
    static final double POUNDS_PER_TONNE = 2204.62;

    public static long calculateArea(double diameter)
    {
        double radius = diameter / 2;
        return Math.round(PI * (radius * radius));
    }

    public double calculateVolume(double diameter, double height, double peakHeight)
    {
        double radius = diameter / 2;
        double cylinderVolume = PI * (radius * radius) * height;
        double coneVolume = (PI * (radius * radius) * peakHeight) / 3;
        return cylinderVolume + coneVolume;
    }

    public double calculateGrossBushels(double area, double volume ) {
        return Utils.Round((.8 * volume), 1);
    }

    public double calculateNetBushels(Grains.GrainTypes crop,  long area, double volume, double testWeight, double moisture ) {
        double netBushels = calculateGrossBushels(area, volume) * crop.MoistureFactor(moisture) * crop.PackFactor(area, testWeight);
        return Utils.Round(netBushels, 1);
    }

    public double calculateNetTonnes(Grains.GrainTypes crop,  long area, double volume, double testWeight, double moisture ) {
        double netBushels = calculateGrossBushels(area, volume) * crop.MoistureFactor(moisture) * crop.PackFactor(area, testWeight);
        double netBushelWeight = netBushels * crop.BaseTestWeight();
        double netTonnes = netBushelWeight / POUNDS_PER_TONNE;
        return Utils.Round(netTonnes, 2);
    }
}
