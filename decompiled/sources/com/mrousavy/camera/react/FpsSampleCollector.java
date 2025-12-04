package com.mrousavy.camera.react;

import androidx.camera.video.AudioStats;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/mrousavy/camera/react/FpsSampleCollector;", "", "callback", "Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "<init>", "(Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;)V", "getCallback", "()Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "timestamps", "", "", "timer", "Ljava/util/Timer;", ViewProps.START, "", "stop", "onTick", "averageFps", "", "getAverageFps", "()D", "Callback", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFpsSampleCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FpsSampleCollector.kt\ncom/mrousavy/camera/react/FpsSampleCollector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,48:1\n774#2:49\n865#2,2:50\n*S KotlinDebug\n*F\n+ 1 FpsSampleCollector.kt\ncom/mrousavy/camera/react/FpsSampleCollector\n*L\n27#1:49\n27#1:50,2\n*E\n"})
/* loaded from: classes4.dex */
public final class FpsSampleCollector {
    private final Callback callback;
    private Timer timer;
    private List timestamps;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "", "onAverageFpsChanged", "", "averageFps", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Callback {
        void onAverageFpsChanged(double averageFps);
    }

    public FpsSampleCollector(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.timestamps = new ArrayList();
    }

    @NotNull
    public final Callback getCallback() {
        return this.callback;
    }

    public final void start() {
        Timer timer = new Timer("VisionCamera FPS Sample Collector");
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.mrousavy.camera.react.FpsSampleCollector$start$$inlined$schedule$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.getCallback().onAverageFpsChanged(this.this$0.getAverageFps());
            }
        }, 1000L, 1000L);
    }

    public final void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    public final void onTick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.timestamps.add(Long.valueOf(jCurrentTimeMillis));
        List list = this.timestamps;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (jCurrentTimeMillis - ((Number) obj).longValue() < 1000) {
                arrayList.add(obj);
            }
        }
        this.timestamps = CollectionsKt.toMutableList((Collection) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getAverageFps() {
        return (((Long) CollectionsKt.firstOrNull(this.timestamps)) == null || ((Long) CollectionsKt.lastOrNull(this.timestamps)) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : 1000.0d / ((r1.longValue() - r0.longValue()) / (this.timestamps.size() - 1));
    }
}
