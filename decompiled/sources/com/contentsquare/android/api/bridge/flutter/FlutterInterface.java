package com.contentsquare.android.api.bridge.flutter;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0681g0;
import com.contentsquare.android.sdk.C0691h0;
import com.contentsquare.android.sdk.C0714j3;
import com.contentsquare.android.sdk.K1;
import com.contentsquare.android.sdk.Q1;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FlutterInterface {

    @NonNull
    private static final String FLUTTER_VIEW = "FlutterView";
    private static final String PARSING_ERROR_MESSAGE = "Error while parsing %s";

    @VisibleForTesting
    static FlutterSrEventListener sSrListener;

    @NonNull
    private static final Logger LOGGER = new Logger("FlutterInterface");

    @NonNull
    @VisibleForTesting
    static BridgeEventProcessorNonStatic sBridgeEventProcessorNonStatic = new BridgeEventProcessorNonStatic();
    private static boolean sIsFirstFlutterEventAdded = false;

    @NonNull
    @VisibleForTesting
    static FlutterBridgeSrEventProcessor sFlutterBridgeSrEventProcessor = new FlutterBridgeSrEventProcessor();

    public static class BridgeEventProcessorNonStatic {
        public void process(@NonNull String str, @NonNull JSONObject jSONObject) {
            ContentsquareModule contentsquareModule;
            Activity activity;
            if (C0681g0.e == null) {
                C0681g0.e = new C0681g0();
            }
            C0681g0 c0681g0 = C0681g0.e;
            if ((c0681g0.c == null || !str.equals(c0681g0.b)) && (contentsquareModule = ContentsquareModule.getInstance()) != null && (activity = contentsquareModule.getLiveActivityProvider().a.get()) != null) {
                c0681g0.b = str;
                c0681g0.a(activity, str);
            }
            C0714j3 c0714j3 = c0681g0.c;
            if (c0714j3 != null) {
                c0681g0.a.b(C0691h0.a.a(jSONObject, c0714j3));
            }
        }
    }

    @SafeVarargs
    public static void excludeExternalView(@NonNull Class<? extends View>... clsArr) {
        Q1.b(clsArr);
    }

    public static boolean isFirstFlutterEventAdded() {
        return sIsFirstFlutterEventAdded;
    }

    public static void registerExternalView(@NonNull View view, @NonNull ExternalViewGraphListener externalViewGraphListener) {
        WeakHashMap<View, ExternalViewGraphListener> weakHashMap = K1.g;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(externalViewGraphListener, "externalViewGraphListener");
        K1.g.put(view, externalViewGraphListener);
    }

    public static void sendCrashReports(@NonNull List<byte[]> list) {
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        CoreModule coreModule = CoreModule.getInstance();
        ScreenViewTracker screenViewTracker = coreModule != null ? new ScreenViewTracker(coreModule.getPreferencesStore()) : null;
        if (csApplicationModule == null || screenViewTracker == null) {
            LOGGER.e("Unable to initialize flutter crash processor");
        } else {
            new FlutterCrashProcessor(new FlutterCrashBuilder(screenViewTracker, csApplicationModule)).process(list);
        }
    }

    public static void sendEvent(@NonNull String str) {
        LOGGER.d("sendEvent: " + str);
        try {
            sBridgeEventProcessorNonStatic.process(FLUTTER_VIEW, new JSONObject(str));
        } catch (JSONException e) {
            Q2.a(LOGGER, "Send event error while parsing " + str, e);
        }
    }

    public static void sendSessionReplayProtoDataList(@NonNull List<byte[]> list) {
        if (sSrListener == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (byte[] bArr : list) {
            try {
                arrayList.add(SessionRecordingV1.Event.parseFrom(bArr));
            } catch (InvalidProtocolBufferException e) {
                Q2.a(LOGGER, "Send error while parsing proto data at  index: " + list.indexOf(bArr), e);
            }
        }
        sFlutterBridgeSrEventProcessor.processProtoEvents(arrayList, sSrListener);
    }

    public static void setOnFlutterEventListener(FlutterSrEventListener flutterSrEventListener) {
        sSrListener = flutterSrEventListener;
    }

    public static void setsIsFirstFlutterEventAdded(boolean z) {
        sIsFirstFlutterEventAdded = z;
    }

    public static void unRegisterExternalView(@NonNull View view) {
        WeakHashMap<View, ExternalViewGraphListener> weakHashMap = K1.g;
        Intrinsics.checkNotNullParameter(view, "view");
        K1.g.remove(view);
    }
}
