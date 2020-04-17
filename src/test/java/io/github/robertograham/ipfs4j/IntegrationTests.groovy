package io.github.robertograham.ipfs4j

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

@Subject(Ipfs)
@Testcontainers
class IntegrationTests extends Specification {

  private Ipfs subject

  @Shared
  private GenericContainer ipfsContainer = new GenericContainer("ipfs/go-ipfs:latest")
      .withExposedPorts(5001)
      .waitingFor(Wait.forLogMessage("Gateway \\(readonly\\) server listening on /ip4/0\\.0\\.0\\.0/tcp/8080\\n", 1))

  def setup() {
    subject = Ipfs.newIpfs("http://${ipfsContainer.containerIpAddress}:${ipfsContainer.firstMappedPort}")
  }

  def "add file to IPFS"() {
    given: "a new text file"
    final def file = new File("test.txt") << "test"

    expect: "the correct name to be present in the add response"
    verifyAll(subject.add(AddRequest.newBuilder()
        .file(file)
        .build())) {
      name == 'test.txt'
    }

    cleanup:
    file.delete()
  }

  def "list available IPFS commands"() {
    expect: "the correct name to be present in the commands response"
    verifyAll(subject.commands(CommandsRequest.newBuilder()
        .flags(true)
        .build())) {
      name == "ipfs"
    }
  }
}
