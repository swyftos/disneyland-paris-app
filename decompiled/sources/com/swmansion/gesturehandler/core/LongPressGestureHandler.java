package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.eventbuilders.LongPressGestureHandlerEventDataBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 H\u0014J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0014J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020\u001cH\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "minDurationMs", "", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", TypedValues.TransitionType.S_DURATION, "", "getDuration", "()I", "defaultMaxDist", "", "maxDist", "numberOfPointersRequired", "startX", "startY", "startTime", "previousTime", "handler", "Landroid/os/Handler;", "currentPointers", "resetConfig", "", "getAverageCoords", "Lkotlin/Pair;", "ev", "Landroid/view/MotionEvent;", "excludePointer", "", "onHandle", "event", "sourceEvent", "onStateChange", "newState", "previousState", "dispatchStateChange", "prevState", "dispatchHandlerUpdate", "onReset", "Factory", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLongPressGestureHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongPressGestureHandler.kt\ncom/swmansion/gesturehandler/core/LongPressGestureHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n1557#2:213\n1628#2,3:214\n1557#2:217\n1628#2,3:218\n*S KotlinDebug\n*F\n+ 1 LongPressGestureHandler.kt\ncom/swmansion/gesturehandler/core/LongPressGestureHandler\n*L\n44#1:213\n44#1:214,3\n45#1:217\n45#1:218,3\n*E\n"})
/* loaded from: classes4.dex */
public final class LongPressGestureHandler extends GestureHandler {
    private int currentPointers;
    private final float defaultMaxDist;
    private Handler handler;
    private float maxDist;
    private long minDurationMs;
    private int numberOfPointersRequired;
    private long previousTime;
    private long startTime;
    private float startX;
    private float startY;

    public LongPressGestureHandler(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.minDurationMs = 500L;
        setShouldCancelWhenOutside(true);
        float f = context.getResources().getDisplayMetrics().density * 10.0f;
        this.defaultMaxDist = f;
        this.maxDist = f;
        this.numberOfPointersRequired = 1;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final int getDuration() {
        return (int) (this.previousTime - this.startTime);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.minDurationMs = 500L;
        this.maxDist = this.defaultMaxDist;
        setShouldCancelWhenOutside(true);
    }

    static /* synthetic */ Pair getAverageCoords$default(LongPressGestureHandler longPressGestureHandler, MotionEvent motionEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return longPressGestureHandler.getAverageCoords(motionEvent, z);
    }

    private final Pair getAverageCoords(MotionEvent ev, boolean excludePointer) {
        if (!excludePointer) {
            IntRange intRangeUntil = RangesKt.until(0, ev.getPointerCount());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(ev.getX(((IntIterator) it).nextInt())));
            }
            float fAverageOfFloat = (float) CollectionsKt.averageOfFloat(arrayList);
            IntRange intRangeUntil2 = RangesKt.until(0, ev.getPointerCount());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it2 = intRangeUntil2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(ev.getY(((IntIterator) it2).nextInt())));
            }
            return new Pair(Float.valueOf(fAverageOfFloat), Float.valueOf((float) CollectionsKt.averageOfFloat(arrayList2)));
        }
        int pointerCount = ev.getPointerCount();
        float x = BitmapDescriptorFactory.HUE_RED;
        float y = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (i != ev.getActionIndex()) {
                x += ev.getX(i);
                y += ev.getY(i);
            }
        }
        return new Pair(Float.valueOf(x / (ev.getPointerCount() - 1)), Float.valueOf(y / (ev.getPointerCount() - 1)));
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(@NotNull MotionEvent event, @NotNull MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (getState() == 0) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.previousTime = jUptimeMillis;
                this.startTime = jUptimeMillis;
                begin();
                Pair averageCoords$default = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue = ((Number) averageCoords$default.component1()).floatValue();
                float fFloatValue2 = ((Number) averageCoords$default.component2()).floatValue();
                this.startX = fFloatValue;
                this.startY = fFloatValue2;
                this.currentPointers++;
            }
            if (sourceEvent.getActionMasked() == 5) {
                this.currentPointers++;
                Pair averageCoords$default2 = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue3 = ((Number) averageCoords$default2.component1()).floatValue();
                float fFloatValue4 = ((Number) averageCoords$default2.component2()).floatValue();
                this.startX = fFloatValue3;
                this.startY = fFloatValue4;
                if (this.currentPointers > this.numberOfPointersRequired) {
                    fail();
                    this.currentPointers = 0;
                }
            }
            if (getState() == 2 && this.currentPointers == this.numberOfPointersRequired && (sourceEvent.getActionMasked() == 0 || sourceEvent.getActionMasked() == 5)) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.handler = handler;
                long j = this.minDurationMs;
                if (j > 0) {
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(new Runnable() { // from class: com.swmansion.gesturehandler.core.LongPressGestureHandler$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.activate();
                        }
                    }, this.minDurationMs);
                } else if (j == 0) {
                    activate();
                }
            }
            if (sourceEvent.getActionMasked() == 1 || sourceEvent.getActionMasked() == 12) {
                this.currentPointers--;
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                    this.handler = null;
                }
                if (getState() == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (sourceEvent.getActionMasked() == 6) {
                int i = this.currentPointers - 1;
                this.currentPointers = i;
                if (i < this.numberOfPointersRequired && getState() != 4) {
                    fail();
                    this.currentPointers = 0;
                    return;
                }
                Pair averageCoords = getAverageCoords(sourceEvent, true);
                float fFloatValue5 = ((Number) averageCoords.component1()).floatValue();
                float fFloatValue6 = ((Number) averageCoords.component2()).floatValue();
                this.startX = fFloatValue5;
                this.startY = fFloatValue6;
                return;
            }
            Pair averageCoords$default3 = getAverageCoords$default(this, sourceEvent, false, 2, null);
            float fFloatValue7 = ((Number) averageCoords$default3.component1()).floatValue();
            float fFloatValue8 = ((Number) averageCoords$default3.component2()).floatValue();
            float f = fFloatValue7 - this.startX;
            float f2 = fFloatValue8 - this.startY;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.maxDist;
            if (f3 > f4 * f4) {
                if (getState() == 4) {
                    cancel();
                } else {
                    fail();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onStateChange(int newState, int previousState) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchStateChange(int newState, int prevState) {
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchStateChange(newState, prevState);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchHandlerUpdate(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchHandlerUpdate(event);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        super.onReset();
        this.currentPointers = 0;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/swmansion/gesturehandler/core/LongPressGestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/GestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "<init>", "()V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "create", "context", "Landroid/content/Context;", "setConfig", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/LongPressGestureHandlerEventDataBuilder;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory extends GestureHandler.Factory<LongPressGestureHandler> {
        private final Class type = LongPressGestureHandler.class;
        private final String name = "LongPressGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        @NotNull
        public Class<LongPressGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        @NotNull
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        @NotNull
        public LongPressGestureHandler create(@Nullable Context context) {
            Intrinsics.checkNotNull(context);
            return new LongPressGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(@NotNull LongPressGestureHandler handler, @NotNull ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig((Factory) handler, config);
            if (config.hasKey("minDurationMs")) {
                handler.setMinDurationMs(config.getInt("minDurationMs"));
            }
            if (config.hasKey("maxDist")) {
                handler.maxDist = PixelUtil.toPixelFromDIP(config.getDouble("maxDist"));
            }
            if (config.hasKey("numberOfPointers")) {
                handler.setNumberOfPointers(config.getInt("numberOfPointers"));
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        @NotNull
        public LongPressGestureHandlerEventDataBuilder createEventBuilder(@NotNull LongPressGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new LongPressGestureHandlerEventDataBuilder(handler);
        }
    }
}
