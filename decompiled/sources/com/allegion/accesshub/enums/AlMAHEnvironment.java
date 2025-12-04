package com.allegion.accesshub.enums;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.allegion.accesshub.interfaces.IAlMAHEnvironment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/allegion/accesshub/enums/AlMAHEnvironment;", "", "Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getBaseAccessHubUrl", "()Ljava/lang/String;", "baseAccessHubUrl", "b", "getBaseApiManagementUrl", "baseApiManagementUrl", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "DEV", "QA", "BETA", "PILOT", "PROD", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public enum AlMAHEnvironment implements IAlMAHEnvironment {
    DEV("https://api.securewebserv.com/dev/mobileaccess/", "https://api.securewebserv.com"),
    QA("https://api.securewebserv.com/test/mobileaccess/", "https://api.securewebserv.com"),
    BETA("https://api.securewebserv.com/mobileaccess/", "https://api.securewebserv.com"),
    PILOT("https://api.allegion.com/pilot/mobileaccess/", "https://api.allegion.com/"),
    PROD("https://api.allegion.com/mobileaccess/", "https://api.allegion.com/");


    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final String baseAccessHubUrl;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private final String baseApiManagementUrl;

    AlMAHEnvironment(String str, String str2) {
        this.baseAccessHubUrl = str;
        this.baseApiManagementUrl = str2;
    }

    @Override // com.allegion.accesshub.interfaces.IAlMAHEnvironment
    @NotNull
    public String getBaseAccessHubUrl() {
        return this.baseAccessHubUrl;
    }

    @Override // com.allegion.accesshub.interfaces.IAlMAHEnvironment
    @NotNull
    public String getBaseApiManagementUrl() {
        return this.baseApiManagementUrl;
    }
}
