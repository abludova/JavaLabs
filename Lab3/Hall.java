import java.util.ArrayList;
import java.util.List;
public class Hall {
    private String name;
    private int capacity;
    private List<Seat> seats;
    private List<MovieSession> movieSessions;
    public Hall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.seats = new ArrayList<>();
        this.movieSessions = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
    }
    public void removeSeat(Seat seat) {
        seats.remove(seat);
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public List<MovieSession> getMovieSessions() {
        return movieSessions;
    }
    public void addMovieSession(MovieSession movieSession) {
        movieSessions.add(movieSession);
    }
    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", seats=" + seats +
                ", movieSessions=" + movieSessions +
                '}';
    }
}
