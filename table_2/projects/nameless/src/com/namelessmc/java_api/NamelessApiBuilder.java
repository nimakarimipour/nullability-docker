package com.namelessmc.java_api;
public class NamelessApiBuilder {
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(5);
	private static final String DEFAULT_USER_AGENT = "Nameless-Java-API";
	private static final int DEFAULT_RESPONSE_SIZE_LIMIT = 32*1024*1024;
	private final  URL apiUrl;
	private final  String apiKey;
	private final  GsonBuilder gsonBuilder;
	private  ApiLogger debugLogger = null;
	private final Methanol. Builder httpClientBuilder;
	private int responseSizeLimit = DEFAULT_RESPONSE_SIZE_LIMIT;
	NamelessApiBuilder(final  URL apiUrl,
					   final  String apiKey) {
		try {
			this.apiUrl = apiUrl.toString().endsWith("/") ? apiUrl : new URL(apiUrl + "/");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		this.apiKey = apiKey;
		this.gsonBuilder = new GsonBuilder();
		this.gsonBuilder.disableHtmlEscaping();
		this.httpClientBuilder = Methanol.newBuilder()
				.defaultHeader("X-Api-Key", this.apiKey)
				.userAgent(DEFAULT_USER_AGENT)
				.readTimeout(DEFAULT_TIMEOUT)
				.requestTimeout(DEFAULT_TIMEOUT)
				.connectTimeout(DEFAULT_TIMEOUT)
				.autoAcceptEncoding(true);
	}
	public  NamelessApiBuilder userAgent(final  String userAgent) {
		this.httpClientBuilder.userAgent(userAgent);
		return this;
	}
	public  NamelessApiBuilder debug(final boolean debug) {
		if (debug) {
			return this.withStdErrDebugLogging();
		} else {
			this.debugLogger = null;
			return this;
		}
	}
	@Deprecated
	public  NamelessApiBuilder withStdErrDebugLogging() {
		this.debugLogger = PrintStreamLogger.DEFAULT_INSTANCE;
		return this;
	}
	public  NamelessApiBuilder stdErrDebugLogger() {
		this.debugLogger = PrintStreamLogger.DEFAULT_INSTANCE;
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withSlf4jDebugLogging() {
		this.debugLogger = Slf4jLogger.DEFAULT_INSTANCE;
		return this;
	}
	public  NamelessApiBuilder slf4jDebugLogger() {
		this.debugLogger = Slf4jLogger.DEFAULT_INSTANCE;
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withCustomDebugLogger(final  ApiLogger debugLogger) {
		this.debugLogger = debugLogger;
		return this;
	}
	public  NamelessApiBuilder customDebugLogger(final  ApiLogger debugLogger) {
		this.debugLogger = debugLogger;
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withTimeoutMillis(final int timeout) {
		return this.withTimeout(Duration.ofMillis(timeout));
	}
	@Deprecated
	public  NamelessApiBuilder withTimeout(final  Duration timeout) {
		this.httpClientBuilder.readTimeout(timeout)
				.requestTimeout(timeout)
				.connectTimeout(timeout);
		return this;
	}
	public  NamelessApiBuilder timeout(final  Duration timeout) {
		this.httpClientBuilder.readTimeout(timeout)
				.requestTimeout(timeout)
				.connectTimeout(timeout);
		return this;
	}
	public  NamelessApiBuilder withProxy(final ProxySelector proxy) {
		this.httpClientBuilder.proxy(proxy);
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder proxy(final ProxySelector proxy) {
		this.httpClientBuilder.proxy(proxy);
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withAuthenticator(final Authenticator authenticator) {
		this.httpClientBuilder.authenticator(authenticator);
		return this;
	}
	public  NamelessApiBuilder authenticator(final Authenticator authenticator) {
		this.httpClientBuilder.authenticator(authenticator);
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withPrettyJson() {
		gsonBuilder.setPrettyPrinting();
		return this;
	}
	public  NamelessApiBuilder pettyJsonRequests() {
		gsonBuilder.setPrettyPrinting();
		return this;
	}
	@Deprecated
	public  NamelessApiBuilder withResponseSizeLimit(int responseSizeLimitBytes) {
		this.responseSizeLimit = responseSizeLimitBytes;
		return this;
	}
	public  NamelessApiBuilder responseSizeLimit(int responseSizeLimitBytes) {
		this.responseSizeLimit = responseSizeLimitBytes;
		return this;
	}
	public  NamelessApiBuilder executor(final  Executor executor) {
		this.httpClientBuilder.executor(executor);
		return this;
	}
	public  NamelessAPI build() {
		return new NamelessAPI(
				new RequestHandler(
						this.apiUrl,
						this.httpClientBuilder.build(),
						this.gsonBuilder.create(),
						this.debugLogger,
						this.responseSizeLimit
				),
				this.apiUrl,
				this.apiKey
		);
	}
}
