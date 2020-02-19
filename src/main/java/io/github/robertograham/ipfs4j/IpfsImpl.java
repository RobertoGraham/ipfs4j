package io.github.robertograham.ipfs4j;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class IpfsImpl implements Ipfs {

  @NonNull
  private final AddResource addResource;

  @Override
  public AddResponse add(final AddRequest addRequest) {
    return addResource.submit(addRequest);
  }
}
