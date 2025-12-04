package com.allegion.accesssdk.actions;

import android.util.Pair;
import com.allegion.accesssdk.R;
import com.allegion.accesssdk.exceptions.MobileAccessException;
import com.allegion.accesssdk.exceptions.MobileAccessExceptionType;
import com.allegion.accesssdk.interfaces.IAccountPersistence;
import com.allegion.accesssdk.interfaces.IModelPersistenceManager;
import com.allegion.accesssdk.models.Account;
import com.allegion.accesssdk.models.ConnectedAccount;
import com.allegion.accesssdk.utilities.LoggingUtility;
import com.allegion.accesssdk.utilities.StringHelper;
import com.allegion.logging.AlLog;
import com.urbanairship.AirshipConfigOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f000)\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0)\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b2\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f000)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010+¨\u00064"}, d2 = {"Lcom/allegion/accesssdk/actions/AccountPersister;", "Lcom/allegion/accesssdk/interfaces/IAccountPersistence;", "", "message", "", "e", "", "trackFailureInAnalytics", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "readAccountFromPersistentStorage", "()V", "readConnectedAccountsFromPersistentStorage", "clear", "removeAccount", "removeConnectedAccount", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "connectedAccount", "", "storeConnectedAccount", "(Lcom/allegion/accesssdk/models/ConnectedAccount;)Z", "", "retrieveConnectedAccounts", "()[Lcom/allegion/accesssdk/models/ConnectedAccount;", "Ljava/util/UUID;", "connectedAccountIdentifier", "retrieveConnectedAccount", "(Ljava/util/UUID;)Lcom/allegion/accesssdk/models/ConnectedAccount;", "Lcom/allegion/accesssdk/models/Account;", "account", "storeAccount", "(Lcom/allegion/accesssdk/models/Account;)Z", "retrieveAccount", "()Lcom/allegion/accesssdk/models/Account;", "isInitialized", "()Z", "", "connectAccountNotFoundSignifier", "I", "", "connectedAccounts", "Ljava/util/List;", "Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;", "accountPersistenceManager", "Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;", "Lcom/allegion/accesssdk/models/Account;", "Lcom/allegion/accesssdk/actions/AlAnalyticsService;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/allegion/accesssdk/actions/AlAnalyticsService;", "Ljava/util/ArrayList;", "connectedAccountPersistenceManager", "<init>", "(Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;Lcom/allegion/accesssdk/interfaces/IModelPersistenceManager;Lcom/allegion/accesssdk/actions/AlAnalyticsService;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AccountPersister implements IAccountPersistence {
    private Account account;
    private final IModelPersistenceManager<Account> accountPersistenceManager;
    private final AlAnalyticsService analytics;
    private final int connectAccountNotFoundSignifier;
    private final IModelPersistenceManager<ArrayList<ConnectedAccount>> connectedAccountPersistenceManager;
    private List<ConnectedAccount> connectedAccounts;

    public AccountPersister(@NotNull IModelPersistenceManager<ArrayList<ConnectedAccount>> connectedAccountPersistenceManager, @NotNull IModelPersistenceManager<Account> accountPersistenceManager, @NotNull AlAnalyticsService analytics) {
        Intrinsics.checkParameterIsNotNull(connectedAccountPersistenceManager, "connectedAccountPersistenceManager");
        Intrinsics.checkParameterIsNotNull(accountPersistenceManager, "accountPersistenceManager");
        Intrinsics.checkParameterIsNotNull(analytics, "analytics");
        this.connectedAccountPersistenceManager = connectedAccountPersistenceManager;
        this.accountPersistenceManager = accountPersistenceManager;
        this.analytics = analytics;
        this.connectAccountNotFoundSignifier = -1;
        this.connectedAccounts = new ArrayList();
        this.account = Account.INSTANCE.getEmpty();
    }

    private final void trackFailureInAnalytics(String message, Throwable e) {
        this.analytics.trackFail("AccountPersister", "AccountPersister retrieval", new Pair(message, e.getMessage()));
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public void clear() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "clear", null, 2, null);
        this.connectedAccounts = new ArrayList();
        this.account = Account.INSTANCE.getEmpty();
        LoggingUtility.Companion.logMethodExit$default(companion, "clear", null, null, 6, null);
    }

    public final boolean isInitialized() {
        return !retrieveAccount().isEmpty();
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public void readAccountFromPersistentStorage() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "readAccountFromPersistentStorage", null, 2, null);
        try {
            Account accountRetrieve = this.accountPersistenceManager.retrieve();
            if (accountRetrieve == null) {
                accountRetrieve = Account.INSTANCE.getEmpty();
            }
            this.account = accountRetrieve;
            LoggingUtility.Companion.logMethodExit$default(companion, "readAccountFromPersistentStorage", null, null, 6, null);
        } catch (Exception e) {
            trackFailureInAnalytics("MobileAccessException", e);
            AlLog.e(e, "Encountered an unexpected error while retrieving an account from persistent storage", new Object[0]);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_RETRIEVE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.account_persister_initialize_failed_error_description), companion2.getString(R.string.retrieve_account_failed_error_description), companion2.getString(R.string.account_persister_initialize_recovery_suggestion), null, 32, null);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public void readConnectedAccountsFromPersistentStorage() {
        List<ConnectedAccount> arrayList;
        LoggingUtility.Companion.logMethodEntry$default(LoggingUtility.INSTANCE, "readConnectedAccountsFromPersistentStorage", null, 2, null);
        try {
            ArrayList<ConnectedAccount> arrayListRetrieve = this.connectedAccountPersistenceManager.retrieve();
            if (arrayListRetrieve == null || (arrayList = CollectionsKt.toMutableList((Collection) arrayListRetrieve)) == null) {
                arrayList = new ArrayList<>();
            }
            this.connectedAccounts = arrayList;
        } catch (Exception e) {
            trackFailureInAnalytics("MobileAccessException", e);
            AlLog.e(e, "Encountered an unexpected error while retrieving connectedAccounts from persistent storage", new Object[0]);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_RETRIEVE_MODEL;
            StringHelper.Companion companion = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion.getString(R.string.account_persister_initialize_failed_error_description), companion.getString(R.string.retrieve_connected_accounts_failed_error_description), companion.getString(R.string.account_persister_initialize_recovery_suggestion), null, 32, null);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public void removeAccount() {
        this.accountPersistenceManager.remove();
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public void removeConnectedAccount() {
        this.connectedAccountPersistenceManager.remove();
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    @NotNull
    public Account retrieveAccount() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "retrieveAccount", null, 2, null);
        Account account = this.account;
        LoggingUtility.Companion.logMethodExit$default(companion, "retrieveAccount", account.toString(), null, 4, null);
        return account;
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    @Nullable
    public synchronized ConnectedAccount retrieveConnectedAccount(@NotNull UUID connectedAccountIdentifier) {
        ConnectedAccount connectedAccount;
        try {
            Intrinsics.checkParameterIsNotNull(connectedAccountIdentifier, "connectedAccountIdentifier");
            LoggingUtility.INSTANCE.logMethodEntry("retrieveConnectedAccount", MapsKt.mapOf(TuplesKt.to("connectedAccountIdentified", connectedAccountIdentifier.toString())));
            List<ConnectedAccount> list = this.connectedAccounts;
            Iterator<ConnectedAccount> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getID(), connectedAccountIdentifier)) {
                    break;
                }
                i++;
            }
            connectedAccount = (ConnectedAccount) CollectionsKt.getOrNull(list, i);
            LoggingUtility.Companion.logMethodExit$default(LoggingUtility.INSTANCE, "retrieveConnectedAccount", String.valueOf(connectedAccount), null, 4, null);
        } catch (Throwable th) {
            throw th;
        }
        return connectedAccount;
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    @NotNull
    public ConnectedAccount[] retrieveConnectedAccounts() {
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        LoggingUtility.Companion.logMethodEntry$default(companion, "retrieveConnectedAccounts", null, 2, null);
        Object[] array = this.connectedAccounts.toArray(new ConnectedAccount[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        ConnectedAccount[] connectedAccountArr = (ConnectedAccount[]) array;
        LoggingUtility.Companion.logMethodExit$default(companion, "retrieveConnectedAccounts", connectedAccountArr.toString(), null, 4, null);
        return connectedAccountArr;
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public synchronized boolean storeAccount(@NotNull Account account) {
        Intrinsics.checkParameterIsNotNull(account, "account");
        LoggingUtility.Companion companion = LoggingUtility.INSTANCE;
        companion.logMethodEntry("storeAccount", MapsKt.mapOf(TuplesKt.to("account", account.toString())));
        try {
            this.accountPersistenceManager.store(account);
            this.account = account;
            AlLog.i("Exiting storeAccount", new Object[0]);
            AlLog.d("Returning Boolean: [true" + AbstractJsonLexerKt.END_LIST, new Object[0]);
            LoggingUtility.Companion.logMethodExit$default(companion, "storeAccount", String.valueOf(true), null, 4, null);
        } catch (Exception e) {
            trackFailureInAnalytics("MobileAccessException", e);
            AlLog.e(e, "Encountered an unexpected error while storing account in storeConnectedAccount", new Object[0]);
            MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_STORE_MODEL;
            StringHelper.Companion companion2 = StringHelper.INSTANCE;
            throw new MobileAccessException(e, mobileAccessExceptionType, companion2.getString(R.string.store_account_failed_error_description), companion2.getString(R.string.store_account_failed_error_description), companion2.getString(R.string.account_persister_recovery_suggestion), null, 32, null);
        }
        return true;
    }

    @Override // com.allegion.accesssdk.interfaces.IAccountPersistence
    public synchronized boolean storeConnectedAccount(@NotNull ConnectedAccount connectedAccount) {
        try {
            Intrinsics.checkParameterIsNotNull(connectedAccount, "connectedAccount");
            LoggingUtility.INSTANCE.logMethodEntry("storeConnectedAccount", MapsKt.mapOf(TuplesKt.to("connectedAccount", connectedAccount.toString())));
            UUID id = connectedAccount.getID();
            List<ConnectedAccount> list = this.connectedAccounts;
            Iterator<ConnectedAccount> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(it.next().getID(), id)) {
                    break;
                }
                i++;
            }
            if (i != this.connectAccountNotFoundSignifier) {
                list.get(i).updateAccessToken(connectedAccount.getAccessToken());
            } else {
                list.add(connectedAccount);
            }
            try {
                this.connectedAccountPersistenceManager.store((ArrayList) list);
                this.connectedAccounts = list;
                LoggingUtility.Companion.logMethodExit$default(LoggingUtility.INSTANCE, "storeConnectedAccount", String.valueOf(true), null, 4, null);
            } catch (Exception e) {
                trackFailureInAnalytics("MobileAccessException", e);
                AlLog.e(e, "Encountered an unexpected error while persisting connectedAccounts storeConnectedAccount", new Object[0]);
                MobileAccessExceptionType mobileAccessExceptionType = MobileAccessExceptionType.FAILED_TO_STORE_MODEL;
                StringHelper.Companion companion = StringHelper.INSTANCE;
                throw new MobileAccessException(e, mobileAccessExceptionType, companion.getString(R.string.store_connected_account_failed_error_description), companion.getString(R.string.store_connected_account_failed_error_description), companion.getString(R.string.account_persister_recovery_suggestion), null, 32, null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }
}
