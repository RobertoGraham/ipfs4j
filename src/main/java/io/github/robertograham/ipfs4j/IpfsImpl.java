package io.github.robertograham.ipfs4j;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class IpfsImpl implements Ipfs {

  @NonNull
  private final AddResource addResource;
  @NonNull
  private final CommandsResource commandsResource;

  @Override
  public AddResponse add(final AddRequest addRequest) {
    return addResource.submit(addRequest);
  }

  @Override
  public CommandsResponse commands(final CommandsRequest commandsRequest) {
    return commandsResource.submit(commandsRequest);
  }
}
