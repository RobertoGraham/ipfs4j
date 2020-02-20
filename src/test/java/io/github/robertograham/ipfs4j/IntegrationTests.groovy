package io.github.robertograham.ipfs4j


import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
class IntegrationTests extends Specification {

  private Ipfs ipfs

  @Shared
  private GenericContainer ipfsContainer = new GenericContainer("ipfs/go-ipfs:latest")
      .withExposedPorts(5001)
      .waitingFor(Wait.forLogMessage("Gateway \\(readonly\\) server listening on /ip4/0\\.0\\.0\\.0/tcp/8080\\n", 1))

  def setup() {
    ipfs = Ipfs.newIpfs("http://${ipfsContainer.containerIpAddress}:${ipfsContainer.firstMappedPort}")
  }

  def "add file to IPFS"() {
    given: "a new text file"
    final def file = new File("test.txt")

    and: "content is written to it"
    file.write("test")

    when: "the file is added to IPFS"
    final def addResponse = ipfs.add(AddRequest.newBuilder()
        .file(file)
        .build())

    then: "the correct name is present in the add response"
    addResponse.name == "test.txt"

    cleanup:
    file.delete()
  }

  def "list available IPFS commands"() {
    when: "a commands request is submitted"
    final def commandsResponse = ipfs.commands(CommandsRequest.newBuilder()
        .flags(true)
        .build())

    then: "the root command has the correct name"
    commandsResponse.name == "ipfs"
  }
}
