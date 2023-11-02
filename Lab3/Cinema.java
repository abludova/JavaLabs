import java.util.ArrayList;
import java.util.List;
public class Cinema {
    private String name;
    private String address;
    private List<Hall> halls;
    private List<Movie> movies;
    private List<MovieSession> movieSessions;
    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.movieSessions = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public List<Hall> getHalls() {
        return halls;
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public List<MovieSession> getMovieSessions() {
        return movieSessions;
    }
    public void addHall(Hall hall) {
        halls.add(hall);
    }
    public void removeHall(Hall hall) {
        halls.remove(hall);
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }
    public void addMovieSession(MovieSession movieSession) {
        movieSessions.add(movieSession);
    }
    public void removeMovieSession(MovieSession movieSession) {
        movieSessions.remove(movieSession);
    }
    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", halls=" + halls +
                ", movies=" + movies +
                ", movieSessions=" + movieSessions +
                '}';
    }
}
