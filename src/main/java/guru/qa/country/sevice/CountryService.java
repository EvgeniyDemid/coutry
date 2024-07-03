package guru.qa.country.sevice;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.exception.ResourceNotFoundException;
import guru.qa.country.model.Country;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class CountryService {

	private final CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public List<CountryEntity> allCountries() {
		return countryRepository.findAll();

	}

	public CountryEntity countryById(UUID uuid) throws ResourceNotFoundException {
		return
				countryRepository.
						findById(uuid).
						orElseThrow(() -> new ResourceNotFoundException(
								uuid));
	}


	public @Nonnull
	CountryEntity addCounty(@Nonnull Country county) {

		final String name = county.name();
		final String code = county.code();

		CountryEntity ce = new CountryEntity();
		ce.setName(name);
		ce.setCode(code);
		return countryRepository.save(ce);
	}

	public @Nonnull CountryEntity editCountryById(UUID uuid, Country country) {

		CountryEntity countryEntity = countryRepository
				.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(
						uuid));
		countryEntity.setName(country.name());
		return countryRepository.save(countryEntity);
	}
}
