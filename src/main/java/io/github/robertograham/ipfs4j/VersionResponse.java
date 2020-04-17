package io.github.robertograham.ipfs4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
@JsonDeserialize(builder = VersionResponse.Builder.class)
@JsonPOJOBuilder(withPrefix = "")
public class VersionResponse {

  @JsonProperty("Commit")
  String commit;

  @JsonProperty("Golang")
  String golang;

  @JsonProperty("Repo")
  String repo;

  @JsonProperty("System")
  String system;

  @JsonProperty("Version")
  String version;
}
