package com.urbanairship;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import java.util.List;

@Dao
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public abstract class PreferenceDataDao {
    @Query("DELETE FROM preferences WHERE (`_id` == :key)")
    public abstract void delete(@NonNull String str);

    @Query("DELETE FROM preferences")
    public abstract void deleteAll();

    @NonNull
    @Query("SELECT * FROM preferences")
    @Transaction
    public abstract List<PreferenceData> getPreferences();

    @NonNull
    @Query("SELECT _id FROM preferences")
    @Transaction
    public abstract List<String> queryKeys();

    @NonNull
    @Query("SELECT * FROM preferences WHERE (`_id` == :key)")
    @Transaction
    public abstract PreferenceData queryValue(@NonNull String str);

    @Insert(onConflict = 1)
    @Transaction
    public abstract void upsert(@NonNull PreferenceData preferenceData);
}
