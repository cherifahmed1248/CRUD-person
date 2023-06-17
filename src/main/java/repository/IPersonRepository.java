package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.domain.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

	List<Person> findAllByOrderByFirstNameAsc();

}
