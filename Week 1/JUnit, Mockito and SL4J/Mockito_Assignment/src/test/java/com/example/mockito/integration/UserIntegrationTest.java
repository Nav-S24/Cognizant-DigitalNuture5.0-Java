package com.example.mockito.integration;
import com.example.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserIntegrationTest{
 @MockBean UserService service;
 @Autowired UserService injected;
 @Test void contextTest(){
   when(service.getUserById(1L)).thenReturn(null);
 }
}
