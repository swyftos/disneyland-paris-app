package com.disney.id.android;

import com.disney.id.android.OneID;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.logging.OneIDLogger;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.net.URL;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR+\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u001b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/disney/id/android/Config;", "", "environment", "Lcom/disney/id/android/OneID$Environment;", "clientId", "", TCEventPropertiesNames.TCD_LANGUAGE, "cssOverrideUrl", "Ljava/net/URL;", "logLevel", "Lcom/disney/id/android/OneID$LogLevel;", "(Lcom/disney/id/android/OneID$Environment;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;Lcom/disney/id/android/OneID$LogLevel;)V", "getClientId", "()Ljava/lang/String;", "getCssOverrideUrl", "()Ljava/net/URL;", "getEnvironment", "()Lcom/disney/id/android/OneID$Environment;", "getLanguage", "<set-?>", "getLogLevel", "()Lcom/disney/id/android/OneID$LogLevel;", "setLogLevel", "(Lcom/disney/id/android/OneID$LogLevel;)V", "logLevel$delegate", "Lkotlin/properties/ReadWriteProperty;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "validateLanguageFormat", "", "languagePreference", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Config.kt\ncom/disney/id/android/Config\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n*L\n1#1,76:1\n33#2,3:77\n*S KotlinDebug\n*F\n+ 1 Config.kt\ncom/disney/id/android/Config\n*L\n43#1:77,3\n*E\n"})
/* loaded from: classes3.dex */
public final class Config {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Config.class, "logLevel", "getLogLevel()Lcom/disney/id/android/OneID$LogLevel;", 0))};

    @NotNull
    public static final String LANGUAGE_DEFAULT = "en-US";

    @NotNull
    public static final String VALID_LANGUAGE_PATTERN = "^[a-z]{2}-[A-Z]{2}$";
    private final String clientId;
    private final URL cssOverrideUrl;
    private final OneID.Environment environment;
    private final String language;

    /* renamed from: logLevel$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty logLevel;

    @Inject
    public Logger logger;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Config(@NotNull OneID.Environment environment, @NotNull String clientId) {
        this(environment, clientId, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Config(@NotNull OneID.Environment environment, @NotNull String clientId, @NotNull String language) {
        this(environment, clientId, language, null, null, 24, null);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(language, "language");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Config(@NotNull OneID.Environment environment, @NotNull String clientId, @NotNull String language, @Nullable URL url) {
        this(environment, clientId, language, url, null, 16, null);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(language, "language");
    }

    @JvmOverloads
    public Config(@NotNull OneID.Environment environment, @NotNull String clientId, @NotNull String language, @Nullable URL url, @NotNull final OneID.LogLevel logLevel) throws EmptyStringArgument, InvalidLanguageFormat {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Delegates delegates = Delegates.INSTANCE;
        this.logLevel = new ObservableProperty<OneID.LogLevel>(logLevel) { // from class: com.disney.id.android.Config$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, OneID.LogLevel oldValue, OneID.LogLevel newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                this.getLogger$OneID_release().setLogLevel(newValue);
            }
        };
        OneIDDagger.getComponent().inject(this);
        if (StringsKt.isBlank(clientId)) {
            throw new EmptyStringArgument("The clientId is blank or empty");
        }
        if (!validateLanguageFormat(language)) {
            throw new InvalidLanguageFormat("The language passed in is invalid.");
        }
        this.environment = environment;
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = clientId.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this.clientId = upperCase;
        this.language = language;
        this.cssOverrideUrl = url;
        setLogLevel(logLevel);
    }

    public /* synthetic */ Config(OneID.Environment environment, String str, String str2, URL url, OneID.LogLevel logLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(environment, str, (i & 4) != 0 ? LANGUAGE_DEFAULT : str2, (i & 8) != 0 ? null : url, (i & 16) != 0 ? OneIDLogger.INSTANCE.getDEFAULT_LOG_LEVEL() : logLevel);
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final OneID.Environment getEnvironment() {
        return this.environment;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final URL getCssOverrideUrl() {
        return this.cssOverrideUrl;
    }

    @NotNull
    public final OneID.LogLevel getLogLevel() {
        return (OneID.LogLevel) this.logLevel.getValue(this, $$delegatedProperties[0]);
    }

    public final void setLogLevel(@NotNull OneID.LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
        this.logLevel.setValue(this, $$delegatedProperties[0], logLevel);
    }

    private final boolean validateLanguageFormat(String languagePreference) {
        return new Regex(VALID_LANGUAGE_PATTERN).matches(languagePreference);
    }
}
