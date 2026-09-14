package org.apache.commons.lang3;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.Suppliers;

/* JADX INFO: loaded from: classes6.dex */
public final class SystemProperties {
    public static final String APPLE_AWT_ENABLE_TEMPLATE_IMAGES = "apple.awt.enableTemplateImages";

    @Deprecated
    public static final String AWT_TOOLKIT = "awt.toolkit";
    public static final String COM_SUN_JNDI_LDAP_OBJECT_TRUST_SERIAL_DATA = "com.sun.jndi.ldap.object.trustSerialData";
    public static final String COM_SUN_NET_HTTP_SERVER_HTTP_SERVER_PROVIDER = "com.sun.net.httpserver.HttpServerProvider";
    public static final String FILE_ENCODING = "file.encoding";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String FTP_NON_PROXY_HOST = "ftp.nonProxyHosts";
    public static final String FTP_PROXY_HOST = "ftp.proxyHost";
    public static final String FTP_PROXY_PORT = "ftp.proxyPort";
    public static final String HTTPS_PROXY_HOST = "https.proxyHost";
    public static final String HTTPS_PROXY_PORT = "https.proxyPort";
    public static final String HTTP_AGENT = "http.agent";
    public static final String HTTP_AUTH_DIGEST_CNONCE_REPEAT = "http.auth.digest.cnonceRepeat";
    public static final String HTTP_AUTH_DIGEST_RE_ENABLED_ALGORITHMS = "http.auth.digest.reEnabledAlgorithms";
    public static final String HTTP_AUTH_DIGEST_VALIDATE_PROXY = "http.auth.digest.validateProxy";
    public static final String HTTP_AUTH_DIGEST_VALIDATE_SERVER = "http.auth.digest.validateServer";
    public static final String HTTP_AUTH_NTLM_DOMAIN = "http.auth.ntlm.domain";
    public static final String HTTP_KEEP_ALIVE = "http.keepAlive";
    public static final String HTTP_KEEP_ALIVE_TIME_PROXY = "http.keepAlive.time.proxy";
    public static final String HTTP_KEEP_ALIVE_TIME_SERVER = "http.keepAlive.time.server";
    public static final String HTTP_MAX_CONNECTIONS = "http.maxConnections";
    public static final String HTTP_MAX_REDIRECTS = "http.maxRedirects";
    public static final String HTTP_NON_PROXY_HOSTS = "http.nonProxyHosts";
    public static final String HTTP_PROXY_HOST = "http.proxyHost";
    public static final String HTTP_PROXY_PORT = "http.proxyPort";
    public static final String JAVAX_ACCESSIBILITY_ASSISTIVE_TECHNOLOGIES = "javax.accessibility.assistive_technologies";
    public static final String JAVAX_NET_SSL_SESSION_CACHE_SIZE = "javax.net.ssl.sessionCacheSize";
    public static final String JAVAX_RMI_SSL_CLIENT_ENABLED_CIPHER_SUITES = "javax.rmi.ssl.client.enabledCipherSuites";
    public static final String JAVAX_RMI_SSL_CLIENT_ENABLED_PROTOCOLS = "javax.rmi.ssl.client.enabledProtocols";
    public static final String JAVAX_SECURITY_AUTH_USE_SUBJECT_CREDS_ONLY = "javax.security.auth.useSubjectCredsOnly";
    public static final String JAVAX_SMART_CARD_IO_TERMINAL_FACTORY_DEFAULT_TYPE = "javax.smartcardio.TerminalFactory.DefaultType";

    @Deprecated
    public static final String JAVA_AWT_FONTS = "java.awt.fonts";

    @Deprecated
    public static final String JAVA_AWT_GRAPHICSENV = "java.awt.graphicsenv";

    @Deprecated
    public static final String JAVA_AWT_HEADLESS = "java.awt.headless";

    @Deprecated
    public static final String JAVA_AWT_PRINTERJOB = "java.awt.printerjob";
    public static final String JAVA_CLASS_PATH = "java.class.path";
    public static final String JAVA_CLASS_VERSION = "java.class.version";

    @Deprecated
    public static final String JAVA_COMPILER = "java.compiler";
    public static final String JAVA_CONTENT_HANDLER_PKGS = "java.content.handler.pkgs";

    @Deprecated
    public static final String JAVA_ENDORSED_DIRS = "java.endorsed.dirs";

    @Deprecated
    public static final String JAVA_EXT_DIRS = "java.ext.dirs";
    public static final String JAVA_HOME = "java.home";
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    public static final String JAVA_LIBRARY_PATH = "java.library.path";
    public static final String JAVA_LOCALE_PROVIDERS = "java.locale.providers";
    public static final String JAVA_LOCALE_USE_OLD_ISO_CODES = "java.locale.useOldISOCodes";
    public static final String JAVA_NET_PREFER_IPV4_STACK = "java.net.preferIPv4Stack";
    public static final String JAVA_NET_PREFER_IPV6_ADDRESSES = "java.net.preferIPv6Addresses";
    public static final String JAVA_NET_SOCKS_PASSWORD = "java.net.socks.password";
    public static final String JAVA_NET_SOCKS_USER_NAME = "java.net.socks.username";
    public static final String JAVA_NET_USE_SYSTEM_PROXIES = "java.net.useSystemProxies";
    public static final String JAVA_NIO_CHANNELS_DEFAULT_THREAD_POOL_INITIAL_SIZE = "java.nio.channels.DefaultThreadPool.initialSize";
    public static final String JAVA_NIO_CHANNELS_DEFAULT_THREAD_POOL_THREAD_FACTORY = "java.nio.channels.DefaultThreadPool.threadFactory";
    public static final String JAVA_NIO_CHANNELS_SPI_ASYNCHRONOUS_CHANNEL_PROVIDER = "java.nio.channels.spi.AsynchronousChannelProvider";
    public static final String JAVA_NIO_CHANNELS_SPI_SELECTOR_PROVIDER = "java.nio.channels.spi.SelectorProvider";
    public static final String JAVA_NIO_FILE_SPI_DEFAULT_FILE_SYSTEM_PROVIDER = "java.nio.file.spi.DefaultFileSystemProvider";
    public static final String JAVA_PROPERTIES_DATE = "java.properties.date";
    public static final String JAVA_PROTOCOL_HANDLER_PKGS = "java.protocol.handler.pkgs";
    public static final String JAVA_RMI_SERVER_CODEBASE = "java.rmi.server.codebase";
    public static final String JAVA_RMI_SERVER_HOST_NAME = "java.rmi.server.hostname";
    public static final String JAVA_RMI_SERVER_RANDOM_IDS = "java.rmi.server.randomIDs";
    public static final String JAVA_RMI_SERVER_RMI_CLASS_LOADER_SPI = "java.rmi.server.RMIClassLoaderSpi";
    public static final String JAVA_RUNTIME_NAME = "java.runtime.name";
    public static final String JAVA_RUNTIME_VERSION = "java.runtime.version";
    public static final String JAVA_SECURITY_AUTH_LOGIN_CONFIG = "java.security.auth.login.config";
    public static final String JAVA_SECURITY_DEBUG = "java.security.debug";
    public static final String JAVA_SECURITY_KERBEROS_CONF = "java.security.krb5.conf";
    public static final String JAVA_SECURITY_KERBEROS_KDC = "java.security.krb5.kdc";
    public static final String JAVA_SECURITY_KERBEROS_REALM = "java.security.krb5.realm";
    public static final String JAVA_SECURITY_MANAGER = "java.security.manager";
    public static final String JAVA_SPECIFICATION_MAINTENANCE_VERSION = "java.specification.maintenance.version";
    public static final String JAVA_SPECIFICATION_NAME = "java.specification.name";
    public static final String JAVA_SPECIFICATION_VENDOR = "java.specification.vendor";
    public static final String JAVA_SPECIFICATION_VERSION = "java.specification.version";
    public static final String JAVA_SYSTEM_CLASS_LOADER = "java.system.class.loader";
    public static final String JAVA_TIME_ZONE_DEFAULT_ZONE_RULES_PROVIDER = "java.time.zone.DefaultZoneRulesProvider";
    public static final String JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_EXCEPTION_HANDLER = "java.util.concurrent.ForkJoinPool.common.exceptionHandler";
    public static final String JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_MAXIMUM_SPARES = "java.util.concurrent.ForkJoinPool.common.maximumSpares";
    public static final String JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_PARALLELISM = "java.util.concurrent.ForkJoinPool.common.parallelism";
    public static final String JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_THREAD_FACTORY = "java.util.concurrent.ForkJoinPool.common.threadFactory";
    public static final String JAVA_UTIL_CURRENCY_DATA = "java.util.currency.data";
    public static final String JAVA_UTIL_LOGGING_CONFIG_CLASS = "java.util.logging.config.class";
    public static final String JAVA_UTIL_LOGGING_CONFIG_FILE = "java.util.logging.config.file";
    public static final String JAVA_UTIL_LOGGING_SIMPLE_FORMATTER_FORMAT = "java.util.logging.simpleformatter.format";
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = "java.util.prefs.PreferencesFactory";
    public static final String JAVA_UTIL_PROPERTY_RESOURCE_BUNDLE_ENCODING = "java.util.PropertyResourceBundle.encoding";
    public static final String JAVA_VENDOR = "java.vendor";
    public static final String JAVA_VENDOR_URL = "java.vendor.url";
    public static final String JAVA_VENDOR_VERSION = "java.vendor.version";
    public static final String JAVA_VERSION = "java.version";
    public static final String JAVA_VERSION_DATE = "java.version.date";
    public static final String JAVA_VM_INFO = "java.vm.info";
    public static final String JAVA_VM_NAME = "java.vm.name";
    public static final String JAVA_VM_SPECIFICATION_NAME = "java.vm.specification.name";
    public static final String JAVA_VM_SPECIFICATION_VENDOR = "java.vm.specification.vendor";
    public static final String JAVA_VM_SPECIFICATION_VERSION = "java.vm.specification.version";
    public static final String JAVA_VM_VENDOR = "java.vm.vendor";
    public static final String JAVA_VM_VERSION = "java.vm.version";
    public static final String JAVA_XML_CONFIG_FILE = "java.xml.config.file";
    public static final String JDBC_DRIVERS = "jdbc.drivers";
    public static final String JDK_HTTPS_NEGOTIATE_CBT = "jdk.https.negotiate.cbt";
    public static final String JDK_HTTP_AUTH_PROXYING_DISABLED_SCHEMES = "jdk.http.auth.proxying.disabledSchemes";
    public static final String JDK_HTTP_AUTH_TUNNELING_DISABLED_SCHEMES = "jdk.http.auth.tunneling.disabledSchemes";
    public static final String JDK_HTTP_CLIENT_ALLOW_RESTRICTED_HEADERS = "jdk.httpclient.allowRestrictedHeaders";
    public static final String JDK_HTTP_CLIENT_AUTH_RETRY_LIMIT = "jdk.httpclient.auth.retrylimit";
    public static final String JDK_HTTP_CLIENT_BUF_SIZE = "jdk.httpclient.bufsize";
    public static final String JDK_HTTP_CLIENT_CONNECTION_POOL_SIZE = "jdk.httpclient.connectionPoolSize";
    public static final String JDK_HTTP_CLIENT_CONNECTION_WINDOW_SIZE = "jdk.httpclient.connectionWindowSize";
    public static final String JDK_HTTP_CLIENT_DISABLE_RETRY_CONNECT = "jdk.httpclient.disableRetryConnect";
    public static final String JDK_HTTP_CLIENT_ENABLE_ALL_METHOD_RETRY = "jdk.httpclient.enableAllMethodRetry";
    public static final String JDK_HTTP_CLIENT_ENABLE_PUSH = "jdk.httpclient.enablepush";
    public static final String JDK_HTTP_CLIENT_HPACK_MAX_HEADER_TABLE_SIZE = "jdk.httpclient.hpack.maxheadertablesize";
    public static final String JDK_HTTP_CLIENT_HTTP_CLIENT_LOG = "jdk.httpclient.HttpClient.log";
    public static final String JDK_HTTP_CLIENT_KEEP_ALIVE_TIMEOUT = "jdk.httpclient.keepalive.timeout";
    public static final String JDK_HTTP_CLIENT_KEEP_ALIVE_TIMEOUT_H2 = "jdk.httpclient.keepalive.timeout.h2";
    public static final String JDK_HTTP_CLIENT_MAX_FRAME_SIZE = "jdk.httpclient.maxframesize";
    public static final String JDK_HTTP_CLIENT_MAX_STREAMS = "jdk.httpclient.maxstreams";
    public static final String JDK_HTTP_CLIENT_RECEIVE_BUFFER_SIZE = "jdk.httpclient.receiveBufferSize";
    public static final String JDK_HTTP_CLIENT_REDIRECTS_RETRY_LIMIT = "jdk.httpclient.redirects.retrylimit";
    public static final String JDK_HTTP_CLIENT_SEND_BUFFER_SIZE = "jdk.httpclient.sendBufferSize";
    public static final String JDK_HTTP_CLIENT_WEB_SOCKET_WRITE_BUFFER_SIZE = "jdk.httpclient.websocket.writeBufferSize";
    public static final String JDK_HTTP_CLIENT_WINDOW_SIZE = "jdk.httpclient.windowsize";
    public static final String JDK_HTTP_SERVER_MAX_CONNECTIONS = "jdk.httpserver.maxConnections";
    public static final String JDK_INCLUDE_IN_EXCEPTIONS = "jdk.includeInExceptions";
    public static final String JDK_INTERNAL_HTTP_CLIENT_DISABLE_HOST_NAME_VERIFICATION = "jdk.internal.httpclient.disableHostnameVerification";
    public static final String JDK_IO_PERMISSIONS_USE_CANONICAL_PATH = "jdk.io.permissionsUseCanonicalPath";
    public static final String JDK_JNDI_LDAP_OBJECT_FACTORIES_FILTER = "jdk.jndi.ldap.object.factoriesFilter";
    public static final String JDK_JNDI_OBJECT_FACTORIES_FILTER = "jdk.jndi.object.factoriesFilter";
    public static final String JDK_JNDI_RMI_OBJECT_FACTORIES_FILTER = "jdk.jndi.rmi.object.factoriesFilter";
    public static final String JDK_MODULE_MAIN = "jdk.module.main";
    public static final String JDK_MODULE_MAIN_CLASS = "jdk.module.main.class";
    public static final String JDK_MODULE_PATH = "jdk.module.path";
    public static final String JDK_MODULE_UPGRADE_PATH = "jdk.module.upgrade.path";
    public static final String JDK_NET_UNIX_DOMAIN_TMPDIR = "jdk.net.unixdomain.tmpdir";
    public static final String JDK_NET_URL_CLASS_PATH_SHOW_IGNORED_CLASS_PATH_ENTRIES = "jdk.net.URLClassPath.showIgnoredClassPathEntries";
    public static final String JDK_SERIAL_FILTER = "jdk.serialFilter";
    public static final String JDK_SERIAL_FILTER_FACTORY = "jdk.serialFilterFactory";
    public static final String JDK_TLS_CLIENT_SIGNATURE_SCHEMES = "jdk.tls.client.SignatureSchemes";
    public static final String JDK_TLS_NAMED_GROUPS = "jdk.tls.namedGroups";
    public static final String JDK_TLS_SERVER_SIGNATURE_SCHEMES = "jdk.tls.server.SignatureSchemes";
    public static final String JDK_VIRTUAL_THREAD_SCHEDULER_MAXPOOLSIZE = "jdk.virtualThreadScheduler.maxPoolSize";
    public static final String JDK_VIRTUAL_THREAD_SCHEDULER_PARALLELISM = "jdk.virtualThreadScheduler.parallelism";
    public static final String JDK_XML_CDATA_CHUNK_SIZE = "jdk.xml.cdataChunkSize";
    public static final String JDK_XML_DTD_SUPPORT = "jdk.xml.dtd.support";
    public static final String JDK_XML_ELEMENT_ATTRIBUTE_LIMIT = "jdk.xml.elementAttributeLimit";
    public static final String JDK_XML_ENABLE_EXTENSION_FUNCTIONS = "jdk.xml.enableExtensionFunctions";
    public static final String JDK_XML_ENTITY_EXPANSION_LIMIT = "jdk.xml.entityExpansionLimit";
    public static final String JDK_XML_ENTITY_REPLACEMENT_LIMIT = "jdk.xml.entityReplacementLimi_t";
    public static final String JDK_XML_IS_STANDALONE = "jdk.xml.isStandalone";
    public static final String JDK_XML_JDK_CATALOG_RESOLVE = "jdk.xml.jdkcatalog.resolve";
    public static final String JDK_XML_MAX_ELEMENT_DEPTH = "jdk.xml.maxElementDepth";
    public static final String JDK_XML_MAX_GENERAL_ENTITY_SIZE_LIMIT = "jdk.xml.maxGeneralEntitySizeLimit";
    public static final String JDK_XML_MAX_OCCUR_LIMIT = "jdk.xml.maxOccurLimit";
    public static final String JDK_XML_MAX_PARAMETER_ENTITY_SIZE_LIMIT = "jdk.xml.maxParameterEntitySizeLimit";
    public static final String JDK_XML_MAX_XML_NAME_LIMIT = "jdk.xml.maxXMLNameLimit";
    public static final String JDK_XML_OVERRIDE_DEFAULT_PARSER = "jdk.xml.overrideDefaultParser";
    public static final String JDK_XML_RESET_SYMBOL_TABLE = "jdk.xml.resetSymbolTable";
    public static final String JDK_XML_TOTAL_ENTITY_SIZE_LIMIT = "jdk.xml.totalEntitySizeLimit";
    public static final String JDK_XML_XSLTC_IS_STANDALONE = "jdk.xml.xsltcIsStandalone";
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String NATIVE_ENCODING = "native.encoding";
    public static final String NETWORK_ADDRESS_CACHE_NEGATIVE_TTL = "networkaddress.cache.negative.ttl";
    public static final String NETWORK_ADDRESS_CACHE_STALE_TTL = "networkaddress.cache.stale.ttl";
    public static final String NETWORK_ADDRESS_CACHE_TTL = "networkaddress.cache.ttl";
    public static final String ORG_JCP_XML_DSIG_SECURE_VALIDATION = "org.jcp.xml.dsig.securevalidation";
    public static final String ORG_OPENJDK_JAVA_UTIL_STREAM_TRIPWIRE = "org.openjdk.java.util.stream.tripwire";
    public static final String OS_ARCH = "os.arch";
    public static final String OS_NAME = "os.name";
    public static final String OS_VERSION = "os.version";
    public static final String PATH_SEPARATOR = "path.separator";
    public static final String SOCKS_PROXY_HOST = "socksProxyHost";
    public static final String SOCKS_PROXY_PORT = "socksProxyPort";
    public static final String SOCKS_PROXY_VERSION = "socksProxyVersion";
    public static final String STDERR_ENCODING = "stderr.encoding";
    public static final String STDOUT_ENCODING = "stdout.encoding";
    public static final String SUN_NET_HTTP_SERVER_DRAIN_AMOUNT = "sun.net.httpserver.drainAmount";
    public static final String SUN_NET_HTTP_SERVER_IDLE_INTERVAL = "sun.net.httpserver.idleInterval";
    public static final String SUN_NET_HTTP_SERVER_MAX_IDLE_CONNECTIONS = "sun.net.httpserver.maxIdleConnections";
    public static final String SUN_NET_HTTP_SERVER_MAX_REQ_HEADERS = "sun.net.httpserver.maxReqHeaders";
    public static final String SUN_NET_HTTP_SERVER_MAX_REQ_TIME = "sun.net.httpserver.maxReqTime";
    public static final String SUN_NET_HTTP_SERVER_MAX_RSP_TIME = "sun.net.httpserver.maxRspTime";
    public static final String SUN_NET_HTTP_SERVER_NO_DELAY = "sun.net.httpserver.nodelay";
    public static final String SUN_SECURITY_KRB5_PRINCIPAL = "sun.security.krb5.principal";
    public static final String USER_COUNTRY = "user.country";
    public static final String USER_DIR = "user.dir";
    public static final String USER_EXTENSIONS = "user.extensions";
    public static final String USER_HOME = "user.home";
    public static final String USER_LANGUAGE = "user.language";
    public static final String USER_NAME = "user.name";
    public static final String USER_REGION = "user.region";
    public static final String USER_SCRIPT = "user.script";
    public static final String USER_TIMEZONE = "user.timezone";
    public static final String USER_VARIANT = "user.variant";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getProperty$0(String str) {
        return str;
    }

    public static String getAppleAwtEnableTemplateImages() {
        return getProperty(APPLE_AWT_ENABLE_TEMPLATE_IMAGES);
    }

    @Deprecated
    public static String getAwtToolkit() {
        return getProperty(AWT_TOOLKIT);
    }

    public static boolean getBoolean(Class<?> cls, String str, BooleanSupplier booleanSupplier) {
        return getBoolean(toKey(cls, str, true), booleanSupplier);
    }

    public static boolean getBoolean(String str, BooleanSupplier booleanSupplier) {
        String property = getProperty(str);
        if (property == null) {
            return booleanSupplier != null && booleanSupplier.getAsBoolean();
        }
        return Boolean.parseBoolean(property);
    }

    public static String getComSunJndiLdapObjectTrustSerialData() {
        return getProperty(COM_SUN_JNDI_LDAP_OBJECT_TRUST_SERIAL_DATA);
    }

    public static String getComSunNetHttpServerHttpServerProvider() {
        return getProperty(COM_SUN_NET_HTTP_SERVER_HTTP_SERVER_PROVIDER);
    }

    public static String getFileEncoding() {
        return getProperty(FILE_ENCODING);
    }

    public static String getFileSeparator() {
        return getProperty(FILE_SEPARATOR);
    }

    public static String getFtpNonProxyHost() {
        return getProperty(FTP_NON_PROXY_HOST);
    }

    public static String getFtpProxyHost() {
        return getProperty(FTP_PROXY_HOST);
    }

    public static String getFtpProxyPort() {
        return getProperty(FTP_PROXY_PORT);
    }

    public static String getHttpAgent() {
        return getProperty(HTTP_AGENT);
    }

    public static String getHttpAuthDigestCnonceRepeat() {
        return getProperty(HTTP_AUTH_DIGEST_CNONCE_REPEAT);
    }

    public static String getHttpAuthDigestReenabledAlgorithms() {
        return getProperty(HTTP_AUTH_DIGEST_RE_ENABLED_ALGORITHMS);
    }

    public static String getHttpAuthDigestValidateProxy() {
        return getProperty(HTTP_AUTH_DIGEST_VALIDATE_PROXY);
    }

    public static String getHttpAuthDigestValidateServer() {
        return getProperty(HTTP_AUTH_DIGEST_VALIDATE_SERVER);
    }

    public static String getHttpAuthNtlmDomain() {
        return getProperty(HTTP_AUTH_NTLM_DOMAIN);
    }

    public static String getHttpKeepAlive() {
        return getProperty(HTTP_KEEP_ALIVE);
    }

    public static String getHttpKeepAliveTimeProxy() {
        return getProperty(HTTP_KEEP_ALIVE_TIME_PROXY);
    }

    public static String getHttpKeepAliveTimeServer() {
        return getProperty(HTTP_KEEP_ALIVE_TIME_SERVER);
    }

    public static String getHttpMaxConnections() {
        return getProperty(HTTP_MAX_CONNECTIONS);
    }

    public static String getHttpMaxRedirects() {
        return getProperty(HTTP_MAX_REDIRECTS);
    }

    public static String getHttpNonProxyHosts() {
        return getProperty(HTTP_NON_PROXY_HOSTS);
    }

    public static String getHttpProxyHost() {
        return getProperty(HTTP_PROXY_HOST);
    }

    public static String getHttpProxyPort() {
        return getProperty(HTTP_PROXY_PORT);
    }

    public static String getHttpsProxyHost() {
        return getProperty(HTTPS_PROXY_HOST);
    }

    public static String getHttpsProxyPort() {
        return getProperty(HTTPS_PROXY_PORT);
    }

    public static int getInt(Class<?> cls, String str, IntSupplier intSupplier) {
        return getInt(toKey(cls, str, true), intSupplier);
    }

    public static int getInt(String str, IntSupplier intSupplier) {
        String property = getProperty(str);
        if (property != null) {
            return Integer.parseInt(property);
        }
        if (intSupplier != null) {
            return intSupplier.getAsInt();
        }
        return 0;
    }

    @Deprecated
    public static String getJavaAwtFonts() {
        return getProperty(JAVA_AWT_FONTS);
    }

    @Deprecated
    public static String getJavaAwtGraphicsenv() {
        return getProperty(JAVA_AWT_GRAPHICSENV);
    }

    @Deprecated
    public static String getJavaAwtHeadless() {
        return getProperty(JAVA_AWT_HEADLESS);
    }

    @Deprecated
    public static String getJavaAwtPrinterjob() {
        return getProperty(JAVA_AWT_PRINTERJOB);
    }

    public static String getJavaClassPath() {
        return getProperty(JAVA_CLASS_PATH);
    }

    public static String getJavaClassVersion() {
        return getProperty(JAVA_CLASS_VERSION);
    }

    @Deprecated
    public static String getJavaCompiler() {
        return getProperty(JAVA_COMPILER);
    }

    public static String getJavaContentHandlerPkgs() {
        return getProperty(JAVA_CONTENT_HANDLER_PKGS);
    }

    @Deprecated
    public static String getJavaEndorsedDirs() {
        return getProperty(JAVA_ENDORSED_DIRS);
    }

    @Deprecated
    public static String getJavaExtDirs() {
        return getProperty(JAVA_EXT_DIRS);
    }

    public static String getJavaHome() {
        return getProperty("java.home");
    }

    public static String getJavaIoTmpdir() {
        return getProperty("java.io.tmpdir");
    }

    public static String getJavaLibraryPath() {
        return getProperty(JAVA_LIBRARY_PATH);
    }

    public static String getJavaLocaleProviders() {
        return getProperty(JAVA_LOCALE_PROVIDERS);
    }

    public static String getJavaLocaleUseOldIsoCodes() {
        return getProperty(JAVA_LOCALE_USE_OLD_ISO_CODES);
    }

    public static String getJavaNetPreferIpv4Stack() {
        return getProperty(JAVA_NET_PREFER_IPV4_STACK);
    }

    public static String getJavaNetPreferIpv6Addresses() {
        return getProperty(JAVA_NET_PREFER_IPV6_ADDRESSES);
    }

    public static String getJavaNetSocksPassword() {
        return getProperty(JAVA_NET_SOCKS_PASSWORD);
    }

    public static String getJavaNetSocksUserName() {
        return getProperty(JAVA_NET_SOCKS_USER_NAME);
    }

    public static String getJavaNetUseSystemProxies() {
        return getProperty(JAVA_NET_USE_SYSTEM_PROXIES);
    }

    public static String getJavaNioChannelsDefaultThreadPoolInitialSize() {
        return getProperty(JAVA_NIO_CHANNELS_DEFAULT_THREAD_POOL_INITIAL_SIZE);
    }

    public static String getJavaNioChannelsDefaultThreadPoolThreadFactory() {
        return getProperty(JAVA_NIO_CHANNELS_DEFAULT_THREAD_POOL_THREAD_FACTORY);
    }

    public static String getJavaNioChannelsSpiAsynchronousChannelProvider() {
        return getProperty(JAVA_NIO_CHANNELS_SPI_ASYNCHRONOUS_CHANNEL_PROVIDER);
    }

    public static String getJavaNioChannelsSpiSelectorProvider() {
        return getProperty(JAVA_NIO_CHANNELS_SPI_SELECTOR_PROVIDER);
    }

    public static String getJavaNioFileSpiDefaultFileSystemProvider() {
        return getProperty(JAVA_NIO_FILE_SPI_DEFAULT_FILE_SYSTEM_PROVIDER);
    }

    public static String getJavaPropertiesDate() {
        return getProperty(JAVA_PROPERTIES_DATE);
    }

    public static String getJavaProtocolHandlerPkgs() {
        return getProperty(JAVA_PROTOCOL_HANDLER_PKGS);
    }

    public static String getJavaRmiServerCodebase() {
        return getProperty(JAVA_RMI_SERVER_CODEBASE);
    }

    public static String getJavaRmiServerHostName() {
        return getProperty(JAVA_RMI_SERVER_HOST_NAME);
    }

    public static String getJavaRmiServerRandomIds() {
        return getProperty(JAVA_RMI_SERVER_RANDOM_IDS);
    }

    public static String getJavaRmiServerRmiClassLoaderSpi() {
        return getProperty(JAVA_RMI_SERVER_RMI_CLASS_LOADER_SPI);
    }

    public static String getJavaRuntimeName() {
        return getProperty(JAVA_RUNTIME_NAME);
    }

    public static String getJavaRuntimeVersion() {
        return getProperty(JAVA_RUNTIME_VERSION);
    }

    public static String getJavaSecurityAuthLoginConfig() {
        return getProperty(JAVA_SECURITY_AUTH_LOGIN_CONFIG);
    }

    public static String getJavaSecurityManager() {
        return getProperty(JAVA_SECURITY_MANAGER);
    }

    public static String getJavaSpecificationMaintenanceVersion() {
        return getProperty(JAVA_SPECIFICATION_MAINTENANCE_VERSION);
    }

    public static String getJavaSpecificationName() {
        return getProperty(JAVA_SPECIFICATION_NAME);
    }

    public static String getJavaSpecificationVendor() {
        return getProperty(JAVA_SPECIFICATION_VENDOR);
    }

    public static String getJavaSpecificationVersion() {
        return getProperty(JAVA_SPECIFICATION_VERSION);
    }

    public static String getJavaSpecificationVersion(String str) {
        return getProperty(JAVA_SPECIFICATION_VERSION, str);
    }

    public static String getJavaSystemClassLoader() {
        return getProperty(JAVA_SYSTEM_CLASS_LOADER);
    }

    public static String getJavaTimeZoneDefaultZoneRulesProvider() {
        return getProperty(JAVA_TIME_ZONE_DEFAULT_ZONE_RULES_PROVIDER);
    }

    public static String getJavaUtilConcurrentForkJoinPoolCommonExceptionHandler() {
        return getProperty(JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_EXCEPTION_HANDLER);
    }

    public static String getJavaUtilConcurrentForkJoinPoolCommonMaximumSpares() {
        return getProperty(JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_MAXIMUM_SPARES);
    }

    public static String getJavaUtilConcurrentForkJoinPoolCommonParallelism() {
        return getProperty(JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_PARALLELISM);
    }

    public static String getJavaUtilConcurrentForkJoinPoolCommonThreadFactory() {
        return getProperty(JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_THREAD_FACTORY);
    }

    public static String getJavaUtilCurrencyData() {
        return getProperty(JAVA_UTIL_CURRENCY_DATA);
    }

    public static String getJavaUtilLoggingConfigClass() {
        return getProperty(JAVA_UTIL_LOGGING_CONFIG_CLASS);
    }

    public static String getJavaUtilLoggingConfigFile() {
        return getProperty(JAVA_UTIL_LOGGING_CONFIG_FILE);
    }

    public static String getJavaUtilLoggingSimpleFormatterFormat() {
        return getProperty(JAVA_UTIL_LOGGING_SIMPLE_FORMATTER_FORMAT);
    }

    public static String getJavaUtilPrefsPreferencesFactory() {
        return getProperty(JAVA_UTIL_PREFS_PREFERENCES_FACTORY);
    }

    public static String getJavaUtilPropertyResourceBundleEncoding() {
        return getProperty(JAVA_UTIL_PROPERTY_RESOURCE_BUNDLE_ENCODING);
    }

    public static String getJavaVendor() {
        return getProperty(JAVA_VENDOR);
    }

    public static String getJavaVendorUrl() {
        return getProperty(JAVA_VENDOR_URL);
    }

    public static String getJavaVendorVersion() {
        return getProperty(JAVA_VENDOR_VERSION);
    }

    public static String getJavaVersion() {
        return getProperty(JAVA_VERSION);
    }

    public static String getJavaVersionDate() {
        return getProperty(JAVA_VERSION_DATE);
    }

    public static String getJavaVmInfo() {
        return getProperty(JAVA_VM_INFO);
    }

    public static String getJavaVmName() {
        return getProperty(JAVA_VM_NAME);
    }

    public static String getJavaVmSpecificationName() {
        return getProperty(JAVA_VM_SPECIFICATION_NAME);
    }

    public static String getJavaVmSpecificationVendor() {
        return getProperty(JAVA_VM_SPECIFICATION_VENDOR);
    }

    public static String getJavaVmSpecificationVersion() {
        return getProperty(JAVA_VM_SPECIFICATION_VERSION);
    }

    public static String getJavaVmVendor() {
        return getProperty(JAVA_VM_VENDOR);
    }

    public static String getJavaVmVersion() {
        return getProperty(JAVA_VM_VERSION);
    }

    public static String getJavaxAccessibilityAssistiveTechnologies() {
        return getProperty(JAVAX_ACCESSIBILITY_ASSISTIVE_TECHNOLOGIES);
    }

    public static String getJavaXmlConfigFile() {
        return getProperty(JAVA_XML_CONFIG_FILE);
    }

    public static String getJavaxNetSslSessionCacheSize() {
        return getProperty(JAVAX_NET_SSL_SESSION_CACHE_SIZE);
    }

    public static String getJavaxRmiSslClientEnabledCipherSuites() {
        return getProperty(JAVAX_RMI_SSL_CLIENT_ENABLED_CIPHER_SUITES);
    }

    public static String getJavaxRmiSslClientEnabledProtocols() {
        return getProperty(JAVAX_RMI_SSL_CLIENT_ENABLED_PROTOCOLS);
    }

    public static String getJavaxSecurityAuthUseSubjectCredsOnly() {
        return getProperty(JAVAX_SECURITY_AUTH_USE_SUBJECT_CREDS_ONLY);
    }

    public static String getJavaxSmartCardIoTerminalFactoryDefaultType() {
        return getProperty(JAVAX_SMART_CARD_IO_TERMINAL_FACTORY_DEFAULT_TYPE);
    }

    public static String getJdbcDrivers() {
        return getProperty(JDBC_DRIVERS);
    }

    public static String getJdkHttpAuthProxyingDisabledSchemes() {
        return getProperty(JDK_HTTP_AUTH_PROXYING_DISABLED_SCHEMES);
    }

    public static String getJdkHttpAuthTunnelingDisabledSchemes() {
        return getProperty(JDK_HTTP_AUTH_TUNNELING_DISABLED_SCHEMES);
    }

    public static String getJdkHttpClientAllowRestrictedHeaders() {
        return getProperty(JDK_HTTP_CLIENT_ALLOW_RESTRICTED_HEADERS);
    }

    public static String getJdkHttpClientAuthRetryLimit() {
        return getProperty(JDK_HTTP_CLIENT_AUTH_RETRY_LIMIT);
    }

    public static String getJdkHttpClientBufSize() {
        return getProperty(JDK_HTTP_CLIENT_BUF_SIZE);
    }

    public static String getJdkHttpClientConnectionPoolSize() {
        return getProperty(JDK_HTTP_CLIENT_CONNECTION_POOL_SIZE);
    }

    public static String getJdkHttpClientConnectionWindowSize() {
        return getProperty(JDK_HTTP_CLIENT_CONNECTION_WINDOW_SIZE);
    }

    public static String getJdkHttpClientDisableRetryConnect() {
        return getProperty(JDK_HTTP_CLIENT_DISABLE_RETRY_CONNECT);
    }

    public static String getJdkHttpClientEnableAllMethodRetry() {
        return getProperty(JDK_HTTP_CLIENT_ENABLE_ALL_METHOD_RETRY);
    }

    public static String getJdkHttpClientEnablePush() {
        return getProperty(JDK_HTTP_CLIENT_ENABLE_PUSH);
    }

    public static String getJdkHttpClientHpackMaxHeaderTableSize() {
        return getProperty(JDK_HTTP_CLIENT_HPACK_MAX_HEADER_TABLE_SIZE);
    }

    public static String getJdkHttpClientHttpClientLog() {
        return getProperty(JDK_HTTP_CLIENT_HTTP_CLIENT_LOG);
    }

    public static String getJdkHttpClientKeepAliveTimeout() {
        return getProperty(JDK_HTTP_CLIENT_KEEP_ALIVE_TIMEOUT);
    }

    public static String getJdkHttpClientKeepAliveTimeoutH2() {
        return getProperty(JDK_HTTP_CLIENT_KEEP_ALIVE_TIMEOUT_H2);
    }

    public static String getJdkHttpClientMaxFrameSize() {
        return getProperty(JDK_HTTP_CLIENT_MAX_FRAME_SIZE);
    }

    public static String getJdkHttpClientMaxStreams() {
        return getProperty(JDK_HTTP_CLIENT_MAX_STREAMS);
    }

    public static String getJdkHttpClientReceiveBufferSize() {
        return getProperty(JDK_HTTP_CLIENT_RECEIVE_BUFFER_SIZE);
    }

    public static String getJdkHttpClientRedirectsRetryLimit() {
        return getProperty(JDK_HTTP_CLIENT_REDIRECTS_RETRY_LIMIT);
    }

    public static String getJdkHttpClientSendBufferSize() {
        return getProperty(JDK_HTTP_CLIENT_SEND_BUFFER_SIZE);
    }

    public static String getJdkHttpClientWebSocketWriteBufferSize() {
        return getProperty(JDK_HTTP_CLIENT_WEB_SOCKET_WRITE_BUFFER_SIZE);
    }

    public static String getJdkHttpClientWindowSize() {
        return getProperty(JDK_HTTP_CLIENT_WINDOW_SIZE);
    }

    public static String getJdkHttpServerMaxConnections() {
        return getProperty(JDK_HTTP_SERVER_MAX_CONNECTIONS);
    }

    public static String getJdkHttpsNegotiateCbt() {
        return getProperty(JDK_HTTPS_NEGOTIATE_CBT);
    }

    public static String getJdkIncludeInExceptions() {
        return getProperty(JDK_INCLUDE_IN_EXCEPTIONS);
    }

    public static String getJdkInternalHttpClientDisableHostNameVerification() {
        return getProperty(JDK_INTERNAL_HTTP_CLIENT_DISABLE_HOST_NAME_VERIFICATION);
    }

    public static String getJdkIoPermissionsUseCanonicalPath() {
        return getProperty(JDK_IO_PERMISSIONS_USE_CANONICAL_PATH);
    }

    public static String getJdkJndiLdapObjectFactoriesFilter() {
        return getProperty(JDK_JNDI_LDAP_OBJECT_FACTORIES_FILTER);
    }

    public static String getJdkJndiObjectFactoriesFilter() {
        return getProperty(JDK_JNDI_OBJECT_FACTORIES_FILTER);
    }

    public static String getJdkJndiRmiObjectFactoriesFilter() {
        return getProperty(JDK_JNDI_RMI_OBJECT_FACTORIES_FILTER);
    }

    public static String getJdkModuleMain() {
        return getProperty(JDK_MODULE_MAIN);
    }

    public static String getJdkModuleMainClass() {
        return getProperty(JDK_MODULE_MAIN_CLASS);
    }

    public static String getJdkModulePath() {
        return getProperty(JDK_MODULE_PATH);
    }

    public static String getJdkModuleUpgradePath() {
        return getProperty(JDK_MODULE_UPGRADE_PATH);
    }

    public static String getJdkNetUnixDomainTmpDir() {
        return getProperty(JDK_NET_UNIX_DOMAIN_TMPDIR);
    }

    public static String getJdkNetUrlClassPathShowIgnoredClassPathEntries() {
        return getProperty(JDK_NET_URL_CLASS_PATH_SHOW_IGNORED_CLASS_PATH_ENTRIES);
    }

    public static String getJdkSerialFilter() {
        return getProperty(JDK_SERIAL_FILTER);
    }

    public static String getJdkSerialFilterFactory() {
        return getProperty(JDK_SERIAL_FILTER_FACTORY);
    }

    public static String getJdkTlsClientSignatureSchemes() {
        return getProperty(JDK_TLS_CLIENT_SIGNATURE_SCHEMES);
    }

    public static String getJdkTlsNamedGroups() {
        return getProperty(JDK_TLS_NAMED_GROUPS);
    }

    public static String getJdkTlsServerSignatureSchemes() {
        return getProperty(JDK_TLS_SERVER_SIGNATURE_SCHEMES);
    }

    public static String getJdkVirtualThreadSchedulerMaxPoolSize() {
        return getProperty(JDK_VIRTUAL_THREAD_SCHEDULER_MAXPOOLSIZE);
    }

    public static String getJdkVirtualThreadSchedulerParallelism() {
        return getProperty(JDK_VIRTUAL_THREAD_SCHEDULER_PARALLELISM);
    }

    public static String getJdkXmlCdataChunkSize() {
        return getProperty(JDK_XML_CDATA_CHUNK_SIZE);
    }

    public static String getJdkXmlDtdSupport() {
        return getProperty(JDK_XML_DTD_SUPPORT);
    }

    public static String getJdkXmlElementAttributeLimit() {
        return getProperty(JDK_XML_ELEMENT_ATTRIBUTE_LIMIT);
    }

    public static String getJdkXmlEnableExtensionFunctions() {
        return getProperty(JDK_XML_ENABLE_EXTENSION_FUNCTIONS);
    }

    public static String getJdkXmlEntityExpansionLimit() {
        return getProperty(JDK_XML_ENTITY_EXPANSION_LIMIT);
    }

    public static String getJdkXmlEntityReplacementLimit() {
        return getProperty(JDK_XML_ENTITY_REPLACEMENT_LIMIT);
    }

    public static String getJdkXmlIsStandalone() {
        return getProperty(JDK_XML_IS_STANDALONE);
    }

    public static String getJdkXmlJdkCatalogResolve() {
        return getProperty(JDK_XML_JDK_CATALOG_RESOLVE);
    }

    public static String getJdkXmlMaxElementDepth() {
        return getProperty(JDK_XML_MAX_ELEMENT_DEPTH);
    }

    public static String getJdkXmlMaxGeneralEntitySizeLimit() {
        return getProperty(JDK_XML_MAX_GENERAL_ENTITY_SIZE_LIMIT);
    }

    public static String getJdkXmlMaxOccurLimit() {
        return getProperty(JDK_XML_MAX_OCCUR_LIMIT);
    }

    public static String getJdkXmlMaxParameterEntitySizeLimit() {
        return getProperty(JDK_XML_MAX_PARAMETER_ENTITY_SIZE_LIMIT);
    }

    public static String getJdkXmlMaxXmlNameLimit() {
        return getProperty(JDK_XML_MAX_XML_NAME_LIMIT);
    }

    public static String getJdkXmlOverrideDefaultParser() {
        return getProperty(JDK_XML_OVERRIDE_DEFAULT_PARSER);
    }

    public static String getJdkXmlResetSymbolTable() {
        return getProperty(JDK_XML_RESET_SYMBOL_TABLE);
    }

    public static String getJdkXmlTotalEntitySizeLimit() {
        return getProperty(JDK_XML_TOTAL_ENTITY_SIZE_LIMIT);
    }

    public static String getJdkXmlXsltcIsStandalone() {
        return getProperty(JDK_XML_XSLTC_IS_STANDALONE);
    }

    public static String getLineSeparator() {
        return getProperty(LINE_SEPARATOR);
    }

    public static String getLineSeparator(Supplier<String> supplier) {
        return getProperty(LINE_SEPARATOR, supplier);
    }

    public static long getLong(Class<?> cls, String str, LongSupplier longSupplier) {
        return getLong(toKey(cls, str, true), longSupplier);
    }

    public static long getLong(String str, LongSupplier longSupplier) {
        String property = getProperty(str);
        if (property != null) {
            return Long.parseLong(property);
        }
        if (longSupplier != null) {
            return longSupplier.getAsLong();
        }
        return 0L;
    }

    public static String getNativeEncoding() {
        return getProperty(NATIVE_ENCODING);
    }

    public static String getNetworkAddressCacheNegativeTtl() {
        return getProperty(NETWORK_ADDRESS_CACHE_NEGATIVE_TTL);
    }

    public static String getNetworkAddressCacheStaleTtl() {
        return getProperty(NETWORK_ADDRESS_CACHE_STALE_TTL);
    }

    public static String getNetworkAddressCacheTtl() {
        return getProperty(NETWORK_ADDRESS_CACHE_TTL);
    }

    public static String getOrgJcpXmlDsigSecureValidation() {
        return getProperty(ORG_JCP_XML_DSIG_SECURE_VALIDATION);
    }

    public static String getOrgOpenJdkJavaUtilStreamTripwire() {
        return getProperty(ORG_OPENJDK_JAVA_UTIL_STREAM_TRIPWIRE);
    }

    public static String getOsArch() {
        return getProperty(OS_ARCH);
    }

    public static String getOsName() {
        return getProperty(OS_NAME);
    }

    public static String getOsVersion() {
        return getProperty(OS_VERSION);
    }

    public static Path getPath(String str, Supplier<Path> supplier) {
        String property = getProperty(str);
        if (property != null) {
            return Paths.get(property, new String[0]);
        }
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public static String getPathSeparator() {
        return getProperty(PATH_SEPARATOR);
    }

    public static String getProperty(String str) {
        return getProperty(str, Suppliers.nul());
    }

    static String getProperty(String str, final String str2) {
        return getProperty(str, new Supplier() { // from class: org.apache.commons.lang3.SystemProperties$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return SystemProperties.lambda$getProperty$0(str2);
            }
        });
    }

    static String getProperty(String str, Supplier supplier) {
        try {
            if (StringUtils.isEmpty(str)) {
                return (String) Suppliers.get(supplier);
            }
            return (String) StringUtils.getIfEmpty(System.getProperty(str), supplier);
        } catch (SecurityException unused) {
            return (String) supplier.get();
        }
    }

    public static String getSocksProxyHost() {
        return getProperty(SOCKS_PROXY_HOST);
    }

    public static String getSocksProxyPort() {
        return getProperty(SOCKS_PROXY_PORT);
    }

    public static String getSocksProxyVersion() {
        return getProperty(SOCKS_PROXY_VERSION);
    }

    public static String getStdErrEncoding() {
        return getProperty(STDERR_ENCODING);
    }

    public static String getStdOutEncoding() {
        return getProperty(STDOUT_ENCODING);
    }

    public static String getSunNetHttpServerDrainAmount() {
        return getProperty(SUN_NET_HTTP_SERVER_DRAIN_AMOUNT);
    }

    public static String getSunNetHttpServerIdleInterval() {
        return getProperty(SUN_NET_HTTP_SERVER_IDLE_INTERVAL);
    }

    public static String getSunNetHttpServerMaxIdleConnections() {
        return getProperty(SUN_NET_HTTP_SERVER_MAX_IDLE_CONNECTIONS);
    }

    public static String getSunNetHttpServerMaxReqHeaders() {
        return getProperty(SUN_NET_HTTP_SERVER_MAX_REQ_HEADERS);
    }

    public static String getSunNetHttpServerMaxReqTime() {
        return getProperty(SUN_NET_HTTP_SERVER_MAX_REQ_TIME);
    }

    public static String getSunNetHttpServerMaxRspTime() {
        return getProperty(SUN_NET_HTTP_SERVER_MAX_RSP_TIME);
    }

    public static String getSunNetHttpServerNoDelay() {
        return getProperty(SUN_NET_HTTP_SERVER_NO_DELAY);
    }

    public static String getSunSecurityKrb5Principal() {
        return getProperty(SUN_SECURITY_KRB5_PRINCIPAL);
    }

    public static String getUserCountry() {
        return getProperty(USER_COUNTRY);
    }

    public static String getUserDir() {
        return getProperty("user.dir");
    }

    public static String getUserExtensions() {
        return getProperty(USER_EXTENSIONS);
    }

    public static String getUserHome() {
        return getProperty("user.home");
    }

    public static String getUserLanguage() {
        return getProperty(USER_LANGUAGE);
    }

    public static String getUserName() {
        return getProperty("user.name");
    }

    public static String getUserName(String str) {
        return getProperty("user.name", str);
    }

    public static String getUserRegion() {
        return getProperty(USER_REGION);
    }

    public static String getUserScript() {
        return getProperty(USER_SCRIPT);
    }

    public static String getUserTimezone() {
        return getProperty(USER_TIMEZONE);
    }

    public static String getUserVariant() {
        return getProperty(USER_VARIANT);
    }

    public static boolean isPropertySet(String str) {
        return getProperty(str) != null;
    }

    private static String toKey(Class cls, String str, boolean z) {
        return ClassUtils.getName(cls, "", z) + InstructionFileId.DOT + str;
    }

    @Deprecated
    public SystemProperties() {
    }
}
