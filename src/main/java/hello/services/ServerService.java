package hello.services;

import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;

import java.util.List;

public interface ServerService {
    String routeUserToChannelWithHyperlinkLink(String token, int channelID);

    List<MovieDTO> getAllMovies();

    MovieDTO save(Movie movie);
    List<Movie> findAll();
}
