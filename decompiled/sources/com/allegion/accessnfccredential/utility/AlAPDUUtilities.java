package com.allegion.accessnfccredential.utility;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/allegion/accessnfccredential/utility/AlAPDUUtilities;", "", "()V", "Companion", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlAPDUUtilities {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/allegion/accessnfccredential/utility/AlAPDUUtilities$Companion;", "", "()V", "hasHCESupport", "", "context", "Landroid/content/Context;", "hasNFCTurnedOn", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean hasHCESupport(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
        }

        public final boolean hasNFCTurnedOn(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Object systemService = context.getSystemService("nfc");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.nfc.NfcManager");
            }
            NfcAdapter defaultAdapter = ((NfcManager) systemService).getDefaultAdapter();
            return defaultAdapter != null && defaultAdapter.isEnabled();
        }
    }
}
