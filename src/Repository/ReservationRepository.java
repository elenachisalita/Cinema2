package Repository;

import Domain.Reservation;
import Domain.ReservationValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationRepository {

    private Map<String, Reservation> storage = new HashMap<>();
    private ReservationValidator validator;

    public ReservationRepository (ReservationValidator validator) {
        this.validator = validator;
    }

    public Reservation findById (String id) {
        return storage.get(id);
    }

    /**
     * adds or updates a reservation if it already exists
     * @param reservation the reservation to add or update
     */
    public void upsert(Reservation reservation) {
        validator.validate(reservation);
        storage.put(reservation.getId(), reservation);
    }

    /**
     * Removes a reservation with a given id
     * @param id the id
     * throws RunTimeException if there is no reservation
     */

    public void remove (String id) {

        if(!storage.containsKey(id)) {
            throw new RuntimeException("There is no reservation with the given id.");
        }
        storage.remove(id);
    }

    public List<Reservation> getAll() {
        return new ArrayList<>(storage.values());
    }
}
