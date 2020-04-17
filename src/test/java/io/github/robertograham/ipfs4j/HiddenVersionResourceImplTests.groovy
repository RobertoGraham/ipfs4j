package io.github.robertograham.ipfs4j

import spock.lang.Specification
import spock.lang.Subject

@Subject(HiddenVersionResourceImpl)
class HiddenVersionResourceImplTests extends Specification {

  private def versionClient = Mock(VersionClient)
  private def subject = new HiddenVersionResourceImpl(versionClient)

  def "version resource submit implementation delegates to version client"() {
    given: "a version request"
    final def versionRequest = VersionRequest.newBuilder()
        .number(true)
        .commit(true)
        .repo(true)
        .all(true)
        .build()

    and: "an expected version response"
    final def expectedVersionResponse = VersionResponse.newBuilder()
        .build()

    when: "the version resource is executed with the version request"
    final def actualVersionResponse = subject.submit(versionRequest)

    then: "the version client is executed with the correct arguments"
    1 * versionClient.version(versionRequest.getNumber(),
        versionRequest.getCommit(),
        versionRequest.getRepo(),
        versionRequest.getAll()) >> expectedVersionResponse

    and: "the returned version response matches the expected version response"
    actualVersionResponse == expectedVersionResponse
  }

  def "version resource deps implementation delegates to version client"() {
    given: "an expected version deps response"
    final def expectedVersionDepsResponse = VersionDepsResponse.newBuilder()
        .build()

    when: "the version resource deps method is called"
    final def actualVersionDepsResponse = subject.deps()

    then: "the version client deps method is called"
    1 * versionClient.deps() >> expectedVersionDepsResponse

    and: "the returned version deps response matches the expected version deps response"
    actualVersionDepsResponse == expectedVersionDepsResponse
  }
}
