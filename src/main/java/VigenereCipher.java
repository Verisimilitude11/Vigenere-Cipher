import java.util.*;

public class VigenereCipher {
  CaesarCipher[] ciphers;

  public VigenereCipher(ArrayList<Integer> key) {
    for (Integer k : key) {
      if (k == null || k < 0 || k > 25) {
        throw new IllegalArgumentException(
            "Key must contain only valid integers between 0 and 25.");
      }
    }
    ciphers = new CaesarCipher[key.size()];
    for (int i = 0; i < key.size(); i++) {
      ciphers[i] = new CaesarCipher(key.get(i));
    }
  }

  public String encrypt(String input) {
    StringBuilder answer = new StringBuilder();
    int i = 0;
    for (char c : input.toCharArray()) {
      int cipherIndex = i % ciphers.length;
      CaesarCipher thisCipher = ciphers[cipherIndex];
      answer.append(thisCipher.encryptLetter(c));
      i++;
    }
    return answer.toString();
  }

  public String decrypt(String input) {
    StringBuilder answer = new StringBuilder();
    int i = 0;
    for (char c : input.toCharArray()) {
      int cipherIndex = i % ciphers.length;
      CaesarCipher thisCipher = ciphers[cipherIndex];
      answer.append(thisCipher.decryptLetter(c));
      i++;
    }
    return answer.toString();
  }

  public String toString() {
    return Arrays.toString(ciphers);
  }
}
