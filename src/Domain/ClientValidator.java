package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator {

    public void validate (Client client) {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(client.getDateOfBirth());

        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct form!");
        }

        try {
            format.parse (client.getDateOfRegistration());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct form!");
        }
    }
}
