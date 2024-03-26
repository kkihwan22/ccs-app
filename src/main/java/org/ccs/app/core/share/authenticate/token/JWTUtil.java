package org.ccs.app.core.share.authenticate.token;

import io.jsonwebtoken.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
public class JWTUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String issued(JWTType type, Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + type.getExpirationMs());

        return Jwts.builder()
                .setSubject(Long.toString(userId)) // 토큰 subject를 사용자 ID로 설정
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // 토큰 서명
                .compact();
    }

    public boolean verify(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            Date expiration = claimsJws.getBody().getExpiration();
            return new Date().before(expiration);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Object decode(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
