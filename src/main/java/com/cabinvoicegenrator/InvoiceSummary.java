package com.cabinvoicegenrator;

public class InvoiceSummary {
    public int numberOfRides;
    public double totalFare;
    public double average;

    public InvoiceSummary(int numberOfRides, double totalFare)
    {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.average = average;
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "numberOfRides=" + numberOfRides +
                ", totalFare=" + totalFare +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceSummary other = (InvoiceSummary) obj;
        return Double.doubleToLongBits(average) == Double.doubleToLongBits(other.average)
                && numberOfRides == other.numberOfRides
                && Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
    }
}
