package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v0 com.urbanairship.android.layout.property.ViewType, still in use, count: 1, list:
  (r7v0 com.urbanairship.android.layout.property.ViewType) from 0x01c3: FILLED_NEW_ARRAY 
  (r4v0 com.urbanairship.android.layout.property.ViewType)
  (r5v0 com.urbanairship.android.layout.property.ViewType)
  (r6v0 com.urbanairship.android.layout.property.ViewType)
  (r7v0 com.urbanairship.android.layout.property.ViewType)
  (r0v22 com.urbanairship.android.layout.property.ViewType)
  (r3v17 com.urbanairship.android.layout.property.ViewType)
  (r3v20 com.urbanairship.android.layout.property.ViewType)
 A[WRAPPED] (LINE:52) elemType: com.urbanairship.android.layout.property.ViewType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class ViewType {
    CONTAINER("container"),
    LINEAR_LAYOUT("linear_layout"),
    SCROLL_LAYOUT("scroll_layout"),
    EMPTY_VIEW("empty_view"),
    WEB_VIEW("web_view"),
    MEDIA("media"),
    LABEL("label"),
    LABEL_BUTTON("label_button"),
    IMAGE_BUTTON("image_button"),
    BUTTON_LAYOUT("button_layout"),
    PAGER_CONTROLLER("pager_controller"),
    PAGER("pager"),
    PAGER_INDICATOR("pager_indicator"),
    STORY_INDICATOR("story_indicator"),
    FORM_CONTROLLER("form_controller"),
    NPS_FORM_CONTROLLER("nps_form_controller"),
    CHECKBOX_CONTROLLER("checkbox_controller"),
    CHECKBOX("checkbox"),
    TOGGLE("toggle"),
    BASIC_TOGGLE_LAYOUT("basic_toggle_layout"),
    RADIO_INPUT_TOGGLE_LAYOUT("radio_input_toggle_layout"),
    CHECKBOX_TOGGLE_LAYOUT("checkbox_toggle_layout"),
    RADIO_INPUT_CONTROLLER("radio_input_controller"),
    RADIO_INPUT("radio_input"),
    TEXT_INPUT("text_input"),
    SCORE(FirebaseAnalytics.Param.SCORE),
    STATE_CONTROLLER("state_controller"),
    CUSTOM_VIEW("custom_view"),
    ICON_VIEW("icon_view"),
    SCORE_CONTROLLER("score_controller"),
    SCORE_TOGGLE_LAYOUT("score_toggle_layout"),
    UNKNOWN("");

    private static final List CONTROLLERS;
    private static final List FORM_INPUTS;
    private final String value;

    public static ViewType valueOf(String str) {
        return (ViewType) Enum.valueOf(ViewType.class, str);
    }

    public static ViewType[] values() {
        return (ViewType[]) $VALUES.clone();
    }

    static {
        ViewType viewType = FORM_CONTROLLER;
        ViewType viewType2 = NPS_FORM_CONTROLLER;
        ViewType viewType3 = CHECKBOX_CONTROLLER;
        ViewType viewType4 = RADIO_INPUT_CONTROLLER;
        ViewType viewType5 = SCORE_CONTROLLER;
        FORM_INPUTS = Arrays.asList(viewType3, new ViewType("checkbox"), viewType4, viewType, new ViewType("toggle"), viewType, viewType, new ViewType("basic_toggle_layout"), new ViewType("text_input"), new ViewType(FirebaseAnalytics.Param.SCORE), viewType, viewType2, viewType5, new ViewType("score_toggle_layout"));
        CONTROLLERS = Arrays.asList(viewType3, viewType, viewType2, new ViewType("pager_controller"), viewType4, new ViewType("state_controller"), viewType5);
    }

    private ViewType(String str) {
        this.value = str;
    }

    @NonNull
    public static ViewType from(@NonNull String str) {
        for (ViewType viewType : values()) {
            if (viewType.value.equals(str.toLowerCase(Locale.ROOT))) {
                return viewType;
            }
        }
        return UNKNOWN;
    }

    @NonNull
    public static ViewType from(int i) {
        for (ViewType viewType : values()) {
            if (viewType.ordinal() == i) {
                return viewType;
            }
        }
        return UNKNOWN;
    }

    public boolean isFormInput() {
        return FORM_INPUTS.contains(this);
    }

    public boolean isController() {
        return CONTROLLERS.contains(this);
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
