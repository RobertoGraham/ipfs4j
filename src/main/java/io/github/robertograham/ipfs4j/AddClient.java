package io.github.robertograham.ipfs4j;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.io.File;

interface AddClient {

  @RequestLine("POST /api/v0/add")
  @Headers("Content-Type: multipart/form-data")
  AddResponse add(@Param("file") File file);
}