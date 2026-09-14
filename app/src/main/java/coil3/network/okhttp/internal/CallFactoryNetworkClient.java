package coil3.network.okhttp.internal;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import coil3.network.NetworkClient;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p163io.CloseableKt;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JQ\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t21\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001b"}, m1836d2 = {"Lcoil3/network/okhttp/internal/CallFactoryNetworkClient;", "Lcoil3/network/NetworkClient;", "callFactory", "Lokhttp3/Call$Factory;", "constructor-impl", "(Lokhttp3/Call$Factory;)Lokhttp3/Call$Factory;", "executeRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lcoil3/network/NetworkRequest;", "block", "Lkotlin/Function2;", "Lcoil3/network/NetworkResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "executeRequest-impl", "(Lokhttp3/Call$Factory;Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "coil-network-okhttp"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@JvmInline
public final class CallFactoryNetworkClient implements NetworkClient {
    private final Call.Factory callFactory;

    /* JADX INFO: renamed from: coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 */
    static final class C17761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallFactoryNetworkClient.m2784executeRequestimpl(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CallFactoryNetworkClient m2780boximpl(Call.Factory factory) {
        return new CallFactoryNetworkClient(factory);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Call.Factory m2781constructorimpl(@NotNull Call.Factory factory) {
        return factory;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2782equalsimpl(Call.Factory factory, Object obj) {
        return (obj instanceof CallFactoryNetworkClient) && Intrinsics.areEqual(factory, ((CallFactoryNetworkClient) obj).getCallFactory());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2783equalsimpl0(Call.Factory factory, Call.Factory factory2) {
        return Intrinsics.areEqual(factory, factory2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2785hashCodeimpl(Call.Factory factory) {
        return factory.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2786toStringimpl(Call.Factory factory) {
        return "CallFactoryNetworkClient(callFactory=" + factory + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object other) {
        return m2782equalsimpl(this.callFactory, other);
    }

    public int hashCode() {
        return m2785hashCodeimpl(this.callFactory);
    }

    public String toString() {
        return m2786toStringimpl(this.callFactory);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Call.Factory getCallFactory() {
        return this.callFactory;
    }

    private /* synthetic */ CallFactoryNetworkClient(Call.Factory factory) {
        this.callFactory = factory;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: executeRequest-impl, reason: not valid java name */
    public static <T> Object m2784executeRequestimpl(Call.Factory factory, @NotNull NetworkRequest networkRequest, @NotNull Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        C17761 c17761;
        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function3;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        if (continuation instanceof C17761) {
            c17761 = (C17761) continuation;
            int i = c17761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17761.label = i - Integer.MIN_VALUE;
            } else {
                c17761 = new C17761(continuation);
            }
        } else {
            c17761 = new C17761(continuation);
        }
        Object request = c17761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17761.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(request);
            c17761.L$0 = function2;
            c17761.L$1 = factory;
            c17761.label = 1;
            request = UtilsKt.toRequest(networkRequest, c17761);
            if (request == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable2 = (Closeable) c17761.L$0;
                    try {
                        ResultKt.throwOnFailure(request);
                        CloseableKt.closeFinally(closeable2, null);
                        return request;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(closeable2, th);
                            throw th3;
                        }
                    }
                }
                function3 = (Function2) c17761.L$0;
                ResultKt.throwOnFailure(request);
                closeable = (Closeable) request;
                try {
                    NetworkResponse networkResponse = UtilsKt.toNetworkResponse((Response) closeable);
                    c17761.L$0 = closeable;
                    c17761.label = 3;
                    request = function3.invoke(networkResponse, c17761);
                    if (request == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    closeable2 = closeable;
                    CloseableKt.closeFinally(closeable2, null);
                    return request;
                } catch (Throwable th4) {
                    th = th4;
                    closeable2 = closeable;
                    throw th;
                }
            }
            factory = (Call.Factory) c17761.L$1;
            function2 = (Function2) c17761.L$0;
            ResultKt.throwOnFailure(request);
        }
        Call callNewCall = factory.newCall((Request) request);
        c17761.L$0 = function2;
        c17761.L$1 = null;
        c17761.label = 2;
        request = CallsKt.await(callNewCall, c17761);
        if (request == coroutine_suspended) {
            return coroutine_suspended;
        }
        function3 = function2;
        closeable = (Closeable) request;
        NetworkResponse networkResponse2 = UtilsKt.toNetworkResponse((Response) closeable);
        c17761.L$0 = closeable;
        c17761.label = 3;
        request = function3.invoke(networkResponse2, c17761);
        if (request == coroutine_suspended) {
            return coroutine_suspended;
        }
        closeable2 = closeable;
        CloseableKt.closeFinally(closeable2, null);
        return request;
    }

    @Override // coil3.network.NetworkClient
    @Nullable
    public <T> Object executeRequest(@NotNull NetworkRequest networkRequest, @NotNull Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return m2784executeRequestimpl(this.callFactory, networkRequest, function2, continuation);
    }
}
