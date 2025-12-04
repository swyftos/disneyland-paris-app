package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.HeartRating;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PercentageRating;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.StarRating;
import androidx.media3.common.ThumbRating;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.legacy.AudioAttributesCompat;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaControllerCompat;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.RatingCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
abstract class LegacyConversions {
    public static final MediaBrowserServiceCompat.BrowserRoot defaultBrowserRoot = new MediaBrowserServiceCompat.BrowserRoot(MediaLibraryService.SERVICE_INTERFACE, null);
    public static final ImmutableSet KNOWN_METADATA_COMPAT_KEYS = ImmutableSet.of("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", "android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT);

    private static int convertToFolderType(long j) {
        if (j == 0) {
            return 0;
        }
        if (j == 1) {
            return 1;
        }
        if (j == 2) {
            return 2;
        }
        if (j == 3) {
            return 3;
        }
        if (j == 4) {
            return 4;
        }
        if (j == 5) {
            return 5;
        }
        return j == 6 ? 6 : 0;
    }

    public static int convertToLegacyErrorCode(int i) {
        if (i == -110) {
            return 8;
        }
        if (i == -109) {
            return 11;
        }
        if (i == -6) {
            return 2;
        }
        if (i == -2) {
            return 1;
        }
        if (i == 1) {
            return 10;
        }
        switch (i) {
            case -107:
                return 9;
            case -106:
                return 7;
            case -105:
                return 6;
            case -104:
                return 5;
            case -103:
                return 4;
            case -102:
                return 3;
            default:
                return 0;
        }
    }

    public static int convertToPlaybackStateCompatShuffleMode(boolean z) {
        return z ? 1 : 0;
    }

    public static long convertToQueueItemId(int i) {
        if (i == -1) {
            return -1L;
        }
        return i;
    }

    private static int convertToSessionErrorCode(int i) {
        switch (i) {
            case 1:
                return -2;
            case 2:
                return -6;
            case 3:
                return -102;
            case 4:
                return -103;
            case 5:
                return -104;
            case 6:
                return -105;
            case 7:
                return -106;
            case 8:
                return -110;
            case 9:
                return -107;
            case 10:
                return 1;
            case 11:
                return -109;
            default:
                return -1;
        }
    }

    private static boolean hasAction(long j, long j2) {
        return (j & j2) != 0;
    }

    public static class ConversionException extends Exception {
        private ConversionException(String str) {
            super(str);
        }
    }

    public static PlaybackException convertToPlaybackException(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null || playbackStateCompat.getState() != 7) {
            return null;
        }
        CharSequence errorMessage = playbackStateCompat.getErrorMessage();
        Bundle extras = playbackStateCompat.getExtras();
        String string = errorMessage != null ? errorMessage.toString() : null;
        int iConvertToPlaybackExceptionErrorCode = convertToPlaybackExceptionErrorCode(playbackStateCompat.getErrorCode());
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        return new PlaybackException(string, null, iConvertToPlaybackExceptionErrorCode, extras);
    }

    public static SessionError convertToSessionError(PlaybackStateCompat playbackStateCompat, Context context) {
        if (playbackStateCompat == null) {
            return null;
        }
        return convertToSessionError(playbackStateCompat.getState(), playbackStateCompat.getErrorCode(), playbackStateCompat.getErrorMessage(), playbackStateCompat.getExtras(), context);
    }

    static SessionError convertToSessionError(int i, int i2, CharSequence charSequence, Bundle bundle, Context context) {
        String sessionErrorMessage;
        if (i == 7 || i2 == 0) {
            return null;
        }
        int iConvertToSessionErrorCode = convertToSessionErrorCode(i2);
        if (charSequence != null) {
            sessionErrorMessage = charSequence.toString();
        } else {
            sessionErrorMessage = getSessionErrorMessage(iConvertToSessionErrorCode, context);
        }
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        return new SessionError(iConvertToSessionErrorCode, sessionErrorMessage, bundle);
    }

    private static String getSessionErrorMessage(int i, Context context) {
        if (i == -100) {
            return context.getString(R.string.error_message_disconnected);
        }
        if (i == 1) {
            return context.getString(R.string.error_message_info_cancelled);
        }
        if (i == -6) {
            return context.getString(R.string.error_message_not_supported);
        }
        if (i == -5) {
            return context.getString(R.string.error_message_io);
        }
        if (i == -4) {
            return context.getString(R.string.error_message_permission_denied);
        }
        if (i == -3) {
            return context.getString(R.string.error_message_bad_value);
        }
        if (i == -2) {
            return context.getString(R.string.error_message_invalid_state);
        }
        switch (i) {
            case -110:
                return context.getString(R.string.error_message_content_already_playing);
            case -109:
                return context.getString(R.string.error_message_end_of_playlist);
            case -108:
                return context.getString(R.string.error_message_setup_required);
            case -107:
                return context.getString(R.string.error_message_skip_limit_reached);
            case -106:
                return context.getString(R.string.error_message_not_available_in_region);
            case -105:
                return context.getString(R.string.error_message_parental_control_restricted);
            case -104:
                return context.getString(R.string.error_message_concurrent_stream_limit);
            case -103:
                return context.getString(R.string.error_message_premium_account_required);
            case -102:
                return context.getString(R.string.error_message_authentication_expired);
            default:
                return context.getString(R.string.error_message_fallback);
        }
    }

    private static int convertToPlaybackExceptionErrorCode(int i) {
        int iConvertToSessionErrorCode = convertToSessionErrorCode(i);
        if (iConvertToSessionErrorCode == -5) {
            return 2000;
        }
        if (iConvertToSessionErrorCode != -1) {
            return iConvertToSessionErrorCode;
        }
        return 1000;
    }

    public static int convertToLegacyErrorCode(PlaybackException playbackException) {
        return convertToLegacyErrorCode(playbackException.errorCode);
    }

    public static MediaBrowserCompat.MediaItem convertToBrowserItem(MediaItem mediaItem, Bitmap bitmap) {
        MediaDescriptionCompat mediaDescriptionCompatConvertToMediaDescriptionCompat = convertToMediaDescriptionCompat(mediaItem, bitmap);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        Boolean bool = mediaMetadata.isBrowsable;
        int i = (bool == null || !bool.booleanValue()) ? 0 : 1;
        Boolean bool2 = mediaMetadata.isPlayable;
        if (bool2 != null && bool2.booleanValue()) {
            i |= 2;
        }
        return new MediaBrowserCompat.MediaItem(mediaDescriptionCompatConvertToMediaDescriptionCompat, i);
    }

    public static MediaItem convertToMediaItem(MediaBrowserCompat.MediaItem mediaItem) {
        return convertToMediaItem(mediaItem.getDescription(), mediaItem.isBrowsable(), mediaItem.isPlayable());
    }

    public static MediaItem convertToMediaItem(MediaSessionCompat.QueueItem queueItem) {
        return convertToMediaItem(queueItem.getDescription());
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Assertions.checkNotNull(mediaDescriptionCompat);
        return convertToMediaItem(mediaDescriptionCompat, false, true);
    }

    public static MediaItem convertToMediaItem(MediaMetadataCompat mediaMetadataCompat, int i) {
        return convertToMediaItem(mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID"), mediaMetadataCompat, i);
    }

    public static MediaItem convertToMediaItem(String str, MediaMetadataCompat mediaMetadataCompat, int i) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str != null) {
            builder.setMediaId(str);
        }
        String string = mediaMetadataCompat.getString("android.media.metadata.MEDIA_URI");
        if (string != null) {
            builder.setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(Uri.parse(string)).build());
        }
        builder.setMediaMetadata(convertToMediaMetadata(mediaMetadataCompat, i));
        return builder.build();
    }

    private static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat, boolean z, boolean z2) {
        String mediaId = mediaDescriptionCompat.getMediaId();
        MediaItem.Builder builder = new MediaItem.Builder();
        if (mediaId == null) {
            mediaId = "";
        }
        return builder.setMediaId(mediaId).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(mediaDescriptionCompat.getMediaUri()).build()).setMediaMetadata(convertToMediaMetadata(mediaDescriptionCompat, 0, z, z2)).build();
    }

    public static ImmutableList convertBrowserItemListToMediaItemList(List list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((ImmutableList.Builder) convertToMediaItem((MediaBrowserCompat.MediaItem) list.get(i)));
        }
        return builder.build();
    }

    public static List convertToMediaItemList(Timeline timeline) {
        ArrayList arrayList = new ArrayList();
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < timeline.getWindowCount(); i++) {
            arrayList.add(timeline.getWindow(i, window).mediaItem);
        }
        return arrayList;
    }

    public static MediaSessionCompat.QueueItem convertToQueueItem(MediaItem mediaItem, int i, Bitmap bitmap) {
        return new MediaSessionCompat.QueueItem(convertToMediaDescriptionCompat(mediaItem, bitmap), convertToQueueItemId(i));
    }

    public static Timeline.Window convertToWindow(MediaItem mediaItem, int i) {
        Timeline.Window window = new Timeline.Window();
        window.set(0, mediaItem, null, 0L, 0L, 0L, true, false, null, 0L, C.TIME_UNSET, i, i, 0L);
        return window;
    }

    public static Timeline.Period convertToPeriod(int i) {
        Timeline.Period period = new Timeline.Period();
        period.set(null, null, i, C.TIME_UNSET, 0L, AdPlaybackState.NONE, true);
        return period;
    }

    public static MediaMetadata convertToMediaMetadata(CharSequence charSequence) {
        if (charSequence == null) {
            return MediaMetadata.EMPTY;
        }
        return new MediaMetadata.Builder().setTitle(charSequence).build();
    }

    public static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        return convertToMediaMetadata(mediaDescriptionCompat, i, false, true);
    }

    private static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, int i, boolean z, boolean z2) {
        byte[] bArrConvertToByteArray;
        if (mediaDescriptionCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setSubtitle(mediaDescriptionCompat.getSubtitle()).setDescription(mediaDescriptionCompat.getDescription()).setArtworkUri(mediaDescriptionCompat.getIconUri()).setUserRating(convertToRating(RatingCompat.newUnratedRating(i)));
        Bitmap iconBitmap = mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null) {
            try {
                bArrConvertToByteArray = convertToByteArray(iconBitmap);
            } catch (IOException e) {
                Log.w("LegacyConversions", "Failed to convert iconBitmap to artworkData", e);
                bArrConvertToByteArray = null;
            }
            builder.setArtworkData(bArrConvertToByteArray, 3);
        }
        Bundle extras = mediaDescriptionCompat.getExtras();
        Bundle bundle = extras != null ? new Bundle(extras) : null;
        if (bundle != null && bundle.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(bundle.getLong("android.media.extra.BT_FOLDER_TYPE"))));
            bundle.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        builder.setIsBrowsable(Boolean.valueOf(z));
        if (bundle != null && bundle.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) bundle.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
            bundle.remove(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT);
        }
        if (bundle != null && bundle.containsKey("androidx.media3.mediadescriptioncompat.title")) {
            builder.setTitle(bundle.getCharSequence("androidx.media3.mediadescriptioncompat.title"));
            builder.setDisplayTitle(mediaDescriptionCompat.getTitle());
            bundle.remove("androidx.media3.mediadescriptioncompat.title");
        } else {
            builder.setTitle(mediaDescriptionCompat.getTitle());
        }
        if (bundle != null && !bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        builder.setIsPlayable(Boolean.valueOf(z2));
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MediaMetadata convertToMediaMetadata(MediaMetadataCompat mediaMetadataCompat, int i) {
        if (mediaMetadataCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        CharSequence text = mediaMetadataCompat.getText("android.media.metadata.TITLE");
        CharSequence text2 = mediaMetadataCompat.getText("android.media.metadata.DISPLAY_TITLE");
        MediaMetadata.Builder title = builder.setTitle(text != null ? text : text2);
        if (text == null) {
            text2 = null;
        }
        title.setDisplayTitle(text2).setSubtitle(mediaMetadataCompat.getText("android.media.metadata.DISPLAY_SUBTITLE")).setDescription(mediaMetadataCompat.getText("android.media.metadata.DISPLAY_DESCRIPTION")).setArtist(mediaMetadataCompat.getText("android.media.metadata.ARTIST")).setAlbumTitle(mediaMetadataCompat.getText("android.media.metadata.ALBUM")).setAlbumArtist(mediaMetadataCompat.getText("android.media.metadata.ALBUM_ARTIST")).setOverallRating(convertToRating(mediaMetadataCompat.getRating("android.media.metadata.RATING")));
        if (mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
            long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
            if (j >= 0) {
                builder.setDurationMs(Long.valueOf(j));
            }
        }
        Rating ratingConvertToRating = convertToRating(mediaMetadataCompat.getRating("android.media.metadata.USER_RATING"));
        if (ratingConvertToRating != null) {
            builder.setUserRating(ratingConvertToRating);
        } else {
            builder.setUserRating(convertToRating(RatingCompat.newUnratedRating(i)));
        }
        if (mediaMetadataCompat.containsKey("android.media.metadata.YEAR")) {
            builder.setRecordingYear(Integer.valueOf((int) mediaMetadataCompat.getLong("android.media.metadata.YEAR")));
        }
        String firstString = getFirstString(mediaMetadataCompat, "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI");
        if (firstString != null) {
            builder.setArtworkUri(Uri.parse(firstString));
        }
        Bitmap firstBitmap = getFirstBitmap(mediaMetadataCompat, "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART");
        if (firstBitmap != null) {
            try {
                builder.setArtworkData(convertToByteArray(firstBitmap), 3);
            } catch (IOException e) {
                Log.w("LegacyConversions", "Failed to convert artworkBitmap to artworkData", e);
            }
        }
        boolean zContainsKey = mediaMetadataCompat.containsKey("android.media.metadata.BT_FOLDER_TYPE");
        builder.setIsBrowsable(Boolean.valueOf(zContainsKey));
        if (zContainsKey) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(mediaMetadataCompat.getLong("android.media.metadata.BT_FOLDER_TYPE"))));
        }
        if (mediaMetadataCompat.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
        }
        builder.setIsPlayable(Boolean.TRUE);
        Bundle bundle = mediaMetadataCompat.getBundle();
        UnmodifiableIterator it = KNOWN_METADATA_COMPAT_KEYS.iterator();
        while (it.hasNext()) {
            bundle.remove((String) it.next());
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        return builder.build();
    }

    private static Bitmap getFirstBitmap(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getBitmap(str);
            }
        }
        return null;
    }

    private static String getFirstString(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getString(str);
            }
        }
        return null;
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata, String str, Uri uri, long j, Bitmap bitmap) {
        Long l;
        MediaMetadataCompat.Builder builderPutString = new MediaMetadataCompat.Builder().putString("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = mediaMetadata.title;
        if (charSequence != null) {
            builderPutString.putText("android.media.metadata.TITLE", charSequence);
        }
        CharSequence charSequence2 = mediaMetadata.displayTitle;
        if (charSequence2 != null) {
            builderPutString.putText("android.media.metadata.DISPLAY_TITLE", charSequence2);
        }
        CharSequence charSequence3 = mediaMetadata.subtitle;
        if (charSequence3 != null) {
            builderPutString.putText("android.media.metadata.DISPLAY_SUBTITLE", charSequence3);
        }
        CharSequence charSequence4 = mediaMetadata.description;
        if (charSequence4 != null) {
            builderPutString.putText("android.media.metadata.DISPLAY_DESCRIPTION", charSequence4);
        }
        CharSequence charSequence5 = mediaMetadata.artist;
        if (charSequence5 != null) {
            builderPutString.putText("android.media.metadata.ARTIST", charSequence5);
        }
        CharSequence charSequence6 = mediaMetadata.albumTitle;
        if (charSequence6 != null) {
            builderPutString.putText("android.media.metadata.ALBUM", charSequence6);
        }
        CharSequence charSequence7 = mediaMetadata.albumArtist;
        if (charSequence7 != null) {
            builderPutString.putText("android.media.metadata.ALBUM_ARTIST", charSequence7);
        }
        if (mediaMetadata.recordingYear != null) {
            builderPutString.putLong("android.media.metadata.YEAR", r0.intValue());
        }
        if (uri != null) {
            builderPutString.putString("android.media.metadata.MEDIA_URI", uri.toString());
        }
        Uri uri2 = mediaMetadata.artworkUri;
        if (uri2 != null) {
            builderPutString.putString("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            builderPutString.putString("android.media.metadata.ALBUM_ART_URI", mediaMetadata.artworkUri.toString());
        }
        if (bitmap != null) {
            builderPutString.putBitmap("android.media.metadata.DISPLAY_ICON", bitmap);
            builderPutString.putBitmap("android.media.metadata.ALBUM_ART", bitmap);
        }
        Integer num = mediaMetadata.folderType;
        if (num != null && num.intValue() != -1) {
            builderPutString.putLong("android.media.metadata.BT_FOLDER_TYPE", convertToExtraBtFolderType(mediaMetadata.folderType.intValue()));
        }
        if (j == C.TIME_UNSET && (l = mediaMetadata.durationMs) != null) {
            j = l.longValue();
        }
        if (j != C.TIME_UNSET) {
            builderPutString.putLong("android.media.metadata.DURATION", j);
        }
        RatingCompat ratingCompatConvertToRatingCompat = convertToRatingCompat(mediaMetadata.userRating);
        if (ratingCompatConvertToRatingCompat != null) {
            builderPutString.putRating("android.media.metadata.USER_RATING", ratingCompatConvertToRatingCompat);
        }
        RatingCompat ratingCompatConvertToRatingCompat2 = convertToRatingCompat(mediaMetadata.overallRating);
        if (ratingCompatConvertToRatingCompat2 != null) {
            builderPutString.putRating("android.media.metadata.RATING", ratingCompatConvertToRatingCompat2);
        }
        if (mediaMetadata.mediaType != null) {
            builderPutString.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, r5.intValue());
        }
        Bundle bundle = mediaMetadata.extras;
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = mediaMetadata.extras.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    builderPutString.putText(str2, (CharSequence) obj);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    builderPutString.putLong(str2, ((Number) obj).longValue());
                }
            }
        }
        return builderPutString.build();
    }

    public static MediaDescriptionCompat convertToMediaDescriptionCompat(MediaItem mediaItem, Bitmap bitmap) {
        CharSequence charSequence;
        CharSequence charSequence2;
        MediaDescriptionCompat.Builder mediaId = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.mediaId.equals("") ? null : mediaItem.mediaId);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (bitmap != null) {
            mediaId.setIconBitmap(bitmap);
        }
        Bundle bundle = mediaMetadata.extras;
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        Integer num = mediaMetadata.folderType;
        boolean z = (num == null || num.intValue() == -1) ? false : true;
        boolean z2 = mediaMetadata.mediaType != null;
        if (z || z2) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (z) {
                bundle.putLong("android.media.extra.BT_FOLDER_TYPE", convertToExtraBtFolderType(((Integer) Assertions.checkNotNull(mediaMetadata.folderType)).intValue()));
            }
            if (z2) {
                bundle.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, ((Integer) Assertions.checkNotNull(mediaMetadata.mediaType)).intValue());
            }
        }
        CharSequence charSequence3 = mediaMetadata.displayTitle;
        if (charSequence3 != null) {
            charSequence = mediaMetadata.subtitle;
            charSequence2 = mediaMetadata.description;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putCharSequence("androidx.media3.mediadescriptioncompat.title", mediaMetadata.title);
        } else {
            CharSequence[] charSequenceArr = new CharSequence[3];
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                String[] strArr = MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                CharSequence text = getText(strArr[i2], mediaMetadata);
                if (!TextUtils.isEmpty(text)) {
                    charSequenceArr[i] = text;
                    i++;
                }
                i2 = i3;
            }
            charSequence3 = charSequenceArr[0];
            charSequence = charSequenceArr[1];
            charSequence2 = charSequenceArr[2];
        }
        return mediaId.setTitle(charSequence3).setSubtitle(charSequence).setDescription(charSequence2).setIconUri(mediaMetadata.artworkUri).setMediaUri(mediaItem.requestMetadata.mediaUri).setExtras(bundle).build();
    }

    private static CharSequence getText(String str, MediaMetadata mediaMetadata) {
        str.hashCode();
        switch (str) {
            case "android.media.metadata.ARTIST":
                return mediaMetadata.artist;
            case "android.media.metadata.WRITER":
                return mediaMetadata.writer;
            case "android.media.metadata.COMPOSER":
                return mediaMetadata.composer;
            case "android.media.metadata.ALBUM":
                return mediaMetadata.albumTitle;
            case "android.media.metadata.TITLE":
                return mediaMetadata.title;
            case "android.media.metadata.ALBUM_ARTIST":
                return mediaMetadata.albumArtist;
            default:
                return null;
        }
    }

    private static long convertToExtraBtFolderType(int i) {
        switch (i) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                throw new IllegalArgumentException("Unrecognized FolderType: " + i);
        }
    }

    public static Rating convertToRating(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        switch (ratingCompat.getRatingStyle()) {
            case 1:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 3:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 4:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 5:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 6:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
        }
        return null;
    }

    public static RatingCompat convertToRatingCompat(Rating rating) {
        if (rating == null) {
            return null;
        }
        int ratingCompatStyle = getRatingCompatStyle(rating);
        if (!rating.isRated()) {
            return RatingCompat.newUnratedRating(ratingCompatStyle);
        }
        switch (ratingCompatStyle) {
            case 1:
                return RatingCompat.newHeartRating(((HeartRating) rating).isHeart());
            case 2:
                return RatingCompat.newThumbRating(((ThumbRating) rating).isThumbsUp());
            case 3:
            case 4:
            case 5:
                return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).getStarRating());
            case 6:
                return RatingCompat.newPercentageRating(((PercentageRating) rating).getPercent());
            default:
                return null;
        }
    }

    public static int convertToPlaybackStateCompatState(Player player, boolean z) {
        if (player.getPlayerError() != null) {
            return 7;
        }
        int playbackState = player.getPlaybackState();
        boolean zShouldShowPlayButton = Util.shouldShowPlayButton(player, z);
        if (playbackState == 1) {
            return 0;
        }
        if (playbackState == 2) {
            return zShouldShowPlayButton ? 2 : 6;
        }
        if (playbackState == 3) {
            return zShouldShowPlayButton ? 2 : 3;
        }
        if (playbackState == 4) {
            return 1;
        }
        throw new IllegalArgumentException("Unrecognized State: " + playbackState);
    }

    public static PlaybackParameters convertToPlaybackParameters(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return PlaybackParameters.DEFAULT;
        }
        return new PlaybackParameters(playbackStateCompat.getPlaybackSpeed());
    }

    public static boolean convertToPlayWhenReady(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return false;
        }
        switch (playbackStateCompat.getState()) {
        }
        return false;
    }

    public static int convertToPlaybackState(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        if (playbackStateCompat == null) {
            return 1;
        }
        switch (playbackStateCompat.getState()) {
            case 0:
            case 1:
            case 7:
            case 8:
                return 1;
            case 2:
                long jConvertToDurationMs = convertToDurationMs(mediaMetadataCompat);
                return (jConvertToDurationMs != C.TIME_UNSET && convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j) >= jConvertToDurationMs) ? 4 : 3;
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                throw new ConversionException("Invalid state of PlaybackStateCompat: " + playbackStateCompat.getState());
        }
    }

    public static boolean convertToIsPlaying(PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat != null && playbackStateCompat.getState() == 3;
    }

    public static boolean convertToIsPlayingAd(MediaMetadataCompat mediaMetadataCompat) {
        return (mediaMetadataCompat == null || mediaMetadataCompat.getLong("android.media.metadata.ADVERTISEMENT") == 0) ? false : true;
    }

    public static long convertToCurrentPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        long position;
        if (playbackStateCompat == null) {
            return 0L;
        }
        if (playbackStateCompat.getState() == 3) {
            position = getCurrentPosition(playbackStateCompat, j);
        } else {
            position = playbackStateCompat.getPosition();
        }
        long j2 = position;
        long jConvertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        if (jConvertToDurationMs == C.TIME_UNSET) {
            return Math.max(0L, j2);
        }
        return Util.constrainValue(j2, 0L, jConvertToDurationMs);
    }

    private static long getCurrentPosition(PlaybackStateCompat playbackStateCompat, long j) {
        return playbackStateCompat.getCurrentPosition(j == C.TIME_UNSET ? null : Long.valueOf(j));
    }

    public static long convertToDurationMs(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
            return C.TIME_UNSET;
        }
        long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
        return j <= 0 ? C.TIME_UNSET : j;
    }

    public static long convertToBufferedPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        long bufferedPosition = playbackStateCompat == null ? 0L : playbackStateCompat.getBufferedPosition();
        long jConvertToCurrentPositionMs = convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j);
        long jConvertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        if (jConvertToDurationMs == C.TIME_UNSET) {
            return Math.max(jConvertToCurrentPositionMs, bufferedPosition);
        }
        return Util.constrainValue(bufferedPosition, jConvertToCurrentPositionMs, jConvertToDurationMs);
    }

    public static long convertToTotalBufferedDurationMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        return convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j) - convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j);
    }

    public static int convertToBufferedPercentage(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        return MediaUtils.calculateBufferedPercentage(convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j), convertToDurationMs(mediaMetadataCompat));
    }

    public static int getRatingCompatStyle(Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (!(rating instanceof StarRating)) {
            return rating instanceof PercentageRating ? 6 : 0;
        }
        int maxStars = ((StarRating) rating).getMaxStars();
        int i = 3;
        if (maxStars != 3) {
            i = 4;
            if (maxStars != 4) {
                i = 5;
                if (maxStars != 5) {
                    return 0;
                }
            }
        }
        return i;
    }

    public static int convertToRepeatMode(int i) {
        if (i == -1 || i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                Log.w("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + i + " was converted to `Player.REPEAT_MODE_OFF`");
                return 0;
            }
        }
        return i2;
    }

    public static int convertToPlaybackStateCompatRepeatMode(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                Log.w("LegacyConversions", "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                return 0;
            }
        }
        return i2;
    }

    public static boolean convertToShuffleModeEnabled(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        if (i == 1 || i == 2) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized ShuffleMode: " + i);
    }

    public static MediaLibraryService.LibraryParams convertToLibraryParams(Context context, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            int i = bundle.getInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", -1);
            if (i >= 0) {
                bundle.remove("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS");
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                bundle.putBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, z);
            }
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).setRecent(bundle.getBoolean("android.service.media.extra.RECENT")).setOffline(bundle.getBoolean("android.service.media.extra.OFFLINE")).setSuggested(bundle.getBoolean("android.service.media.extra.SUGGESTED")).build();
        } catch (Exception unused) {
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).build();
        }
    }

    public static Bundle convertToRootHints(MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams == null) {
            return null;
        }
        Bundle bundle = new Bundle(libraryParams.extras);
        if (libraryParams.extras.containsKey(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY)) {
            boolean z = libraryParams.extras.getBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, false);
            bundle.remove(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY);
            bundle.putInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", z ? 1 : 3);
        }
        bundle.putBoolean("android.service.media.extra.RECENT", libraryParams.isRecent);
        bundle.putBoolean("android.service.media.extra.OFFLINE", libraryParams.isOffline);
        bundle.putBoolean("android.service.media.extra.SUGGESTED", libraryParams.isSuggested);
        return bundle;
    }

    public static Player.Commands convertToPlayerCommands(PlaybackStateCompat playbackStateCompat, int i, long j, boolean z) {
        Player.Commands.Builder builder = new Player.Commands.Builder();
        long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
        if ((hasAction(actions, 4L) && hasAction(actions, 2L)) || hasAction(actions, 512L)) {
            builder.add(1);
        }
        if (hasAction(actions, 16384L)) {
            builder.add(2);
        }
        if ((hasAction(actions, 32768L) && hasAction(actions, 1024L)) || ((hasAction(actions, 65536L) && hasAction(actions, 2048L)) || (hasAction(actions, 131072L) && hasAction(actions, 8192L)))) {
            builder.addAll(31, 2);
        }
        if (hasAction(actions, 8L)) {
            builder.add(11);
        }
        if (hasAction(actions, 64L)) {
            builder.add(12);
        }
        if (hasAction(actions, 256L)) {
            builder.addAll(5, 4);
        }
        if (hasAction(actions, 32L)) {
            builder.addAll(9, 8);
        }
        if (hasAction(actions, 16L)) {
            builder.addAll(7, 6);
        }
        if (hasAction(actions, 4194304L)) {
            builder.add(13);
        }
        if (hasAction(actions, 1L)) {
            builder.add(3);
        }
        if (i == 1) {
            builder.addAll(26, 34);
        } else if (i == 2) {
            builder.addAll(26, 34, 25, 33);
        }
        builder.addAll(23, 17, 18, 16, 21, 32);
        if ((j & 4) != 0) {
            builder.add(20);
            if (hasAction(actions, 4096L)) {
                builder.add(10);
            }
        }
        if (z) {
            if (hasAction(actions, 262144L)) {
                builder.add(15);
            }
            if (hasAction(actions, 2097152L)) {
                builder.add(14);
            }
        }
        return builder.build();
    }

    public static SessionCommands convertToSessionCommands(PlaybackStateCompat playbackStateCompat, boolean z) {
        List<PlaybackStateCompat.CustomAction> customActions;
        SessionCommands.Builder builder = new SessionCommands.Builder();
        builder.addAllSessionCommands();
        if (!z) {
            builder.remove(SessionCommand.COMMAND_CODE_SESSION_SET_RATING);
        }
        if (playbackStateCompat != null && (customActions = playbackStateCompat.getCustomActions()) != null) {
            for (PlaybackStateCompat.CustomAction customAction : customActions) {
                String action = customAction.getAction();
                Bundle extras = customAction.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                builder.add(new SessionCommand(action, extras));
            }
        }
        return builder.build();
    }

    public static ImmutableList convertToCustomLayout(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return ImmutableList.of();
        }
        List<PlaybackStateCompat.CustomAction> customActions = playbackStateCompat.getCustomActions();
        if (customActions == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (PlaybackStateCompat.CustomAction customAction : customActions) {
            String action = customAction.getAction();
            Bundle extras = customAction.getExtras();
            CommandButton.Builder builder2 = new CommandButton.Builder(extras != null ? extras.getInt(MediaConstants.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT, 0) : 0, customAction.getIcon());
            if (extras == null) {
                extras = Bundle.EMPTY;
            }
            builder.add((ImmutableList.Builder) builder2.setSessionCommand(new SessionCommand(action, extras)).setDisplayName(customAction.getName()).setEnabled(true).build());
        }
        return builder.build();
    }

    public static AudioAttributes convertToAudioAttributes(AudioAttributesCompat audioAttributesCompat) {
        if (audioAttributesCompat == null) {
            return AudioAttributes.DEFAULT;
        }
        return new AudioAttributes.Builder().setContentType(audioAttributesCompat.getContentType()).setFlags(audioAttributesCompat.getFlags()).setUsage(audioAttributesCompat.getUsage()).build();
    }

    public static AudioAttributes convertToAudioAttributes(MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return AudioAttributes.DEFAULT;
        }
        return convertToAudioAttributes(playbackInfo.getAudioAttributes());
    }

    public static AudioAttributesCompat convertToAudioAttributesCompat(AudioAttributes audioAttributes) {
        return new AudioAttributesCompat.Builder().setContentType(audioAttributes.contentType).setFlags(audioAttributes.flags).setUsage(audioAttributes.usage).build();
    }

    public static int getLegacyStreamType(AudioAttributes audioAttributes) {
        int legacyStreamType = convertToAudioAttributesCompat(audioAttributes).getLegacyStreamType();
        if (legacyStreamType == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    public static Object getFutureResult(Future future, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (true) {
            try {
                try {
                    return future.get(j2, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    z = true;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (jElapsedRealtime2 >= j) {
                        throw new TimeoutException();
                    }
                    j2 = j - jElapsedRealtime2;
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static DeviceInfo convertToDeviceInfo(MediaControllerCompat.PlaybackInfo playbackInfo, String str) {
        if (playbackInfo == null) {
            return DeviceInfo.UNKNOWN;
        }
        return new DeviceInfo.Builder(playbackInfo.getPlaybackType() == 2 ? 1 : 0).setMaxVolume(playbackInfo.getMaxVolume()).setRoutingControllerId(str).build();
    }

    public static int convertToDeviceVolume(MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return 0;
        }
        return playbackInfo.getCurrentVolume();
    }

    public static boolean convertToIsDeviceMuted(MediaControllerCompat.PlaybackInfo playbackInfo) {
        return playbackInfo != null && playbackInfo.getCurrentVolume() == 0;
    }

    private static byte[] convertToByteArray(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
