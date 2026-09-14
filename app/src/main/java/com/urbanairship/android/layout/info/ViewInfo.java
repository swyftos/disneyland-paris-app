package com.urbanairship.android.layout.info;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ViewInfo;", "Lcom/urbanairship/android/layout/info/View;", "()V", "Companion", "Lcom/urbanairship/android/layout/info/BaseCheckableInfo;", "Lcom/urbanairship/android/layout/info/ButtonInfo;", "Lcom/urbanairship/android/layout/info/CheckableInfo;", "Lcom/urbanairship/android/layout/info/CustomViewInfo;", "Lcom/urbanairship/android/layout/info/EmptyInfo;", "Lcom/urbanairship/android/layout/info/IconViewInfo;", "Lcom/urbanairship/android/layout/info/LabelInfo;", "Lcom/urbanairship/android/layout/info/MediaInfo;", "Lcom/urbanairship/android/layout/info/PagerIndicatorInfo;", "Lcom/urbanairship/android/layout/info/ScoreInfo;", "Lcom/urbanairship/android/layout/info/StoryIndicatorInfo;", "Lcom/urbanairship/android/layout/info/TextInputInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/WebViewInfo;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ViewInfo implements View {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ViewInfo$Companion;", "", "()V", "viewInfoFromJson", "Lcom/urbanairship/android/layout/info/ViewInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ViewInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ViewInfo$Companion\n*L\n97#1:945,15\n130#1:960,15\n*E\n"})
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

        /* JADX WARN: Code duplicated, block: B:101:0x0223  */
        /* JADX WARN: Code duplicated, block: B:103:0x0229  */
        /* JADX WARN: Code duplicated, block: B:104:0x022d  */
        /* JADX WARN: Code duplicated, block: B:106:0x0237  */
        /* JADX WARN: Code duplicated, block: B:108:0x023d  */
        /* JADX WARN: Code duplicated, block: B:110:0x0243  */
        /* JADX WARN: Code duplicated, block: B:111:0x0247  */
        /* JADX WARN: Code duplicated, block: B:113:0x026b  */
        /* JADX WARN: Code duplicated, block: B:114:0x027b  */
        /* JADX WARN: Code duplicated, block: B:115:0x0287  */
        /* JADX WARN: Code duplicated, block: B:116:0x0293  */
        /* JADX WARN: Code duplicated, block: B:117:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:118:0x02b1  */
        /* JADX WARN: Code duplicated, block: B:119:0x02be  */
        /* JADX WARN: Code duplicated, block: B:122:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:124:0x02f3  */
        /* JADX WARN: Code duplicated, block: B:125:0x02fa  */
        /* JADX WARN: Code duplicated, block: B:126:0x0301  */
        /* JADX WARN: Code duplicated, block: B:127:0x0308  */
        /* JADX WARN: Code duplicated, block: B:128:0x030f  */
        /* JADX WARN: Code duplicated, block: B:129:0x0316  */
        /* JADX WARN: Code duplicated, block: B:130:0x031d  */
        /* JADX WARN: Code duplicated, block: B:131:0x0324  */
        /* JADX WARN: Code duplicated, block: B:132:0x032b  */
        /* JADX WARN: Code duplicated, block: B:133:0x0332  */
        /* JADX WARN: Code duplicated, block: B:134:0x0339  */
        /* JADX WARN: Code duplicated, block: B:135:0x0340  */
        /* JADX WARN: Code duplicated, block: B:136:0x0347  */
        /* JADX WARN: Code duplicated, block: B:137:0x034e  */
        /* JADX WARN: Code duplicated, block: B:138:0x0355  */
        /* JADX WARN: Code duplicated, block: B:139:0x035c  */
        /* JADX WARN: Code duplicated, block: B:140:0x0362  */
        /* JADX WARN: Code duplicated, block: B:141:0x0368  */
        /* JADX WARN: Code duplicated, block: B:142:0x036e  */
        /* JADX WARN: Code duplicated, block: B:143:0x0374  */
        /* JADX WARN: Code duplicated, block: B:144:0x037a  */
        /* JADX WARN: Code duplicated, block: B:145:0x0380  */
        /* JADX WARN: Code duplicated, block: B:146:0x0386  */
        /* JADX WARN: Code duplicated, block: B:147:0x038c  */
        /* JADX WARN: Code duplicated, block: B:148:0x0392  */
        /* JADX WARN: Code duplicated, block: B:149:0x0398  */
        /* JADX WARN: Code duplicated, block: B:150:0x039e  */
        /* JADX WARN: Code duplicated, block: B:151:0x03a4  */
        /* JADX WARN: Code duplicated, block: B:152:0x03aa  */
        /* JADX WARN: Code duplicated, block: B:153:0x03b0  */
        /* JADX WARN: Code duplicated, block: B:154:0x03b6  */
        /* JADX WARN: Code duplicated, block: B:60:0x0163  */
        /* JADX WARN: Code duplicated, block: B:62:0x0169  */
        /* JADX WARN: Code duplicated, block: B:64:0x017b  */
        /* JADX WARN: Code duplicated, block: B:66:0x0189  */
        /* JADX WARN: Code duplicated, block: B:68:0x018f  */
        /* JADX WARN: Code duplicated, block: B:70:0x0195  */
        /* JADX WARN: Code duplicated, block: B:72:0x019f  */
        /* JADX WARN: Code duplicated, block: B:74:0x01a5  */
        /* JADX WARN: Code duplicated, block: B:76:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:80:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:82:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:84:0x01d9  */
        /* JADX WARN: Code duplicated, block: B:86:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:88:0x01ef  */
        /* JADX WARN: Code duplicated, block: B:90:0x01f9  */
        /* JADX WARN: Code duplicated, block: B:92:0x0203  */
        /* JADX WARN: Code duplicated, block: B:94:0x0209  */
        /* JADX WARN: Code duplicated, block: B:96:0x020f  */
        /* JADX WARN: Code duplicated, block: B:97:0x0213  */
        /* JADX WARN: Code duplicated, block: B:99:0x021d  */
        /* JADX WARN: Instruction removed from duplicated block: B:111:0x0247, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:122:0x02d9, please report this as an issue */
        @JvmStatic
        @NotNull
        public final ViewInfo viewInfoFromJson(@NotNull JsonMap json) throws JsonException {
            String str;
            String strOptString;
            StringBuilder sb;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            String strOptString2;
            Object jsonValue2;
            Object objOptMap;
            Object objOptList;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue3 = json.get("type");
            if (jsonValue3 == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "' for field '";
                        strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
                    } else {
                        str = "' for field '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList2 = jsonValue3.optList();
                            if (objOptList2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap2 = jsonValue3.optMap();
                            if (objOptMap2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptMap2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue4 = jsonValue3.toJsonValue();
                            if (jsonValue4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) jsonValue4;
                        }
                    }
                    switch (WhenMappings.$EnumSwitchMapping$0[ViewType.from(strOptString).ordinal()]) {
                        case 1:
                            return new ContainerLayoutInfo(json);
                        case 2:
                            return new LinearLayoutInfo(json);
                        case 3:
                            return new ScrollLayoutInfo(json);
                        case 4:
                            return new EmptyInfo(json);
                        case 5:
                            return new WebViewInfo(json);
                        case 6:
                            return new MediaInfo(json);
                        case 7:
                            return new LabelInfo(json);
                        case 8:
                            return new LabelButtonInfo(json);
                        case 9:
                            return new ImageButtonInfo(json);
                        case 10:
                            return new ButtonLayoutInfo(json);
                        case 11:
                            return new CustomViewInfo(json);
                        case 12:
                            return new PagerControllerInfo(json);
                        case 13:
                            return new PagerInfo(json);
                        case 14:
                            return new PagerIndicatorInfo(json);
                        case 15:
                            return new StoryIndicatorInfo(json);
                        case 16:
                            return new FormControllerInfo(json);
                        case 17:
                            return new NpsFormControllerInfo(json);
                        case 18:
                            return new CheckboxControllerInfo(json);
                        case 19:
                            return new CheckboxInfo(json);
                        case 20:
                            return new ToggleInfo(json);
                        case 21:
                            return new BasicToggleLayoutInfo(json);
                        case 22:
                            return new CheckboxToggleLayoutInfo(json);
                        case 23:
                            return new RadioInputToggleLayoutInfo(json);
                        case 24:
                            return new RadioInputControllerInfo(json);
                        case 25:
                            return new RadioInputInfo(json);
                        case 26:
                            return new TextInputInfo(json);
                        case 27:
                            return new ScoreInfo(json);
                        case 28:
                            return new StateControllerInfo(json);
                        case 29:
                            return new IconViewInfo(json);
                        case 30:
                            return new ScoreControllerInfo(json);
                        case 31:
                            return new ScoreToggleLayoutInfo(json);
                        case 32:
                            sb = new StringBuilder();
                            sb.append("Unknown view type! '");
                            jsonValue = json.get("type");
                            if (jsonValue != null) {
                                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString2 = jsonValue.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString2 = jsonValue.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList = jsonValue.optList();
                                if (objOptList == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap = jsonValue.optMap();
                                if (objOptMap == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptMap;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue2 = jsonValue.toJsonValue();
                                if (jsonValue2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) jsonValue2;
                            }
                            sb.append(strOptString2);
                            sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
                            throw new JsonException(sb.toString());
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            str = "' for field '";
            switch (WhenMappings.$EnumSwitchMapping$0[ViewType.from(strOptString).ordinal()]) {
                case 1:
                    return new ContainerLayoutInfo(json);
                case 2:
                    return new LinearLayoutInfo(json);
                case 3:
                    return new ScrollLayoutInfo(json);
                case 4:
                    return new EmptyInfo(json);
                case 5:
                    return new WebViewInfo(json);
                case 6:
                    return new MediaInfo(json);
                case 7:
                    return new LabelInfo(json);
                case 8:
                    return new LabelButtonInfo(json);
                case 9:
                    return new ImageButtonInfo(json);
                case 10:
                    return new ButtonLayoutInfo(json);
                case 11:
                    return new CustomViewInfo(json);
                case 12:
                    return new PagerControllerInfo(json);
                case 13:
                    return new PagerInfo(json);
                case 14:
                    return new PagerIndicatorInfo(json);
                case 15:
                    return new StoryIndicatorInfo(json);
                case 16:
                    return new FormControllerInfo(json);
                case 17:
                    return new NpsFormControllerInfo(json);
                case 18:
                    return new CheckboxControllerInfo(json);
                case 19:
                    return new CheckboxInfo(json);
                case 20:
                    return new ToggleInfo(json);
                case 21:
                    return new BasicToggleLayoutInfo(json);
                case 22:
                    return new CheckboxToggleLayoutInfo(json);
                case 23:
                    return new RadioInputToggleLayoutInfo(json);
                case 24:
                    return new RadioInputControllerInfo(json);
                case 25:
                    return new RadioInputInfo(json);
                case 26:
                    return new TextInputInfo(json);
                case 27:
                    return new ScoreInfo(json);
                case 28:
                    return new StateControllerInfo(json);
                case 29:
                    return new IconViewInfo(json);
                case 30:
                    return new ScoreControllerInfo(json);
                case 31:
                    return new ScoreToggleLayoutInfo(json);
                case 32:
                    sb = new StringBuilder();
                    sb.append("Unknown view type! '");
                    jsonValue = json.get("type");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.toJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue2;
                    }
                    sb.append(strOptString2);
                    sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
                    throw new JsonException(sb.toString());
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private Companion() {
        }
    }

    private ViewInfo() {
    }
}
