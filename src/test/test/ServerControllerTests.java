package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import hello.Application;
import hello.entities.Channel;
import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@Transactional
public class ServerControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void ShouldReturnAllMoviesAsDTO() throws Exception {

        String json = this.mockMvc.perform(get("http://localhost:8080/server/allMovies"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$").isArray()).andReturn().getResponse().getContentAsString();
        TypeFactory mapCollectionType = mapper.getTypeFactory();
        List<MovieDTO> movieList = mapper.readValue(json, mapCollectionType.constructCollectionType(List.class, MovieDTO.class));
        System.out.println("movieList = " + movieList);
         }

    @Test
    public void ShouldReturnAllChannels() throws Exception {

        String json = this.mockMvc.perform(get("http://localhost:8080/server/allChannels"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$").isArray()).andReturn().getResponse().getContentAsString();
        TypeFactory mapCollectionType = mapper.getTypeFactory();
        List<Channel> channelsList = mapper.readValue(json, mapCollectionType.constructCollectionType(List.class, Channel.class));
        System.out.println("channelsList = " + channelsList);

    }

    @Test
    public void ShouldReturnSavedMovieDTO() throws Exception {

        Movie movie = new Movie("Movie 1", "Description", 292, 13,"12:00", "movie11111111.mp4");
        String json = this.mockMvc.perform(post("http://localhost:8080/server/saveMovie").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(movie).getBytes())).andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //.andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$").isArray())
        MovieDTO movieDTO = mapper.readValue(json, MovieDTO.class);
        System.out.println("movieDTO = " + movieDTO);

    }
    @Test
    public void ShouldReturnUpdatedChannelWithAddedMovieOntoPlaylist() throws Exception {

        String json = this.mockMvc.perform(post("http://localhost:8080/server/updateChannel").param("channelID","1").param("movieID","34").param("startingTime","13:00")).andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //.andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$").isArray())
        Channel channel = mapper.readValue(json, Channel.class);
        System.out.println("channel.getPlaylist() = " + channel.getPlaylist());
    }
    @Test
    public void ShouldReturnUpdatedMovieAssignedToChannel() throws Exception {
        //String testMovieID="34", testStartAtTime="13:00";
        String json = this.mockMvc.perform(post("http://localhost:8080/server/updateMovie").param("channelID","1").param("movieID","35").param("startingTime","15:00")).andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        //.andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$").isArray())
        MovieDTO movieDTO = mapper.readValue(json, MovieDTO.class);
        System.out.println("movieDTO = " + movieDTO.toString());

    }

}
