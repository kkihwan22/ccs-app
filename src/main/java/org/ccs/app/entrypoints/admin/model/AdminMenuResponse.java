package org.ccs.app.entrypoints.admin.model;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.Menu;

@Getter @ToString
public class AdminMenuResponse {
    private final Long id;
    private final Long parentId;
    private final String name;
    private final Integer depth;
    private final Integer itemOrder;
    private final Boolean disabled;

    public AdminMenuResponse(Menu menu) {
        this.id = menu.getId();
        this.parentId = menu.getParentId();
        this.name = menu.getName();
        this.depth = menu.getDepth();
        this.itemOrder = menu.getItemOrder();
        this.disabled = menu.getDisabled();
    }
}
