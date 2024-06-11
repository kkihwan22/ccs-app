package org.ccs.app.entrypoints.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.ccs.app.core.common.domain.ClientProperty;

import java.time.LocalDateTime;

public class ClientPropertyDTO {
    public record CreateRequest(
            @NotBlank String key,
            @NotBlank String propertyValue,
            @NotNull Boolean usingIos,
            @NotNull Boolean usingAos,
            @NotNull Boolean usingWeb) {}

    public record UpdateRequest(
            @NotBlank String propertyValue,
            @NotNull Boolean usingIos,
            @NotNull Boolean usingAos,
            @NotNull Boolean usingWeb) {}

    public record Response(
            Long id,
            String key,
            Boolean usingIos,
            Boolean usingAos,
            Boolean usingWeb,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        public static Response of(ClientProperty property) {
            return new Response(
                    property.getId(),
                    property.getKey(),
                    property.getUsingIos(),
                    property.getUsingAos(),
                    property.getUsingWeb(),
                    property.getCreatedDateTime(),
                    property.getUpdatedDateTime());
        }
    }
}