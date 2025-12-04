package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000È\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010W\u001a\u00020X2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\0Z¢\u0006\u0002\b]H\u0087\bø\u0001\u0000¢\u0006\u0002\b^\u001a)\u0010_\u001a\u00020X*\u00020X2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\0Z¢\u0006\u0002\b]H\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0017\u0010\u001f\u001a\u0004\u0018\u00010 *\u00020\u00028F¢\u0006\u0006\u001a\u0004\b!\u0010\"\"\u0017\u0010#\u001a\u0004\u0018\u00010$*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0017\u0010'\u001a\u0004\u0018\u00010(*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0017\u0010+\u001a\u0004\u0018\u00010,*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0017\u0010/\u001a\u0004\u0018\u000100*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0017\u00103\u001a\u0004\u0018\u000104*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b5\u00106\"\u0017\u00107\u001a\u0004\u0018\u000108*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u0017\u0010;\u001a\u0004\u0018\u00010<*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0017\u0010?\u001a\u0004\u0018\u00010@*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bA\u0010B\"\u0017\u0010C\u001a\u0004\u0018\u00010D*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bE\u0010F\"\u0017\u0010G\u001a\u0004\u0018\u00010H*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bI\u0010J\"\u0017\u0010K\u001a\u0004\u0018\u00010L*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bM\u0010N\"\u0017\u0010O\u001a\u0004\u0018\u00010P*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bQ\u0010R\"\u0017\u0010S\u001a\u0004\u0018\u00010T*\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010V\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006`"}, d2 = {"appStateChangeOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AppStateChange;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;", "getAppStateChangeOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AppStateChange;", "assetHashesOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHashes;", "getAssetHashesOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHashes;", "crashOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "getCrashOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "customErrorOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "getCustomErrorOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "endOfScreenViewOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EndOfScreenView;", "getEndOfScreenViewOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EndOfScreenView;", "etrScreenOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Etr;", "getEtrScreenOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Etr;", "etrSessionOrNull", "getEtrSessionOrNull", "gestureOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "getGestureOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "insertionMutationOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "getInsertionMutationOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "jsErrorOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;", "getJsErrorOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;", "moveMutationOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$MoveMutation;", "getMoveMutationOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$MoveMutation;", "networkRequestMetricOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "getNetworkRequestMetricOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "onlineAssetsOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$OnlineAssets;", "getOnlineAssetsOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$OnlineAssets;", "qualitySettingsAppliedOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "getQualitySettingsAppliedOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "recordingStartOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;", "getRecordingStartOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;", "recordingStopOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;", "getRecordingStopOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;", "removalMutationOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RemovalMutation;", "getRemovalMutationOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RemovalMutation;", "screenViewOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ScreenView;", "getScreenViewOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ScreenView;", "styleMutationOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "getStyleMutationOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "touchGestureOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;", "getTouchGestureOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;", "webviewEventOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WebviewEvent;", "getWebviewEventOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WebviewEvent;", "windowResizeOrNull", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WindowResize;", "getWindowResizeOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventOrBuilder;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WindowResize;", "event", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/EventKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeevent", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,636:1\n1#2:637\n*E\n"})
/* loaded from: classes3.dex */
public final class EventKtKt {
    @JvmName(name = "-initializeevent")
    @NotNull
    /* renamed from: -initializeevent, reason: not valid java name */
    public static final SessionRecordingV1.Event m1285initializeevent(Function1<? super EventKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EventKt.Dsl.Companion companion = EventKt.Dsl.INSTANCE;
        SessionRecordingV1.Event.Builder builderNewBuilder = SessionRecordingV1.Event.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Event copy(SessionRecordingV1.Event event, Function1<? super EventKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EventKt.Dsl.Companion companion = EventKt.Dsl.INSTANCE;
        SessionRecordingV1.Event.Builder builder = event.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EventKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SessionRecordingV1.AppStateChange getAppStateChangeOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasAppStateChange()) {
            return eventOrBuilder.getAppStateChange();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.AssetHashes getAssetHashesOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasAssetHashes()) {
            return eventOrBuilder.getAssetHashes();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Crash getCrashOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasCrash()) {
            return eventOrBuilder.getCrash();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.CustomError getCustomErrorOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasCustomError()) {
            return eventOrBuilder.getCustomError();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.EndOfScreenView getEndOfScreenViewOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasEndOfScreenView()) {
            return eventOrBuilder.getEndOfScreenView();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Etr getEtrScreenOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasEtrScreen()) {
            return eventOrBuilder.getEtrScreen();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Etr getEtrSessionOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasEtrSession()) {
            return eventOrBuilder.getEtrSession();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.Gesture getGestureOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasGesture()) {
            return eventOrBuilder.getGesture();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.InsertionMutation getInsertionMutationOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasInsertionMutation()) {
            return eventOrBuilder.getInsertionMutation();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.JsError getJsErrorOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasJsError()) {
            return eventOrBuilder.getJsError();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.MoveMutation getMoveMutationOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasMoveMutation()) {
            return eventOrBuilder.getMoveMutation();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.NetworkRequestMetric getNetworkRequestMetricOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasNetworkRequestMetric()) {
            return eventOrBuilder.getNetworkRequestMetric();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.OnlineAssets getOnlineAssetsOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasOnlineAssets()) {
            return eventOrBuilder.getOnlineAssets();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.QualitySettingsApplied getQualitySettingsAppliedOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasQualitySettingsApplied()) {
            return eventOrBuilder.getQualitySettingsApplied();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.RecordingStart getRecordingStartOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasRecordingStart()) {
            return eventOrBuilder.getRecordingStart();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.RecordingStop getRecordingStopOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasRecordingStop()) {
            return eventOrBuilder.getRecordingStop();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.RemovalMutation getRemovalMutationOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasRemovalMutation()) {
            return eventOrBuilder.getRemovalMutation();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.ScreenView getScreenViewOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasScreenView()) {
            return eventOrBuilder.getScreenView();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.StyleMutation getStyleMutationOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasStyleMutation()) {
            return eventOrBuilder.getStyleMutation();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.TouchGesture getTouchGestureOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasTouchGesture()) {
            return eventOrBuilder.getTouchGesture();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.WebviewEvent getWebviewEventOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasWebviewEvent()) {
            return eventOrBuilder.getWebviewEvent();
        }
        return null;
    }

    @Nullable
    public static final SessionRecordingV1.WindowResize getWindowResizeOrNull(SessionRecordingV1.EventOrBuilder eventOrBuilder) {
        Intrinsics.checkNotNullParameter(eventOrBuilder, "<this>");
        if (eventOrBuilder.hasWindowResize()) {
            return eventOrBuilder.getWindowResize();
        }
        return null;
    }
}
