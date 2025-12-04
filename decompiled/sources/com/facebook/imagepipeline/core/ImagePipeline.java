package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.StrictMode;
import androidx.exifinterface.media.ExifInterface;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.fresco.urimod.UriModifier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ThreadSafe
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J;\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(0\t2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b*\u0010+JE\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(0\t2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b*\u0010-JO\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(0\t2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b*\u0010/J1\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100)0(0\t2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b0\u00101J+\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b2\u00103JQ\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b5\u00106J-\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b5\u00103J5\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b5\u00107J5\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020&¢\u0006\u0004\b5\u00108J]\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0)0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010 2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0002\b\u0003\u0018\u000109¢\u0006\u0004\b5\u0010;J+\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100)0(2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b<\u00103J5\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100)0(2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u00107J+\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b>\u00103J5\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b>\u00107J3\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u00107J)\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b?\u00103J1\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b?\u0010BJ=\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010A\u001a\u00020@2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b?\u0010CJ3\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bD\u00107JA\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010A\u001a\u00020@2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\bD\u0010CJ\u0015\u0010H\u001a\u00020G2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020G2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bJ\u0010IJ\u0017\u0010J\u001a\u00020G2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020G2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bL\u0010IJ\r\u0010M\u001a\u00020G¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020G¢\u0006\u0004\bO\u0010NJ\r\u0010P\u001a\u00020G¢\u0006\u0004\bP\u0010NJ\u0017\u0010Q\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bQ\u0010RJ\u0017\u0010Q\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\bQ\u0010SJ\u0017\u0010T\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bT\u0010RJ\u0017\u0010T\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\bT\u0010SJ\u0017\u0010U\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bU\u0010RJ!\u0010U\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010E2\b\u0010W\u001a\u0004\u0018\u00010V¢\u0006\u0004\bU\u0010XJ\u0015\u0010U\u001a\u00020\n2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\bU\u0010SJ\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0(2\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bY\u0010ZJ\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0(2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\bY\u0010[J#\u0010\\\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\\\u0010]J\u001f\u0010_\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010)2\b\u0010^\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b_\u0010`J\u0017\u0010a\u001a\u00020\n2\b\u0010^\u001a\u0004\u0018\u00010\r¢\u0006\u0004\ba\u0010bJG\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0(\"\u0004\b\u0000\u0010c2\u0014\u0010e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)0d2\u0006\u0010g\u001a\u00020f2\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bh\u0010iJ!\u0010j\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\u00052\b\u0010l\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bm\u0010nJ\r\u0010o\u001a\u00020G¢\u0006\u0004\bo\u0010NJ\r\u0010p\u001a\u00020G¢\u0006\u0004\bp\u0010NJ\r\u0010q\u001a\u00020G¢\u0006\u0004\bq\u0010NJ\u0017\u0010r\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\br\u0010SJC\u0010x\u001a\b\u0012\u0004\u0012\u00020\n0w2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010^\u001a\u00020\r2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020=0s2\u0006\u0010v\u001a\u00020uH\u0002¢\u0006\u0004\bx\u0010yJc\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0(\"\u0004\b\u0000\u0010c2\u0012\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0d2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\bh\u0010zJw\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0(\"\u0004\b\u0000\u0010c2\u0012\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000)0d2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010 2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0002\b\u0003\u0018\u000109H\u0002¢\u0006\u0004\bh\u0010{JS\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0(2\u000e\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0d2\u0006\u0010$\u001a\u00020#2\u0006\u00104\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010A\u001a\u00020@2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b|\u0010}J\u001e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\r0~2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0084\u0001R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u0084\u0001R\u0015\u0010,\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b,\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\u000f\n\u0005\b\u000f\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0088\u0001R\u001a\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\u000f\n\u0005\b\u0015\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0015\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0017\u0010\u008e\u0001R\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0018\u0010\u0084\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\"\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0084\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u0094\u0001R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\u000f\n\u0005\b\u001d\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0015\u0010\u009b\u0001\u001a\u00030\u0098\u00018F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0014\u0010\u009c\u0001\u001a\u00020\n8F¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipeline;", "", "Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "producerSequenceFactory", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListeners", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "requestListener2s", "Lcom/facebook/common/internal/Supplier;", "", "isPrefetchEnabledSupplier", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "bitmapMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "encodedMemoryCache", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "diskCachesStoreSupplier", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "threadHandoffProducerQueue", "suppressBitmapPrefetchingSupplier", "lazyDataSource", "Lcom/facebook/callercontext/CallerContextVerifier;", "callerContextVerifier", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "config", "<init>", "(Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;Ljava/util/Set;Ljava/util/Set;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/cache/CacheKeyFactory;Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/callercontext/CallerContextVerifier;Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "", "generateUniqueFutureId", "()Ljava/lang/String;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageRequest", "callerContext", "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;", "requestLevel", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "getDataSourceSupplier", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;)Lcom/facebook/common/internal/Supplier;", "requestListener", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/common/internal/Supplier;", "uiComponentId", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Lcom/facebook/imagepipeline/listener/RequestListener;Ljava/lang/String;)Lcom/facebook/common/internal/Supplier;", "getEncodedImageDataSourceSupplier", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;)Lcom/facebook/common/internal/Supplier;", "fetchImageFromBitmapCache", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;)Lcom/facebook/datasource/DataSource;", "lowestPermittedRequestLevelOnSubmit", "fetchDecodedImage", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Lcom/facebook/imagepipeline/listener/RequestListener;Ljava/lang/String;)Lcom/facebook/datasource/DataSource;", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/datasource/DataSource;", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;)Lcom/facebook/datasource/DataSource;", "", "extras", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Lcom/facebook/imagepipeline/listener/RequestListener;Ljava/lang/String;Ljava/util/Map;)Lcom/facebook/datasource/DataSource;", "fetchEncodedImage", "Ljava/lang/Void;", "prefetchToBitmapCache", "prefetchToDiskCache", "Lcom/facebook/imagepipeline/common/Priority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/common/Priority;)Lcom/facebook/datasource/DataSource;", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;Lcom/facebook/imagepipeline/common/Priority;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/datasource/DataSource;", "prefetchToEncodedCache", "Landroid/net/Uri;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "", "evictFromMemoryCache", "(Landroid/net/Uri;)V", "evictFromDiskCache", "(Lcom/facebook/imagepipeline/request/ImageRequest;)V", "evictFromCache", "clearMemoryCaches", "()V", "clearDiskCaches", "clearCaches", "isInBitmapMemoryCache", "(Landroid/net/Uri;)Z", "(Lcom/facebook/imagepipeline/request/ImageRequest;)Z", "isInEncodedMemoryCache", "isInDiskCacheSync", "Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;", "cacheChoice", "(Landroid/net/Uri;Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;)Z", "isInDiskCache", "(Landroid/net/Uri;)Lcom/facebook/datasource/DataSource;", "(Lcom/facebook/imagepipeline/request/ImageRequest;)Lcom/facebook/datasource/DataSource;", "getCacheKey", "(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;)Lcom/facebook/cache/common/CacheKey;", "cacheKey", "getCachedImage", "(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/common/references/CloseableReference;", "hasCachedImage", "(Lcom/facebook/cache/common/CacheKey;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/imagepipeline/producers/Producer;", "producerSequence", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "settableProducerContext", "submitFetchRequest", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/datasource/DataSource;", "getRequestListenerForRequest", "(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/imagepipeline/listener/RequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getCombinedRequestListener", "(Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/imagepipeline/listener/RequestListener;", "pause", "resume", "init", "isInDynamicDiskCachesSync", "Lbolts/Continuation;", "intermediateContinuation", "Lbolts/CancellationTokenSource;", "cts", "Lbolts/Task;", "isInDynamicDiskCaches", "(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/cache/common/CacheKey;Lbolts/Continuation;Lbolts/CancellationTokenSource;)Lbolts/Task;", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Ljava/lang/Object;Lcom/facebook/imagepipeline/listener/RequestListener;Ljava/lang/String;)Lcom/facebook/datasource/DataSource;", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Ljava/lang/Object;Lcom/facebook/imagepipeline/listener/RequestListener;Ljava/lang/String;Ljava/util/Map;)Lcom/facebook/datasource/DataSource;", "submitPrefetchRequest", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Ljava/lang/Object;Lcom/facebook/imagepipeline/common/Priority;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/internal/Predicate;", "predicateForUri", "(Landroid/net/Uri;)Lcom/facebook/common/internal/Predicate;", "Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "getProducerSequenceFactory", "()Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListener2", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "getBitmapMemoryCache", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "Ljava/util/concurrent/atomic/AtomicLong;", "idCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "isLazyDataSource", "()Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/callercontext/CallerContextVerifier;", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "getConfig", "()Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "", "getUsedDiskCacheSize", "()J", "usedDiskCacheSize", "isPaused", "()Z", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImagePipeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImagePipeline.kt\ncom/facebook/imagepipeline/core/ImagePipeline\n+ 2 FrescoSystrace.kt\ncom/facebook/imagepipeline/systrace/FrescoSystrace\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1154:1\n40#2,9:1155\n40#2,9:1164\n40#2,9:1180\n40#2,9:1189\n40#2,9:1198\n40#2,9:1207\n216#3,2:1173\n216#3,2:1175\n216#3,2:1178\n1#4:1177\n*S KotlinDebug\n*F\n+ 1 ImagePipeline.kt\ncom/facebook/imagepipeline/core/ImagePipeline\n*L\n418#1:1155,9\n550#1:1164,9\n902#1:1180,9\n967#1:1189,9\n1005#1:1198,9\n1039#1:1207,9\n610#1:1173,2\n638#1:1175,2\n768#1:1178,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ImagePipeline {
    private final MemoryCache bitmapMemoryCache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CallerContextVerifier callerContextVerifier;
    private final ImagePipelineConfigInterface config;
    private final Supplier diskCachesStoreSupplier;
    private final MemoryCache encodedMemoryCache;
    private final AtomicLong idCounter;
    private final Supplier isLazyDataSource;
    private final Supplier isPrefetchEnabledSupplier;
    private final ProducerSequenceFactory producerSequenceFactory;
    private final RequestListener requestListener;
    private final RequestListener2 requestListener2;
    private final Supplier suppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private static final CancellationException NULL_IMAGEREQUEST_EXCEPTION = new CancellationException("ImageRequest is null");
    private static final CancellationException MODIFIED_URL_IS_NULL = new CancellationException("Modified URL is null");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageRequest.CacheChoice.DYNAMIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearMemoryCaches$lambda$3(CacheKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public final void init() {
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        return prefetchToEncodedCache$default(this, imageRequest, obj, null, null, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object obj, @NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToEncodedCache$default(this, imageRequest, obj, priority, null, 8, null);
    }

    private final DataSource submitFetchRequest(Producer producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, RequestListener requestListener, String uiComponentId, Map extras) {
        DataSource dataSourceImmediateFailedDataSource;
        if (!FrescoSystrace.isTracing()) {
            InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
            if (callerContextVerifier != null) {
                callerContextVerifier.verifyCallerContext(callerContext, false);
            }
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener, callerContext, max, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext.putExtras(extras);
                return CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, internalRequestListener);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            InternalRequestListener internalRequestListener2 = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            CallerContextVerifier callerContextVerifier2 = this.callerContextVerifier;
            if (callerContextVerifier2 != null) {
                callerContextVerifier2.verifyCallerContext(callerContext, false);
            }
            try {
                ImageRequest.RequestLevel max2 = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
                Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                SettableProducerContext settableProducerContext2 = new SettableProducerContext(imageRequest, generateUniqueFutureId(), uiComponentId, internalRequestListener2, callerContext, max2, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext2.putExtras(extras);
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext2, internalRequestListener2);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            return dataSourceImmediateFailedDataSource;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    @Nullable
    public final CacheKey getCacheKey(@Nullable ImageRequest imageRequest, @Nullable Object callerContext) {
        CacheKey bitmapCacheKey;
        CacheKey bitmapCacheKey2;
        CacheKey cacheKey = null;
        if (!FrescoSystrace.isTracing()) {
            if (imageRequest == null) {
                return null;
            }
            if (imageRequest.getPostprocessor() != null) {
                bitmapCacheKey2 = this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
            } else {
                bitmapCacheKey2 = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext);
            }
            return bitmapCacheKey2;
        }
        FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        if (imageRequest != null) {
            try {
                if (imageRequest.getPostprocessor() != null) {
                    bitmapCacheKey = this.cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
                } else {
                    bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, callerContext);
                }
                cacheKey = bitmapCacheKey;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        return cacheKey;
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToBitmapCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @Nullable RequestListener requestListener) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Producer<Void> decodedImagePrefetchProducerSequence;
        Producer<Void> decodedImagePrefetchProducerSequence2;
        boolean zBooleanValue = false;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#prefetchToBitmapCache");
            try {
                if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
                    DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                    return dataSourceImmediateFailedDataSource2;
                }
                try {
                } catch (Exception e) {
                    dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e);
                }
                if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                    DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                    Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                    return dataSourceImmediateSuccessfulDataSource;
                }
                if (imageRequest == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Boolean boolShouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
                if (boolShouldDecodePrefetches != null) {
                    if (!boolShouldDecodePrefetches.booleanValue()) {
                        zBooleanValue = true;
                    }
                } else {
                    Object obj = this.suppressBitmapPrefetchingSupplier.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    zBooleanValue = ((Boolean) obj).booleanValue();
                }
                if (zBooleanValue) {
                    decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                } else {
                    decodedImagePrefetchProducerSequence = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                }
                dataSourceImmediateFailedDataSource = submitPrefetchRequest(decodedImagePrefetchProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, Priority.MEDIUM, requestListener);
                return dataSourceImmediateFailedDataSource;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
            DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource3;
        }
        try {
            if (this.config.getExperiments().getPrefetchShortcutEnabled() && isInBitmapMemoryCache(imageRequest)) {
                DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
                return dataSourceImmediateSuccessfulDataSource2;
            }
            if (imageRequest == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Boolean boolShouldDecodePrefetches2 = imageRequest.shouldDecodePrefetches();
            if (boolShouldDecodePrefetches2 != null) {
                if (!boolShouldDecodePrefetches2.booleanValue()) {
                    zBooleanValue = true;
                }
            } else {
                Object obj2 = this.suppressBitmapPrefetchingSupplier.get();
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                zBooleanValue = ((Boolean) obj2).booleanValue();
            }
            if (zBooleanValue) {
                decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                decodedImagePrefetchProducerSequence2 = this.producerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return submitPrefetchRequest(decodedImagePrefetchProducerSequence2, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, Priority.MEDIUM, requestListener);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull Priority priority, @Nullable RequestListener requestListener) {
        DataSource<Void> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (!FrescoSystrace.isTracing()) {
            if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource2, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource2;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource3 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource3, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource3;
            }
            try {
                if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                    return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
                }
                DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource, "immediateSuccessfulDataSource(...)");
                return dataSourceImmediateSuccessfulDataSource;
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#prefetchToEncodedCache");
        try {
            if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
                DataSource<Void> dataSourceImmediateFailedDataSource4 = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource4, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource4;
            }
            if (imageRequest == null) {
                DataSource<Void> dataSourceImmediateFailedDataSource5 = DataSources.immediateFailedDataSource(NULL_IMAGEREQUEST_EXCEPTION);
                Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource5, "immediateFailedDataSource(...)");
                return dataSourceImmediateFailedDataSource5;
            }
            try {
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            if (!this.config.getExperiments().getPrefetchShortcutEnabled() || !isInEncodedMemoryCache(imageRequest)) {
                dataSourceImmediateFailedDataSource = submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
                return dataSourceImmediateFailedDataSource;
            }
            DataSource<Void> dataSourceImmediateSuccessfulDataSource2 = DataSources.immediateSuccessfulDataSource();
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateSuccessfulDataSource2, "immediateSuccessfulDataSource(...)");
            return dataSourceImmediateSuccessfulDataSource2;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    @NotNull
    public final <T> DataSource<CloseableReference<T>> submitFetchRequest(@NotNull Producer<CloseableReference<T>> producerSequence, @NotNull SettableProducerContext settableProducerContext, @Nullable RequestListener requestListener) {
        DataSource<CloseableReference<T>> dataSourceImmediateFailedDataSource;
        Intrinsics.checkNotNullParameter(producerSequence, "producerSequence");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
            try {
                try {
                    dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
                } catch (Exception e) {
                    dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e);
                }
                return dataSourceImmediateFailedDataSource;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        try {
            return CloseableProducerToDataSourceAdapter.create(producerSequence, settableProducerContext, new InternalRequestListener(requestListener, this.requestListener2));
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public ImagePipeline(@NotNull ProducerSequenceFactory producerSequenceFactory, @NotNull Set<? extends RequestListener> requestListeners, @NotNull Set<? extends RequestListener2> requestListener2s, @NotNull Supplier<Boolean> isPrefetchEnabledSupplier, @NotNull MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, @NotNull MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, @NotNull Supplier<DiskCachesStore> diskCachesStoreSupplier, @NotNull CacheKeyFactory cacheKeyFactory, @NotNull ThreadHandoffProducerQueue threadHandoffProducerQueue, @NotNull Supplier<Boolean> suppressBitmapPrefetchingSupplier, @NotNull Supplier<Boolean> lazyDataSource, @Nullable CallerContextVerifier callerContextVerifier, @NotNull ImagePipelineConfigInterface config) {
        Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        Intrinsics.checkNotNullParameter(config, "config");
        this.producerSequenceFactory = producerSequenceFactory;
        this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.requestListener = new ForwardingRequestListener((Set<RequestListener>) requestListeners);
        this.requestListener2 = new ForwardingRequestListener2(requestListener2s);
        this.idCounter = new AtomicLong();
        this.bitmapMemoryCache = bitmapMemoryCache;
        this.encodedMemoryCache = encodedMemoryCache;
        this.cacheKeyFactory = cacheKeyFactory;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
        this.isLazyDataSource = lazyDataSource;
        this.callerContextVerifier = callerContextVerifier;
        this.config = config;
    }

    @NotNull
    public final ProducerSequenceFactory getProducerSequenceFactory() {
        return this.producerSequenceFactory;
    }

    @NotNull
    public final MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.bitmapMemoryCache;
    }

    @NotNull
    public final CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    @NotNull
    public final Supplier<Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    @NotNull
    public final ImagePipelineConfigInterface getConfig() {
        return this.config;
    }

    @NotNull
    public final String generateUniqueFutureId() {
        return String.valueOf(this.idCounter.getAndIncrement());
    }

    @NotNull
    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object callerContext, @Nullable final ImageRequest.RequestLevel requestLevel) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, callerContext, requestLevel, null, null, 24, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add(ReactNativeBlobUtilConst.DATA_ENCODE_URI, imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    @NotNull
    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object callerContext, @Nullable final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.fetchDecodedImage$default(ImagePipeline.this, imageRequest, callerContext, requestLevel, requestListener, null, 16, null);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add(ReactNativeBlobUtilConst.DATA_ENCODE_URI, imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    @NotNull
    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object callerContext, @Nullable final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener, @Nullable final String uiComponentId) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getDataSourceSupplier.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, callerContext, requestLevel, requestListener, uiComponentId);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add(ReactNativeBlobUtilConst.DATA_ENCODE_URI, imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    @NotNull
    public final Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(@NotNull final ImageRequest imageRequest, @Nullable final Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.getEncodedImageDataSourceSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, callerContext);
            }

            public String toString() {
                String string = Objects.toStringHelper(this).add(ReactNativeBlobUtilConst.DATA_ENCODE_URI, imageRequest.getSourceUri()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        };
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(@NotNull ImageRequest imageRequest, @Nullable Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchDecodedImage(imageRequest, callerContext, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public static /* synthetic */ DataSource fetchDecodedImage$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str, int i, Object obj2) {
        return imagePipeline.fetchDecodedImage(imageRequest, obj, (i & 4) != 0 ? null : requestLevel, (i & 8) != 0 ? null : requestListener, (i & 16) != 0 ? null : str);
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @Nullable ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, @Nullable RequestListener requestListener, @Nullable String uiComponentId) {
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            Producer<CloseableReference<CloseableImage>> decodedImageProducerSequence = this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest);
            if (lowestPermittedRequestLevelOnSubmit == null) {
                lowestPermittedRequestLevelOnSubmit = ImageRequest.RequestLevel.FULL_FETCH;
            }
            return submitFetchRequest(decodedImageProducerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object callerContext) {
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, null, null, 24, null);
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        return fetchDecodedImage$default(this, imageRequest, callerContext, null, requestListener, null, 16, null);
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        return fetchDecodedImage$default(this, imageRequest, callerContext, lowestPermittedRequestLevelOnSubmit, null, null, 16, null);
    }

    @NotNull
    public final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, @Nullable RequestListener requestListener, @Nullable String uiComponentId, @Nullable Map<String, ?> extras) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        if (imageRequest == null) {
            DataSource<CloseableReference<CloseableImage>> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            return submitFetchRequest(this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, extras);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    @NotNull
    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(@NotNull ImageRequest imageRequest, @Nullable Object callerContext) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchEncodedImage(imageRequest, callerContext, null);
    }

    @NotNull
    public final DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(@NotNull ImageRequest imageRequest, @Nullable Object callerContext, @Nullable RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getSourceUri() == null) {
            throw new IllegalStateException("Required value was null.");
        }
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.producerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, requestListener, null, null);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToBitmapCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext) {
        return prefetchToBitmapCache(imageRequest, callerContext, null);
    }

    @NotNull
    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @Nullable RequestListener requestListener) {
        return prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, requestListener);
    }

    @NotNull
    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext) {
        return prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, null);
    }

    @NotNull
    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return prefetchToDiskCache(imageRequest, callerContext, priority, null);
    }

    @JvmOverloads
    @NotNull
    public final DataSource<Void> prefetchToDiskCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @NotNull Priority priority, @Nullable RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (imageRequest == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(new NullPointerException("imageRequest is null"));
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
        try {
            return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, callerContext, priority, requestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    @NotNull
    public final DataSource<Void> prefetchToEncodedCache(@Nullable ImageRequest imageRequest, @Nullable Object callerContext, @Nullable RequestListener requestListener) {
        return prefetchToEncodedCache(imageRequest, callerContext, Priority.MEDIUM, requestListener);
    }

    public static /* synthetic */ DataSource prefetchToEncodedCache$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, Priority priority, RequestListener requestListener, int i, Object obj2) {
        if ((i & 4) != 0) {
            priority = Priority.MEDIUM;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        return imagePipeline.prefetchToEncodedCache(imageRequest, obj, priority, requestListener);
    }

    public final void evictFromMemoryCache(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Predicate predicatePredicateForUri = predicateForUri(uri);
        this.bitmapMemoryCache.removeAll(predicatePredicateForUri);
        this.encodedMemoryCache.removeAll(predicatePredicateForUri);
    }

    public final void evictFromDiskCache(@Nullable Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri == null) {
            throw new IllegalStateException("Required value was null.");
        }
        evictFromDiskCache(imageRequestFromUri);
    }

    public final void evictFromDiskCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        BufferedDiskCache mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
        Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.remove(encodedCacheKey);
        diskCachesStore.getSmallImageBufferedDiskCache().remove(encodedCacheKey);
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(encodedCacheKey);
        }
    }

    public final void evictFromCache(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public final void clearMemoryCaches() {
        Predicate predicate = new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda5
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.clearMemoryCaches$lambda$3((CacheKey) obj);
            }
        };
        this.bitmapMemoryCache.removeAll(predicate);
        this.encodedMemoryCache.removeAll(predicate);
    }

    public final void clearDiskCaches() {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        diskCachesStore.getMainBufferedDiskCache().clearAll();
        diskCachesStore.getSmallImageBufferedDiskCache().clearAll();
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clearAll();
        }
    }

    public final long getUsedDiskCacheSize() {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        long size = diskCachesStore.getMainBufferedDiskCache().getSize() + diskCachesStore.getSmallImageBufferedDiskCache().getSize();
        Collection<BufferedDiskCache> collectionValues = diskCachesStore.getDynamicBufferedDiskCaches().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        long size2 = 0;
        while (it.hasNext()) {
            size2 += ((BufferedDiskCache) it.next()).getSize();
        }
        return size + size2;
    }

    public final void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public final boolean isInBitmapMemoryCache(@Nullable Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInBitmapMemoryCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CacheKey bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, null);
        MemoryCache memoryCache = this.bitmapMemoryCache;
        Intrinsics.checkNotNull(bitmapCacheKey);
        CloseableReference closeableReference = memoryCache.get(bitmapCacheKey);
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
        }
    }

    public final boolean isInEncodedMemoryCache(@Nullable Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.encodedMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInEncodedMemoryCache(@Nullable ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        MemoryCache memoryCache = this.encodedMemoryCache;
        Intrinsics.checkNotNull(encodedCacheKey);
        CloseableReference closeableReference = memoryCache.get(encodedCacheKey);
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
        }
    }

    public final boolean isInDiskCacheSync(@Nullable Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DYNAMIC);
    }

    public final boolean isInDiskCacheSync(@Nullable Uri uri, @Nullable ImageRequest.CacheChoice cacheChoice) throws NumberFormatException {
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build();
        Intrinsics.checkNotNull(imageRequestBuild);
        return isInDiskCacheSync(imageRequestBuild);
    }

    private final boolean isInDynamicDiskCachesSync(ImageRequest imageRequest) {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        String diskCacheId = imageRequest.getDiskCacheId();
        if (diskCacheId == null) {
            Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
            while (it.hasNext()) {
                BufferedDiskCache value = it.next().getValue();
                Intrinsics.checkNotNull(encodedCacheKey);
                if (value.diskCheckSync(encodedCacheKey)) {
                    return true;
                }
            }
            return false;
        }
        BufferedDiskCache bufferedDiskCache = diskCachesStore.getDynamicBufferedDiskCaches().get(diskCacheId);
        if (bufferedDiskCache == null) {
            return false;
        }
        Intrinsics.checkNotNull(encodedCacheKey);
        return bufferedDiskCache.diskCheckSync(encodedCacheKey);
    }

    public final boolean isInDiskCacheSync(@NotNull ImageRequest imageRequest) {
        boolean zDiskCheckSync;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        ImageRequest.CacheChoice cacheChoice = imageRequest.getCacheChoice();
        Intrinsics.checkNotNullExpressionValue(cacheChoice, "getCacheChoice(...)");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[cacheChoice.ordinal()];
            if (i == 1) {
                BufferedDiskCache mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = mainBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else if (i == 2) {
                BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = smallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                zDiskCheckSync = isInDynamicDiskCachesSync(imageRequest);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zDiskCheckSync;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    @NotNull
    public final DataSource<Boolean> isInDiskCache(@Nullable Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri != null) {
            return isInDiskCache(imageRequestFromUri);
        }
        throw new IllegalStateException("Required value was null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, bolts.Task] */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, bolts.Task, java.lang.Object] */
    private final Task isInDynamicDiskCaches(ImageRequest imageRequest, CacheKey cacheKey, final Continuation intermediateContinuation, final CancellationTokenSource cts) {
        Task<Boolean> taskContains;
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        String diskCacheId = imageRequest != null ? imageRequest.getDiskCacheId() : null;
        if (diskCacheId != null) {
            BufferedDiskCache bufferedDiskCache = diskCachesStore.getDynamicBufferedDiskCaches().get(diskCacheId);
            if (bufferedDiskCache != null && (taskContains = bufferedDiskCache.contains(cacheKey)) != null) {
                return taskContains;
            }
            Task taskForResult = Task.forResult(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
            return taskForResult;
        }
        if (diskCachesStore.getDynamicBufferedDiskCaches().size() == 0) {
            Task taskForResult2 = Task.forResult(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(taskForResult2, "forResult(...)");
            return taskForResult2;
        }
        Iterator<Map.Entry<String, BufferedDiskCache>> it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
        ?? ForResult = Task.forResult(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(ForResult, "forResult(...)");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ForResult;
        Task task = ForResult;
        while (it.hasNext()) {
            objectRef.element = it.next().getValue().contains(cacheKey);
            task.continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline.isInDynamicDiskCaches.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // bolts.Continuation
                public final Task then(Task task2) {
                    if (!task2.isCancelled() && !task2.isFaulted() && ((Boolean) task2.getResult()).booleanValue()) {
                        cts.cancel();
                        return Task.forResult(Boolean.TRUE).continueWith(intermediateContinuation);
                    }
                    if (task2.isCancelled()) {
                        return Task.forResult(Boolean.FALSE);
                    }
                    return (Task) objectRef.element;
                }
            }, cts.getToken());
            task = (Task) objectRef.element;
        }
        return task;
    }

    @NotNull
    public final DataSource<Boolean> isInDiskCache(@Nullable final ImageRequest imageRequest) {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        final DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        final CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        Continuation continuation = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda0
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$7(simpleDataSourceCreate, task);
            }
        };
        final Continuation continuation2 = new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda1
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$8(simpleDataSourceCreate, task);
            }
        };
        BufferedDiskCache mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
        Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.contains(encodedCacheKey).continueWithTask(new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda2
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$9(diskCachesStore, encodedCacheKey, task);
            }
        }).continueWithTask((Continuation<TContinuationResult, Task<TContinuationResult>>) new Continuation() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda3
            @Override // bolts.Continuation
            public final Object then(Task task) {
                return ImagePipeline.isInDiskCache$lambda$10(this.f$0, imageRequest, encodedCacheKey, continuation2, cancellationTokenSource, task);
            }
        }, cancellationTokenSource.getToken()).continueWith(continuation);
        Intrinsics.checkNotNull(simpleDataSourceCreate);
        return simpleDataSourceCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Void isInDiskCache$lambda$7(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        boolean z = false;
        if ((bool != null ? bool.booleanValue() : false) || (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue())) {
            z = true;
        }
        simpleDataSource.setResult(Boolean.valueOf(z));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Void isInDiskCache$lambda$8(SimpleDataSource simpleDataSource, Task task) {
        Boolean bool = (Boolean) simpleDataSource.getResult();
        simpleDataSource.setResult(Boolean.valueOf((bool != null ? bool.booleanValue() : false) || !(task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue())), false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task isInDiskCache$lambda$9(DiskCachesStore diskCachesStore, CacheKey cacheKey, Task task) {
        Intrinsics.checkNotNullParameter(diskCachesStore, "$diskCachesStore");
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(Boolean.TRUE);
        }
        BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
        Intrinsics.checkNotNull(cacheKey);
        return smallImageBufferedDiskCache.contains(cacheKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task isInDiskCache$lambda$10(ImagePipeline this$0, ImageRequest imageRequest, CacheKey cacheKey, Continuation intermediateContinuation, CancellationTokenSource cts, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intermediateContinuation, "$intermediateContinuation");
        Intrinsics.checkNotNullParameter(cts, "$cts");
        if (!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()) {
            return Task.forResult(Boolean.TRUE);
        }
        Intrinsics.checkNotNull(cacheKey);
        return this$0.isInDynamicDiskCaches(imageRequest, cacheKey, intermediateContinuation, cts);
    }

    @Nullable
    public final CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = this.bitmapMemoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public final boolean hasCachedImage(@Nullable CacheKey cacheKey) {
        if (cacheKey == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains((MemoryCache) cacheKey);
    }

    private final DataSource submitFetchRequest(Producer producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, RequestListener requestListener, String uiComponentId) {
        return submitFetchRequest(producerSequence, imageRequest, lowestPermittedRequestLevelOnSubmit, callerContext, requestListener, uiComponentId, null);
    }

    private final DataSource submitPrefetchRequest(Producer producerSequence, ImageRequest imageRequest, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit, Object callerContext, Priority priority, RequestListener requestListener) throws NumberFormatException {
        ImageRequest imageRequestBuild = imageRequest;
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
        CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(callerContext, true);
        }
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        Uri uriModifyPrefetchUri = UriModifier.INSTANCE.modifyPrefetchUri(sourceUri, callerContext);
        if (uriModifyPrefetchUri == null) {
            DataSource dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(MODIFIED_URL_IS_NULL);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (!Intrinsics.areEqual(sourceUri, uriModifyPrefetchUri)) {
            imageRequestBuild = ImageRequestBuilder.fromRequest(imageRequest).setSource(uriModifyPrefetchUri).build();
        }
        try {
            ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequestBuild.getLowestPermittedRequestLevel(), lowestPermittedRequestLevelOnSubmit);
            Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
            String strGenerateUniqueFutureId = generateUniqueFutureId();
            ImagePipelineExperiments experiments = this.config.getExperiments();
            return ProducerToDataSourceAdapter.INSTANCE.create(producerSequence, new SettableProducerContext(imageRequestBuild, strGenerateUniqueFutureId, internalRequestListener, callerContext, max, true, experiments != null && experiments.getAllowProgressiveOnPrefetch() && imageRequestBuild.getProgressiveRenderingEnabled(), priority, this.config), internalRequestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    @NotNull
    public final RequestListener getRequestListenerForRequest(@Nullable ImageRequest imageRequest, @Nullable RequestListener requestListener) {
        if (imageRequest == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.requestListener;
            }
            return new ForwardingRequestListener(this.requestListener, imageRequest.getRequestListener());
        }
        if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.requestListener, requestListener);
        }
        return new ForwardingRequestListener(this.requestListener, requestListener, imageRequest.getRequestListener());
    }

    @NotNull
    public final RequestListener getCombinedRequestListener(@Nullable RequestListener listener) {
        return listener != null ? new ForwardingRequestListener(this.requestListener, listener) : this.requestListener;
    }

    private final Predicate predicateForUri(final Uri uri) {
        return new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda4
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.predicateForUri$lambda$16(uri, (CacheKey) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean predicateForUri$lambda$16(Uri uri, CacheKey key) {
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullParameter(key, "key");
        return key.containsUri(uri);
    }

    public final void pause() {
        this.threadHandoffProducerQueue.startQueueing();
    }

    public final void resume() {
        this.threadHandoffProducerQueue.stopQueuing();
    }

    public final boolean isPaused() {
        return this.threadHandoffProducerQueue.isQueueing();
    }
}
