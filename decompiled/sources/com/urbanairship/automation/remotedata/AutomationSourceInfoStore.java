package com.urbanairship.automation.remotedata;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remotedata.RemoteDataSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationSourceInfoStore;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "(Lcom/urbanairship/PreferenceDataStore;)V", "getSourceInfo", "Lcom/urbanairship/automation/remotedata/AutomationSourceInfo;", "source", "Lcom/urbanairship/remotedata/RemoteDataSource;", "contactID", "", "makeInfoKey", "recoverSource", "recoverStore", "key", "legacyTimestampKey", "legacySdkVersionKey", "setSourceInfo", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationSourceInfoStore {
    private final PreferenceDataStore dataStore;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteDataSource.values().length];
            try {
                iArr[RemoteDataSource.CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteDataSource.APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AutomationSourceInfoStore(@NotNull PreferenceDataStore dataStore) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.dataStore = dataStore;
    }

    @Nullable
    public final AutomationSourceInfo getSourceInfo(@NotNull RemoteDataSource source, @Nullable String contactID) {
        Intrinsics.checkNotNullParameter(source, "source");
        JsonValue jsonValue = this.dataStore.getJsonValue(makeInfoKey(source, contactID));
        Intrinsics.checkNotNullExpressionValue(jsonValue, "getJsonValue(...)");
        if (jsonValue.isNull()) {
            return recoverSource(source, contactID);
        }
        return AutomationSourceInfo.INSTANCE.fromJson(jsonValue);
    }

    public final void setSourceInfo(@NotNull AutomationSourceInfo info, @NotNull RemoteDataSource source, @Nullable String contactID) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        this.dataStore.put(makeInfoKey(source, contactID), info);
    }

    private final String makeInfoKey(RemoteDataSource source, String contactID) {
        if (WhenMappings.$EnumSwitchMapping$0[source.ordinal()] == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("AutomationSourceInfo.");
            sb.append(source);
            sb.append('.');
            if (contactID == null) {
                contactID = "";
            }
            sb.append(contactID);
            return sb.toString();
        }
        return "AutomationSourceInfo." + source;
    }

    private final AutomationSourceInfo recoverSource(RemoteDataSource source, String contactID) {
        String strMakeInfoKey = makeInfoKey(source, contactID);
        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
        if (i == 1) {
            return recoverStore(strMakeInfoKey, "com.urbanairship.iam.data.contact_last_payload_timestamp", "com.urbanairship.iaa.contact_last_sdk_version");
        }
        if (i == 2) {
            return recoverStore(strMakeInfoKey, "com.urbanairship.iam.data.LAST_PAYLOAD_TIMESTAMP", "com.urbanairship.iaa.last_sdk_version");
        }
        throw new NoWhenBranchMatchedException();
    }

    private final AutomationSourceInfo recoverStore(String key, String legacyTimestampKey, String legacySdkVersionKey) {
        String string = this.dataStore.getString(legacySdkVersionKey, null);
        long j = this.dataStore.getLong(legacyTimestampKey, -1L);
        if (string == null || j == -1) {
            return null;
        }
        AutomationSourceInfo automationSourceInfo = new AutomationSourceInfo(null, j, string);
        this.dataStore.put(key, automationSourceInfo);
        this.dataStore.remove(legacyTimestampKey);
        this.dataStore.remove(legacySdkVersionKey);
        return automationSourceInfo;
    }
}
