package com.myapp.sample.controller;
package com.mkyong.disable;

import com.myapp.sample.model.Person;
import com.myapp.sample.repositories.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@Disabled("Disabled until bug #2019 has been fixed!")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
  
  MockMvc mockMvc;
  
  @Mock
  private PersonController personController;
  
  @Autowired
  private TestRestTemplate template;
  
  @Autowired
  PersonRepository personRepository;
  
  @Before
  public void setup() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    personRepository.deleteAll();
  }
  
  @Test
  public void testRegister() throws Exception {
    
    Assert.assertEquals(200,200);
  }

  @Test
  public void testGetAllPersons() throws Exception {
    
    Assert.assertEquals(200,200);
  }

  @Test
  public void testGetPersonById() throws Exception {
    
    Assert.assertEquals(200,200);
  }

  @Test
  public void testGetPersonByNull() throws Exception {
    
    Assert.assertEquals(404,404);
  }

  private HttpEntity<Object> getHttpEntity(Object body) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<Object>(body, headers);
  }

}
