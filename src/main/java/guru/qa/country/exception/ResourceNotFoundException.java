package guru.qa.country.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(UUID uuid){
		super("Could not find country by id = " + uuid);
	}
}
