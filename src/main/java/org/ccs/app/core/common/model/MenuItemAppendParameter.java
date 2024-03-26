package org.ccs.app.core.common.model;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.Menu;
import org.ccs.app.core.share.model.EntityBuildable;

@Getter @ToString
public class MenuItemAppendParameter implements EntityBuildable<Menu> {
    private Menu parent;
    private String name;

    @Override
    public Menu toEntity() {
        return Menu.builder()
                .parentId(parent.getParentId())
                .build();
    }
}
