package eu.java.pg.jsonb;

import eu.java.pg.jsonb.domain.CommonPerson;
import eu.java.pg.jsonb.domain.Professor;
import eu.java.pg.jsonb.domain.Student;
import eu.java.pg.jsonb.domain.info.ProfessorInfo;
import eu.java.pg.jsonb.domain.info.StudentInfo;
import eu.java.pg.jsonb.repository.CommonPersonRepository;
import eu.java.pg.jsonb.repository.ProfessorRepository;
import eu.java.pg.jsonb.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PgJsonApplication.class)
public class PgJsonDemoTest {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CommonPersonRepository commonPersonRepository;

    @PersistenceContext
    private EntityManager em;

    @Before
    public void setup(){
       commonPersonRepository.deleteAll();
    }

    @Test
    public void demoTest(){
        Student student = new Student();
        student.setEmail("student@pgjson.org");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setAge(20);
        studentInfo.setFirstName("Johnny");
        studentInfo.setLastName("Ventura");
        student.setInfo(studentInfo);
        Student savedStudent = studentRepository.save(student);
        Student readStudent = studentRepository.findOne(savedStudent.getId());
        System.out.println("************************************************************");
        System.out.println(readStudent);
        System.out.println("************************************************************");


        Professor professor = new Professor();
        professor.setEmail("professor@pgjson.org");
        ProfessorInfo professorInfo = new ProfessorInfo();
        professorInfo.setFirstName("Archibald");
        professorInfo.setLastName("Wisconsin");
        List<String> courses = new ArrayList<>();
        courses.add("Physics");
        courses.add("Mathematics");
        professorInfo.setCourses(courses);
        professor.setInfo(professorInfo);
        Professor savedProfessor = professorRepository.save(professor);
        Professor readProfessor = professorRepository.findOne(savedProfessor.getId());
        System.out.println("-----------------------------------------------------------");
        System.out.println(readProfessor);
        System.out.println("-----------------------------------------------------------");


        System.out.println("///////////////////////////////////////////////////////////");
        List<CommonPerson> readCommonPersons = commonPersonRepository.findAll();
        readCommonPersons.forEach(commonPerson -> System.out.println(commonPerson));
        System.out.println("///////////////////////////////////////////////////////////");
    }



}
