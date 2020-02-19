package io.github.robertograham.ipfs4j;

import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;

public interface Ipfs {

  static Ipfs newIpfs(final String ipfsUrl) {
    return new IpfsImpl(new AddResourceImpl(Feign.builder()
        .encoder(new FormEncoder())
        .decoder(new JacksonDecoder())
        .target(AddClient.class, ipfsUrl)));
  }

  AddResponse add(AddRequest addRequest);
}
