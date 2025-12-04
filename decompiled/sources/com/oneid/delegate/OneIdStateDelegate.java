package com.oneid.delegate;

import com.disney.id.android.OneIDState;
import com.disney.id.android.OneIDStateCallback;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/oneid/delegate/OneIdStateDelegate;", "Lcom/disney/id/android/OneIDStateCallback;", "onReady", "Lkotlin/Function0;", "", "onFailure", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "stateChange", BluetoothManager.BLE_STATUS_PARAM, "Lcom/disney/id/android/OneIDState;", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OneIdStateDelegate implements OneIDStateCallback {
    private final Function0 onFailure;
    private final Function0 onReady;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OneIDState.values().length];
            try {
                iArr[OneIDState.Initializing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OneIDState.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OneIDState.Renewing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OneIDState.PermanentFailure.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OneIdStateDelegate(@NotNull Function0<Unit> onReady, @NotNull Function0<Unit> onFailure) {
        Intrinsics.checkNotNullParameter(onReady, "onReady");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.onReady = onReady;
        this.onFailure = onFailure;
    }

    @Override // com.disney.id.android.OneIDStateCallback
    public void stateChange(@NotNull OneIDState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.onReady.invoke();
            } else if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                this.onFailure.invoke();
            }
        }
    }
}
