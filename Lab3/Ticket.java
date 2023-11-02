public class Ticket {
    private MovieSession movieSession;
    private Seat seat;
    private int price;
    private boolean isBooked;
    public Ticket(MovieSession movieSession, Seat seat, int price, boolean isBooked) {
        this.movieSession = movieSession;
        this.seat = seat;
        this.price = price;
        this.isBooked = isBooked;
    }
    public MovieSession getMovieSession() {
        return movieSession;
    }
    public Seat getSeat() {
        return seat;
    }
    public int getPrice() {
        return price;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "movieSession=" + movieSession +
                ", seat=" + seat +
                ", price=" + price +
                ", isBooked=" + isBooked +
                '}';
    }
}
