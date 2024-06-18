package org.ccs.app.entrypoints.authenticate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.ccs.app.core.authenticate.model.SignupParameter;

public class AuthenticationDTO {

    public record SignupRequest(
            @NotBlank @Email String email,
            @NotBlank @Size(min = 8, max = 64) String password
    ) {
        public SignupParameter to() {
            return new SignupParameter(email, password);
        }
    }
}
