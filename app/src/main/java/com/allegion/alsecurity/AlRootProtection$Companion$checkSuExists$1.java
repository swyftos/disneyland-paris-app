package com.allegion.alsecurity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m1836d2 = {"canExecuteCommand", "", "command", "", "invoke"}, m1837k = 3, m1838mv = {1, 1, 15})
final class AlRootProtection$Companion$checkSuExists$1 extends Lambda implements Function1<String, Boolean> {
    public static final AlRootProtection$Companion$checkSuExists$1 INSTANCE = new AlRootProtection$Companion$checkSuExists$1();

    AlRootProtection$Companion$checkSuExists$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(@NotNull String command) {
        Intrinsics.checkParameterIsNotNull(command, "command");
        boolean z = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            Intrinsics.checkExpressionValueIsNotNull(process, "process");
            if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null) {
                z = true;
            }
        } catch (Throwable unused) {
            if (process != null) {
            }
            return z;
        }
        process.destroy();
        return z;
    }
}
