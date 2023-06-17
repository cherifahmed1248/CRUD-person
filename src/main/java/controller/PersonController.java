package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.PersonDto;
import service.IPersonService;

@RequestMapping(value = "/person")
@RestController
public class PersonController {

	@Autowired
	IPersonService personService;

	@GetMapping("findAll")
	public List<PersonDto> findAllPerson() {
		return personService.findAllPerson();
	}

	@PostMapping("save")
	public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto p) {
		try {
			personService.savePerson(p);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
