package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.features.srm.SrmKeysCache;
import java.util.LinkedHashSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.features.srm.SrmKeysCache$plusAssign$2", f = "SrmKeysCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class D6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ SrmKeysCache a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D6(SrmKeysCache srmKeysCache, Continuation<? super D6> continuation) {
        super(2, continuation);
        this.a = srmKeysCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new D6(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new D6(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        SrmKeysCache srmKeysCache = this.a;
        synchronized (srmKeysCache) {
            Json.Companion companion = Json.INSTANCE;
            LinkedHashSet linkedHashSet = srmKeysCache.d;
            companion.getSerializersModule();
            String strEncodeToString = companion.encodeToString(new LinkedHashSetSerializer(SrmKeysCache.Key.Companion.serializer()), linkedHashSet);
            srmKeysCache.a.mkdirs(srmKeysCache.e);
            srmKeysCache.a.writeBytesToFile(srmKeysCache.f, StringsKt.encodeToByteArray(strEncodeToString), false);
            srmKeysCache.i.d("Saved " + srmKeysCache.d.size() + " keys to disk.");
        }
        return Unit.INSTANCE;
    }
}
