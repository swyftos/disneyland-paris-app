package com.allegion.analytics;

import androidx.core.util.Pair;
import com.allegion.altranslation.AlJsonKt;
import com.allegion.analytics.tracker.AlAppCenterEventTracker;
import com.allegion.logging.AlLog;
import com.allegion.logging.AlLogging;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.event.AlEventType;
import com.allegion.logging.event.IAlActionEvent;
import com.allegion.logging.event.IAlCustomEvent;
import com.allegion.logging.property.AlPropertyKt;
import com.microsoft.appcenter.analytics.Analytics;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0001¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/allegion/analytics/AlAppCenterAnalyticsLogger;", "", "()V", "write", "", "event", "Lcom/allegion/logging/event/IAlActionEvent;", "Lcom/allegion/logging/event/IAlCustomEvent;", "writeEntry", "Lcom/allegion/logging/entry/IAlEntry;", "writeEntry$Analytics_release", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAppCenterAnalyticsLogger {
    public static final AlAppCenterAnalyticsLogger INSTANCE = new AlAppCenterAnalyticsLogger();

    private AlAppCenterAnalyticsLogger() {
    }

    @JvmStatic
    public static final void writeEntry$Analytics_release(@NotNull IAlEntry event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof IAlActionEvent) {
            INSTANCE.write((IAlActionEvent) event);
        } else if (event instanceof IAlCustomEvent) {
            INSTANCE.write((IAlCustomEvent) event);
        }
    }

    private final void write(IAlActionEvent event) {
        String str;
        String json;
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String action = event.getAction();
            Object[] args = event.getArgs();
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            str = String.format(action, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
        } catch (MissingFormatArgumentException e) {
            String action2 = event.getAction();
            AlLog.e("Event: `%s` contains missing arguments!! %s", action2, e.getMessage());
            str = action2;
        }
        Map<String, Serializable> mapConsolidate = AlPropertyKt.consolidate(AlLogging.getProperties(), event);
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Action Type", event.getType().toString()));
        for (Map.Entry<String, Serializable> entry : mapConsolidate.entrySet()) {
            String key = entry.getKey();
            Serializable value = entry.getValue();
            if (value instanceof String) {
                json = (String) value;
            } else {
                json = AlJsonKt.toJson(value);
            }
            mapMutableMapOf.put(key, json);
        }
        Analytics.trackEvent(event.getCategory() + ' ' + str, (Map<String, String>) mapMutableMapOf);
    }

    private final void write(IAlCustomEvent event) {
        String json;
        String json2;
        Map<String, Serializable> mapConsolidate = AlPropertyKt.consolidate(AlLogging.getProperties(), event);
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Event Type", event.getType().toString()));
        if (event.getType() == AlEventType.SUCCESS) {
            mapMutableMapOf.put(AlAppCenterEventTracker.APPCENTER_PROPERTY_SUCCESSFUL, AlAppCenterEventTracker.APPCENTER_PROPERTY_SUCCESSFUL_TRUE);
        } else if (event.getType() == AlEventType.FAILURE) {
            mapMutableMapOf.put(AlAppCenterEventTracker.APPCENTER_PROPERTY_SUCCESSFUL, AlAppCenterEventTracker.APPCENTER_PROPERTY_SUCCESSFUL_FALSE);
        }
        for (Map.Entry<String, Serializable> entry : mapConsolidate.entrySet()) {
            String key = entry.getKey();
            Serializable value = entry.getValue();
            if (value instanceof String) {
                json2 = (String) value;
            } else {
                json2 = AlJsonKt.toJson(value);
            }
            mapMutableMapOf.put(key, json2);
        }
        for (Pair<String, Object> pair : event.getProperties()) {
            String str = pair.first;
            if (str == null) {
                return;
            }
            if (str == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "it.first!!");
            Object obj = pair.second;
            if (obj instanceof String) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                json = (String) obj;
            } else {
                json = AlJsonKt.toJson(obj);
            }
            mapMutableMapOf.put(str, json);
        }
        Analytics.trackEvent(event.getCategory() + ' ' + event.getAction(), (Map<String, String>) mapMutableMapOf);
    }
}
