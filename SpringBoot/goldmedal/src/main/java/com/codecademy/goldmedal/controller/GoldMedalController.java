package com.codecademy.goldmedal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.goldmedal.model.CountriesResponse;
import com.codecademy.goldmedal.model.Country;
import com.codecademy.goldmedal.model.CountryDetailsResponse;
import com.codecademy.goldmedal.model.CountrySummary;
import com.codecademy.goldmedal.repositories.CountriesRepository;
import com.codecademy.goldmedal.repositories.GoldMedalsRepository;

@RestController
@RequestMapping("/countries")
public class GoldMedalController {
	
	
	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private GoldMedalsRepository goldMedalsRepository;

    public GoldMedalController() {
    }

    @GetMapping
    public CountriesResponse getCountries(@RequestParam String sort_by, @RequestParam String ascending) {
        var ascendingOrder = ascending.toLowerCase().equals("y");
        return new CountriesResponse(getCountrySummaries(sort_by.toLowerCase(), ascendingOrder));
    }

   
    @GetMapping("/{country}")
    public CountryDetailsResponse getCountryDetails(@PathVariable String country) {
        String countryName = WordUtils.capitalizeFully(country);
        return getCountryDetailsResponse(countryName);
    }
    

    /*
    @GetMapping("/{country}/medals")
    public CountryMedalsListResponse getCountryMedalsList(@PathVariable String country, @RequestParam String sort_by, @RequestParam String ascending) {
        String countryName = WordUtils.capitalizeFully(country);
        var ascendingOrder = ascending.toLowerCase().equals("y");
        return getCountryMedalsListResponse(countryName, sort_by.toLowerCase(), ascendingOrder);
    }*/

    /*private CountryMedalsListResponse getCountryMedalsListResponse(String countryName, String sortBy, boolean ascendingOrder) {
        List<GoldMedal> medalsList;
        switch (sortBy) {
            case "year":
                //medalsList = // TODO: list of medals sorted by year in the given order
                break;
            case "season":
                //medalsList = // TODO: list of medals sorted by season in the given order
                break;
            case "city":
                //medalsList = // TODO: list of medals sorted by city in the given order
                break;
            case "name":
                //medalsList = // TODO: list of medals sorted by athlete's name in the given order
                break;
            case "event":
                //medalsList = // TODO: list of medals sorted by event in the given order
                break;
            default:
                //medalsList = new ArrayList<>();
                break;
        }
        return null;
        //return new CountryMedalsListResponse(medalsList);
    }*/

    private CountryDetailsResponse getCountryDetailsResponse(String countryName) {
        final var countryOptional =  countriesRepository.findByName(countryName);
        if (countryOptional.isEmpty()) {
            return new CountryDetailsResponse(countryName);
        }

        final var country = countryOptional.get();
        final var goldMedalCount = goldMedalsRepository.countByCountry(countryName);

        final var summerWins = goldMedalsRepository.findByCountryAndSeasonOrderByYearAsc(countryName, "Summer"); 
        final var numberSummerWins = summerWins.size() > 0 ? summerWins.size() : null;
        final var totalSummerEvents = goldMedalsRepository.countBySeason("Summer");
        final var percentageTotalSummerWins = totalSummerEvents != 0 && numberSummerWins != null ? (float) summerWins.size() / totalSummerEvents : null;
        final var yearFirstSummerWin = summerWins.size() > 0 ? summerWins.get(0).getYear() : null;

        final var winterWins =  goldMedalsRepository.findByCountryAndSeason(countryName, "Winter");
        final Integer numberWinterWins = winterWins != null && winterWins.size() > 0 ? winterWins.size() : 0;
        final Integer totalWinterEvents = goldMedalsRepository.countBySeason("Winter");
        final var percentageTotalWinterWins = totalWinterEvents != 0 && numberWinterWins != null ? (float) winterWins.size() / totalWinterEvents : null;
        final Integer yearFirstWinterWin = winterWins != null && winterWins.size() > 0 ? winterWins.get(0).getYear() : 0;

        final var numberEventsWonByFemaleAthletes = goldMedalsRepository.countByGenderAndCountry("Women", countryName);
        final var numberEventsWonByMaleAthletes = goldMedalsRepository.countByGenderAndCountry("Men", countryName);

        return new CountryDetailsResponse(
                countryName,
                country.getGdp(),
                country.getPopulation(),
                goldMedalCount,
                numberSummerWins,
                percentageTotalSummerWins,
                yearFirstSummerWin,
                numberWinterWins,
                percentageTotalWinterWins,
                yearFirstWinterWin,
                numberEventsWonByFemaleAthletes,
                numberEventsWonByMaleAthletes);
    }

    private List<CountrySummary> getCountrySummaries(String sortBy, boolean ascendingOrder) {
        List<Country> countries;
        switch (sortBy) {
            case "name":
                countries = ascendingOrder ? countriesRepository.findAllByOrderByNameAsc() : countriesRepository.findAllByOrderByNameDesc(); 
                break;
            case "gdp":
                countries = ascendingOrder ? countriesRepository.findAllByOrderByGdpAsc() : countriesRepository.findAllByOrderByGdpDesc();
                break;
            case "population":
                countries = ascendingOrder ? countriesRepository.findAllByOrderByPopulationAsc() : countriesRepository.findAllByOrderByPopulationDesc();
                break;
            case "medals":
            default:
                countries = countriesRepository.findAllByOrderByNameAsc();
                break;
        }

        var countrySummaries = getCountrySummariesWithMedalCount(countries);

        if (sortBy.equalsIgnoreCase("medals")) {
            countrySummaries = sortByMedalCount(countrySummaries, ascendingOrder);
        }

        return countrySummaries;
    }

    private List<CountrySummary> sortByMedalCount(List<CountrySummary> countrySummaries, boolean ascendingOrder) {
        return countrySummaries.stream()
                .sorted((t1, t2) -> ascendingOrder ?
                        t1.getMedals() - t2.getMedals() :
                        t2.getMedals() - t1.getMedals())
                .collect(Collectors.toList());
    }

    private List<CountrySummary> getCountrySummariesWithMedalCount(List<Country> countries) {
        List<CountrySummary> countrySummaries = new ArrayList<>();
        for (var country : countries) {
            var goldMedalCount = goldMedalsRepository.countByCountry(country.getName());
            countrySummaries.add(new CountrySummary(country, goldMedalCount));
        }
        return countrySummaries;
    }
}
