package org.ccs.app.entrypoints.user.controller;

import lombok.RequiredArgsConstructor;
import org.ccs.app.entrypoints.share.controller.BaseRestController;
import org.ccs.app.entrypoints.user.model.CreateUserRequest;
import org.ccs.app.entrypoints.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRestController implements BaseRestController {

    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public void createUser(@RequestBody CreateUserRequest request, BindingResult bindingResult) {
        hasError(bindingResult);

    }

    /**
     * 엑셀을 이용하여 대량으로 등록 or 수정한다.
     */
    @PutMapping("/api/v1/bulk-users")
    public void bulkUsers() {

    }
}
