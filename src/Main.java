import Domain.MovieValidator;
import Domain.Client;
import Domain.ClientValidator;
import Domain.MovieValidator;
import Domain.ReservationValidator;
import Repository.MovieRepository;
import Repository.ClientRepository;
import Repository.ReservationRepository;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        MovieValidator movieValidator = new MovieValidator();
        ClientValidator clientValidator = new ClientValidator();
        ReservationValidator reservationValidator = new ReservationValidator();

        MovieRepository movieRepository = new MovieRepository(movieValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        ClientService clientService = new ClientService(clientRepository);
        ReservationService reservationService = new ReservationService(reservationRepository);

        Console console = new Console(movieService, clientService, reservationService);
        console.run();
    }
}