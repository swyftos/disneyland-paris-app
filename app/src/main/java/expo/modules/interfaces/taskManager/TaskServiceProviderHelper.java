package expo.modules.interfaces.taskManager;

import android.content.Context;
import expo.modules.ExpoModulesPackageList;
import expo.modules.core.ModulePriorities;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.core.interfaces.Package;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1836d2 = {"Lexpo/modules/interfaces/taskManager/TaskServiceProviderHelper;", "", "<init>", "()V", "getTaskServiceImpl", "Lexpo/modules/interfaces/taskManager/TaskServiceInterface;", "context", "Landroid/content/Context;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nTaskServiceProviderHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskServiceProviderHelper.kt\nexpo/modules/interfaces/taskManager/TaskServiceProviderHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n808#2,11:43\n1062#2:54\n808#2,11:55\n*S KotlinDebug\n*F\n+ 1 TaskServiceProviderHelper.kt\nexpo/modules/interfaces/taskManager/TaskServiceProviderHelper\n*L\n32#1:43,11\n33#1:54\n37#1:55,11\n*E\n"})
public final class TaskServiceProviderHelper {

    @NotNull
    public static final TaskServiceProviderHelper INSTANCE = new TaskServiceProviderHelper();

    private TaskServiceProviderHelper() {
    }

    @DoNotStrip
    @Nullable
    public final TaskServiceInterface getTaskServiceImpl(@NotNull Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(context, "context");
        Method method = ExpoModulesPackageList.class.getMethod("getPackageList", new Class[0]);
        if (method == null) {
            return null;
        }
        Object objInvoke = method.invoke(null, new Object[0]);
        List list = objInvoke instanceof List ? (List) objInvoke : null;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Package) {
                arrayList.add(obj);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: expo.modules.interfaces.taskManager.TaskServiceProviderHelper$getTaskServiceImpl$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ModulePriorities modulePriorities = ModulePriorities.INSTANCE;
                return ComparisonsKt.compareValues(Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) t2).getClass()).getQualifiedName())), Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) t).getClass()).getQualifiedName())));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listSortedWith) {
            if (obj2 instanceof TaskServiceProviderInterface) {
                arrayList2.add(obj2);
            }
        }
        TaskServiceProviderInterface taskServiceProviderInterface = (TaskServiceProviderInterface) CollectionsKt.firstOrNull((List) arrayList2);
        if (taskServiceProviderInterface != null) {
            return taskServiceProviderInterface.getTaskServiceImpl(context);
        }
        return null;
    }
}
