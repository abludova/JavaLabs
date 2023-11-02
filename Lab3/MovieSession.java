public class MovieSession {
    private Movie movie;
    private Hall hall;
    private double ticketPrice;
    private Cinema cinema;
    public MovieSession(Movie movie, Hall hall, double ticketPrice, Cinema cinema) {
        this.movie = movie;
        this.hall = hall;
        this.ticketPrice = ticketPrice;
        this.cinema = cinema;
    }
    public Movie getMovie() {
        return movie;
    }
    public Hall getHall() {
        return hall;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public Cinema getCinema() {
        return cinema;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    @Override
    public String toString() {
        return "MovieSession{" +
                "movie=" + movie.getTitle() + // Включаем информацию о фильме
                ", hall=" + hall.getName() + // Включаем информацию о зале
                ", ticketPrice=" + ticketPrice +
                ", cinema=" + cinema.getName() + // Включаем информацию о кинотеатре
                '}';
    }
}
