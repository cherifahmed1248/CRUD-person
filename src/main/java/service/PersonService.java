package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.domain.Person;

import dto.PersonDto;
import repository.IPersonRepository;

public class PersonService implements IPersonService {

	@Autowired
	IPersonRepository personRepository;

	@Override
	public void savePerson(PersonDto personDto) throws Exception {
		int age = calculateAge(personDto.getBirthDate());
		if (age >= 150) {
			throw new Exception("age should be less then 150 years");
		}
		Person person = new Person();
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setBirthDate(personDto.getBirthDate());
		personRepository.save(person);
	}

	@Override
	public List<PersonDto> findAllPerson() {
		List<Person> persons = personRepository.findAllByOrderByFirstNameAsc();
		List<PersonDto> personsDto = new ArrayList<>();
		for (Person p : persons) {
			PersonDto person = new PersonDto();
			person.setFirstName(p.getFirstName());
			person.setLastName(p.getLastName());
			person.setBirthDate(p.getBirthDate());
			person.setAge(calculateAge(p.getBirthDate()));
			personsDto.add(person);
		}
		return personsDto;
	}

	private int calculateAge(Date birthDate) {
		Date now = new Date();

		long diff = now.getTime() - birthDate.getTime();

		long years = diff / (1000L * 60 * 60 * 24 * 365);

		return (int) years;
	}

}
