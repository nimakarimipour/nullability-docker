package com.squareup.picasso3;
@RunWith(RobolectricTestRunner.class) 
public class RemoteViewsActionTest {
  private Picasso picasso;
  private RemoteViews remoteViews;
  @Before public void setUp() {
    picasso = createPicasso();
    remoteViews = mock(RemoteViews.class);
    when(remoteViews.getLayoutId()).thenReturn(android.R.layout.list_content);
  }
  @Test public void completeSetsBitmapOnRemoteViews() {
    Callback callback = mockCallback();
    Bitmap bitmap = makeBitmap();
    RemoteViewsAction action = createAction(callback);
    action.complete(new RequestHandler.Result(bitmap, NETWORK));
    verify(remoteViews).setImageViewBitmap(1, bitmap);
    verify(callback).onSuccess();
  }
  @Test public void errorWithNoResourceIsNoop() {
    Callback callback = mockCallback();
    RemoteViewsAction action = createAction(callback);
    Exception e = new RuntimeException();
    action.error(e);
    verifyZeroInteractions(remoteViews);
    verify(callback).onError(e);
  }
  @Test public void errorWithResourceSetsResource() {
    Callback callback = mockCallback();
    RemoteViewsAction action = createAction(1, callback);
    Exception e = new RuntimeException();
    action.error(e);
    verify(remoteViews).setImageViewResource(1, 1);
    verify(callback).onError(e);
  }
  @Test public void clearsCallbackOnCancel() {
    Picasso picasso = mock(Picasso.class);
    ImageView target = mockImageViewTarget();
    Callback callback = mockCallback();
    ImageViewAction request =
        new ImageViewAction(picasso, new Target<>(target), null, callback);
    request.cancel();
    assertThat(request.callback).isNull();
  }
  private TestableRemoteViewsAction createAction(Callback callback) {
    return createAction(0, callback);
  }
  private TestableRemoteViewsAction createAction(int errorResId, Callback callback) {
    Target<RemoteViewsTarget> wrapper =
        new Target<>(new RemoteViewsTarget(remoteViews, 1), errorResId);
    return new TestableRemoteViewsAction(picasso, null, wrapper, callback);
  }
  private Picasso createPicasso() {
    Dispatcher dispatcher = mock(Dispatcher.class);
    PlatformLruCache cache = new PlatformLruCache(0);
    return new Picasso(RuntimeEnvironment.application, dispatcher, UNUSED_CALL_FACTORY, null, cache,
        null, NO_TRANSFORMERS, NO_HANDLERS, mock(Stats.class), ARGB_8888, false, false);
  }
  static class TestableRemoteViewsAction extends RemoteViewsAction {
    TestableRemoteViewsAction(Picasso picasso, Request data, Target<RemoteViewsTarget> target,
        Callback callback) {
      super(picasso, data, target, callback);
    }
    @Override void update() {
    }
  }
}
