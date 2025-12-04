package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.models.Account;
import com.allegion.accesssdk.models.ConnectedAccount;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/allegion/accesssdk/interfaces/IAccountPersistence;", "", "", "readAccountFromPersistentStorage", "()V", "readConnectedAccountsFromPersistentStorage", "clear", "removeAccount", "removeConnectedAccount", "Lcom/allegion/accesssdk/models/ConnectedAccount;", "connectedAccount", "", "storeConnectedAccount", "(Lcom/allegion/accesssdk/models/ConnectedAccount;)Z", "", "retrieveConnectedAccounts", "()[Lcom/allegion/accesssdk/models/ConnectedAccount;", "Ljava/util/UUID;", "connectedAccountIdentifier", "retrieveConnectedAccount", "(Ljava/util/UUID;)Lcom/allegion/accesssdk/models/ConnectedAccount;", "Lcom/allegion/accesssdk/models/Account;", "account", "storeAccount", "(Lcom/allegion/accesssdk/models/Account;)Z", "retrieveAccount", "()Lcom/allegion/accesssdk/models/Account;", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAccountPersistence {
    void clear();

    void readAccountFromPersistentStorage();

    void readConnectedAccountsFromPersistentStorage();

    void removeAccount();

    void removeConnectedAccount();

    @NotNull
    Account retrieveAccount();

    @Nullable
    ConnectedAccount retrieveConnectedAccount(@NotNull UUID connectedAccountIdentifier);

    @NotNull
    ConnectedAccount[] retrieveConnectedAccounts();

    boolean storeAccount(@NotNull Account account);

    boolean storeConnectedAccount(@NotNull ConnectedAccount connectedAccount);
}
