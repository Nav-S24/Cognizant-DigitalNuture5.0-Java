package com.example.mockito.service;
import com.example.mockito.entity.User;
import com.example.mockito.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceTest{
 @Mock UserRepository repo;
 @InjectMocks UserService service;
 @Test void testGetUser(){
  when(repo.findById(1L)).thenReturn(Optional.of(new User(1L,"Alice")));
  assertEquals("Alice",service.getUserById(1L).getName());
 }
}
