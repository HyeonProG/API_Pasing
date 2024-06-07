package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	
	private int id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
	
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Geo {
	private float lat;
	private float lng;
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Company {
	private String name;
	private String catchPhrase;
	private String bs;
}

