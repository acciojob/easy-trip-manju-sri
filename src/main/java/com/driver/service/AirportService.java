package com.driver.service;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import com.driver.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    AirportRepository airportRepository = new AirportRepository();

    public String addAirport(Airport airport){

        //We should write some logic :
        //Validations

        if(airport.getAirportName().equals(null)) {
            return "Name should not be null";
        }
        //Saving it to the database
        String ans = airportRepository.addAirport(airport);
        return ans;
    }

    public void addPassenger(Passenger passenger) {
        airportRepository.savePassenger(passenger);
    }

    public String largestAirport() {
      String largestAirport =  airportRepository.findLargestAirport();
      return largestAirport;
    }

    public double getShortestTimeTravel(City fromCity, City toCity) {
      double duration =  airportRepository.getFlightWithShortestDuration(fromCity,toCity);
      return duration;
    }

    public void addFlight(Flight flight) {
        airportRepository.addFlight(flight);
    }

    public int calculateTravelFare(Integer flightId) {

        int flightFare = airportRepository.calculateFare(flightId);
        return flightFare;
    }


}
