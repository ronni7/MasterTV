package hello.controllers;

import hello.entities.Channel;
import hello.entities.Movie;
import hello.entities.dataObjects.MovieDTO;
import hello.services.ChannelServiceImpl;
import hello.services.ServerServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/server")
public class ServerController {
    private final ServerServiceImpl serverService;
    private final ChannelServiceImpl channelService;

    public ServerController(ServerServiceImpl serverService, ChannelServiceImpl channelService) {
        this.serverService = serverService;
        this.channelService = channelService;
    }

    @GetMapping(path = "/watch")
    public @ResponseBody
    String routeUserToChannelWithHyperlinkLink(@RequestParam int channelID) {
        return channelService.getChannelByChannelID(channelID).getHyperlink();
    }

    @GetMapping(path = "/allMovies")
    public @ResponseBody
    List<MovieDTO> allMovies() {
        return serverService.getAllMovies();
    }

    @GetMapping(path = "/allM")
    public @ResponseBody
    List<Movie> allM() {
        return serverService.findAll();
    }

    @GetMapping(path = "/allChannels")
    public @ResponseBody
    List<Channel> allChannels() {
        return channelService.getAllChannels();
    }

    @PostMapping(path = "/saveChannel")
    public @ResponseBody
    Channel saveChannel(@RequestBody Channel channel) {
        return channelService.save(channel);
    }

    @PostMapping(path = "/saveMovie")
    public @ResponseBody
    MovieDTO saveMovie(@RequestBody Movie movie) {

        return serverService.save(movie);
    }

    @PostMapping(path = "/updateMovie")
    public @ResponseBody
    Movie updateMovie(@RequestParam int channelID, @RequestParam int movieID, @RequestParam String startingTime) {
        Movie m = serverService.findMovieByMovieID(movieID);
        m.setStartAtTime(startingTime);
        m.setChannel(channelService.getChannelByChannelID(channelID));
        return serverService.saveFullMovie(m);
    }

    @PostMapping(path = "/updateChannel")
    public @ResponseBody
    Channel updateChannel(@RequestParam int channelID, @RequestParam int movieID, @RequestParam String startingTime) {
        Channel c = channelService.getChannelByChannelID(channelID);
        c.getPlaylist().add(serverService.findMovieByMovieID(updateMovie(channelID, movieID, startingTime).getMovieID()));
        return channelService.save(c);
    }

    @PostMapping(path = "/updateChannelHyperlink")
    public @ResponseBody
    Channel setChannelHyperlink(@RequestParam int channelID, @RequestParam String hyperlink) {
        Channel c = channelService.getChannelByChannelID(channelID);
        c.setHyperlink(hyperlink);
        return channelService.save(c);
    }

    @GetMapping(path = "/getMovieFilename")
    public @ResponseBody
    String getMovieFilename(@RequestParam int movieID) {
        return serverService.findMovieByMovieID(movieID).getFileName();
    }

    @PostMapping(path = "/deleteChannel")
    public @ResponseBody
    void deleteChannel(@RequestParam int channelID) {
        channelService.deleteChannelByChannelID(channelID);
    }

    @PostMapping(path = "/deleteMovie")
    public @ResponseBody
    void deleteMovie(@RequestParam int movieID) {
        serverService.deleteMovieByChannelID(movieID);
    }
}
