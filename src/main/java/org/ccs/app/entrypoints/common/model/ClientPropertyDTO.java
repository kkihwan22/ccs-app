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
                @NotNull Boolean usingWeb
        ) {}

        public record DefaultResponse(
                Long id,
                String key,
                Boolean usingIos,
                Boolean usingAos,
                Boolean usingWeb,
                LocalDateTime createdAt,
                LocalDateTime updatedAt
        ) {
                public static DefaultResponse of(Long id) {
                        return new DefaultResponse(id, null, null, null, null, null, null);
                }
                
                public static DefaultResponse of(ClientProperty property) {
                        return new DefaultResponse(
                                property.getId(),
                                property.getKey(),
                                property.getUsingIos(),
                                property.getUsingAos(),
                                property.getUsingWeb(),
                                property.getCreatedDateTime(),
                                property.getUpdatedDateTime()
                        );
                }
        }
}