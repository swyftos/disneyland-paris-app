package com.allegion.logging.logger;

import com.allegion.altranslation.AlJsonKt;
import com.allegion.logging.AlLogging;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.event.IAlActionEvent;
import com.allegion.logging.event.IAlCustomEvent;
import com.allegion.logging.property.AlPropertyKt;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0001¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/allegion/logging/logger/AlDebugEventLogger;", "", "()V", "write", "", "entry", "Lcom/allegion/logging/event/IAlActionEvent;", "Lcom/allegion/logging/event/IAlCustomEvent;", "writeEntry", "Lcom/allegion/logging/entry/IAlEntry;", "writeEntry$AlLogging_release", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlDebugEventLogger {
    public static final AlDebugEventLogger INSTANCE = new AlDebugEventLogger();

    private AlDebugEventLogger() {
    }

    @JvmStatic
    public static final void writeEntry$AlLogging_release(@NotNull IAlEntry entry) {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        if (entry instanceof IAlActionEvent) {
            INSTANCE.write((IAlActionEvent) entry);
        } else if (entry instanceof IAlCustomEvent) {
            INSTANCE.write((IAlCustomEvent) entry);
        }
    }

    private final void write(IAlActionEvent entry) {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = AbstractJsonLexerKt.BEGIN_LIST + entry.getType() + ", " + entry.getCategory() + "]: " + entry.getAction();
            Object[] args = entry.getArgs();
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
            System.out.println((Object) str2);
        } catch (MissingFormatArgumentException e) {
            System.out.println((Object) ('`' + entry.getType() + ' ' + entry.getCategory() + ' ' + entry.getAction() + "` is missing arguments!! " + e.getMessage()));
        }
    }

    private final void write(IAlCustomEvent entry) {
        System.out.println((Object) (AbstractJsonLexerKt.BEGIN_LIST + entry.getType() + ", " + entry.getCategory() + "]: " + entry.getAction() + " \nproperties: " + AlJsonKt.toJson(entry.getProperties()) + " \nuserProperties: " + AlJsonKt.toJson(AlJsonKt.toJson(AlPropertyKt.consolidate(AlLogging.getProperties(), entry)))));
    }
}
