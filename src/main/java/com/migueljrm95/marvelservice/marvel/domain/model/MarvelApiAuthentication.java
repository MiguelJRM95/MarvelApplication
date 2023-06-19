package com.migueljrm95.marvelservice.marvel.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Component
public class MarvelApiAuthentication {
    @Value("${marvelService.marvelExternalApi.publicKey}")
    private String publicKey;

    @Value("${marvelService.marvelExternalApi.privateKey}")
    private String privateKey;

    private final String ts = String.valueOf(System.currentTimeMillis());;

    public String generateHash(){
        return DigestUtils.md5Hex(ts + privateKey + publicKey);
    }
}
