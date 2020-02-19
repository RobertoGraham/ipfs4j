package io.github.robertograham.ipfs4j;

import java.io.File;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
public class AddRequest {

  File file;
}
