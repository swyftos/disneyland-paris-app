package com.allegion.analytics;

import com.allegion.altranslation.AlJsonKt;
import com.allegion.logging.AlLog;
import com.allegion.logging.AlLogging;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.entry.IAlExceptionEntry;
import com.allegion.logging.entry.IAlExceptionLogEntry;
import com.allegion.logging.property.AlPropertyKt;
import com.microsoft.appcenter.crashes.Crashes;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/allegion/analytics/AlAppCenterExceptionLogger;", "", "()V", "write", "", "entry", "Lcom/allegion/logging/entry/IAlExceptionEntry;", "Lcom/allegion/logging/entry/IAlExceptionLogEntry;", "writeEntry", "event", "Lcom/allegion/logging/entry/IAlEntry;", "writeEntry$Analytics_release", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAppCenterExceptionLogger {
    public static final AlAppCenterExceptionLogger INSTANCE = new AlAppCenterExceptionLogger();

    private AlAppCenterExceptionLogger() {
    }

    @JvmStatic
    public static final void writeEntry$Analytics_release(@NotNull IAlEntry event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof IAlExceptionLogEntry) {
            INSTANCE.write((IAlExceptionLogEntry) event);
        } else if (event instanceof IAlExceptionEntry) {
            INSTANCE.write((IAlExceptionEntry) event);
        }
    }

    private final void write(IAlExceptionEntry entry) {
        String json;
        if (entry.getException() == null) {
            return;
        }
        Map<String, Serializable> mapConsolidate = AlPropertyKt.consolidate(AlLogging.getProperties(), entry);
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Log Level", entry.getLevel().toString()));
        for (Map.Entry<String, Serializable> entry2 : mapConsolidate.entrySet()) {
            String key = entry2.getKey();
            Serializable value = entry2.getValue();
            if (value instanceof String) {
                json = (String) value;
            } else {
                json = AlJsonKt.toJson(value);
            }
            mapMutableMapOf.put(key, json);
        }
        Throwable exception = entry.getException();
        if (exception == null) {
            Intrinsics.throwNpe();
        }
        Crashes.trackError(exception, mapMutableMapOf, null);
    }

    private final void write(IAlExceptionLogEntry entry) {
        String json;
        if (entry.getException() == null) {
            return;
        }
        String str = entry.getCategory() + " - " + entry.getAction() + ": " + entry.getMessage();
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] args = entry.getArgs();
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
            str = str2;
        } catch (MissingFormatArgumentException e) {
            AlLog.e("Entry: `%s` contains missing arguments!! %s", str, e.getMessage());
        }
        Map<String, Serializable> mapConsolidate = AlPropertyKt.consolidate(AlLogging.getProperties(), entry);
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Log Level", entry.getLevel().toString()), TuplesKt.to("Description", str));
        for (Map.Entry<String, Serializable> entry2 : mapConsolidate.entrySet()) {
            String key = entry2.getKey();
            Serializable value = entry2.getValue();
            if (value instanceof String) {
                json = (String) value;
            } else {
                json = AlJsonKt.toJson(value);
            }
            mapMutableMapOf.put(key, json);
        }
        Throwable exception = entry.getException();
        if (exception == null) {
            Intrinsics.throwNpe();
        }
        Crashes.trackError(exception, mapMutableMapOf, null);
    }
}
