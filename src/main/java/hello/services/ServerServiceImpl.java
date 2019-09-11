package hello.services;

import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;
import hello.repositories.ServerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServerServiceImpl implements ServerService {
    private ServerRepository serverRepository;

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }


    @Override
    public List<MovieDTO> getAllMovies() {

        return serverRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MovieDTO save(Movie movie) {
        return convertToDTO(serverRepository.save(movie));

    }

    @Override
    public Movie saveFullMovie(Movie movie) {
        return serverRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return serverRepository.findAll();
    }

    @Override
    public Movie findMovieByMovieID(int movieID) {
        return serverRepository.findByMovieID(movieID);
    }

    private MovieDTO convertToDTO(Movie movie) {
        return new MovieDTO(movie.getMovieID(), movie.getTitle(), movie.getDescription(), movie.getStartAtTime(), movie.getLengthInMinutes(), movie.getMinimumAge(), movie.getChannel());
    }

    @Override
    public void deleteMovieByChannelID(int movieID) {
        serverRepository.deleteById(movieID);
    }


}
