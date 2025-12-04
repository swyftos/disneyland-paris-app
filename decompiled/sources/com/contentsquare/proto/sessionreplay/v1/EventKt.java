package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventKt {

    @NotNull
    public static final EventKt INSTANCE = new EventKt();

    @Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0007\u0018\u0000 ¼\u00012\u00020\u0001:\u0002¼\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0001J\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001J\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0090\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0091\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0092\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0093\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0094\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0095\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0096\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0097\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0098\u0001\u001a\u00030\u008e\u0001J\b\u0010\u0099\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009a\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009b\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009c\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009d\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009e\u0001\u001a\u00030\u008e\u0001J\b\u0010\u009f\u0001\u001a\u00030\u008e\u0001J\b\u0010 \u0001\u001a\u00030\u008e\u0001J\b\u0010¡\u0001\u001a\u00030\u008e\u0001J\b\u0010¢\u0001\u001a\u00030\u008e\u0001J\b\u0010£\u0001\u001a\u00030\u008e\u0001J\b\u0010¤\u0001\u001a\u00030\u008e\u0001J\b\u0010¥\u0001\u001a\u00030¦\u0001J\b\u0010§\u0001\u001a\u00030¦\u0001J\b\u0010¨\u0001\u001a\u00030¦\u0001J\b\u0010©\u0001\u001a\u00030¦\u0001J\b\u0010ª\u0001\u001a\u00030¦\u0001J\b\u0010«\u0001\u001a\u00030¦\u0001J\b\u0010¬\u0001\u001a\u00030¦\u0001J\b\u0010\u00ad\u0001\u001a\u00030¦\u0001J\b\u0010®\u0001\u001a\u00030¦\u0001J\b\u0010¯\u0001\u001a\u00030¦\u0001J\b\u0010°\u0001\u001a\u00030¦\u0001J\b\u0010±\u0001\u001a\u00030¦\u0001J\b\u0010²\u0001\u001a\u00030¦\u0001J\b\u0010³\u0001\u001a\u00030¦\u0001J\b\u0010´\u0001\u001a\u00030¦\u0001J\b\u0010µ\u0001\u001a\u00030¦\u0001J\b\u0010¶\u0001\u001a\u00030¦\u0001J\b\u0010·\u0001\u001a\u00030¦\u0001J\b\u0010¸\u0001\u001a\u00030¦\u0001J\b\u0010¹\u0001\u001a\u00030¦\u0001J\b\u0010º\u0001\u001a\u00030¦\u0001J\b\u0010»\u0001\u001a\u00030¦\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0011\u0010-\u001a\u00020.8G¢\u0006\u0006\u001a\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010\u0005\u001a\u0002018G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0002072\u0006\u0010\u0005\u001a\u0002078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u00020=2\u0006\u0010\u0005\u001a\u00020=8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020C8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010J\u001a\u00020I2\u0006\u0010\u0005\u001a\u00020I8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u00020O2\u0006\u0010\u0005\u001a\u00020O8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010V\u001a\u00020U2\u0006\u0010\u0005\u001a\u00020U8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u00020[2\u0006\u0010\u0005\u001a\u00020[8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010b\u001a\u00020a2\u0006\u0010\u0005\u001a\u00020a8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001a\u00020g2\u0006\u0010\u0005\u001a\u00020g8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u00020m2\u0006\u0010\u0005\u001a\u00020m8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010t\u001a\u00020s2\u0006\u0010\u0005\u001a\u00020s8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010z\u001a\u00020y2\u0006\u0010\u0005\u001a\u00020y8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R)\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010\u0005\u001a\u00020\u007f8G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R+\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0005\u001a\u00030\u0085\u00018G@GX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006½\u0001"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AppStateChange;", "appStateChange", "getAppStateChange", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AppStateChange;", "setAppStateChange", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AppStateChange;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHashes;", "assetHashes", "getAssetHashes", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHashes;", "setAssetHashes", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$AssetHashes;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "crash", "getCrash", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "setCrash", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "customError", "getCustomError", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;", "setCustomError", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$CustomError;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EndOfScreenView;", "endOfScreenView", "getEndOfScreenView", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EndOfScreenView;", "setEndOfScreenView", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EndOfScreenView;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Etr;", "etrScreen", "getEtrScreen", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Etr;", "setEtrScreen", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Etr;)V", "etrSession", "getEtrSession", "setEtrSession", "eventCase", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event$EventCase;", "getEventCase", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event$EventCase;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "gesture", "getGesture", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;", "setGesture", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Gesture;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "insertionMutation", "getInsertionMutation", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;", "setInsertionMutation", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$InsertionMutation;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;", "jsError", "getJsError", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;", "setJsError", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$JsError;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$MoveMutation;", "moveMutation", "getMoveMutation", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$MoveMutation;", "setMoveMutation", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$MoveMutation;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "networkRequestMetric", "getNetworkRequestMetric", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "setNetworkRequestMetric", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$OnlineAssets;", "onlineAssets", "getOnlineAssets", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$OnlineAssets;", "setOnlineAssets", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$OnlineAssets;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "qualitySettingsApplied", "getQualitySettingsApplied", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;", "setQualitySettingsApplied", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$QualitySettingsApplied;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;", "recordingStart", "getRecordingStart", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;", "setRecordingStart", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;", "recordingStop", "getRecordingStop", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;", "setRecordingStop", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStop;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RemovalMutation;", "removalMutation", "getRemovalMutation", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RemovalMutation;", "setRemovalMutation", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RemovalMutation;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ScreenView;", "screenView", "getScreenView", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ScreenView;", "setScreenView", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ScreenView;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "styleMutation", "getStyleMutation", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "setStyleMutation", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;", "touchGesture", "getTouchGesture", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;", "setTouchGesture", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$TouchGesture;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WebviewEvent;", "webviewEvent", "getWebviewEvent", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WebviewEvent;", "setWebviewEvent", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WebviewEvent;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WindowResize;", "windowResize", "getWindowResize", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WindowResize;", "setWindowResize", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$WindowResize;)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "clearAppStateChange", "", "clearAssetHashes", "clearCrash", "clearCustomError", "clearEndOfScreenView", "clearEtrScreen", "clearEtrSession", "clearEvent", "clearGesture", "clearInsertionMutation", "clearJsError", "clearMoveMutation", "clearNetworkRequestMetric", "clearOnlineAssets", "clearQualitySettingsApplied", "clearRecordingStart", "clearRecordingStop", "clearRemovalMutation", "clearScreenView", "clearStyleMutation", "clearTouchGesture", "clearWebviewEvent", "clearWindowResize", "hasAppStateChange", "", "hasAssetHashes", "hasCrash", "hasCustomError", "hasEndOfScreenView", "hasEtrScreen", "hasEtrSession", "hasGesture", "hasInsertionMutation", "hasJsError", "hasMoveMutation", "hasNetworkRequestMetric", "hasOnlineAssets", "hasQualitySettingsApplied", "hasRecordingStart", "hasRecordingStop", "hasRemovalMutation", "hasScreenView", "hasStyleMutation", "hasTouchGesture", "hasWebviewEvent", "hasWindowResize", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.Event.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/EventKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.Event.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.Event.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.Event _build() {
            SessionRecordingV1.Event eventBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(eventBuild, "_builder.build()");
            return eventBuild;
        }

        public final void clearAppStateChange() {
            this._builder.clearAppStateChange();
        }

        public final void clearAssetHashes() {
            this._builder.clearAssetHashes();
        }

        public final void clearCrash() {
            this._builder.clearCrash();
        }

        public final void clearCustomError() {
            this._builder.clearCustomError();
        }

        public final void clearEndOfScreenView() {
            this._builder.clearEndOfScreenView();
        }

        public final void clearEtrScreen() {
            this._builder.clearEtrScreen();
        }

        public final void clearEtrSession() {
            this._builder.clearEtrSession();
        }

        public final void clearEvent() {
            this._builder.clearEvent();
        }

        public final void clearGesture() {
            this._builder.clearGesture();
        }

        public final void clearInsertionMutation() {
            this._builder.clearInsertionMutation();
        }

        public final void clearJsError() {
            this._builder.clearJsError();
        }

        public final void clearMoveMutation() {
            this._builder.clearMoveMutation();
        }

        public final void clearNetworkRequestMetric() {
            this._builder.clearNetworkRequestMetric();
        }

        public final void clearOnlineAssets() {
            this._builder.clearOnlineAssets();
        }

        public final void clearQualitySettingsApplied() {
            this._builder.clearQualitySettingsApplied();
        }

        public final void clearRecordingStart() {
            this._builder.clearRecordingStart();
        }

        public final void clearRecordingStop() {
            this._builder.clearRecordingStop();
        }

        public final void clearRemovalMutation() {
            this._builder.clearRemovalMutation();
        }

        public final void clearScreenView() {
            this._builder.clearScreenView();
        }

        public final void clearStyleMutation() {
            this._builder.clearStyleMutation();
        }

        public final void clearTouchGesture() {
            this._builder.clearTouchGesture();
        }

        public final void clearWebviewEvent() {
            this._builder.clearWebviewEvent();
        }

        public final void clearWindowResize() {
            this._builder.clearWindowResize();
        }

        @JvmName(name = "getAppStateChange")
        @NotNull
        public final SessionRecordingV1.AppStateChange getAppStateChange() {
            SessionRecordingV1.AppStateChange appStateChange = this._builder.getAppStateChange();
            Intrinsics.checkNotNullExpressionValue(appStateChange, "_builder.getAppStateChange()");
            return appStateChange;
        }

        @JvmName(name = "getAssetHashes")
        @NotNull
        public final SessionRecordingV1.AssetHashes getAssetHashes() {
            SessionRecordingV1.AssetHashes assetHashes = this._builder.getAssetHashes();
            Intrinsics.checkNotNullExpressionValue(assetHashes, "_builder.getAssetHashes()");
            return assetHashes;
        }

        @JvmName(name = "getCrash")
        @NotNull
        public final SessionRecordingV1.Crash getCrash() {
            SessionRecordingV1.Crash crash = this._builder.getCrash();
            Intrinsics.checkNotNullExpressionValue(crash, "_builder.getCrash()");
            return crash;
        }

        @JvmName(name = "getCustomError")
        @NotNull
        public final SessionRecordingV1.CustomError getCustomError() {
            SessionRecordingV1.CustomError customError = this._builder.getCustomError();
            Intrinsics.checkNotNullExpressionValue(customError, "_builder.getCustomError()");
            return customError;
        }

        @JvmName(name = "getEndOfScreenView")
        @NotNull
        public final SessionRecordingV1.EndOfScreenView getEndOfScreenView() {
            SessionRecordingV1.EndOfScreenView endOfScreenView = this._builder.getEndOfScreenView();
            Intrinsics.checkNotNullExpressionValue(endOfScreenView, "_builder.getEndOfScreenView()");
            return endOfScreenView;
        }

        @JvmName(name = "getEtrScreen")
        @NotNull
        public final SessionRecordingV1.Etr getEtrScreen() {
            SessionRecordingV1.Etr etrScreen = this._builder.getEtrScreen();
            Intrinsics.checkNotNullExpressionValue(etrScreen, "_builder.getEtrScreen()");
            return etrScreen;
        }

        @JvmName(name = "getEtrSession")
        @NotNull
        public final SessionRecordingV1.Etr getEtrSession() {
            SessionRecordingV1.Etr etrSession = this._builder.getEtrSession();
            Intrinsics.checkNotNullExpressionValue(etrSession, "_builder.getEtrSession()");
            return etrSession;
        }

        @JvmName(name = "getEventCase")
        @NotNull
        public final SessionRecordingV1.Event.EventCase getEventCase() {
            SessionRecordingV1.Event.EventCase eventCase = this._builder.getEventCase();
            Intrinsics.checkNotNullExpressionValue(eventCase, "_builder.getEventCase()");
            return eventCase;
        }

        @JvmName(name = "getGesture")
        @NotNull
        public final SessionRecordingV1.Gesture getGesture() {
            SessionRecordingV1.Gesture gesture = this._builder.getGesture();
            Intrinsics.checkNotNullExpressionValue(gesture, "_builder.getGesture()");
            return gesture;
        }

        @JvmName(name = "getInsertionMutation")
        @NotNull
        public final SessionRecordingV1.InsertionMutation getInsertionMutation() {
            SessionRecordingV1.InsertionMutation insertionMutation = this._builder.getInsertionMutation();
            Intrinsics.checkNotNullExpressionValue(insertionMutation, "_builder.getInsertionMutation()");
            return insertionMutation;
        }

        @JvmName(name = "getJsError")
        @NotNull
        public final SessionRecordingV1.JsError getJsError() {
            SessionRecordingV1.JsError jsError = this._builder.getJsError();
            Intrinsics.checkNotNullExpressionValue(jsError, "_builder.getJsError()");
            return jsError;
        }

        @JvmName(name = "getMoveMutation")
        @NotNull
        public final SessionRecordingV1.MoveMutation getMoveMutation() {
            SessionRecordingV1.MoveMutation moveMutation = this._builder.getMoveMutation();
            Intrinsics.checkNotNullExpressionValue(moveMutation, "_builder.getMoveMutation()");
            return moveMutation;
        }

        @JvmName(name = "getNetworkRequestMetric")
        @NotNull
        public final SessionRecordingV1.NetworkRequestMetric getNetworkRequestMetric() {
            SessionRecordingV1.NetworkRequestMetric networkRequestMetric = this._builder.getNetworkRequestMetric();
            Intrinsics.checkNotNullExpressionValue(networkRequestMetric, "_builder.getNetworkRequestMetric()");
            return networkRequestMetric;
        }

        @JvmName(name = "getOnlineAssets")
        @NotNull
        public final SessionRecordingV1.OnlineAssets getOnlineAssets() {
            SessionRecordingV1.OnlineAssets onlineAssets = this._builder.getOnlineAssets();
            Intrinsics.checkNotNullExpressionValue(onlineAssets, "_builder.getOnlineAssets()");
            return onlineAssets;
        }

        @JvmName(name = "getQualitySettingsApplied")
        @NotNull
        public final SessionRecordingV1.QualitySettingsApplied getQualitySettingsApplied() {
            SessionRecordingV1.QualitySettingsApplied qualitySettingsApplied = this._builder.getQualitySettingsApplied();
            Intrinsics.checkNotNullExpressionValue(qualitySettingsApplied, "_builder.getQualitySettingsApplied()");
            return qualitySettingsApplied;
        }

        @JvmName(name = "getRecordingStart")
        @NotNull
        public final SessionRecordingV1.RecordingStart getRecordingStart() {
            SessionRecordingV1.RecordingStart recordingStart = this._builder.getRecordingStart();
            Intrinsics.checkNotNullExpressionValue(recordingStart, "_builder.getRecordingStart()");
            return recordingStart;
        }

        @JvmName(name = "getRecordingStop")
        @NotNull
        public final SessionRecordingV1.RecordingStop getRecordingStop() {
            SessionRecordingV1.RecordingStop recordingStop = this._builder.getRecordingStop();
            Intrinsics.checkNotNullExpressionValue(recordingStop, "_builder.getRecordingStop()");
            return recordingStop;
        }

        @JvmName(name = "getRemovalMutation")
        @NotNull
        public final SessionRecordingV1.RemovalMutation getRemovalMutation() {
            SessionRecordingV1.RemovalMutation removalMutation = this._builder.getRemovalMutation();
            Intrinsics.checkNotNullExpressionValue(removalMutation, "_builder.getRemovalMutation()");
            return removalMutation;
        }

        @JvmName(name = "getScreenView")
        @NotNull
        public final SessionRecordingV1.ScreenView getScreenView() {
            SessionRecordingV1.ScreenView screenView = this._builder.getScreenView();
            Intrinsics.checkNotNullExpressionValue(screenView, "_builder.getScreenView()");
            return screenView;
        }

        @JvmName(name = "getStyleMutation")
        @NotNull
        public final SessionRecordingV1.StyleMutation getStyleMutation() {
            SessionRecordingV1.StyleMutation styleMutation = this._builder.getStyleMutation();
            Intrinsics.checkNotNullExpressionValue(styleMutation, "_builder.getStyleMutation()");
            return styleMutation;
        }

        @JvmName(name = "getTouchGesture")
        @NotNull
        public final SessionRecordingV1.TouchGesture getTouchGesture() {
            SessionRecordingV1.TouchGesture touchGesture = this._builder.getTouchGesture();
            Intrinsics.checkNotNullExpressionValue(touchGesture, "_builder.getTouchGesture()");
            return touchGesture;
        }

        @JvmName(name = "getWebviewEvent")
        @NotNull
        public final SessionRecordingV1.WebviewEvent getWebviewEvent() {
            SessionRecordingV1.WebviewEvent webviewEvent = this._builder.getWebviewEvent();
            Intrinsics.checkNotNullExpressionValue(webviewEvent, "_builder.getWebviewEvent()");
            return webviewEvent;
        }

        @JvmName(name = "getWindowResize")
        @NotNull
        public final SessionRecordingV1.WindowResize getWindowResize() {
            SessionRecordingV1.WindowResize windowResize = this._builder.getWindowResize();
            Intrinsics.checkNotNullExpressionValue(windowResize, "_builder.getWindowResize()");
            return windowResize;
        }

        public final boolean hasAppStateChange() {
            return this._builder.hasAppStateChange();
        }

        public final boolean hasAssetHashes() {
            return this._builder.hasAssetHashes();
        }

        public final boolean hasCrash() {
            return this._builder.hasCrash();
        }

        public final boolean hasCustomError() {
            return this._builder.hasCustomError();
        }

        public final boolean hasEndOfScreenView() {
            return this._builder.hasEndOfScreenView();
        }

        public final boolean hasEtrScreen() {
            return this._builder.hasEtrScreen();
        }

        public final boolean hasEtrSession() {
            return this._builder.hasEtrSession();
        }

        public final boolean hasGesture() {
            return this._builder.hasGesture();
        }

        public final boolean hasInsertionMutation() {
            return this._builder.hasInsertionMutation();
        }

        public final boolean hasJsError() {
            return this._builder.hasJsError();
        }

        public final boolean hasMoveMutation() {
            return this._builder.hasMoveMutation();
        }

        public final boolean hasNetworkRequestMetric() {
            return this._builder.hasNetworkRequestMetric();
        }

        public final boolean hasOnlineAssets() {
            return this._builder.hasOnlineAssets();
        }

        public final boolean hasQualitySettingsApplied() {
            return this._builder.hasQualitySettingsApplied();
        }

        public final boolean hasRecordingStart() {
            return this._builder.hasRecordingStart();
        }

        public final boolean hasRecordingStop() {
            return this._builder.hasRecordingStop();
        }

        public final boolean hasRemovalMutation() {
            return this._builder.hasRemovalMutation();
        }

        public final boolean hasScreenView() {
            return this._builder.hasScreenView();
        }

        public final boolean hasStyleMutation() {
            return this._builder.hasStyleMutation();
        }

        public final boolean hasTouchGesture() {
            return this._builder.hasTouchGesture();
        }

        public final boolean hasWebviewEvent() {
            return this._builder.hasWebviewEvent();
        }

        public final boolean hasWindowResize() {
            return this._builder.hasWindowResize();
        }

        @JvmName(name = "setAppStateChange")
        public final void setAppStateChange(SessionRecordingV1.AppStateChange value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppStateChange(value);
        }

        @JvmName(name = "setAssetHashes")
        public final void setAssetHashes(SessionRecordingV1.AssetHashes value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAssetHashes(value);
        }

        @JvmName(name = "setCrash")
        public final void setCrash(SessionRecordingV1.Crash value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCrash(value);
        }

        @JvmName(name = "setCustomError")
        public final void setCustomError(SessionRecordingV1.CustomError value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCustomError(value);
        }

        @JvmName(name = "setEndOfScreenView")
        public final void setEndOfScreenView(SessionRecordingV1.EndOfScreenView value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEndOfScreenView(value);
        }

        @JvmName(name = "setEtrScreen")
        public final void setEtrScreen(SessionRecordingV1.Etr value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEtrScreen(value);
        }

        @JvmName(name = "setEtrSession")
        public final void setEtrSession(SessionRecordingV1.Etr value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEtrSession(value);
        }

        @JvmName(name = "setGesture")
        public final void setGesture(SessionRecordingV1.Gesture value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setGesture(value);
        }

        @JvmName(name = "setInsertionMutation")
        public final void setInsertionMutation(SessionRecordingV1.InsertionMutation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setInsertionMutation(value);
        }

        @JvmName(name = "setJsError")
        public final void setJsError(SessionRecordingV1.JsError value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setJsError(value);
        }

        @JvmName(name = "setMoveMutation")
        public final void setMoveMutation(SessionRecordingV1.MoveMutation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMoveMutation(value);
        }

        @JvmName(name = "setNetworkRequestMetric")
        public final void setNetworkRequestMetric(SessionRecordingV1.NetworkRequestMetric value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setNetworkRequestMetric(value);
        }

        @JvmName(name = "setOnlineAssets")
        public final void setOnlineAssets(SessionRecordingV1.OnlineAssets value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOnlineAssets(value);
        }

        @JvmName(name = "setQualitySettingsApplied")
        public final void setQualitySettingsApplied(SessionRecordingV1.QualitySettingsApplied value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setQualitySettingsApplied(value);
        }

        @JvmName(name = "setRecordingStart")
        public final void setRecordingStart(SessionRecordingV1.RecordingStart value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRecordingStart(value);
        }

        @JvmName(name = "setRecordingStop")
        public final void setRecordingStop(SessionRecordingV1.RecordingStop value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRecordingStop(value);
        }

        @JvmName(name = "setRemovalMutation")
        public final void setRemovalMutation(SessionRecordingV1.RemovalMutation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRemovalMutation(value);
        }

        @JvmName(name = "setScreenView")
        public final void setScreenView(SessionRecordingV1.ScreenView value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setScreenView(value);
        }

        @JvmName(name = "setStyleMutation")
        public final void setStyleMutation(SessionRecordingV1.StyleMutation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStyleMutation(value);
        }

        @JvmName(name = "setTouchGesture")
        public final void setTouchGesture(SessionRecordingV1.TouchGesture value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTouchGesture(value);
        }

        @JvmName(name = "setWebviewEvent")
        public final void setWebviewEvent(SessionRecordingV1.WebviewEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setWebviewEvent(value);
        }

        @JvmName(name = "setWindowResize")
        public final void setWindowResize(SessionRecordingV1.WindowResize value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setWindowResize(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.Event.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private EventKt() {
    }
}
