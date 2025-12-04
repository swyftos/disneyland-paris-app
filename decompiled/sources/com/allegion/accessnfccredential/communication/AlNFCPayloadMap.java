package com.allegion.accessnfccredential.communication;

import com.allegion.accessblecredential.communication.AlCBORMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086.¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlNFCPayloadMap;", "", "()V", AlCBORMessage.ENC_PAYLOAD, "", "getEncPayload", "()[B", "setEncPayload", "([B)V", AlCBORMessage.SIGNATURES, "", "Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "getSignatures", "()[Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "setSignatures", "([Lcom/allegion/accessnfccredential/communication/AlSignatureMap;)V", "[Lcom/allegion/accessnfccredential/communication/AlSignatureMap;", "tenantId", "getTenantId", "setTenantId", AlCBORMessage.TEMP_KEY, "getTmpKey", "setTmpKey", "isInitialized", "", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlNFCPayloadMap {

    @NotNull
    public byte[] encPayload;

    @NotNull
    public AlSignatureMap[] signatures;

    @NotNull
    public byte[] tenantId;

    @NotNull
    public byte[] tmpKey;

    @NotNull
    public final byte[] getTmpKey() {
        byte[] bArr = this.tmpKey;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.TEMP_KEY);
        }
        return bArr;
    }

    public final void setTmpKey(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.tmpKey = bArr;
    }

    @NotNull
    public final byte[] getEncPayload() {
        byte[] bArr = this.encPayload;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.ENC_PAYLOAD);
        }
        return bArr;
    }

    public final void setEncPayload(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.encPayload = bArr;
    }

    @NotNull
    public final AlSignatureMap[] getSignatures() {
        AlSignatureMap[] alSignatureMapArr = this.signatures;
        if (alSignatureMapArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AlCBORMessage.SIGNATURES);
        }
        return alSignatureMapArr;
    }

    public final void setSignatures(@NotNull AlSignatureMap[] alSignatureMapArr) {
        Intrinsics.checkParameterIsNotNull(alSignatureMapArr, "<set-?>");
        this.signatures = alSignatureMapArr;
    }

    @NotNull
    public final byte[] getTenantId() {
        byte[] bArr = this.tenantId;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tenantId");
        }
        return bArr;
    }

    public final void setTenantId(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.tenantId = bArr;
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.accessnfccredential.communication.AlNFCPayloadMap$isInitialized$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0 {
        AnonymousClass1(AlNFCPayloadMap alNFCPayloadMap) {
            super(alNFCPayloadMap);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return AlCBORMessage.TEMP_KEY;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlNFCPayloadMap.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getTmpKey()[B";
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return ((AlNFCPayloadMap) this.receiver).getTmpKey();
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object obj) {
            ((AlNFCPayloadMap) this.receiver).setTmpKey((byte[]) obj);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.accessnfccredential.communication.AlNFCPayloadMap$isInitialized$2, reason: invalid class name */
    final /* synthetic */ class AnonymousClass2 extends MutablePropertyReference0 {
        AnonymousClass2(AlNFCPayloadMap alNFCPayloadMap) {
            super(alNFCPayloadMap);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return AlCBORMessage.ENC_PAYLOAD;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlNFCPayloadMap.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getEncPayload()[B";
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return ((AlNFCPayloadMap) this.receiver).getEncPayload();
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object obj) {
            ((AlNFCPayloadMap) this.receiver).setEncPayload((byte[]) obj);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.accessnfccredential.communication.AlNFCPayloadMap$isInitialized$3, reason: invalid class name */
    final /* synthetic */ class AnonymousClass3 extends MutablePropertyReference0 {
        AnonymousClass3(AlNFCPayloadMap alNFCPayloadMap) {
            super(alNFCPayloadMap);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return AlCBORMessage.SIGNATURES;
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlNFCPayloadMap.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getSignatures()[Lcom/allegion/accessnfccredential/communication/AlSignatureMap;";
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return ((AlNFCPayloadMap) this.receiver).getSignatures();
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object obj) {
            ((AlNFCPayloadMap) this.receiver).setSignatures((AlSignatureMap[]) obj);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* renamed from: com.allegion.accessnfccredential.communication.AlNFCPayloadMap$isInitialized$4, reason: invalid class name */
    final /* synthetic */ class AnonymousClass4 extends MutablePropertyReference0 {
        AnonymousClass4(AlNFCPayloadMap alNFCPayloadMap) {
            super(alNFCPayloadMap);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "tenantId";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AlNFCPayloadMap.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getTenantId()[B";
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return ((AlNFCPayloadMap) this.receiver).getTenantId();
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object obj) {
            ((AlNFCPayloadMap) this.receiver).setTenantId((byte[]) obj);
        }
    }

    public final boolean isInitialized() {
        return (this.tmpKey == null || this.encPayload == null || this.signatures == null || this.tenantId == null) ? false : true;
    }
}
