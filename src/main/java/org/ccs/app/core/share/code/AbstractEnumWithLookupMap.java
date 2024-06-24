package org.ccs.app.core.share.code;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractEnumWithLookupMap<E extends Enum<E>> {

    private final Map<String, E> lookupMap;

    protected AbstractEnumWithLookupMap(Class<E> enumType) {
        this.lookupMap = Stream.of(enumType.getEnumConstants())
                .collect(Collectors.toMap(Enum::name, Function.identity()));
    }

    public E get(String name) {
        if (Objects.isNull(name))
            return null;
        return lookupMap.get(name.toUpperCase());
    }
}
