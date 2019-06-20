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

    /*@GetMapping(path = "/watch")
    public @ResponseBody
    String routeUserToChannelWithHyperlinkLink(@RequestParam int channelID){
        String token="insertTokenHere";
        return serverService.routeUserToChannelWithHyperlinkLink(token,channelID);
    }*/
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
    Channel saveChannel(@RequestParam Channel channel) {
        return channelService.save(channel);
    }

    @PostMapping(path = "/saveMovie")
    public @ResponseBody
    MovieDTO saveMovie(@RequestBody Movie movie) {

        return serverService.save(movie);
    }
}
