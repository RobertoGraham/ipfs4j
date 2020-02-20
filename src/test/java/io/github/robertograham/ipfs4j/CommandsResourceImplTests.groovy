package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(CommandsResourceImpl)
class CommandsResourceImplTests extends Specification {

  private def commandsClient = Mock(CommandsClient)
  private def subject = new CommandsResourceImpl(commandsClient)

  def "commands resource implementation delegates to commands client"() {
    given: "an add request"
    final def commandsRequest = CommandsRequest.newBuilder()
        .flags(true)
        .build()

    and: "an expected commands response"
    final def expectedCommandsResponse = CommandsResponse.newBuilder()
        .build()

    when: "the commands resource is executed with the commands request"
    final def actualCommandsResponse = subject.submit(commandsRequest)

    then: "the commands client is executed with the correct arguments"
    1 * commandsClient.commands(commandsRequest.getFlags()) >> expectedCommandsResponse

    and: "the returned commands response matches the expected commands response"
    actualCommandsResponse == expectedCommandsResponse
  }
}
