package Domain;

public class Reservation {

    private String id, idMovie, idClientCard, date, time;

    public Reservation(String id, String idMovie, String idClientCard, String date, String time) {
        this.id = id;
        this.idMovie = idMovie;
        this.idClientCard = idClientCard;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idMovie='" + idMovie + '\'' +
                ", idClientCard='" + idClientCard + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(String idClientCard) {
        this.idClientCard = idClientCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
