package io.github.robertograham.ipfs4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
@JsonDeserialize(builder = AddResponse.Builder.class)
@JsonPOJOBuilder(withPrefix = "")
public class AddResponse {

  @JsonProperty("Bytes")
  long bytes;

  @JsonProperty("Name")
  String name;

  @JsonProperty("Hash")
  String hash;

  @JsonProperty("Size")
  String size;
}
