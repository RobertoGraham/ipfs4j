package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(IpfsImpl)
class IpfsImplTests extends Specification {

  private def addResource = Mock(AddResource)
  private def commandsResource = Mock(CommandsResource)
  private def subject = new IpfsImpl(addResource, commandsResource)

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
}
