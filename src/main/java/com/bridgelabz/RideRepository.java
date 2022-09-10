package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    static List<Customer> customerList = new ArrayList<>();
    static Map<String, Ride[]> userRides = new HashMap<>();
    public static Invoice generateInvoiceByUserId(int userId) {
        for (Customer customer : customerList) {
            if(customer.getId() == userId)
                return CabInvoiceGenerator.generateInvoice(customer.getRides());
        }
        return null;
    }
    public static void addRideForUser(String userId, Ride[] rides) throws InvoiceGeneratorException {
        if (userRides.containsKey(userId))
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
                    "User ID Already Exists!!!");
        else
            userRides.put(userId, rides);
    }
    public static Ride[] getRidesForUser(String userId) {
        return userRides.get(userId);
    }
}
