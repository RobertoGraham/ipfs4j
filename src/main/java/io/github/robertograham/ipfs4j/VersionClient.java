package io.github.robertograham.ipfs4j;

import feign.Param;
import feign.RequestLine;

public interface VersionClient {

  @RequestLine("POST /api/v0/version?number={number}&commit={commit}&repo={repo}&all={all}")
  VersionResponse version(@Param("number") Boolean number, @Param("commit") Boolean commit,
      @Param("repo") Boolean repo, @Param("all") Boolean all);

  @RequestLine("POST /api/v0/version/deps")
  VersionDepsResponse deps();
}