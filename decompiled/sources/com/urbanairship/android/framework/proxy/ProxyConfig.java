package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.PrivacyManager;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002EFB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B¿\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00100\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00102\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fHÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fHÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fHÆ\u0003JÈ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\b\u0010B\u001a\u00020CH\u0016J\t\u0010D\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b$\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0012\u0010\u001dR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0013\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*¨\u0006G"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyConfig;", "Lcom/urbanairship/json/JsonSerializable;", "config", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "defaultEnvironment", "Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;", "productionEnvironment", "developmentEnvironment", "site", "", "inProduction", "", "initialConfigUrl", "urlAllowList", "", "urlAllowListScopeJavaScriptInterface", "urlAllowListScopeOpenUrl", "isChannelCaptureEnabled", "isChannelCreationDelayEnabled", "enabledFeatures", "Lcom/urbanairship/PrivacyManager$Feature;", "autoPauseInAppAutomationOnLaunch", "androidConfig", "Lcom/urbanairship/android/framework/proxy/ProxyConfig$Android;", "(Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/urbanairship/PrivacyManager$Feature;Ljava/lang/Boolean;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Android;)V", "getAndroidConfig", "()Lcom/urbanairship/android/framework/proxy/ProxyConfig$Android;", "getAutoPauseInAppAutomationOnLaunch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDefaultEnvironment", "()Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;", "getDevelopmentEnvironment", "getEnabledFeatures", "()Lcom/urbanairship/PrivacyManager$Feature;", "getInProduction", "getInitialConfigUrl", "()Ljava/lang/String;", "getProductionEnvironment", "getSite", "getUrlAllowList", "()Ljava/util/List;", "getUrlAllowListScopeJavaScriptInterface", "getUrlAllowListScopeOpenUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/urbanairship/PrivacyManager$Feature;Ljava/lang/Boolean;Lcom/urbanairship/android/framework/proxy/ProxyConfig$Android;)Lcom/urbanairship/android/framework/proxy/ProxyConfig;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Android", "Environment", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProxyConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProxyConfig.kt\ncom/urbanairship/android/framework/proxy/ProxyConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1#2:115\n1#2:128\n1#2:141\n1603#3,9:105\n1855#3:114\n1856#3:116\n1612#3:117\n1603#3,9:118\n1855#3:127\n1856#3:129\n1612#3:130\n1603#3,9:131\n1855#3:140\n1856#3:142\n1612#3:143\n*S KotlinDebug\n*F\n+ 1 ProxyConfig.kt\ncom/urbanairship/android/framework/proxy/ProxyConfig\n*L\n34#1:115\n35#1:128\n36#1:141\n34#1:105,9\n34#1:114\n34#1:116\n34#1:117\n35#1:118,9\n35#1:127\n35#1:129\n35#1:130\n36#1:131,9\n36#1:140\n36#1:142\n36#1:143\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class ProxyConfig implements JsonSerializable {
    private final Android androidConfig;
    private final Boolean autoPauseInAppAutomationOnLaunch;
    private final Environment defaultEnvironment;
    private final Environment developmentEnvironment;
    private final PrivacyManager.Feature enabledFeatures;
    private final Boolean inProduction;
    private final String initialConfigUrl;
    private final Boolean isChannelCaptureEnabled;
    private final Boolean isChannelCreationDelayEnabled;
    private final Environment productionEnvironment;
    private final String site;
    private final List urlAllowList;
    private final List urlAllowListScopeJavaScriptInterface;
    private final List urlAllowListScopeOpenUrl;

    public ProxyConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Environment getDefaultEnvironment() {
        return this.defaultEnvironment;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getIsChannelCaptureEnabled() {
        return this.isChannelCaptureEnabled;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getIsChannelCreationDelayEnabled() {
        return this.isChannelCreationDelayEnabled;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final PrivacyManager.Feature getEnabledFeatures() {
        return this.enabledFeatures;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getAutoPauseInAppAutomationOnLaunch() {
        return this.autoPauseInAppAutomationOnLaunch;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Android getAndroidConfig() {
        return this.androidConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Environment getProductionEnvironment() {
        return this.productionEnvironment;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Environment getDevelopmentEnvironment() {
        return this.developmentEnvironment;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSite() {
        return this.site;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getInProduction() {
        return this.inProduction;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getInitialConfigUrl() {
        return this.initialConfigUrl;
    }

    @Nullable
    public final List<String> component7() {
        return this.urlAllowList;
    }

    @Nullable
    public final List<String> component8() {
        return this.urlAllowListScopeJavaScriptInterface;
    }

    @Nullable
    public final List<String> component9() {
        return this.urlAllowListScopeOpenUrl;
    }

    @NotNull
    public final ProxyConfig copy(@Nullable Environment defaultEnvironment, @Nullable Environment productionEnvironment, @Nullable Environment developmentEnvironment, @Nullable String site, @Nullable Boolean inProduction, @Nullable String initialConfigUrl, @Nullable List<String> urlAllowList, @Nullable List<String> urlAllowListScopeJavaScriptInterface, @Nullable List<String> urlAllowListScopeOpenUrl, @Nullable Boolean isChannelCaptureEnabled, @Nullable Boolean isChannelCreationDelayEnabled, @Nullable PrivacyManager.Feature enabledFeatures, @Nullable Boolean autoPauseInAppAutomationOnLaunch, @Nullable Android androidConfig) {
        return new ProxyConfig(defaultEnvironment, productionEnvironment, developmentEnvironment, site, inProduction, initialConfigUrl, urlAllowList, urlAllowListScopeJavaScriptInterface, urlAllowListScopeOpenUrl, isChannelCaptureEnabled, isChannelCreationDelayEnabled, enabledFeatures, autoPauseInAppAutomationOnLaunch, androidConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxyConfig)) {
            return false;
        }
        ProxyConfig proxyConfig = (ProxyConfig) other;
        return Intrinsics.areEqual(this.defaultEnvironment, proxyConfig.defaultEnvironment) && Intrinsics.areEqual(this.productionEnvironment, proxyConfig.productionEnvironment) && Intrinsics.areEqual(this.developmentEnvironment, proxyConfig.developmentEnvironment) && Intrinsics.areEqual(this.site, proxyConfig.site) && Intrinsics.areEqual(this.inProduction, proxyConfig.inProduction) && Intrinsics.areEqual(this.initialConfigUrl, proxyConfig.initialConfigUrl) && Intrinsics.areEqual(this.urlAllowList, proxyConfig.urlAllowList) && Intrinsics.areEqual(this.urlAllowListScopeJavaScriptInterface, proxyConfig.urlAllowListScopeJavaScriptInterface) && Intrinsics.areEqual(this.urlAllowListScopeOpenUrl, proxyConfig.urlAllowListScopeOpenUrl) && Intrinsics.areEqual(this.isChannelCaptureEnabled, proxyConfig.isChannelCaptureEnabled) && Intrinsics.areEqual(this.isChannelCreationDelayEnabled, proxyConfig.isChannelCreationDelayEnabled) && Intrinsics.areEqual(this.enabledFeatures, proxyConfig.enabledFeatures) && Intrinsics.areEqual(this.autoPauseInAppAutomationOnLaunch, proxyConfig.autoPauseInAppAutomationOnLaunch) && Intrinsics.areEqual(this.androidConfig, proxyConfig.androidConfig);
    }

    public int hashCode() {
        Environment environment = this.defaultEnvironment;
        int iHashCode = (environment == null ? 0 : environment.hashCode()) * 31;
        Environment environment2 = this.productionEnvironment;
        int iHashCode2 = (iHashCode + (environment2 == null ? 0 : environment2.hashCode())) * 31;
        Environment environment3 = this.developmentEnvironment;
        int iHashCode3 = (iHashCode2 + (environment3 == null ? 0 : environment3.hashCode())) * 31;
        String str = this.site;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.inProduction;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.initialConfigUrl;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.urlAllowList;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.urlAllowListScopeJavaScriptInterface;
        int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.urlAllowListScopeOpenUrl;
        int iHashCode9 = (iHashCode8 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool2 = this.isChannelCaptureEnabled;
        int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isChannelCreationDelayEnabled;
        int iHashCode11 = (iHashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        PrivacyManager.Feature feature = this.enabledFeatures;
        int iHashCode12 = (iHashCode11 + (feature == null ? 0 : feature.hashCode())) * 31;
        Boolean bool4 = this.autoPauseInAppAutomationOnLaunch;
        int iHashCode13 = (iHashCode12 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Android android2 = this.androidConfig;
        return iHashCode13 + (android2 != null ? android2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProxyConfig(defaultEnvironment=" + this.defaultEnvironment + ", productionEnvironment=" + this.productionEnvironment + ", developmentEnvironment=" + this.developmentEnvironment + ", site=" + this.site + ", inProduction=" + this.inProduction + ", initialConfigUrl=" + this.initialConfigUrl + ", urlAllowList=" + this.urlAllowList + ", urlAllowListScopeJavaScriptInterface=" + this.urlAllowListScopeJavaScriptInterface + ", urlAllowListScopeOpenUrl=" + this.urlAllowListScopeOpenUrl + ", isChannelCaptureEnabled=" + this.isChannelCaptureEnabled + ", isChannelCreationDelayEnabled=" + this.isChannelCreationDelayEnabled + ", enabledFeatures=" + this.enabledFeatures + ", autoPauseInAppAutomationOnLaunch=" + this.autoPauseInAppAutomationOnLaunch + ", androidConfig=" + this.androidConfig + ")";
    }

    public ProxyConfig(@Nullable Environment environment, @Nullable Environment environment2, @Nullable Environment environment3, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable PrivacyManager.Feature feature, @Nullable Boolean bool4, @Nullable Android android2) {
        this.defaultEnvironment = environment;
        this.productionEnvironment = environment2;
        this.developmentEnvironment = environment3;
        this.site = str;
        this.inProduction = bool;
        this.initialConfigUrl = str2;
        this.urlAllowList = list;
        this.urlAllowListScopeJavaScriptInterface = list2;
        this.urlAllowListScopeOpenUrl = list3;
        this.isChannelCaptureEnabled = bool2;
        this.isChannelCreationDelayEnabled = bool3;
        this.enabledFeatures = feature;
        this.autoPauseInAppAutomationOnLaunch = bool4;
        this.androidConfig = android2;
    }

    public /* synthetic */ ProxyConfig(Environment environment, Environment environment2, Environment environment3, String str, Boolean bool, String str2, List list, List list2, List list3, Boolean bool2, Boolean bool3, PrivacyManager.Feature feature, Boolean bool4, Android android2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : environment, (i & 2) != 0 ? null : environment2, (i & 4) != 0 ? null : environment3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? null : bool2, (i & 1024) != 0 ? null : bool3, (i & 2048) != 0 ? null : feature, (i & 4096) != 0 ? null : bool4, (i & 8192) == 0 ? android2 : null);
    }

    @Nullable
    public final Environment getDefaultEnvironment() {
        return this.defaultEnvironment;
    }

    @Nullable
    public final Environment getProductionEnvironment() {
        return this.productionEnvironment;
    }

    @Nullable
    public final Environment getDevelopmentEnvironment() {
        return this.developmentEnvironment;
    }

    @Nullable
    public final String getSite() {
        return this.site;
    }

    @Nullable
    public final Boolean getInProduction() {
        return this.inProduction;
    }

    @Nullable
    public final String getInitialConfigUrl() {
        return this.initialConfigUrl;
    }

    @Nullable
    public final List<String> getUrlAllowList() {
        return this.urlAllowList;
    }

    @Nullable
    public final List<String> getUrlAllowListScopeJavaScriptInterface() {
        return this.urlAllowListScopeJavaScriptInterface;
    }

    @Nullable
    public final List<String> getUrlAllowListScopeOpenUrl() {
        return this.urlAllowListScopeOpenUrl;
    }

    @Nullable
    public final Boolean isChannelCaptureEnabled() {
        return this.isChannelCaptureEnabled;
    }

    @Nullable
    public final Boolean isChannelCreationDelayEnabled() {
        return this.isChannelCreationDelayEnabled;
    }

    @Nullable
    public final PrivacyManager.Feature getEnabledFeatures() {
        return this.enabledFeatures;
    }

    @Nullable
    public final Boolean getAutoPauseInAppAutomationOnLaunch() {
        return this.autoPauseInAppAutomationOnLaunch;
    }

    @Nullable
    public final Android getAndroidConfig() {
        return this.androidConfig;
    }

    public ProxyConfig(@NotNull JsonMap config) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JsonMap map;
        JsonList list;
        JsonList list2;
        JsonList list3;
        String string;
        JsonMap map2;
        JsonMap map3;
        JsonMap map4;
        Intrinsics.checkNotNullParameter(config, "config");
        JsonValue jsonValue = config.get("default");
        Android android2 = null;
        Environment environment = (jsonValue == null || (map4 = jsonValue.getMap()) == null) ? null : new Environment(map4);
        JsonValue jsonValue2 = config.get("production");
        Environment environment2 = (jsonValue2 == null || (map3 = jsonValue2.getMap()) == null) ? null : new Environment(map3);
        JsonValue jsonValue3 = config.get("development");
        Environment environment3 = (jsonValue3 == null || (map2 = jsonValue3.getMap()) == null) ? null : new Environment(map2);
        JsonValue jsonValue4 = config.get("site");
        String site = (jsonValue4 == null || (string = jsonValue4.getString()) == null) ? null : Utils.INSTANCE.parseSite(string);
        JsonValue jsonValue5 = config.get("inProduction");
        Boolean bool = jsonValue5 != null ? jsonValue5.getBoolean() : null;
        JsonValue jsonValue6 = config.get("initialConfigUrl");
        String string2 = jsonValue6 != null ? jsonValue6.getString() : null;
        JsonValue jsonValue7 = config.get("urlAllowList");
        if (jsonValue7 == null || (list3 = jsonValue7.getList()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Iterator<JsonValue> it = list3.iterator();
            while (it.hasNext()) {
                String string3 = it.next().getString();
                if (string3 != null) {
                    arrayList4.add(string3);
                }
            }
            arrayList = arrayList4;
        }
        JsonValue jsonValue8 = config.get("urlAllowListScopeJavaScriptInterface");
        if (jsonValue8 == null || (list2 = jsonValue8.getList()) == null) {
            arrayList2 = null;
        } else {
            ArrayList arrayList5 = new ArrayList();
            Iterator<JsonValue> it2 = list2.iterator();
            while (it2.hasNext()) {
                String string4 = it2.next().getString();
                if (string4 != null) {
                    arrayList5.add(string4);
                }
            }
            arrayList2 = arrayList5;
        }
        JsonValue jsonValue9 = config.get("urlAllowListScopeOpenUrl");
        if (jsonValue9 == null || (list = jsonValue9.getList()) == null) {
            arrayList3 = null;
        } else {
            ArrayList arrayList6 = new ArrayList();
            Iterator<JsonValue> it3 = list.iterator();
            while (it3.hasNext()) {
                String string5 = it3.next().getString();
                if (string5 != null) {
                    arrayList6.add(string5);
                }
            }
            arrayList3 = arrayList6;
        }
        JsonValue jsonValue10 = config.get("isChannelCaptureEnabled");
        Boolean bool2 = jsonValue10 != null ? jsonValue10.getBoolean() : null;
        JsonValue jsonValue11 = config.get("isChannelCreationDelayEnabled");
        Boolean bool3 = jsonValue11 != null ? jsonValue11.getBoolean() : null;
        JsonValue jsonValue12 = config.get("enabledFeatures");
        PrivacyManager.Feature features = jsonValue12 != null ? Utils.INSTANCE.parseFeatures(jsonValue12) : null;
        JsonValue jsonValue13 = config.get("autoPauseInAppAutomationOnLaunch");
        Boolean bool4 = jsonValue13 != null ? jsonValue13.getBoolean() : null;
        JsonValue jsonValue14 = config.get("android");
        if (jsonValue14 != null && (map = jsonValue14.getMap()) != null) {
            android2 = new Android(map);
        }
        this(environment, environment2, environment3, site, bool, string2, arrayList, arrayList2, arrayList3, bool2, bool3, features, bool4, android2);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("default", this.defaultEnvironment).put("production", this.productionEnvironment).put("development", this.developmentEnvironment);
        String str = this.site;
        JsonMap.Builder builderPutOpt = builderPut.put("site", str != null ? Utils.INSTANCE.siteString(str) : null).putOpt("inProduction", this.inProduction).putOpt("initialConfigUrl", this.initialConfigUrl).putOpt("urlAllowList", this.urlAllowList).putOpt("urlAllowListScopeJavaScriptInterface", this.urlAllowListScopeJavaScriptInterface).putOpt("urlAllowListScopeOpenUrl", this.urlAllowListScopeOpenUrl).putOpt("isChannelCaptureEnabled", this.isChannelCaptureEnabled).putOpt("isChannelCreationDelayEnabled", this.isChannelCreationDelayEnabled);
        PrivacyManager.Feature feature = this.enabledFeatures;
        JsonValue jsonValue = builderPutOpt.putOpt("enabledFeatures", feature != null ? Utils.featureNames(feature) : null).putOpt("autoPauseInAppAutomationOnLaunch", this.autoPauseInAppAutomationOnLaunch).putOpt("android", this.androidConfig).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;", "Lcom/urbanairship/json/JsonSerializable;", "config", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "appKey", "", "appSecret", "logLevel", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppKey", "()Ljava/lang/String;", "getAppSecret", "getLogLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/urbanairship/android/framework/proxy/ProxyConfig$Environment;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nProxyConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProxyConfig.kt\ncom/urbanairship/android/framework/proxy/ProxyConfig$Environment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
    public static final /* data */ class Environment implements JsonSerializable {
        private final String appKey;
        private final String appSecret;
        private final Integer logLevel;

        public static /* synthetic */ Environment copy$default(Environment environment, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = environment.appKey;
            }
            if ((i & 2) != 0) {
                str2 = environment.appSecret;
            }
            if ((i & 4) != 0) {
                num = environment.logLevel;
            }
            return environment.copy(str, str2, num);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getAppKey() {
            return this.appKey;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getAppSecret() {
            return this.appSecret;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Integer getLogLevel() {
            return this.logLevel;
        }

        @NotNull
        public final Environment copy(@Nullable String appKey, @Nullable String appSecret, @Nullable Integer logLevel) {
            return new Environment(appKey, appSecret, logLevel);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Environment)) {
                return false;
            }
            Environment environment = (Environment) other;
            return Intrinsics.areEqual(this.appKey, environment.appKey) && Intrinsics.areEqual(this.appSecret, environment.appSecret) && Intrinsics.areEqual(this.logLevel, environment.logLevel);
        }

        public int hashCode() {
            String str = this.appKey;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.appSecret;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.logLevel;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Environment(appKey=" + this.appKey + ", appSecret=" + this.appSecret + ", logLevel=" + this.logLevel + ")";
        }

        public Environment(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
            this.appKey = str;
            this.appSecret = str2;
            this.logLevel = num;
        }

        @Nullable
        public final String getAppKey() {
            return this.appKey;
        }

        @Nullable
        public final String getAppSecret() {
            return this.appSecret;
        }

        @Nullable
        public final Integer getLogLevel() {
            return this.logLevel;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() throws JsonException {
            String strLogLevelString;
            JsonMap.Builder builderPutOpt = JsonMap.newBuilder().putOpt("appKey", this.appKey).putOpt("appSecret", this.appSecret);
            Integer num = this.logLevel;
            if (num != null) {
                strLogLevelString = Utils.INSTANCE.logLevelString(num.intValue());
            } else {
                strLogLevelString = null;
            }
            JsonValue jsonValue = builderPutOpt.putOpt("logLevel", strLogLevelString).build().getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Environment(@NotNull JsonMap config) {
            String string;
            Intrinsics.checkNotNullParameter(config, "config");
            JsonValue jsonValue = config.get("appKey");
            Integer numValueOf = null;
            String string2 = jsonValue != null ? jsonValue.getString() : null;
            JsonValue jsonValue2 = config.get("appSecret");
            String string3 = jsonValue2 != null ? jsonValue2.getString() : null;
            JsonValue jsonValue3 = config.get("logLevel");
            if (jsonValue3 != null && (string = jsonValue3.getString()) != null) {
                numValueOf = Integer.valueOf(Utils.INSTANCE.parseLogLevel(string));
            }
            this(string2, string3, numValueOf);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyConfig$Android;", "Lcom/urbanairship/json/JsonSerializable;", "config", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "appStoreUri", "", "fcmFirebaseAppName", "notificationConfig", "Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "logPrivacyLevel", "Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/framework/proxy/NotificationConfig;Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;)V", "getAppStoreUri", "()Ljava/lang/String;", "getFcmFirebaseAppName", "getLogPrivacyLevel", "()Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;", "getNotificationConfig", "()Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nProxyConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProxyConfig.kt\ncom/urbanairship/android/framework/proxy/ProxyConfig$Android\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
    public static final /* data */ class Android implements JsonSerializable {
        private final String appStoreUri;
        private final String fcmFirebaseAppName;
        private final AirshipConfigOptions.PrivacyLevel logPrivacyLevel;
        private final NotificationConfig notificationConfig;

        public static /* synthetic */ Android copy$default(Android android2, String str, String str2, NotificationConfig notificationConfig, AirshipConfigOptions.PrivacyLevel privacyLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = android2.appStoreUri;
            }
            if ((i & 2) != 0) {
                str2 = android2.fcmFirebaseAppName;
            }
            if ((i & 4) != 0) {
                notificationConfig = android2.notificationConfig;
            }
            if ((i & 8) != 0) {
                privacyLevel = android2.logPrivacyLevel;
            }
            return android2.copy(str, str2, notificationConfig, privacyLevel);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getAppStoreUri() {
            return this.appStoreUri;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getFcmFirebaseAppName() {
            return this.fcmFirebaseAppName;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final NotificationConfig getNotificationConfig() {
            return this.notificationConfig;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final AirshipConfigOptions.PrivacyLevel getLogPrivacyLevel() {
            return this.logPrivacyLevel;
        }

        @NotNull
        public final Android copy(@Nullable String appStoreUri, @Nullable String fcmFirebaseAppName, @Nullable NotificationConfig notificationConfig, @Nullable AirshipConfigOptions.PrivacyLevel logPrivacyLevel) {
            return new Android(appStoreUri, fcmFirebaseAppName, notificationConfig, logPrivacyLevel);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Android)) {
                return false;
            }
            Android android2 = (Android) other;
            return Intrinsics.areEqual(this.appStoreUri, android2.appStoreUri) && Intrinsics.areEqual(this.fcmFirebaseAppName, android2.fcmFirebaseAppName) && Intrinsics.areEqual(this.notificationConfig, android2.notificationConfig) && this.logPrivacyLevel == android2.logPrivacyLevel;
        }

        public int hashCode() {
            String str = this.appStoreUri;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.fcmFirebaseAppName;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            NotificationConfig notificationConfig = this.notificationConfig;
            int iHashCode3 = (iHashCode2 + (notificationConfig == null ? 0 : notificationConfig.hashCode())) * 31;
            AirshipConfigOptions.PrivacyLevel privacyLevel = this.logPrivacyLevel;
            return iHashCode3 + (privacyLevel != null ? privacyLevel.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Android(appStoreUri=" + this.appStoreUri + ", fcmFirebaseAppName=" + this.fcmFirebaseAppName + ", notificationConfig=" + this.notificationConfig + ", logPrivacyLevel=" + this.logPrivacyLevel + ")";
        }

        public Android(@Nullable String str, @Nullable String str2, @Nullable NotificationConfig notificationConfig, @Nullable AirshipConfigOptions.PrivacyLevel privacyLevel) {
            this.appStoreUri = str;
            this.fcmFirebaseAppName = str2;
            this.notificationConfig = notificationConfig;
            this.logPrivacyLevel = privacyLevel;
        }

        @Nullable
        public final String getAppStoreUri() {
            return this.appStoreUri;
        }

        @Nullable
        public final String getFcmFirebaseAppName() {
            return this.fcmFirebaseAppName;
        }

        @Nullable
        public final NotificationConfig getNotificationConfig() {
            return this.notificationConfig;
        }

        @Nullable
        public final AirshipConfigOptions.PrivacyLevel getLogPrivacyLevel() {
            return this.logPrivacyLevel;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonMap.Builder builderPutOpt = JsonMap.newBuilder().putOpt("appStoreUri", this.appStoreUri).putOpt("fcmFirebaseAppName", this.fcmFirebaseAppName).putOpt("notificationConfig", this.notificationConfig);
            AirshipConfigOptions.PrivacyLevel privacyLevel = this.logPrivacyLevel;
            JsonValue jsonValue = builderPutOpt.putOpt("logPrivacyLevel", privacyLevel != null ? Utils.INSTANCE.logPrivacyLevelString(privacyLevel) : null).build().getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Android(@NotNull JsonMap config) throws JsonException {
            String string;
            JsonMap map;
            Intrinsics.checkNotNullParameter(config, "config");
            JsonValue jsonValue = config.get("appStoreUri");
            AirshipConfigOptions.PrivacyLevel logPrivacyLevel = null;
            String string2 = jsonValue != null ? jsonValue.getString() : null;
            JsonValue jsonValue2 = config.get("fcmFirebaseAppName");
            String string3 = jsonValue2 != null ? jsonValue2.getString() : null;
            JsonValue jsonValue3 = config.get("notificationConfig");
            NotificationConfig notificationConfig = (jsonValue3 == null || (map = jsonValue3.getMap()) == null) ? null : new NotificationConfig(map);
            JsonValue jsonValue4 = config.get("logPrivacyLevel");
            if (jsonValue4 != null && (string = jsonValue4.getString()) != null) {
                logPrivacyLevel = Utils.INSTANCE.parseLogPrivacyLevel(string);
            }
            this(string2, string3, notificationConfig, logPrivacyLevel);
        }
    }
}
