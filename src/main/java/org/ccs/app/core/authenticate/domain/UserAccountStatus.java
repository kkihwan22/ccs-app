package org.ccs.app.core.authenticate.domain;

public enum UserAccountStatus {
    UNVERIFIED,
    ENABLED, /* 활성화 */
    LOCKED,  /* 패스워드 특정 횟수 위반 */
    BLOCKED, /* 운영자에 의해 차단 */
    ;
}
