package com.disney.id.android;

import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.localdata.LocalStorage;
import com.urbanairship.channel.AttributeMutation;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/disney/id/android/SWIDController;", "Lcom/disney/id/android/SWID;", "()V", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swid", "", "forceStore", "", "get", "reset", AttributeMutation.ATTRIBUTE_ACTION_SET, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SWIDController implements SWID {

    @Inject
    public LocalStorage storage;
    private String swid;

    public SWIDController() {
        OneIDDagger.getComponent().inject(this);
        String str = getStorage$OneID_release().get("com.oneid.swid");
        if (str != null) {
            this.swid = str;
        } else {
            reset();
        }
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    @Override // com.disney.id.android.SWID
    @NotNull
    public String get() {
        String str = this.swid;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    @Override // com.disney.id.android.SWID
    public void set(@NotNull String swid) {
        Intrinsics.checkNotNullParameter(swid, "swid");
        this.swid = swid;
    }

    @Override // com.disney.id.android.SWID
    public void forceStore() {
        LocalStorage storage$OneID_release = getStorage$OneID_release();
        String str = this.swid;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swid");
            str = null;
        }
        storage$OneID_release.put("com.oneid.swid", str);
    }

    @Override // com.disney.id.android.SWID
    public void reset() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.swid = string;
        forceStore();
    }
}
