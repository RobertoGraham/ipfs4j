package io.github.robertograham.ipfs4j;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
public class VersionRequest {

  Boolean number;

  Boolean commit;

  Boolean repo;

  Boolean all;
}
