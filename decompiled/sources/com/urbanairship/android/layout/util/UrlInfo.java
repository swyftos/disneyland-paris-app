package com.urbanairship.android.layout.util;

import androidx.annotation.NonNull;
import com.urbanairship.android.layout.info.ImageButtonInfo;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.info.MediaInfo;
import com.urbanairship.android.layout.info.ViewGroupInfo;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.info.WebViewInfo;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.property.MediaType;
import com.urbanairship.android.layout.property.ViewType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
public class UrlInfo {
    private final Boolean requiresNetwork;
    private final UrlType type;
    private final String url;

    public enum UrlType {
        WEB_PAGE,
        IMAGE,
        VIDEO
    }

    public UrlInfo(@NonNull UrlType urlType, @NonNull String str) {
        this.type = urlType;
        this.url = str;
        this.requiresNetwork = Boolean.TRUE;
    }

    public UrlInfo(@NonNull UrlType urlType, @NonNull String str, @NonNull Boolean bool) {
        this.type = urlType;
        this.url = str;
        this.requiresNetwork = bool;
    }

    @NonNull
    public UrlType getType() {
        return this.type;
    }

    @NonNull
    public String getUrl() {
        return this.url;
    }

    @NonNull
    public Boolean getRequiresNetwork() {
        return this.requiresNetwork;
    }

    @NonNull
    public static Set<UrlInfo> from(@NonNull ViewInfo viewInfo) {
        HashSet hashSet = new HashSet();
        int i = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ViewType[viewInfo.getType().ordinal()];
        if (i == 1) {
            MediaInfo mediaInfo = (MediaInfo) viewInfo;
            int i2 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$MediaType[mediaInfo.getMediaType().ordinal()];
            if (i2 == 1) {
                hashSet.add(new UrlInfo(UrlType.IMAGE, mediaInfo.getUrl()));
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                hashSet.add(new UrlInfo(UrlType.VIDEO, mediaInfo.getUrl()));
            }
        } else if (i == 2) {
            ImageButtonInfo imageButtonInfo = (ImageButtonInfo) viewInfo;
            if (imageButtonInfo.getImage().getType() == Image.Type.URL) {
                hashSet.add(new UrlInfo(UrlType.IMAGE, ((Image.Url) imageButtonInfo.getImage()).getUrl()));
            }
        } else if (i == 3) {
            hashSet.add(new UrlInfo(UrlType.WEB_PAGE, ((WebViewInfo) viewInfo).getUrl()));
        }
        if (viewInfo instanceof ViewGroupInfo) {
            Iterator it = ((ViewGroupInfo) viewInfo).getChildren().iterator();
            while (it.hasNext()) {
                hashSet.addAll(from(((ItemInfo) it.next()).getInfo()));
            }
        }
        return hashSet;
    }

    /* renamed from: com.urbanairship.android.layout.util.UrlInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$MediaType;
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$ViewType;

        static {
            int[] iArr = new int[ViewType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$ViewType = iArr;
            try {
                iArr[ViewType.MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$ViewType[ViewType.IMAGE_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$ViewType[ViewType.WEB_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MediaType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$MediaType = iArr2;
            try {
                iArr2[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$MediaType[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$MediaType[MediaType.YOUTUBE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$MediaType[MediaType.VIMEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
