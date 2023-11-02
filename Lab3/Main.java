import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cinema> cinemas = new ArrayList<>();
        //кинотеатры
        Cinema cinema1 = new Cinema("Каро7", "пр-т. Ленинский 30");
        Cinema cinema2 = new Cinema("СинемаПарк", "ТРЦ «Европа», ул. Профессора Баранова 40");
        Cinema cinema3 = new Cinema("Киносфера", "ул. Генерала Челнокова 11");
        Cinema cinema4 = new Cinema("Заря", "пр-т. Мира 41/43");

        //залы
        Hall hall1Cinema1 = new Hall("Зал 1", 3);
        Hall hall2Cinema1 = new Hall("Зал 2", 2);
        Hall hall1Cinema2 = new Hall("Зал 1", 3);
        Hall hall1Cinema3 = new Hall("Зал 1", 4);
        Hall hall2Cinema3 = new Hall("Зал 2", 1);
        Hall hall1Cinema4 = new Hall("Зал 1", 2);

        //сиденья
        Seat seat1 = new Seat(1, 1);
        Seat seat2 = new Seat(1, 2);
        Seat seat3 = new Seat(2, 1);
        Seat seat4 = new Seat(2, 2);

        //фильмы
        Movie movie1 = new Movie("Повелитель ветра", 99, LocalDateTime.of(2023, 10, 13, 10, 30));
        Movie movie2 = new Movie("Смешарики снимают кино", 60, LocalDateTime.of(2023, 10, 13, 11, 0));
        Movie movie3 = new Movie("Вася не в себе", 90, LocalDateTime.of(2023, 10, 13, 14, 1));
        Movie movie4 = new Movie("Выжившая", 101, LocalDateTime.of(2023, 10, 13, 15, 1));

        //сеансы
        MovieSession session1 = new MovieSession(movie1, hall1Cinema1, 500.0, cinema1);
        MovieSession session2 = new MovieSession(movie2, hall1Cinema2, 550.0, cinema2);
        MovieSession session3 = new MovieSession(movie3, hall1Cinema3, 490.0, cinema3);
        MovieSession session4 = new MovieSession(movie4, hall1Cinema4, 500.0, cinema4);

        // добавляем сеансы в кинотеатры
        cinema1.addMovieSession(session1);
        cinema2.addMovieSession(session2);
        cinema3.addMovieSession(session3);
        cinema4.addMovieSession(session4);

        hall1Cinema2.addMovieSession(session2);
        hall1Cinema3.addMovieSession(session3);
        hall2Cinema3.addMovieSession(session3);
        hall1Cinema4.addMovieSession(session4);

        cinemas.add(cinema1);
        cinemas.add(cinema2);
        cinemas.add(cinema3);
        cinemas.add(cinema4);

        AdminMode adminMode = new AdminMode(cinemas);
        UserMode userMode = new UserMode(cinemas);

        System.out.println("Выберите режим:");
        System.out.println("1. Режим администратора");
        System.out.println("2. Режим пользователя");

        Scanner scanner = new Scanner(System.in);
        int modeChoice = scanner.nextInt();

        if (modeChoice == 1) {
            adminMode.start();
        } else if (modeChoice == 2) {
            userMode.start();
        } else {
            System.out.println("Неправильный выбор режима");
        }
    }
}
