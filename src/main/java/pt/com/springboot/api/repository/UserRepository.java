package pt.com.springboot.api.repository;

import org.springframework.data.jpa.repository.Query;
import pt.com.springboot.api.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);

}
