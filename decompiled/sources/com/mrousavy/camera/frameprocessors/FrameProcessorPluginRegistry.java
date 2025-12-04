package com.mrousavy.camera.frameprocessors;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.HashMap;
import java.util.Map;

@DoNotStrip
@Keep
/* loaded from: classes4.dex */
public class FrameProcessorPluginRegistry {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<String, PluginInitializer> Plugins = new HashMap();
    private static final String TAG = "FrameProcessorPluginRegistry";

    public interface PluginInitializer {
        @NonNull
        FrameProcessorPlugin initializePlugin(@NonNull VisionCameraProxy visionCameraProxy, @Nullable Map<String, Object> map);
    }

    @DoNotStrip
    @Keep
    public static void addFrameProcessorPlugin(String str, PluginInitializer pluginInitializer) {
        Plugins.put(str, pluginInitializer);
        Log.i(TAG, "Successfully registered Frame Processor Plugin \"" + str + "\"!");
    }

    @Nullable
    @DoNotStrip
    @Keep
    public static FrameProcessorPlugin getPlugin(String str, VisionCameraProxy visionCameraProxy, Map<String, Object> map) {
        Log.i(TAG, "Looking up Frame Processor Plugin \"" + str + "\"...");
        PluginInitializer pluginInitializer = Plugins.get(str);
        if (pluginInitializer == null) {
            Log.i(TAG, "Frame Processor Plugin \"" + str + "\" does not exist!");
            return null;
        }
        Log.i(TAG, "Frame Processor Plugin \"" + str + "\" found! Initializing...");
        return pluginInitializer.initializePlugin(visionCameraProxy, map);
    }
}
