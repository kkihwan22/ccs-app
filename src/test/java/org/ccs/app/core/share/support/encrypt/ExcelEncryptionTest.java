package org.ccs.app.core.share.support.encrypt;

import org.junit.jupiter.api.Test;

import java.io.File;

class ExcelEncryptionTest {

    String fileName = "/Users/keehwan/workspace/tmp/file/20240605.xlsx";

    @Test
    void encrypt() {
        ExcelEncryption encryption = new ExcelEncryption(new File(fileName));
        try {
            encryption.encrypt();
        } catch (Exception e) {

        }
    }
}