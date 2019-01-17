package pt.com.springboot.api.repository;

import org.springframework.data.jpa.repository.Query;
import pt.com.springboot.api.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import pt.com.springboot.api.model.User;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);

    Student findByEmailIgnoreCaseContaining(String email);


}
