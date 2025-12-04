package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes3.dex */
final class zzli implements ObjectEncoder {
    static final zzli zza = new zzli();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("status");
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(1);
        builder.withProperty(zzfaVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzfa zzfaVar2 = new zzfa();
        zzfaVar2.zza(2);
        builder2.withProperty(zzfaVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder(TCEventPropertiesNames.TCD_MODEL);
        zzfa zzfaVar3 = new zzfa();
        zzfaVar3.zza(3);
        builder3.withProperty(zzfaVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(TCEventPropertiesNames.TCD_LANGUAGE);
        zzfa zzfaVar4 = new zzfa();
        zzfaVar4.zza(4);
        builder4.withProperty(zzfaVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("segmentationRequest");
        zzfa zzfaVar5 = new zzfa();
        zzfaVar5.zza(5);
        builder5.withProperty(zzfaVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("segmentationResult");
        zzfa zzfaVar6 = new zzfa();
        zzfaVar6.zza(6);
        builder6.withProperty(zzfaVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("aggregatedSegmentations");
        zzfa zzfaVar7 = new zzfa();
        zzfaVar7.zza(7);
        builder7.withProperty(zzfaVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("durationMs");
        zzfa zzfaVar8 = new zzfa();
        zzfaVar8.zza(8);
        builder8.withProperty(zzfaVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("nativeSegmentationException");
        zzfa zzfaVar9 = new zzfa();
        zzfaVar9.zza(9);
        builder9.withProperty(zzfaVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("downloadErrorCodes");
        zzfa zzfaVar10 = new zzfa();
        zzfaVar10.zza(10);
        builder10.withProperty(zzfaVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("domain");
        zzfa zzfaVar11 = new zzfa();
        zzfaVar11.zza(11);
        builder11.withProperty(zzfaVar11.zzb()).build();
    }

    private zzli() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) {
        throw null;
    }
}
