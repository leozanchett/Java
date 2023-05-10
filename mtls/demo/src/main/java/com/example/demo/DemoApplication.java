package com.example.demo;

//import com.nimbusds.jose.JOSEException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/mtls")
	public String mTLS(HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String acessSignature = request.getHeader("access-signature");
		//String publicKeyStr = "{ \"public\": {\"crv\": \"P-521\",\"ext\": true,\"key_ops\": [\"verify\"],\"kty\": \"EC\",\"x\": \"AbFCmkni9pvGC1o9uAOhPGfgveJrk9Y4NgtNHLyb6FtgwgMHXSMZPoFLsA03neFa1i2-36GnT_zTydSbyMZMS9Py\",\"y\": \"AXR3qFe3LBJvY7pXrBw3bQdUP6ozsHZqa7VIFUVGnY5a7iakifA6QeGmtNbcGI9y32nJzHorDcYKLQ38BUbWd9JM\"}}";
		String publicKeyStr = "{ \"crv\": \"P-521\",\"ext\": true,\"key_ops\": [\"verify\"],\"kty\": \"EC\",\"x\": \"AbFCmkni9pvGC1o9uAOhPGfgveJrk9Y4NgtNHLyb6FtgwgMHXSMZPoFLsA03neFa1i2-36GnT_zTydSbyMZMS9Py\",\"y\": \"AXR3qFe3LBJvY7pXrBw3bQdUP6ozsHZqa7VIFUVGnY5a7iakifA6QeGmtNbcGI9y32nJzHorDcYKLQ38BUbWd9JM\"}";
		byte[] publicKeyBytes = Base64.getUrlDecoder().decode(publicKeyStr);
//		JsonWebKey jwk = JsonWebKey.Factory.newJwk(publicKeyStr);
//		ECKey ecKey = (ECKey) jwk.getKey();
//		ECPublicKey publicKey = (ECPublicKey) ecKey.toPublicKey();
//
//
//
//		byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
//		ECPublicKey publicKey = (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(publicKeyBytes));

//		JwtDecoder jwtDecoder = NimbusJwtDecoder.withPublicKey((RSAPublicKey) publicKey).build();
//		System.out.println(jwtDecoder.decode(acessSignature));
		return  "Hello World";
	}
}