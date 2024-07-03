package guru.qa.country.model;

import guru.qa.country.data.CountryEntity;

public record Country(String name, String code) {

	public static Country fromEntity(CountryEntity country) {
		return new Country(
				country.getName(),
				country.getCode()
		);
	}
}

