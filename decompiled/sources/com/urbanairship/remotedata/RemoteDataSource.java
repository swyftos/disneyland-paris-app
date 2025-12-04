package com.urbanairship.remotedata;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataSource;", "", "(Ljava/lang/String;I)V", "APP", "CONTACT", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class RemoteDataSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RemoteDataSource[] $VALUES;
    public static final RemoteDataSource APP = new RemoteDataSource("APP", 0);
    public static final RemoteDataSource CONTACT = new RemoteDataSource("CONTACT", 1);

    private static final /* synthetic */ RemoteDataSource[] $values() {
        return new RemoteDataSource[]{APP, CONTACT};
    }

    @NotNull
    public static EnumEntries<RemoteDataSource> getEntries() {
        return $ENTRIES;
    }

    public static RemoteDataSource valueOf(String str) {
        return (RemoteDataSource) Enum.valueOf(RemoteDataSource.class, str);
    }

    public static RemoteDataSource[] values() {
        return (RemoteDataSource[]) $VALUES.clone();
    }

    private RemoteDataSource(String str, int i) {
    }

    static {
        RemoteDataSource[] remoteDataSourceArr$values = $values();
        $VALUES = remoteDataSourceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(remoteDataSourceArr$values);
    }
}
