package com.lambda.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class CountryController {

    //localhost:2019/data/allcountries
    @RequestMapping(value= "/allcountries",
                    produces = {"application/json"})

    public ResponseEntity<?> getAllCountries(){

        CountriesApplication.myCountryList.countryList.sort((e1,e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(CountriesApplication.myCountryList.countryList, HttpStatus.OK);

    }


}
