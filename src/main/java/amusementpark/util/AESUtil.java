package amusementpark.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.03.28 0:14
 */
public class AESUtil {
  private static final String KEY_ALGORITHM = "AES";
  private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

  // appKey,每隔一段时间进行替换即可
  // 可以设计成保存到数据库中或者那里，然后进行每隔一段时间进行替换，增加保密的安全性
  private static final String APP_KEY = "vdfgds-4545-gdgvdh-45grt455-gedrg34634";

  /**
   * AES 加密操作
   *
   * @param content 待加密内容
   * @return 返回Base64转码后的加密数据
   */
  public static String encrypt(String content) {
    try {
      // 创建密码器
      Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

      byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);

      // 初始化为加密模式的密码器
      cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(APP_KEY));

      // 加密
      byte[] result = cipher.doFinal(byteContent);

      // 通过Base64转码返回
      return Base64.encodeBase64String(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  /**
   * AES 解密操作
   *
   * @param content 待解密内容
   */
  public static String decrypt(String content) {

    try {
      // 实例化
      Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

      // 使用密钥初始化，设置为解密模式
      cipher.init(Cipher.DECRYPT_MODE, getSecretKey(APP_KEY));

      // 执行操作
      byte[] bycontent = Base64.decodeBase64(content);
      byte[] result = cipher.doFinal(bycontent);

      return new String(result, StandardCharsets.UTF_8);
    } catch (Exception ex) {
      Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
    }

    return null;
  }
  /** 生成加密秘钥 */
  private static SecretKeySpec getSecretKey(String appKey) {
    // 返回生成指定算法密钥生成器的 KeyGenerator 对象
    KeyGenerator kg = null;

    try {
      kg = KeyGenerator.getInstance(KEY_ALGORITHM);

      // SecureRandom 实现随操作系统本身的內部状态，除非调用方在调用 getInstance 方法之后又调用了 setSeed 方法；该实现在
      // windows 上每次生成的 key 都相同，但是在 solaris 或部分 linux 系统上则不同。解决在linux操作系统中加密产生的字符串不一致问题。
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

      secureRandom.setSeed(appKey.getBytes());

      // AES 要求密钥长度为 128
      kg.init(128, secureRandom);

      // 生成一个密钥
      SecretKey secretKey = kg.generateKey();

      // 转换为AES专用密钥
      return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace();
    }

    return null;
  }
}
