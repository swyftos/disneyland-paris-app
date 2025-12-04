package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class K6 implements InterfaceC0628a7 {

    @NotNull
    public final J6 a;
    public boolean b;

    public K6(@NotNull J6 staticCollector) {
        Intrinsics.checkNotNullParameter(staticCollector, "staticCollector");
        this.a = staticCollector;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.b ? 1 : 2;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @Nullable
    public final Object b(@NotNull Continuation<? super JSONObject> continuation) {
        J6 j6 = this.a;
        j6.getClass();
        try {
            return new JSONObject(j6.e);
        } catch (JSONException e) {
            Q2.a(j6.f, "Failed to create json object: " + e.getCause(), e);
            return new JSONObject();
        }
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() throws ClassNotFoundException {
        int i;
        if (this.b) {
            return;
        }
        J6 j6 = this.a;
        C0632b1 c0632b1 = j6.c;
        c0632b1.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Map<String, Integer> map = c0632b1.c;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            ArrayList arrayList = new ArrayList(str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                int i3 = 97;
                if ('a' > cCharAt || cCharAt >= '{') {
                    i3 = 65;
                    if ('A' > cCharAt || cCharAt >= '[') {
                        arrayList.add(Character.valueOf(cCharAt));
                    } else {
                        i = cCharAt - '3';
                    }
                } else {
                    i = cCharAt - 'S';
                }
                cCharAt = (char) ((i % 26) + i3);
                arrayList.add(Character.valueOf(cCharAt));
            }
            linkedHashMap.put(CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null), entry.getValue());
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            try {
                c0632b1.a.loadClass((String) entry2.getKey());
                listCreateListBuilder.add(entry2.getValue());
                c0632b1.b.d("Class found in app: " + ((String) entry2.getKey()));
            } catch (ClassNotFoundException e) {
                c0632b1.b.d(e.getMessage());
            }
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        HashMap<String, Object> map2 = j6.e;
        map2.put("app_id", j6.a.getBuildInformation().getApplicationId());
        map2.put("app_name", j6.a.getBuildInformation().getApplicationName());
        map2.put("app_version", j6.a.getBuildInformation().getApplicationVersion());
        map2.put("app_build_version", Long.valueOf(j6.a.getBuildInformation().getApplicationVersionCode()));
        map2.put(OneIDTrackerEvent.EVENT_PARAM_SDK_VERSION, j6.a.getBuildInformation().getSdkVersion());
        map2.put("sdk_build_version", Integer.valueOf(j6.a.getBuildInformation().getSdkBuild()));
        map2.put("os_type", "Android");
        map2.put("os_version", j6.a.getDeviceOs());
        String deviceModel = j6.a.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "";
        }
        map2.put("device_model", deviceModel);
        String deviceManufacturer = j6.a.getDeviceManufacturer();
        map2.put("device_manufacturer", deviceManufacturer != null ? deviceManufacturer : "");
        map2.put("metadata.android_app_min_sdk_version", Integer.valueOf(j6.a.getBuildInformation().getMinSdkVersion()));
        map2.put("metadata.android_app_target_sdk_version", Integer.valueOf(j6.a.getBuildInformation().getTargetSdkVersion()));
        map2.put("metadata.android_app_compile_sdk_version", Integer.valueOf(j6.a.getBuildInformation().getCompileSdkVersion()));
        map2.put("metadata.android_app_gradle_version", ExtensionsKt.resourceStringByName(j6.d, "contentsquare_telemetry_gradle_version"));
        map2.put("metadata.android_app_agp_version", ExtensionsKt.resourceStringByName(j6.d, "contentsquare_telemetry_agp_version"));
        map2.put("metadata.android_app_kotlin_version", j6.a.getBuildInformation().getAppKotlinVersion());
        JsonConfig.ProjectConfiguration projectConfiguration = j6.b;
        map2.put("bucket", Integer.valueOf(projectConfiguration != null ? projectConfiguration.getBucketSize() : -1));
        Lazy lazy = M.a;
        map2.put("start_mode", M.a(j6.d) ? "autostart" : "manual");
        map2.put("env", listBuild);
        map2.put("is_unified_sdk_present", Boolean.valueOf(listBuild.contains(13)));
        map2.put("is_heap_integration_present", Boolean.valueOf(listBuild.contains(14)));
        map2.put("is_heap_sdk_present", Boolean.valueOf(listBuild.contains(15)));
        map2.put("is_cs_started", Boolean.valueOf(ContentsquareModule.getInstance() != null));
        this.b = true;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @Nullable
    public final Object a(@NotNull Continuation<? super Unit> continuation) {
        this.b = false;
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return EnumC0690h.STATIC;
    }
}
