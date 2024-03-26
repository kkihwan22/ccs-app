package org.ccs.app.entrypoints.share.model;

/**
 * @param context 는 에러가 발생한 위치에 대한 정보를 담는다.
 * @param reason 는 에러가 발생한 원인에 대한 정보를 담는다.
 */

public record ErrorBindings<K, V>(K context, V reason) {
}
