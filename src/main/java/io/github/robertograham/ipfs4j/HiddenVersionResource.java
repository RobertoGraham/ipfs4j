package io.github.robertograham.ipfs4j;

interface HiddenVersionResource extends VersionResource {

  VersionResponse submit(VersionRequest versionRequest);
}
