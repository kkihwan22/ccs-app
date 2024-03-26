package org.ccs.app.entrypoints.common.model;

import jakarta.validation.constraints.NotBlank;

public record PreSignedGenerateRequest(
        @NotBlank String objectKey) {}

