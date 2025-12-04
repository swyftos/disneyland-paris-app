package cl.json;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cl.json.social.DiscordShare;
import cl.json.social.EmailShare;
import cl.json.social.FacebookPagesManagerShare;
import cl.json.social.FacebookShare;
import cl.json.social.FacebookStoriesShare;
import cl.json.social.GenericShare;
import cl.json.social.GooglePlusShare;
import cl.json.social.InstagramShare;
import cl.json.social.InstagramStoriesShare;
import cl.json.social.LinkedinShare;
import cl.json.social.MessengerShare;
import cl.json.social.PinterestShare;
import cl.json.social.SMSShare;
import cl.json.social.ShareIntent;
import cl.json.social.SnapChatShare;
import cl.json.social.TargetChosenReceiver;
import cl.json.social.TelegramShare;
import cl.json.social.TwitterShare;
import cl.json.social.ViberShare;
import cl.json.social.WhatsAppBusinessShare;
import cl.json.social.WhatsAppShare;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class RNShareImpl implements ActivityEventListener {
    public static final String NAME = "RNShare";
    static ReactApplicationContext RCTContext = null;
    public static final int SHARE_REQUEST_CODE = 16845;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 16845) {
            if (i2 == 0) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putBoolean("success", false);
                writableMapCreateMap.putString("message", "CANCELED");
                TargetChosenReceiver.callbackResolve(writableMapCreateMap);
                return;
            }
            if (i2 == -1) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putBoolean("success", true);
                TargetChosenReceiver.callbackResolve(writableMapCreateMap2);
            }
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    private enum SHARES {
        facebook,
        facebookstories,
        generic,
        pagesmanager,
        twitter,
        whatsapp,
        whatsappbusiness,
        instagram,
        instagramstories,
        googleplus,
        email,
        pinterest,
        messenger,
        snapchat,
        sms,
        linkedin,
        telegram,
        viber,
        discord;

        public static ShareIntent getShareClass(String str, ReactApplicationContext reactApplicationContext) {
            switch (AnonymousClass1.$SwitchMap$cl$json$RNShareImpl$SHARES[valueOf(str).ordinal()]) {
                case 1:
                    return new GenericShare(reactApplicationContext);
                case 2:
                    return new FacebookShare(reactApplicationContext);
                case 3:
                    return new FacebookStoriesShare(reactApplicationContext);
                case 4:
                    return new FacebookPagesManagerShare(reactApplicationContext);
                case 5:
                    return new TwitterShare(reactApplicationContext);
                case 6:
                    return new WhatsAppShare(reactApplicationContext);
                case 7:
                    return new WhatsAppBusinessShare(reactApplicationContext);
                case 8:
                    return new InstagramShare(reactApplicationContext);
                case 9:
                    return new InstagramStoriesShare(reactApplicationContext);
                case 10:
                    return new GooglePlusShare(reactApplicationContext);
                case 11:
                    return new EmailShare(reactApplicationContext);
                case 12:
                    return new PinterestShare(reactApplicationContext);
                case 13:
                    return new SMSShare(reactApplicationContext);
                case 14:
                    return new SnapChatShare(reactApplicationContext);
                case 15:
                    return new MessengerShare(reactApplicationContext);
                case 16:
                    return new LinkedinShare(reactApplicationContext);
                case 17:
                    return new TelegramShare(reactApplicationContext);
                case 18:
                    return new ViberShare(reactApplicationContext);
                case 19:
                    return new DiscordShare(reactApplicationContext);
                default:
                    return null;
            }
        }
    }

    /* renamed from: cl.json.RNShareImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cl$json$RNShareImpl$SHARES;

        static {
            int[] iArr = new int[SHARES.values().length];
            $SwitchMap$cl$json$RNShareImpl$SHARES = iArr;
            try {
                iArr[SHARES.generic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.facebook.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.facebookstories.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.pagesmanager.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.twitter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.whatsapp.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.whatsappbusiness.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.instagram.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.instagramstories.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.googleplus.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.email.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.pinterest.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.sms.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.snapchat.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.messenger.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.linkedin.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.telegram.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.viber.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$cl$json$RNShareImpl$SHARES[SHARES.discord.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public RNShareImpl(ReactApplicationContext reactApplicationContext) {
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        for (SHARES shares : SHARES.values()) {
            map.put(shares.toString().toUpperCase(Locale.ROOT), shares.toString());
        }
        return map;
    }

    public void open(ReadableMap readableMap, Promise promise) {
        TargetChosenReceiver.registerCallbacks(promise);
        try {
            new GenericShare(RCTContext).open(readableMap);
        } catch (ActivityNotFoundException e) {
            Log.e("RNShare", e.getMessage());
            e.printStackTrace(System.out);
            TargetChosenReceiver.callbackReject("not_available");
        } catch (Exception e2) {
            Log.e("RNShare", e2.getMessage());
            e2.printStackTrace(System.out);
            TargetChosenReceiver.callbackReject(e2.getMessage());
        }
    }

    public void shareSingle(ReadableMap readableMap, Promise promise) {
        TargetChosenReceiver.registerCallbacks(promise);
        if (ShareIntent.hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
            try {
                ShareIntent shareClass = SHARES.getShareClass(readableMap.getString(NotificationCompat.CATEGORY_SOCIAL), RCTContext);
                if (shareClass != null) {
                    shareClass.open(readableMap);
                    return;
                }
                throw new ActivityNotFoundException("Invalid share activity");
            } catch (ActivityNotFoundException e) {
                Log.e("RNShare", e.getMessage());
                e.printStackTrace(System.out);
                TargetChosenReceiver.callbackReject(e.getMessage());
                return;
            } catch (Exception e2) {
                Log.e("RNShare", e2.getMessage());
                e2.printStackTrace(System.out);
                TargetChosenReceiver.callbackReject(e2.getMessage());
                return;
            }
        }
        TargetChosenReceiver.callbackReject("key 'social' missing in options");
    }

    public void isPackageInstalled(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(ShareIntent.isPackageInstalled(str, RCTContext)));
        } catch (Exception e) {
            Log.e("RNShare", e.getMessage());
            promise.reject(e.getMessage());
        }
    }

    public void isBase64File(String str, Promise promise) {
        try {
            String scheme = Uri.parse(str).getScheme();
            if (scheme != null && scheme.equals("data")) {
                promise.resolve(Boolean.TRUE);
            } else {
                promise.resolve(Boolean.FALSE);
            }
        } catch (Exception e) {
            Log.e("RNShare", e.getMessage());
            e.printStackTrace(System.out);
            promise.reject(e.getMessage());
        }
    }
}
