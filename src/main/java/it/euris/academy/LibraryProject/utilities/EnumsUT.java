package it.euris.academy.LibraryProject.utilities;

import it.euris.academy.LibraryProject.enums.Gender;

public class EnumsUT {

	public static String toString(Gender value) {
		return value == null ? null : value.name();
	}

	public static Gender getGenderType(String value) {
		if (value == null) {
			return null;
		}
		for (Gender type : Gender.values()) {
			if (type.name().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
	public static Gender getGenderTypeBetter(String value) {
		 return  null;
	}
}
