package io.github.robertograham.ipfs4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
@JsonDeserialize(builder = VersionDepsResponse.Builder.class)
@JsonPOJOBuilder(withPrefix = "")
public class VersionDepsResponse {

  @JsonProperty("Path")
  String path;

  @JsonProperty("ReplacedBy")
  String replacedBy;

  @JsonProperty("Sum")
  String sum;

  @JsonProperty("Version")
  String version;
}
