package io.github.robertograham.ipfs4j;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class CommandsResourceImpl implements CommandsResource {

  @NonNull
  private final CommandsClient commandsClient;

  @Override
  public CommandsResponse submit(final CommandsRequest commandsRequest) {
    return commandsClient.commands(commandsRequest.getFlags());
  }
}
