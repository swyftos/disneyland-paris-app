package com.urbanairship.iam.content;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactcommunity.rndatetimepicker.RNConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "Lcom/urbanairship/json/JsonSerializable;", "Landroid/os/Parcelable;", "()V", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "describeContents", "", "isEmbedded", "", "validate", "writeToParcel", "", FirebaseAnalytics.Param.DESTINATION, "Landroid/os/Parcel;", "flags", "AirshipLayoutContent", "BannerContent", "CREATOR", "CustomContent", "DisplayType", "FullscreenContent", "HTMLContent", "ModalContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$AirshipLayoutContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$BannerContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$CustomContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$FullscreenContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$HTMLContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$ModalContent;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InAppMessageDisplayContent implements JsonSerializable, Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ InAppMessageDisplayContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: getDisplayType$urbanairship_automation_release */
    public abstract DisplayType getDisplayType();

    public boolean isEmbedded() {
        return false;
    }

    public abstract boolean validate();

    private InAppMessageDisplayContent() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$BannerContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "banner", "Lcom/urbanairship/iam/content/Banner;", "(Lcom/urbanairship/iam/content/Banner;)V", "getBanner", "()Lcom/urbanairship/iam/content/Banner;", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BannerContent extends InAppMessageDisplayContent {
        private final Banner banner;
        private final DisplayType displayType;

        public static /* synthetic */ BannerContent copy$default(BannerContent bannerContent, Banner banner, int i, Object obj) {
            if ((i & 1) != 0) {
                banner = bannerContent.banner;
            }
            return bannerContent.copy(banner);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Banner getBanner() {
            return this.banner;
        }

        @NotNull
        public final BannerContent copy(@NotNull Banner banner) {
            Intrinsics.checkNotNullParameter(banner, "banner");
            return new BannerContent(banner);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BannerContent) && Intrinsics.areEqual(this.banner, ((BannerContent) other).banner);
        }

        public int hashCode() {
            return this.banner.hashCode();
        }

        @NotNull
        public String toString() {
            return "BannerContent(banner=" + this.banner + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerContent(@NotNull Banner banner) {
            super(null);
            Intrinsics.checkNotNullParameter(banner, "banner");
            this.banner = banner;
            this.displayType = DisplayType.BANNER;
        }

        @NotNull
        public final Banner getBanner() {
            return this.banner;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return this.banner.validate$urbanairship_automation_release();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.banner.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$FullscreenContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", RNConstants.ARG_FULLSCREEN, "Lcom/urbanairship/iam/content/Fullscreen;", "(Lcom/urbanairship/iam/content/Fullscreen;)V", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getFullscreen", "()Lcom/urbanairship/iam/content/Fullscreen;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FullscreenContent extends InAppMessageDisplayContent {
        private final DisplayType displayType;
        private final Fullscreen fullscreen;

        public static /* synthetic */ FullscreenContent copy$default(FullscreenContent fullscreenContent, Fullscreen fullscreen, int i, Object obj) {
            if ((i & 1) != 0) {
                fullscreen = fullscreenContent.fullscreen;
            }
            return fullscreenContent.copy(fullscreen);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Fullscreen getFullscreen() {
            return this.fullscreen;
        }

        @NotNull
        public final FullscreenContent copy(@NotNull Fullscreen fullscreen) {
            Intrinsics.checkNotNullParameter(fullscreen, "fullscreen");
            return new FullscreenContent(fullscreen);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FullscreenContent) && Intrinsics.areEqual(this.fullscreen, ((FullscreenContent) other).fullscreen);
        }

        public int hashCode() {
            return this.fullscreen.hashCode();
        }

        @NotNull
        public String toString() {
            return "FullscreenContent(fullscreen=" + this.fullscreen + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenContent(@NotNull Fullscreen fullscreen) {
            super(null);
            Intrinsics.checkNotNullParameter(fullscreen, "fullscreen");
            this.fullscreen = fullscreen;
            this.displayType = DisplayType.FULLSCREEN;
        }

        @NotNull
        public final Fullscreen getFullscreen() {
            return this.fullscreen;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return this.fullscreen.validate();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.fullscreen.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$ModalContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "modal", "Lcom/urbanairship/iam/content/Modal;", "(Lcom/urbanairship/iam/content/Modal;)V", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getModal", "()Lcom/urbanairship/iam/content/Modal;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ModalContent extends InAppMessageDisplayContent {
        private final DisplayType displayType;
        private final Modal modal;

        public static /* synthetic */ ModalContent copy$default(ModalContent modalContent, Modal modal, int i, Object obj) {
            if ((i & 1) != 0) {
                modal = modalContent.modal;
            }
            return modalContent.copy(modal);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Modal getModal() {
            return this.modal;
        }

        @NotNull
        public final ModalContent copy(@NotNull Modal modal) {
            Intrinsics.checkNotNullParameter(modal, "modal");
            return new ModalContent(modal);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ModalContent) && Intrinsics.areEqual(this.modal, ((ModalContent) other).modal);
        }

        public int hashCode() {
            return this.modal.hashCode();
        }

        @NotNull
        public String toString() {
            return "ModalContent(modal=" + this.modal + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModalContent(@NotNull Modal modal) {
            super(null);
            Intrinsics.checkNotNullParameter(modal, "modal");
            this.modal = modal;
            this.displayType = DisplayType.MODAL;
        }

        @NotNull
        public final Modal getModal() {
            return this.modal;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return this.modal.validate();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() throws JsonException {
            return this.modal.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$HTMLContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "html", "Lcom/urbanairship/iam/content/HTML;", "(Lcom/urbanairship/iam/content/HTML;)V", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getHtml", "()Lcom/urbanairship/iam/content/HTML;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class HTMLContent extends InAppMessageDisplayContent {
        private final DisplayType displayType;
        private final HTML html;

        public static /* synthetic */ HTMLContent copy$default(HTMLContent hTMLContent, HTML html, int i, Object obj) {
            if ((i & 1) != 0) {
                html = hTMLContent.html;
            }
            return hTMLContent.copy(html);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final HTML getHtml() {
            return this.html;
        }

        @NotNull
        public final HTMLContent copy(@NotNull HTML html) {
            Intrinsics.checkNotNullParameter(html, "html");
            return new HTMLContent(html);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HTMLContent) && Intrinsics.areEqual(this.html, ((HTMLContent) other).html);
        }

        public int hashCode() {
            return this.html.hashCode();
        }

        @NotNull
        public String toString() {
            return "HTMLContent(html=" + this.html + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HTMLContent(@NotNull HTML html) {
            super(null);
            Intrinsics.checkNotNullParameter(html, "html");
            this.html = html;
            this.displayType = DisplayType.HTML;
        }

        @NotNull
        public final HTML getHtml() {
            return this.html;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return this.html.validate$urbanairship_automation_release();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() throws JsonException {
            return this.html.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$CustomContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", SchedulerSupport.CUSTOM, "Lcom/urbanairship/iam/content/Custom;", "(Lcom/urbanairship/iam/content/Custom;)V", "getCustom", "()Lcom/urbanairship/iam/content/Custom;", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class CustomContent extends InAppMessageDisplayContent {
        private final Custom custom;
        private final DisplayType displayType;

        public static /* synthetic */ CustomContent copy$default(CustomContent customContent, Custom custom, int i, Object obj) {
            if ((i & 1) != 0) {
                custom = customContent.custom;
            }
            return customContent.copy(custom);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Custom getCustom() {
            return this.custom;
        }

        @NotNull
        public final CustomContent copy(@NotNull Custom custom) {
            Intrinsics.checkNotNullParameter(custom, "custom");
            return new CustomContent(custom);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CustomContent) && Intrinsics.areEqual(this.custom, ((CustomContent) other).custom);
        }

        public int hashCode() {
            return this.custom.hashCode();
        }

        @NotNull
        public String toString() {
            return "CustomContent(custom=" + this.custom + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomContent(@NotNull Custom custom) {
            super(null);
            Intrinsics.checkNotNullParameter(custom, "custom");
            this.custom = custom;
            this.displayType = DisplayType.CUSTOM;
        }

        @NotNull
        public final Custom getCustom() {
            return this.custom;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.custom.getJsonValue();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$AirshipLayoutContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "layout", "Lcom/urbanairship/iam/content/AirshipLayout;", "(Lcom/urbanairship/iam/content/AirshipLayout;)V", "displayType", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getDisplayType$urbanairship_automation_release", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "getLayout", "()Lcom/urbanairship/iam/content/AirshipLayout;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "isEmbedded", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AirshipLayoutContent extends InAppMessageDisplayContent {
        private final DisplayType displayType;
        private final AirshipLayout layout;

        public static /* synthetic */ AirshipLayoutContent copy$default(AirshipLayoutContent airshipLayoutContent, AirshipLayout airshipLayout, int i, Object obj) {
            if ((i & 1) != 0) {
                airshipLayout = airshipLayoutContent.layout;
            }
            return airshipLayoutContent.copy(airshipLayout);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final AirshipLayout getLayout() {
            return this.layout;
        }

        @NotNull
        public final AirshipLayoutContent copy(@NotNull AirshipLayout layout) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            return new AirshipLayoutContent(layout);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AirshipLayoutContent) && Intrinsics.areEqual(this.layout, ((AirshipLayoutContent) other).layout);
        }

        public int hashCode() {
            return this.layout.hashCode();
        }

        @NotNull
        public String toString() {
            return "AirshipLayoutContent(layout=" + this.layout + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AirshipLayoutContent(@NotNull AirshipLayout layout) {
            super(null);
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.layout = layout;
            this.displayType = DisplayType.LAYOUT;
        }

        @NotNull
        public final AirshipLayout getLayout() {
            return this.layout;
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean validate() {
            return this.layout.validate$urbanairship_automation_release();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        public boolean isEmbedded() {
            return this.layout.isEmbedded$urbanairship_automation_release();
        }

        @Override // com.urbanairship.iam.content.InAppMessageDisplayContent
        @NotNull
        /* renamed from: getDisplayType$urbanairship_automation_release, reason: from getter */
        public DisplayType getDisplayType() {
            return this.displayType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            return this.layout.getJsonValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "BANNER", "CUSTOM", "FULLSCREEN", "MODAL", "HTML", "LAYOUT", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DisplayType implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DisplayType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final DisplayType BANNER = new DisplayType("BANNER", 0, "banner");
        public static final DisplayType CUSTOM = new DisplayType("CUSTOM", 1, SchedulerSupport.CUSTOM);
        public static final DisplayType FULLSCREEN = new DisplayType("FULLSCREEN", 2, RNConstants.ARG_FULLSCREEN);
        public static final DisplayType MODAL = new DisplayType("MODAL", 3, "modal");
        public static final DisplayType HTML = new DisplayType("HTML", 4, "html");
        public static final DisplayType LAYOUT = new DisplayType("LAYOUT", 5, "layout");

        private static final /* synthetic */ DisplayType[] $values() {
            return new DisplayType[]{BANNER, CUSTOM, FULLSCREEN, MODAL, HTML, LAYOUT};
        }

        @NotNull
        public static EnumEntries<DisplayType> getEntries() {
            return $ENTRIES;
        }

        public static DisplayType valueOf(String str) {
            return (DisplayType) Enum.valueOf(DisplayType.class, str);
        }

        public static DisplayType[] values() {
            return (DisplayType[]) $VALUES.clone();
        }

        private DisplayType(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        public final String getJson() {
            return this.json;
        }

        static {
            DisplayType[] displayTypeArr$values = $values();
            $VALUES = displayTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(displayTypeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessageDisplayContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageDisplayContent.kt\ncom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n288#2,2:171\n*S KotlinDebug\n*F\n+ 1 InAppMessageDisplayContent.kt\ncom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType$Companion\n*L\n115#1:171,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final DisplayType fromJson(@NotNull JsonValue value) throws JsonException {
                DisplayType next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<DisplayType> it = DisplayType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                DisplayType displayType = next;
                if (displayType != null) {
                    return displayType;
                }
                throw new JsonException("Unsupported display type " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/iam/content/InAppMessageDisplayContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "()V", "PARCEL_CONTENT", "", "PARCEL_DISPLAY_TYPE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", "type", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$DisplayType;", "newArray", "", TCEventPropertiesNames.TCP_SIZE, "", "(I)[Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nInAppMessageDisplayContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageDisplayContent.kt\ncom/urbanairship/iam/content/InAppMessageDisplayContent$CREATOR\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,170:1\n1#2:171\n*E\n"})
    /* renamed from: com.urbanairship.iam.content.InAppMessageDisplayContent$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<InAppMessageDisplayContent> {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.urbanairship.iam.content.InAppMessageDisplayContent$CREATOR$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DisplayType.values().length];
                try {
                    iArr[DisplayType.BANNER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DisplayType.CUSTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DisplayType.FULLSCREEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DisplayType.MODAL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DisplayType.HTML.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DisplayType.LAYOUT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppMessageDisplayContent fromJson(@NotNull JsonValue value, @NotNull DisplayType type) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(type, "type");
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return new BannerContent(Banner.INSTANCE.fromJson(value));
                case 2:
                    return new CustomContent(Custom.INSTANCE.fromJson(value));
                case 3:
                    return new FullscreenContent(Fullscreen.INSTANCE.fromJson(value));
                case 4:
                    return new ModalContent(Modal.INSTANCE.fromJson(value));
                case 5:
                    return new HTMLContent(HTML.INSTANCE.fromJson(value));
                case 6:
                    return new AirshipLayoutContent(AirshipLayout.INSTANCE.fromJson(value));
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @Nullable
        public InAppMessageDisplayContent createFromParcel(@NotNull Parcel parcel) {
            JsonValue string;
            JsonMap jsonMapRequireMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            try {
                String string2 = parcel.readString();
                if (string2 != null && (string = JsonValue.parseString(string2)) != null && (jsonMapRequireMap = string.requireMap()) != null) {
                    DisplayType.Companion companion = DisplayType.INSTANCE;
                    JsonValue jsonValueRequire = jsonMapRequireMap.require("display_type");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                    DisplayType displayTypeFromJson = companion.fromJson(jsonValueRequire);
                    JsonValue jsonValueRequire2 = jsonMapRequireMap.require("content");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                    return fromJson(jsonValueRequire2, displayTypeFromJson);
                }
                return null;
            } catch (Exception e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.iam.content.InAppMessageDisplayContent$CREATOR$createFromParcel$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to restore message display content";
                    }
                });
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppMessageDisplayContent[] newArray(int size) {
            return new InAppMessageDisplayContent[size];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel destination, int flags) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        try {
            destination.writeString(JsonExtensionsKt.jsonMapOf(TuplesKt.to("display_type", getDisplayType()), TuplesKt.to("content", getJsonValue())).toString());
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.content.InAppMessageDisplayContent.writeToParcel.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to write in-app message display content to parcel!";
                }
            });
        }
    }
}
