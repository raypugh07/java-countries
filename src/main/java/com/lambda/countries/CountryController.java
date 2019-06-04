package com.lambda.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    //localhost:2019/data/allcountries
    @RequestMapping(value= "/allcountries",
                    produces = {"application/json"})

    public ResponseEntity<?> getCountryDetail(){

        CountriesApplication.myCountryList.countryList.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(CountriesApplication.myCountryList.countryList, HttpStatus.OK);

    }

    //localhost:2019/data/country/2
    @GetMapping(value="/country/{id}",
                produces={"application/json"})
    public ResponseEntity<?> getCountryDetail(@PathVariable long id){
        Country rtnCountry= CountriesApplication.myCountryList.findCountry(e -> (e.getId() == id));
        return new ResponseEntity<>(rtnCountry,HttpStatus.OK);
    }

    //localhost:2019/data/countries/a
    @GetMapping(value="/countries/{letter}",
                produces={"application/json"})
    public ResponseEntity<?> getACountries(
            @PathVariable char letter){

        ArrayList<Country> rtnACountries=CountriesApplication.myCountryList.findCountries(e->e.getName().toUpperCase().
                charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnACountries,HttpStatus.OK);
    }

    //localhost:2019/data/name/size/{number}
    @GetMapping(value="/name/size/{number}",
                produces={"application/json"})
    public ResponseEntity<?> getTheseCountries(
            @PathVariable int number) {

        ArrayList<Country> rtnTheseCountries=CountriesApplication.myCountryList.findCountries(e->e.getName().length()==
                number);
        return new ResponseEntity<>(rtnTheseCountries,HttpStatus.OK);
    }

    //localhost:2019/data/population/size/{people}
    @GetMapping(value="/population/size/{people}",
                produces={"application/json"})
    public ResponseEntity<?> getThoseCountries(
            @PathVariable double people) {
        ArrayList<Country> rtnThoseCountries=CountriesApplication.myCountryList.findCountries(e->e.getPopulation()>=
                people);
        return new ResponseEntity<>(rtnThoseCountries,HttpStatus.OK);
    }

    //localhost:2019/data/population/min
   /* @GetMapping(value="/population/min",
                produces = {"application/json"})
    public ResponseEntity<?> getMinCountry(
            @PathVariable double min){
        ArrayList<Country> rtnMinCountry=CountriesApplication.myCountryList.findCountry(e->e.getPopulation())

    }*/

    


}
