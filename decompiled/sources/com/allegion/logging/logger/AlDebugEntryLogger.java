package com.allegion.logging.logger;

import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.entry.IAlExceptionEntry;
import com.allegion.logging.entry.IAlExceptionLogEntry;
import com.allegion.logging.entry.IAlLogEntry;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/allegion/logging/logger/AlDebugEntryLogger;", "", "()V", "write", "", "entry", "Lcom/allegion/logging/entry/IAlExceptionEntry;", "Lcom/allegion/logging/entry/IAlExceptionLogEntry;", "Lcom/allegion/logging/entry/IAlLogEntry;", "writeEntry", "Lcom/allegion/logging/entry/IAlEntry;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlDebugEntryLogger {
    public static final AlDebugEntryLogger INSTANCE = new AlDebugEntryLogger();

    private AlDebugEntryLogger() {
    }

    @JvmStatic
    public static final void writeEntry(@NotNull IAlEntry entry) {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        if (entry instanceof IAlLogEntry) {
            INSTANCE.write((IAlLogEntry) entry);
        } else if (entry instanceof IAlExceptionLogEntry) {
            INSTANCE.write((IAlExceptionLogEntry) entry);
        } else if (entry instanceof IAlExceptionEntry) {
            INSTANCE.write((IAlExceptionEntry) entry);
        }
    }

    private final void write(IAlLogEntry entry) {
        String str = entry.getLevel() + '/' + entry.getCategory() + '/' + entry.getAction() + ": " + entry.getMessage();
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] args = entry.getArgs();
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
            System.out.println((Object) str2);
        } catch (MissingFormatArgumentException e) {
            System.out.println((Object) ('`' + str + "` is missing arguments!! " + e.getMessage()));
        }
    }

    private final void write(IAlExceptionEntry entry) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable exception = entry.getException();
        if (exception != null) {
            exception.printStackTrace(printWriter);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getLevel());
        sb.append('/');
        sb.append(entry.getCategory());
        sb.append('/');
        sb.append(entry.getAction());
        sb.append(": ");
        Throwable exception2 = entry.getException();
        sb.append(exception2 != null ? exception2.getMessage() : null);
        sb.append('\n');
        sb.append(stringWriter);
        System.out.println((Object) sb.toString());
    }

    private final void write(IAlExceptionLogEntry entry) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable exception = entry.getException();
        if (exception != null) {
            exception.printStackTrace(printWriter);
        }
        String str = entry.getLevel() + '/' + entry.getCategory() + '/' + entry.getAction() + ": " + entry.getMessage() + '\n' + stringWriter;
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] args = entry.getArgs();
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
            System.out.println((Object) str2);
        } catch (MissingFormatArgumentException e) {
            System.out.println((Object) ('`' + str + "` is missing arguments!! " + e.getMessage()));
        }
    }
}
