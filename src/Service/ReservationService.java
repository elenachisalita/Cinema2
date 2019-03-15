package Service;

import Domain.Movie;
import Domain.Reservation;
import Repository.MovieRepository;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {


    private ReservationRepository reservationRepository;
    private MovieRepository movieRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
    }

    public Reservation addOrUpdate (String id, String idMovie, String idClientCard, String date, String time) {
        Reservation existing = reservationRepository.findById(id);
        if (existing != null) {
            //keep unchanged fields as they were
            if (idMovie.isEmpty()) {
                idMovie = existing.getIdMovie();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

            Movie movieSold = movieRepository.findById(idMovie);
            if (movieSold == null) {
                throw new RuntimeException("There is no movie with the given id!");
            }
            double basePrice = movieSold.getPrice();
            double bonus = 0;
            if(idClientCard != null && movieSold.isAvalible()) {
                bonus = 0.1;
            }

            Reservation reservation = new Reservation(id, idMovie, idClientCard, date, time);
            reservationRepository.upsert(reservation);
            return reservation;
        }


    public void remove (String id) {
        reservationRepository.remove(id);
    }

    public List<Reservation > getAll() {
        return reservationRepository.getAll();
    }
}
