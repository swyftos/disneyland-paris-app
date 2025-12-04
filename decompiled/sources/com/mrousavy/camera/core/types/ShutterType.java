package com.mrousavy.camera.core.types;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/types/ShutterType;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "PHOTO", "SNAPSHOT", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShutterType implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShutterType[] $VALUES;
    public static final ShutterType PHOTO = new ShutterType("PHOTO", 0, "photo");
    public static final ShutterType SNAPSHOT = new ShutterType("SNAPSHOT", 1, "snapshot");
    private final String unionValue;

    private static final /* synthetic */ ShutterType[] $values() {
        return new ShutterType[]{PHOTO, SNAPSHOT};
    }

    @NotNull
    public static EnumEntries<ShutterType> getEntries() {
        return $ENTRIES;
    }

    private ShutterType(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        ShutterType[] shutterTypeArr$values = $values();
        $VALUES = shutterTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shutterTypeArr$values);
    }

    public static ShutterType valueOf(String str) {
        return (ShutterType) Enum.valueOf(ShutterType.class, str);
    }

    public static ShutterType[] values() {
        return (ShutterType[]) $VALUES.clone();
    }
}
