package guru.qa.country.controller;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.model.Country;
import guru.qa.country.sevice.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {

	private final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping("/all")
	public List<CountryEntity> allCountries() {
		return countryService.allCountries();
	}

	@GetMapping("/{id}")
	public CountryEntity countryById(@PathVariable UUID id) {
		return countryService.countryById(id);
	}

	@PostMapping("/add")
	public CountryEntity addCountry(@RequestBody Country country) {
		return countryService.addCounty(country);
	}

	@PatchMapping("/edit/{id}")
	public CountryEntity editCountry(@PathVariable UUID id, @RequestBody Country country) {
		return countryService.editCountryById(id, country);
	}
}
