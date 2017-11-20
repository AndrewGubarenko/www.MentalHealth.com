package com.AndriiGubarenko.mentalHealth.security;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenManager {
	private String privateKey;
	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

	public TokenManager(String privateKey) {
		this.privateKey = privateKey;
	}

	public String createToken(TokenPayload payload) {
		JwtBuilder builder = Jwts.builder().setId(payload.getUserId().toString())
                .setIssuedAt(payload.getCreatedTime())
                .setSubject(payload.getLogin())
                .signWith(signatureAlgorithm, createSign());
		return builder.compact();
	}
	
	private Key createSign() {
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(privateKey);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}

	public boolean verifyToken(String token) {
		TokenPayload payload = extractPayload(token);
		String trustedToken = createToken(payload);
		return token.equals(trustedToken);
	}

	public TokenPayload extractPayload(String token) {
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
			       .parseClaimsJws(token).getBody();
		TokenPayload payload = new TokenPayload(Long.valueOf(claims.getId()), claims.getSubject(), claims.getIssuedAt());
		
		return payload;
	}
}
