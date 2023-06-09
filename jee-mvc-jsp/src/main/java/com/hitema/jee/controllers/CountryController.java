package com.hitema.jee.controllers;


import com.hitema.jee.entities.Country;
import com.hitema.jee.services.CountryService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;


@Controller
public class CountryController {

	private static final Logger log = LogManager.getLogger(CountryController.class);

	private CountryService service;

	public CountryController(CountryService service) {
		this.service = service;
	}

	@PostConstruct
	private void check() {
		log.info("Check postconstruct called service Up : "+(service!=null?"Yes":"No"));
	}
	
	
	@GetMapping("/countries")
    public ModelAndView getCountries() {	
		List<Country> countries = service.readAll();
        return new ModelAndView("countries","countries",countries);
    }

	@RequestMapping(value = "/citiesOfcountry/{cId}", method = RequestMethod.GET)
	public ModelAndView getCities(@PathVariable Long cId) {
		Country c = service.read(cId);
		log.trace("Country : {}", c);
		return new ModelAndView("cities","cities",c.getCities());
	}

	@GetMapping("/countryModify")
	public ModelAndView getCountryModify() {
		log.trace("appel getCountryModify Country");
		Country country = new Country();
		country.setLastUpdate(LocalDateTime.now());
		return new ModelAndView("countryModify", "country", country);
	}

	@PostMapping("/countryModify")
	public ModelAndView countryModify(@ModelAttribute("countryForm") Country country, ModelMap model) {
		log.trace("save the country : {}", country);
		country.setLastUpdate(LocalDateTime.now());
		Country c = service.create(country);
		log.trace("saved : {}", c);
		return new ModelAndView("countryModify", "country", c);
	}
}
