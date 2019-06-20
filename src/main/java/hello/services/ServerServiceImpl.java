package hello.services;

import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;
import hello.repositories.ServerRepository;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServerServiceImpl implements ServerService {
    private ServerRepository serverRepository;

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public String routeUserToChannelWithHyperlinkLink(String token, int channelID) {
        return null;
    }

    @Override
    public List<MovieDTO> getAllMovies() {

      //  List<Movie> list = serverRepository.findAll();
      //  System.out.println("list = " + list);
      //  System.out.println("list.stream() = " + list.stream());

       // List<Movie> movieList= list.stream().collect(Collectors.toList()).forEach(movie -> movie.setDescription("CHUJ"));;
      //  System.out.println("list movieslist= " + movieList);
        // list.stream().forEach(movie -> convertToDTO(movie));
     /*   for (Movie m : list) {
            System.out.println("m = " + m);
            System.out.println("new MovieDTO(m.getMovieID(), m.getTitle(), m.getDescription(), m.getLengthInMinutes(), m.getMinimumAge()) = "
                    + new MovieDTO(m.getMovieID(), m.getTitle(), m.getDescription(), m.getLengthInMinutes(), m.getMinimumAge()));

        }*/
     //   List<MovieDTO> lissst=list.forEach(this::convertToDTO);
        return serverRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MovieDTO save(Movie movie) {
        return convertToDTO(serverRepository.save(movie));

    }

    @Override
    public List<Movie> findAll() {
        return serverRepository.findAll();
    }

    private MovieDTO convertToDTO(Movie movie) {
        return new MovieDTO(movie.getMovieID(), movie.getTitle(), movie.getDescription(), movie.getLengthInMinutes(), movie.getMinimumAge());
    }
    /* @Override
    public String getChannelHyperlink(int channelID) {
       return hyperlinks.stream().filter(channel -> channel.getChannelID()==channelID).findFirst().get().getHyperlink();
    }*/


}
