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
import com.contentsquare.android.sdk.C2538K1;
import com.contentsquare.android.sdk.C2598Q1;
import com.contentsquare.android.sdk.C2599Q2;
import com.contentsquare.android.sdk.C2751g0;
import com.contentsquare.android.sdk.C2761h0;
import com.contentsquare.android.sdk.C2784j3;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
            if (C2751g0.f2653e == null) {
                C2751g0.f2653e = new C2751g0();
            }
            C2751g0 c2751g0 = C2751g0.f2653e;
            if ((c2751g0.f2656c == null || !str.equals(c2751g0.f2655b)) && (contentsquareModule = ContentsquareModule.getInstance()) != null && (activity = contentsquareModule.getLiveActivityProvider().f1856a.get()) != null) {
                c2751g0.f2655b = str;
                c2751g0.m1138a(activity, str);
            }
            C2784j3 c2784j3 = c2751g0.f2656c;
            if (c2784j3 != null) {
                c2751g0.f2654a.m1120b(C2761h0.a.m1142a(jSONObject, c2784j3));
            }
        }
    }

    @SafeVarargs
    public static void excludeExternalView(@NonNull Class<? extends View>... clsArr) {
        C2598Q1.m1009b(clsArr);
    }

    public static boolean isFirstFlutterEventAdded() {
        return sIsFirstFlutterEventAdded;
    }

    public static void registerExternalView(@NonNull View view, @NonNull ExternalViewGraphListener externalViewGraphListener) {
        WeakHashMap<View, ExternalViewGraphListener> weakHashMap = C2538K1.f1771g;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(externalViewGraphListener, "externalViewGraphListener");
        C2538K1.f1771g.put(view, externalViewGraphListener);
    }

    public static void sendCrashReports(@NonNull List<byte[]> list) {
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        CoreModule coreModule = CoreModule.getInstance();
        ScreenViewTracker screenViewTracker = coreModule != null ? new ScreenViewTracker(coreModule.getPreferencesStore()) : null;
        if (csApplicationModule == null || screenViewTracker == null) {
            LOGGER.m829e("Unable to initialize flutter crash processor");
        } else {
            new FlutterCrashProcessor(new FlutterCrashBuilder(screenViewTracker, csApplicationModule)).process(list);
        }
    }

    public static void sendEvent(@NonNull String str) {
        LOGGER.m827d("sendEvent: " + str);
        try {
            sBridgeEventProcessorNonStatic.process(FLUTTER_VIEW, new JSONObject(str));
        } catch (JSONException e) {
            C2599Q2.m1011a(LOGGER, "Send event error while parsing " + str, e);
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
                C2599Q2.m1011a(LOGGER, "Send error while parsing proto data at  index: " + list.indexOf(bArr), e);
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
        WeakHashMap<View, ExternalViewGraphListener> weakHashMap = C2538K1.f1771g;
        Intrinsics.checkNotNullParameter(view, "view");
        C2538K1.f1771g.remove(view);
    }
}
