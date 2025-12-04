package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.N7;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class P7 {

    @NotNull
    public final CsApplicationModule a;

    @NotNull
    public final C0710j b;

    @NotNull
    public final Configuration c;

    @NotNull
    public final Logger d;

    public P7(@NotNull CsApplicationModule csApplicationModule, @NotNull C0710j analyticsPipeline, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(csApplicationModule, "csApplicationModule");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = csApplicationModule;
        this.b = analyticsPipeline;
        this.c = configuration;
        this.d = new Logger(null, 1, null);
    }

    public final void a(@Nullable String str) {
        Logger logger;
        String str2;
        boolean userIdentifier;
        JsonConfig.SessionReplay sessionReplay;
        JsonConfig.ProjectConfiguration projectConfig = this.c.getProjectConfig();
        String strJoinToString$default = null;
        Integer numValueOf = projectConfig != null ? Integer.valueOf(projectConfig.getCsProjectId()) : null;
        if (numValueOf == null || str == null) {
            this.d.e("Unable to send user identifier");
            return;
        }
        boolean z = false;
        if (this.a.getSdkManager().f) {
            JsonConfig.ProjectConfiguration projectConfig2 = this.c.getProjectConfig();
            if (projectConfig2 == null || (sessionReplay = projectConfig2.getSessionReplay()) == null) {
                this.d.e("Project configuration not ready. Assuming user identification collection is disabled.");
                userIdentifier = false;
            } else {
                userIdentifier = sessionReplay.getUserIdentifier();
            }
            if (userIdentifier) {
                z = true;
            }
        }
        if (!z) {
            logger = this.d;
            str2 = "User identifier collection is disabled for this project.";
        } else {
            if (str.length() <= 100) {
                int iIntValue = numValueOf.intValue();
                StringBuilder sb = new StringBuilder();
                String lowerCase = StringsKt.trim(str).toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                sb.append(lowerCase);
                sb.append(':');
                sb.append(iIntValue);
                String string = sb.toString();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    byte[] resultBytes = messageDigest.digest(bytes);
                    Intrinsics.checkNotNullExpressionValue(resultBytes, "resultBytes");
                    strJoinToString$default = ArraysKt.joinToString$default(resultBytes, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) O7.a, 30, (Object) null);
                } catch (NoSuchAlgorithmException e) {
                    Q2.a(this.d, "Unable to get Message Digest", e);
                }
                if (strJoinToString$default == null) {
                    return;
                }
                E1 eventsBuildersFactory = this.a.getEventsBuildersFactory();
                Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
                N7.a aVar = (N7.a) E1.a(eventsBuildersFactory, 22);
                Intrinsics.checkNotNullParameter(strJoinToString$default, "<set-?>");
                aVar.k = strJoinToString$default;
                this.b.a(aVar);
                return;
            }
            logger = this.d;
            str2 = "User Identifier is too long: the current input has a length of " + str.length() + " while the limit is 100.";
        }
        logger.e(str2);
    }
}
