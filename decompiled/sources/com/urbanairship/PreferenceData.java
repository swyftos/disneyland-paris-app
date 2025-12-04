package com.urbanairship;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.urbanairship.preferencecenter.PreferenceCenter;

@Entity(tableName = PreferenceCenter.DEEP_LINK_HOST)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class PreferenceData {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "_id")
    protected String _id;

    @ColumnInfo(name = "value")
    protected String value;

    public PreferenceData(@NonNull String str, String str2) {
        this._id = str;
        this.value = str2;
    }

    @Ignore
    public String getKey() {
        return this._id;
    }

    @Ignore
    public String getValue() {
        return this.value;
    }
}
