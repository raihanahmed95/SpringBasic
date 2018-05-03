package raihan.bs23.encryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Created by Raihan on 6/21/2017.
 */
@Component
public class TextEncryptor {

    @Autowired
    private StandardPBEStringEncryptor pbeStringEncryptor;

    @Value("${key.encryptionKey}")
    private String encryptionKey;

    public String encrypt(String textToEncrypt) {
        try {
            if (!pbeStringEncryptor.isInitialized()) {
                this.initEncryptor();
            }

            String encryptedPassword = pbeStringEncryptor.encrypt(textToEncrypt);

            return encryptedPassword;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public String dycrypt(String textToDycrypt) {
        try {
            if (!pbeStringEncryptor.isInitialized()) {
                this.initEncryptor();
            }
            return pbeStringEncryptor.decrypt(textToDycrypt);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

    }

    public boolean isEqual(String encryptedText, String plainText) {
        try {
            if (!pbeStringEncryptor.isInitialized()) {
                this.initEncryptor();
            }
            return this.dycrypt(encryptedText).equals(plainText);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void initEncryptor() {
        if (!pbeStringEncryptor.isInitialized()) {
            pbeStringEncryptor.setPassword(encryptionKey);
            pbeStringEncryptor.setStringOutputType("hexadecimal");
        }
    }
}
