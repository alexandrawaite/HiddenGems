package me.alex;

import java.util.ArrayList;
import java.util.List;

public class CountryMockData {
    private List<String> countries;

    private static CountryMockData instance = null;
    public static CountryMockData getInstance() {
        if (instance == null) {
            instance = new CountryMockData();
        }

        return instance;
    }

    public CountryMockData() {
        countries = new ArrayList<String>();

        countries.add("Colombia");
        countries.add("Ethiopia");
        countries.add("Japan");
    }

    public List<String> getCountries() {
        return countries;
    }
}
