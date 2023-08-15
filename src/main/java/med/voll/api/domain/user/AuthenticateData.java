package med.voll.api.domain.user;

import org.springframework.http.ResponseEntity;

public record AuthenticateData(String login, String password) {

}
