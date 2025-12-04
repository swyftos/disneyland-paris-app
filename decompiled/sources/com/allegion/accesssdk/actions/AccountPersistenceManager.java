package com.allegion.accesssdk.actions;

import android.util.Pair;
import com.allegion.accesssdk.R;
import com.allegion.accesssdk.exceptions.MobileAccessException;
import com.allegion.accesssdk.exceptions.MobileAccessExceptionType;
import com.allegion.accesssdk.interfaces.IModelPersistenceManager;
import com.allegion.accesssdk.models.Account;
import com.allegion.accesssdk.utilities.AnalyticsConstants;
import com.allegion.accesssdk.utilities.LoggingUtility;
import com.allegion.accesssdk.utilities.StringHelper;
import com.allegion.logging.AlLog;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/allegion/accesssdk/actions/AccountPersistenceManager;", "Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;", "Lcom/allegion/accesssdk/models/Account;", "src", "", "store", "(Lcom/allegion/accesssdk/models/Account;)V", "retrieve", "()Lcom/allegion/accesssdk/models/Account;", "", "contains", "()Z", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "()V", "", "errorString", "Ljava/lang/String;", "key", "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", "Lcom/allegion/accesssdk/actions/IAlStorageService;", "persistence", "Lcom/allegion/accesssdk/actions/IAlStorageService;", "<init>", "(Lcom/allegion/accesssdk/actions/IAlAnalyticsService;Lcom/allegion/accesssdk/actions/IAlStorageService;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AccountPersistenceManager implements IModelPersistenceManager<Account> {
    private final IAlAnalyticsService analytics;
    private final String errorString;
    private final String key;
    private final IAlStorageService persistence;

    public AccountPersistenceManager(@NotNull IAlAnalyticsService analytics, @NotNull IAlStorageService persistence) {
        Intrinsics.checkParameterIsNotNull(analytics, "analytics");
        Intrinsics.checkParameterIsNotNull(persistence, "persistence");
        this.analytics = analytics;
        this.persistence = persistence;
        this.key = "52aab158-4ef2-11ed-bdc3-0242ac120002";
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    @Nullable
    public Account retrieve() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "retrieve", null, 2, null);
        try {
            if (!this.persistence.contains(this.key)) {
                return null;
            }
            Account account = (Account) this.persistence.retrieve(this.key, Account.class);
            companion.logMethodExit("retrieve", account.toString(), "Retrieve Successful");
            return account;
        } catch (Exception e) {
            this.analytics.trackFail(AnalyticsConstants.ACCOUNT_CATEGORY, AnalyticsConstants.ACCOUNT_RETRIEVAL_ACTION, new Pair(this.errorString, e.getMessage()));
            AlLog.e("Retrieve method failed", e);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_RETRIEVE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.retrieve_account_failed_error_description), companion2.getString(R.string.retrieve_account_failed_failure_reason), companion2.getString(R.string.default_recovery_suggestion), null, 32, null);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IModelPersistenceManager
    public void store(@NotNull Account src) {
        Intrinsics.checkParameterIsNotNull(src, "src");
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        companion.logMethodEntry("store", MapsKt.mapOf(TuplesKt.to("src", src.toString())));
        try {
            this.persistence.store(this.key, src);
            LoggingUtility.Companion.logMethodExit$default(companion, "store", null, null, 6, null);
        } catch (Exception e) {
            this.analytics.trackFail(AnalyticsConstants.ACCOUNT_CATEGORY, AnalyticsConstants.ACCOUNT_STORAGE_ACTION, new Pair(this.errorString, e.getMessage()));
            AlLog.e("Failed to store Account. Account details- account ID: " + src.getAccountID() + ", device ID: " + src.getDeviceID(), e);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_STORE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.store_account_failed_error_description), companion2.getString(R.string.store_account_failed_failure_reason), companion2.getString(R.string.default_recovery_suggestion), null, 32, null);
        }
    }
}
