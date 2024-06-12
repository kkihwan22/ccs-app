package org.ccs.app.entrypoints.common.model;

import jakarta.validation.constraints.NotBlank;

public class FileDTO {

    public record PreSignedGenerateRequest(@NotBlank String objectKey) {}

    public record PreSignedResponse(String url, Long expirationTime) {}
}
