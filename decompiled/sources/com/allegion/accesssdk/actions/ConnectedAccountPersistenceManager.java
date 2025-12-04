package com.allegion.accesssdk.actions;

import android.util.Pair;
import com.allegion.accesssdk.R;
import com.allegion.accesssdk.exceptions.MobileAccessException;
import com.allegion.accesssdk.exceptions.MobileAccessExceptionType;
import com.allegion.accesssdk.interfaces.IModelPersistenceManager;
import com.allegion.accesssdk.models.ConnectedAccount;
import com.allegion.accesssdk.utilities.AnalyticsConstants;
import com.allegion.accesssdk.utilities.LoggingUtility;
import com.allegion.accesssdk.utilities.StringHelper;
import com.allegion.logging.AlLog;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.channel.AttributeMutation;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/allegion/accesssdk/actions/ConnectedAccountPersistenceManager;", "Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;", "Ljava/util/ArrayList;", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "Lkotlin/collections/ArrayList;", "src", "", "store", "(Ljava/util/ArrayList;)V", "retrieve", "()Ljava/util/ArrayList;", "", "contains", "()Z", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "()V", "Lcom/allegion/accesssdk/actions/IAlStorageService;", "persistence", "Lcom/allegion/accesssdk/actions/IAlStorageService;", "", "errorString", "Ljava/lang/String;", "key", "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", "<init>", "(Lcom/allegion/accesssdk/actions/IAlAnalyticsService;Lcom/allegion/accesssdk/actions/IAlStorageService;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class ConnectedAccountPersistenceManager implements IModelPersistenceManager<ArrayList<ConnectedAccount>> {
    private final IAlAnalyticsService analytics;
    private final String errorString;
    private final String key;
    private final IAlStorageService persistence;

    public ConnectedAccountPersistenceManager(@NotNull IAlAnalyticsService analytics, @NotNull IAlStorageService persistence) {
        Intrinsics.checkParameterIsNotNull(analytics, "analytics");
        Intrinsics.checkParameterIsNotNull(persistence, "persistence");
        this.analytics = analytics;
        this.persistence = persistence;
        this.key = "52aaad48-4ef2-11ed-bdc3-0242ac120002";
        this.errorString = "Error";
    }

    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    public boolean contains() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "contains", null, 2, null);
        boolean zContains = this.persistence.contains(this.key);
        LoggingUtility.Companion.logMethodExit$default(companion, "contains", String.valueOf(zContains), null, 4, null);
        return zContains;
    }

    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    public void remove() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, AttributeMutation.ATTRIBUTE_ACTION_REMOVE, null, 2, null);
        this.persistence.remove(this.key);
        LoggingUtility.Companion.logMethodExit$default(companion, AttributeMutation.ATTRIBUTE_ACTION_REMOVE, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, java.util.ArrayList, java.util.Collection] */
    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    @Nullable
    public ArrayList<ConnectedAccount> retrieve() {
        ArrayList<ConnectedAccount> arrayList = null;
        LoggingUtility.Companion.logMethodEntry$default(LoggingUtility.INSTANCE, "retrieve", null, 2, null);
        try {
            if (this.persistence.contains(this.key)) {
                Serializable serializableRetrieve = this.persistence.retrieve(this.key, ArrayList.class);
                Intrinsics.checkExpressionValueIsNotNull(serializableRetrieve, "persistence.retrieve(key, ArrayList::class.java)");
                ?? arrayList2 = new ArrayList();
                for (Object obj : (Iterable) serializableRetrieve) {
                    if (obj instanceof ConnectedAccount) {
                        arrayList2.add(obj);
                    }
                }
                LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
                String string = arrayList2.toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "retrievalResult.toString()");
                LoggingUtility.Companion.logMethodExit$default(companion, "store", string, null, 4, null);
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Exception e) {
            this.analytics.trackFail(AnalyticsConstants.CONNECTED_ACCOUNT_CATEGORY, AnalyticsConstants.CONNECTED_ACCOUNT_RETRIEVAL_ACTION, new Pair(this.errorString, e.getMessage()));
            AlLog.e(e, "Encountered an unexpected error while attempting to retrieve Connected Accounts", new Object[0]);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_RETRIEVE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.retrieve_connected_accounts_failed_error_description), companion2.getString(R.string.retrieve_connected_accounts_failed_failure_reason), companion2.getString(R.string.default_recovery_suggestion), null, 32, null);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    public void store(@NotNull ArrayList<ConnectedAccount> src) {
        Intrinsics.checkParameterIsNotNull(src, "src");
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        companion.logMethodEntry("store", MapsKt.mapOf(TuplesKt.to("src", src.toString())));
        try {
            this.persistence.store(this.key, src);
            LoggingUtility.Companion.logMethodExit$default(companion, "store", "Store Successful", null, 4, null);
        } catch (Exception e) {
            this.analytics.trackFail(AnalyticsConstants.CONNECTED_ACCOUNT_CATEGORY, AnalyticsConstants.CONNECTED_ACCOUNT_STORAGE_ACTION, new Pair(this.errorString, e.getMessage()));
            AlLog.e(e, "Encountered an unexpected error while attempting to store Connected Account", new Object[0]);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_STORE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.store_connected_accounts_failed_error_description), companion2.getString(R.string.store_connected_accounts_failed_failure_reason), companion2.getString(R.string.default_recovery_suggestion), null, 32, null);
        }
    }
}
