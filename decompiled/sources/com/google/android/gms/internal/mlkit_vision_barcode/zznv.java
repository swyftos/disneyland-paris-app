package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;

/* loaded from: classes3.dex */
final class zznv implements ObjectEncoder {
    static final zznv zza = new zznv();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(3);
        builder.withProperty(zzfaVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzfa zzfaVar2 = new zzfa();
        zzfaVar2.zza(4);
        builder2.withProperty(zzfaVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        zzfa zzfaVar3 = new zzfa();
        zzfaVar3.zza(5);
        builder3.withProperty(zzfaVar3.zzb()).build();
    }

    private zznv() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) {
        throw null;
    }
}
