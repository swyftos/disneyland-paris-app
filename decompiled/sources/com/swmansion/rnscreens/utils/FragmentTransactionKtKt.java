package com.swmansion.rnscreens.utils;

import androidx.fragment.app.FragmentTransaction;
import com.swmansion.rnscreens.R;
import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"setTweenAnimations", "", "Landroidx/fragment/app/FragmentTransaction;", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "shouldUseOpenAnimation", "", "react-native-screens_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FragmentTransactionKtKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            try {
                iArr[Screen.StackAnimation.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Screen.StackAnimation.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Screen.StackAnimation.FADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Screen.StackAnimation.SLIDE_FROM_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Screen.StackAnimation.FADE_FROM_BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Screen.StackAnimation.IOS_FROM_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Screen.StackAnimation.IOS_FROM_LEFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void setTweenAnimations(@NotNull FragmentTransaction fragmentTransaction, @NotNull Screen.StackAnimation stackAnimation, boolean z) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        Intrinsics.checkNotNullParameter(stackAnimation, "stackAnimation");
        if (z) {
            switch (WhenMappings.$EnumSwitchMapping$0[stackAnimation.ordinal()]) {
                case 1:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_default_enter_in, R.anim.rns_default_enter_out);
                    return;
                case 2:
                    int i = R.anim.rns_no_animation_20;
                    fragmentTransaction.setCustomAnimations(i, i);
                    return;
                case 3:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_fade_in, R.anim.rns_fade_out);
                    return;
                case 4:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                    return;
                case 5:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                    return;
                case 6:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_slide_in_from_bottom, R.anim.rns_no_animation_medium);
                    return;
                case 7:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_fade_from_bottom, R.anim.rns_no_animation_350);
                    return;
                case 8:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_ios_from_right_foreground_open, R.anim.rns_ios_from_right_background_open);
                    return;
                case 9:
                    fragmentTransaction.setCustomAnimations(R.anim.rns_ios_from_left_foreground_open, R.anim.rns_ios_from_left_background_open);
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        switch (WhenMappings.$EnumSwitchMapping$0[stackAnimation.ordinal()]) {
            case 1:
                fragmentTransaction.setCustomAnimations(R.anim.rns_default_exit_in, R.anim.rns_default_exit_out);
                return;
            case 2:
                int i2 = R.anim.rns_no_animation_20;
                fragmentTransaction.setCustomAnimations(i2, i2);
                return;
            case 3:
                fragmentTransaction.setCustomAnimations(R.anim.rns_fade_in, R.anim.rns_fade_out);
                return;
            case 4:
                fragmentTransaction.setCustomAnimations(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                return;
            case 5:
                fragmentTransaction.setCustomAnimations(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                return;
            case 6:
                fragmentTransaction.setCustomAnimations(R.anim.rns_no_animation_medium, R.anim.rns_slide_out_to_bottom);
                return;
            case 7:
                fragmentTransaction.setCustomAnimations(R.anim.rns_no_animation_250, R.anim.rns_fade_to_bottom);
                return;
            case 8:
                fragmentTransaction.setCustomAnimations(R.anim.rns_ios_from_right_background_close, R.anim.rns_ios_from_right_foreground_close);
                return;
            case 9:
                fragmentTransaction.setCustomAnimations(R.anim.rns_ios_from_left_background_close, R.anim.rns_ios_from_left_foreground_close);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
