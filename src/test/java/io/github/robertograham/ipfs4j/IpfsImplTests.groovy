package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(IpfsImpl)
class IpfsImplTests extends Specification {

  private def addResource = Mock(AddResource)
  private def commandsResource = Mock(CommandsResource)
  private def hiddenVersionResource = Mock(HiddenVersionResource)
  private def subject = new IpfsImpl(addResource, commandsResource, hiddenVersionResource)

  def "add a file to IPFS"() {
    given: "an add request"
    final def addRequest = AddRequest.newBuilder()
        .build()

    and: "an add response"
    final def expectedAddResponse = AddResponse.newBuilder()
        .build()

    and: "the add resource returns the add response when executed"
    addResource.submit(addRequest) >> expectedAddResponse

    expect: "the returned add response is as expected"
    subject.add(addRequest) == expectedAddResponse
  }

  def "list IPFS commands"() {
    given: "a commands request"
    final def commandsRequest = CommandsRequest.newBuilder()
        .build()

    and: "a commands response"
    final def expectedCommandsResponse = CommandsResponse.newBuilder()
        .build()

    and: "the commands resource returns the commands response when executed"
    commandsResource.submit(commandsRequest) >> expectedCommandsResponse

    expect: "the returned commands response is as expected"
    subject.commands(commandsRequest) == expectedCommandsResponse
  }

  def "get version resource"() {
    expect: "the returned version resource is as expected"
    subject.version() == hiddenVersionResource
  }

  def "get IPFS version"() {
    given: "a version request"
    final def versionRequest = VersionRequest.newBuilder()
        .build()

    and: "a version response"
    final def expectedVersionResponse = VersionResponse.newBuilder()
        .build()

    and: "the hidden version resource returns the version response when executed"
    hiddenVersionResource.submit(versionRequest) >> expectedVersionResponse

    expect: "the returned version response is as expected"
    subject.version(versionRequest) == expectedVersionResponse
  }
}
