import java.util.List;
import java.util.Scanner;
public class AdminMode {
    private List<Cinema> cinemas;
    private Scanner scanner;
    public AdminMode(List<Cinema> cinemas) {
        this.cinemas = cinemas;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("Меню администратора:");
            System.out.println("1. Просмотр информации о кинотеатрах");
            System.out.println("2. Выход");

            int choice = scanner.nextInt();
            if (choice == 1) {
                displayCinemaInfo(); // Добавьте этот вызов для вывода информации о кинотеатрах
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Неправильный выбор");
            }
        }
    }

    private void displayCinemaInfo() {
        for (Cinema cinema : cinemas) {
            System.out.println("Кинотеатр: " + cinema.getName());
            System.out.println("Адрес: " + cinema.getAddress());
            for (Hall hall : cinema.getHalls()) {
                System.out.println("Зал:" + hall.getName());
                System.out.println("Вместимость зала" + hall.getCapacity());
                for (MovieSession session : hall.getMovieSessions()) {
                    Movie movie = session.getMovie();
                    System.out.println("Фильм:" + movie.getTitle());
                    System.out.println("Стоимость" + session.getTicketPrice() );
                    System.out.println("Свободные места в зале:");
                    for (Seat seat : hall.getSeats()) {
                        boolean isBooked = false;
                        for (Ticket ticket : seat.getTickets()) {
                            if (ticket != null && ticket.getMovieSession() == session && ticket.isBooked()) {
                                isBooked = true;
                                break;
                            }
                        }
                        if (!isBooked) {
                            System.out.println("      Ряд " + seat.getRow() + ", Место " + seat.getNumber());
                        }
                    }
                }
            }
            System.out.println();
        }
    }

}
