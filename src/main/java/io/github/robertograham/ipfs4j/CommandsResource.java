package io.github.robertograham.ipfs4j;

interface CommandsResource {

  CommandsResponse submit(CommandsRequest commandsRequest);
}