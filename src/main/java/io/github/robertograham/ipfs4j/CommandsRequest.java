package io.github.robertograham.ipfs4j;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
public class CommandsRequest {

  Boolean flags;
}
