package org.ccs.app.core.share.code;

public enum LangCode {

    KO,
    EN,
    JA,
    ;

    private static final AbstractEnumWithLookupMap<LangCode> lookup = new AbstractEnumWithLookupMap<>(LangCode.class) {};

    public static LangCode get(String name) {
        return lookup.get(name);
    }

}
