package com.fx.sharingbikes.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    public static final String KEY_ALGORITHM = "AES";
    public static final String KEY_ALGORITHM_MODE = "AES/CBC/PKCS5Padding";

    public static String encrypt(String data, String key) {
        try {
            SecretKeySpec spec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, spec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] bs = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64Util.encode(bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String data, String key) {
        try {
            SecretKeySpec spec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_MODE);
            cipher.init(Cipher.DECRYPT_MODE, spec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] originBytes = Base64Util.decode(data);
            byte[] result = cipher.doFinal(originBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        /**AES加密数据**/
//        String key = "123456789abcdfgt";
//        String dataToEn = "{'mobile':'13009715105','code':'6666','platform':'android'}";
//        String enResult = encrypt(dataToEn, key);
//        System.out.println(enResult);
//        /**RSA 加密AES的密钥**/
//        byte[] enKey = RSAUtil.encryptByPublicKey(key.getBytes("UTF-8"), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5boVUQ95FTf3WUbf4ApFt 6RXY9dAgBDrEqxFoEhsYZSWRmsu7w8NKjGS0nTMUKTHl9Lm3Vjc2IOrohnK6 g2b5CSGFgBU453KF3dHYWSB6+lcugsbby71OU0GsQZ96n0FlJRaIzi4t+2RH PnOq/mk/KVWjpv4Rl7qbTdgPvaDMqwIDAQAB");
//        String baseKey = Base64Util.encode(enKey);
//        System.out.println(baseKey);
//
//        byte[] de = Base64Util.decode(baseKey);
//        byte[] deKeyResult = RSAUtil.decryptByPrivateKey(de);
//        System.out.println(new String(deKeyResult,"UTF-8"));
//        String deResult = decrypt(enResult,key);
//        System.out.println(deResult);
//    }
}
