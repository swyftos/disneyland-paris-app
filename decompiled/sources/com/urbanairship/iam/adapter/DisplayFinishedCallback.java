package com.urbanairship.iam.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.UALog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/iam/adapter/DisplayFinishedCallback;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "(Ljava/lang/String;)V", "isValid", "", "()Z", "setValid", "(Z)V", "describeContents", "", "finished", "", "result", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "writeToParcel", "dest", "flags", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayFinishedCallback implements Parcelable {
    private final String id;
    private boolean isValid;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Map cached = new LinkedHashMap();

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DisplayFinishedCallback> CREATOR = new Parcelable.Creator<DisplayFinishedCallback>() { // from class: com.urbanairship.iam.adapter.DisplayFinishedCallback$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisplayFinishedCallback createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisplayFinishedCallback(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisplayFinishedCallback[] newArray(int size) {
            return new DisplayFinishedCallback[size];
        }
    };

    public /* synthetic */ DisplayFinishedCallback(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public /* synthetic */ DisplayFinishedCallback(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DisplayFinishedCallback(String str) {
        this.id = str;
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            boolean z = cached.get(str) != null;
            reentrantLock.unlock();
            this.isValid = z;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: isValid, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    public final void setValid(boolean z) {
        this.isValid = z;
    }

    public final void finished(@NotNull CustomDisplayResolution result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            Map map = cached;
            Function1 function1 = (Function1) map.get(this.id);
            TypeIntrinsics.asMutableMap(map).remove(this.id);
            if (function1 == null) {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.adapter.DisplayFinishedCallback.finished.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to process result. Either the app was killed, the callback was called multiple times, or its being called on a different process.";
                    }
                }, 1, null);
            } else {
                function1.invoke(result);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private DisplayFinishedCallback(Parcel parcel) {
        this(parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0000¢\u0006\u0002\b\u0010R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/adapter/DisplayFinishedCallback$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/urbanairship/iam/adapter/DisplayFinishedCallback;", "cached", "", "", "Lkotlin/Function1;", "Lcom/urbanairship/iam/adapter/CustomDisplayResolution;", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "newCallback", "callback", "newCallback$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DisplayFinishedCallback newCallback$urbanairship_automation_release(@NotNull Function1<? super CustomDisplayResolution, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            ReentrantLock reentrantLock = DisplayFinishedCallback.lock;
            reentrantLock.lock();
            try {
                DisplayFinishedCallback.cached.put(string, callback);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                return new DisplayFinishedCallback(string, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }
}
