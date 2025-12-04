package com.allegion.accesshub.interfaces;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;", "", "", "getBaseApiManagementUrl", "()Ljava/lang/String;", "baseApiManagementUrl", "getBaseAccessHubUrl", "baseAccessHubUrl", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlMAHEnvironment {
    @NotNull
    String getBaseAccessHubUrl();

    @NotNull
    String getBaseApiManagementUrl();
}
