package org.ccs.app.entrypoints.authenticate.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.authenticate.model.AuthenticationDTO.SignupRequest;
import org.ccs.app.entrypoints.authenticate.service.AuthenticationService;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.share.controller.ResponseFactory;
import org.ccs.app.entrypoints.share.model.ContentBody;
import org.ccs.app.entrypoints.share.model.SuccessBody;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthenticationRestController implements BaseRestController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ContentBody<SuccessBody<String>> signup(@Valid @RequestBody SignupRequest request, BindingResult bindingResult) {
        hasError(bindingResult);
        authenticationService.signup(request);
        return ResponseFactory.success("success");
    }

    @GetMapping("/auth/verify/email")
    public void verifyEmail() {

    }

    @PutMapping("/auth/reset/password")
    public void resetPassword() {

    }
}
