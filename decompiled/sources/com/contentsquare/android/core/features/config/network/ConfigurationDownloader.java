package com.contentsquare.android.core.features.config.network;

import com.allegion.accesssdk.BuildConfig;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.contentsquare.android.core.utils.UriBuilder;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015J$\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/contentsquare/android/core/features/config/network/ConfigurationDownloader;", "", "configuration", "Lcom/contentsquare/android/core/features/config/Configuration;", "httpConnection", "Lcom/contentsquare/android/core/features/http/HttpConnection;", "buildConfig", "Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/contentsquare/android/core/features/config/Configuration;Lcom/contentsquare/android/core/features/http/HttpConnection;Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "execute", "", "userId", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "onDownloadedCallback", "Lkotlin/Function0;", "fetchConfig", EventProcessorPerformanceManager.LOG_EVENT_ENDPOINT, "handleResponse", "response", "Lcom/contentsquare/android/core/features/http/HttpResponse;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigurationDownloader {

    @NotNull
    private final BuildConfigInstantiable buildConfig;

    @NotNull
    private final Configuration configuration;

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final HttpConnection httpConnection;

    @NotNull
    private final Logger logger;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.core.features.config.network.ConfigurationDownloader$execute$1", f = "ConfigurationDownloader.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.core.features.config.network.ConfigurationDownloader$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $configEndpoint;
        final /* synthetic */ Function0<Unit> $onDownloadedCallback;
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $userId;
        int label;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.contentsquare.android.core.features.config.network.ConfigurationDownloader$execute$1$1", f = "ConfigurationDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.contentsquare.android.core.features.config.network.ConfigurationDownloader$execute$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onDownloadedCallback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00401(Function0<Unit> function0, Continuation<? super C00401> continuation) {
                super(2, continuation);
                this.$onDownloadedCallback = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00401(this.$onDownloadedCallback, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onDownloadedCallback.invoke();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, String str3, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$configEndpoint = str;
            this.$userId = str2;
            this.$packageName = str3;
            this.$onDownloadedCallback = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConfigurationDownloader.this.new AnonymousClass1(this.$configEndpoint, this.$userId, this.$packageName, this.$onDownloadedCallback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strFetchConfig = ConfigurationDownloader.this.fetchConfig(this.$configEndpoint, this.$userId, this.$packageName);
                if (strFetchConfig != null) {
                    ConfigurationDownloader.this.configuration.saveToStorage(strFetchConfig);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C00401 c00401 = new C00401(this.$onDownloadedCallback, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c00401, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ConfigurationDownloader(Configuration configuration, HttpConnection httpConnection, BuildConfigInstantiable buildConfig) {
        this(configuration, httpConnection, buildConfig, null, 8, null);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchConfig(String endpoint, String userId, String packageName) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (this.configuration.getLastETag().length() > 0) {
            mapCreateMapBuilder.put("If-None-Match", this.configuration.getLastETag());
        }
        if (userId != null && Intrinsics.areEqual(this.buildConfig.getBuildType(), BuildConfig.FLAVOR)) {
            mapCreateMapBuilder.put("uid", userId);
        }
        return handleResponse(this.httpConnection.performHttpGet(endpoint, MapsKt.build(mapCreateMapBuilder)), endpoint, packageName);
    }

    private final String handleResponse(HttpResponse response, String endpoint, String packageName) {
        String str;
        int status = response.getStatus();
        if (status == 200) {
            String stringResponse = response.getStringResponse();
            if (stringResponse == null) {
                return null;
            }
            Configuration configuration = this.configuration;
            List<String> list = response.getHeaders().get("ETag");
            if (list == null || (str = (String) CollectionsKt.first((List) list)) == null) {
                str = "";
            }
            configuration.setLastETag(str);
            this.logger.d("Got remote config: ".concat(stringResponse));
            return stringResponse;
        }
        if (status == 304) {
            return null;
        }
        if (status != 404) {
            this.logger.w("Failed to get the Contentsquare configuration from server: " + response.getStatus() + " HTTP code.");
            return null;
        }
        this.logger.e("Got HTTP_NOT_FOUND for endpoint " + endpoint);
        this.logger.p("Config for package name '" + packageName + "' could not be retrieved. A Contentsquare project mightnot have been created for you yet. Send your package name to your Contentsquare contact.");
        return null;
    }

    public final void execute(String userId, String packageName, Function0<Unit> onDownloadedCallback) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(onDownloadedCallback, "onDownloadedCallback");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(UriBuilder.buildProjectConfigUrl(packageName), userId, packageName, onDownloadedCallback, null), 3, null);
    }

    @JvmOverloads
    public ConfigurationDownloader(Configuration configuration, HttpConnection httpConnection, BuildConfigInstantiable buildConfig, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.configuration = configuration;
        this.httpConnection = httpConnection;
        this.buildConfig = buildConfig;
        this.coroutineScope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("ConfigurationDownloader"));
        this.logger = new Logger("ConfigurationDownloader");
    }

    public /* synthetic */ ConfigurationDownloader(Configuration configuration, HttpConnection httpConnection, BuildConfigInstantiable buildConfigInstantiable, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(configuration, httpConnection, buildConfigInstantiable, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
