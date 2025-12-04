package com.urbanairship.messagecenter;

import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.preferencecenter.PreferenceCenter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0002'(B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eJ\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0002\b J\u0015\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eJ\u0017\u0010%\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\b&R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/urbanairship/messagecenter/User;", "", PreferenceCenter.DEEP_LINK_HOST, "Lcom/urbanairship/PreferenceDataStore;", "(Lcom/urbanairship/PreferenceDataStore;)V", "id", "", "getId", "()Ljava/lang/String;", "isUserCreated", "", "()Z", "listeners", "", "Lcom/urbanairship/messagecenter/User$Listener;", HintConstants.AUTOFILL_HINT_PASSWORD, "getPassword", "channelId", "registeredChannelId", "getRegisteredChannelId$urbanairship_message_center_release", "setRegisteredChannelId$urbanairship_message_center_release", "(Ljava/lang/String;)V", "userCredentials", "Lcom/urbanairship/messagecenter/UserCredentials;", "getUserCredentials$urbanairship_message_center_release", "()Lcom/urbanairship/messagecenter/UserCredentials;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreated", "onCreated$urbanairship_message_center_release", "onUpdated", "onUpdated$urbanairship_message_center_release", "onUserUpdated", "success", "onUserUpdated$urbanairship_message_center_release", "removeListener", "setUser", "setUser$urbanairship_message_center_release", "Companion", "Listener", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class User {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List listeners;
    private final PreferenceDataStore preferences;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/messagecenter/User$Listener;", "", "onUserUpdated", "", "success", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onUserUpdated(boolean success);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isCreated() {
        return INSTANCE.isCreated();
    }

    public User(@NotNull PreferenceDataStore preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.preferences = preferences;
        String string = preferences.getString("com.urbanairship.user.PASSWORD", null);
        if (string != null && string.length() != 0 && preferences.putSync("com.urbanairship.user.USER_TOKEN", INSTANCE.encode(string, preferences.getString("com.urbanairship.user.ID", null)))) {
            preferences.remove("com.urbanairship.user.PASSWORD");
        }
        this.listeners = new CopyOnWriteArrayList();
    }

    public final void addListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void onUserUpdated$urbanairship_message_center_release(boolean success) {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onUserUpdated(success);
        }
    }

    public final void onUpdated$urbanairship_message_center_release(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (Intrinsics.areEqual(channelId, getRegisteredChannelId$urbanairship_message_center_release())) {
            return;
        }
        this.preferences.put("com.urbanairship.user.REGISTERED_CHANNEL_ID", channelId);
    }

    public final void onCreated$urbanairship_message_center_release(@NotNull UserCredentials userCredentials, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(userCredentials, "userCredentials");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        setRegisteredChannelId$urbanairship_message_center_release(channelId);
        setUser$urbanairship_message_center_release(userCredentials);
    }

    public final boolean isUserCreated() {
        String password;
        String id = getId();
        return (id == null || id.length() == 0 || (password = getPassword()) == null || password.length() == 0) ? false : true;
    }

    public final void setUser$urbanairship_message_center_release(@Nullable UserCredentials userCredentials) {
        UALog.d("Setting Rich Push user: %s", userCredentials);
        this.preferences.put("com.urbanairship.user.ID", userCredentials != null ? userCredentials.getUsername() : null);
        this.preferences.put("com.urbanairship.user.USER_TOKEN", INSTANCE.encode(userCredentials != null ? userCredentials.getPassword() : null, userCredentials != null ? userCredentials.getUsername() : null));
    }

    @Nullable
    public final UserCredentials getUserCredentials$urbanairship_message_center_release() {
        String password;
        String id = getId();
        if (id == null || (password = getPassword()) == null) {
            return null;
        }
        return new UserCredentials(id, password);
    }

    @Nullable
    public final String getId() {
        if (this.preferences.getString("com.urbanairship.user.USER_TOKEN", null) != null) {
            return this.preferences.getString("com.urbanairship.user.ID", null);
        }
        return null;
    }

    @Nullable
    public final String getPassword() {
        if (this.preferences.getString("com.urbanairship.user.ID", null) != null) {
            return INSTANCE.decode(this.preferences.getString("com.urbanairship.user.USER_TOKEN", null), getId());
        }
        return null;
    }

    @NotNull
    public final String getRegisteredChannelId$urbanairship_message_center_release() {
        String string = this.preferences.getString("com.urbanairship.user.REGISTERED_CHANNEL_ID", "");
        return string == null ? "" : string;
    }

    public final void setRegisteredChannelId$urbanairship_message_center_release(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.preferences.put("com.urbanairship.user.REGISTERED_CHANNEL_ID", channelId);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/messagecenter/User$Companion;", "", "()V", "KEY_PREFIX", "", "USER_ID_KEY", "USER_PASSWORD_KEY", "USER_REGISTERED_CHANNEL_ID_KEY", "USER_TOKEN_KEY", "isCreated", "", "isCreated$annotations", "()Z", "decode", "encodedString", "key", "encode", "input", "xor", "", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isCreated$annotations() {
        }

        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isCreated() {
            return MessageCenter.INSTANCE.shared().getUser().isUserCreated();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String encode(String input, String key) {
            if (input == null || input.length() == 0 || key == null || key.length() == 0) {
                return null;
            }
            Charset charset = Charsets.UTF_8;
            byte[] bytes = input.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = key.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] bArrXor = xor(bytes, bytes2);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrXor) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String decode(String encodedString, String key) {
            if (encodedString != null && encodedString.length() != 0 && key != null && key.length() != 0) {
                int length = encodedString.length();
                if (length % 2 != 0) {
                    return null;
                }
                try {
                    byte[] bArr = new byte[length / 2];
                    int i = 0;
                    while (i < length) {
                        int i2 = i / 2;
                        int i3 = i + 2;
                        String strSubstring = encodedString.substring(i, i3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        bArr[i2] = Byte.parseByte(strSubstring, CharsKt.checkRadix(16));
                        i = i3;
                    }
                    byte[] bytes = key.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    byte[] bArrXor = xor(bArr, bytes);
                    Charset charsetForName = Charset.forName("UTF-8");
                    Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                    return new String(bArrXor, charsetForName);
                } catch (UnsupportedEncodingException e) {
                    UALog.e(e, "RichPushUser - Unable to decode string.", new Object[0]);
                } catch (NumberFormatException e2) {
                    UALog.e(e2, "RichPushUser - String contains invalid hex numbers.", new Object[0]);
                }
            }
            return null;
        }

        private final byte[] xor(byte[] a, byte[] b) {
            byte[] bArr = new byte[a.length];
            int length = a.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) (a[i] ^ b[i % b.length]);
            }
            return bArr;
        }
    }
}
