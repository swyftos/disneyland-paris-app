package com.urbanairship.iam.assets;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/assets/EmptyAirshipCachedAssets;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "()V", "cacheUri", "Landroid/net/Uri;", "remoteUrl", "", "describeContents", "", "getMediaSize", "Landroid/util/Size;", "isCached", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyAirshipCachedAssets implements AirshipCachedAssets {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    @Nullable
    public Uri cacheUri(@NotNull String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    public boolean isCached(@NotNull String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
    }

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    @NotNull
    public Size getMediaSize(@NotNull String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        return new Size(-1, -1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/iam/assets/EmptyAirshipCachedAssets$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/urbanairship/iam/assets/EmptyAirshipCachedAssets;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", TCEventPropertiesNames.TCP_SIZE, "", "(I)[Lcom/urbanairship/iam/assets/EmptyAirshipCachedAssets;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.urbanairship.iam.assets.EmptyAirshipCachedAssets$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<EmptyAirshipCachedAssets> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EmptyAirshipCachedAssets createFromParcel(@Nullable Parcel source) {
            return new EmptyAirshipCachedAssets();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EmptyAirshipCachedAssets[] newArray(int size) {
            return new EmptyAirshipCachedAssets[size];
        }
    }
}
