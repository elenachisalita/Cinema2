package Repository;

import Domain.Movie;
import Domain.MovieValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {

    private Map<String, Movie> storage = new HashMap<>();
    private MovieValidator validator;

    public MovieRepository (MovieValidator validator) {
        this.validator = validator;
    }

    public Movie findById (String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a movie if it already exists
     * @param movie the movie to add or update
     */

    public void upsert (Movie movie) {
        validator.validate(movie);
        storage.put(movie.getId(), movie);
    }

    /**
     * removes a movie with a given id
     * @param id the id
     * throws RunTimeException if there is no movie with the given id
     */
    public void remove (String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no movie with given id to remove! ");
        }

        storage.remove(id);
    }

    public List<Movie> getAll() {

        return new ArrayList<>(storage.values());
    }
}
