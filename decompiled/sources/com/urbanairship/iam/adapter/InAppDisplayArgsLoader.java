package com.urbanairship.iam.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/iam/adapter/InAppDisplayArgsLoader;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "(Ljava/lang/String;)V", "describeContents", "", "dispose", "", "load", "Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "writeToParcel", "dest", "flags", "Companion", "LoadException", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppDisplayArgsLoader implements Parcelable {
    private final String id;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Map cached = new HashMap();

    @JvmField
    @NotNull
    public static final Parcelable.Creator<InAppDisplayArgsLoader> CREATOR = new Parcelable.Creator<InAppDisplayArgsLoader>() { // from class: com.urbanairship.iam.adapter.InAppDisplayArgsLoader$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppDisplayArgsLoader createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InAppDisplayArgsLoader(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppDisplayArgsLoader[] newArray(int size) {
            return new InAppDisplayArgsLoader[size];
        }
    };

    public /* synthetic */ InAppDisplayArgsLoader(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public /* synthetic */ InAppDisplayArgsLoader(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private InAppDisplayArgsLoader(String str) {
        this.id = str;
    }

    private InAppDisplayArgsLoader(Parcel parcel) {
        this(parcel.readString());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/iam/adapter/InAppDisplayArgsLoader$LoadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LoadException extends Exception {
        public LoadException(@Nullable String str) {
            super(str);
        }
    }

    @NotNull
    public final <T extends InAppMessageDisplayContent> InAppDisplayArgs<T> load() throws LoadException {
        Object obj = cached.get(this.id);
        InAppDisplayArgs<T> inAppDisplayArgs = obj instanceof InAppDisplayArgs ? (InAppDisplayArgs) obj : null;
        if (inAppDisplayArgs != null) {
            return inAppDisplayArgs;
        }
        throw new LoadException("In-app display args no longer available");
    }

    public final void dispose() {
        cached.remove(this.id);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u0005\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/adapter/InAppDisplayArgsLoader$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/urbanairship/iam/adapter/InAppDisplayArgsLoader;", "cached", "", "", "Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", "newLoader", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "args", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final <T extends InAppMessageDisplayContent> InAppDisplayArgsLoader newLoader(@NotNull InAppDisplayArgs<T> args) {
            Intrinsics.checkNotNullParameter(args, "args");
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            InAppDisplayArgsLoader.cached.put(string, args);
            return new InAppDisplayArgsLoader(string, (DefaultConstructorMarker) null);
        }
    }
}
