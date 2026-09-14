package com.allegion.accesssdk.actions;

import android.content.Context;
import com.allegion.accesshub.interfaces.IAlConfig;
import com.allegion.accesssdk.enums.IAlSdkEnvironment;
import com.allegion.accesssdk.exceptions.AlPublicKeyExportException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m1836d2 = {"Lcom/allegion/accesssdk/actions/IAlSdkConfiguration;", "Lcom/allegion/accesshub/interfaces/IAlConfig;", "", "exportEccDevicePublicKeyUncompressed", "()[B", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "getEnvironment", "()Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "environment", "Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "getUserConfig", "()Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "userConfig", "AccessSdk_qaRelease"}, m1837k = 1, m1838mv = {1, 4, 0})
public interface IAlSdkConfiguration extends IAlConfig {
    @NotNull
    byte[] exportEccDevicePublicKeyUncompressed() throws AlPublicKeyExportException;

    @NotNull
    Context getContext();

    @NotNull
    IAlSdkEnvironment getEnvironment();

    @NotNull
    AlImmutableConfig getUserConfig();
}
