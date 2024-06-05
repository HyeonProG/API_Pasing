package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog {

	private String name;
	private String breed;
	private int age;

	public static void main(String[] args) {

		Dog dog1 = new Dog("도리", "말티즈", 10);
		Dog dog2 = new Dog("곰이", "시바견", 5);

		Dog[] dogArr = { dog1, dog2 };

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String dog1Str = gson.toJson(dog1);
		System.out.println(dog1Str);

		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		String dog2Str = gson2.toJson(dog2);
		System.out.println(dog2Str);

		Dog dogObject = gson.fromJson(dog1Str, Dog.class);
		System.out.println(dogObject.getName() + "\n" + dogObject.getBreed() + "\n" + dogObject.getAge());

	} // end of main

}
