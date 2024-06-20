package org.ccs.app.core.share.support.generator;

import java.util.UUID;

public class UUIDGenerator {

    public static String withoutBar() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
