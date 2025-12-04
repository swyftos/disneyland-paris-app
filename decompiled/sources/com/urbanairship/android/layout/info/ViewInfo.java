package com.urbanairship.android.layout.info;

import androidx.annotation.RestrictTo;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/info/ViewInfo;", "Lcom/urbanairship/android/layout/info/View;", "()V", "Companion", "Lcom/urbanairship/android/layout/info/BaseCheckableInfo;", "Lcom/urbanairship/android/layout/info/ButtonInfo;", "Lcom/urbanairship/android/layout/info/CheckableInfo;", "Lcom/urbanairship/android/layout/info/CustomViewInfo;", "Lcom/urbanairship/android/layout/info/EmptyInfo;", "Lcom/urbanairship/android/layout/info/IconViewInfo;", "Lcom/urbanairship/android/layout/info/LabelInfo;", "Lcom/urbanairship/android/layout/info/MediaInfo;", "Lcom/urbanairship/android/layout/info/PagerIndicatorInfo;", "Lcom/urbanairship/android/layout/info/ScoreInfo;", "Lcom/urbanairship/android/layout/info/StoryIndicatorInfo;", "Lcom/urbanairship/android/layout/info/TextInputInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/WebViewInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class ViewInfo implements View {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ViewInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final ViewInfo viewInfoFromJson(@NotNull JsonMap jsonMap) throws JsonException {
        return INSTANCE.viewInfoFromJson(jsonMap);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/ViewInfo$Companion;", "", "()V", "viewInfoFromJson", "Lcom/urbanairship/android/layout/info/ViewInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ViewInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ViewInfo$Companion\n*L\n97#1:945,15\n130#1:960,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ViewType.values().length];
                try {
                    iArr[ViewType.CONTAINER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ViewType.LINEAR_LAYOUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ViewType.SCROLL_LAYOUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ViewType.EMPTY_VIEW.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ViewType.WEB_VIEW.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ViewType.MEDIA.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ViewType.LABEL.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ViewType.LABEL_BUTTON.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ViewType.IMAGE_BUTTON.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ViewType.BUTTON_LAYOUT.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ViewType.CUSTOM_VIEW.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ViewType.PAGER_CONTROLLER.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[ViewType.PAGER.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[ViewType.PAGER_INDICATOR.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[ViewType.STORY_INDICATOR.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[ViewType.FORM_CONTROLLER.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[ViewType.NPS_FORM_CONTROLLER.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[ViewType.CHECKBOX_CONTROLLER.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr[ViewType.CHECKBOX.ordinal()] = 19;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr[ViewType.TOGGLE.ordinal()] = 20;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr[ViewType.BASIC_TOGGLE_LAYOUT.ordinal()] = 21;
                } catch (NoSuchFieldError unused21) {
                }
                try {
                    iArr[ViewType.CHECKBOX_TOGGLE_LAYOUT.ordinal()] = 22;
                } catch (NoSuchFieldError unused22) {
                }
                try {
                    iArr[ViewType.RADIO_INPUT_TOGGLE_LAYOUT.ordinal()] = 23;
                } catch (NoSuchFieldError unused23) {
                }
                try {
                    iArr[ViewType.RADIO_INPUT_CONTROLLER.ordinal()] = 24;
                } catch (NoSuchFieldError unused24) {
                }
                try {
                    iArr[ViewType.RADIO_INPUT.ordinal()] = 25;
                } catch (NoSuchFieldError unused25) {
                }
                try {
                    iArr[ViewType.TEXT_INPUT.ordinal()] = 26;
                } catch (NoSuchFieldError unused26) {
                }
                try {
                    iArr[ViewType.SCORE.ordinal()] = 27;
                } catch (NoSuchFieldError unused27) {
                }
                try {
                    iArr[ViewType.STATE_CONTROLLER.ordinal()] = 28;
                } catch (NoSuchFieldError unused28) {
                }
                try {
                    iArr[ViewType.ICON_VIEW.ordinal()] = 29;
                } catch (NoSuchFieldError unused29) {
                }
                try {
                    iArr[ViewType.SCORE_CONTROLLER.ordinal()] = 30;
                } catch (NoSuchFieldError unused30) {
                }
                try {
                    iArr[ViewType.SCORE_TOGGLE_LAYOUT.ordinal()] = 31;
                } catch (NoSuchFieldError unused31) {
                }
                try {
                    iArr[ViewType.UNKNOWN.ordinal()] = 32;
                } catch (NoSuchFieldError unused32) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:124:0x02f3  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x02fa  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0301  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0308  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x030f  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0316  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x031d  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0324  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x032b  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x0332  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0339  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x0340  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x0347  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x034e  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0355  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x035c  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0362  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0368  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x036e  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0374  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x037a  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0380  */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0386  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x038c  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x0392  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0398  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x039e  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03a4  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x03aa  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x03b0  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x03b6  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0169  */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.info.ViewInfo viewInfoFromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r24) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1092
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.ViewInfo.Companion.viewInfoFromJson(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.info.ViewInfo");
        }

        private Companion() {
        }
    }

    private ViewInfo() {
    }
}
