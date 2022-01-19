package kr.co.fpj.Encryption;
	import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

import javax.crypto.Cipher;

import org.springframework.stereotype.Component;

	@Component
	public class LoginEncryption {
		
		HashMap<String, Object> keys = new HashMap<>();
		
		public HashMap<String, Object> getKey() throws NoSuchAlgorithmException, InvalidKeySpecException{
			
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(1024);
			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec
					(publicKey, RSAPublicKeySpec.class);
			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			keys.put("privateKey", privateKey);
			keys.put("publicKey", publicKey);
			keys.put("publicKeyModulus", publicKeyModulus);
			keys.put("publicKeyExponent", publicKeyExponent);
			return keys;
		}
		
		public void clearKeyMap() {
			this.keys.clear();
		}
		
		public String decryptRsa(PrivateKey privateKey, String securedValue) {
			 String decryptedValue = "";
			 try{
				Cipher cipher = Cipher.getInstance("RSA");
			   /**
				* 암호화 된 값은 byte 배열이다.
				* 이를 문자열 폼으로 전송하기 위해 16진 문자열(hex)로 변경한다. 
				* 서버측에서도 값을 받을 때 hex 문자열을 받아서 이를 다시 byte 배열로 바꾼 뒤에 복호화 과정을 수행한다.
				*/
				byte[] encryptedBytes = hexToByteArray(securedValue);
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
				decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
			 }catch(Exception e)
			 {
				 System.out.println(("decryptRsa Exception Error : "+e.getMessage()));
			 }
				return decryptedValue;
				
		}
		 public static byte[] hexToByteArray(String hex) {
			if (hex == null || hex.length() % 2 != 0) {
				return new byte[]{};
			}
		 
			byte[] bytes = new byte[hex.length() / 2];
			for (int i = 0; i < hex.length(); i += 2) {
				byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
				bytes[(int) Math.floor(i / 2)] = value;
			}
			return bytes;
		}

		
	}

