package com.facebook.react.bridge;

import ch.qos.logback.core.net.SyslogConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\bv\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bx¨\u0006y"}, d2 = {"Lcom/facebook/react/bridge/ReactMarkerConstants;", "", "hasMatchingNameMarker", "", "<init>", "(Ljava/lang/String;IZ)V", "()Z", "APP_STARTUP_START", "APP_STARTUP_END", "CREATE_REACT_CONTEXT_START", "CREATE_REACT_CONTEXT_END", "INIT_REACT_RUNTIME_START", "INIT_REACT_RUNTIME_END", "PROCESS_PACKAGES_START", "PROCESS_PACKAGES_END", "BUILD_NATIVE_MODULE_REGISTRY_START", "BUILD_NATIVE_MODULE_REGISTRY_END", "CREATE_CATALYST_INSTANCE_START", "CREATE_CATALYST_INSTANCE_END", "DESTROY_CATALYST_INSTANCE_START", "DESTROY_CATALYST_INSTANCE_END", "RUN_JS_BUNDLE_START", "RUN_JS_BUNDLE_END", "NATIVE_MODULE_INITIALIZE_START", "NATIVE_MODULE_INITIALIZE_END", "SETUP_REACT_CONTEXT_START", "SETUP_REACT_CONTEXT_END", "CHANGE_THREAD_PRIORITY", "CREATE_UI_MANAGER_MODULE_START", "CREATE_UI_MANAGER_MODULE_END", "CREATE_VIEW_MANAGERS_START", "CREATE_VIEW_MANAGERS_END", "CREATE_UI_MANAGER_MODULE_CONSTANTS_START", "CREATE_UI_MANAGER_MODULE_CONSTANTS_END", "NATIVE_MODULE_SETUP_START", "NATIVE_MODULE_SETUP_END", "CREATE_MODULE_START", "CREATE_MODULE_END", "PROCESS_CORE_REACT_PACKAGE_START", "PROCESS_CORE_REACT_PACKAGE_END", "CREATE_I18N_MODULE_CONSTANTS_START", "CREATE_I18N_MODULE_CONSTANTS_END", "I18N_MODULE_CONSTANTS_CONVERT_START", "I18N_MODULE_CONSTANTS_CONVERT_END", "GET_CONSTANTS_START", "GET_CONSTANTS_END", "INITIALIZE_MODULE_START", "INITIALIZE_MODULE_END", "ON_HOST_RESUME_START", "ON_HOST_RESUME_END", "ON_USER_LEAVE_HINT_START", "ON_USER_LEAVE_HINT_END", "ON_HOST_PAUSE_START", "ON_HOST_PAUSE_END", "CONVERT_CONSTANTS_START", "CONVERT_CONSTANTS_END", "PRE_REACT_CONTEXT_END", "UNPACKING_JS_BUNDLE_LOADER_CHECK_START", "UNPACKING_JS_BUNDLE_LOADER_CHECK_END", "UNPACKING_JS_BUNDLE_LOADER_EXTRACTED", "UNPACKING_JS_BUNDLE_LOADER_BLOCKED", "loadApplicationScript_startStringConvert", "loadApplicationScript_endStringConvert", "PRE_SETUP_REACT_CONTEXT_START", "PRE_SETUP_REACT_CONTEXT_END", "PRE_RUN_JS_BUNDLE_START", "ATTACH_MEASURED_ROOT_VIEWS_START", "ATTACH_MEASURED_ROOT_VIEWS_END", "CONTENT_APPEARED", "RELOAD", "DOWNLOAD_START", "DOWNLOAD_END", "REACT_CONTEXT_THREAD_START", "REACT_CONTEXT_THREAD_END", "GET_REACT_INSTANCE_MANAGER_START", "GET_REACT_INSTANCE_MANAGER_END", "GET_REACT_INSTANCE_HOLDER_SPEC_START", "GET_REACT_INSTANCE_HOLDER_SPEC_END", "BUILD_REACT_INSTANCE_MANAGER_START", "BUILD_REACT_INSTANCE_MANAGER_END", "PROCESS_INFRA_PACKAGE_START", "PROCESS_INFRA_PACKAGE_END", "PROCESS_PRODUCT_PACKAGE_START", "PROCESS_PRODUCT_PACKAGE_END", "CREATE_MC_MODULE_START", "CREATE_MC_MODULE_END", "CREATE_MC_MODULE_GET_METADATA_START", "CREATE_MC_MODULE_GET_METADATA_END", "REGISTER_JS_SEGMENT_START", "REGISTER_JS_SEGMENT_STOP", "VM_INIT", "ON_FRAGMENT_CREATE", "JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START", "JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END", "LOAD_REACT_NATIVE_SO_FILE_START", "LOAD_REACT_NATIVE_SO_FILE_END", "ROOT_VIEW_ON_MEASURE_START", "ROOT_VIEW_ON_MEASURE_END", "ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START", "ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END", "ROOT_VIEW_UPDATE_LAYOUT_SPECS_START", "ROOT_VIEW_UPDATE_LAYOUT_SPECS_END", "LOAD_REACT_NATIVE_FABRIC_SO_FILE_START", "LOAD_REACT_NATIVE_FABRIC_SO_FILE_END", "FABRIC_COMMIT_START", "FABRIC_COMMIT_END", "FABRIC_FINISH_TRANSACTION_START", "FABRIC_FINISH_TRANSACTION_END", "FABRIC_DIFF_START", "FABRIC_DIFF_END", "FABRIC_LAYOUT_START", "FABRIC_LAYOUT_END", "FABRIC_LAYOUT_AFFECTED_NODES", "FABRIC_BATCH_EXECUTION_START", "FABRIC_BATCH_EXECUTION_END", "FABRIC_UPDATE_UI_MAIN_THREAD_START", "FABRIC_UPDATE_UI_MAIN_THREAD_END", "REACT_BRIDGE_LOADING_START", "REACT_BRIDGE_LOADING_END", "REACT_BRIDGELESS_LOADING_START", "REACT_BRIDGELESS_LOADING_END", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactMarkerConstants {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReactMarkerConstants[] $VALUES;
    public static final ReactMarkerConstants ATTACH_MEASURED_ROOT_VIEWS_END;
    public static final ReactMarkerConstants ATTACH_MEASURED_ROOT_VIEWS_START;
    public static final ReactMarkerConstants BUILD_NATIVE_MODULE_REGISTRY_END;
    public static final ReactMarkerConstants BUILD_NATIVE_MODULE_REGISTRY_START;
    public static final ReactMarkerConstants BUILD_REACT_INSTANCE_MANAGER_END;
    public static final ReactMarkerConstants BUILD_REACT_INSTANCE_MANAGER_START;
    public static final ReactMarkerConstants CHANGE_THREAD_PRIORITY;
    public static final ReactMarkerConstants CONTENT_APPEARED;
    public static final ReactMarkerConstants CONVERT_CONSTANTS_END;
    public static final ReactMarkerConstants CONVERT_CONSTANTS_START;
    public static final ReactMarkerConstants CREATE_CATALYST_INSTANCE_END;
    public static final ReactMarkerConstants CREATE_CATALYST_INSTANCE_START;
    public static final ReactMarkerConstants CREATE_I18N_MODULE_CONSTANTS_END;
    public static final ReactMarkerConstants CREATE_I18N_MODULE_CONSTANTS_START;
    public static final ReactMarkerConstants CREATE_MC_MODULE_END;
    public static final ReactMarkerConstants CREATE_MC_MODULE_GET_METADATA_END;
    public static final ReactMarkerConstants CREATE_MC_MODULE_GET_METADATA_START;
    public static final ReactMarkerConstants CREATE_MC_MODULE_START;
    public static final ReactMarkerConstants CREATE_MODULE_END;
    public static final ReactMarkerConstants CREATE_MODULE_START;
    public static final ReactMarkerConstants CREATE_REACT_CONTEXT_START;
    public static final ReactMarkerConstants CREATE_UI_MANAGER_MODULE_CONSTANTS_END;
    public static final ReactMarkerConstants CREATE_UI_MANAGER_MODULE_CONSTANTS_START;
    public static final ReactMarkerConstants CREATE_UI_MANAGER_MODULE_END;
    public static final ReactMarkerConstants CREATE_UI_MANAGER_MODULE_START;
    public static final ReactMarkerConstants CREATE_VIEW_MANAGERS_END;
    public static final ReactMarkerConstants CREATE_VIEW_MANAGERS_START;
    public static final ReactMarkerConstants DESTROY_CATALYST_INSTANCE_END;
    public static final ReactMarkerConstants DESTROY_CATALYST_INSTANCE_START;
    public static final ReactMarkerConstants DOWNLOAD_END;
    public static final ReactMarkerConstants DOWNLOAD_START;
    public static final ReactMarkerConstants FABRIC_BATCH_EXECUTION_END;
    public static final ReactMarkerConstants FABRIC_BATCH_EXECUTION_START;
    public static final ReactMarkerConstants FABRIC_COMMIT_END;
    public static final ReactMarkerConstants FABRIC_COMMIT_START;
    public static final ReactMarkerConstants FABRIC_DIFF_END;
    public static final ReactMarkerConstants FABRIC_DIFF_START;
    public static final ReactMarkerConstants FABRIC_FINISH_TRANSACTION_END;
    public static final ReactMarkerConstants FABRIC_FINISH_TRANSACTION_START;
    public static final ReactMarkerConstants FABRIC_LAYOUT_AFFECTED_NODES;
    public static final ReactMarkerConstants FABRIC_LAYOUT_END;
    public static final ReactMarkerConstants FABRIC_LAYOUT_START;
    public static final ReactMarkerConstants FABRIC_UPDATE_UI_MAIN_THREAD_END;
    public static final ReactMarkerConstants FABRIC_UPDATE_UI_MAIN_THREAD_START;
    public static final ReactMarkerConstants GET_CONSTANTS_END;
    public static final ReactMarkerConstants GET_CONSTANTS_START;
    public static final ReactMarkerConstants GET_REACT_INSTANCE_HOLDER_SPEC_END;
    public static final ReactMarkerConstants GET_REACT_INSTANCE_HOLDER_SPEC_START;
    public static final ReactMarkerConstants GET_REACT_INSTANCE_MANAGER_END;
    public static final ReactMarkerConstants GET_REACT_INSTANCE_MANAGER_START;
    public static final ReactMarkerConstants I18N_MODULE_CONSTANTS_CONVERT_END;
    public static final ReactMarkerConstants I18N_MODULE_CONSTANTS_CONVERT_START;
    public static final ReactMarkerConstants INITIALIZE_MODULE_END;
    public static final ReactMarkerConstants INITIALIZE_MODULE_START;
    public static final ReactMarkerConstants JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END;
    public static final ReactMarkerConstants JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START;
    public static final ReactMarkerConstants LOAD_REACT_NATIVE_FABRIC_SO_FILE_END;
    public static final ReactMarkerConstants LOAD_REACT_NATIVE_FABRIC_SO_FILE_START;
    public static final ReactMarkerConstants LOAD_REACT_NATIVE_SO_FILE_END;
    public static final ReactMarkerConstants LOAD_REACT_NATIVE_SO_FILE_START;
    public static final ReactMarkerConstants NATIVE_MODULE_INITIALIZE_END;
    public static final ReactMarkerConstants NATIVE_MODULE_INITIALIZE_START;
    public static final ReactMarkerConstants ON_FRAGMENT_CREATE;
    public static final ReactMarkerConstants ON_HOST_PAUSE_END;
    public static final ReactMarkerConstants ON_HOST_PAUSE_START;
    public static final ReactMarkerConstants ON_HOST_RESUME_END;
    public static final ReactMarkerConstants ON_HOST_RESUME_START;
    public static final ReactMarkerConstants ON_USER_LEAVE_HINT_END;
    public static final ReactMarkerConstants ON_USER_LEAVE_HINT_START;
    public static final ReactMarkerConstants PRE_REACT_CONTEXT_END;
    public static final ReactMarkerConstants PRE_RUN_JS_BUNDLE_START;
    public static final ReactMarkerConstants PRE_SETUP_REACT_CONTEXT_END;
    public static final ReactMarkerConstants PRE_SETUP_REACT_CONTEXT_START;
    public static final ReactMarkerConstants PROCESS_CORE_REACT_PACKAGE_END;
    public static final ReactMarkerConstants PROCESS_CORE_REACT_PACKAGE_START;
    public static final ReactMarkerConstants PROCESS_INFRA_PACKAGE_END;
    public static final ReactMarkerConstants PROCESS_INFRA_PACKAGE_START;
    public static final ReactMarkerConstants PROCESS_PACKAGES_END;
    public static final ReactMarkerConstants PROCESS_PACKAGES_START;
    public static final ReactMarkerConstants PROCESS_PRODUCT_PACKAGE_END;
    public static final ReactMarkerConstants PROCESS_PRODUCT_PACKAGE_START;
    public static final ReactMarkerConstants REACT_BRIDGELESS_LOADING_END;
    public static final ReactMarkerConstants REACT_BRIDGELESS_LOADING_START;
    public static final ReactMarkerConstants REACT_BRIDGE_LOADING_END;
    public static final ReactMarkerConstants REACT_BRIDGE_LOADING_START;
    public static final ReactMarkerConstants REACT_CONTEXT_THREAD_END;
    public static final ReactMarkerConstants REACT_CONTEXT_THREAD_START;
    public static final ReactMarkerConstants RELOAD;
    public static final ReactMarkerConstants ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END;
    public static final ReactMarkerConstants ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START;
    public static final ReactMarkerConstants ROOT_VIEW_ON_MEASURE_END;
    public static final ReactMarkerConstants ROOT_VIEW_ON_MEASURE_START;
    public static final ReactMarkerConstants ROOT_VIEW_UPDATE_LAYOUT_SPECS_END;
    public static final ReactMarkerConstants ROOT_VIEW_UPDATE_LAYOUT_SPECS_START;
    public static final ReactMarkerConstants SETUP_REACT_CONTEXT_END;
    public static final ReactMarkerConstants SETUP_REACT_CONTEXT_START;
    public static final ReactMarkerConstants UNPACKING_JS_BUNDLE_LOADER_BLOCKED;
    public static final ReactMarkerConstants UNPACKING_JS_BUNDLE_LOADER_CHECK_END;
    public static final ReactMarkerConstants UNPACKING_JS_BUNDLE_LOADER_CHECK_START;
    public static final ReactMarkerConstants UNPACKING_JS_BUNDLE_LOADER_EXTRACTED;
    public static final ReactMarkerConstants VM_INIT;
    private final boolean hasMatchingNameMarker;
    public static final ReactMarkerConstants APP_STARTUP_START = new ReactMarkerConstants("APP_STARTUP_START", 0, true);
    public static final ReactMarkerConstants APP_STARTUP_END = new ReactMarkerConstants("APP_STARTUP_END", 1, true);
    public static final ReactMarkerConstants CREATE_REACT_CONTEXT_END = new ReactMarkerConstants("CREATE_REACT_CONTEXT_END", 3, true);
    public static final ReactMarkerConstants INIT_REACT_RUNTIME_START = new ReactMarkerConstants("INIT_REACT_RUNTIME_START", 4, true);
    public static final ReactMarkerConstants INIT_REACT_RUNTIME_END = new ReactMarkerConstants("INIT_REACT_RUNTIME_END", 5, true);
    public static final ReactMarkerConstants RUN_JS_BUNDLE_START = new ReactMarkerConstants("RUN_JS_BUNDLE_START", 14, true);
    public static final ReactMarkerConstants RUN_JS_BUNDLE_END = new ReactMarkerConstants("RUN_JS_BUNDLE_END", 15, true);
    public static final ReactMarkerConstants NATIVE_MODULE_SETUP_START = new ReactMarkerConstants("NATIVE_MODULE_SETUP_START", 27, true);
    public static final ReactMarkerConstants NATIVE_MODULE_SETUP_END = new ReactMarkerConstants("NATIVE_MODULE_SETUP_END", 28, true);
    public static final ReactMarkerConstants loadApplicationScript_startStringConvert = new ReactMarkerConstants("loadApplicationScript_startStringConvert", 54, true);
    public static final ReactMarkerConstants loadApplicationScript_endStringConvert = new ReactMarkerConstants("loadApplicationScript_endStringConvert", 55, true);
    public static final ReactMarkerConstants REGISTER_JS_SEGMENT_START = new ReactMarkerConstants("REGISTER_JS_SEGMENT_START", 81, true);
    public static final ReactMarkerConstants REGISTER_JS_SEGMENT_STOP = new ReactMarkerConstants("REGISTER_JS_SEGMENT_STOP", 82, true);

    private static final /* synthetic */ ReactMarkerConstants[] $values() {
        return new ReactMarkerConstants[]{APP_STARTUP_START, APP_STARTUP_END, CREATE_REACT_CONTEXT_START, CREATE_REACT_CONTEXT_END, INIT_REACT_RUNTIME_START, INIT_REACT_RUNTIME_END, PROCESS_PACKAGES_START, PROCESS_PACKAGES_END, BUILD_NATIVE_MODULE_REGISTRY_START, BUILD_NATIVE_MODULE_REGISTRY_END, CREATE_CATALYST_INSTANCE_START, CREATE_CATALYST_INSTANCE_END, DESTROY_CATALYST_INSTANCE_START, DESTROY_CATALYST_INSTANCE_END, RUN_JS_BUNDLE_START, RUN_JS_BUNDLE_END, NATIVE_MODULE_INITIALIZE_START, NATIVE_MODULE_INITIALIZE_END, SETUP_REACT_CONTEXT_START, SETUP_REACT_CONTEXT_END, CHANGE_THREAD_PRIORITY, CREATE_UI_MANAGER_MODULE_START, CREATE_UI_MANAGER_MODULE_END, CREATE_VIEW_MANAGERS_START, CREATE_VIEW_MANAGERS_END, CREATE_UI_MANAGER_MODULE_CONSTANTS_START, CREATE_UI_MANAGER_MODULE_CONSTANTS_END, NATIVE_MODULE_SETUP_START, NATIVE_MODULE_SETUP_END, CREATE_MODULE_START, CREATE_MODULE_END, PROCESS_CORE_REACT_PACKAGE_START, PROCESS_CORE_REACT_PACKAGE_END, CREATE_I18N_MODULE_CONSTANTS_START, CREATE_I18N_MODULE_CONSTANTS_END, I18N_MODULE_CONSTANTS_CONVERT_START, I18N_MODULE_CONSTANTS_CONVERT_END, GET_CONSTANTS_START, GET_CONSTANTS_END, INITIALIZE_MODULE_START, INITIALIZE_MODULE_END, ON_HOST_RESUME_START, ON_HOST_RESUME_END, ON_USER_LEAVE_HINT_START, ON_USER_LEAVE_HINT_END, ON_HOST_PAUSE_START, ON_HOST_PAUSE_END, CONVERT_CONSTANTS_START, CONVERT_CONSTANTS_END, PRE_REACT_CONTEXT_END, UNPACKING_JS_BUNDLE_LOADER_CHECK_START, UNPACKING_JS_BUNDLE_LOADER_CHECK_END, UNPACKING_JS_BUNDLE_LOADER_EXTRACTED, UNPACKING_JS_BUNDLE_LOADER_BLOCKED, loadApplicationScript_startStringConvert, loadApplicationScript_endStringConvert, PRE_SETUP_REACT_CONTEXT_START, PRE_SETUP_REACT_CONTEXT_END, PRE_RUN_JS_BUNDLE_START, ATTACH_MEASURED_ROOT_VIEWS_START, ATTACH_MEASURED_ROOT_VIEWS_END, CONTENT_APPEARED, RELOAD, DOWNLOAD_START, DOWNLOAD_END, REACT_CONTEXT_THREAD_START, REACT_CONTEXT_THREAD_END, GET_REACT_INSTANCE_MANAGER_START, GET_REACT_INSTANCE_MANAGER_END, GET_REACT_INSTANCE_HOLDER_SPEC_START, GET_REACT_INSTANCE_HOLDER_SPEC_END, BUILD_REACT_INSTANCE_MANAGER_START, BUILD_REACT_INSTANCE_MANAGER_END, PROCESS_INFRA_PACKAGE_START, PROCESS_INFRA_PACKAGE_END, PROCESS_PRODUCT_PACKAGE_START, PROCESS_PRODUCT_PACKAGE_END, CREATE_MC_MODULE_START, CREATE_MC_MODULE_END, CREATE_MC_MODULE_GET_METADATA_START, CREATE_MC_MODULE_GET_METADATA_END, REGISTER_JS_SEGMENT_START, REGISTER_JS_SEGMENT_STOP, VM_INIT, ON_FRAGMENT_CREATE, JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START, JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END, LOAD_REACT_NATIVE_SO_FILE_START, LOAD_REACT_NATIVE_SO_FILE_END, ROOT_VIEW_ON_MEASURE_START, ROOT_VIEW_ON_MEASURE_END, ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START, ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END, ROOT_VIEW_UPDATE_LAYOUT_SPECS_START, ROOT_VIEW_UPDATE_LAYOUT_SPECS_END, LOAD_REACT_NATIVE_FABRIC_SO_FILE_START, LOAD_REACT_NATIVE_FABRIC_SO_FILE_END, FABRIC_COMMIT_START, FABRIC_COMMIT_END, FABRIC_FINISH_TRANSACTION_START, FABRIC_FINISH_TRANSACTION_END, FABRIC_DIFF_START, FABRIC_DIFF_END, FABRIC_LAYOUT_START, FABRIC_LAYOUT_END, FABRIC_LAYOUT_AFFECTED_NODES, FABRIC_BATCH_EXECUTION_START, FABRIC_BATCH_EXECUTION_END, FABRIC_UPDATE_UI_MAIN_THREAD_START, FABRIC_UPDATE_UI_MAIN_THREAD_END, REACT_BRIDGE_LOADING_START, REACT_BRIDGE_LOADING_END, REACT_BRIDGELESS_LOADING_START, REACT_BRIDGELESS_LOADING_END};
    }

    @NotNull
    public static EnumEntries<ReactMarkerConstants> getEntries() {
        return $ENTRIES;
    }

    private ReactMarkerConstants(String str, int i, boolean z) {
        this.hasMatchingNameMarker = z;
    }

    /* synthetic */ ReactMarkerConstants(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 1) != 0 ? false : z);
    }

    @JvmName(name = "hasMatchingNameMarker")
    /* renamed from: hasMatchingNameMarker, reason: from getter */
    public final boolean getHasMatchingNameMarker() {
        return this.hasMatchingNameMarker;
    }

    static {
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z = false;
        CREATE_REACT_CONTEXT_START = new ReactMarkerConstants("CREATE_REACT_CONTEXT_START", 2, z, i, defaultConstructorMarker);
        PROCESS_PACKAGES_START = new ReactMarkerConstants("PROCESS_PACKAGES_START", 6, z, i, defaultConstructorMarker);
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z2 = false;
        PROCESS_PACKAGES_END = new ReactMarkerConstants("PROCESS_PACKAGES_END", 7, z2, i2, defaultConstructorMarker2);
        BUILD_NATIVE_MODULE_REGISTRY_START = new ReactMarkerConstants("BUILD_NATIVE_MODULE_REGISTRY_START", 8, z, i, defaultConstructorMarker);
        BUILD_NATIVE_MODULE_REGISTRY_END = new ReactMarkerConstants("BUILD_NATIVE_MODULE_REGISTRY_END", 9, z2, i2, defaultConstructorMarker2);
        CREATE_CATALYST_INSTANCE_START = new ReactMarkerConstants("CREATE_CATALYST_INSTANCE_START", 10, z, i, defaultConstructorMarker);
        CREATE_CATALYST_INSTANCE_END = new ReactMarkerConstants("CREATE_CATALYST_INSTANCE_END", 11, z2, i2, defaultConstructorMarker2);
        DESTROY_CATALYST_INSTANCE_START = new ReactMarkerConstants("DESTROY_CATALYST_INSTANCE_START", 12, z, i, defaultConstructorMarker);
        DESTROY_CATALYST_INSTANCE_END = new ReactMarkerConstants("DESTROY_CATALYST_INSTANCE_END", 13, z2, i2, defaultConstructorMarker2);
        NATIVE_MODULE_INITIALIZE_START = new ReactMarkerConstants("NATIVE_MODULE_INITIALIZE_START", 16, z, i, defaultConstructorMarker);
        NATIVE_MODULE_INITIALIZE_END = new ReactMarkerConstants("NATIVE_MODULE_INITIALIZE_END", 17, z2, i2, defaultConstructorMarker2);
        SETUP_REACT_CONTEXT_START = new ReactMarkerConstants("SETUP_REACT_CONTEXT_START", 18, z, i, defaultConstructorMarker);
        SETUP_REACT_CONTEXT_END = new ReactMarkerConstants("SETUP_REACT_CONTEXT_END", 19, z2, i2, defaultConstructorMarker2);
        CHANGE_THREAD_PRIORITY = new ReactMarkerConstants("CHANGE_THREAD_PRIORITY", 20, z, i, defaultConstructorMarker);
        CREATE_UI_MANAGER_MODULE_START = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_START", 21, z2, i2, defaultConstructorMarker2);
        CREATE_UI_MANAGER_MODULE_END = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_END", 22, z, i, defaultConstructorMarker);
        CREATE_VIEW_MANAGERS_START = new ReactMarkerConstants("CREATE_VIEW_MANAGERS_START", 23, z2, i2, defaultConstructorMarker2);
        CREATE_VIEW_MANAGERS_END = new ReactMarkerConstants("CREATE_VIEW_MANAGERS_END", 24, z, i, defaultConstructorMarker);
        CREATE_UI_MANAGER_MODULE_CONSTANTS_START = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_CONSTANTS_START", 25, z2, i2, defaultConstructorMarker2);
        CREATE_UI_MANAGER_MODULE_CONSTANTS_END = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_CONSTANTS_END", 26, z, i, defaultConstructorMarker);
        CREATE_MODULE_START = new ReactMarkerConstants("CREATE_MODULE_START", 29, z, i, defaultConstructorMarker);
        CREATE_MODULE_END = new ReactMarkerConstants("CREATE_MODULE_END", 30, z2, i2, defaultConstructorMarker2);
        PROCESS_CORE_REACT_PACKAGE_START = new ReactMarkerConstants("PROCESS_CORE_REACT_PACKAGE_START", 31, z, i, defaultConstructorMarker);
        PROCESS_CORE_REACT_PACKAGE_END = new ReactMarkerConstants("PROCESS_CORE_REACT_PACKAGE_END", 32, z2, i2, defaultConstructorMarker2);
        CREATE_I18N_MODULE_CONSTANTS_START = new ReactMarkerConstants("CREATE_I18N_MODULE_CONSTANTS_START", 33, z, i, defaultConstructorMarker);
        CREATE_I18N_MODULE_CONSTANTS_END = new ReactMarkerConstants("CREATE_I18N_MODULE_CONSTANTS_END", 34, z2, i2, defaultConstructorMarker2);
        I18N_MODULE_CONSTANTS_CONVERT_START = new ReactMarkerConstants("I18N_MODULE_CONSTANTS_CONVERT_START", 35, z, i, defaultConstructorMarker);
        I18N_MODULE_CONSTANTS_CONVERT_END = new ReactMarkerConstants("I18N_MODULE_CONSTANTS_CONVERT_END", 36, z2, i2, defaultConstructorMarker2);
        GET_CONSTANTS_START = new ReactMarkerConstants("GET_CONSTANTS_START", 37, z, i, defaultConstructorMarker);
        GET_CONSTANTS_END = new ReactMarkerConstants("GET_CONSTANTS_END", 38, z2, i2, defaultConstructorMarker2);
        INITIALIZE_MODULE_START = new ReactMarkerConstants("INITIALIZE_MODULE_START", 39, z, i, defaultConstructorMarker);
        INITIALIZE_MODULE_END = new ReactMarkerConstants("INITIALIZE_MODULE_END", 40, z2, i2, defaultConstructorMarker2);
        ON_HOST_RESUME_START = new ReactMarkerConstants("ON_HOST_RESUME_START", 41, z, i, defaultConstructorMarker);
        ON_HOST_RESUME_END = new ReactMarkerConstants("ON_HOST_RESUME_END", 42, z2, i2, defaultConstructorMarker2);
        ON_USER_LEAVE_HINT_START = new ReactMarkerConstants("ON_USER_LEAVE_HINT_START", 43, z, i, defaultConstructorMarker);
        ON_USER_LEAVE_HINT_END = new ReactMarkerConstants("ON_USER_LEAVE_HINT_END", 44, z2, i2, defaultConstructorMarker2);
        ON_HOST_PAUSE_START = new ReactMarkerConstants("ON_HOST_PAUSE_START", 45, z, i, defaultConstructorMarker);
        ON_HOST_PAUSE_END = new ReactMarkerConstants("ON_HOST_PAUSE_END", 46, z2, i2, defaultConstructorMarker2);
        CONVERT_CONSTANTS_START = new ReactMarkerConstants("CONVERT_CONSTANTS_START", 47, z, i, defaultConstructorMarker);
        CONVERT_CONSTANTS_END = new ReactMarkerConstants("CONVERT_CONSTANTS_END", 48, z2, i2, defaultConstructorMarker2);
        PRE_REACT_CONTEXT_END = new ReactMarkerConstants("PRE_REACT_CONTEXT_END", 49, z, i, defaultConstructorMarker);
        UNPACKING_JS_BUNDLE_LOADER_CHECK_START = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_CHECK_START", 50, z2, i2, defaultConstructorMarker2);
        UNPACKING_JS_BUNDLE_LOADER_CHECK_END = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_CHECK_END", 51, z, i, defaultConstructorMarker);
        UNPACKING_JS_BUNDLE_LOADER_EXTRACTED = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_EXTRACTED", 52, z2, i2, defaultConstructorMarker2);
        UNPACKING_JS_BUNDLE_LOADER_BLOCKED = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_BLOCKED", 53, z, i, defaultConstructorMarker);
        PRE_SETUP_REACT_CONTEXT_START = new ReactMarkerConstants("PRE_SETUP_REACT_CONTEXT_START", 56, z, i, defaultConstructorMarker);
        PRE_SETUP_REACT_CONTEXT_END = new ReactMarkerConstants("PRE_SETUP_REACT_CONTEXT_END", 57, z2, i2, defaultConstructorMarker2);
        PRE_RUN_JS_BUNDLE_START = new ReactMarkerConstants("PRE_RUN_JS_BUNDLE_START", 58, z, i, defaultConstructorMarker);
        ATTACH_MEASURED_ROOT_VIEWS_START = new ReactMarkerConstants("ATTACH_MEASURED_ROOT_VIEWS_START", 59, z2, i2, defaultConstructorMarker2);
        ATTACH_MEASURED_ROOT_VIEWS_END = new ReactMarkerConstants("ATTACH_MEASURED_ROOT_VIEWS_END", 60, z, i, defaultConstructorMarker);
        CONTENT_APPEARED = new ReactMarkerConstants("CONTENT_APPEARED", 61, z2, i2, defaultConstructorMarker2);
        RELOAD = new ReactMarkerConstants("RELOAD", 62, z, i, defaultConstructorMarker);
        DOWNLOAD_START = new ReactMarkerConstants("DOWNLOAD_START", 63, z2, i2, defaultConstructorMarker2);
        DOWNLOAD_END = new ReactMarkerConstants("DOWNLOAD_END", 64, z, i, defaultConstructorMarker);
        REACT_CONTEXT_THREAD_START = new ReactMarkerConstants("REACT_CONTEXT_THREAD_START", 65, z2, i2, defaultConstructorMarker2);
        REACT_CONTEXT_THREAD_END = new ReactMarkerConstants("REACT_CONTEXT_THREAD_END", 66, z, i, defaultConstructorMarker);
        GET_REACT_INSTANCE_MANAGER_START = new ReactMarkerConstants("GET_REACT_INSTANCE_MANAGER_START", 67, z2, i2, defaultConstructorMarker2);
        GET_REACT_INSTANCE_MANAGER_END = new ReactMarkerConstants("GET_REACT_INSTANCE_MANAGER_END", 68, z, i, defaultConstructorMarker);
        GET_REACT_INSTANCE_HOLDER_SPEC_START = new ReactMarkerConstants("GET_REACT_INSTANCE_HOLDER_SPEC_START", 69, z2, i2, defaultConstructorMarker2);
        GET_REACT_INSTANCE_HOLDER_SPEC_END = new ReactMarkerConstants("GET_REACT_INSTANCE_HOLDER_SPEC_END", 70, z, i, defaultConstructorMarker);
        BUILD_REACT_INSTANCE_MANAGER_START = new ReactMarkerConstants("BUILD_REACT_INSTANCE_MANAGER_START", 71, z2, i2, defaultConstructorMarker2);
        BUILD_REACT_INSTANCE_MANAGER_END = new ReactMarkerConstants("BUILD_REACT_INSTANCE_MANAGER_END", 72, z, i, defaultConstructorMarker);
        PROCESS_INFRA_PACKAGE_START = new ReactMarkerConstants("PROCESS_INFRA_PACKAGE_START", 73, z2, i2, defaultConstructorMarker2);
        PROCESS_INFRA_PACKAGE_END = new ReactMarkerConstants("PROCESS_INFRA_PACKAGE_END", 74, z, i, defaultConstructorMarker);
        PROCESS_PRODUCT_PACKAGE_START = new ReactMarkerConstants("PROCESS_PRODUCT_PACKAGE_START", 75, z2, i2, defaultConstructorMarker2);
        PROCESS_PRODUCT_PACKAGE_END = new ReactMarkerConstants("PROCESS_PRODUCT_PACKAGE_END", 76, z, i, defaultConstructorMarker);
        CREATE_MC_MODULE_START = new ReactMarkerConstants("CREATE_MC_MODULE_START", 77, z2, i2, defaultConstructorMarker2);
        CREATE_MC_MODULE_END = new ReactMarkerConstants("CREATE_MC_MODULE_END", 78, z, i, defaultConstructorMarker);
        CREATE_MC_MODULE_GET_METADATA_START = new ReactMarkerConstants("CREATE_MC_MODULE_GET_METADATA_START", 79, z2, i2, defaultConstructorMarker2);
        CREATE_MC_MODULE_GET_METADATA_END = new ReactMarkerConstants("CREATE_MC_MODULE_GET_METADATA_END", 80, z, i, defaultConstructorMarker);
        VM_INIT = new ReactMarkerConstants("VM_INIT", 83, z, i, defaultConstructorMarker);
        ON_FRAGMENT_CREATE = new ReactMarkerConstants("ON_FRAGMENT_CREATE", 84, z2, i2, defaultConstructorMarker2);
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        boolean z3 = false;
        JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START = new ReactMarkerConstants("JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START", 85, z3, i3, defaultConstructorMarker3);
        int i4 = 1;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        boolean z4 = false;
        JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END = new ReactMarkerConstants("JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END", 86, z4, i4, defaultConstructorMarker4);
        LOAD_REACT_NATIVE_SO_FILE_START = new ReactMarkerConstants("LOAD_REACT_NATIVE_SO_FILE_START", 87, z3, i3, defaultConstructorMarker3);
        LOAD_REACT_NATIVE_SO_FILE_END = new ReactMarkerConstants("LOAD_REACT_NATIVE_SO_FILE_END", 88, z4, i4, defaultConstructorMarker4);
        ROOT_VIEW_ON_MEASURE_START = new ReactMarkerConstants("ROOT_VIEW_ON_MEASURE_START", 89, z3, i3, defaultConstructorMarker3);
        ROOT_VIEW_ON_MEASURE_END = new ReactMarkerConstants("ROOT_VIEW_ON_MEASURE_END", 90, z4, i4, defaultConstructorMarker4);
        ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START = new ReactMarkerConstants("ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START", 91, z3, i3, defaultConstructorMarker3);
        ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END = new ReactMarkerConstants("ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END", 92, z4, i4, defaultConstructorMarker4);
        ROOT_VIEW_UPDATE_LAYOUT_SPECS_START = new ReactMarkerConstants("ROOT_VIEW_UPDATE_LAYOUT_SPECS_START", 93, z3, i3, defaultConstructorMarker3);
        ROOT_VIEW_UPDATE_LAYOUT_SPECS_END = new ReactMarkerConstants("ROOT_VIEW_UPDATE_LAYOUT_SPECS_END", 94, z4, i4, defaultConstructorMarker4);
        LOAD_REACT_NATIVE_FABRIC_SO_FILE_START = new ReactMarkerConstants("LOAD_REACT_NATIVE_FABRIC_SO_FILE_START", 95, z3, i3, defaultConstructorMarker3);
        LOAD_REACT_NATIVE_FABRIC_SO_FILE_END = new ReactMarkerConstants("LOAD_REACT_NATIVE_FABRIC_SO_FILE_END", 96, z4, i4, defaultConstructorMarker4);
        FABRIC_COMMIT_START = new ReactMarkerConstants("FABRIC_COMMIT_START", 97, z3, i3, defaultConstructorMarker3);
        FABRIC_COMMIT_END = new ReactMarkerConstants("FABRIC_COMMIT_END", 98, z4, i4, defaultConstructorMarker4);
        FABRIC_FINISH_TRANSACTION_START = new ReactMarkerConstants("FABRIC_FINISH_TRANSACTION_START", 99, z3, i3, defaultConstructorMarker3);
        FABRIC_FINISH_TRANSACTION_END = new ReactMarkerConstants("FABRIC_FINISH_TRANSACTION_END", 100, z4, i4, defaultConstructorMarker4);
        FABRIC_DIFF_START = new ReactMarkerConstants("FABRIC_DIFF_START", 101, z3, i3, defaultConstructorMarker3);
        FABRIC_DIFF_END = new ReactMarkerConstants("FABRIC_DIFF_END", 102, z4, i4, defaultConstructorMarker4);
        FABRIC_LAYOUT_START = new ReactMarkerConstants("FABRIC_LAYOUT_START", PublicKeyAlgorithmTags.EXPERIMENTAL_4, z3, i3, defaultConstructorMarker3);
        FABRIC_LAYOUT_END = new ReactMarkerConstants("FABRIC_LAYOUT_END", 104, z4, i4, defaultConstructorMarker4);
        FABRIC_LAYOUT_AFFECTED_NODES = new ReactMarkerConstants("FABRIC_LAYOUT_AFFECTED_NODES", 105, z3, i3, defaultConstructorMarker3);
        FABRIC_BATCH_EXECUTION_START = new ReactMarkerConstants("FABRIC_BATCH_EXECUTION_START", PublicKeyAlgorithmTags.EXPERIMENTAL_7, z4, i4, defaultConstructorMarker4);
        FABRIC_BATCH_EXECUTION_END = new ReactMarkerConstants("FABRIC_BATCH_EXECUTION_END", PublicKeyAlgorithmTags.EXPERIMENTAL_8, z3, i3, defaultConstructorMarker3);
        FABRIC_UPDATE_UI_MAIN_THREAD_START = new ReactMarkerConstants("FABRIC_UPDATE_UI_MAIN_THREAD_START", 108, z4, i4, defaultConstructorMarker4);
        FABRIC_UPDATE_UI_MAIN_THREAD_END = new ReactMarkerConstants("FABRIC_UPDATE_UI_MAIN_THREAD_END", 109, z3, i3, defaultConstructorMarker3);
        REACT_BRIDGE_LOADING_START = new ReactMarkerConstants("REACT_BRIDGE_LOADING_START", PublicKeyAlgorithmTags.EXPERIMENTAL_11, z4, i4, defaultConstructorMarker4);
        REACT_BRIDGE_LOADING_END = new ReactMarkerConstants("REACT_BRIDGE_LOADING_END", 111, z3, i3, defaultConstructorMarker3);
        REACT_BRIDGELESS_LOADING_START = new ReactMarkerConstants("REACT_BRIDGELESS_LOADING_START", SyslogConstants.LOG_ALERT, z4, i4, defaultConstructorMarker4);
        REACT_BRIDGELESS_LOADING_END = new ReactMarkerConstants("REACT_BRIDGELESS_LOADING_END", 113, z3, i3, defaultConstructorMarker3);
        ReactMarkerConstants[] reactMarkerConstantsArr$values = $values();
        $VALUES = reactMarkerConstantsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(reactMarkerConstantsArr$values);
    }

    public static ReactMarkerConstants valueOf(String str) {
        return (ReactMarkerConstants) Enum.valueOf(ReactMarkerConstants.class, str);
    }

    public static ReactMarkerConstants[] values() {
        return (ReactMarkerConstants[]) $VALUES.clone();
    }
}
