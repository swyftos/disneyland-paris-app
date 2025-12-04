package com.urbanairship.iam;

import com.urbanairship.android.layout.util.UrlInfo;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.info.InAppMessageMediaInfo;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"getUrlInfos", "", "Lcom/urbanairship/android/layout/util/UrlInfo;", "Lcom/urbanairship/iam/InAppMessage;", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppMessageMediaInfo.MediaType.values().length];
            try {
                iArr[InAppMessageMediaInfo.MediaType.YOUTUBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.VIMEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final List getUrlInfos$convert(InAppMessageMediaInfo inAppMessageMediaInfo) {
        if (inAppMessageMediaInfo == null) {
            return CollectionsKt.emptyList();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[inAppMessageMediaInfo.getType().ordinal()];
        if (i == 1) {
            return CollectionsKt.listOf(new UrlInfo(UrlInfo.UrlType.VIDEO, inAppMessageMediaInfo.getUrl()));
        }
        if (i == 2) {
            return CollectionsKt.listOf(new UrlInfo(UrlInfo.UrlType.VIDEO, inAppMessageMediaInfo.getUrl()));
        }
        if (i == 3) {
            return CollectionsKt.listOf(new UrlInfo(UrlInfo.UrlType.VIDEO, inAppMessageMediaInfo.getUrl()));
        }
        if (i == 4) {
            return CollectionsKt.listOf(new UrlInfo(UrlInfo.UrlType.IMAGE, inAppMessageMediaInfo.getUrl()));
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final List<UrlInfo> getUrlInfos(@NotNull InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, "<this>");
        InAppMessageDisplayContent displayContent = inAppMessage.getDisplayContent();
        if (displayContent instanceof InAppMessageDisplayContent.AirshipLayoutContent) {
            Set<UrlInfo> setFrom = UrlInfo.from(((InAppMessageDisplayContent.AirshipLayoutContent) inAppMessage.getDisplayContent()).getLayout().getLayoutInfo().getView());
            Intrinsics.checkNotNullExpressionValue(setFrom, "from(...)");
            return CollectionsKt.toList(setFrom);
        }
        if (displayContent instanceof InAppMessageDisplayContent.BannerContent) {
            return getUrlInfos$convert(((InAppMessageDisplayContent.BannerContent) inAppMessage.getDisplayContent()).getBanner().getMedia());
        }
        if (displayContent instanceof InAppMessageDisplayContent.CustomContent) {
            return CollectionsKt.emptyList();
        }
        if (displayContent instanceof InAppMessageDisplayContent.FullscreenContent) {
            return getUrlInfos$convert(((InAppMessageDisplayContent.FullscreenContent) inAppMessage.getDisplayContent()).getFullscreen().getMedia());
        }
        if (displayContent instanceof InAppMessageDisplayContent.HTMLContent) {
            return CollectionsKt.listOf(new UrlInfo(UrlInfo.UrlType.WEB_PAGE, ((InAppMessageDisplayContent.HTMLContent) inAppMessage.getDisplayContent()).getHtml().getUrl(), Boolean.valueOf(!Intrinsics.areEqual(((InAppMessageDisplayContent.HTMLContent) inAppMessage.getDisplayContent()).getHtml().getRequiresConnectivity(), Boolean.FALSE))));
        }
        if (displayContent instanceof InAppMessageDisplayContent.ModalContent) {
            return getUrlInfos$convert(((InAppMessageDisplayContent.ModalContent) inAppMessage.getDisplayContent()).getModal().getMedia());
        }
        throw new NoWhenBranchMatchedException();
    }
}
