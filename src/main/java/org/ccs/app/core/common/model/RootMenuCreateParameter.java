package org.ccs.app.core.common.model;

import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.Menu;
import org.ccs.app.core.share.model.EntityBuildable;

import java.util.Objects;

@Getter @ToString
public class RootMenuCreateParameter implements EntityBuildable<Menu> {
    private String name;
    private String target;

    public RootMenuCreateParameter(String name, String target) {
        this.name = Objects.requireNonNull(name);
        this.target = target;
    }

    @Override
    public Menu toEntity() {
        return Menu.builder()
                .target(target)
                .name(name)
                .build();
    }
}
