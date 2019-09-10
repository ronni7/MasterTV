package hello.services;

import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;

import java.util.List;

public interface ServerService {

    List<MovieDTO> getAllMovies();

    MovieDTO save(Movie movie);

    Movie saveFullMovie(Movie movie);

    List<Movie> findAll();

    Movie findMovieByMovieID(int movieID);


}
