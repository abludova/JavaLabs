import java.util.ArrayList;
import java.util.List;
public class Seat {
    private int row;
    private int number;
    private List<Ticket> tickets; // Добавляем список билетов для данного места
    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.tickets = new ArrayList<>();
    }
    public int getRow() {
        return row;
    }
    public int getNumber() {
        return number;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }
    public boolean isEmployed() {
        // Проверяем, есть ли забронированные билеты для данного места
        for (Ticket ticket : tickets) {
            if (ticket.isBooked()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", number=" + number +
                ", isEmployed=" + isEmployed() +
                '}';
    }
}
