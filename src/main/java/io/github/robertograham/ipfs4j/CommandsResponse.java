package io.github.robertograham.ipfs4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
@JsonDeserialize(builder = CommandsResponse.Builder.class)
@JsonPOJOBuilder(withPrefix = "")
public class CommandsResponse {

  @JsonProperty("Name")
  String name;

  @JsonProperty("Options")
  List<Option> options;

  @JsonProperty("Subcommands")
  List<CommandsResponse> subcommands;

  @Value
  @lombok.Builder(builderMethodName = "newBuilder", builderClassName = "Builder")
  @JsonDeserialize(builder = Option.Builder.class)
  @JsonPOJOBuilder(withPrefix = "")
  public static class Option {

    @JsonProperty("Names")
    List<String> names;
  }
}
