package com.urbanairship.iam.assets;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.UAStringUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u001dH\u0002J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\fH\u0002J\u0018\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/urbanairship/iam/assets/DefaultAirshipCachedAssets;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "directory", "Ljava/io/File;", "fileManager", "Lcom/urbanairship/iam/assets/AssetFileManager;", "(Ljava/io/File;Lcom/urbanairship/iam/assets/AssetFileManager;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "metadataCache", "", "", "Lcom/urbanairship/json/JsonValue;", "cacheUri", "Landroid/net/Uri;", "remoteUrl", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "generateAndStoreMetadata", "", "url", "generateAndStoreMetadata$urbanairship_automation_release", "getCachedAssetUrl", "remote", "getMediaSize", "Landroid/util/Size;", "hashCode", "isCached", "jsonToSize", "json", "metadataUri", "mediaUri", "readJson", "metadata", "sizeToJson", TCEventPropertiesNames.TCP_SIZE, "writeJson", FirebaseAnalytics.Param.DESTINATION, "jsonValue", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAirshipCachedAssets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipCachedAssets.kt\ncom/urbanairship/iam/assets/DefaultAirshipCachedAssets\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,259:1\n29#2:260\n29#2:261\n36#2:263\n1#3:262\n*S KotlinDebug\n*F\n+ 1 AirshipCachedAssets.kt\ncom/urbanairship/iam/assets/DefaultAirshipCachedAssets\n*L\n82#1:260\n93#1:261\n192#1:263\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultAirshipCachedAssets implements AirshipCachedAssets {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String METADATA_EXTENSION = ".metadata";
    private final File directory;
    private final AssetFileManager fileManager;
    private final ReentrantLock lock;
    private final Map metadataCache;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    @Nullable
    public Uri cacheUri(@NotNull final String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        try {
            return getCachedAssetUrl(Uri.parse(remoteUrl));
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.cacheUri.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get cached asset url! " + remoteUrl;
                }
            });
            return null;
        }
    }

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    public boolean isCached(@NotNull final String remoteUrl) {
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        try {
            return this.fileManager.assetItemExists(getCachedAssetUrl(Uri.parse(remoteUrl)));
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.isCached.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to determine if asset is cached! " + remoteUrl;
                }
            });
            return false;
        }
    }

    public DefaultAirshipCachedAssets(@NotNull File directory, @NotNull AssetFileManager fileManager) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileManager, "fileManager");
        this.directory = directory;
        this.fileManager = fileManager;
        this.lock = new ReentrantLock();
        this.metadataCache = new LinkedHashMap();
    }

    private final File metadataUri(Uri mediaUri) {
        return new File(mediaUri.getPath() + "..metadata");
    }

    @Override // com.urbanairship.iam.assets.AirshipCachedAssets
    @NotNull
    public Size getMediaSize(@NotNull String remoteUrl) {
        Size sizeJsonToSize;
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            JsonValue jsonValue = (JsonValue) this.metadataCache.get(remoteUrl);
            if (jsonValue != null) {
                sizeJsonToSize = jsonToSize(jsonValue);
            } else {
                Uri uriCacheUri = cacheUri(remoteUrl);
                if (uriCacheUri == null) {
                    Size size = new Size(-1, -1);
                    reentrantLock.unlock();
                    return size;
                }
                JsonValue json = readJson(metadataUri(uriCacheUri));
                this.metadataCache.put(remoteUrl, json);
                sizeJsonToSize = jsonToSize(json);
            }
            reentrantLock.unlock();
            return sizeJsonToSize;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void generateAndStoreMetadata$urbanairship_automation_release(@NotNull final String url) {
        Uri uriCacheUri;
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.directory.exists() && (uriCacheUri = cacheUri(url)) != null) {
            try {
                if (this.fileManager.assetItemExists(uriCacheUri)) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(uriCacheUri.getPath(), options);
                    try {
                        JsonValue jsonValueSizeToJson = sizeToJson(new Size(options.outWidth, options.outHeight));
                        writeJson(metadataUri(uriCacheUri), jsonValueSizeToJson);
                        ReentrantLock reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            this.metadataCache.put(url, jsonValueSizeToJson);
                            Unit unit = Unit.INSTANCE;
                        } finally {
                            reentrantLock.unlock();
                        }
                    } catch (JsonException e) {
                        UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$generateAndStoreMetadata$json$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to generate cached asset metadata. Unable to convert size to json!";
                            }
                        });
                    }
                }
            } catch (IOException e2) {
                UALog.e(e2, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$generateAndStoreMetadata$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to generate and store cached asset metadata! " + url;
                    }
                });
            }
        }
    }

    private final Size jsonToSize(JsonValue json) {
        JsonMap jsonMapOptMap = json.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        return new Size(jsonMapOptMap.opt("width").getInt(-1), jsonMapOptMap.opt("height").getInt(-1));
    }

    private final JsonValue sizeToJson(Size size) {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("height", Integer.valueOf(size.getHeight())), TuplesKt.to("width", Integer.valueOf(size.getWidth()))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    private final void writeJson(File destination, JsonValue jsonValue) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), Charsets.UTF_8), 8192);
            try {
                bufferedWriter.write(jsonValue.toString());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
            } finally {
            }
        } catch (Exception e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.writeJson.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to write cached asset metadata!";
                }
            });
        }
    }

    private final JsonValue readJson(File metadata) {
        if (!metadata.exists()) {
            JsonValue NULL = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
            return NULL;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(metadata), Charsets.UTF_8), 8192);
            try {
                TextStreamsKt.copyTo$default(bufferedReader, stringWriter, 0, 2, null);
                CloseableKt.closeFinally(bufferedReader, null);
                JsonValue string = JsonValue.parseString(stringWriter.toString());
                Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
                return string;
            } finally {
            }
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.readJson.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse cached asset metadata!";
                }
            });
            JsonValue NULL2 = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL2, "NULL");
            return NULL2;
        } catch (IOException e2) {
            UALog.e(e2, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.readJson.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to read cached asset metadata!";
                }
            });
            JsonValue NULL22 = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL22, "NULL");
            return NULL22;
        }
    }

    private final Uri getCachedAssetUrl(Uri remote) throws IOException {
        String strSha256 = UAStringUtil.sha256(remote.getPath());
        if (strSha256 != null) {
            return Uri.fromFile(new File(this.directory, strSha256));
        }
        throw new IOException("Failed to generate cached asset URL hash!");
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(DefaultAirshipCachedAssets.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.assets.DefaultAirshipCachedAssets");
        return Intrinsics.areEqual(this.directory, ((DefaultAirshipCachedAssets) other).directory);
    }

    public int hashCode() {
        return Objects.hash(this.directory);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        try {
            JsonValue jsonValueWrap = JsonValue.wrap(this.metadataCache);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            parcel.writeString(jsonValueWrap.toString());
            parcel.writeString(this.directory.getAbsolutePath());
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets.writeToParcel.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to write cached asset metadata to parcel!";
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/assets/DefaultAirshipCachedAssets$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "()V", "METADATA_EXTENSION", "", "getMETADATA_EXTENSION$urbanairship_automation_release$annotations", "METADATA_IMAGE_HEIGHT", "METADATA_IMAGE_WIDTH", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", TCEventPropertiesNames.TCP_SIZE, "", "(I)[Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<AirshipCachedAssets> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMETADATA_EXTENSION$urbanairship_automation_release$annotations() {
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @Nullable
        public AirshipCachedAssets createFromParcel(@NotNull Parcel parcel) throws JsonException {
            JsonMap jsonMapJsonMapOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            try {
                jsonMapJsonMapOf = JsonValue.parseString(parcel.readString()).optMap();
            } catch (JsonException e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$CREATOR$createFromParcel$metadata$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to restore cached asset metadata from parcel!";
                    }
                });
                jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(new Pair[0]);
            }
            Intrinsics.checkNotNull(jsonMapJsonMapOf);
            final String string = parcel.readString();
            if (string == null) {
                return null;
            }
            File file = new File(string);
            try {
                if (!file.exists()) {
                    UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$CREATOR$createFromParcel$directory$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to restore cached asset! Directory does not exist! " + string;
                        }
                    }, 1, null);
                    return null;
                }
                Context applicationContext = UAirship.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                DefaultAirshipCachedAssets defaultAirshipCachedAssets = new DefaultAirshipCachedAssets(file, new DefaultAssetFileManager(applicationContext, null, 2, null));
                Map map = defaultAirshipCachedAssets.metadataCache;
                Map<String, JsonValue> map2 = jsonMapJsonMapOf.getMap();
                Intrinsics.checkNotNullExpressionValue(map2, "getMap(...)");
                map.putAll(map2);
                return defaultAirshipCachedAssets;
            } catch (Exception e2) {
                UALog.e(e2, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.assets.DefaultAirshipCachedAssets$CREATOR$createFromParcel$directory$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to restore cached asset! " + string;
                    }
                });
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AirshipCachedAssets[] newArray(int size) {
            return new AirshipCachedAssets[size];
        }
    }
}
