package io.github.robertograham.ipfs4j;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
final class HiddenVersionResourceImpl implements HiddenVersionResource {

  @NonNull
  private final VersionClient versionClient;

  @Override
  public VersionResponse submit(final VersionRequest versionRequest) {
    return versionClient
        .version(versionRequest.getNumber(), versionRequest.getCommit(), versionRequest.getRepo(),
            versionRequest.getAll());
  }

  @Override
  public VersionDepsResponse deps() {
    return versionClient.deps();
  }
}
