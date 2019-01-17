package pt.com.springboot.api;

import pt.com.springboot.api.model.Student;
import pt.com.springboot.api.repository.StudentRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersistData() {
        Student student = new Student("Roberto", "robertodure1990@gmail.com");
        this.studentRepository.save(student);
        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("Roberto");
        assertThat(student.getEmail()).isEqualTo("robertodure1990@gmail.com");
    }

    @Test
    public void deleteShouldRemoveData() {
        Student student = new Student("Roberto", "robertodure1990@gmail.com");
        this.studentRepository.save(student);
        studentRepository.delete(student);
        assertThat(studentRepository.findOne(student.getId())).isNull();
    }

    @Test
    public void updateShouldChangeAndPersistData() {
        Student student = new Student("Roberto", "robertodure1990@gmail.com");
        this.studentRepository.save(student);
        student.setName("Roberto Duré");
        student.setEmail("robertodure1990@gmail.com");
        this.studentRepository.save(student);
        student = this.studentRepository.findOne(student.getId());
        assertThat(student.getName()).isEqualTo("Roberto Duré");
        assertThat(student.getEmail()).isEqualTo("robertodure1990@gmail.com");
    }

    @Test
    public void findByNameIgnoreCaseContainingShouldIgnoreCase() {
        Student student = new Student("Roberto", "robertodure1990@gmail.com");
        Student student2 = new Student("roberto", "robertodure@gmail.com");
        this.studentRepository.save(student);
        this.studentRepository.save(student2);
        List<Student> studentList = studentRepository.findByNameIgnoreCaseContaining("roberto");
        assertThat(studentList.size()).isEqualTo(2);
    }

    @Test
    public void createWhenNameIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("student's name is required");
        this.studentRepository.save(new Student());
    }

    @Test
    public void createWhenEmailIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        Student student = new Student();
        student.setName("Roberto");
        this.studentRepository.save(student);
    }
    @Test
    public void createWhenEmailIsNotValidShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Enter a valid email");
        Student student = new Student();
        student.setName("Roberto");
        student.setEmail("roberto");
        this.studentRepository.save(student);
    }

}
