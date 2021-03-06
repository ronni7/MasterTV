package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Application;

import hello.entities.User;
import hello.entities.dataObjects.UserLoggedDTO;
import hello.utilities.enums.GENDER;
import hello.utilities.enums.ROLE;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
public class MainControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

          @Test
        public void ShouldReturnUser() throws Exception {
            User user = new User(
                    "imieee",
                    "nazwiskaso",
                    "SpecjalnyTestowy",
                    "Nickname",
                    "hasloJestTajne".toCharArray(),
                    "emaissl@johnny.com",
                    GENDER.MALE,
                    ROLE.USER
            );
            mockMvc.perform(post("http://localhost:8080/register").contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(user).getBytes()))
                    /*   .param("s", mapper.writeValueAsString(u)))*/
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(Matchers.instanceOf(LinkedHashMap.class)));


        }
    @Test
    public void ShouldNotReturnUserBecauseLoginIsAlreadyTaken() throws Exception {
        User user = new User(
                "imie",
                "nazwisko",
                "login",
                "nick",
                "TajneHaslo1".toCharArray(),
                "email@johnny.com",
                GENDER.MALE,
                ROLE.USER
        );
        String json=mockMvc.perform(post("http://localhost:8080/register").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user).getBytes()))
                /*   .param("s", mapper.writeValueAsString(u)))*/
                .andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        User u=mapper.readValue(json,User.class);
            assert u.getUserID()==-1;


    }
    @Test
    public void ShouldReturnAllUsers() throws Exception {

        this.mockMvc.perform(get("http://localhost:8080/all"))
                .andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void ShouldReturnTrueWhenUserHasBeenLoggedSuccessfully() throws Exception {
        String json = mockMvc.perform(post("http://localhost:8080/login")
                .param("password", "TajneHaslo1")
                .param("login", "login"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap()).andReturn().getResponse().getContentAsString();


        UserLoggedDTO u = mapper.readValue(json, UserLoggedDTO.class);
        Assert.assertEquals(u.getRole(), ROLE.USER);
    }

    @Test
    public void ShouldReturnTrueWhenAdminHasBeenLoggedSuccessfully() throws Exception {
        String json = mockMvc.perform(post("http://localhost:8080/login")
                .param("password", "admin")
                .param("login", "admin"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap()).andReturn().getResponse().getContentAsString();

        UserLoggedDTO u = mapper.readValue(json, UserLoggedDTO.class);

        Assert.assertEquals(u.getRole(), ROLE.ADMIN);
    }

}