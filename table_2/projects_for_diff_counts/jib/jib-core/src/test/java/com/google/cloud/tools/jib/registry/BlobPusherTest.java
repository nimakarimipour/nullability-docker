package com.google.cloud.tools.jib.registry;
@RunWith(MockitoJUnitRunner.class)
public class BlobPusherTest {
  @Mock private Blob mockBlob;
  @Mock private URL mockURL;
  private DescriptorDigest fakeDescriptorDigest;
  private BlobPusher testBlobPusher;
  @Before
  public void setUpFakes() throws DigestException {
    fakeDescriptorDigest =
        DescriptorDigest.fromHash(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    testBlobPusher =
        new BlobPusher(
            new RegistryEndpointProperties("someServerUrl", "someImageName"),
            fakeDescriptorDigest,
            mockBlob);
  }
  @Test
  public void testInitializer_getContent() {
    Assert.assertNull(testBlobPusher.initializer().getContent());
  }
  @Test
  public void testGetAccept() {
    Assert.assertEquals(0, testBlobPusher.initializer().getAccept().size());
  }
  @Test
  public void testInitializer_handleResponse_created() throws IOException, RegistryException {
    Response mockResponse = Mockito.mock(Response.class);
    Mockito.when(mockResponse.getStatusCode()).thenReturn(201); 
    Assert.assertNull(testBlobPusher.initializer().handleResponse(mockResponse));
  }
  @Test
  public void testInitializer_handleResponse_accepted() throws IOException, RegistryException {
    Response mockResponse = Mockito.mock(Response.class);
    Mockito.when(mockResponse.getStatusCode()).thenReturn(202); 
    Mockito.when(mockResponse.getHeader("Location"))
        .thenReturn(Collections.singletonList("location"));
    Assert.assertEquals("location", testBlobPusher.initializer().handleResponse(mockResponse));
  }
  @Test
  public void testInitializer_handleResponse_accepted_multipleLocations()
      throws IOException, RegistryException {
    Response mockResponse = Mockito.mock(Response.class);
    Mockito.when(mockResponse.getStatusCode()).thenReturn(202); 
    Mockito.when(mockResponse.getHeader("Location"))
        .thenReturn(Arrays.asList("location1", "location2"));
    try {
      testBlobPusher.initializer().handleResponse(mockResponse);
      Assert.fail("Multiple 'Location' headers should be a registry error");
    } catch (RegistryErrorException ex) {
      Assert.assertThat(
          ex.getMessage(),
          CoreMatchers.containsString("Expected 1 'Location' header, but found 2"));
    }
  }
  @Test
  public void testInitializer_handleResponse_unrecognized() throws IOException, RegistryException {
    Response mockResponse = Mockito.mock(Response.class);
    Mockito.when(mockResponse.getStatusCode()).thenReturn(-1); 
    try {
      testBlobPusher.initializer().handleResponse(mockResponse);
      Assert.fail("Multiple 'Location' headers should be a registry error");
    } catch (RegistryErrorException ex) {
      Assert.assertThat(
          ex.getMessage(), CoreMatchers.containsString("Received unrecognized status code -1"));
    }
  }
  @Test
  public void testInitializer_getApiRoute() throws MalformedURLException {
    Assert.assertEquals(
        new URL("http:
        testBlobPusher.initializer().getApiRoute("http:
  }
  @Test
  public void testInitializer_getHttpMethod() {
    Assert.assertEquals("POST", testBlobPusher.initializer().getHttpMethod());
  }
  @Test
  public void testInitializer_getActionDescription() {
    Assert.assertEquals(
        "push BLOB for someServerUrl/someImageName with digest " + fakeDescriptorDigest,
        testBlobPusher.initializer().getActionDescription());
  }
  @Test
  public void testWriter_getContent() throws IOException {
    BlobHttpContent body = testBlobPusher.writer(mockURL).getContent();
    Assert.assertNotNull(body);
    Assert.assertEquals("application/octet-stream", body.getType());
    body.writeTo(ByteStreams.nullOutputStream());
    Mockito.verify(mockBlob).writeTo(ByteStreams.nullOutputStream());
  }
  @Test
  public void testWriter_GetAccept() {
    Assert.assertEquals(0, testBlobPusher.writer(mockURL).getAccept().size());
  }
  @Test
  public void testWriter_handleResponse() throws IOException, RegistryException {
    Response mockResponse = Mockito.mock(Response.class);
    Mockito.when(mockResponse.getHeader("Location"))
        .thenReturn(Collections.singletonList("location"));
    Assert.assertEquals("location", testBlobPusher.writer(mockURL).handleResponse(mockResponse));
  }
  @Test
  public void testWriter_getApiRoute() throws MalformedURLException {
    URL fakeUrl = new URL("http:
    Assert.assertEquals(fakeUrl, testBlobPusher.writer(fakeUrl).getApiRoute(""));
  }
  @Test
  public void testWriter_getHttpMethod() {
    Assert.assertEquals("PATCH", testBlobPusher.writer(mockURL).getHttpMethod());
  }
  @Test
  public void testWriter_getActionDescription() {
    Assert.assertEquals(
        "push BLOB for someServerUrl/someImageName with digest " + fakeDescriptorDigest,
        testBlobPusher.writer(mockURL).getActionDescription());
  }
  @Test
  public void testCommitter_getContent() {
    Assert.assertNull(testBlobPusher.committer(mockURL).getContent());
  }
  @Test
  public void testCommitter_GetAccept() {
    Assert.assertEquals(0, testBlobPusher.committer(mockURL).getAccept().size());
  }
  @Test
  public void testCommitter_handleResponse() throws IOException, RegistryException {
    Assert.assertNull(
        testBlobPusher.committer(mockURL).handleResponse(Mockito.mock(Response.class)));
  }
  @Test
  public void testCommitter_getApiRoute() throws MalformedURLException {
    Assert.assertEquals(
        new URL("https:
        testBlobPusher.committer(new URL("https:
  }
  @Test
  public void testCommitter_getHttpMethod() {
    Assert.assertEquals("PUT", testBlobPusher.committer(mockURL).getHttpMethod());
  }
  @Test
  public void testCommitter_getActionDescription() {
    Assert.assertEquals(
        "push BLOB for someServerUrl/someImageName with digest " + fakeDescriptorDigest,
        testBlobPusher.committer(mockURL).getActionDescription());
  }
}
