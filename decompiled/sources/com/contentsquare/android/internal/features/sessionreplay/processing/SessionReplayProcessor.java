package com.contentsquare.android.internal.features.sessionreplay.processing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.MainThread;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.contentsquare.android.api.bridge.flutter.FlutterInterface;
import com.contentsquare.android.api.bridge.xpf.BridgeManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.HeapInterface;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.android.sdk.AbstractC0707i6;
import com.contentsquare.android.sdk.AbstractRunnableC0823u3;
import com.contentsquare.android.sdk.C0622a1;
import com.contentsquare.android.sdk.C0633b2;
import com.contentsquare.android.sdk.C0643c2;
import com.contentsquare.android.sdk.C0644c3;
import com.contentsquare.android.sdk.C0656d5;
import com.contentsquare.android.sdk.C0666e5;
import com.contentsquare.android.sdk.C0697h6;
import com.contentsquare.android.sdk.C0715j4;
import com.contentsquare.android.sdk.C0717j6;
import com.contentsquare.android.sdk.C0732l1;
import com.contentsquare.android.sdk.C0742m1;
import com.contentsquare.android.sdk.C0751n0;
import com.contentsquare.android.sdk.C0775p4;
import com.contentsquare.android.sdk.C0782q1;
import com.contentsquare.android.sdk.C0785q4;
import com.contentsquare.android.sdk.C0791r1;
import com.contentsquare.android.sdk.C0819u;
import com.contentsquare.android.sdk.C0824u4;
import com.contentsquare.android.sdk.C0829v;
import com.contentsquare.android.sdk.C0831v1;
import com.contentsquare.android.sdk.C0837v7;
import com.contentsquare.android.sdk.C0838w;
import com.contentsquare.android.sdk.C0840w1;
import com.contentsquare.android.sdk.C0847x;
import com.contentsquare.android.sdk.C0848x0;
import com.contentsquare.android.sdk.C0850x2;
import com.contentsquare.android.sdk.C0854x6;
import com.contentsquare.android.sdk.C0855x7;
import com.contentsquare.android.sdk.C0856y;
import com.contentsquare.android.sdk.D5;
import com.contentsquare.android.sdk.E5;
import com.contentsquare.android.sdk.EnumC0677f6;
import com.contentsquare.android.sdk.G0;
import com.contentsquare.android.sdk.H1;
import com.contentsquare.android.sdk.I;
import com.contentsquare.android.sdk.I2;
import com.contentsquare.android.sdk.I6;
import com.contentsquare.android.sdk.InterfaceC0789q8;
import com.contentsquare.android.sdk.InterfaceRunnableC0741m0;
import com.contentsquare.android.sdk.InterfaceRunnableC0841w2;
import com.contentsquare.android.sdk.J1;
import com.contentsquare.android.sdk.J2;
import com.contentsquare.android.sdk.J4;
import com.contentsquare.android.sdk.J7;
import com.contentsquare.android.sdk.K5;
import com.contentsquare.android.sdk.L7;
import com.contentsquare.android.sdk.M2;
import com.contentsquare.android.sdk.N4;
import com.contentsquare.android.sdk.N5;
import com.contentsquare.android.sdk.O5;
import com.contentsquare.android.sdk.P5;
import com.contentsquare.android.sdk.Q;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.android.sdk.R3;
import com.contentsquare.android.sdk.R6;
import com.contentsquare.android.sdk.S;
import com.contentsquare.android.sdk.T4;
import com.contentsquare.android.sdk.U;
import com.contentsquare.android.sdk.U1;
import com.contentsquare.android.sdk.ViewTreeObserverOnPreDrawListenerC0833v3;
import com.contentsquare.android.sdk.W;
import com.contentsquare.android.sdk.Z1;
import com.contentsquare.android.sdk.Z2;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.urbanairship.util.PendingIntentCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ¼\u00012\u00020\u00012\u00020\u0002:\u0002½\u0001B\u0091\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010=\u001a\u00020<\u0012\b\b\u0002\u0010?\u001a\u00020>\u0012\b\b\u0002\u0010A\u001a\u00020@\u0012\b\b\u0002\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\b\b\u0002\u0010G\u001a\u00020F\u0012\b\b\u0002\u0010I\u001a\u00020H\u0012\b\b\u0002\u0010K\u001a\u00020J\u0012\b\b\u0002\u0010M\u001a\u00020L\u0012\b\b\u0002\u0010O\u001a\u00020N\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010S\u001a\u00020R\u0012\b\b\u0002\u0010U\u001a\u00020T\u0012\b\b\u0002\u0010W\u001a\u00020V¢\u0006\u0004\bX\u0010YJ\u000f\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b[\u0010\\J=\u0010g\u001a\u00020Z2\u0006\u0010^\u001a\u00020]2\u0006\u0010`\u001a\u00020_2\u0006\u0010b\u001a\u00020a2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u00192\u0006\u0010f\u001a\u00020eH\u0003¢\u0006\u0004\bg\u0010hJE\u0010n\u001a\u00020Z2\u0006\u0010i\u001a\u00020_2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010j2\u0006\u0010m\u001a\u00020a2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u00192\u0006\u0010f\u001a\u00020eH\u0003¢\u0006\u0004\bn\u0010oJ%\u0010p\u001a\u00020Z2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u00192\u0006\u0010i\u001a\u00020_H\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010s\u001a\u00020r2\u0006\u0010m\u001a\u00020aH\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020Z2\u0006\u0010m\u001a\u00020aH\u0003¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020ZH\u0002¢\u0006\u0004\bw\u0010\\J\u0013\u0010x\u001a\u00020Z*\u00020_H\u0002¢\u0006\u0004\bx\u0010yJ\u0015\u0010{\u001a\u00020Z2\u0006\u0010z\u001a\u00020e¢\u0006\u0004\b{\u0010|J\r\u0010}\u001a\u00020Z¢\u0006\u0004\b}\u0010\\J\u0017\u0010~\u001a\u00020Z2\u0006\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\b~\u0010vJ\u0018\u0010\u007f\u001a\u00020Z2\u0006\u0010^\u001a\u00020]H\u0017¢\u0006\u0005\b\u007f\u0010\u0080\u0001JR\u0010\u0083\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020_2\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010j2\u0006\u0010m\u001a\u00020a2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u00192\u0006\u0010f\u001a\u00020eH\u0007¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001JM\u0010\u0086\u0001\u001a\u00020Z2\u0006\u0010i\u001a\u00020_2\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010k2\u0006\u0010m\u001a\u00020a2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0\u00192\u0006\u0010f\u001a\u00020eH\u0007¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0089\u0001\u001a\u00020Z2\u0007\u0010\u0088\u0001\u001a\u00020rH\u0007¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001a\u0010\u008d\u0001\u001a\u00020Z2\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0011\u0010\u008f\u0001\u001a\u00020ZH\u0007¢\u0006\u0005\b\u008f\u0001\u0010\\R\u0015\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0004\u0010\u0090\u0001R\u0015\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010\u0091\u0001R\u0015\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\b\u0010\u0092\u0001R\u0015\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010\u0093\u0001R\u0015\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0010\u0010\u0094\u0001R\u0015\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010\u0095\u0001R\u0015\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0014\u0010\u0096\u0001R\u0015\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0016\u0010\u0097\u0001R\u0015\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0018\u0010\u0098\u0001R\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001b\u0010\u0099\u0001R\u0015\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001d\u0010\u009a\u0001R\u0015\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001f\u0010\u009b\u0001R\u0015\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b!\u0010\u009c\u0001R\u0015\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b#\u0010\u009d\u0001R\u0015\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b%\u0010\u009e\u0001R\u0015\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b'\u0010\u009f\u0001R\u0015\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b)\u0010 \u0001R\u0017\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b-\u0010¡\u0001R\u0017\u0010/\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b/\u0010¢\u0001R\u0015\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b1\u0010£\u0001R\u0015\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b3\u0010¤\u0001R\u0015\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b5\u0010¥\u0001R\u0015\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b7\u0010¦\u0001R\u0015\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b9\u0010§\u0001R\u0015\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b;\u0010¨\u0001R\u0015\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b=\u0010©\u0001R\u0015\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b?\u0010ª\u0001R\u0015\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bC\u0010«\u0001R\u0015\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bG\u0010¬\u0001R\u0015\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bK\u0010\u00ad\u0001R\u0015\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bM\u0010®\u0001R\u0015\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bO\u0010¯\u0001R\u0015\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bQ\u0010°\u0001R\u0015\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bS\u0010±\u0001R\u0015\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bU\u0010²\u0001R\u0015\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bW\u0010³\u0001R\u0018\u0010µ\u0001\u001a\u00030´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u00020e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/contentsquare/android/internal/features/sessionreplay/processing/SessionReplayProcessor;", "Lcom/contentsquare/android/sdk/u3;", "Lcom/contentsquare/android/sdk/O5;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/contentsquare/android/sdk/D5;", "sessionReplayConfiguration", "Lcom/contentsquare/android/sdk/N4;", "samplingMode", "Lcom/contentsquare/android/sdk/Z2;", "maskingParameter", "Lcom/contentsquare/android/core/system/DeviceInfo;", ErrorLogHelper.DEVICE_INFO_FILE, "Lcom/contentsquare/android/sdk/v3;", "onDrawObserver", "Lcom/contentsquare/android/sdk/M2;", "liveActivityProvider", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/contentsquare/android/sdk/j4;", "qualitySettings", "Lcom/contentsquare/android/sdk/U;", "batchStorageProcessor", "Lcom/contentsquare/android/sdk/H1;", "eventsProvidersManager", "", "Lcom/contentsquare/android/sdk/R6;", "stoppableEventProviders", "Lcom/contentsquare/android/sdk/q8;", "viewMutationEventProvider", "Lcom/contentsquare/android/sdk/I6;", "startStopEventProvider", "Lcom/contentsquare/android/sdk/I;", "appStateEventProvider", "Lcom/contentsquare/android/sdk/P5;", "sessionStateManager", "Landroid/os/Handler;", "mainThreadHandler", "Lcom/contentsquare/android/sdk/E5;", "lifecycleCallbacks", "Lcom/contentsquare/android/sdk/x7;", "throttleOperator", "Lcom/contentsquare/android/sdk/j6;", "srQuickLink", "Lcom/contentsquare/android/sdk/x;", "animationSupervisor", "Lcom/contentsquare/android/sdk/v;", "animationCompletionHandler", "Lcom/contentsquare/android/sdk/U1;", "forceMaskingResolver", "Lcom/contentsquare/android/sdk/u;", "androidViewToViewLightConverter", "Lcom/contentsquare/android/sdk/T4;", "screenCapturer", "Lcom/contentsquare/android/sdk/u4;", "recyclableViewAppearance", "Lcom/contentsquare/android/api/bridge/xpf/BridgeManager;", "bridgeManager", "Lcom/contentsquare/android/sdk/J1;", "eventsToBatchProcessor", "Lcom/contentsquare/android/sdk/q4;", "recordingTypeProvider", "Lcom/contentsquare/android/sdk/p4;", "recordingStartTimeProvider", "Lcom/contentsquare/android/sdk/J2;", "lastEventTimeTracker", "Lcom/contentsquare/android/sdk/I2;", "lastEventTimeProvider", "Lcom/contentsquare/android/sdk/q1;", "etrScreenEventTracker", "Lcom/contentsquare/android/sdk/r1;", "etrScreenEventUrlProvider", "Lcom/contentsquare/android/sdk/v1;", "etrSessionEventTracker", "Lcom/contentsquare/android/sdk/w1;", "etrSessionEventUrlProvider", "Lcom/contentsquare/android/sdk/x6;", "urlGenerator", "Lcom/contentsquare/android/sdk/S;", "batchDispatcher", "Lcom/contentsquare/android/sdk/e5;", "screenViewEventProvider", "Lcom/contentsquare/android/sdk/c2;", "gestureEventViewMapper", "Lcom/contentsquare/android/core/features/logging/Logger;", "logger", "Lcom/contentsquare/android/sdk/K5;", "sessionReplayTreeLogger", "<init>", "(Landroid/app/Application;Lcom/contentsquare/android/sdk/D5;Lcom/contentsquare/android/sdk/N4;Lcom/contentsquare/android/sdk/Z2;Lcom/contentsquare/android/core/system/DeviceInfo;Lcom/contentsquare/android/sdk/v3;Lcom/contentsquare/android/sdk/M2;Landroidx/lifecycle/LifecycleOwner;Lcom/contentsquare/android/sdk/j4;Lcom/contentsquare/android/sdk/U;Lcom/contentsquare/android/sdk/H1;Ljava/util/List;Lcom/contentsquare/android/sdk/q8;Lcom/contentsquare/android/sdk/I6;Lcom/contentsquare/android/sdk/I;Lcom/contentsquare/android/sdk/P5;Landroid/os/Handler;Lcom/contentsquare/android/sdk/E5;Lcom/contentsquare/android/sdk/x7;Lcom/contentsquare/android/sdk/j6;Lcom/contentsquare/android/sdk/x;Lcom/contentsquare/android/sdk/v;Lcom/contentsquare/android/sdk/U1;Lcom/contentsquare/android/sdk/u;Lcom/contentsquare/android/sdk/T4;Lcom/contentsquare/android/sdk/u4;Lcom/contentsquare/android/api/bridge/xpf/BridgeManager;Lcom/contentsquare/android/sdk/J1;Lcom/contentsquare/android/sdk/q4;Lcom/contentsquare/android/sdk/p4;Lcom/contentsquare/android/sdk/J2;Lcom/contentsquare/android/sdk/I2;Lcom/contentsquare/android/sdk/q1;Lcom/contentsquare/android/sdk/r1;Lcom/contentsquare/android/sdk/v1;Lcom/contentsquare/android/sdk/w1;Lcom/contentsquare/android/sdk/x6;Lcom/contentsquare/android/sdk/S;Lcom/contentsquare/android/sdk/e5;Lcom/contentsquare/android/sdk/c2;Lcom/contentsquare/android/core/features/logging/Logger;Lcom/contentsquare/android/sdk/K5;)V", "", "triggerSingleFrameProcessingManually", "()V", "Landroid/view/Window;", "window", "Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;", "currentViewLight", "Lcom/contentsquare/android/sdk/N5;", "currentSessionState", "Lcom/contentsquare/android/sdk/i6;", "srEvents", "", "shouldForceMasking", "captureAndProcessScreen", "(Landroid/view/Window;Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;Lcom/contentsquare/android/sdk/N5;Ljava/util/List;Z)V", "viewLight", "Lcom/contentsquare/android/sdk/a1;", "Lcom/contentsquare/android/sdk/T4$d;", "screenCaptureDeferredResult", "sessionState", "completeUiThreadProcess", "(Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;Lcom/contentsquare/android/sdk/a1;Lcom/contentsquare/android/sdk/N5;Ljava/util/List;Z)V", "mapGestureEventsToViewLight", "(Ljava/util/List;Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;)V", "Lcom/contentsquare/android/sdk/Q;", "createNewBatch", "(Lcom/contentsquare/android/sdk/N5;)Lcom/contentsquare/android/sdk/Q;", "flushCurrentEventBatch", "(Lcom/contentsquare/android/sdk/N5;)V", "startSessionReplayInFlutterIfNeeded", "setForceMaskingRecursively", "(Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;)V", "isNewSession", "startProcess", "(Z)V", "stopProcess", "onPreScreenNumberChange", "onDraw", "(Landroid/view/Window;)V", "", "timestamp", "switchToWorkerThread", "(Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;JLcom/contentsquare/android/sdk/a1;Lcom/contentsquare/android/sdk/N5;Ljava/util/List;Z)V", "screenCaptureResult", "createSrEvents", "(Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;JLcom/contentsquare/android/sdk/T4$d;Lcom/contentsquare/android/sdk/N5;Ljava/util/List;Z)V", "batchToStore", "storeAndSendSrEvents", "(Lcom/contentsquare/android/sdk/Q;)V", "Lcom/contentsquare/android/sdk/G0;", "crashEvent", "addCrashAndSaveToDisk", "(Lcom/contentsquare/android/sdk/G0;)V", "flushCurrentEventBatchAsync", "Landroid/app/Application;", "Lcom/contentsquare/android/sdk/D5;", "Lcom/contentsquare/android/sdk/N4;", "Lcom/contentsquare/android/sdk/v3;", "Lcom/contentsquare/android/sdk/M2;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/contentsquare/android/sdk/j4;", "Lcom/contentsquare/android/sdk/U;", "Lcom/contentsquare/android/sdk/H1;", "Ljava/util/List;", "Lcom/contentsquare/android/sdk/q8;", "Lcom/contentsquare/android/sdk/I6;", "Lcom/contentsquare/android/sdk/I;", "Lcom/contentsquare/android/sdk/P5;", "Landroid/os/Handler;", "Lcom/contentsquare/android/sdk/E5;", "Lcom/contentsquare/android/sdk/x7;", "Lcom/contentsquare/android/sdk/x;", "Lcom/contentsquare/android/sdk/v;", "Lcom/contentsquare/android/sdk/U1;", "Lcom/contentsquare/android/sdk/u;", "Lcom/contentsquare/android/sdk/T4;", "Lcom/contentsquare/android/sdk/u4;", "Lcom/contentsquare/android/api/bridge/xpf/BridgeManager;", "Lcom/contentsquare/android/sdk/J1;", "Lcom/contentsquare/android/sdk/q4;", "Lcom/contentsquare/android/sdk/p4;", "Lcom/contentsquare/android/sdk/I2;", "Lcom/contentsquare/android/sdk/r1;", "Lcom/contentsquare/android/sdk/w1;", "Lcom/contentsquare/android/sdk/x6;", "Lcom/contentsquare/android/sdk/S;", "Lcom/contentsquare/android/sdk/e5;", "Lcom/contentsquare/android/sdk/c2;", "Lcom/contentsquare/android/core/features/logging/Logger;", "Lcom/contentsquare/android/sdk/K5;", "", "batchModificationLock", "Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "isProcessStarted", "Z", "Companion", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSessionReplayProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionReplayProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SessionReplayProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,571:1\n1855#2,2:572\n800#2,11:574\n1855#2,2:585\n*S KotlinDebug\n*F\n+ 1 SessionReplayProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/SessionReplayProcessor\n*L\n269#1:572,2\n487#1:574,11\n566#1:585,2\n*E\n"})
/* loaded from: classes2.dex */
public final class SessionReplayProcessor extends AbstractRunnableC0823u3 implements O5 {
    private static final long SCREEN_CAPTURE_TIMEOUT_MILLIS = 1000;

    @NotNull
    private final C0819u androidViewToViewLightConverter;

    @Nullable
    private final C0829v animationCompletionHandler;

    @Nullable
    private final C0847x animationSupervisor;

    @NotNull
    private final I appStateEventProvider;

    @NotNull
    private final Application application;

    @NotNull
    private final S batchDispatcher;

    @NotNull
    private final Object batchModificationLock;

    @NotNull
    private final U batchStorageProcessor;

    @NotNull
    private final BridgeManager bridgeManager;

    @NotNull
    private final C0791r1 etrScreenEventUrlProvider;

    @NotNull
    private final C0840w1 etrSessionEventUrlProvider;

    @NotNull
    private final H1 eventsProvidersManager;

    @NotNull
    private final J1 eventsToBatchProcessor;

    @NotNull
    private final U1 forceMaskingResolver;

    @NotNull
    private final C0643c2 gestureEventViewMapper;
    private boolean isProcessStarted;

    @NotNull
    private final I2 lastEventTimeProvider;

    @NotNull
    private final E5 lifecycleCallbacks;

    @NotNull
    private final LifecycleObserver lifecycleObserver;

    @NotNull
    private final LifecycleOwner lifecycleOwner;

    @NotNull
    private final M2 liveActivityProvider;

    @NotNull
    private final Logger logger;

    @NotNull
    private final Handler mainThreadHandler;

    @NotNull
    private final ViewTreeObserverOnPreDrawListenerC0833v3 onDrawObserver;

    @NotNull
    private final C0715j4 qualitySettings;

    @NotNull
    private final C0775p4 recordingStartTimeProvider;

    @NotNull
    private final C0785q4 recordingTypeProvider;

    @NotNull
    private final C0824u4 recyclableViewAppearance;

    @NotNull
    private final N4 samplingMode;

    @NotNull
    private final T4 screenCapturer;

    @NotNull
    private final C0666e5 screenViewEventProvider;

    @NotNull
    private final D5 sessionReplayConfiguration;

    @NotNull
    private final K5 sessionReplayTreeLogger;

    @NotNull
    private final P5 sessionStateManager;

    @NotNull
    private final I6 startStopEventProvider;

    @NotNull
    private final List<R6> stoppableEventProviders;

    @NotNull
    private final C0855x7 throttleOperator;

    @NotNull
    private final C0854x6 urlGenerator;

    @NotNull
    private final InterfaceC0789q8 viewMutationEventProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionReplayProcessor(@NotNull Application application, @NotNull D5 sessionReplayConfiguration, @NotNull N4 samplingMode, @NotNull Z2 maskingParameter, @NotNull DeviceInfo deviceInfo, @NotNull ViewTreeObserverOnPreDrawListenerC0833v3 onDrawObserver, @NotNull M2 liveActivityProvider, @NotNull LifecycleOwner lifecycleOwner, @NotNull C0715j4 qualitySettings, @NotNull U batchStorageProcessor, @NotNull H1 eventsProvidersManager, @NotNull List<? extends R6> stoppableEventProviders, @NotNull InterfaceC0789q8 viewMutationEventProvider, @NotNull I6 startStopEventProvider, @NotNull I appStateEventProvider, @NotNull P5 sessionStateManager, @NotNull Handler mainThreadHandler, @NotNull E5 lifecycleCallbacks, @NotNull C0855x7 throttleOperator, @NotNull C0717j6 srQuickLink, @Nullable C0847x c0847x, @Nullable C0829v c0829v, @NotNull U1 forceMaskingResolver, @NotNull C0819u androidViewToViewLightConverter, @NotNull T4 screenCapturer, @NotNull C0824u4 recyclableViewAppearance, @NotNull BridgeManager bridgeManager, @NotNull J1 eventsToBatchProcessor, @NotNull C0785q4 recordingTypeProvider, @NotNull C0775p4 recordingStartTimeProvider, @NotNull J2 listener, @NotNull I2 lastEventTimeProvider, @NotNull C0782q1 etrScreenEventTracker, @NotNull C0791r1 etrScreenEventUrlProvider, @NotNull C0831v1 etrSessionEventTracker, @NotNull C0840w1 etrSessionEventUrlProvider, @NotNull C0854x6 urlGenerator, @NotNull S batchDispatcher, @NotNull C0666e5 screenViewEventProvider, @NotNull C0643c2 gestureEventViewMapper, @NotNull Logger logger, @NotNull K5 sessionReplayTreeLogger) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sessionReplayConfiguration, "sessionReplayConfiguration");
        Intrinsics.checkNotNullParameter(samplingMode, "samplingMode");
        Intrinsics.checkNotNullParameter(maskingParameter, "maskingParameter");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(onDrawObserver, "onDrawObserver");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(qualitySettings, "qualitySettings");
        Intrinsics.checkNotNullParameter(batchStorageProcessor, "batchStorageProcessor");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(stoppableEventProviders, "stoppableEventProviders");
        Intrinsics.checkNotNullParameter(viewMutationEventProvider, "viewMutationEventProvider");
        Intrinsics.checkNotNullParameter(startStopEventProvider, "startStopEventProvider");
        Intrinsics.checkNotNullParameter(appStateEventProvider, "appStateEventProvider");
        Intrinsics.checkNotNullParameter(sessionStateManager, "sessionStateManager");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkNotNullParameter(lifecycleCallbacks, "lifecycleCallbacks");
        Intrinsics.checkNotNullParameter(throttleOperator, "throttleOperator");
        Intrinsics.checkNotNullParameter(srQuickLink, "srQuickLink");
        Intrinsics.checkNotNullParameter(forceMaskingResolver, "forceMaskingResolver");
        Intrinsics.checkNotNullParameter(androidViewToViewLightConverter, "androidViewToViewLightConverter");
        Intrinsics.checkNotNullParameter(screenCapturer, "screenCapturer");
        Intrinsics.checkNotNullParameter(recyclableViewAppearance, "recyclableViewAppearance");
        Intrinsics.checkNotNullParameter(bridgeManager, "bridgeManager");
        Intrinsics.checkNotNullParameter(eventsToBatchProcessor, "eventsToBatchProcessor");
        Intrinsics.checkNotNullParameter(recordingTypeProvider, "recordingTypeProvider");
        Intrinsics.checkNotNullParameter(recordingStartTimeProvider, "recordingStartTimeProvider");
        Intrinsics.checkNotNullParameter(listener, "lastEventTimeTracker");
        Intrinsics.checkNotNullParameter(lastEventTimeProvider, "lastEventTimeProvider");
        Intrinsics.checkNotNullParameter(etrScreenEventTracker, "etrScreenEventTracker");
        Intrinsics.checkNotNullParameter(etrScreenEventUrlProvider, "etrScreenEventUrlProvider");
        Intrinsics.checkNotNullParameter(etrSessionEventTracker, "etrSessionEventTracker");
        Intrinsics.checkNotNullParameter(etrSessionEventUrlProvider, "etrSessionEventUrlProvider");
        Intrinsics.checkNotNullParameter(urlGenerator, "urlGenerator");
        Intrinsics.checkNotNullParameter(batchDispatcher, "batchDispatcher");
        Intrinsics.checkNotNullParameter(screenViewEventProvider, "screenViewEventProvider");
        Intrinsics.checkNotNullParameter(gestureEventViewMapper, "gestureEventViewMapper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(sessionReplayTreeLogger, "sessionReplayTreeLogger");
        this.application = application;
        this.sessionReplayConfiguration = sessionReplayConfiguration;
        this.samplingMode = samplingMode;
        this.onDrawObserver = onDrawObserver;
        this.liveActivityProvider = liveActivityProvider;
        this.lifecycleOwner = lifecycleOwner;
        this.qualitySettings = qualitySettings;
        this.batchStorageProcessor = batchStorageProcessor;
        this.eventsProvidersManager = eventsProvidersManager;
        this.stoppableEventProviders = stoppableEventProviders;
        this.viewMutationEventProvider = viewMutationEventProvider;
        this.startStopEventProvider = startStopEventProvider;
        this.appStateEventProvider = appStateEventProvider;
        this.sessionStateManager = sessionStateManager;
        this.mainThreadHandler = mainThreadHandler;
        this.lifecycleCallbacks = lifecycleCallbacks;
        this.throttleOperator = throttleOperator;
        this.animationSupervisor = c0847x;
        this.animationCompletionHandler = c0829v;
        this.forceMaskingResolver = forceMaskingResolver;
        this.androidViewToViewLightConverter = androidViewToViewLightConverter;
        this.screenCapturer = screenCapturer;
        this.recyclableViewAppearance = recyclableViewAppearance;
        this.bridgeManager = bridgeManager;
        this.eventsToBatchProcessor = eventsToBatchProcessor;
        this.recordingTypeProvider = recordingTypeProvider;
        this.recordingStartTimeProvider = recordingStartTimeProvider;
        this.lastEventTimeProvider = lastEventTimeProvider;
        this.etrScreenEventUrlProvider = etrScreenEventUrlProvider;
        this.etrSessionEventUrlProvider = etrSessionEventUrlProvider;
        this.urlGenerator = urlGenerator;
        this.batchDispatcher = batchDispatcher;
        this.screenViewEventProvider = screenViewEventProvider;
        this.gestureEventViewMapper = gestureEventViewMapper;
        this.logger = logger;
        this.sessionReplayTreeLogger = sessionReplayTreeLogger;
        this.batchModificationLock = new Object();
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStart(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                I i = this.a.appStateEventProvider;
                synchronized (i) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    EnumC0677f6 enumC0677f6 = EnumC0677f6.FOREGROUND;
                    i.a.a(new C0697h6(jCurrentTimeMillis, enumC0677f6));
                    i.b.d("Session Replay state event added: " + enumC0677f6);
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                I i = this.a.appStateEventProvider;
                synchronized (i) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    EnumC0677f6 enumC0677f6 = EnumC0677f6.BACKGROUND;
                    i.a.a(new C0697h6(jCurrentTimeMillis, enumC0677f6));
                    i.b.d("Session Replay state event added: " + enumC0677f6);
                }
                this.a.flushCurrentEventBatchAsync();
            }
        };
        onDrawObserver.getClass();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        onDrawObserver.c = this;
        Intrinsics.checkNotNullParameter(throttleOperator, "<set-?>");
        onDrawObserver.b = throttleOperator;
        synchronized (eventsToBatchProcessor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            eventsToBatchProcessor.d.add(listener);
        }
        eventsToBatchProcessor.a(etrScreenEventTracker);
        eventsToBatchProcessor.a(etrSessionEventTracker);
        if (c0829v == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        c0829v.c = this;
    }

    @UiThread
    private final void captureAndProcessScreen(Window window, ViewLight currentViewLight, N5 currentSessionState, List<? extends AbstractC0707i6> srEvents, boolean shouldForceMasking) {
        T4 t4 = this.screenCapturer;
        C0715j4 c0715j4 = this.qualitySettings;
        c0715j4.getClass();
        float densityScaleDown = QualityLevel.values()[c0715j4.h].getDensityScaleDown();
        t4.getClass();
        Intrinsics.checkNotNullParameter(window, "window");
        completeUiThreadProcess(currentViewLight, t4.a.a(window, densityScaleDown), currentSessionState, srEvents, shouldForceMasking);
    }

    @UiThread
    private final void completeUiThreadProcess(ViewLight viewLight, C0622a1<T4.d> screenCaptureDeferredResult, N5 sessionState, List<? extends AbstractC0707i6> srEvents, boolean shouldForceMasking) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.qualitySettings.b();
            this.logger.d("Switching to worker thread");
            switchToWorkerThread(viewLight, jCurrentTimeMillis, screenCaptureDeferredResult, sessionState, srEvents, shouldForceMasking);
        } catch (Exception e) {
            Q2.a(this.logger, "Something went wrong on completeUiThreadProcess.", e);
        }
    }

    private final Q createNewBatch(N5 sessionState) {
        Q qA;
        synchronized (this.batchModificationLock) {
            qA = this.eventsToBatchProcessor.a(this.urlGenerator.a(sessionState));
            this.eventsToBatchProcessor.a();
        }
        return qA;
    }

    @WorkerThread
    private final void flushCurrentEventBatch(N5 sessionState) {
        storeAndSendSrEvents(createNewBatch(sessionState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flushCurrentEventBatchAsync$lambda$13(SessionReplayProcessor this$0, List currentSrEvents, N5 currentSessionState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentSrEvents, "$currentSrEvents");
        Intrinsics.checkNotNullParameter(currentSessionState, "$currentSessionState");
        synchronized (this$0.batchModificationLock) {
            this$0.eventsToBatchProcessor.a((List<? extends AbstractC0707i6>) currentSrEvents);
            this$0.flushCurrentEventBatch(currentSessionState);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void mapGestureEventsToViewLight(List<? extends AbstractC0707i6> srEvents, ViewLight viewLight) {
        Object next;
        ArrayList<Z1> gestureEvents = new ArrayList();
        for (Object obj : srEvents) {
            if (obj instanceof Z1) {
                gestureEvents.add(obj);
            }
        }
        if (gestureEvents.isEmpty()) {
            return;
        }
        this.gestureEventViewMapper.getClass();
        Intrinsics.checkNotNullParameter(gestureEvents, "gestureEvents");
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        LinkedList<ViewLight> linkedListFlattenAndReverse = viewLight.flattenAndReverse(C0633b2.a);
        if (CollectionsKt.any(linkedListFlattenAndReverse)) {
            for (Z1 z1 : gestureEvents) {
                int i = z1.c;
                int i2 = z1.d;
                Iterator<T> it = linkedListFlattenAndReverse.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    ViewLight viewLight2 = (ViewLight) next;
                    int posX = viewLight2.getPosX();
                    int posY = viewLight2.getPosY();
                    int width = viewLight2.getWidth();
                    int height = viewLight2.getHeight();
                    if (i < posX || i >= posX + width || i2 < posY || i2 >= posY + height) {
                    }
                }
                z1.b = (ViewLight) next;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreScreenNumberChange$lambda$6(SessionReplayProcessor this$0, long j, List currentSrEvents, N5 currentSessionState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentSrEvents, "$currentSrEvents");
        Intrinsics.checkNotNullParameter(currentSessionState, "$currentSessionState");
        synchronized (this$0.batchModificationLock) {
            this$0.eventsToBatchProcessor.a((List<? extends AbstractC0707i6>) currentSrEvents);
            this$0.screenViewEventProvider.a.a(CollectionsKt.listOf(new C0732l1(j)));
            this$0.flushCurrentEventBatch(currentSessionState);
            this$0.screenViewEventProvider.a.a(CollectionsKt.listOf(new C0656d5(j)));
            Unit unit = Unit.INSTANCE;
        }
        this$0.recordingStartTimeProvider.a = j;
    }

    private final void setForceMaskingRecursively(ViewLight viewLight) {
        viewLight.setMasked(true);
        viewLight.setForceMasked(true);
        Iterator<T> it = viewLight.getChildren().iterator();
        while (it.hasNext()) {
            setForceMaskingRecursively((ViewLight) it.next());
        }
    }

    private final void startSessionReplayInFlutterIfNeeded() {
        if (!this.bridgeManager.isFlutterRegistered() || this.bridgeManager.isSessionReplayEnabled()) {
            return;
        }
        this.mainThreadHandler.post(new Runnable() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SessionReplayProcessor.startSessionReplayInFlutterIfNeeded$lambda$14(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSessionReplayInFlutterIfNeeded$lambda$14(SessionReplayProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isProcessStarted && this$0.bridgeManager.isFlutterRegistered() && !this$0.bridgeManager.isSessionReplayEnabled()) {
            this$0.bridgeManager.enableSessionReplay(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void storeAndSendSrEvents$lambda$10(SessionReplayProcessor this$0, Q batchToStore) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(batchToStore, "$batchToStore");
        try {
            this$0.batchStorageProcessor.a(batchToStore);
            this$0.batchDispatcher.a();
        } catch (Exception e) {
            Q2.a(this$0.logger, "Something went wrong while trying to store or dispatch.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchToWorkerThread$lambda$7(C0622a1 c0622a1, SessionReplayProcessor this$0, ViewLight viewLight, long j, N5 sessionState, List srEvents, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewLight, "$viewLight");
        Intrinsics.checkNotNullParameter(sessionState, "$sessionState");
        Intrinsics.checkNotNullParameter(srEvents, "$srEvents");
        try {
            if (c0622a1 != null) {
                T4.d dVar = (T4.d) c0622a1.a();
                if (dVar != null) {
                    this$0.createSrEvents(viewLight, j, dVar, sessionState, srEvents, z);
                }
            } else {
                this$0.createSrEvents(viewLight, j, null, sessionState, srEvents, z);
            }
        } catch (Exception e) {
            Q2.a(this$0.logger, "Something went wrong while processing sr events.", e);
        }
    }

    private final void triggerSingleFrameProcessingManually() {
        Handler handler = this.mainThreadHandler;
        AbstractRunnableC0823u3 abstractRunnableC0823u3 = this.onDrawObserver.c;
        if (abstractRunnableC0823u3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onDrawListener");
            abstractRunnableC0823u3 = null;
        }
        handler.post(abstractRunnableC0823u3);
    }

    public final void addCrashAndSaveToDisk(@NotNull G0 crashEvent) {
        Intrinsics.checkNotNullParameter(crashEvent, "crashEvent");
        synchronized (this.batchModificationLock) {
            this.eventsToBatchProcessor.a(this.eventsProvidersManager.a());
            this.eventsToBatchProcessor.a(CollectionsKt.listOf(crashEvent));
            this.screenViewEventProvider.a.a(CollectionsKt.listOf(new C0732l1(System.currentTimeMillis())));
            this.batchStorageProcessor.a(createNewBatch(this.sessionStateManager.a()));
            Unit unit = Unit.INSTANCE;
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final void createSrEvents(@NotNull ViewLight viewLight, long timestamp, @Nullable T4.d screenCaptureResult, @NotNull N5 sessionState, @NotNull List<? extends AbstractC0707i6> srEvents, boolean shouldForceMasking) throws IOException {
        J4 j4;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(srEvents, "srEvents");
        if (shouldForceMasking && !this.bridgeManager.isFlutterRegistered()) {
            setForceMaskingRecursively(viewLight);
        }
        if (this.sessionReplayTreeLogger.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, false)) {
            this.sessionReplayTreeLogger.d = (screenCaptureResult == null || (j4 = screenCaptureResult.a) == null || (bitmap = j4.c) == null) ? null : bitmap.copy(Bitmap.Config.RGB_565, false);
            K5 k5 = this.sessionReplayTreeLogger;
            k5.getClass();
            Intrinsics.checkNotNullParameter(viewLight, "viewLight");
            k5.c = viewLight;
        }
        if (screenCaptureResult != null) {
            C0824u4 c0824u4 = this.recyclableViewAppearance;
            c0824u4.getClass();
            Intrinsics.checkNotNullParameter(viewLight, "root");
            Intrinsics.checkNotNullParameter(screenCaptureResult, "screenCaptureResult");
            Pair<LinkedList<ViewLight>, LinkedList<ViewLight>> pairSplitFlattenAndReverse = viewLight.splitFlattenAndReverse();
            Iterator<ViewLight> it = pairSplitFlattenAndReverse.getFirst().iterator();
            while (it.hasNext()) {
                ViewLight viewLight2 = it.next();
                Intrinsics.checkNotNullExpressionValue(viewLight2, "viewLight");
                c0824u4.a(viewLight2, screenCaptureResult);
            }
            Iterator<ViewLight> it2 = pairSplitFlattenAndReverse.getSecond().iterator();
            while (it2.hasNext()) {
                ViewLight viewLight3 = it2.next();
                Intrinsics.checkNotNullExpressionValue(viewLight3, "viewLight");
                c0824u4.a(viewLight3, screenCaptureResult);
            }
            W w = c0824u4.d;
            w.a.putAll(w.b);
            w.b.clear();
        }
        if (this.sessionReplayTreeLogger.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, false)) {
            K5 k52 = this.sessionReplayTreeLogger;
            k52.b.d("Saving frame to: " + k52.f.getAbsoluteFile());
            ViewLight viewLight4 = k52.c;
            if (viewLight4 != null) {
                String str = "frame_" + k52.e + ".proto";
                if (!k52.f.exists()) {
                    k52.f.mkdirs();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(k52.f, str));
                    fileOutputStream.write(K5.a(viewLight4).toByteArray());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    k52.b.e(e.getMessage());
                }
            }
            if (k52.d != null) {
                String str2 = "frame_" + k52.e + ".png";
                if (!k52.f.exists()) {
                    k52.f.mkdirs();
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(k52.f, str2));
                    Bitmap bitmap2 = k52.d;
                    if (bitmap2 != null) {
                        bitmap2.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    k52.b.e(e2.getMessage());
                }
            }
            k52.e++;
            k52.d = null;
            k52.c = null;
        }
        ArrayList arrayListA = this.viewMutationEventProvider.a(viewLight, timestamp);
        synchronized (this.batchModificationLock) {
            try {
                mapGestureEventsToViewLight(srEvents, viewLight);
                J1 j1 = this.eventsToBatchProcessor;
                if (j1.c.c > j1.a) {
                    flushCurrentEventBatch(sessionState);
                }
                this.eventsToBatchProcessor.a(srEvents);
                this.eventsToBatchProcessor.a(arrayListA);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        startSessionReplayInFlutterIfNeeded();
    }

    @MainThread
    public final void flushCurrentEventBatchAsync() {
        final List list;
        final N5 n5A = this.sessionStateManager.a();
        H1 h1 = this.eventsProvidersManager;
        synchronized (h1) {
            list = CollectionsKt.toList(h1.a);
            h1.a.clear();
        }
        C0837v7 c0837v7 = C0751n0.a;
        C0751n0.a(new InterfaceRunnableC0741m0() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SessionReplayProcessor.flushCurrentEventBatchAsync$lambda$13(this.f$0, list, n5A);
            }
        });
    }

    @Override // com.contentsquare.android.sdk.AbstractRunnableC0823u3
    @UiThread
    public void onDraw(@NotNull Window window) {
        List<? extends AbstractC0707i6> list;
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            C0855x7 c0855x7 = this.throttleOperator;
            C0715j4 c0715j4 = this.qualitySettings;
            c0855x7.c = 1000 / c0715j4.g;
            R3 r3 = c0715j4.e;
            r3.a.getClass();
            r3.d = SystemClock.elapsedRealtime();
            C0847x c0847x = this.animationSupervisor;
            if (c0847x != null) {
                c0847x.a();
            }
            N5 n5A = this.sessionStateManager.a();
            C0819u c0819u = this.androidViewToViewLightConverter;
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            ViewLight viewLightA = c0819u.a(decorView);
            U1 u1 = this.forceMaskingResolver;
            View decorView2 = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
            boolean z = u1.a(decorView2) != 1;
            H1 h1 = this.eventsProvidersManager;
            synchronized (h1) {
                list = CollectionsKt.toList(h1.a);
                h1.a.clear();
            }
            if (!this.bridgeManager.isFlutterRegistered() || !this.bridgeManager.isSessionReplayEnabled()) {
                captureAndProcessScreen(window, viewLightA, n5A, list, z);
            } else if (FlutterInterface.isFirstFlutterEventAdded()) {
                completeUiThreadProcess(viewLightA, null, n5A, list, z);
            }
        } catch (Exception e) {
            Q2.a(this.logger, "Something went wrong in onDraw.", e);
        }
    }

    @Override // com.contentsquare.android.sdk.O5
    public void onPreScreenNumberChange(@NotNull final N5 currentSessionState) {
        final List list;
        Intrinsics.checkNotNullParameter(currentSessionState, "currentSessionState");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        H1 h1 = this.eventsProvidersManager;
        synchronized (h1) {
            list = CollectionsKt.toList(h1.a);
            h1.a.clear();
        }
        C0837v7 c0837v7 = C0751n0.a;
        C0751n0.a(new InterfaceRunnableC0741m0() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SessionReplayProcessor.onPreScreenNumberChange$lambda$6(this.f$0, jCurrentTimeMillis, list, currentSessionState);
            }
        });
        triggerSingleFrameProcessingManually();
    }

    public final void startProcess(boolean isNewSession) {
        this.startStopEventProvider.a(isNewSession);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.recordingStartTimeProvider.a = jCurrentTimeMillis;
        synchronized (this.batchModificationLock) {
            this.screenViewEventProvider.a.a(CollectionsKt.listOf(new C0656d5(jCurrentTimeMillis)));
            Unit unit = Unit.INSTANCE;
        }
        this.bridgeManager.setSessionReplayCapture(this.onDrawObserver);
        C0829v onPreDrawListener = this.animationCompletionHandler;
        if (onPreDrawListener != null) {
            ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3 = this.onDrawObserver;
            viewTreeObserverOnPreDrawListenerC0833v3.getClass();
            Intrinsics.checkNotNullParameter(onPreDrawListener, "onPreDrawListener");
            viewTreeObserverOnPreDrawListenerC0833v3.d.add(onPreDrawListener);
        }
        Activity activity = this.liveActivityProvider.a.get();
        if (activity != null) {
            ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v32 = this.onDrawObserver;
            viewTreeObserverOnPreDrawListenerC0833v32.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewTreeObserver viewTreeObserverA = viewTreeObserverOnPreDrawListenerC0833v32.a();
            if (viewTreeObserverA != null) {
                viewTreeObserverA.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v32);
                viewTreeObserverOnPreDrawListenerC0833v32.a.d("Listener to onDraw removed.");
            }
            FlutterInterface.setOnFlutterEventListener(null);
            viewTreeObserverOnPreDrawListenerC0833v32.e = new WeakReference<>(activity.getWindow());
            ViewTreeObserver viewTreeObserverA2 = viewTreeObserverOnPreDrawListenerC0833v32.a();
            if (viewTreeObserverA2 != null) {
                viewTreeObserverA2.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v32);
                viewTreeObserverOnPreDrawListenerC0833v32.a.d("Listen to draws.");
            }
            FlutterInterface.setOnFlutterEventListener(viewTreeObserverOnPreDrawListenerC0833v32);
            this.onDrawObserver.onPreDraw();
        }
        this.lifecycleCallbacks.a();
        this.lifecycleOwner.getLifecycle().addObserver(this.lifecycleObserver);
        this.sessionStateManager.d = this;
        if (this.sessionReplayTreeLogger.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_LOG_VIEWLIGHT_TREE, false) && isNewSession) {
            K5 k5 = this.sessionReplayTreeLogger;
            k5.d = null;
            k5.c = null;
            k5.e = 0;
            if (k5.f.exists()) {
                FilesKt.deleteRecursively(k5.f);
            }
        }
        this.isProcessStarted = true;
    }

    public final void stopProcess() {
        Iterator<T> it = this.stoppableEventProviders.iterator();
        while (it.hasNext()) {
            ((R6) it.next()).a();
        }
        H1 h1 = this.eventsProvidersManager;
        synchronized (h1) {
            h1.a.clear();
        }
        this.lifecycleCallbacks.b();
        C0829v onPreDrawListener = this.animationCompletionHandler;
        if (onPreDrawListener != null) {
            ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3 = this.onDrawObserver;
            viewTreeObserverOnPreDrawListenerC0833v3.getClass();
            Intrinsics.checkNotNullParameter(onPreDrawListener, "onPreDrawListener");
            viewTreeObserverOnPreDrawListenerC0833v3.d.remove(onPreDrawListener);
        }
        ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v32 = this.onDrawObserver;
        ViewTreeObserver viewTreeObserverA = viewTreeObserverOnPreDrawListenerC0833v32.a();
        if (viewTreeObserverA != null) {
            viewTreeObserverA.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v32);
            viewTreeObserverOnPreDrawListenerC0833v32.a.d("Listener to onDraw removed.");
        }
        FlutterInterface.setOnFlutterEventListener(null);
        this.recyclableViewAppearance.c.a.evictAll();
        W w = this.recyclableViewAppearance.d;
        w.a.clear();
        w.b.clear();
        this.lifecycleOwner.getLifecycle().removeObserver(this.lifecycleObserver);
        this.bridgeManager.enableSessionReplay(false);
        this.bridgeManager.setSessionReplayCapture(null);
        this.sessionStateManager.d = null;
        this.isProcessStarted = false;
    }

    @VisibleForTesting
    public final void storeAndSendSrEvents(@NotNull final Q batchToStore) {
        boolean z;
        Intrinsics.checkNotNullParameter(batchToStore, "batchToStore");
        C0837v7 c0837v7 = C0850x2.a;
        InterfaceRunnableC0841w2 task = new InterfaceRunnableC0841w2() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SessionReplayProcessor.storeAndSendSrEvents$lambda$10(this.f$0, batchToStore);
            }
        };
        Intrinsics.checkNotNullParameter(task, "task");
        C0837v7 c0837v72 = C0850x2.a;
        synchronized (c0837v72) {
            Intrinsics.checkNotNullParameter(task, "task");
            try {
                c0837v72.a.execute(task);
                z = true;
            } catch (RejectedExecutionException e) {
                c0837v72.b.d(e, "addTask failed");
                z = false;
            }
        }
        if (z) {
            return;
        }
        C0850x2.b.e("the IOThreadPool is full, a task was skipped");
    }

    @UiThread
    @VisibleForTesting
    public final void switchToWorkerThread(@NotNull final ViewLight viewLight, final long timestamp, @Nullable final C0622a1<T4.d> screenCaptureDeferredResult, @NotNull final N5 sessionState, @NotNull final List<? extends AbstractC0707i6> srEvents, final boolean shouldForceMasking) {
        boolean z;
        Intrinsics.checkNotNullParameter(viewLight, "viewLight");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(srEvents, "srEvents");
        C0837v7 c0837v7 = C0751n0.a;
        InterfaceRunnableC0741m0 task = new InterfaceRunnableC0741m0() { // from class: com.contentsquare.android.internal.features.sessionreplay.processing.SessionReplayProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SessionReplayProcessor.switchToWorkerThread$lambda$7(screenCaptureDeferredResult, this, viewLight, timestamp, sessionState, srEvents, shouldForceMasking);
            }
        };
        Intrinsics.checkNotNullParameter(task, "task");
        C0837v7 c0837v72 = C0751n0.a;
        synchronized (c0837v72) {
            Intrinsics.checkNotNullParameter(task, "task");
            try {
                c0837v72.a.execute(task);
                z = true;
            } catch (RejectedExecutionException e) {
                c0837v72.b.d(e, "addTask failed");
                z = false;
            }
        }
        if (z) {
            return;
        }
        C0751n0.b.e("the CPUThreadPool is full, a task was skipped");
    }

    public SessionReplayProcessor(Application application, D5 d5, N4 n4, Z2 z2, DeviceInfo deviceInfo, ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3, M2 m2, LifecycleOwner lifecycleOwner, C0715j4 c0715j4, U u, H1 h1, List list, InterfaceC0789q8 interfaceC0789q8, I6 i6, I i, P5 p5, Handler handler, E5 e5, C0855x7 c0855x7, C0717j6 c0717j6, C0847x c0847x, C0829v c0829v, U1 u1, C0819u c0819u, T4 t4, C0824u4 c0824u4, BridgeManager bridgeManager, J1 j1, C0785q4 c0785q4, C0775p4 c0775p4, J2 j2, I2 i2, C0782q1 c0782q1, C0791r1 c0791r1, C0831v1 c0831v1, C0840w1 c0840w1, C0854x6 c0854x6, S s, C0666e5 c0666e5, C0643c2 c0643c2, Logger logger, K5 k5, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        C0847x c0847x2;
        C0819u c0819u2;
        J1 j12;
        C0831v1 c0831v12;
        C0782q1 c0782q12;
        C0854x6 c0854x62;
        K5 k52;
        Handler handler2 = (i3 & 65536) != 0 ? new Handler(Looper.getMainLooper()) : handler;
        E5 e52 = (i3 & 131072) != 0 ? new E5(application, viewTreeObserverOnPreDrawListenerC0833v3) : e5;
        C0855x7 c0855x72 = (i3 & 262144) != 0 ? new C0855x7(new SystemInstantiable(), handler2, 200L) : c0855x7;
        ComposeInterface composeInterface = null;
        if ((i3 & 1048576) != 0) {
            CoreModule.Companion companion = CoreModule.INSTANCE;
            if (C0848x0.a(companion.getInstance(), JsonConfigFeatureFlagNames.SR_DETECT_ANIMATIONS) || companion.safeInstance(application).getPreferencesStore().getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_ANIMATION_DETECTION, false)) {
                SystemInstantiable systemInstantiable = new SystemInstantiable();
                c0847x2 = new C0847x(systemInstantiable, new C0838w(), new C0856y(c0717j6, systemInstantiable));
            } else {
                c0847x2 = null;
            }
        } else {
            c0847x2 = c0847x;
        }
        C0829v c0829v2 = (i3 & 2097152) != 0 ? c0847x2 != null ? new C0829v(c0847x2, handler2) : null : c0829v;
        U1 u12 = (i3 & 4194304) != 0 ? new U1(d5, c0847x2) : u1;
        if ((i3 & 8388608) != 0) {
            SystemInstantiable systemInstantiable2 = new SystemInstantiable();
            CoreModule companion2 = CoreModule.INSTANCE.getInstance();
            if (companion2 != null && C0848x0.a(companion2, JsonConfigFeatureFlagNames.SR_JETPACK_COMPOSE)) {
                composeInterface = (ComposeInterface) C0644c3.c.getValue();
            }
            c0819u2 = new C0819u(systemInstantiable2, z2, composeInterface, c0847x2);
        } else {
            c0819u2 = c0819u;
        }
        T4 t42 = (i3 & 16777216) != 0 ? new T4() : t4;
        C0824u4 c0824u42 = (i3 & PendingIntentCompat.FLAG_MUTABLE) != 0 ? new C0824u4() : c0824u4;
        if ((i3 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0) {
            j12 = new J1(bridgeManager.isFlutterRegistered() ? SessionRecordingV1.EventPayload.Position.POSITION_RELATIVE : SessionRecordingV1.EventPayload.Position.POSITION_ABSOLUTE);
        } else {
            j12 = j1;
        }
        C0785q4 c0785q42 = (i3 & 268435456) != 0 ? new C0785q4(n4) : c0785q4;
        C0775p4 c0775p42 = (i3 & 536870912) != 0 ? new C0775p4() : c0775p4;
        J2 j22 = (i3 & 1073741824) != 0 ? new J2() : j2;
        I2 i22 = (i3 & Integer.MIN_VALUE) != 0 ? new I2(j22) : i2;
        C0782q1 c0782q13 = (i4 & 1) != 0 ? new C0782q1() : c0782q1;
        C0791r1 c0791r12 = (i4 & 2) != 0 ? new C0791r1(c0782q13) : c0791r1;
        C0831v1 c0831v13 = (i4 & 4) != 0 ? new C0831v1() : c0831v1;
        C0840w1 c0840w12 = (i4 & 8) != 0 ? new C0840w1(c0831v13) : c0840w1;
        if ((i4 & 16) != 0) {
            CoreModule.Companion companion3 = CoreModule.INSTANCE;
            c0831v12 = c0831v13;
            c0782q12 = c0782q13;
            c0854x62 = new C0854x6(d5, new C0742m1(companion3.safeInstance(application).getConfiguration(), companion3.safeInstance(application).getPreferencesStore()), new L7(companion3.safeInstance(application).getPreferencesStore()), CollectionsKt.listOf((Object[]) new J7[]{c0785q42, c0775p42, i22, c0791r12, c0840w12}), (HeapInterface) C0644c3.d.getValue(), deviceInfo.getBuildInformation());
        } else {
            c0831v12 = c0831v13;
            c0782q12 = c0782q13;
            c0854x62 = c0854x6;
        }
        S s2 = (i4 & 32) != 0 ? new S(deviceInfo, d5, u) : s;
        C0666e5 c0666e52 = (i4 & 64) != 0 ? new C0666e5(j12) : c0666e5;
        C0643c2 c0643c22 = (i4 & 128) != 0 ? new C0643c2() : c0643c2;
        Logger logger2 = (i4 & 256) != 0 ? new Logger("SessionReplayProcessor") : logger;
        if ((i4 & 512) != 0) {
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
            k52 = new K5(applicationContext, CoreModule.INSTANCE.safeInstance(application).getPreferencesStore());
        } else {
            k52 = k5;
        }
        this(application, d5, n4, z2, deviceInfo, viewTreeObserverOnPreDrawListenerC0833v3, m2, lifecycleOwner, c0715j4, u, h1, list, interfaceC0789q8, i6, i, p5, handler2, e52, c0855x72, c0717j6, c0847x2, c0829v2, u12, c0819u2, t42, c0824u42, bridgeManager, j12, c0785q42, c0775p42, j22, i22, c0782q12, c0791r12, c0831v12, c0840w12, c0854x62, s2, c0666e52, c0643c22, logger2, k52);
    }
}
