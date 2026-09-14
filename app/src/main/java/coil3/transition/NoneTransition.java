package coil3.transition;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lcoil3/transition/NoneTransition;", "Lcoil3/transition/Transition;", TypedValues.AttributesType.S_TARGET, "Lcoil3/transition/TransitionTarget;", "result", "Lcoil3/request/ImageResult;", "<init>", "(Lcoil3/transition/TransitionTarget;Lcoil3/request/ImageResult;)V", "transition", "", "Factory", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class NoneTransition implements Transition {
    private final ImageResult result;
    private final TransitionTarget target;

    public NoneTransition(@NotNull TransitionTarget transitionTarget, @NotNull ImageResult imageResult) {
        this.target = transitionTarget;
        this.result = imageResult;
    }

    @Override // coil3.transition.Transition
    public void transition() {
        ImageResult imageResult = this.result;
        if (imageResult instanceof SuccessResult) {
            this.target.onSuccess(((SuccessResult) imageResult).getImage());
        } else {
            if (!(imageResult instanceof ErrorResult)) {
                throw new NoWhenBranchMatchedException();
            }
            this.target.onError(((ErrorResult) imageResult).getImage());
        }
    }

    @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1836d2 = {"Lcoil3/transition/NoneTransition$Factory;", "Lcoil3/transition/Transition$Factory;", "<init>", "()V", "create", "Lcoil3/transition/Transition;", TypedValues.AttributesType.S_TARGET, "Lcoil3/transition/TransitionTarget;", "result", "Lcoil3/request/ImageResult;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Factory implements Transition.Factory {
        @Override // coil3.transition.Transition.Factory
        @NotNull
        public Transition create(@NotNull TransitionTarget target, @NotNull ImageResult result) {
            return new NoneTransition(target, result);
        }
    }
}
