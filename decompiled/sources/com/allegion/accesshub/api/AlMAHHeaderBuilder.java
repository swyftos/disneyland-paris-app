package com.allegion.accesshub.api;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.allegion.accesshub.enums.Header;
import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.interfaces.IAlConfig;
import com.allegion.alsecurity.AlEcc;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.urbanairship.actions.RateAppAction;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Request;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.picocontainer.Characteristics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/allegion/accesshub/api/AlMAHHeaderBuilder;", "", "Lokhttp3/Request$Builder;", "builder", "Lcom/allegion/accesshub/interfaces/IAlConfig;", "config", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "(Lokhttp3/Request$Builder;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "", "Lcom/allegion/accesshub/enums/Header;", "headers", "", RateAppAction.BODY_KEY, "headerBuilder", "(Lokhttp3/Request$Builder;[Lcom/allegion/accesshub/enums/Header;Ljava/lang/String;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "<init>", "()V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlMAHHeaderBuilder {
    public static final AlMAHHeaderBuilder INSTANCE = new AlMAHHeaderBuilder();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Header.values();
            $EnumSwitchMapping$0 = new int[]{1, 2, 3, 4, 5};
        }
    }

    private AlMAHHeaderBuilder() {
    }

    private final void a(Request.Builder builder, IAlConfig config) {
        String value = Header.SUBSCRIPTION_KEY.getValue();
        String string = config.getSubscriptionKey().toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "config.subscriptionKey.toString()");
        builder.addHeader(value, StringsKt.replace$default(string, "-", "", false, 4, (Object) null));
    }

    public final void headerBuilder(@NotNull Request.Builder builder, @NotNull Header[] headers, @Nullable String body, @NotNull IAlConfig config) throws AlMAHException {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Objects.requireNonNull(headers, "Headers are null");
        for (Header header : headers) {
            int iOrdinal = header.ordinal();
            if (iOrdinal == 0) {
                builder.addHeader(Header.CONTENT_TYPE_JSON.getValue(), "application/json");
            } else if (iOrdinal == 1) {
                a(builder, config);
            } else if (iOrdinal == 2) {
                Objects.requireNonNull(body, "Body is null and required for device signature header");
                Intrinsics.checkExpressionValueIsNotNull(body, "Objects.requireNonNull<S…er\"\n                    )");
                AlEcc alEcc = new AlEcc();
                try {
                    PrivateKey privateKey = config.getKeyManagement().getKeyPair(config.getDeviceKeyReference()).getPrivate();
                    Intrinsics.checkExpressionValueIsNotNull(privateKey, "config.keyManagement.get…viceKeyReference).private");
                    byte[] bytes = body.getBytes(Charsets.UTF_8);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    builder.addHeader(Header.DEVICE_SIG.getValue(), Hex.toHexString(alEcc.sign(privateKey, bytes)));
                } catch (AlSecurityException e) {
                    throw new AlMAHException("Exception thrown getting device keys", e);
                }
            } else if (iOrdinal == 3) {
                String string = config.getDeviceId().toString();
                Intrinsics.checkExpressionValueIsNotNull(string, "config.deviceId.toString()");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ss.SSS'Z'");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String str = string + "_" + simpleDateFormat.format(Long.valueOf(new Date().getTime() + 3600000));
                AlEcc alEcc2 = new AlEcc();
                try {
                    PrivateKey privateKey2 = config.getKeyManagement().getKeyPair(config.getDeviceKeyReference()).getPrivate();
                    Intrinsics.checkExpressionValueIsNotNull(privateKey2, "config.keyManagement.get…viceKeyReference).private");
                    Charset charset = Charsets.UTF_8;
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    byte[] bytes2 = str.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                    String str2 = str + ":" + Hex.toHexString(alEcc2.sign(privateKey2, bytes2));
                    StringBuilder sb = new StringBuilder();
                    sb.append("Maa ");
                    if (str2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    byte[] bytes3 = str2.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes3, "(this as java.lang.String).getBytes(charset)");
                    sb.append(Base64.toBase64String(bytes3));
                    builder.addHeader(Header.AUTH.getValue(), sb.toString());
                } catch (AlSecurityException e2) {
                    throw new AlMAHException("Exception thrown getting device keys", e2);
                }
            } else if (iOrdinal == 4) {
                builder.addHeader(Header.AUTOMATED_TEST.getValue(), Characteristics.TRUE);
            }
        }
    }
}
