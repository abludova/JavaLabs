import java.time.LocalDateTime;
public class Movie {
    private String title;
    private int duration;
    private LocalDateTime startTime;
    public Movie(String title, int duration, LocalDateTime startTime){
        this.title =title;
        this.duration =duration;
        this.startTime = startTime;
    }
    public String getTitle(){
        return title;
    }
    public int getDuration(){
        return duration;
    }
    public LocalDateTime getStartTime(){
        return startTime;
    }
    public  void setTitle(String title){
        this.title = title;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", startTime=" + startTime +
                '}';
    }


}
