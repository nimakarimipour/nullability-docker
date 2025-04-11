package com.squareup.picasso3;
class AssetRequestHandler extends RequestHandler {
  private static final String ANDROID_ASSET = "android_asset";
  private static final int ASSET_PREFIX_LENGTH =
      (SCHEME_FILE + ":
  private final Context context;
  private final Object lock = new Object();
  private volatile AssetManager assetManager;
  AssetRequestHandler(Context context) {
    this.context = context;
  }
  @Override public boolean canHandleRequest( Request data) {
    Uri uri = data.uri;
    return uri != null
        && SCHEME_FILE.equals(uri.getScheme())
        && !uri.getPathSegments().isEmpty()
        && ANDROID_ASSET.equals(uri.getPathSegments().get(0));
  }
  @Override
  public void load( Picasso picasso,  Request request,  Callback callback) {
    initializeIfFirstTime();
    boolean signaledCallback = false;
    try {
      Source source = Okio.source(assetManager.open(getFilePath(request)));
      try {
        Bitmap bitmap = decodeStream(source, request);
        signaledCallback = true;
        callback.onSuccess(new Result(bitmap, DISK));
      } finally {
        try {
          source.close();
        } catch (IOException ignored) {
        }
      }
    } catch (Exception e) {
      if (!signaledCallback) {
        callback.onError(e);
      }
    }
  }
  @Initializer
  private void initializeIfFirstTime() {
    if (assetManager == null) {
      synchronized (lock) {
        if (assetManager == null) {
          assetManager = context.getAssets();
        }
      }
    }
  }
  static String getFilePath(Request request) {
    Uri uri = checkNotNull(request.uri, "request.uri == null");
    return uri.toString().substring(ASSET_PREFIX_LENGTH);
  }
}
