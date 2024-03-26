package org.ccs.app.entrypoints.admin.model;

import jakarta.validation.constraints.NotBlank;

public record AdminMenuCreateRequest(@NotBlank String name, String target) {

}
