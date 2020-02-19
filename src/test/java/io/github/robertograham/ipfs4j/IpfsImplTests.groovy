package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(IpfsImpl)
class IpfsImplTests extends Specification {

  private def addResource = Mock(AddResource)
  private def subject = new IpfsImpl(addResource)

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
}
