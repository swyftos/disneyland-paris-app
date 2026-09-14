package coil3.network;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.annotation.InternalCoilApi;
import coil3.content.MimeTypeMap;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.UtilsKt;
import coil3.network.internal.Utils_androidKt;
import coil3.request.Options;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J4\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J@\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\u001b2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010)\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002J\f\u0010*\u001a\u00020+*\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020+*\u00020,H\u0082@¢\u0006\u0002\u0010-J\f\u0010*\u001a\u00020+*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, m1836d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", "url", "", "options", "Lcoil3/request/Options;", "networkClient", "Lkotlin/Lazy;", "Lcoil3/network/NetworkClient;", "diskCache", "Lcoil3/disk/DiskCache;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Ljava/lang/String;Lcoil3/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/network/ConnectivityChecker;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil3/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "networkResponse", "(Lcoil3/disk/DiskCache$Snapshot;Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRequest", "executeNetworkRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", CMSAttributeTableGenerator.CONTENT_TYPE, "toNetworkResponseOrNull", "toImageSource", "Lcoil3/decode/ImageSource;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokio/Buffer;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nNetworkFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkFetcher.kt\ncoil3/network/NetworkFetcher\n+ 2 FileSystem.kt\nokio/FileSystem\n+ 3 Okio.kt\nokio/Okio__OkioKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,291:1\n80#2:292\n165#2:293\n81#2:294\n82#2:299\n67#2:330\n68#2:335\n52#3,4:295\n60#3,10:300\n56#3,18:310\n66#3:329\n52#3,4:331\n60#3,10:336\n56#3,3:346\n71#3,3:349\n1#4:328\n*S KotlinDebug\n*F\n+ 1 NetworkFetcher.kt\ncoil3/network/NetworkFetcher\n*L\n150#1:292\n150#1:293\n150#1:294\n150#1:299\n224#1:330\n224#1:335\n150#1:295,4\n150#1:300,10\n150#1:310,18\n224#1:329\n224#1:331,4\n224#1:336,10\n224#1:346,3\n224#1:349,3\n*E\n"})
public final class NetworkFetcher implements Fetcher {
    private final Lazy cacheStrategy;
    private final ConnectivityChecker connectivityChecker;
    private final Lazy diskCache;
    private final Lazy networkClient;
    private final Options options;
    private final String url;

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$fetch$1 */
    static final class C17711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C17711(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.fetch(this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$toImageSource$1 */
    static final class C17731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17731(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.toImageSource(null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$writeToDiskCache$1 */
    static final class C17741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C17741(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.writeToDiskCache(null, null, null, null, this);
        }
    }

    public NetworkFetcher(@NotNull String str, @NotNull Options options, @NotNull Lazy<? extends NetworkClient> lazy, @NotNull Lazy<? extends DiskCache> lazy2, @NotNull Lazy<? extends CacheStrategy> lazy3, @NotNull ConnectivityChecker connectivityChecker) {
        this.url = str;
        this.options = options;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00f0 A[Catch: Exception -> 0x00b5, TryCatch #0 {Exception -> 0x00b5, blocks: (B:45:0x00e8, B:47:0x00f0, B:52:0x011a, B:55:0x0124, B:54:0x0120, B:29:0x0075, B:31:0x007e, B:40:0x00bb, B:42:0x00c7, B:34:0x0095, B:36:0x009f), top: B:70:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x0145 A[Catch: Exception -> 0x0035, TryCatch #1 {Exception -> 0x0035, blocks: (B:14:0x0030, B:64:0x015b, B:21:0x0048, B:59:0x0141, B:61:0x0145), top: B:71:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x015a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0164  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, coil3.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, coil3.network.NetworkResponse] */
    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) throws Exception {
        C17711 c17711;
        DiskCache.Snapshot snapshot;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        CacheStrategy.ReadResult readResult;
        Object obj;
        ?? r14;
        NetworkRequest networkRequestNewRequest;
        NetworkFetcher networkFetcher;
        Ref.ObjectRef objectRef4;
        ?? r15;
        SourceFetchResult sourceFetchResult;
        if (continuation instanceof C17711) {
            c17711 = (C17711) continuation;
            int i = c17711.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17711.label = i - Integer.MIN_VALUE;
            } else {
                c17711 = new C17711(continuation);
            }
        } else {
            c17711 = new C17711(continuation);
        }
        Object objExecuteNetworkRequest = c17711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17711.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) c17711.L$2;
                    Ref.ObjectRef objectRef6 = (Ref.ObjectRef) c17711.L$1;
                    NetworkFetcher networkFetcher2 = (NetworkFetcher) c17711.L$0;
                    try {
                        ResultKt.throwOnFailure(objExecuteNetworkRequest);
                        objectRef2 = objectRef5;
                        r15 = networkFetcher2;
                        obj = objExecuteNetworkRequest;
                        objectRef = objectRef6;
                        this = this;
                        readResult = (CacheStrategy.ReadResult) obj;
                        if (readResult.getResponse() != null) {
                            return new SourceFetchResult(r15.toImageSource((DiskCache.Snapshot) objectRef.element), r15.getMimeType(r15.url, readResult.getResponse().getHeaders().get("Content-Type")), DataSource.DISK);
                        }
                        objectRef3 = objectRef2;
                    } catch (Exception e) {
                        e = e;
                        this = objectRef6;
                        snapshot = (DiskCache.Snapshot) this.element;
                        if (snapshot != null) {
                            UtilsKt.closeQuietly(snapshot);
                        }
                        throw e;
                    }
                } else if (i2 == 2) {
                    Ref.ObjectRef objectRef7 = (Ref.ObjectRef) c17711.L$1;
                    NetworkFetcher networkFetcher3 = (NetworkFetcher) c17711.L$0;
                    ResultKt.throwOnFailure(objExecuteNetworkRequest);
                    networkFetcher = networkFetcher3;
                    objectRef4 = objectRef7;
                    sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
                    if (sourceFetchResult == null) {
                        return sourceFetchResult;
                    }
                    NetworkRequest networkRequestNewRequest2 = networkFetcher.newRequest();
                    Function2 c17722 = networkFetcher.new C17722(null);
                    c17711.L$0 = objectRef4;
                    c17711.L$1 = null;
                    c17711.label = 3;
                    objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequestNewRequest2, c17722, c17711);
                    if (objExecuteNetworkRequest == coroutine_suspended) {
                        this = objectRef4;
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.ObjectRef objectRef8 = (Ref.ObjectRef) c17711.L$0;
                    ResultKt.throwOnFailure(objExecuteNetworkRequest);
                    this = objectRef8;
                }
                this = objectRef4;
                return (SourceFetchResult) objExecuteNetworkRequest;
            }
            ResultKt.throwOnFailure(objExecuteNetworkRequest);
            objectRef = new Ref.ObjectRef();
            objectRef.element = readFromDiskCache();
            try {
                objectRef2 = new Ref.ObjectRef();
                if (objectRef.element != 0) {
                    Long size = getFileSystem().metadata(((DiskCache.Snapshot) objectRef.element).getMetadata()).getSize();
                    if (size != null && size.longValue() == 0) {
                        return new SourceFetchResult(toImageSource((DiskCache.Snapshot) objectRef.element), getMimeType(this.url, null), DataSource.DISK);
                    }
                    ?? networkResponseOrNull = toNetworkResponseOrNull((DiskCache.Snapshot) objectRef.element);
                    objectRef2.element = networkResponseOrNull;
                    if (networkResponseOrNull != 0) {
                        CacheStrategy cacheStrategy = (CacheStrategy) this.cacheStrategy.getValue();
                        NetworkResponse networkResponse = (NetworkResponse) objectRef2.element;
                        NetworkRequest networkRequestNewRequest3 = newRequest();
                        Options options = this.options;
                        c17711.L$0 = this;
                        c17711.L$1 = objectRef;
                        c17711.L$2 = objectRef2;
                        c17711.label = 1;
                        obj = cacheStrategy.read(networkResponse, networkRequestNewRequest3, options, c17711);
                        if (obj == coroutine_suspended) {
                            this = this;
                            return coroutine_suspended;
                        }
                        this = this;
                        readResult = (CacheStrategy.ReadResult) obj;
                        if (readResult.getResponse() != null) {
                            return new SourceFetchResult(r15.toImageSource((DiskCache.Snapshot) objectRef.element), r15.getMimeType(r15.url, readResult.getResponse().getHeaders().get("Content-Type")), DataSource.DISK);
                        }
                        objectRef3 = objectRef2;
                    }
                }
                objectRef3 = objectRef2;
                readResult = null;
                this = this;
            } catch (Exception e2) {
                e = e2;
                this = objectRef;
                snapshot = (DiskCache.Snapshot) this.element;
                if (snapshot != null) {
                    UtilsKt.closeQuietly(snapshot);
                }
                throw e;
            }
            if (readResult == null || (networkRequestNewRequest = readResult.getRequest()) == null) {
                r14 = r15;
                r14 = r15;
                networkRequestNewRequest = r14.newRequest();
            }
            r14 = r15;
            NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(objectRef, r14, objectRef3, networkRequestNewRequest, null);
            c17711.L$0 = r14;
            c17711.L$1 = objectRef;
            c17711.L$2 = null;
            c17711.label = 2;
            Object objExecuteNetworkRequest2 = r14.executeNetworkRequest(networkRequestNewRequest, networkFetcher$fetch$fetchResult$1, c17711);
            if (objExecuteNetworkRequest2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            networkFetcher = r14;
            objectRef4 = objectRef;
            objExecuteNetworkRequest = objExecuteNetworkRequest2;
            sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
            if (sourceFetchResult == null) {
                return sourceFetchResult;
            }
            NetworkRequest networkRequestNewRequest4 = networkFetcher.newRequest();
            Function2 c17723 = networkFetcher.new C17722(null);
            c17711.L$0 = objectRef4;
            c17711.L$1 = null;
            c17711.label = 3;
            objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequestNewRequest4, c17723, c17711);
            if (objExecuteNetworkRequest == coroutine_suspended) {
                this = objectRef4;
                return coroutine_suspended;
            }
            this = objectRef4;
            return (SourceFetchResult) objExecuteNetworkRequest;
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$fetch$2 */
    static final class C17722 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C17722(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C17722 c17722 = NetworkFetcher.this.new C17722(continuation);
            c17722.L$0 = obj;
            return c17722;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation continuation) {
            return ((C17722) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NetworkResponse networkResponse;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NetworkResponse networkResponse2 = (NetworkResponse) this.L$0;
                NetworkFetcher networkFetcher = NetworkFetcher.this;
                NetworkResponseBody networkResponseBodyRequireBody = UtilsKt.requireBody(networkResponse2);
                this.L$0 = networkResponse2;
                this.label = 1;
                Object imageSource = networkFetcher.toImageSource(networkResponseBodyRequireBody, this);
                if (imageSource == coroutine_suspended) {
                    return coroutine_suspended;
                }
                networkResponse = networkResponse2;
                obj = imageSource;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            NetworkFetcher networkFetcher2 = NetworkFetcher.this;
            return new SourceFetchResult((ImageSource) obj, networkFetcher2.getMimeType(networkFetcher2.url, networkResponse.getHeaders().get("Content-Type")), DataSource.NETWORK);
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache diskCache;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (diskCache = (DiskCache) this.diskCache.getValue()) == null) {
            return null;
        }
        return diskCache.openSnapshot(getDiskCacheKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    /* JADX WARN: Code duplicated, block: B:70:0x011d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object writeToDiskCache(DiskCache.Snapshot snapshot, NetworkResponse networkResponse, NetworkRequest networkRequest, NetworkResponse networkResponse2, Continuation continuation) throws Exception {
        C17741 c17741;
        DiskCache.Editor editorOpenEditor;
        DiskCache.Editor editor;
        NetworkResponse networkResponse3;
        NetworkResponse networkResponse4;
        NetworkResponseBody body;
        NetworkResponseBody body2;
        if (continuation instanceof C17741) {
            c17741 = (C17741) continuation;
            int i = c17741.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17741.label = i - Integer.MIN_VALUE;
            } else {
                c17741 = new C17741(continuation);
            }
        } else {
            c17741 = new C17741(continuation);
        }
        Object objWrite = c17741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17741.label;
        Throwable th = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWrite);
            if (!this.options.getDiskCachePolicy().getWriteEnabled()) {
                if (snapshot != null) {
                    UtilsKt.closeQuietly(snapshot);
                }
                return null;
            }
            CacheStrategy cacheStrategy = (CacheStrategy) this.cacheStrategy.getValue();
            Options options = this.options;
            c17741.L$0 = this;
            c17741.L$1 = snapshot;
            c17741.L$2 = networkResponse2;
            c17741.label = 1;
            objWrite = cacheStrategy.write(networkResponse, networkRequest, networkResponse2, options, c17741);
            if (objWrite == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                editor = (DiskCache.Editor) c17741.L$2;
                networkResponse3 = (NetworkResponse) c17741.L$1;
                networkResponse4 = (NetworkResponse) c17741.L$0;
                try {
                    ResultKt.throwOnFailure(objWrite);
                    return editor.commitAndOpenSnapshot();
                } catch (Exception e) {
                    e = e;
                    UtilsKt.abortQuietly(editor);
                    body = networkResponse4.getBody();
                    if (body != null) {
                        UtilsKt.closeQuietly(body);
                    }
                    body2 = networkResponse3.getBody();
                    if (body2 != null) {
                        UtilsKt.closeQuietly(body2);
                    }
                    throw e;
                }
            }
            networkResponse2 = (NetworkResponse) c17741.L$2;
            snapshot = (DiskCache.Snapshot) c17741.L$1;
            this = (NetworkFetcher) c17741.L$0;
            ResultKt.throwOnFailure(objWrite);
        }
        NetworkResponse response = ((CacheStrategy.WriteResult) objWrite).getResponse();
        if (response == null) {
            return null;
        }
        if (snapshot != null) {
            editorOpenEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache diskCache = (DiskCache) this.diskCache.getValue();
            editorOpenEditor = diskCache != null ? diskCache.openEditor(this.getDiskCacheKey()) : null;
        }
        if (editorOpenEditor == null) {
            return null;
        }
        try {
            BufferedSink bufferedSinkBuffer = Okio.buffer(this.getFileSystem().sink(editorOpenEditor.getMetadata(), false));
            try {
                CacheNetworkResponse.INSTANCE.writeTo(response, bufferedSinkBuffer);
                Unit unit = Unit.INSTANCE;
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                }
            }
            if (th != null) {
                throw th;
            }
            NetworkResponseBody body3 = response.getBody();
            if (body3 != null) {
                FileSystem fileSystem = this.getFileSystem();
                Path data = editorOpenEditor.getData();
                c17741.L$0 = networkResponse2;
                c17741.L$1 = response;
                c17741.L$2 = editorOpenEditor;
                c17741.label = 2;
                if (body3.writeTo(fileSystem, data, c17741) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            editor = editorOpenEditor;
            networkResponse3 = response;
            networkResponse4 = networkResponse2;
            return editor.commitAndOpenSnapshot();
        } catch (Exception e2) {
            e = e2;
            editor = editorOpenEditor;
            networkResponse3 = response;
            networkResponse4 = networkResponse2;
            UtilsKt.abortQuietly(editor);
            body = networkResponse4.getBody();
            if (body != null) {
                UtilsKt.closeQuietly(body);
            }
            body2 = networkResponse3.getBody();
            if (body2 != null) {
                UtilsKt.closeQuietly(body2);
            }
            throw e;
        }
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder builderNewBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            builderNewBuilder.set("Cache-Control", "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                builderNewBuilder.set("Cache-Control", "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderNewBuilder.set("Cache-Control", "no-cache");
        } else {
            builderNewBuilder.set("Cache-Control", "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), builderNewBuilder.build(), ImageRequestsKt.getHttpBody(this.options));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeNetworkRequest(NetworkRequest networkRequest, Function2 function2, Continuation continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            Utils_androidKt.assertNotOnMainThread();
        }
        return ((NetworkClient) this.networkClient.getValue()).executeRequest(networkRequest, new C17702(function2, null), continuation);
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$executeNetworkRequest$2 */
    static final class C17702 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17702(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C17702 c17702 = new C17702(this.$block, continuation);
            c17702.L$0 = obj;
            return c17702;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation continuation) {
            return ((C17702) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NetworkResponse networkResponse = (NetworkResponse) this.L$0;
                int code = networkResponse.getCode();
                if ((200 > code || code >= 300) && networkResponse.getCode() != 304) {
                    throw new HttpException(networkResponse);
                }
                Function2 function2 = this.$block;
                this.label = 1;
                obj = function2.invoke(networkResponse, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @InternalCoilApi
    @Nullable
    public final String getMimeType(@NotNull String url, @Nullable String contentType) {
        String mimeTypeFromUrl;
        if ((contentType == null || StringsKt.startsWith$default(contentType, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(url)) != null) {
            return mimeTypeFromUrl;
        }
        if (contentType != null) {
            return StringsKt.substringBefore$default(contentType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkResponse toNetworkResponseOrNull(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        NetworkResponse from;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                from = CacheNetworkResponse.INSTANCE.readFrom(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                from = null;
            }
            if (th == null) {
                return from;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object toImageSource(NetworkResponseBody networkResponseBody, Continuation continuation) {
        C17731 c17731;
        Buffer buffer;
        if (continuation instanceof C17731) {
            c17731 = (C17731) continuation;
            int i = c17731.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17731.label = i - Integer.MIN_VALUE;
            } else {
                c17731 = new C17731(continuation);
            }
        } else {
            c17731 = new C17731(continuation);
        }
        Object obj = c17731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17731.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            buffer = new Buffer();
            c17731.L$0 = this;
            c17731.L$1 = buffer;
            c17731.label = 1;
            if (networkResponseBody.writeTo(buffer, c17731) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Buffer buffer2 = (Buffer) c17731.L$1;
            NetworkFetcher networkFetcher = (NetworkFetcher) c17731.L$0;
            ResultKt.throwOnFailure(obj);
            buffer = buffer2;
            this = networkFetcher;
        }
        return this.toImageSource(buffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default(buffer, getFileSystem(), null, 4, null);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        FileSystem fileSystem;
        DiskCache diskCache = (DiskCache) this.diskCache.getValue();
        return (diskCache == null || (fileSystem = diskCache.getFileSystem()) == null) ? this.options.getFileSystem() : fileSystem;
    }

    @Metadata(m1835d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1836d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "networkClient", "Lkotlin/Function0;", "Lcoil3/network/NetworkClient;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "networkClientLazy", "Lkotlin/Lazy;", "cacheStrategyLazy", "connectivityCheckerLazy", "Lcoil3/network/internal/SingleParameterLazy;", "create", "Lcoil3/fetch/Fetcher;", "data", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy cacheStrategyLazy;
        private final SingleParameterLazy connectivityCheckerLazy;
        private final Lazy networkClientLazy;

        public Factory(@NotNull Function0<? extends NetworkClient> function0, @NotNull Function0<? extends CacheStrategy> function1, @NotNull Function1<? super Context, ? extends ConnectivityChecker> function2) {
            this.networkClientLazy = LazyKt.lazy(function0);
            this.cacheStrategyLazy = LazyKt.lazy(function1);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: coil3.network.NetworkFetcher$Factory$2 */
        public /* synthetic */ class C17692 extends FunctionReferenceImpl implements Function1 {
            public static final C17692 INSTANCE = new C17692();

            C17692() {
                super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ConnectivityChecker invoke(Context context) {
                return ConnectivityCheckerKt.ConnectivityChecker(context);
            }
        }

        public /* synthetic */ Factory(Function0 function0, Function0 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CacheStrategy.DEFAULT;
                }
            } : function1, (i & 4) != 0 ? C17692.INSTANCE : function2);
        }

        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri data, @NotNull Options options, @NotNull final ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new NetworkFetcher(data.getData(), options, this.networkClientLazy, LazyKt.lazy(new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return imageLoader.getDiskCache();
                    }
                }), this.cacheStrategyLazy, (ConnectivityChecker) this.connectivityCheckerLazy.get(options.getContext()));
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), "http") || Intrinsics.areEqual(data.getScheme(), "https");
        }
    }
}
