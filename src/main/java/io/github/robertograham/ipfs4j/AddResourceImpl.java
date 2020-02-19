package io.github.robertograham.ipfs4j;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class AddResourceImpl implements AddResource {

  @NonNull
  private final AddClient addClient;

  @Override
  public AddResponse submit(final AddRequest addRequest) {
    return addClient.add(addRequest.getFile());
  }
}
