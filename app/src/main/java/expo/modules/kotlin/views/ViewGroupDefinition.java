package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BÉ\u0002\u0012S\u0010\u0002\u001aO\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\u0004\u0018\u0001`\r\u0012@\u0010\u000e\u001a<\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u0012)\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012>\u0010\u0014\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0016\u0012>\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0018¢\u0006\u0004\b\u0019\u0010\u001aR^\u0010\u0002\u001aO\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cRK\u0010\u000e\u001a<\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR4\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 RI\u0010\u0014\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eRI\u0010\u0017\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fj\u0004\u0018\u0001`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001e¨\u0006#"}, m1836d2 = {"Lexpo/modules/kotlin/views/ViewGroupDefinition;", "", "addViewAction", "Lkotlin/Function3;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "Landroid/view/View;", "child", "", ArrayContainsMatcher.INDEX_KEY, "", "Lexpo/modules/kotlin/views/AddViewAction;", "getChildAtAction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/GetChildAtAction;", "getChildCountAction", "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/GetChildCountAction;", "removeViewAction", "childToRemove", "Lexpo/modules/kotlin/views/RemoveViewAction;", "removeViewAtAction", "Lexpo/modules/kotlin/views/RemoveViewAtAction;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getAddViewAction", "()Lkotlin/jvm/functions/Function3;", "getGetChildAtAction", "()Lkotlin/jvm/functions/Function2;", "getGetChildCountAction", "()Lkotlin/jvm/functions/Function1;", "getRemoveViewAction", "getRemoveViewAtAction", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ViewGroupDefinition {
    private final Function3 addViewAction;
    private final Function2 getChildAtAction;
    private final Function1 getChildCountAction;
    private final Function2 removeViewAction;
    private final Function2 removeViewAtAction;

    public ViewGroupDefinition(@Nullable Function3<? super ViewGroup, ? super View, ? super Integer, Unit> function3, @Nullable Function2<? super ViewGroup, ? super Integer, ? extends View> function2, @Nullable Function1<? super ViewGroup, Integer> function1, @Nullable Function2<? super ViewGroup, ? super View, Unit> function4, @Nullable Function2<? super ViewGroup, ? super Integer, Unit> function5) {
        this.addViewAction = function3;
        this.getChildAtAction = function2;
        this.getChildCountAction = function1;
        this.removeViewAction = function4;
        this.removeViewAtAction = function5;
    }

    @Nullable
    public final Function3<ViewGroup, View, Integer, Unit> getAddViewAction() {
        return this.addViewAction;
    }

    @Nullable
    public final Function2<ViewGroup, Integer, View> getGetChildAtAction() {
        return this.getChildAtAction;
    }

    @Nullable
    public final Function1<ViewGroup, Integer> getGetChildCountAction() {
        return this.getChildCountAction;
    }

    @Nullable
    public final Function2<ViewGroup, View, Unit> getRemoveViewAction() {
        return this.removeViewAction;
    }

    @Nullable
    public final Function2<ViewGroup, Integer, Unit> getRemoveViewAtAction() {
        return this.removeViewAtAction;
    }
}
