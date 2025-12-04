package com.disney.id.android;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import androidx.autofill.HintConstants;
import com.disney.id.android.Connectivity;
import com.disney.id.android.LookupValue;
import com.disney.id.android.Session;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.BaseGCResponse;
import com.disney.id.android.services.GCError;
import com.disney.id.android.services.GCErrorContent;
import com.disney.id.android.services.GCErrorHandlingAdapter;
import com.disney.id.android.services.GCResponseError;
import com.disney.id.android.services.GCService;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.disney.id.android.utils.GsonUtils;
import com.disney.id.android.utils.StringPatterns;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

@Metadata(d1 = {"\u0000ù\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001`\b\u0000\u0018\u0000 æ\u00012\u00020\u0001:\u0004æ\u0001ç\u0001B\u0005¢\u0006\u0002\u0010\u0002J2\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010s2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0016J$\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010qH\u0002J\u0019\u0010~\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J+\u0010\u0081\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\f\u0010\u0082\u0001\u001a\u0007\u0012\u0002\b\u00030\u0083\u00012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010qH\u0002J\u001f\u0010\u0084\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020z2\f\u0010\u0082\u0001\u001a\u0007\u0012\u0002\b\u00030\u0083\u0001H\u0002J?\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010y\u001a\u00020z2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010x2\u0016\u0010\u0082\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0088\u00010\u008a\u00010\u0083\u0001H\u0002J\u0014\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\u001b\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u00012\b\u0010\u0092\u0001\u001a\u00030\u0080\u0001H\u0002J\u001b\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0090\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u0012\u0010\u0097\u0001\u001a\u00020\"2\u0007\u0010\u0098\u0001\u001a\u00020cH\u0002J\u001b\u0010\u0099\u0001\u001a\u00020\"2\u0007\u0010\u0098\u0001\u001a\u00020c2\u0007\u0010\u009a\u0001\u001a\u00020\"H\u0002J?\u0010\u009b\u0001\u001a\u00020m2\u0007\u0010\u009c\u0001\u001a\u00020q2\b\u0010\u009d\u0001\u001a\u00030\u0086\u00012\r\u0010t\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0002J!\u0010\u009e\u0001\u001a\u00020m2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010sH\u0002J7\u0010\u009f\u0001\u001a\u00020m2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010q2\r\u0010t\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u001d\u0010 \u0001\u001a\u00020m2\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u001b\u0010¡\u0001\u001a\u00030¢\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010\u0090\u0001H\u0002J\u000b\u0010¥\u0001\u001a\u0004\u0018\u00010qH\u0016J5\u0010¦\u0001\u001a\u00020m2\u0007\u0010§\u0001\u001a\u00020q2\r\u0010t\u001a\t\u0012\u0005\u0012\u00030¨\u00010u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u0016\u0010©\u0001\u001a\u0005\u0018\u00010ª\u00012\b\u0010y\u001a\u0004\u0018\u00010zH\u0002J%\u0010«\u0001\u001a\u00030\u008e\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\t\u0010®\u0001\u001a\u0004\u0018\u00010sH\u0000¢\u0006\u0003\b¯\u0001JL\u0010°\u0001\u001a\u00030\u008e\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010\u0090\u00012\u0011\u0010±\u0001\u001a\f\u0012\u0005\u0012\u00030²\u0001\u0018\u00010\u0090\u00012\u0011\u0010³\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u0090\u00012\t\u0010®\u0001\u001a\u0004\u0018\u00010sH\u0002J_\u0010´\u0001\u001a\u00020m2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010x2\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\u0013\b\u0002\u0010¸\u0001\u001a\f\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u0090\u00012\u0012\b\u0002\u0010¹\u0001\u001a\u000b\u0012\u0004\u0012\u00020m\u0018\u00010º\u0001H\u0000¢\u0006\u0003\b»\u0001J-\u0010¼\u0001\u001a\u0004\u0018\u00010x2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010y\u001a\u00020z2\r\u0010t\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010uH\u0002J\n\u0010½\u0001\u001a\u00030¢\u0001H\u0016J \u0010¾\u0001\u001a\u00020m2\b\u0010¿\u0001\u001a\u00030ª\u00012\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010qH\u0002J\n\u0010Á\u0001\u001a\u00030¢\u0001H\u0016J\u0013\u0010Â\u0001\u001a\u00020m2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J>\u0010Ã\u0001\u001a\u00020m2\u0007\u0010§\u0001\u001a\u00020q2\u0007\u0010\u009c\u0001\u001a\u00020q2\r\u0010t\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u0018\u0010Ä\u0001\u001a\u00020\"2\u0007\u0010\u0098\u0001\u001a\u00020cH\u0000¢\u0006\u0003\bÅ\u0001J\t\u0010Æ\u0001\u001a\u00020mH\u0016J$\u0010Ç\u0001\u001a\u0005\u0018\u00010\u008e\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010y\u001a\u00020zH\u0000¢\u0006\u0003\bÈ\u0001J&\u0010É\u0001\u001a\u00020m2\u0007\u0010t\u001a\u00030Ê\u00012\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J(\u0010Ë\u0001\u001a\u00020m2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010q2\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010qH\u0000¢\u0006\u0003\bÌ\u0001J\u0014\u0010Í\u0001\u001a\u00030¢\u00012\b\u0010y\u001a\u0004\u0018\u00010zH\u0016Jc\u0010Î\u0001\u001a\u00020m2\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010\u0090\u00012\u0011\u0010±\u0001\u001a\f\u0012\u0005\u0012\u00030²\u0001\u0018\u00010\u0090\u00012\u0011\u0010³\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u0090\u00012\r\u0010t\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J!\u0010Ï\u0001\u001a\u00020m2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010s2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010qH\u0002J'\u0010Ð\u0001\u001a\u00020m2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u0088\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0000¢\u0006\u0003\bÓ\u0001J'\u0010Ô\u0001\u001a\u00020m2\u0007\u0010Õ\u0001\u001a\u00020\"2\b\u0010p\u001a\u0004\u0018\u00010q2\t\u0010À\u0001\u001a\u0004\u0018\u00010qH\u0016J\u001a\u0010Ö\u0001\u001a\u00020\"2\t\u0010×\u0001\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0003\u0010Ø\u0001J\u0013\u0010Ù\u0001\u001a\u00020m2\b\u0010¿\u0001\u001a\u00030ª\u0001H\u0002J\t\u0010Ú\u0001\u001a\u00020mH\u0002J\u0014\u0010Û\u0001\u001a\u00030¢\u00012\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J5\u0010Ü\u0001\u001a\u00020m2\b\u0010Ý\u0001\u001a\u00030\u008e\u00012\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010p\u001a\u0004\u0018\u00010q2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0016J5\u0010Þ\u0001\u001a\u00020m2\b\u0010ß\u0001\u001a\u00030\u00ad\u00012\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010p\u001a\u0004\u0018\u00010q2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0016J4\u0010à\u0001\u001a\u00020m2\u0007\u0010á\u0001\u001a\u00020q2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0u2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\"\u0010â\u0001\u001a\u00030ã\u0001*\u00030ã\u00012\u000b\b\u0002\u0010ä\u0001\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0003\u0010å\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00107\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u0001068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u00020=8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020C8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u0002\u001a\u0004\bE\u0010FR\u0012\u0010G\u001a\u00060HR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010M\u001a\u00020N8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020T8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020Z8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0010\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010d\u001a\u00020e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0016\u0010j\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, d2 = {"Lcom/disney/id/android/OneIDSession;", "Lcom/disney/id/android/Session;", "()V", "appContext", "Landroid/content/Context;", "getAppContext$OneID_release", "()Landroid/content/Context;", "setAppContext$OneID_release", "(Landroid/content/Context;)V", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "connectivity", "Lcom/disney/id/android/Connectivity;", "getConnectivity$OneID_release", "()Lcom/disney/id/android/Connectivity;", "setConnectivity$OneID_release", "(Lcom/disney/id/android/Connectivity;)V", "gcService", "Lcom/disney/id/android/services/GCService;", "getGcService$OneID_release", "()Lcom/disney/id/android/services/GCService;", "setGcService$OneID_release", "(Lcom/disney/id/android/services/GCService;)V", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "guestStalenessTTLInMilliseconds", "", "headlessListenerHolder", "Lcom/disney/id/android/HeadlessListenerHolder;", "getHeadlessListenerHolder$OneID_release", "()Lcom/disney/id/android/HeadlessListenerHolder;", "setHeadlessListenerHolder$OneID_release", "(Lcom/disney/id/android/HeadlessListenerHolder;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "oneIdStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getOneIdStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setOneIdStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "value", "Lcom/disney/id/android/Session$Owner;", "owner", "getOwner", "()Lcom/disney/id/android/Session$Owner;", "setOwner", "(Lcom/disney/id/android/Session$Owner;)V", OneIDRecoveryContext.RECOVERY_CONTEXT, "Lcom/disney/id/android/RecoveryContext;", "getRecoveryContext$OneID_release", "()Lcom/disney/id/android/RecoveryContext;", "setRecoveryContext$OneID_release", "(Lcom/disney/id/android/RecoveryContext;)V", "refreshHandler", "Landroid/os/Handler;", "getRefreshHandler$OneID_release$annotations", "getRefreshHandler$OneID_release", "()Landroid/os/Handler;", "refreshRunner", "Lcom/disney/id/android/OneIDSession$RefreshRunner;", "refreshThread", "Landroid/os/HandlerThread;", "refreshingToken", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tokenConnectivityListener", "com/disney/id/android/OneIDSession$tokenConnectivityListener$1", "Lcom/disney/id/android/OneIDSession$tokenConnectivityListener$1;", "tokenRefreshRetryAttempts", "", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "weakOwner", "Ljava/lang/ref/WeakReference;", "beginRecovery", "", "lookupValue", "Lcom/disney/id/android/LookupValue;", "conversationId", "", LightboxActivity.CONFIGS_EXTRA, "Lcom/disney/id/android/OptionalConfigs;", "callback", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/OneIDCallbackData;", "buildErrorFromOnError", "Lcom/disney/id/android/OneIDError;", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "throwable", "", "loggerMessage", "buildErrorFromResponse", "errorBody", "Lcom/disney/id/android/services/GCResponseError;", "buildErrorFromResponseFailure", "response", "Lretrofit2/Response;", "buildErrorInvalidJson", "buildGuestCallbackData", "Lcom/disney/id/android/GuestCallbackData;", "data", "Lcom/google/gson/JsonElement;", "ppuError", "Lcom/disney/id/android/services/BaseGCResponse;", "buildLegalDetail", "Lcom/disney/id/android/LegalDetail;", "disclosure", "Lcom/google/gson/JsonObject;", "buildPPUList", "", "Lcom/disney/id/android/PPU;", "responseError", "buildPlainTextLinks", "Lcom/disney/id/android/PlainTextLink;", "linkElements", "Lcom/google/gson/JsonArray;", "calculateRefreshIntervalForExpiredToken", "attemptCount", "calculateRefreshIntervalForValidToken", "tokenTTL", "changePassword", HintConstants.AUTOFILL_HINT_PASSWORD, "guestData", "clearLocalStorage", "completeRecovery", ViewProps.END, "getAutogenerateUsernameQuery", "", "fields", "Lcom/disney/id/android/Field;", "getCountryCode", "getGuestFlow", "loginValue", "Lcom/disney/id/android/GuestFlowCallbackData;", "getGuestObject", "Lcom/disney/id/android/Guest;", "getNewsletterBodyForLoggedOutUser", "buDetails", "Lcom/disney/id/android/NewsletterDetails;", "options", "getNewsletterBodyForLoggedOutUser$OneID_release", "getRegisterBody", "marketing", "Lcom/disney/id/android/MarketingDetail;", "legal", "handleCompletions", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "ppuData", "Lorg/json/JSONObject;", "ppus", "onCompletion", "Lkotlin/Function0;", "handleCompletions$OneID_release", "handleGuestError", "highTrust", "initiateScheduledRefresh", "guest", "sourceEventInfo", "isLoggedIn", "loadGuestFromStorage", FirebaseAnalytics.Event.LOGIN, "nextTokenRefreshInterval", "nextTokenRefreshInterval$OneID_release", "notifyOwnerOfLogout", "processNewToken", "processNewToken$OneID_release", "refreshGuest", "Lcom/disney/id/android/Session$ResultCallback;", "refreshToken", "refreshToken$OneID_release", "refreshTokenExpired", "register", "remoteLogout", "saveGuestOrTokenToStorage", "guestJsonElement", "tokenJsonElement", "saveGuestOrTokenToStorage$OneID_release", "scheduleTokenRefresh", "delayUntilRefresh", "secondsUntilExpiration", "timestamp", "(Ljava/lang/Long;)J", "setExpiration", "setGuestFreshnessTimestamp", "shouldGuestBeRefreshed", "updateGuest", "updateBody", "updateMarketing", "newsletterDetails", "validateOTP", "otp", "setAccessTokenExpiration", "Lcom/disney/id/android/Token;", "exp", "(Lcom/disney/id/android/Token;Ljava/lang/Long;)Lcom/disney/id/android/Token;", "Companion", "RefreshRunner", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDSession.kt\ncom/disney/id/android/OneIDSession\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2712:1\n1#2:2713\n766#3:2714\n857#3,2:2715\n1855#3,2:2717\n*S KotlinDebug\n*F\n+ 1 OneIDSession.kt\ncom/disney/id/android/OneIDSession\n*L\n915#1:2714\n915#1:2715,2\n923#1:2717,2\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDSession implements Session {
    private static final String TAG = OneIDSession.class.getSimpleName();

    @NotNull
    public static final String lastDateRetrievedKey = "lastDateRetrieved";

    @Inject
    public Context appContext;

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public Connectivity connectivity;

    @Inject
    public GCService gcService;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public HeadlessListenerHolder headlessListenerHolder;

    @Inject
    public Logger logger;

    @Inject
    public ExposedStorage oneIdStorage;

    @Inject
    public RecoveryContext recoveryContext;
    private final Handler refreshHandler;
    private final RefreshRunner refreshRunner;
    private final HandlerThread refreshThread;

    @Inject
    public SCALPController scalpController;

    @Inject
    public LocalStorage storage;

    @Inject
    public SWID swid;
    private final OneIDSession$tokenConnectivityListener$1 tokenConnectivityListener;
    private int tokenRefreshRetryAttempts;

    @Inject
    public Tracker tracker;
    private WeakReference weakOwner;
    private long guestStalenessTTLInMilliseconds = 86400000;
    private AtomicBoolean refreshingToken = new AtomicBoolean(false);

    @VisibleForTesting
    public static /* synthetic */ void getRefreshHandler$OneID_release$annotations() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.disney.id.android.OneIDSession$tokenConnectivityListener$1] */
    public OneIDSession() {
        OneIDDagger.getComponent().inject(this);
        HandlerThread handlerThread = new HandlerThread("OneID Token Refresh");
        this.refreshThread = handlerThread;
        handlerThread.start();
        this.refreshHandler = new Handler(handlerThread.getLooper());
        this.refreshRunner = new RefreshRunner();
        this.tokenConnectivityListener = new Connectivity.Listener() { // from class: com.disney.id.android.OneIDSession$tokenConnectivityListener$1
            @Override // com.disney.id.android.Connectivity.Listener
            public void onConnected() {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Received onConnect", null, 4, null);
                Guest guest = this.this$0.getGuestHandler$OneID_release().get();
                if (guest != null) {
                    this.this$0.initiateScheduledRefresh(guest, "source(onConnected)");
                }
            }

            @Override // com.disney.id.android.Connectivity.Listener
            public void onDisconnected() {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Received onDisconnect", null, 4, null);
                this.this$0.getRefreshHandler().removeCallbacks(this.this$0.refreshRunner);
            }
        };
    }

    @NotNull
    public final Context getAppContext$OneID_release() {
        Context context = this.appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void setAppContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final Connectivity getConnectivity$OneID_release() {
        Connectivity connectivity = this.connectivity;
        if (connectivity != null) {
            return connectivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectivity");
        return null;
    }

    public final void setConnectivity$OneID_release(@NotNull Connectivity connectivity) {
        Intrinsics.checkNotNullParameter(connectivity, "<set-?>");
        this.connectivity = connectivity;
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    @NotNull
    public final ExposedStorage getOneIdStorage$OneID_release() {
        ExposedStorage exposedStorage = this.oneIdStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIdStorage");
        return null;
    }

    public final void setOneIdStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.oneIdStorage = exposedStorage;
    }

    @NotNull
    public final ConfigHandler getConfigHandler$OneID_release() {
        ConfigHandler configHandler = this.configHandler;
        if (configHandler != null) {
            return configHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configHandler");
        return null;
    }

    public final void setConfigHandler$OneID_release(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "<set-?>");
        this.configHandler = configHandler;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @NotNull
    public final GuestHandler getGuestHandler$OneID_release() {
        GuestHandler guestHandler = this.guestHandler;
        if (guestHandler != null) {
            return guestHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guestHandler");
        return null;
    }

    public final void setGuestHandler$OneID_release(@NotNull GuestHandler guestHandler) {
        Intrinsics.checkNotNullParameter(guestHandler, "<set-?>");
        this.guestHandler = guestHandler;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final GCService getGcService$OneID_release() {
        GCService gCService = this.gcService;
        if (gCService != null) {
            return gCService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gcService");
        return null;
    }

    public final void setGcService$OneID_release(@NotNull GCService gCService) {
        Intrinsics.checkNotNullParameter(gCService, "<set-?>");
        this.gcService = gCService;
    }

    @NotNull
    public final SCALPController getScalpController$OneID_release() {
        SCALPController sCALPController = this.scalpController;
        if (sCALPController != null) {
            return sCALPController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpController");
        return null;
    }

    public final void setScalpController$OneID_release(@NotNull SCALPController sCALPController) {
        Intrinsics.checkNotNullParameter(sCALPController, "<set-?>");
        this.scalpController = sCALPController;
    }

    @NotNull
    public final RecoveryContext getRecoveryContext$OneID_release() {
        RecoveryContext recoveryContext = this.recoveryContext;
        if (recoveryContext != null) {
            return recoveryContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException(OneIDRecoveryContext.RECOVERY_CONTEXT);
        return null;
    }

    public final void setRecoveryContext$OneID_release(@NotNull RecoveryContext recoveryContext) {
        Intrinsics.checkNotNullParameter(recoveryContext, "<set-?>");
        this.recoveryContext = recoveryContext;
    }

    @NotNull
    public final HeadlessListenerHolder getHeadlessListenerHolder$OneID_release() {
        HeadlessListenerHolder headlessListenerHolder = this.headlessListenerHolder;
        if (headlessListenerHolder != null) {
            return headlessListenerHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headlessListenerHolder");
        return null;
    }

    public final void setHeadlessListenerHolder$OneID_release(@NotNull HeadlessListenerHolder headlessListenerHolder) {
        Intrinsics.checkNotNullParameter(headlessListenerHolder, "<set-?>");
        this.headlessListenerHolder = headlessListenerHolder;
    }

    @NotNull
    /* renamed from: getRefreshHandler$OneID_release, reason: from getter */
    public final Handler getRefreshHandler() {
        return this.refreshHandler;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/disney/id/android/OneIDSession$RefreshRunner;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lcom/disney/id/android/OneIDSession;)V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "sourceEventInfo", "getSourceEventInfo", "setSourceEventInfo", "run", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RefreshRunner implements Runnable {
        private String conversationId;
        private String sourceEventInfo;

        public RefreshRunner() {
        }

        @Nullable
        public final String getConversationId() {
            return this.conversationId;
        }

        public final void setConversationId(@Nullable String str) {
            this.conversationId = str;
        }

        @Nullable
        public final String getSourceEventInfo() {
            return this.sourceEventInfo;
        }

        public final void setSourceEventInfo(@Nullable String str) {
            this.sourceEventInfo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            OneIDSession.this.refreshToken$OneID_release(this.conversationId, this.sourceEventInfo);
            this.conversationId = null;
            this.sourceEventInfo = null;
        }
    }

    @Override // com.disney.id.android.Session
    @Nullable
    public Session.Owner getOwner() {
        WeakReference weakReference = this.weakOwner;
        if (weakReference != null) {
            return (Session.Owner) weakReference.get();
        }
        return null;
    }

    @Override // com.disney.id.android.Session
    public void setOwner(@Nullable Session.Owner owner) {
        this.weakOwner = owner != null ? new WeakReference(owner) : null;
    }

    @Override // com.disney.id.android.Session
    public boolean refreshTokenExpired(@Nullable TrackerEventKey trackerEventKey) {
        Token token$OneID_release;
        Long refreshExp;
        Guest guestObject = getGuestObject(trackerEventKey);
        if (guestObject == null || (token$OneID_release = guestObject.getToken$OneID_release()) == null || (refreshExp = token$OneID_release.getRefreshExp()) == null) {
            return true;
        }
        return new Date(refreshExp.longValue()).before(new Date());
    }

    private final Guest getGuestObject(TrackerEventKey trackerEventKey) {
        JsonElement jsonElement;
        String str = getStorage$OneID_release().get(getConfigHandler$OneID_release().get().getClientId() + ".guest");
        Guest guest = null;
        if (str != null) {
            Gson gsonCreateStandardGson$default = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null);
            try {
                jsonElement = (JsonElement) gsonCreateStandardGson$default.fromJson(str, JsonElement.class);
            } catch (Exception e) {
                OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
                if (event != null) {
                    event.appendCodes$OneID_release("INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(rawguestloadfailure)");
                }
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Invalid guest or token object found in storage", e);
                jsonElement = null;
            }
            try {
                guest = (Guest) gsonCreateStandardGson$default.fromJson(str, Guest.class);
            } catch (Exception e2) {
                OneIDTrackerEvent event2 = getTracker$OneID_release().getEvent(trackerEventKey);
                if (event2 != null) {
                    event2.appendCodes$OneID_release("INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(guestloadfailure)");
                }
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                logger$OneID_release2.e(TAG3, "Invalid guest object found in storage.  Guest not loaded", e2);
            }
            if (guest != null) {
                setExpiration(guest);
                guest.setRawGuest$OneID_release(jsonElement);
            }
        }
        return guest;
    }

    @Override // com.disney.id.android.Session
    public boolean shouldGuestBeRefreshed(@Nullable TrackerEventKey trackerEventKey) {
        OneIDTrackerEvent event;
        String str = getStorage$OneID_release().get(getConfigHandler$OneID_release().get().getClientId() + ".lastDateRetrieved");
        long guestLastRetrieved = 0;
        if (str != null) {
            try {
                guestLastRetrieved = ((GuestFreshnessTimestamp) GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null).fromJson(str, GuestFreshnessTimestamp.class)).getGuestLastRetrieved();
            } catch (Exception e) {
                if (trackerEventKey != null && (event = getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                    event.appendCodes$OneID_release("INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(lastDateRetrieved)");
                }
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Invalid last retrieved date found in storage.  date not loaded", e);
            }
        }
        return new Date().getTime() - guestLastRetrieved > this.guestStalenessTTLInMilliseconds;
    }

    @Override // com.disney.id.android.Session
    public void loadGuestFromStorage(@Nullable TrackerEventKey trackerEventKey) {
        String swid;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Loading guest from storage", null, 4, null);
        Guest guestObject = getGuestObject(trackerEventKey);
        getGuestHandler$OneID_release().set(guestObject);
        if (guestObject != null) {
            if (isLoggedIn()) {
                getConnectivity$OneID_release().addListener(this.tokenConnectivityListener);
                initiateScheduledRefresh(guestObject, "source(loadGuestFromStorage)");
            }
            Token token$OneID_release = guestObject.getToken$OneID_release();
            if (token$OneID_release == null || (swid = token$OneID_release.getSwid()) == null) {
                return;
            }
            getSwid$OneID_release().set(swid);
            Logger logger$OneID_release2 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG2, "Guest loaded // " + swid, null, 4, null);
        }
    }

    private final void setExpiration(Guest guest) {
        if (guest.getToken$OneID_release() == null || !getOneIdStorage$OneID_release().getBoolean("expireToken", false)) {
            return;
        }
        long time = new Date().getTime() - 600;
        Token token$OneID_release = guest.getToken$OneID_release();
        guest.setToken$OneID_release(token$OneID_release != null ? setAccessTokenExpiration(token$OneID_release, Long.valueOf(time)) : null);
    }

    private final Token setAccessTokenExpiration(Token token, Long l) {
        return token.copy((229375 & 1) != 0 ? token.accessToken : null, (229375 & 2) != 0 ? token.refreshToken : null, (229375 & 4) != 0 ? token.swid : null, (229375 & 8) != 0 ? token.accessTokenTTL : null, (229375 & 16) != 0 ? token.refreshTokenTTL : null, (229375 & 32) != 0 ? token.highTrustTTL : null, (229375 & 64) != 0 ? token.initialGrantInChain : null, (229375 & 128) != 0 ? token.scope : null, (229375 & 256) != 0 ? token.idToken : null, (229375 & 512) != 0 ? token.authenticator : null, (229375 & 1024) != 0 ? token.loginValue : null, (229375 & 2048) != 0 ? token.clickbackType : null, (229375 & 4096) != 0 ? token.sessionTransferKey : null, (229375 & 8192) != 0 ? token.clientId : null, (229375 & 16384) != 0 ? token.iat : null, (229375 & 32768) != 0 ? token.accessExp : l, (229375 & 65536) != 0 ? token.refreshExp : null, (229375 & 131072) != 0 ? token.highTrustExp : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initiateScheduledRefresh(Guest guest, String sourceEventInfo) {
        Token token$OneID_release;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Initiating scheduled refresh sequence", null, 4, null);
        this.refreshHandler.removeCallbacks(this.refreshRunner);
        this.tokenRefreshRetryAttempts = 0;
        if (!getConnectivity$OneID_release().isConnected() || (token$OneID_release = guest.getToken$OneID_release()) == null) {
            return;
        }
        long jSecondsUntilExpiration = secondsUntilExpiration(token$OneID_release.getAccessExp());
        long jRoundToLong = jSecondsUntilExpiration < 30 ? 0L : MathKt.roundToLong(jSecondsUntilExpiration * 0.9d);
        Logger logger$OneID_release2 = getLogger$OneID_release();
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release2, TAG2, "Scheduling initial refresh of token in " + jRoundToLong + " seconds", null, 4, null);
        scheduleTokenRefresh(jRoundToLong, null, sourceEventInfo);
    }

    private final long secondsUntilExpiration(Long timestamp) {
        return ((timestamp != null ? new Date(timestamp.longValue()) : new Date()).getTime() - new Date().getTime()) / 1000;
    }

    private static final void scheduleTokenRefresh$scheduleRefresh(OneIDSession oneIDSession, long j, long j2, String str, String str2) {
        Logger logger$OneID_release = oneIDSession.getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Clearing refresh runner before reschedule", null, 4, null);
        oneIDSession.refreshHandler.removeCallbacks(oneIDSession.refreshRunner);
        if (j >= 0) {
            Logger logger$OneID_release2 = oneIDSession.getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG2, "Posting refresh runner with " + j2 + "ms delay", null, 4, null);
            oneIDSession.refreshRunner.setConversationId(str);
            oneIDSession.refreshRunner.setSourceEventInfo(str2);
            oneIDSession.refreshHandler.postDelayed(oneIDSession.refreshRunner, j2);
        }
    }

    @Override // com.disney.id.android.Session
    public void scheduleTokenRefresh(long delayUntilRefresh, @Nullable String conversationId, @Nullable String sourceEventInfo) {
        long j = delayUntilRefresh * 1000;
        if (this.refreshingToken.get()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "Token refresh happening already, consolidating requests", null, 4, null);
            return;
        }
        scheduleTokenRefresh$scheduleRefresh(this, delayUntilRefresh, j, conversationId, sourceEventInfo);
    }

    private final long calculateRefreshIntervalForExpiredToken(int attemptCount) {
        if (attemptCount == 0) {
            return 30L;
        }
        if (attemptCount > 12) {
            return 3600L;
        }
        return Math.min((long) (calculateRefreshIntervalForExpiredToken(attemptCount - 1) * 1.5d), 3600L);
    }

    private final long calculateRefreshIntervalForValidToken(int attemptCount, long tokenTTL) {
        long j = (long) (tokenTTL * (attemptCount == 0 ? 0.9d : 0.5d));
        if (tokenTTL < 480) {
            return Math.max(j, 30L);
        }
        return Math.max(j, 300L);
    }

    public final long nextTokenRefreshInterval$OneID_release(int attemptCount) {
        Token token$OneID_release;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Calculating refresh interval for attempt " + attemptCount, null, 4, null);
        if (!isLoggedIn()) {
            return -1L;
        }
        Guest guest = getGuestHandler$OneID_release().get();
        long jSecondsUntilExpiration = secondsUntilExpiration((guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getAccessExp());
        if (jSecondsUntilExpiration <= 0) {
            return calculateRefreshIntervalForExpiredToken(attemptCount);
        }
        return calculateRefreshIntervalForValidToken(attemptCount, jSecondsUntilExpiration);
    }

    @Nullable
    public final JsonObject processNewToken$OneID_release(@NotNull JsonElement data, @NotNull TrackerEventKey trackerEventKey) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(trackerEventKey, "trackerEventKey");
        JsonObject asJsonObject = null;
        try {
            JsonObject asJsonObject2 = data.getAsJsonObject();
            if (asJsonObject2 != null && (jsonElement = asJsonObject2.get("token")) != null) {
                asJsonObject = jsonElement.getAsJsonObject();
            }
        } catch (Exception e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Invalid token json", e);
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
            if (event != null) {
                event.appendCodes$OneID_release("INVALID_JSON", "UNKNOWN_ERROR", "exception(" + e.getMessage() + ")");
            }
        }
        if (asJsonObject != null) {
            asJsonObject.addProperty("created", new SimpleDateFormat(StringPatterns.dateFormatPattern, Locale.US).format(new Date()));
        }
        return asJsonObject;
    }

    public static /* synthetic */ void refreshToken$OneID_release$default(OneIDSession oneIDSession, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        oneIDSession.refreshToken$OneID_release(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void refreshToken$OneID_release(@org.jetbrains.annotations.Nullable final java.lang.String r29, @org.jetbrains.annotations.Nullable java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDSession.refreshToken$OneID_release(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleCompletions$OneID_release$default(OneIDSession oneIDSession, OneIDError oneIDError, JSONObject jSONObject, String str, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            oneIDError = null;
        }
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        oneIDSession.handleCompletions$OneID_release(oneIDError, jSONObject, str, list, function0);
    }

    public final void handleCompletions$OneID_release(@Nullable OneIDError error, @Nullable JSONObject ppuData, @Nullable String conversationId, @Nullable List<? extends PPU> ppus, @Nullable Function0<Unit> onCompletion) {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Refreshing token complete", null, 4, null);
        this.refreshingToken.set(false);
        if (onCompletion != null) {
            onCompletion.invoke();
        }
        if (error != null) {
            Session.Owner owner = getOwner();
            if (owner != null) {
                owner.tokenRefreshFailure(error);
                return;
            }
            return;
        }
        if (ppuData != null && conversationId != null) {
            Session.Owner owner2 = getOwner();
            if (owner2 != null) {
                owner2.tokenRefreshSuccess(ppuData, conversationId);
                return;
            }
            return;
        }
        if (ppus != null) {
            Session.Owner owner3 = getOwner();
            if (owner3 != null) {
                owner3.tokenRefreshPPU(ppus);
                return;
            }
            return;
        }
        if (ppuData != null) {
            Session.Owner owner4 = getOwner();
            if (owner4 != null) {
                owner4.tokenRefreshSuccess(ppuData, conversationId);
                return;
            }
            return;
        }
        Session.Owner owner5 = getOwner();
        if (owner5 != null) {
            owner5.tokenRefreshSuccess(null, null);
        }
    }

    @Override // com.disney.id.android.Session
    public void end(@Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId) {
        Session.Owner owner;
        Token token$OneID_release;
        Guest guest = getGuestHandler$OneID_release().get();
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Ending session // " + ((guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getSwid()), null, 4, null);
        this.refreshHandler.removeCallbacks(this.refreshRunner);
        getConnectivity$OneID_release().removeListener(this.tokenConnectivityListener);
        if (isLoggedIn()) {
            remoteLogout(optionalConfigs, conversationId);
        }
        clearLocalStorage(conversationId, optionalConfigs);
        if (guest == null || (owner = getOwner()) == null) {
            return;
        }
        owner.notifyOfLogout();
    }

    @Override // com.disney.id.android.Session
    public void notifyOwnerOfLogout() {
        Session.Owner owner = getOwner();
        if (owner != null) {
            owner.notifyOfLogout();
        }
    }

    private final void clearLocalStorage(String conversationId, OptionalConfigs optionalConfigs) {
        TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.LOG_CLEAR_STORAGE, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Clearing local storage", null, 4, null);
        boolean zIsLoggedIn = isLoggedIn();
        getGuestHandler$OneID_release().set(null);
        Set<String> setKeySet = getStorage$OneID_release().getAll().keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (StringsKt.startsWith$default((String) obj, getConfigHandler$OneID_release().get().getClientId(), false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, "clearResult(" + arrayList + ")", false, 44, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            getStorage$OneID_release().remove((String) it.next());
        }
        if (zIsLoggedIn) {
            getSwid$OneID_release().reset();
        }
    }

    private final void remoteLogout(OptionalConfigs optionalConfigs, String conversationId) {
        Token token$OneID_release;
        String refreshToken;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Calling logout service", null, 4, null);
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_LOGOUT, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        if (!getConnectivity$OneID_release().isConnected()) {
            Tracker tracker$OneID_release = getTracker$OneID_release();
            OneIDTrackerEvent event = tracker$OneID_release.getEvent(trackerEventKeyStartTransactionEvent$default);
            if (event != null) {
                OneIDTrackerEvent.appendCodes$OneID_release$default(event, "NO_CONNECTION", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, 4, null);
            }
            Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
            return;
        }
        Guest guest = getGuestHandler$OneID_release().get();
        if (guest != null && (token$OneID_release = guest.getToken$OneID_release()) != null && (refreshToken = token$OneID_release.getRefreshToken()) != null) {
            HashMap map = new HashMap();
            map.put("tokens", new String[]{refreshToken});
            getGcService$OneID_release().logout(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), getSwid$OneID_release().get(), map).enqueue(new TypeToken<BaseGCResponse<String>>() { // from class: com.disney.id.android.OneIDSession$remoteLogout$2$typeToken$1
            }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<String>>() { // from class: com.disney.id.android.OneIDSession$remoteLogout$2$1
                @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
                public void onResponseSuccess(@NotNull Response<BaseGCResponse<String>> response, @NotNull Response<BaseGCResponse<String>> unconvertedResponse) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                    Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                    String str = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.i$default(logger$OneID_release2, str, "GuestController service: logout success", null, 4, null);
                    OneIDTrackerEvent event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                    if (event2 != null) {
                        OneIDTrackerEvent.appendCodes$OneID_release$default(event2, null, null, "httpstatus(" + response.code() + ")", 3, null);
                    }
                    Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                }

                @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
                public void onResponseFailure(@NotNull Response<?> response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                    String str = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.w$default(logger$OneID_release2, str, "Failed to logout at server", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "httpstatus(" + response.code() + ")", false, 32, null);
                }

                @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
                public void onError(@NotNull Throwable throwable) {
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    this.this$0.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Unable to logout at server");
                }
            });
        } else {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG2, "remote logout can't find token.", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, true, OneIDTrackerEvent.ERROR_CODE_GUEST_HANDLER_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "missing(refreshToken)", false, 32, null);
        }
    }

    @Override // com.disney.id.android.Session
    public boolean isLoggedIn() {
        Token token$OneID_release;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Retrieving the login status", null, 4, null);
        Guest guest = getGuestHandler$OneID_release().get();
        if (guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) {
            return false;
        }
        String refreshToken = token$OneID_release.getRefreshToken();
        return (refreshToken != null ? StringsKt.isBlank(refreshToken) ^ true : false) && ((secondsUntilExpiration(token$OneID_release.getRefreshExp()) > 0L ? 1 : (secondsUntilExpiration(token$OneID_release.getRefreshExp()) == 0L ? 0 : -1)) > 0);
    }

    private final void setGuestFreshnessTimestamp() {
        Gson gsonCreateStandardGson$default = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null);
        GuestFreshnessTimestamp guestFreshnessTimestamp = new GuestFreshnessTimestamp(new Date().getTime());
        getStorage$OneID_release().put(getConfigHandler$OneID_release().get().getClientId() + ".lastDateRetrieved", gsonCreateStandardGson$default.toJson(guestFreshnessTimestamp));
    }

    @Override // com.disney.id.android.Session
    public void refreshGuest(@NotNull final Session.ResultCallback callback, @Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_REFRESH_GUEST, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        getGcService$OneID_release().getGuest(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), getSwid$OneID_release().get()).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$refreshGuest$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.refreshGuest.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) throws JsonIOException {
                GCResponseError error;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                if (baseGCResponseBody != null && (error = baseGCResponseBody.getError()) != null) {
                    callback.onFailure(OneIDSession.this.buildErrorFromResponse(trackerEventKeyStartTransactionEvent$default, error));
                    return;
                }
                BaseGCResponse<JsonElement> baseGCResponseBody2 = response.body();
                if ((baseGCResponseBody2 != null ? baseGCResponseBody2.getData() : null) != null) {
                    Logger logger$OneID_release = OneIDSession.this.getLogger$OneID_release();
                    String str = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "Guest successfully returned from GC", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                    OneIDSession oneIDSession = OneIDSession.this;
                    BaseGCResponse<JsonElement> baseGCResponseBody3 = response.body();
                    oneIDSession.saveGuestOrTokenToStorage$OneID_release(baseGCResponseBody3 != null ? baseGCResponseBody3.getData() : null, OneIDSession.this.getGuestHandler$OneID_release().getTransientToken());
                    OneIDSession.this.loadGuestFromStorage(trackerEventKeyStartTransactionEvent$default);
                    callback.onSuccess();
                    return;
                }
                Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                Logger logger$OneID_release2 = OneIDSession.this.getLogger$OneID_release();
                String str2 = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                Logger.DefaultImpls.w$default(logger$OneID_release2, str2, "Guest returned from GC caused an unexpected error", null, 4, null);
                callback.onFailure(new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed getting guest from GC"));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error getting guest from GC"));
            }
        });
    }

    public final void saveGuestOrTokenToStorage$OneID_release(@Nullable JsonElement guestJsonElement, @Nullable JsonElement tokenJsonElement) throws JsonIOException {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Saving guest or token to storage", null, 4, null);
        Gson gsonCreateStandardGson$default = GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null);
        Guest guest = getGuestHandler$OneID_release().get();
        JsonElement rawGuest$OneID_release = guest != null ? guest.getRawGuest$OneID_release() : null;
        JsonElement jsonElement2 = guestJsonElement == null ? rawGuest$OneID_release : guestJsonElement;
        JsonElement asJsonObject2 = tokenJsonElement == null ? (rawGuest$OneID_release == null || (asJsonObject = rawGuest$OneID_release.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("token")) == null) ? null : jsonElement.getAsJsonObject() : tokenJsonElement;
        if (jsonElement2 != null && asJsonObject2 != null) {
            jsonElement2.getAsJsonObject().add("token", asJsonObject2);
            setGuestFreshnessTimestamp();
            String json = gsonCreateStandardGson$default.toJson(jsonElement2);
            getStorage$OneID_release().put(getConfigHandler$OneID_release().get().getClientId() + ".guest", json);
            return;
        }
        Logger logger$OneID_release2 = getLogger$OneID_release();
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG2, "Attempt to save a null guest or token.  Both are required.", null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    @Override // com.disney.id.android.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateGuest(@org.jetbrains.annotations.NotNull com.google.gson.JsonObject r10, @org.jetbrains.annotations.Nullable com.disney.id.android.OptionalConfigs r11, @org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.NotNull final com.disney.id.android.OneIDCallback<com.disney.id.android.OneIDCallbackData> r13) {
        /*
            r9 = this;
            java.lang.String r0 = "updateBody"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.disney.id.android.tracker.Tracker r1 = r9.getTracker$OneID_release()
            com.disney.id.android.tracker.EventAction r3 = com.disney.id.android.tracker.EventAction.SERVICE_UPDATE_GUEST
            com.disney.id.android.SWID r0 = r9.getSwid$OneID_release()
            java.lang.String r4 = r0.get()
            r7 = 8
            r8 = 0
            r5 = 0
            r2 = r12
            r6 = r11
            com.disney.id.android.tracker.TrackerEventKey r11 = com.disney.id.android.tracker.Tracker.DefaultImpls.startTransactionEvent$default(r1, r2, r3, r4, r5, r6, r7, r8)
            com.disney.id.android.GuestHandler r12 = r9.getGuestHandler$OneID_release()
            kotlin.Pair r12 = r12.getStashed()
            if (r12 == 0) goto L5a
            java.lang.Object r12 = r12.getFirst()
            com.google.gson.JsonElement r12 = (com.google.gson.JsonElement) r12
            if (r12 == 0) goto L57
            com.google.gson.JsonObject r12 = r12.getAsJsonObject()
            if (r12 == 0) goto L57
            java.lang.String r0 = "data"
            com.google.gson.JsonObject r12 = r12.getAsJsonObject(r0)
            if (r12 == 0) goto L57
            java.lang.String r0 = "profile"
            com.google.gson.JsonObject r12 = r12.getAsJsonObject(r0)
            if (r12 == 0) goto L57
            java.lang.String r0 = "swid"
            com.google.gson.JsonElement r12 = r12.get(r0)
            if (r12 == 0) goto L57
            java.lang.String r12 = r12.getAsString()
            goto L58
        L57:
            r12 = 0
        L58:
            if (r12 != 0) goto L62
        L5a:
            com.disney.id.android.SWID r12 = r9.getSwid$OneID_release()
            java.lang.String r12 = r12.get()
        L62:
            com.disney.id.android.services.GCService r0 = r9.getGcService$OneID_release()
            java.lang.String r1 = r11.getId()
            java.lang.String r2 = r11.getActionName()
            com.disney.id.android.services.GCErrorHandlingAdapter$GCCall r10 = r0.updateGuest(r1, r2, r12, r10)
            com.disney.id.android.OneIDSession$updateGuest$typeToken$1 r12 = new com.disney.id.android.OneIDSession$updateGuest$typeToken$1
            r12.<init>()
            com.disney.id.android.OneIDSession$updateGuest$1 r0 = new com.disney.id.android.OneIDSession$updateGuest$1
            r0.<init>()
            r10.enqueue(r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDSession.updateGuest(com.google.gson.JsonObject, com.disney.id.android.OptionalConfigs, java.lang.String, com.disney.id.android.OneIDCallback):void");
    }

    @Override // com.disney.id.android.Session
    public void updateMarketing(@NotNull NewsletterDetails newsletterDetails, @Nullable OptionalConfigs optionalConfigs, @Nullable String conversationId, @NotNull final OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(newsletterDetails, "newsletterDetails");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_UPDATE_MARKETING, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        getGcService$OneID_release().updateMarketing(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), getNewsletterBodyForLoggedOutUser$OneID_release(newsletterDetails, optionalConfigs)).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$updateMarketing$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.updateMarketing.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) {
                OneIDError oneIDError;
                GCResponseError error;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                if (baseGCResponseBody == null || (error = baseGCResponseBody.getError()) == null) {
                    oneIDError = null;
                } else {
                    OneIDSession oneIDSession = OneIDSession.this;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback = callback;
                    String keyErrorCode = error.getKeyErrorCode();
                    String keyCategory = error.getKeyCategory();
                    if (Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_ADVISORY)) {
                        oneIDError = new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString()));
                    } else {
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, keyErrorCode, keyCategory, null, false, 32, null);
                        oneIDCallback.onFailure(new OneIDCallbackData(false, new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString()))));
                        return;
                    }
                }
                Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                callback.onSuccess(new OneIDCallbackData(true, oneIDError));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed updating marketing on GC")));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error updating marketing on GC")));
            }
        });
    }

    @NotNull
    public final JsonObject getNewsletterBodyForLoggedOutUser$OneID_release(@NotNull NewsletterDetails buDetails, @Nullable OptionalConfigs options) {
        String reportingSource;
        Intrinsics.checkNotNullParameter(buDetails, "buDetails");
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("email", buDetails.getEmail());
        jsonObject2.addProperty("countryCodeDetected", getCountryCode());
        jsonObject.add("profile", jsonObject2);
        JsonArray jsonArray = new JsonArray();
        for (MarketingDetail marketingDetail : buDetails.getMarketing()) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("code", marketingDetail.getCode());
            jsonObject3.addProperty("subscribed", Boolean.valueOf(marketingDetail.getSubscribed()));
            jsonObject3.addProperty("textID", marketingDetail.getTextId());
            jsonArray.add(jsonObject3);
        }
        jsonObject.add("marketing", jsonArray);
        JsonArray jsonArray2 = new JsonArray();
        List<LegalDetail> legal = buDetails.getLegal();
        if (legal != null) {
            for (LegalDetail legalDetail : legal) {
                if (legalDetail.getAccepted()) {
                    jsonArray2.add(legalDetail.getCode());
                }
            }
        }
        jsonObject.add("legalAssertions", jsonArray2);
        jsonObject.addProperty("campaign", buDetails.getCampaignId());
        if (options == null || (reportingSource = options.getReportingSource()) == null) {
            reportingSource = "";
        }
        jsonObject.addProperty("marketingSource", reportingSource);
        return jsonObject;
    }

    @Override // com.disney.id.android.Session
    @Nullable
    public String getCountryCode() {
        String region;
        Guest guest = getGuestHandler$OneID_release().get();
        Profile profile = guest != null ? guest.getProfile() : null;
        if (profile != null && (region = profile.getRegion()) != null) {
            return region;
        }
        String countryCodeDetected = profile != null ? profile.getCountryCodeDetected() : null;
        return countryCodeDetected == null ? getScalpController$OneID_release().getCountryCode() : countryCodeDetected;
    }

    @Override // com.disney.id.android.Session
    public boolean highTrust() {
        Token token$OneID_release;
        Guest guest = getGuestHandler$OneID_release().get();
        return secondsUntilExpiration((guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getHighTrustExp()) > 0;
    }

    @Override // com.disney.id.android.Session
    public void login(@NotNull String loginValue, @NotNull String password, @NotNull final OneIDCallback<GuestCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_LOGIN, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        getGcService$OneID_release().login(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), MapsKt.mapOf(TuplesKt.to("loginValue", loginValue), TuplesKt.to(HintConstants.AUTOFILL_HINT_PASSWORD, password))).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$login$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.login.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) throws JsonIOException {
                String str;
                OneIDError oneIDError;
                String str2;
                JsonElement data;
                OneIDError oneIDError2;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                GCResponseError error = baseGCResponseBody != null ? baseGCResponseBody.getError() : null;
                if (error == null) {
                    str = null;
                    oneIDError = null;
                    str2 = "UNKNOWN_ERROR";
                } else {
                    OneIDSession oneIDSession = OneIDSession.this;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback = callback;
                    String keyErrorCode = error.getKeyErrorCode();
                    String keyCategory = error.getKeyCategory();
                    if (Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_ADVISORY)) {
                        oneIDError2 = new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString()));
                        str = keyCategory;
                        str2 = keyErrorCode;
                    } else if (!Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_PPU_ACTIONABLE_INPUT)) {
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, keyErrorCode, keyCategory, null, false, 32, null);
                        oneIDCallback.onFailure(new GuestCallbackData(false, new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString())), null, null, null, null, 56, null));
                        return;
                    } else {
                        str = keyCategory;
                        str2 = keyErrorCode;
                        oneIDError2 = null;
                    }
                    oneIDError = oneIDError2;
                }
                BaseGCResponse<JsonElement> baseGCResponseBody2 = response.body();
                if (baseGCResponseBody2 != null && (data = baseGCResponseBody2.getData()) != null) {
                    OneIDSession oneIDSession2 = OneIDSession.this;
                    TrackerEventKey trackerEventKey2 = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback2 = callback;
                    JsonObject jsonObjectProcessNewToken$OneID_release = oneIDSession2.processNewToken$OneID_release(data, trackerEventKey2);
                    if (jsonObjectProcessNewToken$OneID_release != null) {
                        List listBuildPPUList = error != null ? oneIDSession2.buildPPUList(error) : null;
                        if (listBuildPPUList != null) {
                            Logger logger$OneID_release = oneIDSession2.getLogger$OneID_release();
                            String str3 = OneIDSession.TAG;
                            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                            Logger.DefaultImpls.d$default(logger$OneID_release, str3, "Stashing guest and returning PPU", null, 4, null);
                            oneIDSession2.getGuestHandler$OneID_release().setStashed(data, jsonObjectProcessNewToken$OneID_release);
                            Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, false, str2, str, null, false, 48, null);
                            oneIDCallback2.onFailure(new GuestCallbackData(false, new OneIDError(str2, str, null, 4, null), null, null, listBuildPPUList, null, 44, null));
                            return;
                        }
                        oneIDSession2.getGuestHandler$OneID_release().setStashed(null, null);
                        oneIDSession2.saveGuestOrTokenToStorage$OneID_release(data, jsonObjectProcessNewToken$OneID_release);
                        oneIDSession2.loadGuestFromStorage(trackerEventKey2);
                        Logger logger$OneID_release2 = oneIDSession2.getLogger$OneID_release();
                        String str4 = OneIDSession.TAG;
                        Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release2, str4, "Guest successfully returned from GC", null, 4, null);
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, false, null, null, null, false, 62, null);
                        oneIDCallback2.onSuccess(new GuestCallbackData(true, oneIDError, oneIDSession2.getGuestHandler$OneID_release().get(), null, null, null, 56, null));
                        return;
                    }
                    Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(token)", false, 32, null);
                    Logger logger$OneID_release3 = oneIDSession2.getLogger$OneID_release();
                    String str5 = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.w$default(logger$OneID_release3, str5, "Guest returned from GC caused an unexpected error", null, 4, null);
                    oneIDCallback2.onFailure(new GuestCallbackData(false, new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())), null, null, null, null, 56, null));
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                OneIDSession oneIDSession3 = OneIDSession.this;
                TrackerEventKey trackerEventKey3 = trackerEventKeyStartTransactionEvent$default;
                OneIDCallback oneIDCallback3 = callback;
                Tracker.DefaultImpls.finishEvent$default(oneIDSession3.getTracker$OneID_release(), trackerEventKey3, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(data)", false, 32, null);
                Logger logger$OneID_release4 = oneIDSession3.getLogger$OneID_release();
                String str6 = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
                Logger.DefaultImpls.w$default(logger$OneID_release4, str6, "Guest returned from GC caused an unexpected error", null, 4, null);
                oneIDCallback3.onFailure(new GuestCallbackData(false, new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())), null, null, null, null, 56, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed getting guest from GC"), null, null, null, null, 56, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error getting guest from GC"), null, null, null, null, 56, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List buildPPUList(GCResponseError responseError) {
        List<GCError> errors;
        JsonObject asJsonObject;
        JsonArray asJsonArray;
        String inputName;
        String keyCategory = responseError.getKeyCategory();
        ArrayList arrayList = new ArrayList();
        if ((Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_PPU_ACTIONABLE_INPUT) || Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT)) && (errors = responseError.getErrors()) != null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Attempting to create PPUs from login response", null, 4, null);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (GCError gCError : errors) {
                String code = gCError.getCode();
                OneIDTrackerEvent.Companion companion = OneIDTrackerEvent.INSTANCE;
                if (ArraysKt.contains(companion.getLEGAL_PPU_CODES(), code)) {
                    JsonElement data = gCError.getData();
                    if (data != null && (asJsonObject = data.getAsJsonObject()) != null && (asJsonArray = asJsonObject.getAsJsonArray("disclosures")) != null) {
                        Intrinsics.checkNotNull(asJsonArray);
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            JsonObject asJsonObject2 = it.next().getAsJsonObject();
                            Intrinsics.checkNotNullExpressionValue(asJsonObject2, "getAsJsonObject(...)");
                            arrayList2.add(buildLegalDetail(asJsonObject2));
                        }
                    }
                } else if (ArraysKt.contains(companion.getPROFILE_PPU_CODES(), code) && (inputName = gCError.getInputName()) != null) {
                    arrayList3.add(new Field(inputName, true, null));
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new LegalPPU(arrayList2));
            }
            if (!arrayList3.isEmpty()) {
                arrayList.add(new ProfileChangePPU(arrayList3));
            }
        }
        return arrayList;
    }

    private final LegalDetail buildLegalDetail(JsonObject disclosure) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3 = disclosure.get("content");
        String asString = null;
        JsonObject asJsonObject = jsonElement3 != null ? jsonElement3.getAsJsonObject() : null;
        JsonArray asJsonArray = (asJsonObject == null || (jsonElement2 = asJsonObject.get("links")) == null) ? null : jsonElement2.getAsJsonArray();
        List listBuildPlainTextLinks = asJsonArray != null ? buildPlainTextLinks(asJsonArray) : null;
        JsonElement jsonElement4 = disclosure.get("disclosureCode");
        String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
        JsonElement jsonElement5 = disclosure.get("requiresActiveConsent");
        Boolean boolValueOf = jsonElement5 != null ? Boolean.valueOf(jsonElement5.getAsBoolean()) : null;
        if (asJsonObject != null && (jsonElement = asJsonObject.get("text")) != null) {
            asString = jsonElement.getAsString();
        }
        return new LegalDetail(asString2, boolValueOf, false, asString, listBuildPlainTextLinks);
    }

    private final List buildPlainTextLinks(JsonArray linkElements) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = linkElements.iterator();
        while (it.hasNext()) {
            JsonObject asJsonObject = it.next().getAsJsonObject();
            JsonElement jsonElement = asJsonObject.get(ViewProps.START);
            String asString = null;
            Integer numValueOf = jsonElement != null ? Integer.valueOf(jsonElement.getAsInt()) : null;
            JsonElement jsonElement2 = asJsonObject.get("label");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            JsonElement jsonElement3 = asJsonObject.get("href");
            if (jsonElement3 != null) {
                asString = jsonElement3.getAsString();
            }
            arrayList.add(new PlainTextLink(numValueOf, asString2, asString));
        }
        return arrayList;
    }

    @Override // com.disney.id.android.Session
    public void getGuestFlow(@NotNull String loginValue, @NotNull final OneIDCallback<GuestFlowCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_GUESTFLOW, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        getGcService$OneID_release().getGuestflow(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), MapsKt.mapOf(TuplesKt.to("email", loginValue))).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$getGuestFlow$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.getGuestFlow.1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) throws JSONException {
                JsonElement data;
                GCResponseError error;
                GCErrorContent content;
                GCErrorContent content2;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                Logger logger$OneID_release = OneIDSession.this.getLogger$OneID_release();
                String str = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuestFlow // onResponseSuccess", null, 4, null);
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + unconvertedResponse.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                if (baseGCResponseBody != null && (error = baseGCResponseBody.getError()) != null) {
                    OneIDSession oneIDSession = OneIDSession.this;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback = callback;
                    Logger logger$OneID_release2 = oneIDSession.getLogger$OneID_release();
                    String str2 = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, str2, "getGuestFlow // have error body // " + error, null, 4, null);
                    List<GCError> errors = error.getErrors();
                    if (errors == null || errors.isEmpty()) {
                        OneIDError oneIDError = new OneIDError("UNKNOWN_ERROR", "No errors in error collection", null, 4, null);
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(error)", false, 32, null);
                        oneIDCallback.onFailure(new GuestFlowCallbackData(null, false, oneIDError, 1, null));
                        return;
                    }
                    List<GCError> errors2 = error.getErrors();
                    GCError gCError = errors2 != null ? (GCError) CollectionsKt.first((List) errors2) : null;
                    if (StringsKt.equals$default(error.getKeyCategory(), OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, false, 2, null)) {
                        if (StringsKt.equals$default(gCError != null ? gCError.getInputName() : null, "email", false, 2, null)) {
                            OneIDError oneIDError2 = new OneIDError("INVALID_LOGIN_VALUE", (gCError == null || (content2 = gCError.getContent()) == null) ? null : content2.getText(), null, 4, null);
                            Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, gCError != null ? gCError.getCode() : null, error.getKeyCategory(), null, false, 48, null);
                            oneIDCallback.onFailure(new GuestFlowCallbackData(null, false, oneIDError2, 1, null));
                            return;
                        }
                    }
                    if (!StringsKt.equals$default(error.getKeyCategory(), OneIDTrackerEvent.ERROR_CATEGORY_ADVISORY, false, 2, null)) {
                        if (gCError != null && (content = gCError.getContent()) != null) {
                            text = content.getText();
                        }
                        OneIDError oneIDError3 = new OneIDError("UNKNOWN_ERROR", text, null, 4, null);
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, error.getKeyErrorCode(), error.getKeyCategory(), null, false, 48, null);
                        oneIDCallback.onFailure(new GuestFlowCallbackData(null, false, oneIDError3, 1, null));
                        return;
                    }
                }
                BaseGCResponse<JsonElement> baseGCResponseBody2 = response.body();
                if (baseGCResponseBody2 == null || (data = baseGCResponseBody2.getData()) == null) {
                    OneIDSession oneIDSession2 = OneIDSession.this;
                    TrackerEventKey trackerEventKey2 = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback2 = callback;
                    Logger logger$OneID_release3 = oneIDSession2.getLogger$OneID_release();
                    String str3 = OneIDSession.TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.wtf$default(logger$OneID_release3, str3, "Lack of data in response, code should have exited before now.", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(data)", false, 32, null);
                    oneIDCallback2.onFailure(new GuestFlowCallbackData(null, false, new OneIDError("UNKNOWN_ERROR", "The service did not return data", null, 4, null), 1, null));
                    return;
                }
                OneIDSession oneIDSession3 = OneIDSession.this;
                TrackerEventKey trackerEventKey3 = trackerEventKeyStartTransactionEvent$default;
                OneIDCallback oneIDCallback3 = callback;
                String string = new JSONObject(data.toString()).getString("guestFlow");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -1398051596:
                            if (string.equals("REGISTRATION_FLOW")) {
                                text = GuestFlow.REGISTER;
                                break;
                            }
                            break;
                        case -1233395612:
                            if (string.equals("LOGIN_FLOW")) {
                                text = GuestFlow.LOGIN;
                                break;
                            }
                            break;
                        case -641365302:
                            if (string.equals("CONTACT_CSR_FLOW")) {
                                text = GuestFlow.CONTACT_CSR;
                                break;
                            }
                            break;
                        case 822523800:
                            if (string.equals("RECOVERY_FLOW")) {
                                text = GuestFlow.RECOVERY;
                                break;
                            }
                            break;
                    }
                }
                if (text == null) {
                    OneIDError oneIDError4 = new OneIDError("UNKNOWN_ERROR", "Couldn't parse the guest flow response", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneIDSession3.getTracker$OneID_release(), trackerEventKey3, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "flow(unknown)", false, 32, null);
                    oneIDCallback3.onFailure(new GuestFlowCallbackData(null, false, oneIDError4, 1, null));
                    return;
                }
                Tracker.DefaultImpls.finishEvent$default(oneIDSession3.getTracker$OneID_release(), trackerEventKey3, false, null, null, "flow(" + text + ")", false, 44, null);
                oneIDCallback3.onSuccess(new GuestFlowCallbackData(text, true, null, 4, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new GuestFlowCallbackData(null, false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to get guest-flow at server"), 1, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new GuestFlowCallbackData(null, false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Unable to get guest-flow at server"), 1, null));
            }
        });
    }

    private final JsonObject getRegisterBody(List fields, List marketing, List legal, OptionalConfigs options) {
        String reportingSource;
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        Iterator it = fields.iterator();
        while (it.hasNext()) {
            Field field = (Field) it.next();
            if (Intrinsics.areEqual(field.getName(), HintConstants.AUTOFILL_HINT_PASSWORD)) {
                String value = field.getValue();
                if (value != null) {
                    jsonObject.addProperty(field.getName(), value);
                }
            } else {
                String value2 = field.getValue();
                if (value2 != null) {
                    jsonObject2.addProperty(field.getName(), value2);
                }
            }
        }
        jsonObject.add("profile", jsonObject2);
        if (marketing != null) {
            JsonArray jsonArray = new JsonArray();
            Iterator it2 = marketing.iterator();
            while (it2.hasNext()) {
                MarketingDetail marketingDetail = (MarketingDetail) it2.next();
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("code", marketingDetail.getCode());
                jsonObject3.addProperty("subscribed", Boolean.valueOf(marketingDetail.getSubscribed()));
                jsonObject3.addProperty("textID", marketingDetail.getTextId());
                jsonArray.add(jsonObject3);
            }
            jsonObject.add("marketing", jsonArray);
            if (options == null || (reportingSource = options.getReportingSource()) == null) {
                reportingSource = "";
            }
            jsonObject.addProperty("marketingSource", reportingSource);
        }
        if (legal != null) {
            JsonArray jsonArray2 = new JsonArray();
            Iterator it3 = legal.iterator();
            while (it3.hasNext()) {
                LegalDetail legalDetail = (LegalDetail) it3.next();
                if (legalDetail.getAccepted()) {
                    jsonArray2.add(legalDetail.getCode());
                }
            }
            jsonObject.add("legalAssertions", jsonArray2);
        }
        return jsonObject;
    }

    private final boolean getAutogenerateUsernameQuery(List fields) {
        Object next;
        String value;
        Iterator it = fields.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Field) next).getName(), "username")) {
                break;
            }
        }
        Field field = (Field) next;
        if (field == null) {
            return getScalpController$OneID_release().canAutogenerateUsername();
        }
        return field.getRequired() && ((value = field.getValue()) == null || StringsKt.isBlank(value)) && getScalpController$OneID_release().canAutogenerateUsername();
    }

    @Override // com.disney.id.android.Session
    public void register(@NotNull List<Field> fields, @Nullable List<MarketingDetail> marketing, @Nullable List<LegalDetail> legal, @NotNull final OneIDCallback<GuestCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_REGISTER, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        getGcService$OneID_release().register(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), getRegisterBody(fields, marketing, legal, optionalConfigs), Boolean.valueOf(getAutogenerateUsernameQuery(fields))).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$register$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.register.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) throws JsonIOException {
                JsonElement data;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                OneIDError oneIDErrorHandleGuestError = OneIDSession.this.handleGuestError(baseGCResponseBody != null ? baseGCResponseBody.getError() : null, trackerEventKeyStartTransactionEvent$default, callback);
                if (baseGCResponseBody != null && (data = baseGCResponseBody.getData()) != null) {
                    OneIDSession oneIDSession = OneIDSession.this;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback = callback;
                    GuestCallbackData guestCallbackDataBuildGuestCallbackData = oneIDSession.buildGuestCallbackData(data, trackerEventKey, oneIDErrorHandleGuestError, response);
                    if (guestCallbackDataBuildGuestCallbackData.getSuccess()) {
                        oneIDCallback.onSuccess(guestCallbackDataBuildGuestCallbackData);
                        return;
                    } else {
                        oneIDCallback.onFailure(guestCallbackDataBuildGuestCallbackData);
                        return;
                    }
                }
                OneIDSession oneIDSession2 = OneIDSession.this;
                TrackerEventKey trackerEventKey2 = trackerEventKeyStartTransactionEvent$default;
                OneIDCallback oneIDCallback2 = callback;
                Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(data)", false, 32, null);
                Logger logger$OneID_release = oneIDSession2.getLogger$OneID_release();
                String str = OneIDSession.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.w$default(logger$OneID_release, str, "Guest returned from GC caused an unexpected error", null, 4, null);
                oneIDCallback2.onFailure(new GuestCallbackData(false, new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())), null, Boolean.FALSE, null, null, 48, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to register guest with GC"), null, Boolean.FALSE, null, null, 48, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error registering guest with GC"), null, Boolean.FALSE, null, null, 48, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuestCallbackData buildGuestCallbackData(JsonElement data, TrackerEventKey trackerEventKey, OneIDError ppuError, Response response) throws JsonIOException {
        JsonObject jsonObjectProcessNewToken$OneID_release = processNewToken$OneID_release(data, trackerEventKey);
        if (jsonObjectProcessNewToken$OneID_release != null) {
            saveGuestOrTokenToStorage$OneID_release(data, jsonObjectProcessNewToken$OneID_release);
            loadGuestFromStorage(trackerEventKey);
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Guest successfully returned from GC", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
            return new GuestCallbackData(true, ppuError, getGuestHandler$OneID_release().get(), Boolean.TRUE, null, null, 48, null);
        }
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "missing(token)", false, 32, null);
        Logger logger$OneID_release2 = getLogger$OneID_release();
        String TAG3 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
        Logger.DefaultImpls.w$default(logger$OneID_release2, TAG3, "Guest returned from GC has no token", null, 4, null);
        return new GuestCallbackData(false, new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())), null, Boolean.FALSE, null, null, 48, null);
    }

    @Override // com.disney.id.android.Session
    public void beginRecovery(@NotNull LookupValue lookupValue, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs, @NotNull final OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(lookupValue, "lookupValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), null, EventAction.SERVICE_OTP_RECOVERY, getSwid$OneID_release().get(), null, optionalConfigs, 9, null);
        GCService gcService$OneID_release = getGcService$OneID_release();
        String id = trackerEventKeyStartTransactionEvent$default.getId();
        String actionName = trackerEventKeyStartTransactionEvent$default.getActionName();
        JsonObject jsonObject = new JsonObject();
        if (!(lookupValue instanceof LookupValue.Email)) {
            throw new NoWhenBranchMatchedException();
        }
        jsonObject.addProperty("lookupValue", (String) LookupValueKt.getExhaustive(((LookupValue.Email) lookupValue).getEmail()));
        Unit unit = Unit.INSTANCE;
        gcService$OneID_release.notificationOtpRecovery(id, actionName, jsonObject).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$beginRecovery$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.beginRecovery.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) {
                String keyErrorMessage;
                JsonElement jsonElement;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                JsonElement data = baseGCResponseBody != null ? baseGCResponseBody.getData() : null;
                JsonObject jsonObject2 = data instanceof JsonObject ? (JsonObject) data : null;
                String asString = (jsonObject2 == null || (jsonElement = jsonObject2.get(OneIDRecoveryContext.SESSION_ID)) == null) ? null : jsonElement.getAsString();
                if (asString != null) {
                    OneIDSession.this.getRecoveryContext$OneID_release().setSessionId(asString);
                    Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                    callback.onSuccess(new OneIDCallbackData(true, null, 2, null));
                    return;
                }
                GCResponseError error = baseGCResponseBody != null ? baseGCResponseBody.getError() : null;
                String keyErrorCode = error != null ? error.getKeyErrorCode() : null;
                Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, keyErrorCode, error != null ? error.getKeyCategory() : null, null, false, 48, null);
                if (keyErrorCode == null) {
                    keyErrorCode = "UNKNOWN_ERROR";
                }
                String str = keyErrorCode;
                if (error == null || (keyErrorMessage = error.getKeyErrorMessage()) == null) {
                    keyErrorMessage = "";
                }
                callback.onFailure(new OneIDCallbackData(false, new OneIDError(str, keyErrorMessage, null, 4, null)));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to begin recovery with GC")));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error calling begin recovery with email on GC")));
            }
        });
    }

    @Override // com.disney.id.android.Session
    public void validateOTP(@NotNull String otp, @NotNull final OneIDCallback<OneIDCallbackData> callback, @Nullable String conversationId, @Nullable OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_OTP_REDEEM, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("passcode", otp);
        JsonArray jsonArray = new JsonArray();
        String sessionId = getRecoveryContext$OneID_release().getSessionId();
        if (sessionId != null) {
            jsonArray.add(sessionId);
        }
        jsonObject.add("sessionIds", jsonArray);
        getGcService$OneID_release().otpRedeem(trackerEventKeyStartTransactionEvent$default.getId(), trackerEventKeyStartTransactionEvent$default.getActionName(), jsonObject).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$validateOTP$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.validateOTP.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) {
                Pair pair;
                JsonArray asJsonArray;
                JsonElement jsonElement;
                JsonObject asJsonObject;
                JsonPrimitive asJsonPrimitive;
                JsonObject asJsonObject2;
                JsonPrimitive asJsonPrimitive2;
                GCResponseError error;
                JsonElement data;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                Unit unit = null;
                JsonObject asJsonObject3 = (baseGCResponseBody == null || (data = baseGCResponseBody.getData()) == null || !data.isJsonObject()) ? null : data.getAsJsonObject();
                if (baseGCResponseBody != null && (error = baseGCResponseBody.getError()) != null) {
                    callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromResponse(trackerEventKeyStartTransactionEvent$default, error)));
                    unit = Unit.INSTANCE;
                } else {
                    Pair pair2 = new Pair((asJsonObject3 == null || (asJsonObject2 = asJsonObject3.getAsJsonObject("recoveryToken")) == null || (asJsonPrimitive2 = asJsonObject2.getAsJsonPrimitive(Token.ACCESS_TOKEN)) == null) ? null : asJsonPrimitive2.getAsString(), (asJsonObject3 == null || (asJsonArray = asJsonObject3.getAsJsonArray("accountRecoveryProfiles")) == null || (jsonElement = (JsonElement) CollectionsKt.firstOrNull(asJsonArray)) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (asJsonPrimitive = asJsonObject.getAsJsonPrimitive("swid")) == null) ? null : asJsonPrimitive.getAsString());
                    if (pair2.getFirst() == null || pair2.getSecond() == null) {
                        pair = null;
                    } else {
                        Object first = pair2.getFirst();
                        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.String");
                        Object second = pair2.getSecond();
                        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.String");
                        pair = new Pair((String) first, (String) second);
                    }
                    if (pair != null) {
                        OneIDSession oneIDSession = OneIDSession.this;
                        TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                        OneIDCallback oneIDCallback = callback;
                        oneIDSession.getRecoveryContext$OneID_release().save((String) pair.component1(), (String) pair.component2());
                        Logger logger$OneID_release = oneIDSession.getLogger$OneID_release();
                        String str = OneIDSession.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "access token successfully returned from GC", null, 4, null);
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                        oneIDCallback.onSuccess(new OneIDCallbackData(true, null, 2, null));
                        unit = Unit.INSTANCE;
                    }
                }
                if (unit == null) {
                    callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorInvalidJson(trackerEventKeyStartTransactionEvent$default, response)));
                }
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to validate OTP with GC")));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new OneIDCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error validating OTP with GC")));
            }
        });
    }

    @Override // com.disney.id.android.Session
    public void completeRecovery(@Nullable final String password, @NotNull final OneIDCallback<GuestCallbackData> callback, @Nullable final String conversationId, @Nullable final OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_LOGIN_RECOVERY, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        GCService gcService$OneID_release = getGcService$OneID_release();
        String id = trackerEventKeyStartTransactionEvent$default.getId();
        String actionName = trackerEventKeyStartTransactionEvent$default.getActionName();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("recoveryToken", getRecoveryContext$OneID_release().getAccessToken());
        jsonObject.addProperty("swid", getRecoveryContext$OneID_release().getSwid());
        Unit unit = Unit.INSTANCE;
        gcService$OneID_release.loginRecoveryToken(id, actionName, jsonObject).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$completeRecovery$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.completeRecovery.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) throws JsonIOException {
                String str;
                OneIDError oneIDError;
                String str2;
                JsonElement data;
                JsonObject asJsonObject;
                OneIDCallback oneIDCallback;
                String str3;
                String str4;
                GuestCallbackData guestCallbackData;
                OneIDError oneIDError2;
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                GCResponseError error = baseGCResponseBody != null ? baseGCResponseBody.getError() : null;
                if (error == null) {
                    str = null;
                    oneIDError = null;
                    str2 = "UNKNOWN_ERROR";
                } else {
                    OneIDSession oneIDSession = OneIDSession.this;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartTransactionEvent$default;
                    OneIDCallback oneIDCallback2 = callback;
                    String keyErrorCode = error.getKeyErrorCode();
                    String keyCategory = error.getKeyCategory();
                    if (Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_ADVISORY)) {
                        oneIDError2 = new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString()));
                        str = keyCategory;
                        str2 = keyErrorCode;
                    } else if (!Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_PPU_ACTIONABLE_INPUT)) {
                        Tracker.DefaultImpls.finishEvent$default(oneIDSession.getTracker$OneID_release(), trackerEventKey, false, keyErrorCode, keyCategory, null, false, 32, null);
                        oneIDCallback2.onFailure(new GuestCallbackData(false, new OneIDError(keyErrorCode, keyCategory, new Exception(error.toString())), null, null, null, null, 60, null));
                        return;
                    } else {
                        str = keyCategory;
                        str2 = keyErrorCode;
                        oneIDError2 = null;
                    }
                    oneIDError = oneIDError2;
                }
                if (baseGCResponseBody != null && (data = baseGCResponseBody.getData()) != null && (asJsonObject = data.getAsJsonObject()) != null) {
                    OneIDSession oneIDSession2 = OneIDSession.this;
                    TrackerEventKey trackerEventKey2 = trackerEventKeyStartTransactionEvent$default;
                    String str5 = password;
                    OneIDCallback oneIDCallback3 = callback;
                    String str6 = conversationId;
                    OptionalConfigs optionalConfigs2 = optionalConfigs;
                    JsonObject jsonObjectProcessNewToken$OneID_release = oneIDSession2.processNewToken$OneID_release(asJsonObject, trackerEventKey2);
                    if (jsonObjectProcessNewToken$OneID_release != null) {
                        List listBuildPPUList = error != null ? oneIDSession2.buildPPUList(error) : null;
                        if (listBuildPPUList != null) {
                            Logger logger$OneID_release = oneIDSession2.getLogger$OneID_release();
                            String str7 = OneIDSession.TAG;
                            Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                            Logger.DefaultImpls.d$default(logger$OneID_release, str7, "Stashing guest and returning PPU", null, 4, null);
                            oneIDSession2.getGuestHandler$OneID_release().setStashed(asJsonObject, jsonObjectProcessNewToken$OneID_release);
                            str4 = str6;
                            Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, false, str2, str, null, false, 48, null);
                            guestCallbackData = new GuestCallbackData(false, new OneIDError(str2, str, null, 4, null), null, null, listBuildPPUList, null, 44, null);
                            oneIDCallback = oneIDCallback3;
                            str3 = str5;
                        } else {
                            str4 = str6;
                            oneIDSession2.saveGuestOrTokenToStorage$OneID_release(asJsonObject, jsonObjectProcessNewToken$OneID_release);
                            oneIDSession2.loadGuestFromStorage(trackerEventKey2);
                            Logger logger$OneID_release2 = oneIDSession2.getLogger$OneID_release();
                            String str8 = OneIDSession.TAG;
                            Intrinsics.checkNotNullExpressionValue(str8, "access$getTAG$cp(...)");
                            Logger.DefaultImpls.d$default(logger$OneID_release2, str8, "Guest successfully returned from GC", null, 4, null);
                            Tracker.DefaultImpls.finishEvent$default(oneIDSession2.getTracker$OneID_release(), trackerEventKey2, false, null, null, null, false, 62, null);
                            oneIDCallback = oneIDCallback3;
                            str3 = str5;
                            guestCallbackData = new GuestCallbackData(true, oneIDError, oneIDSession2.getGuestHandler$OneID_release().get(), null, null, null, 56, null);
                        }
                    } else {
                        oneIDCallback = oneIDCallback3;
                        str3 = str5;
                        str4 = str6;
                        Tracker tracker$OneID_release = oneIDSession2.getTracker$OneID_release();
                        if (str == null) {
                            str = OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR;
                        }
                        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey2, true, str2, str, "missing(token)", false, 32, null);
                        Logger logger$OneID_release3 = oneIDSession2.getLogger$OneID_release();
                        String str9 = OneIDSession.TAG;
                        Intrinsics.checkNotNullExpressionValue(str9, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.w$default(logger$OneID_release3, str9, "Guest returned from GC has no token", null, 4, null);
                        guestCallbackData = new GuestCallbackData(false, new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString())), null, Boolean.FALSE, null, null, 48, null);
                    }
                    GuestCallbackData guestCallbackData2 = guestCallbackData;
                    if (!guestCallbackData2.getSuccess() && guestCallbackData2.getPpus() == null) {
                        oneIDCallback.onFailure(guestCallbackData2);
                        return;
                    }
                    if (str3 != null) {
                        oneIDSession2.changePassword(str3, guestCallbackData2, oneIDCallback, str4, optionalConfigs2);
                        return;
                    }
                    oneIDSession2.getRecoveryContext$OneID_release().clear();
                    if (guestCallbackData2.getSuccess()) {
                        oneIDCallback.onSuccess(guestCallbackData2);
                        return;
                    } else {
                        oneIDCallback.onFailure(guestCallbackData2);
                        return;
                    }
                }
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorInvalidJson(trackerEventKeyStartTransactionEvent$default, response), null, null, null, null, 60, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to validate OTP with GC"), null, null, null, null, 60, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error validating OTP with GC"), null, null, null, null, 60, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changePassword(String password, final GuestCallbackData guestData, final OneIDCallback callback, final String conversationId, final OptionalConfigs optionalConfigs) {
        Profile profile;
        final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_CLICKBACK_CHANGE_PASSWORD, getSwid$OneID_release().get(), null, optionalConfigs, 8, null);
        GCService gcService$OneID_release = getGcService$OneID_release();
        String id = trackerEventKeyStartTransactionEvent$default.getId();
        String actionName = trackerEventKeyStartTransactionEvent$default.getActionName();
        JsonObject jsonObject = new JsonObject();
        Guest guest = guestData.getGuest();
        jsonObject.addProperty("loginValue", (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getEmail());
        jsonObject.addProperty(HintConstants.AUTOFILL_HINT_NEW_PASSWORD, password);
        Unit unit = Unit.INSTANCE;
        gcService$OneID_release.changePassword(id, actionName, jsonObject).enqueue(new TypeToken<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession$changePassword$typeToken$1
        }, new GCErrorHandlingAdapter.GCCallback<BaseGCResponse<JsonElement>>() { // from class: com.disney.id.android.OneIDSession.changePassword.1
            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseSuccess(@NotNull Response<BaseGCResponse<JsonElement>> response, @NotNull Response<BaseGCResponse<JsonElement>> unconvertedResponse) {
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(unconvertedResponse, "unconvertedResponse");
                OneIDTrackerEvent event = OneIDSession.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                if (event != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                int iCode = unconvertedResponse.code();
                if (iCode == 200) {
                    OneIDSession.this.getRecoveryContext$OneID_release().clear();
                    Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                    if (guestData.getSuccess()) {
                        callback.onSuccess(guestData);
                        return;
                    } else {
                        callback.onFailure(guestData);
                        return;
                    }
                }
                if (iCode == 400) {
                    OneIDSession.this.getGuestHandler$OneID_release().setStashed(null, null);
                    OneIDSession.this.end(optionalConfigs, conversationId);
                    Tracker.DefaultImpls.finishEvent$default(OneIDSession.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    BaseGCResponse<JsonElement> baseGCResponseBody = response.body();
                    GCResponseError error = baseGCResponseBody != null ? baseGCResponseBody.getError() : null;
                    callback.onFailure(new GuestCallbackData(false, new OneIDError(String.valueOf(unconvertedResponse.code()), error != null ? error.getKeyErrorMessage() : null, null, 4, null), null, null, null, null, 60, null));
                    return;
                }
                OneIDSession.this.getGuestHandler$OneID_release().setStashed(null, null);
                OneIDSession.this.end(optionalConfigs, conversationId);
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, unconvertedResponse, "Failed to change password with GC"), null, null, null, null, 60, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onResponseFailure(@NotNull Response<?> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromResponseFailure(trackerEventKeyStartTransactionEvent$default, response, "Failed to validate OTP with GC"), null, null, null, null, 60, null));
            }

            @Override // com.disney.id.android.services.GCErrorHandlingAdapter.GCCallback
            public void onError(@NotNull Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                callback.onFailure(new GuestCallbackData(false, OneIDSession.this.buildErrorFromOnError(trackerEventKeyStartTransactionEvent$default, throwable, "Error validating OTP with GC"), null, null, null, null, 60, null));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OneIDError buildErrorFromOnError(TrackerEventKey trackerEventKey, Throwable throwable, String loggerMessage) {
        String str;
        String localizedMessage = throwable.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = throwable;
        }
        String str2 = StringsKt.contains$default((CharSequence) String.valueOf(localizedMessage), (CharSequence) "timeout", false, 2, (Object) null) ? "TIMED_OUT" : OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR;
        String localizedMessage2 = throwable.getLocalizedMessage();
        if (localizedMessage2 == null) {
            localizedMessage2 = throwable;
        }
        String str3 = (StringsKt.contains$default((CharSequence) String.valueOf(localizedMessage2), (CharSequence) "malformed JSON", false, 2, (Object) null) || (throwable instanceof JsonSyntaxException)) ? "INVALID_JSON" : OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE;
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, str3, str2, "throwable(" + throwable.getMessage() + ")", false, 32, null);
        if (loggerMessage != null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, loggerMessage, null, 4, null);
        }
        String localizedMessage3 = throwable.getLocalizedMessage();
        if (localizedMessage3 == null) {
            localizedMessage3 = throwable;
        }
        if (StringsKt.contains$default((CharSequence) String.valueOf(localizedMessage3), (CharSequence) "malformed JSON", false, 2, (Object) null) || (throwable instanceof JsonSyntaxException)) {
            str = "INVALID_JSON";
        } else {
            String localizedMessage4 = throwable.getLocalizedMessage();
            if (localizedMessage4 == null) {
                localizedMessage4 = throwable;
            }
            str = StringsKt.contains$default((CharSequence) String.valueOf(localizedMessage4), (CharSequence) "timeout", false, 2, (Object) null) ? "TIMED_OUT" : "UNKNOWN_ERROR";
        }
        return new OneIDError(str, throwable.getLocalizedMessage(), throwable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OneIDError buildErrorFromResponseFailure(TrackerEventKey trackerEventKey, Response response, String loggerMessage) {
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "httpstatus(" + response.code() + ")", false, 32, null);
        if (loggerMessage != null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, loggerMessage, null, 4, null);
        }
        return new OneIDError(String.valueOf(response.code()), response.message(), new Exception(String.valueOf(response.errorBody())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OneIDError buildErrorInvalidJson(TrackerEventKey trackerEventKey, Response response) {
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, true, "INVALID_JSON", OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "recovery data returned from GC caused an unexpected error", null, 4, null);
        return new OneIDError("UNKNOWN_ERROR", "Guest returned from GC caused an unexpected error", new Exception(response.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OneIDError buildErrorFromResponse(TrackerEventKey trackerEventKey, GCResponseError errorBody) {
        String keyErrorCode = errorBody.getKeyErrorCode();
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, keyErrorCode, errorBody.getKeyCategory(), null, false, 48, null);
        return new OneIDError(keyErrorCode, errorBody.getKeyErrorMessage(), new Exception(errorBody.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OneIDError handleGuestError(GCResponseError errorBody, TrackerEventKey trackerEventKey, OneIDCallback callback) {
        if (errorBody != null) {
            String keyErrorCode = errorBody.getKeyErrorCode();
            String keyCategory = errorBody.getKeyCategory();
            if (Intrinsics.areEqual(keyCategory, OneIDTrackerEvent.ERROR_CATEGORY_PPU_ACTIONABLE_INPUT)) {
                return new OneIDError(keyErrorCode, keyCategory, new Exception(errorBody.toString()));
            }
            callback.onFailure(new GuestCallbackData(false, buildErrorFromResponse(trackerEventKey, errorBody), null, null, null, null, 60, null));
        }
        return null;
    }
}
