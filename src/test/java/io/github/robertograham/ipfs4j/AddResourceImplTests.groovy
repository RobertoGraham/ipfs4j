package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(AddResourceImpl)
class AddResourceImplTests extends Specification {

  private def addClient = Mock(AddClient)
  private def subject = new AddResourceImpl(addClient)

  def "add resource implementation delegates to add client"() {
    given: "an add request"
    final def addRequest = AddRequest.newBuilder()
        .file(new File(""))
        .build()

    and: "an add expected response"
    final def expectedAddResponse = AddResponse.newBuilder()
        .build()

    when: "the add resource is executed with the add request"
    final def actualAddResponse = subject.submit(addRequest)

    then: "the add client is executed with the correct arguments"
    1 * addClient.add(addRequest.getFile()) >> expectedAddResponse

    and: "the returned add response matches the expected add response"
    actualAddResponse == expectedAddResponse
  }
}
