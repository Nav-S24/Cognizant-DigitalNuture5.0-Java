package com.example.junit.repository;
import com.example.junit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User,Long>{
 List<User> findByName(String name);
}
