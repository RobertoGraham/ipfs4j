package io.github.robertograham.ipfs4j;

import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;

public interface Ipfs {

  static Ipfs newIpfs(final String ipfsUrl) {
    final var jacksonDecoder = new JacksonDecoder();
    return new IpfsImpl(new AddResourceImpl(Feign.builder()
        .encoder(new FormEncoder())
        .decoder(jacksonDecoder)
        .target(AddClient.class, ipfsUrl)),
        new CommandsResourceImpl(Feign.builder()
            .decoder(jacksonDecoder)
            .target(CommandsClient.class, ipfsUrl)),
        new HiddenVersionResourceImpl(Feign.builder()
            .decoder(jacksonDecoder)
            .target(VersionClient.class, ipfsUrl)));
  }

  AddResponse add(AddRequest addRequest);

  CommandsResponse commands(CommandsRequest commandsRequest);

  VersionResponse version(VersionRequest versionRequest);

  VersionResource version();
}
