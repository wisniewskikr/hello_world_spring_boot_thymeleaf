package pl.kwi.springboot.services;

import java.util.Base64;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SEPARATOR = ":";

    public String generateTokenForEmail(String email) {
        return encodeBase64(UUID.randomUUID().toString() + SEPARATOR + email);
    }

    public String decodeEmailFromToken(String token) {
        return StringUtils.substringAfter(decodeBase64(token), SEPARATOR);
    }

    private static String encodeBase64(String toEncode) {
        return Base64.getUrlEncoder().encodeToString(toEncode.getBytes());
    }

    private static String decodeBase64(String toDecode) {
        return new String(Base64.getUrlDecoder().decode(toDecode));
    }

}