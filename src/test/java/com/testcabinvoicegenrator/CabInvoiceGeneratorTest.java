package com.testcabinvoicegenrator;
import com.cabinvoicegenrator.CabInvoiceGenerator;
import com.cabinvoicegenrator.InvoiceSummary;
import com.cabinvoicegenrator.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest
{
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
        Assertions.assertEquals(52, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        double time = 2;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
        Assertions.assertEquals(5, totalfare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride[] rides = { new Ride(5.0,2),new Ride(0.1,2)};
        InvoiceSummary summary =  cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
        InvoiceSummary  expectedSummary = new InvoiceSummary(1,2,57.0);
        Assertions.assertEquals(expectedSummary,summary);
    }

    @Test
    public void givenUserID_ShouldReturnListOfRides()
    {
        CabInvoiceGenerator cabInvoiceGenerator =new CabInvoiceGenerator();
        Ride[] rides = { new Ride(5.0,2),new Ride(0.1,2)};
        cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
        Ride[] expectedRide = cabInvoiceGenerator.rideRepository.get(1);
        Assertions.assertEquals(expectedRide.toString(),rides.toString());
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2;
        double time = 1;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
        Assertions.assertEquals(32, totalfare,0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenPremiumAndLessThanMinimum_ShouldReturnTotalFare()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 1;
        double time = 1;
        double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
        Assertions.assertEquals(20, totalfare,0.0);
    }
}