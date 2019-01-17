package pt.com.springboot.api.javaclient;

import pt.com.springboot.api.model.Student;


public class JavaSpringClientTest {
    public static void main(String[] args) {

        Student studentPost = new Student();
        studentPost.setName("robert");
        studentPost.setEmail("robert@gmail.com");
        JavaClientDAO dao = new JavaClientDAO();
        dao.delete(29);

    }

}
