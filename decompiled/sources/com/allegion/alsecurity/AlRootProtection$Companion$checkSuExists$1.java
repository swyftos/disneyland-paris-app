package com.allegion.alsecurity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"canExecuteCommand", "", "command", "", "invoke"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class AlRootProtection$Companion$checkSuExists$1 extends Lambda implements Function1<String, Boolean> {
    public static final AlRootProtection$Companion$checkSuExists$1 INSTANCE = new AlRootProtection$Companion$checkSuExists$1();

    AlRootProtection$Companion$checkSuExists$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke2(str));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
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
        }
        process.destroy();
        return z;
    }
}
