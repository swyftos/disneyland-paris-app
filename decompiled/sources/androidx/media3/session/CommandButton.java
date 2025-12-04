package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* loaded from: classes.dex */
public final class CommandButton {

    @UnstableApi
    public static final int ICON_ALBUM = 57369;

    @UnstableApi
    public static final int ICON_ARTIST = 57370;

    @UnstableApi
    public static final int ICON_BLOCK = 57675;

    @UnstableApi
    public static final int ICON_BOOKMARK_FILLED = 1042534;

    @UnstableApi
    public static final int ICON_BOOKMARK_UNFILLED = 59494;

    @UnstableApi
    public static final int ICON_CHECK_CIRCLE_FILLED = 1042540;

    @UnstableApi
    public static final int ICON_CHECK_CIRCLE_UNFILLED = 59500;

    @UnstableApi
    public static final int ICON_CLOSED_CAPTIONS = 57372;

    @UnstableApi
    public static final int ICON_CLOSED_CAPTIONS_OFF = 61916;

    @UnstableApi
    public static final int ICON_FAST_FORWARD = 57375;

    @UnstableApi
    public static final int ICON_FEED = 57573;

    @UnstableApi
    public static final int ICON_FLAG_FILLED = 1040723;

    @UnstableApi
    public static final int ICON_FLAG_UNFILLED = 57683;

    @UnstableApi
    public static final int ICON_HEART_FILLED = 1042557;

    @UnstableApi
    public static final int ICON_HEART_UNFILLED = 59517;

    @UnstableApi
    public static final int ICON_MINUS = 57691;

    @UnstableApi
    public static final int ICON_MINUS_CIRCLE_FILLED = 1040712;

    @UnstableApi
    public static final int ICON_MINUS_CIRCLE_UNFILLED = 1040713;

    @UnstableApi
    public static final int ICON_NEXT = 57412;

    @UnstableApi
    public static final int ICON_PAUSE = 57396;

    @UnstableApi
    public static final int ICON_PLAY = 57399;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED = 57448;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_0_5 = 62690;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_0_8 = 1045730;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_1_0 = 61389;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_1_2 = 62689;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_1_5 = 62688;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_1_8 = 1045728;

    @UnstableApi
    public static final int ICON_PLAYBACK_SPEED_2_0 = 62699;

    @UnstableApi
    public static final int ICON_PLAYLIST_ADD = 57403;

    @UnstableApi
    public static final int ICON_PLAYLIST_REMOVE = 60288;

    @UnstableApi
    public static final int ICON_PLUS = 57669;

    @UnstableApi
    public static final int ICON_PLUS_CIRCLE_FILLED = 1040711;

    @UnstableApi
    public static final int ICON_PLUS_CIRCLE_UNFILLED = 57671;

    @UnstableApi
    public static final int ICON_PREVIOUS = 57413;

    @UnstableApi
    public static final int ICON_QUALITY = 58409;

    @UnstableApi
    public static final int ICON_QUEUE_ADD = 57436;

    @UnstableApi
    public static final int ICON_QUEUE_NEXT = 57446;

    @UnstableApi
    public static final int ICON_QUEUE_REMOVE = 57447;

    @UnstableApi
    public static final int ICON_RADIO = 58654;

    @UnstableApi
    public static final int ICON_REPEAT_ALL = 57408;

    @UnstableApi
    public static final int ICON_REPEAT_OFF = 1040448;

    @UnstableApi
    public static final int ICON_REPEAT_ONE = 57409;

    @UnstableApi
    public static final int ICON_REWIND = 57376;

    @UnstableApi
    public static final int ICON_SETTINGS = 59576;

    @UnstableApi
    public static final int ICON_SHARE = 59405;

    @UnstableApi
    public static final int ICON_SHUFFLE_OFF = 1040452;

    @UnstableApi
    public static final int ICON_SHUFFLE_ON = 57411;

    @UnstableApi
    public static final int ICON_SHUFFLE_STAR = 1040451;

    @UnstableApi
    public static final int ICON_SIGNAL = 61512;

    @UnstableApi
    public static final int ICON_SKIP_BACK = 57410;

    @UnstableApi
    public static final int ICON_SKIP_BACK_10 = 57433;

    @UnstableApi
    public static final int ICON_SKIP_BACK_15 = 1040473;

    @UnstableApi
    public static final int ICON_SKIP_BACK_30 = 57434;

    @UnstableApi
    public static final int ICON_SKIP_BACK_5 = 57435;

    @UnstableApi
    public static final int ICON_SKIP_FORWARD = 63220;

    @UnstableApi
    public static final int ICON_SKIP_FORWARD_10 = 57430;

    @UnstableApi
    public static final int ICON_SKIP_FORWARD_15 = 1040470;

    @UnstableApi
    public static final int ICON_SKIP_FORWARD_30 = 57431;

    @UnstableApi
    public static final int ICON_SKIP_FORWARD_5 = 57432;

    @UnstableApi
    public static final int ICON_STAR_FILLED = 1042488;

    @UnstableApi
    public static final int ICON_STAR_UNFILLED = 59448;

    @UnstableApi
    public static final int ICON_STOP = 57415;

    @UnstableApi
    public static final int ICON_SUBTITLES = 57416;

    @UnstableApi
    public static final int ICON_SUBTITLES_OFF = 61298;

    @UnstableApi
    public static final int ICON_SYNC = 58919;

    @UnstableApi
    public static final int ICON_THUMB_DOWN_FILLED = 1042651;

    @UnstableApi
    public static final int ICON_THUMB_DOWN_UNFILLED = 59611;

    @UnstableApi
    public static final int ICON_THUMB_UP_FILLED = 1042652;

    @UnstableApi
    public static final int ICON_THUMB_UP_UNFILLED = 59612;

    @UnstableApi
    public static final int ICON_UNDEFINED = 0;

    @UnstableApi
    public static final int ICON_VOLUME_DOWN = 57421;

    @UnstableApi
    public static final int ICON_VOLUME_OFF = 57423;

    @UnstableApi
    public static final int ICON_VOLUME_UP = 57424;
    public final CharSequence displayName;

    @UnstableApi
    public final Bundle extras;

    @UnstableApi
    public final int icon;

    @DrawableRes
    public final int iconResId;

    @Nullable
    @UnstableApi
    public final Uri iconUri;
    public final boolean isEnabled;
    public final int playerCommand;

    @Nullable
    public final SessionCommand sessionCommand;
    private static final String FIELD_SESSION_COMMAND = Util.intToStringMaxRadix(0);
    private static final String FIELD_PLAYER_COMMAND = Util.intToStringMaxRadix(1);
    private static final String FIELD_ICON_RES_ID = Util.intToStringMaxRadix(2);
    private static final String FIELD_DISPLAY_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(4);
    private static final String FIELD_ENABLED = Util.intToStringMaxRadix(5);
    private static final String FIELD_ICON_URI = Util.intToStringMaxRadix(6);
    private static final String FIELD_ICON = Util.intToStringMaxRadix(7);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface Icon {
    }

    public static final class Builder {
        private CharSequence displayName;
        private boolean enabled;
        private Bundle extras;
        private int icon;
        private int iconResId;
        private Uri iconUri;
        private int playerCommand;
        private SessionCommand sessionCommand;

        public Builder() {
            this(0);
        }

        @UnstableApi
        public Builder(int i) {
            this(i, CommandButton.getIconResIdForIconConstant(i));
        }

        Builder(int i, int i2) {
            this.icon = i;
            this.iconResId = i2;
            this.displayName = "";
            this.extras = Bundle.EMPTY;
            this.playerCommand = -1;
            this.enabled = true;
        }

        @CanIgnoreReturnValue
        public Builder setSessionCommand(SessionCommand sessionCommand) {
            Assertions.checkNotNull(sessionCommand, "sessionCommand should not be null.");
            Assertions.checkArgument(this.playerCommand == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.sessionCommand = sessionCommand;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayerCommand(int i) {
            Assertions.checkArgument(this.sessionCommand == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.playerCommand = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIconResId(@DrawableRes int i) {
            return setCustomIconResId(i);
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setCustomIconResId(@DrawableRes int i) {
            this.iconResId = i;
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDisplayName(CharSequence charSequence) {
            this.displayName = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEnabled(boolean z) {
            this.enabled = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setExtras(Bundle bundle) {
            this.extras = new Bundle(bundle);
            return this;
        }

        public CommandButton build() {
            Assertions.checkState((this.sessionCommand == null) != (this.playerCommand == -1), "Exactly one of sessionCommand and playerCommand should be set");
            return new CommandButton(this.sessionCommand, this.playerCommand, this.icon, this.iconResId, this.iconUri, this.displayName, this.extras, this.enabled);
        }
    }

    private CommandButton(SessionCommand sessionCommand, int i, int i2, int i3, Uri uri, CharSequence charSequence, Bundle bundle, boolean z) {
        this.sessionCommand = sessionCommand;
        this.playerCommand = i;
        this.icon = i2;
        this.iconResId = i3;
        this.iconUri = uri;
        this.displayName = charSequence;
        this.extras = new Bundle(bundle);
        this.isEnabled = z;
    }

    CommandButton copyWithIsEnabled(boolean z) {
        return this.isEnabled == z ? this : new CommandButton(this.sessionCommand, this.playerCommand, this.icon, this.iconResId, this.iconUri, this.displayName, new Bundle(this.extras), z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandButton)) {
            return false;
        }
        CommandButton commandButton = (CommandButton) obj;
        return Objects.equal(this.sessionCommand, commandButton.sessionCommand) && this.playerCommand == commandButton.playerCommand && this.icon == commandButton.icon && this.iconResId == commandButton.iconResId && Objects.equal(this.iconUri, commandButton.iconUri) && TextUtils.equals(this.displayName, commandButton.displayName) && this.isEnabled == commandButton.isEnabled;
    }

    public int hashCode() {
        return Objects.hashCode(this.sessionCommand, Integer.valueOf(this.playerCommand), Integer.valueOf(this.icon), Integer.valueOf(this.iconResId), this.displayName, Boolean.valueOf(this.isEnabled), this.iconUri);
    }

    static ImmutableList copyWithUnavailableButtonsDisabled(List list, SessionCommands sessionCommands, Player.Commands commands) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            CommandButton commandButton = (CommandButton) list.get(i);
            if (isButtonCommandAvailable(commandButton, sessionCommands, commands)) {
                builder.add((ImmutableList.Builder) commandButton);
            } else {
                builder.add((ImmutableList.Builder) commandButton.copyWithIsEnabled(false));
            }
        }
        return builder.build();
    }

    static boolean isButtonCommandAvailable(CommandButton commandButton, SessionCommands sessionCommands, Player.Commands commands) {
        int i;
        SessionCommand sessionCommand = commandButton.sessionCommand;
        return (sessionCommand != null && sessionCommands.contains(sessionCommand)) || ((i = commandButton.playerCommand) != -1 && commands.contains(i));
    }

    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            bundle.putBundle(FIELD_SESSION_COMMAND, sessionCommand.toBundle());
        }
        int i = this.playerCommand;
        if (i != -1) {
            bundle.putInt(FIELD_PLAYER_COMMAND, i);
        }
        int i2 = this.icon;
        if (i2 != 0) {
            bundle.putInt(FIELD_ICON, i2);
        }
        int i3 = this.iconResId;
        if (i3 != 0) {
            bundle.putInt(FIELD_ICON_RES_ID, i3);
        }
        CharSequence charSequence = this.displayName;
        if (charSequence != "") {
            bundle.putCharSequence(FIELD_DISPLAY_NAME, charSequence);
        }
        if (!this.extras.isEmpty()) {
            bundle.putBundle(FIELD_EXTRAS, this.extras);
        }
        Uri uri = this.iconUri;
        if (uri != null) {
            bundle.putParcelable(FIELD_ICON_URI, uri);
        }
        boolean z = this.isEnabled;
        if (!z) {
            bundle.putBoolean(FIELD_ENABLED, z);
        }
        return bundle;
    }

    @UnstableApi
    @Deprecated
    public static CommandButton fromBundle(Bundle bundle) {
        return fromBundle(bundle, 4);
    }

    @UnstableApi
    public static CommandButton fromBundle(Bundle bundle, int i) {
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMAND);
        SessionCommand sessionCommandFromBundle = bundle2 == null ? null : SessionCommand.fromBundle(bundle2);
        int i2 = bundle.getInt(FIELD_PLAYER_COMMAND, -1);
        int i3 = bundle.getInt(FIELD_ICON_RES_ID, 0);
        CharSequence charSequence = bundle.getCharSequence(FIELD_DISPLAY_NAME, "");
        Bundle bundle3 = bundle.getBundle(FIELD_EXTRAS);
        boolean z = true;
        if (i >= 3 && !bundle.getBoolean(FIELD_ENABLED, true)) {
            z = false;
        }
        Uri uri = (Uri) bundle.getParcelable(FIELD_ICON_URI);
        Builder builder = new Builder(bundle.getInt(FIELD_ICON, 0), i3);
        if (sessionCommandFromBundle != null) {
            builder.setSessionCommand(sessionCommandFromBundle);
        }
        if (i2 != -1) {
            builder.setPlayerCommand(i2);
        }
        if (uri != null) {
            builder.setIconUri(uri);
        }
        Builder displayName = builder.setDisplayName(charSequence);
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        return displayName.setExtras(bundle3).setEnabled(z).build();
    }

    @DrawableRes
    @UnstableApi
    public static int getIconResIdForIconConstant(int i) {
        switch (i) {
            case ICON_ALBUM /* 57369 */:
                return R.drawable.media3_icon_album;
            case ICON_ARTIST /* 57370 */:
                return R.drawable.media3_icon_artist;
            case ICON_CLOSED_CAPTIONS /* 57372 */:
                return R.drawable.media3_icon_closed_captions;
            case ICON_FAST_FORWARD /* 57375 */:
                return R.drawable.media3_icon_fast_forward;
            case ICON_REWIND /* 57376 */:
                return R.drawable.media3_icon_rewind;
            case ICON_PAUSE /* 57396 */:
                return R.drawable.media3_icon_pause;
            case ICON_PLAY /* 57399 */:
                return R.drawable.media3_icon_play;
            case ICON_PLAYLIST_ADD /* 57403 */:
                return R.drawable.media3_icon_playlist_add;
            case ICON_REPEAT_ALL /* 57408 */:
                return R.drawable.media3_icon_repeat_all;
            case ICON_REPEAT_ONE /* 57409 */:
                return R.drawable.media3_icon_repeat_one;
            case ICON_SKIP_BACK /* 57410 */:
                return R.drawable.media3_icon_skip_back;
            case ICON_SHUFFLE_ON /* 57411 */:
                return R.drawable.media3_icon_shuffle_on;
            case ICON_NEXT /* 57412 */:
                return R.drawable.media3_icon_next;
            case ICON_PREVIOUS /* 57413 */:
                return R.drawable.media3_icon_previous;
            case ICON_STOP /* 57415 */:
                return R.drawable.media3_icon_stop;
            case ICON_SUBTITLES /* 57416 */:
                return R.drawable.media3_icon_subtitles;
            case ICON_VOLUME_DOWN /* 57421 */:
                return R.drawable.media3_icon_volume_down;
            case ICON_VOLUME_OFF /* 57423 */:
                return R.drawable.media3_icon_volume_off;
            case ICON_VOLUME_UP /* 57424 */:
                return R.drawable.media3_icon_volume_up;
            case ICON_SKIP_FORWARD_10 /* 57430 */:
                return R.drawable.media3_icon_skip_forward_10;
            case ICON_SKIP_FORWARD_30 /* 57431 */:
                return R.drawable.media3_icon_skip_forward_30;
            case ICON_SKIP_FORWARD_5 /* 57432 */:
                return R.drawable.media3_icon_skip_forward_5;
            case ICON_SKIP_BACK_10 /* 57433 */:
                return R.drawable.media3_icon_skip_back_10;
            case ICON_SKIP_BACK_30 /* 57434 */:
                return R.drawable.media3_icon_skip_back_30;
            case ICON_SKIP_BACK_5 /* 57435 */:
                return R.drawable.media3_icon_skip_back_5;
            case ICON_QUEUE_ADD /* 57436 */:
                return R.drawable.media3_icon_queue_add;
            case ICON_QUEUE_NEXT /* 57446 */:
                return R.drawable.media3_icon_queue_next;
            case ICON_QUEUE_REMOVE /* 57447 */:
                return R.drawable.media3_icon_queue_remove;
            case ICON_PLAYBACK_SPEED /* 57448 */:
                return R.drawable.media3_icon_playback_speed;
            case ICON_FEED /* 57573 */:
                return R.drawable.media3_icon_feed;
            case ICON_PLUS /* 57669 */:
                return R.drawable.media3_icon_plus;
            case ICON_PLUS_CIRCLE_UNFILLED /* 57671 */:
                return R.drawable.media3_icon_plus_circle_unfilled;
            case ICON_BLOCK /* 57675 */:
                return R.drawable.media3_icon_block;
            case ICON_FLAG_UNFILLED /* 57683 */:
                return R.drawable.media3_icon_flag_unfilled;
            case ICON_MINUS /* 57691 */:
                return R.drawable.media3_icon_minus;
            case ICON_QUALITY /* 58409 */:
                return R.drawable.media3_icon_quality;
            case ICON_RADIO /* 58654 */:
                return R.drawable.media3_icon_radio;
            case ICON_SYNC /* 58919 */:
                return R.drawable.media3_icon_sync;
            case ICON_SHARE /* 59405 */:
                return R.drawable.media3_icon_share;
            case ICON_STAR_UNFILLED /* 59448 */:
                return R.drawable.media3_icon_star_unfilled;
            case ICON_BOOKMARK_UNFILLED /* 59494 */:
                return R.drawable.media3_icon_bookmark_unfilled;
            case ICON_CHECK_CIRCLE_UNFILLED /* 59500 */:
                return R.drawable.media3_icon_check_circle_unfilled;
            case ICON_HEART_UNFILLED /* 59517 */:
                return R.drawable.media3_icon_heart_unfilled;
            case ICON_SETTINGS /* 59576 */:
                return R.drawable.media3_icon_settings;
            case ICON_THUMB_DOWN_UNFILLED /* 59611 */:
                return R.drawable.media3_icon_thumb_down_unfilled;
            case ICON_THUMB_UP_UNFILLED /* 59612 */:
                return R.drawable.media3_icon_thumb_up_unfilled;
            case ICON_PLAYLIST_REMOVE /* 60288 */:
                return R.drawable.media3_icon_playlist_remove;
            case ICON_SUBTITLES_OFF /* 61298 */:
                return R.drawable.media3_icon_subtitles_off;
            case ICON_PLAYBACK_SPEED_1_0 /* 61389 */:
                return R.drawable.media3_icon_playback_speed_1_0;
            case ICON_SIGNAL /* 61512 */:
                return R.drawable.media3_icon_signal;
            case ICON_CLOSED_CAPTIONS_OFF /* 61916 */:
                return R.drawable.media3_icon_closed_captions_off;
            case ICON_PLAYBACK_SPEED_1_5 /* 62688 */:
                return R.drawable.media3_icon_playback_speed_1_5;
            case ICON_PLAYBACK_SPEED_1_2 /* 62689 */:
                return R.drawable.media3_icon_playback_speed_1_2;
            case ICON_PLAYBACK_SPEED_0_5 /* 62690 */:
                return R.drawable.media3_icon_playback_speed_0_5;
            case ICON_PLAYBACK_SPEED_2_0 /* 62699 */:
                return R.drawable.media3_icon_playback_speed_2_0;
            case ICON_SKIP_FORWARD /* 63220 */:
                return R.drawable.media3_icon_skip_forward;
            case ICON_REPEAT_OFF /* 1040448 */:
                return R.drawable.media3_icon_repeat_off;
            case ICON_SHUFFLE_STAR /* 1040451 */:
                return R.drawable.media3_icon_shuffle_star;
            case ICON_SHUFFLE_OFF /* 1040452 */:
                return R.drawable.media3_icon_shuffle_off;
            case ICON_SKIP_FORWARD_15 /* 1040470 */:
                return R.drawable.media3_icon_skip_forward_15;
            case ICON_SKIP_BACK_15 /* 1040473 */:
                return R.drawable.media3_icon_skip_back_15;
            case ICON_PLUS_CIRCLE_FILLED /* 1040711 */:
                return R.drawable.media3_icon_plus_circle_filled;
            case ICON_MINUS_CIRCLE_FILLED /* 1040712 */:
                return R.drawable.media3_icon_minus_circle_filled;
            case ICON_MINUS_CIRCLE_UNFILLED /* 1040713 */:
                return R.drawable.media3_icon_minus_circle_unfilled;
            case ICON_FLAG_FILLED /* 1040723 */:
                return R.drawable.media3_icon_flag_filled;
            case ICON_STAR_FILLED /* 1042488 */:
                return R.drawable.media3_icon_star_filled;
            case ICON_BOOKMARK_FILLED /* 1042534 */:
                return R.drawable.media3_icon_bookmark_filled;
            case ICON_CHECK_CIRCLE_FILLED /* 1042540 */:
                return R.drawable.media3_icon_check_circle_filled;
            case ICON_HEART_FILLED /* 1042557 */:
                return R.drawable.media3_icon_heart_filled;
            case ICON_THUMB_DOWN_FILLED /* 1042651 */:
                return R.drawable.media3_icon_thumb_down_filled;
            case ICON_THUMB_UP_FILLED /* 1042652 */:
                return R.drawable.media3_icon_thumb_up_filled;
            case ICON_PLAYBACK_SPEED_1_8 /* 1045728 */:
                return R.drawable.media3_icon_playback_speed_1_8;
            case ICON_PLAYBACK_SPEED_0_8 /* 1045730 */:
                return R.drawable.media3_icon_playback_speed_0_8;
            default:
                return 0;
        }
    }
}
