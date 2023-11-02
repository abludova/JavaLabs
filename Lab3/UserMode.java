import java.util.List;
import java.util.Scanner;

public class UserMode {
    private List<Cinema> cinemas;
    private Scanner scanner;
    public UserMode(List<Cinema> cinemas) {
        this.cinemas = cinemas;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("Меню пользователя:");
            System.out.println("1. Просмотреть список кинотеатров");
            System.out.println("2. Выбрать кинотеатр");
            System.out.println("3. Выход");
            int choice = scanner.nextInt();
            if (choice == 1) {
                displayCinemas();
            } else if (choice == 2) {
                selectCinema();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Неправильный выбор");
            }
        }
    }
    private void displayCinemas() {
        System.out.println("Список кинотеатров:");
        for (Cinema cinema : cinemas) {
            System.out.println("Название: " + cinema.getName());
            System.out.println("Адрес: " + cinema.getAddress());
            System.out.println();
        }
    }
    private void selectCinema() {
        System.out.println("Введите номер выбранного кинотеатра:");
        int cinemaNumber = scanner.nextInt();
        if (cinemaNumber >= 1 && cinemaNumber <= cinemas.size()) {
            Cinema selectedCinema = cinemas.get(cinemaNumber - 1);
            System.out.println("Вы выбрали кинотеатр: " + selectedCinema.getName());
        } else {
            System.out.println("Неправильный номер");
        }
    }
}
