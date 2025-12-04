package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.dlp.BluetoothManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        Data dataFromByteArray;
        long j;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
        int i2;
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, BluetoothManager.BLE_STATUS_PARAM);
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
            int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
            int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
            int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
            int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
            int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
            int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
            int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
            int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
            int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
            int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
            int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
            int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
            int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
            int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
            int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
            int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
            int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
            int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
            HashMap map = new HashMap();
            int i3 = columnIndex13;
            HashMap map2 = new HashMap();
            while (cursorQuery.moveToNext()) {
                int i4 = columnIndex12;
                String string = cursorQuery.getString(columnIndex);
                if (((ArrayList) map.get(string)) == null) {
                    i2 = columnIndex11;
                    map.put(string, new ArrayList());
                } else {
                    i2 = columnIndex11;
                }
                String string2 = cursorQuery.getString(columnIndex);
                if (((ArrayList) map2.get(string2)) == null) {
                    map2.put(string2, new ArrayList());
                }
                columnIndex12 = i4;
                columnIndex11 = i2;
            }
            int i5 = columnIndex11;
            int i6 = columnIndex12;
            int i7 = -1;
            cursorQuery.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(map);
            __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string3 = (columnIndex == i7 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                WorkInfo.State stateIntToState = columnIndex2 == i7 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                if (columnIndex3 == i7) {
                    dataFromByteArray = null;
                } else {
                    dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                }
                long j2 = columnIndex4 == i7 ? 0L : cursorQuery.getLong(columnIndex4);
                long j3 = columnIndex5 == i7 ? 0L : cursorQuery.getLong(columnIndex5);
                long j4 = columnIndex6 == i7 ? 0L : cursorQuery.getLong(columnIndex6);
                int i8 = columnIndex7 == i7 ? 0 : cursorQuery.getInt(columnIndex7);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == i7 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                long j5 = columnIndex9 == i7 ? 0L : cursorQuery.getLong(columnIndex9);
                if (columnIndex10 == i7) {
                    i = i5;
                    j = 0;
                } else {
                    j = cursorQuery.getLong(columnIndex10);
                    i = i5;
                }
                int i9 = i == i7 ? 0 : cursorQuery.getInt(i);
                int i10 = i6;
                int i11 = columnIndex2;
                int i12 = i10 == i7 ? 0 : cursorQuery.getInt(i10);
                int i13 = i3;
                long j6 = i13 == i7 ? 0L : cursorQuery.getLong(i13);
                int i14 = columnIndex14;
                int i15 = i14 == i7 ? 0 : cursorQuery.getInt(i14);
                int i16 = columnIndex15;
                NetworkType networkTypeIntToNetworkType = i16 == i7 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i16));
                int i17 = columnIndex16;
                if (i17 == i7) {
                    z = false;
                } else {
                    z = cursorQuery.getInt(i17) != 0;
                }
                int i18 = columnIndex17;
                if (i18 == i7) {
                    z2 = false;
                } else {
                    z2 = cursorQuery.getInt(i18) != 0;
                }
                int i19 = columnIndex18;
                if (i19 == i7) {
                    z3 = false;
                } else {
                    z3 = cursorQuery.getInt(i19) != 0;
                }
                int i20 = columnIndex19;
                if (i20 == i7) {
                    z4 = false;
                } else {
                    z4 = cursorQuery.getInt(i20) != 0;
                }
                int i21 = columnIndex20;
                long j7 = i21 == i7 ? 0L : cursorQuery.getLong(i21);
                int i22 = columnIndex21;
                long j8 = i22 != i7 ? cursorQuery.getLong(i22) : 0L;
                int i23 = columnIndex22;
                if (i23 == i7) {
                    setByteArrayToSetOfTriggers = null;
                } else {
                    setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i23) ? null : cursorQuery.getBlob(i23));
                }
                Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j7, j8, setByteArrayToSetOfTriggers);
                ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j2, j3, j4, constraints, i8, backoffPolicyIntToBackoffPolicy, j5, j, i9, i12, j6, i15, arrayList3, arrayList4));
                i5 = i;
                i7 = -1;
                i3 = i13;
                columnIndex14 = i14;
                columnIndex15 = i16;
                columnIndex16 = i17;
                columnIndex17 = i18;
                columnIndex18 = i19;
                columnIndex19 = i20;
                columnIndex20 = i21;
                columnIndex21 = i22;
                columnIndex22 = i23;
                columnIndex2 = i11;
                i6 = i10;
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.1
            @Override // java.util.concurrent.Callable
            public List call() {
                Data dataFromByteArray;
                long j;
                int i;
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i2;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, BluetoothManager.BLE_STATUS_PARAM);
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i3 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i4 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i2 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i2 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i4;
                        columnIndex11 = i2;
                    }
                    int i5 = columnIndex11;
                    int i6 = columnIndex12;
                    int i7 = -1;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == i7 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        WorkInfo.State stateIntToState = columnIndex2 == i7 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                        if (columnIndex3 == i7) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j2 = columnIndex4 == i7 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j3 = columnIndex5 == i7 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j4 = columnIndex6 == i7 ? 0L : cursorQuery.getLong(columnIndex6);
                        int i8 = columnIndex7 == i7 ? 0 : cursorQuery.getInt(columnIndex7);
                        BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == i7 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                        long j5 = columnIndex9 == i7 ? 0L : cursorQuery.getLong(columnIndex9);
                        if (columnIndex10 == i7) {
                            i = i5;
                            j = 0;
                        } else {
                            j = cursorQuery.getLong(columnIndex10);
                            i = i5;
                        }
                        int i9 = i == i7 ? 0 : cursorQuery.getInt(i);
                        int i10 = i6;
                        int i11 = columnIndex2;
                        int i12 = i10 == i7 ? 0 : cursorQuery.getInt(i10);
                        int i13 = i3;
                        long j6 = i13 == i7 ? 0L : cursorQuery.getLong(i13);
                        int i14 = columnIndex14;
                        int i15 = i14 == i7 ? 0 : cursorQuery.getInt(i14);
                        int i16 = columnIndex15;
                        NetworkType networkTypeIntToNetworkType = i16 == i7 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i16));
                        int i17 = columnIndex16;
                        if (i17 == i7) {
                            z = false;
                        } else {
                            z = cursorQuery.getInt(i17) != 0;
                        }
                        int i18 = columnIndex17;
                        if (i18 == i7) {
                            z2 = false;
                        } else {
                            z2 = cursorQuery.getInt(i18) != 0;
                        }
                        int i19 = columnIndex18;
                        if (i19 == i7) {
                            z3 = false;
                        } else {
                            z3 = cursorQuery.getInt(i19) != 0;
                        }
                        int i20 = columnIndex19;
                        if (i20 == i7) {
                            z4 = false;
                        } else {
                            z4 = cursorQuery.getInt(i20) != 0;
                        }
                        int i21 = columnIndex20;
                        long j7 = i21 == i7 ? 0L : cursorQuery.getLong(i21);
                        int i22 = columnIndex21;
                        long j8 = i22 != i7 ? cursorQuery.getLong(i22) : 0L;
                        int i23 = columnIndex22;
                        if (i23 == i7) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i23) ? null : cursorQuery.getBlob(i23));
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j7, j8, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j2, j3, j4, constraints, i8, backoffPolicyIntToBackoffPolicy, j5, j, i9, i12, j6, i15, arrayList3, arrayList4));
                        i5 = i;
                        i7 = -1;
                        columnIndex22 = i23;
                        columnIndex2 = i11;
                        i6 = i10;
                        i3 = i13;
                        columnIndex14 = i14;
                        columnIndex15 = i16;
                        columnIndex16 = i17;
                        columnIndex17 = i18;
                        columnIndex18 = i19;
                        columnIndex19 = i20;
                        columnIndex20 = i21;
                        columnIndex21 = i22;
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        });
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosFlow(final SupportSQLiteQuery supportSQLiteQuery) {
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new Callable() { // from class: androidx.work.impl.model.RawWorkInfoDao_Impl.2
            @Override // java.util.concurrent.Callable
            public List call() {
                Data dataFromByteArray;
                long j;
                int i;
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                Set<Constraints.ContentUriTrigger> setByteArrayToSetOfTriggers;
                int i2;
                Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.this.__db, supportSQLiteQuery, true, null);
                try {
                    int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "id");
                    int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, BluetoothManager.BLE_STATUS_PARAM);
                    int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                    int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "initial_delay");
                    int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "interval_duration");
                    int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "flex_duration");
                    int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                    int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "backoff_policy");
                    int columnIndex9 = CursorUtil.getColumnIndex(cursorQuery, "backoff_delay_duration");
                    int columnIndex10 = CursorUtil.getColumnIndex(cursorQuery, "last_enqueue_time");
                    int columnIndex11 = CursorUtil.getColumnIndex(cursorQuery, "period_count");
                    int columnIndex12 = CursorUtil.getColumnIndex(cursorQuery, "generation");
                    int columnIndex13 = CursorUtil.getColumnIndex(cursorQuery, "next_schedule_time_override");
                    int columnIndex14 = CursorUtil.getColumnIndex(cursorQuery, DownloadService.KEY_STOP_REASON);
                    int columnIndex15 = CursorUtil.getColumnIndex(cursorQuery, "required_network_type");
                    int columnIndex16 = CursorUtil.getColumnIndex(cursorQuery, "requires_charging");
                    int columnIndex17 = CursorUtil.getColumnIndex(cursorQuery, "requires_device_idle");
                    int columnIndex18 = CursorUtil.getColumnIndex(cursorQuery, "requires_battery_not_low");
                    int columnIndex19 = CursorUtil.getColumnIndex(cursorQuery, "requires_storage_not_low");
                    int columnIndex20 = CursorUtil.getColumnIndex(cursorQuery, "trigger_content_update_delay");
                    int columnIndex21 = CursorUtil.getColumnIndex(cursorQuery, "trigger_max_content_delay");
                    int columnIndex22 = CursorUtil.getColumnIndex(cursorQuery, "content_uri_triggers");
                    HashMap map = new HashMap();
                    int i3 = columnIndex13;
                    HashMap map2 = new HashMap();
                    while (cursorQuery.moveToNext()) {
                        int i4 = columnIndex12;
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map.get(string)) == null) {
                            i2 = columnIndex11;
                            map.put(string, new ArrayList());
                        } else {
                            i2 = columnIndex11;
                        }
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) map2.get(string2)) == null) {
                            map2.put(string2, new ArrayList());
                        }
                        columnIndex12 = i4;
                        columnIndex11 = i2;
                    }
                    int i5 = columnIndex11;
                    int i6 = columnIndex12;
                    int i7 = -1;
                    cursorQuery.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(map);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string3 = (columnIndex == i7 || cursorQuery.isNull(columnIndex)) ? null : cursorQuery.getString(columnIndex);
                        WorkInfo.State stateIntToState = columnIndex2 == i7 ? null : WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                        if (columnIndex3 == i7) {
                            dataFromByteArray = null;
                        } else {
                            dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndex3) ? null : cursorQuery.getBlob(columnIndex3));
                        }
                        long j2 = columnIndex4 == i7 ? 0L : cursorQuery.getLong(columnIndex4);
                        long j3 = columnIndex5 == i7 ? 0L : cursorQuery.getLong(columnIndex5);
                        long j4 = columnIndex6 == i7 ? 0L : cursorQuery.getLong(columnIndex6);
                        int i8 = columnIndex7 == i7 ? 0 : cursorQuery.getInt(columnIndex7);
                        BackoffPolicy backoffPolicyIntToBackoffPolicy = columnIndex8 == i7 ? null : WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndex8));
                        long j5 = columnIndex9 == i7 ? 0L : cursorQuery.getLong(columnIndex9);
                        if (columnIndex10 == i7) {
                            i = i5;
                            j = 0;
                        } else {
                            j = cursorQuery.getLong(columnIndex10);
                            i = i5;
                        }
                        int i9 = i == i7 ? 0 : cursorQuery.getInt(i);
                        int i10 = i6;
                        int i11 = columnIndex2;
                        int i12 = i10 == i7 ? 0 : cursorQuery.getInt(i10);
                        int i13 = i3;
                        long j6 = i13 == i7 ? 0L : cursorQuery.getLong(i13);
                        int i14 = columnIndex14;
                        int i15 = i14 == i7 ? 0 : cursorQuery.getInt(i14);
                        int i16 = columnIndex15;
                        NetworkType networkTypeIntToNetworkType = i16 == i7 ? null : WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i16));
                        int i17 = columnIndex16;
                        if (i17 == i7) {
                            z = false;
                        } else {
                            z = cursorQuery.getInt(i17) != 0;
                        }
                        int i18 = columnIndex17;
                        if (i18 == i7) {
                            z2 = false;
                        } else {
                            z2 = cursorQuery.getInt(i18) != 0;
                        }
                        int i19 = columnIndex18;
                        if (i19 == i7) {
                            z3 = false;
                        } else {
                            z3 = cursorQuery.getInt(i19) != 0;
                        }
                        int i20 = columnIndex19;
                        if (i20 == i7) {
                            z4 = false;
                        } else {
                            z4 = cursorQuery.getInt(i20) != 0;
                        }
                        int i21 = columnIndex20;
                        long j7 = i21 == i7 ? 0L : cursorQuery.getLong(i21);
                        int i22 = columnIndex21;
                        long j8 = i22 != i7 ? cursorQuery.getLong(i22) : 0L;
                        int i23 = columnIndex22;
                        if (i23 == i7) {
                            setByteArrayToSetOfTriggers = null;
                        } else {
                            setByteArrayToSetOfTriggers = WorkTypeConverters.byteArrayToSetOfTriggers(cursorQuery.isNull(i23) ? null : cursorQuery.getBlob(i23));
                        }
                        Constraints constraints = new Constraints(networkTypeIntToNetworkType, z, z2, z3, z4, j7, j8, setByteArrayToSetOfTriggers);
                        ArrayList arrayList2 = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) map2.get(cursorQuery.getString(columnIndex));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(string3, stateIntToState, dataFromByteArray, j2, j3, j4, constraints, i8, backoffPolicyIntToBackoffPolicy, j5, j, i9, i12, j6, i15, arrayList3, arrayList4));
                        i5 = i;
                        i7 = -1;
                        columnIndex22 = i23;
                        columnIndex2 = i11;
                        i6 = i10;
                        i3 = i13;
                        columnIndex14 = i14;
                        columnIndex15 = i16;
                        columnIndex16 = i17;
                        columnIndex17 = i18;
                        columnIndex18 = i19;
                        columnIndex19 = i20;
                        columnIndex20 = i21;
                        columnIndex21 = i22;
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(HashMap map) {
        int i;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                map2 = new HashMap(999);
            }
            if (i > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i2 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str2);
            }
            i2++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(HashMap map) {
        int i;
        Set<String> setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            HashMap map2 = new HashMap(999);
            loop0: while (true) {
                i = 0;
                for (String str : setKeySet) {
                    map2.put(str, (ArrayList) map.get(str));
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                map2 = new HashMap(999);
            }
            if (i > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(map2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i2 = 1;
        for (String str2 : setKeySet) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str2);
            }
            i2++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorQuery.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }
}
