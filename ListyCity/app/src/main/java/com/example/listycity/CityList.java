package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city is in the cityList. If it is, remove that city. If not, throw NoSuchElementException
     * @param city
     * This is a candidate city to check
     * @return
     * Return number of cities in cityList if found
     */
    public int hasCity(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (city.getCityName().equals(cities.get(i).getCityName())) {
                if (city.getProvinceName().equals(cities.get(i).getProvinceName())) {
                    cities.remove(i); //Remove the city
                    return cities.size();
                }
            }
        }
        throw new NoSuchElementException("City not found in the list");
    }
}
