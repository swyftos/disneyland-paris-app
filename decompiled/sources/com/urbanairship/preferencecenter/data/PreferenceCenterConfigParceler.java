package com.urbanairship.preferencecenter.data;

import android.os.Parcel;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfigParceler;", "Lkotlinx/parcelize/Parceler;", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreferenceCenterConfigParceler implements Parceler<PreferenceCenterConfig> {

    @NotNull
    public static final PreferenceCenterConfigParceler INSTANCE = new PreferenceCenterConfigParceler();

    private PreferenceCenterConfigParceler() {
    }

    @NotNull
    /* renamed from: newArray, reason: merged with bridge method [inline-methods] */
    public PreferenceCenterConfig[] m2931newArray(int i) {
        return (PreferenceCenterConfig[]) Parceler.DefaultImpls.newArray(this, i);
    }

    @NotNull
    /* renamed from: create, reason: merged with bridge method [inline-methods] */
    public PreferenceCenterConfig m2930create(@NotNull Parcel parcel) throws JsonException {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonMap jsonMapRequireMap = JsonValue.parseString(parcel.readString()).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        return PreferenceCenterConfig.INSTANCE.parse$urbanairship_preference_center_release(jsonMapRequireMap);
    }

    public void write(@NotNull PreferenceCenterConfig preferenceCenterConfig, @NotNull Parcel parcel, int i) throws JsonException {
        Intrinsics.checkNotNullParameter(preferenceCenterConfig, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(preferenceCenterConfig.toJson$urbanairship_preference_center_release().toString());
    }
}
