package com.example.mockito.controller;
import com.example.mockito.entity.User;
import com.example.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserControllerTest{
 @Mock UserService service;
 @InjectMocks UserController controller;
 @Test void testGetUser(){
   User u=new User(1L,"John");
   when(service.getUserById(1L)).thenReturn(u);
   assertEquals("John",controller.getUser(1L).getBody().getName());
 }
}
