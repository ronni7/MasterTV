package hello.repositories;

import hello.entities.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findAll();

    Movie findByMovieID(Integer movieID);

}
