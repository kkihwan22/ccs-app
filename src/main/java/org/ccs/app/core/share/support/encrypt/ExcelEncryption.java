package org.ccs.app.core.share.support.encrypt;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class ExcelEncryption {
    private static final String PASSWORD = "1234";
    private final File file;

    public ExcelEncryption(File file) {
        this.file = file;
    }

    public void encrypt() throws IOException, InvalidFormatException, GeneralSecurityException {
        try (
                POIFSFileSystem fs = new POIFSFileSystem();
                OPCPackage opc = OPCPackage.open(this.file);
                FileOutputStream fos = new FileOutputStream(this.file, false)
        ) {

            Encryptor encryptor = createEncryptor();
            opc.save(encryptor.getDataStream(fs));
            fs.writeFilesystem(fos);
        }
    }

    private Encryptor createEncryptor() throws GeneralSecurityException {
        EncryptionInfo encryptionInfo = new EncryptionInfo(EncryptionMode.agile);
        Encryptor encryptor = encryptionInfo.getEncryptor();
        encryptor.confirmPassword(PASSWORD); // 비밀번호 설정
        return encryptor;
    }
}
