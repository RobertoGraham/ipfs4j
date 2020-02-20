package io.github.robertograham.ipfs4j;

public interface CommandsResource {

  CommandsResponse submit(CommandsRequest commandsRequest);
}