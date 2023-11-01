package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AirportRepository {

    HashMap<String, Airport> airportDb = new HashMap<>();
    HashMap<Integer, Passenger> passengerDb = new HashMap<>();

    HashMap<Integer, Flight> flightDb = new HashMap<>();
    public String addAirport(Airport airport) {
        airportDb.put(airport.getAirportName(), airport);
        return "Airport saved successfully";
    }

    public void savePassenger(Passenger passenger) {
        passengerDb.put(passenger.getPassengerId(), passenger);
    }

    public String findLargestAirport() {

        String largestAirport = "";
        int max = 0;
        for (Airport airport : airportDb.values()) {
            if (airport.getNoOfTerminals() > max) {
                largestAirport = airport.getAirportName();
                max = airport.getNoOfTerminals();
            }
            else if (airport.getNoOfTerminals() == max) {
                if (largestAirport.compareTo(airport.getAirportName()) < 0) {
                    largestAirport = airport.getAirportName();
                }
            }
        }
        return largestAirport;
    }

    public double getFlightWithShortestDuration(City fromCity, City toCity) {

        double min = Integer.MAX_VALUE;
        for (Flight flight: flightDb.values()){
           if(flight.getFromCity()==fromCity && flight.getToCity()==toCity){
              if(flight.getDuration()<min){
                  min= flight.getDuration();
              }
           }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public void addFlight(Flight flight) {
        flightDb.put(flight.getFlightId(), flight);
    }

    public int calculateFare(Integer flightId) {

     Flight flight=   flightDb.get(flightId);
     return 0;
    }


}
