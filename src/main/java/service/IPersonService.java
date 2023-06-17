package service;

import java.util.List;

import dto.PersonDto;

public interface IPersonService {

	public void savePerson(PersonDto personDto) throws Exception;
	
	public List<PersonDto> findAllPerson();

}
