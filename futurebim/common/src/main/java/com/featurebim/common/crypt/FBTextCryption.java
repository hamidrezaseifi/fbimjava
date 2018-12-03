package com.featurebim.common.crypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class FBTextCryption {

  private static String ENCRYPTION_KEY = "HAPUTAFB";

  public static byte[] encrypt(final String strClearText) throws Exception {
    
    try {
      final SecureRandom sr = new SecureRandom();
      final DESKeySpec dks = new DESKeySpec(ENCRYPTION_KEY.getBytes());
      final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      final SecretKey key = keyFactory.generateSecret(dks);
      final Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.ENCRYPT_MODE, key, sr);
      return cipher.doFinal(strClearText.getBytes());
      
    }
    catch (final Exception e) {
      e.printStackTrace();
      throw new Exception(e);
    }
    
  }
  
  public static String decrypt(final byte[] bytesEncrypted) throws Exception {
    
    try {
      final SecureRandom sr = new SecureRandom();
      final DESKeySpec dks = new DESKeySpec(ENCRYPTION_KEY.getBytes());
      final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      final SecretKey key = keyFactory.generateSecret(dks);
      final Cipher cipher = Cipher.getInstance("DES");
      cipher.init(Cipher.DECRYPT_MODE, key, sr);
      final byte[] decryptedData = cipher.doFinal(bytesEncrypted);
      return new String(decryptedData);
      
    }
    catch (final Exception e) {
      e.printStackTrace();
      throw new Exception(e);
    }
    
  }

}
