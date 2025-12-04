package com.disney.id.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.disney.id.android.LookupValue;
import com.disney.id.android.SCALPController;
import com.disney.id.android.Session;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.dagger.OneIDComponent;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.extensions.EditableFieldExtensionsKt;
import com.disney.id.android.extensions.JSONExtensionsKt;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.LightboxWebView;
import com.disney.id.android.lightbox.OneIDWebViewFactory;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.GCService;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.disney.id.android.utils.ActivityFlagParser;
import com.disney.id.android.validation.PasswordValidation;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.util.Attributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.picocontainer.Characteristics;

@Metadata(d1 = {"\u0000ô\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u009e\u00022\u00020\u0001:\f\u009e\u0002\u009f\u0002 \u0002¡\u0002¢\u0002£\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u008a\u0001\u001a\u00030\u008b\u00012\f\b\u0002\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u0016\u0010\u008e\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0005\u0012\u00030\u008b\u00010\u008f\u0001H\u0002J<\u0010\u0091\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J@\u0010\u0099\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\f\b\u0002\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J(\u0010\u009c\u0001\u001a\u00030\u009d\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0000¢\u0006\u0003\b \u0001J\u001d\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010¢\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0002JH\u0010¦\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001c2\u000f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010¨\u00012\u0016\u0010©\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0005\u0012\u00030\u008b\u00010\u008f\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0003J\u0011\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00010¢\u0001H\u0003J\n\u0010®\u0001\u001a\u00030\u0094\u0001H\u0003J(\u0010¯\u0001\u001a\u00030\u008b\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030°\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007JJ\u0010±\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\n\b\u0002\u0010²\u0001\u001a\u00030\u009f\u00012\n\b\u0002\u0010³\u0001\u001a\u00030\u009f\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\u0019\u0010±\u0001\u001a\u0005\u0018\u00010´\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010µ\u0001\u001a\u00030\u008b\u00012\b\u0010¶\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007JJ\u0010¸\u0001\u001a\u00030\u008b\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\n\b\u0002\u0010²\u0001\u001a\u00030\u009f\u00012\n\b\u0002\u0010³\u0001\u001a\u00030\u009f\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u001f\u0010¹\u0001\u001a\u00030º\u00012\b\u0010»\u0001\u001a\u00030¼\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u001b\u0010¹\u0001\u001a\u00030º\u00012\u000f\u0010¾\u0001\u001a\n\u0012\u0005\u0012\u00030¿\u00010¢\u0001H\u0003J2\u0010À\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Á\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010Â\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010Ã\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J/\u0010Å\u0001\u001a\u00030\u008b\u00012\b\u0010Ã\u0001\u001a\u00030\u0094\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Ä\u00010\u0096\u0001H\u0002J\u0011\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030Ç\u00010¢\u0001H\u0002J\u0011\u0010È\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010¢\u0001H\u0003J?\u0010È\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010¢\u00012\u000f\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010¢\u00012\b\u0010Ì\u0001\u001a\u00030\u009f\u00012\u0011\u0010Í\u0001\u001a\f\u0012\u0005\u0012\u00030Î\u0001\u0018\u00010¢\u0001H\u0002J+\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u009a\u0001\u001a\u00030\u0094\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\n\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0003J\u0011\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010¢\u0001H\u0003J2\u0010Õ\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010Ö\u0001\u001a\u00030\u0094\u0001J\n\u0010×\u0001\u001a\u0005\u0018\u00010Ë\u0001J4\u0010Ø\u0001\u001a\u00030\u008b\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010Ú\u0001\u001a\u00030\u009f\u0001H\u0007J\u001a\u0010Û\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0094\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010Ü\u0001H\u0007J\u001b\u0010Û\u0001\u001a\u00030\u008b\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030Ý\u00010\u0096\u0001H\u0007J,\u0010Þ\u0001\u001a\u00030\u009f\u00012\u000f\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010¢\u00012\u000f\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010¢\u0001H\u0002J\b\u0010ß\u0001\u001a\u00030\u009f\u0001J\b\u0010à\u0001\u001a\u00030\u009f\u0001J%\u0010á\u0001\u001a\u00030\u009f\u00012\u000f\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010¢\u00012\b\u0010â\u0001\u001a\u00030\u0094\u0001H\u0002J:\u0010ã\u0001\u001a\u00030\u009f\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010´\u00012\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\n\u0010ç\u0001\u001a\u0005\u0018\u00010\u0094\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J2\u0010ê\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030ë\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J>\u0010ì\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\n\u0010í\u0001\u001a\u0005\u0018\u00010\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0002J@\u0010î\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007Jl\u0010ï\u0001\u001a\u00030\u008b\u0001\"\n\b\u0000\u0010ð\u0001*\u00030\u0097\u00012\b\u0010ñ\u0001\u001a\u00030\u0090\u00012\b\u0010ò\u0001\u001a\u00030ó\u00012\u000b\b\u0002\u0010ô\u0001\u001a\u0004\u0018\u00010\u001c2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0011\u0010\u0095\u0001\u001a\f\u0012\u0005\u0012\u0003Hð\u0001\u0018\u00010\u0096\u00012\b\u0010è\u0001\u001a\u00030é\u00012\f\b\u0002\u0010õ\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0002J2\u0010ö\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010÷\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010ø\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030ù\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J(\u0010ú\u0001\u001a\u00030\u008b\u00012\b\u0010õ\u0001\u001a\u00030Ë\u00012\f\b\u0002\u0010û\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0000¢\u0006\u0003\bü\u0001J2\u0010ý\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030þ\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010ÿ\u0001\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J2\u0010\u0080\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u0081\u0002\u001a\u00030\u008b\u00012\b\u0010¶\u0001\u001a\u00030\u0094\u00012\b\u0010\u009a\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\u0017\u0010\u0082\u0002\u001a\u00030\u008b\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\n\u0010\u0083\u0002\u001a\u00030\u008b\u0001H\u0002Jm\u0010\u0084\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u000f\u0010\u0085\u0002\u001a\n\u0012\u0005\u0012\u00030Ô\u00010¢\u00012\u0013\b\u0002\u0010\u0086\u0002\u001a\f\u0012\u0005\u0012\u00030É\u0001\u0018\u00010¢\u00012\u0013\b\u0002\u0010\u0087\u0002\u001a\f\u0012\u0005\u0012\u00030Ç\u0001\u0018\u00010¢\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\u0014\u0010\u0088\u0002\u001a\u00030\u008b\u00012\b\u0010\u0089\u0002\u001a\u00030\u0094\u0001H\u0002JC\u0010\u008a\u0002\u001a\u0005\u0018\u0001Hð\u0001\"\u0005\b\u0000\u0010ð\u00012\u000f\u0010\u008b\u0002\u001a\n\u0012\u0005\u0012\u0003Hð\u00010\u008c\u00022\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\b\u0002\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0000¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002JK\u0010\u008f\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\u0013\b\u0002\u0010\u0090\u0002\u001a\f\u0012\u0005\u0012\u00030¿\u0001\u0018\u00010¢\u00012\u0013\b\u0002\u0010\u0095\u0001\u001a\f\u0012\u0005\u0012\u00030\u009b\u0001\u0018\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J6\u0010\u0091\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0002\u001a\u00030\u0093\u00022\u0013\b\u0002\u0010\u0095\u0001\u001a\f\u0012\u0005\u0012\u00030\u009b\u0001\u0018\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J=\u0010\u0091\u0002\u001a\u00030\u008b\u00012\u000f\u0010\u0085\u0002\u001a\n\u0012\u0005\u0012\u00030\u0094\u00020¢\u00012\u0013\b\u0002\u0010\u0095\u0001\u001a\f\u0012\u0005\u0012\u00030\u009b\u0001\u0018\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u0095\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u0096\u0002\u001a\u00030¼\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00020\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010\u0098\u0002\u001a\u00030\u008b\u00012\b\u0010\u0099\u0002\u001a\u00030\u009f\u0001H\u0000¢\u0006\u0003\b\u009a\u0002Jb\u0010\u009b\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u000f\u0010\u0086\u0002\u001a\n\u0012\u0005\u0012\u00030É\u00010¢\u00012\u0013\b\u0002\u0010\u0087\u0002\u001a\f\u0012\u0005\u0012\u00030Ç\u0001\u0018\u00010¢\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007J<\u0010\u009c\u0002\u001a\u00030\u008b\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u00012\b\u0010\u009d\u0002\u001a\u00030\u0094\u00012\u000f\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0097\u00010\u0096\u00012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001cH\u0007R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0002048\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\u001e\u0010D\u001a\u00020E8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010J\u001a\u00020K8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001e\u0010V\u001a\u00020W8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020]8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010b\u001a\u00020c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010h\u001a\u00020i8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001e\u0010n\u001a\u00020o8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0012\u0010t\u001a\u00060uR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010v\u001a\u00020w8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R \u0010|\u001a\u00020}8\u0000@\u0000X\u0081.¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R$\u0010\u0082\u0001\u001a\u00030\u0083\u00018\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0014\u0010\u0088\u0001\u001a\u00070\u0089\u0001R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0002"}, d2 = {"Lcom/disney/id/android/OneID;", "", "oneidComponent", "Lcom/disney/id/android/dagger/OneIDComponent;", "(Lcom/disney/id/android/dagger/OneIDComponent;)V", "bundler", "Lcom/disney/id/android/bundler/Bundler;", "getBundler$OneID_release", "()Lcom/disney/id/android/bundler/Bundler;", "setBundler$OneID_release", "(Lcom/disney/id/android/bundler/Bundler;)V", "config", "Lcom/disney/id/android/Config;", "getConfig", "()Lcom/disney/id/android/Config;", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "connectivity", "Lcom/disney/id/android/Connectivity;", "getConnectivity$OneID_release", "()Lcom/disney/id/android/Connectivity;", "setConnectivity$OneID_release", "(Lcom/disney/id/android/Connectivity;)V", "value", "Lcom/disney/id/android/OptionalConfigs;", "defaultOptions", "getDefaultOptions", "()Lcom/disney/id/android/OptionalConfigs;", "setDefaultOptions", "(Lcom/disney/id/android/OptionalConfigs;)V", "Lcom/disney/id/android/OneIDListener;", "delegate", "()Lcom/disney/id/android/OneIDListener;", "setDelegate", "(Lcom/disney/id/android/OneIDListener;)V", "gcService", "Lcom/disney/id/android/services/GCService;", "getGcService$OneID_release", "()Lcom/disney/id/android/services/GCService;", "setGcService$OneID_release", "(Lcom/disney/id/android/services/GCService;)V", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "headlessListenerHolder", "Lcom/disney/id/android/HeadlessListenerHolder;", "getHeadlessListenerHolder$OneID_release$annotations", "()V", "getHeadlessListenerHolder$OneID_release", "()Lcom/disney/id/android/HeadlessListenerHolder;", "setHeadlessListenerHolder$OneID_release", "(Lcom/disney/id/android/HeadlessListenerHolder;)V", "initializationCallbackHolder", "Lcom/disney/id/android/InitializationCallbackHolder;", "getInitializationCallbackHolder$OneID_release", "()Lcom/disney/id/android/InitializationCallbackHolder;", "setInitializationCallbackHolder$OneID_release", "(Lcom/disney/id/android/InitializationCallbackHolder;)V", "internalDefaultOptions", "getInternalDefaultOptions$OneID_release", "setInternalDefaultOptions$OneID_release", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "migrationHandler", "Lcom/disney/id/android/MigrationHandler;", "getMigrationHandler$OneID_release", "()Lcom/disney/id/android/MigrationHandler;", "setMigrationHandler$OneID_release", "(Lcom/disney/id/android/MigrationHandler;)V", "oneIDWebView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "getOneIDWebView$OneID_release", "()Lcom/disney/id/android/lightbox/LightboxWebView;", "setOneIDWebView$OneID_release", "(Lcom/disney/id/android/lightbox/LightboxWebView;)V", "oneIDWebViewFactory", "Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "getOneIDWebViewFactory$OneID_release", "()Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "setOneIDWebViewFactory$OneID_release", "(Lcom/disney/id/android/lightbox/OneIDWebViewFactory;)V", "oneIdStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getOneIdStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setOneIdStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "scalpBundleDownloader", "Lcom/disney/id/android/SCALPBundle;", "getScalpBundleDownloader$OneID_release", "()Lcom/disney/id/android/SCALPBundle;", "setScalpBundleDownloader$OneID_release", "(Lcom/disney/id/android/SCALPBundle;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", com.allegion.accesssdk.BuildConfig.SESSION_KEY_REFERENCE, "Lcom/disney/id/android/Session;", "getSession$OneID_release", "()Lcom/disney/id/android/Session;", "setSession$OneID_release", "(Lcom/disney/id/android/Session;)V", "sessionOwner", "Lcom/disney/id/android/OneID$OneIDSessionOwner;", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "webViewOwner", "Lcom/disney/id/android/OneID$OneIDWebViewOwner;", "appContext", "", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "block", "Lkotlin/Function1;", "Landroid/content/Context;", "beginRecoveryWithEmail", "activityContext", "email", "", "callback", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/OneIDCallbackData;", LightboxActivity.CONFIGS_EXTRA, "completeRecovery", HintConstants.AUTOFILL_HINT_PASSWORD, "Lcom/disney/id/android/GuestCallbackData;", "createAndLogMissingGuestError", "Lcom/disney/id/android/OneIDError;", "disableThrottling", "", "createAndLogMissingGuestError$OneID_release", "createPlainTextLinks", "", "Lcom/disney/id/android/PlainTextLink;", "jsonArray", "Lorg/json/JSONArray;", "ensureGuestHasEmailBefore", "success", "Lkotlin/Function0;", "failure", "getComplianceDetails", "Lcom/disney/id/android/ComplianceDetails;", "getCountries", "Lcom/disney/id/android/Country;", "getDefaultCountry", "getEditableProfileFields", "Lcom/disney/id/android/EditFieldsCallbackData;", "getGuest", "fullPayload", "forceRefresh", "Lcom/disney/id/android/Guest;", "getGuestFlow", "loginValue", "Lcom/disney/id/android/GuestFlowCallbackData;", "getGuestInternal", "getGuestUpdateBody", "Lcom/google/gson/JsonObject;", "newsletter", "Lcom/disney/id/android/NewsletterDetails;", "options", "ppus", "Lcom/disney/id/android/PPU;", "getIdentityFlowConfig", "Lcom/disney/id/android/IdentityConfigCallbackData;", "getInlineNewsletters", Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, "Lcom/disney/id/android/GetInlineNewslettersCallbackData;", "getInlineNewslettersHelper", "getLegalDetails", "Lcom/disney/id/android/LegalDetail;", "getMarketingDetails", "Lcom/disney/id/android/MarketingDetail;", "newslettersList", "Lorg/json/JSONObject;", "loggedIn", "guestMarketingArray", "Lcom/disney/id/android/Marketing;", "getPasswordScore", "Lcom/disney/id/android/PasswordScore;", "getRegisterConfig", "Lcom/disney/id/android/RegisterConfigCallbackData;", "getRegisterFields", "Lcom/disney/id/android/Field;", "getRegisterFlowConfig", "getSWID", "getSiteConfig", "getToken", "Lcom/disney/id/android/TokenCallbackData;", "serverUpdate", "getUNID", "", "Lcom/disney/id/android/UnidCallbackData;", "isAllOptedIn", "isLoggedIn", "isLowTrust", "isOptedIn", "newsletterName", "isSuccess", "guest", "newslettersResult", "Lcom/disney/id/android/NewslettersResult;", "emailVerificationErrorCode", "callbackType", "Lcom/disney/id/android/CallbackType;", "launchEmailVerification", "Lcom/disney/id/android/EmailVerificationCallbackData;", "launchExpiredSessionFlow", "guestEmail", "launchIdentityFlow", "launchLightbox", ExifInterface.GPS_DIRECTION_TRUE, "context", "page", "Lcom/disney/id/android/lightbox/LightboxWebView$LightboxPage;", "mergedOptionalConfigs", "params", "launchLogin", "launchNewsletters", "promotionId", "Lcom/disney/id/android/NewslettersCallbackData;", "launchPPU", "conversationId", "launchPPU$OneID_release", "launchProfile", "Lcom/disney/id/android/UpdateProfileCallbackData;", "launchReauth", "launchRegistration", FirebaseAnalytics.Event.LOGIN, WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "notifyIfMigrationFailed", "register", "fields", "marketing", "legal", "reloadGuest", "refreshToken", "resolveCallbackWeakReference", "weakRef", "Ljava/lang/ref/WeakReference;", "resolveCallbackWeakReference$OneID_release", "(Ljava/lang/ref/WeakReference;Lcom/disney/id/android/tracker/TrackerEventKey;Z)Ljava/lang/Object;", "resolvePPU", "resolvedPPUs", "setEditableProfileFields", "jsonProfile", "Lcom/google/gson/JsonElement;", "Lcom/disney/id/android/EditableField;", "setInlineNewsletters", "newsletterDetails", "Lcom/disney/id/android/SetInlineNewslettersCallbackData;", "startPeriodicWorker", "delay", "startPeriodicWorker$OneID_release", "updateMarketing", "validateOTP", "otp", "Companion", "Environment", "LogLevel", "OneIDSessionOwner", "OneIDWebViewOwner", "RefreshTokenCallback", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneID.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneID.kt\ncom/disney/id/android/OneID\n+ 2 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4484:1\n272#2:4485\n1#3:4486\n32#4,2:4487\n1855#5,2:4489\n*S KotlinDebug\n*F\n+ 1 OneID.kt\ncom/disney/id/android/OneID\n*L\n714#1:4485\n2527#1:4487,2\n3395#1:4489,2\n*E\n"})
/* loaded from: classes3.dex */
public final class OneID {

    @NotNull
    public static final String UNID = "unid";

    @NotNull
    public static final String UNID_DEPRECATED_REASON = "UNID Deprecated";

    @NotNull
    public static final String UNID_DEPRECATED_VALUE = "UNID Deprecated";

    @NotNull
    public static final String UNID_REASON = "unidReason";
    private static Context appContext = null;
    private static OneID instance = null;

    @NotNull
    public static final String version = "4.12.5";

    @Inject
    public Bundler bundler;

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public Connectivity connectivity;
    private OneIDListener delegate;

    @Inject
    public GCService gcService;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public HeadlessListenerHolder headlessListenerHolder;

    @Inject
    public InitializationCallbackHolder initializationCallbackHolder;
    private OptionalConfigs internalDefaultOptions;

    @Inject
    public Logger logger;

    @Inject
    public MigrationHandler migrationHandler;
    private LightboxWebView oneIDWebView;

    @Inject
    public OneIDWebViewFactory oneIDWebViewFactory;

    @Inject
    public ExposedStorage oneIdStorage;

    @Inject
    public SCALPBundle scalpBundleDownloader;

    @Inject
    public SCALPController scalpController;

    @Inject
    public Session session;
    private final OneIDSessionOwner sessionOwner;

    @Inject
    public LocalStorage storage;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private final OneIDWebViewOwner webViewOwner;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = OneID.class.getSimpleName();
    private static final Lazy configHandler$delegate = LazyKt.lazy(new Function0() { // from class: com.disney.id.android.OneID$Companion$configHandler$2
        @Override // kotlin.jvm.functions.Function0
        public final OneIDConfigHandler invoke() {
            return new OneIDConfigHandler();
        }
    });
    private static final CoroutineScope mainScope = CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final CoroutineScope defaultScope = CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/OneID$RefreshTokenCallback;", "", "onFailure", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "onSuccess", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface RefreshTokenCallback {
        void onFailure(@Nullable OneIDError error);

        void onSuccess();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallbackType.values().length];
            try {
                iArr[CallbackType.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallbackType.PPU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CallbackType.REGISTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CallbackType.EXPIRED_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CallbackType.PROFILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CallbackType.NEWSLETTERS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CallbackType.EMAIL_VERIFICATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    public static /* synthetic */ void getHeadlessListenerHolder$OneID_release$annotations() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void initialize(@NotNull Config config, @NotNull OneIDListener oneIDListener, @NotNull Context context) throws InterruptedException {
        INSTANCE.initialize(config, oneIDListener, context);
    }

    @JvmStatic
    @JvmOverloads
    public static final void initialize(@NotNull Config config, @NotNull OneIDListener oneIDListener, @NotNull Context context, @Nullable String str) throws InterruptedException {
        INSTANCE.initialize(config, oneIDListener, context, str);
    }

    @JvmStatic
    @JvmOverloads
    public static final void initialize(@NotNull Config config, @NotNull OneIDListener oneIDListener, @NotNull Context context, @Nullable String str, @Nullable OneIDStateCallback oneIDStateCallback) throws InterruptedException {
        INSTANCE.initialize(config, oneIDListener, context, str, oneIDStateCallback);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmStatic
    public static final void initialize(@NotNull Config config, @NotNull OneIDListener oneIDListener, @NotNull Context context, @Nullable String str, @Nullable OneIDStateCallback oneIDStateCallback, @Nullable OneIDHeadlessListener oneIDHeadlessListener) throws InterruptedException {
        INSTANCE.initialize(config, oneIDListener, context, str, oneIDStateCallback, oneIDHeadlessListener);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmStatic
    public static final void reinitializeWithGALC(@NotNull String str, @Nullable OneIDStateCallback oneIDStateCallback) throws NotInitialized, JSONException, InterruptedException {
        INSTANCE.reinitializeWithGALC(str, oneIDStateCallback);
    }

    @JvmStatic
    @NotNull
    public static final OneID shared() {
        return INSTANCE.shared();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void beginRecoveryWithEmail(@NotNull Context activityContext, @NotNull String email, @NotNull OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(callback, "callback");
        beginRecoveryWithEmail$default(this, activityContext, email, callback, null, 8, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void completeRecovery(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        completeRecovery$default(this, activityContext, null, callback, null, 10, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void completeRecovery(@NotNull Context activityContext, @Nullable String str, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        completeRecovery$default(this, activityContext, str, callback, null, 8, null);
    }

    @JvmOverloads
    public final void getEditableProfileFields(@NotNull OneIDCallback<EditFieldsCallbackData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getEditableProfileFields$default(this, callback, null, 2, null);
    }

    @JvmOverloads
    @Nullable
    public final Guest getGuest() {
        return getGuest$default(this, null, 1, null);
    }

    @JvmOverloads
    public final void getGuest(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getGuest$default(this, activityContext, callback, false, false, null, 28, null);
    }

    @JvmOverloads
    public final void getGuest(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, boolean z) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getGuest$default(this, activityContext, callback, z, false, null, 24, null);
    }

    @JvmOverloads
    public final void getGuest(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getGuest$default(this, activityContext, callback, z, z2, null, 16, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getGuestFlow(@NotNull String loginValue, @NotNull OneIDCallback<GuestFlowCallbackData> callback) {
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getGuestFlow$default(this, loginValue, callback, null, 4, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getIdentityFlowConfig(@NotNull Context activityContext, @NotNull OneIDCallback<IdentityConfigCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getIdentityFlowConfig$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void getInlineNewsletters(@NotNull Context activityContext, @NotNull String campaignId, @NotNull OneIDCallback<GetInlineNewslettersCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getInlineNewsletters$default(this, activityContext, campaignId, callback, null, 8, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    @NotNull
    public final PasswordScore getPasswordScore(@NotNull Context activityContext, @NotNull String password) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(password, "password");
        return getPasswordScore$default(this, activityContext, password, null, 4, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getRegisterFlowConfig(@NotNull Context activityContext, @NotNull OneIDCallback<RegisterConfigCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getRegisterFlowConfig$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void getToken(@NotNull OneIDCallback<TokenCallbackData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getToken$default(this, callback, null, false, 6, null);
    }

    @JvmOverloads
    public final void getToken(@NotNull OneIDCallback<TokenCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        getToken$default(this, callback, optionalConfigs, false, 4, null);
    }

    @JvmOverloads
    public final void launchEmailVerification(@NotNull Context activityContext, @NotNull OneIDCallback<EmailVerificationCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchEmailVerification$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void launchIdentityFlow(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchIdentityFlow$default(this, activityContext, null, callback, null, 10, null);
    }

    @JvmOverloads
    public final void launchIdentityFlow(@NotNull Context activityContext, @Nullable String str, @NotNull OneIDCallback<GuestCallbackData> callback) throws JSONException {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchIdentityFlow$default(this, activityContext, str, callback, null, 8, null);
    }

    @JvmOverloads
    public final void launchLogin(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchLogin$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void launchNewsletters(@NotNull Context activityContext, @NotNull String promotionId, @NotNull OneIDCallback<NewslettersCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(promotionId, "promotionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchNewsletters$default(this, activityContext, promotionId, callback, null, 8, null);
    }

    @JvmOverloads
    public final void launchProfile(@NotNull Context activityContext, @NotNull OneIDCallback<UpdateProfileCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchProfile$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void launchReauth(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchReauth$default(this, activityContext, callback, null, 4, null);
    }

    @JvmOverloads
    public final void launchRegistration(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        launchRegistration$default(this, activityContext, callback, null, 4, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void login(@NotNull String loginValue, @NotNull String password, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        login$default(this, loginValue, password, callback, null, 8, null);
    }

    @JvmOverloads
    public final void logout() {
        logout$default(this, null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void register(@NotNull Context activityContext, @NotNull List<Field> fields, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(callback, "callback");
        register$default(this, activityContext, fields, null, null, callback, null, 44, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void register(@NotNull Context activityContext, @NotNull List<Field> fields, @Nullable List<MarketingDetail> list, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(callback, "callback");
        register$default(this, activityContext, fields, list, null, callback, null, 40, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void register(@NotNull Context activityContext, @NotNull List<Field> fields, @Nullable List<MarketingDetail> list, @Nullable List<LegalDetail> list2, @NotNull OneIDCallback<GuestCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(callback, "callback");
        register$default(this, activityContext, fields, list, list2, callback, null, 32, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void resolvePPU(@NotNull Context activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        resolvePPU$default(this, activityContext, null, null, null, 14, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void resolvePPU(@NotNull Context activityContext, @Nullable List<? extends PPU> list) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        resolvePPU$default(this, activityContext, list, null, null, 12, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void resolvePPU(@NotNull Context activityContext, @Nullable List<? extends PPU> list, @Nullable OneIDCallback<GuestCallbackData> oneIDCallback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        resolvePPU$default(this, activityContext, list, oneIDCallback, null, 8, null);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull JsonElement jsonProfile) throws JsonSyntaxException {
        Intrinsics.checkNotNullParameter(jsonProfile, "jsonProfile");
        setEditableProfileFields$default(this, jsonProfile, (OneIDCallback) null, (OptionalConfigs) null, 6, (Object) null);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull JsonElement jsonProfile, @Nullable OneIDCallback<GuestCallbackData> oneIDCallback) throws JsonSyntaxException {
        Intrinsics.checkNotNullParameter(jsonProfile, "jsonProfile");
        setEditableProfileFields$default(this, jsonProfile, oneIDCallback, (OptionalConfigs) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull List<EditableField> fields) throws JsonSyntaxException, JsonIOException {
        Intrinsics.checkNotNullParameter(fields, "fields");
        setEditableProfileFields$default(this, fields, (OneIDCallback) null, (OptionalConfigs) null, 6, (Object) null);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull List<EditableField> fields, @Nullable OneIDCallback<GuestCallbackData> oneIDCallback) throws JsonSyntaxException, JsonIOException {
        Intrinsics.checkNotNullParameter(fields, "fields");
        setEditableProfileFields$default(this, fields, oneIDCallback, (OptionalConfigs) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void setInlineNewsletters(@NotNull Context activityContext, @NotNull NewsletterDetails newsletterDetails, @NotNull OneIDCallback<SetInlineNewslettersCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(newsletterDetails, "newsletterDetails");
        Intrinsics.checkNotNullParameter(callback, "callback");
        setInlineNewsletters$default(this, activityContext, newsletterDetails, callback, null, 8, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void updateMarketing(@NotNull Context activityContext, @NotNull String email, @NotNull List<MarketingDetail> marketing, @NotNull OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(marketing, "marketing");
        Intrinsics.checkNotNullParameter(callback, "callback");
        updateMarketing$default(this, activityContext, email, marketing, null, callback, null, 40, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void updateMarketing(@NotNull Context activityContext, @NotNull String email, @NotNull List<MarketingDetail> marketing, @Nullable List<LegalDetail> list, @NotNull OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(marketing, "marketing");
        Intrinsics.checkNotNullParameter(callback, "callback");
        updateMarketing$default(this, activityContext, email, marketing, list, callback, null, 32, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void validateOTP(@NotNull Context activityContext, @NotNull String otp, @NotNull OneIDCallback<OneIDCallbackData> callback) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(callback, "callback");
        validateOTP$default(this, activityContext, otp, callback, null, 8, null);
    }

    public OneID(@NotNull OneIDComponent oneidComponent) {
        Intrinsics.checkNotNullParameter(oneidComponent, "oneidComponent");
        oneidComponent.inject(this);
        this.sessionOwner = new OneIDSessionOwner();
        this.webViewOwner = new OneIDWebViewOwner();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/OneID$Environment;", "", "env", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnv", "()Ljava/lang/String;", "QA", "STG", "VAL", "PROD", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Environment {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Environment[] $VALUES;
        private final String env;
        public static final Environment QA = new Environment("QA", 0, "QA");
        public static final Environment STG = new Environment("STG", 1, "STG");
        public static final Environment VAL = new Environment("VAL", 2, "VAL");
        public static final Environment PROD = new Environment("PROD", 3, "PROD");

        private static final /* synthetic */ Environment[] $values() {
            return new Environment[]{QA, STG, VAL, PROD};
        }

        @NotNull
        public static EnumEntries<Environment> getEntries() {
            return $ENTRIES;
        }

        public static Environment valueOf(String str) {
            return (Environment) Enum.valueOf(Environment.class, str);
        }

        public static Environment[] values() {
            return (Environment[]) $VALUES.clone();
        }

        private Environment(String str, int i, String str2) {
            this.env = str2;
        }

        @NotNull
        public final String getEnv() {
            return this.env;
        }

        static {
            Environment[] environmentArr$values = $values();
            $VALUES = environmentArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(environmentArr$values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/disney/id/android/OneID$LogLevel;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ERROR", "WARN", "INFO", "DEBUG", "TRACE", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LogLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LogLevel[] $VALUES;
        private final int value;
        public static final LogLevel ERROR = new LogLevel("ERROR", 0, 0);
        public static final LogLevel WARN = new LogLevel("WARN", 1, 1);
        public static final LogLevel INFO = new LogLevel("INFO", 2, 2);
        public static final LogLevel DEBUG = new LogLevel("DEBUG", 3, 3);
        public static final LogLevel TRACE = new LogLevel("TRACE", 4, 4);

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{ERROR, WARN, INFO, DEBUG, TRACE};
        }

        @NotNull
        public static EnumEntries<LogLevel> getEntries() {
            return $ENTRIES;
        }

        public static LogLevel valueOf(String str) {
            return (LogLevel) Enum.valueOf(LogLevel.class, str);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }

        private LogLevel(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            LogLevel[] logLevelArr$values = $values();
            $VALUES = logLevelArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(logLevelArr$values);
        }
    }

    @NotNull
    public final Connectivity getConnectivity$OneID_release() {
        Connectivity connectivity = this.connectivity;
        if (connectivity != null) {
            return connectivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectivity");
        return null;
    }

    public final void setConnectivity$OneID_release(@NotNull Connectivity connectivity) {
        Intrinsics.checkNotNullParameter(connectivity, "<set-?>");
        this.connectivity = connectivity;
    }

    @NotNull
    public final ConfigHandler getConfigHandler$OneID_release() {
        ConfigHandler configHandler = this.configHandler;
        if (configHandler != null) {
            return configHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configHandler");
        return null;
    }

    public final void setConfigHandler$OneID_release(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "<set-?>");
        this.configHandler = configHandler;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @NotNull
    public final GuestHandler getGuestHandler$OneID_release() {
        GuestHandler guestHandler = this.guestHandler;
        if (guestHandler != null) {
            return guestHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guestHandler");
        return null;
    }

    public final void setGuestHandler$OneID_release(@NotNull GuestHandler guestHandler) {
        Intrinsics.checkNotNullParameter(guestHandler, "<set-?>");
        this.guestHandler = guestHandler;
    }

    @NotNull
    public final MigrationHandler getMigrationHandler$OneID_release() {
        MigrationHandler migrationHandler = this.migrationHandler;
        if (migrationHandler != null) {
            return migrationHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("migrationHandler");
        return null;
    }

    public final void setMigrationHandler$OneID_release(@NotNull MigrationHandler migrationHandler) {
        Intrinsics.checkNotNullParameter(migrationHandler, "<set-?>");
        this.migrationHandler = migrationHandler;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final Session getSession$OneID_release() {
        Session session = this.session;
        if (session != null) {
            return session;
        }
        Intrinsics.throwUninitializedPropertyAccessException(com.allegion.accesssdk.BuildConfig.SESSION_KEY_REFERENCE);
        return null;
    }

    public final void setSession$OneID_release(@NotNull Session session) {
        Intrinsics.checkNotNullParameter(session, "<set-?>");
        this.session = session;
    }

    @NotNull
    public final SCALPController getScalpController$OneID_release() {
        SCALPController sCALPController = this.scalpController;
        if (sCALPController != null) {
            return sCALPController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpController");
        return null;
    }

    public final void setScalpController$OneID_release(@NotNull SCALPController sCALPController) {
        Intrinsics.checkNotNullParameter(sCALPController, "<set-?>");
        this.scalpController = sCALPController;
    }

    @Nullable
    /* renamed from: getOneIDWebView$OneID_release, reason: from getter */
    public final LightboxWebView getOneIDWebView() {
        return this.oneIDWebView;
    }

    public final void setOneIDWebView$OneID_release(@Nullable LightboxWebView lightboxWebView) {
        this.oneIDWebView = lightboxWebView;
    }

    @NotNull
    public final OneIDWebViewFactory getOneIDWebViewFactory$OneID_release() {
        OneIDWebViewFactory oneIDWebViewFactory = this.oneIDWebViewFactory;
        if (oneIDWebViewFactory != null) {
            return oneIDWebViewFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIDWebViewFactory");
        return null;
    }

    public final void setOneIDWebViewFactory$OneID_release(@NotNull OneIDWebViewFactory oneIDWebViewFactory) {
        Intrinsics.checkNotNullParameter(oneIDWebViewFactory, "<set-?>");
        this.oneIDWebViewFactory = oneIDWebViewFactory;
    }

    @NotNull
    public final Bundler getBundler$OneID_release() {
        Bundler bundler = this.bundler;
        if (bundler != null) {
            return bundler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundler");
        return null;
    }

    public final void setBundler$OneID_release(@NotNull Bundler bundler) {
        Intrinsics.checkNotNullParameter(bundler, "<set-?>");
        this.bundler = bundler;
    }

    @NotNull
    public final GCService getGcService$OneID_release() {
        GCService gCService = this.gcService;
        if (gCService != null) {
            return gCService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gcService");
        return null;
    }

    public final void setGcService$OneID_release(@NotNull GCService gCService) {
        Intrinsics.checkNotNullParameter(gCService, "<set-?>");
        this.gcService = gCService;
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    @NotNull
    public final ExposedStorage getOneIdStorage$OneID_release() {
        ExposedStorage exposedStorage = this.oneIdStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIdStorage");
        return null;
    }

    public final void setOneIdStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.oneIdStorage = exposedStorage;
    }

    @NotNull
    public final InitializationCallbackHolder getInitializationCallbackHolder$OneID_release() {
        InitializationCallbackHolder initializationCallbackHolder = this.initializationCallbackHolder;
        if (initializationCallbackHolder != null) {
            return initializationCallbackHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initializationCallbackHolder");
        return null;
    }

    public final void setInitializationCallbackHolder$OneID_release(@NotNull InitializationCallbackHolder initializationCallbackHolder) {
        Intrinsics.checkNotNullParameter(initializationCallbackHolder, "<set-?>");
        this.initializationCallbackHolder = initializationCallbackHolder;
    }

    @NotNull
    public final HeadlessListenerHolder getHeadlessListenerHolder$OneID_release() {
        HeadlessListenerHolder headlessListenerHolder = this.headlessListenerHolder;
        if (headlessListenerHolder != null) {
            return headlessListenerHolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headlessListenerHolder");
        return null;
    }

    public final void setHeadlessListenerHolder$OneID_release(@NotNull HeadlessListenerHolder headlessListenerHolder) {
        Intrinsics.checkNotNullParameter(headlessListenerHolder, "<set-?>");
        this.headlessListenerHolder = headlessListenerHolder;
    }

    @NotNull
    public final SCALPBundle getScalpBundleDownloader$OneID_release() {
        SCALPBundle sCALPBundle = this.scalpBundleDownloader;
        if (sCALPBundle != null) {
            return sCALPBundle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpBundleDownloader");
        return null;
    }

    public final void setScalpBundleDownloader$OneID_release(@NotNull SCALPBundle sCALPBundle) {
        Intrinsics.checkNotNullParameter(sCALPBundle, "<set-?>");
        this.scalpBundleDownloader = sCALPBundle;
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u001e\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001fJ\r\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0002\b J8\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0007JD\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007J>\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010*H\u0003JH\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u001c\u0010/\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u00100\u001a\u00020\u0018H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/disney/id/android/OneID$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "UIVERSION_KEY", "UNID", "UNID_DEPRECATED_REASON", "UNID_DEPRECATED_VALUE", "UNID_REASON", "appContext", "Landroid/content/Context;", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler", "()Lcom/disney/id/android/ConfigHandler;", "configHandler$delegate", "Lkotlin/Lazy;", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", "getDefaultScope", "()Lkotlinx/coroutines/CoroutineScope;", "instance", "Lcom/disney/id/android/OneID;", "ioScope", "getIoScope", "mainScope", "getMainScope", "version", "getAppContext", "getAppContext$OneID_release", "getConfigHandler$OneID_release", "initialize", "", "config", "Lcom/disney/id/android/Config;", "delegate", "Lcom/disney/id/android/OneIDListener;", "context", "refreshToken", "stateCallback", "Lcom/disney/id/android/OneIDStateCallback;", "headlessListener", "Lcom/disney/id/android/OneIDHeadlessListener;", Attributes.COUNTRY, "externalRefreshToken", "reinitializeWithGALC", "shared", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        public final void initialize(@NotNull Config config, @NotNull OneIDListener delegate, @NotNull Context context) throws InterruptedException {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(context, "context");
            initialize$default(this, config, delegate, context, null, null, 24, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void initialize(@NotNull Config config, @NotNull OneIDListener delegate, @NotNull Context context, @Nullable String str) throws InterruptedException {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(context, "context");
            initialize$default(this, config, delegate, context, str, null, 16, null);
        }

        private Companion() {
        }

        private final ConfigHandler getConfigHandler() {
            return (ConfigHandler) OneID.configHandler$delegate.getValue();
        }

        @NotNull
        public final CoroutineScope getMainScope() {
            return OneID.mainScope;
        }

        @NotNull
        public final CoroutineScope getIoScope() {
            return OneID.ioScope;
        }

        @NotNull
        public final CoroutineScope getDefaultScope() {
            return OneID.defaultScope;
        }

        @NotNull
        public final ConfigHandler getConfigHandler$OneID_release() throws NotInitialized {
            if (!getConfigHandler().hasConfig()) {
                throw new NotInitialized("OneID has not been initialized yet. No Config");
            }
            return getConfigHandler();
        }

        @NotNull
        public final Context getAppContext$OneID_release() throws NotInitialized {
            Context context = OneID.appContext;
            if (context != null) {
                return context;
            }
            throw new NotInitialized("OneID has not been initialized yet. No Context");
        }

        public static /* synthetic */ void reinitializeWithGALC$default(Companion companion, String str, OneIDStateCallback oneIDStateCallback, int i, Object obj) throws NotInitialized, JSONException, InterruptedException {
            if ((i & 2) != 0) {
                oneIDStateCallback = null;
            }
            companion.reinitializeWithGALC(str, oneIDStateCallback);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
        @JvmStatic
        public final void reinitializeWithGALC(@NotNull String country, @Nullable OneIDStateCallback stateCallback) throws NotInitialized, JSONException, InterruptedException {
            Intrinsics.checkNotNullParameter(country, "country");
            OneID oneIDShared = shared();
            OneIDListener delegate = oneIDShared.getDelegate();
            if (delegate == null) {
                throw new NotInitialized("OneID has no delegate.");
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String upperCase = country.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            JSONArray countries = oneIDShared.getScalpController$OneID_release().getCountries();
            if (countries == null) {
                throw new NotInitialized("OneID has not loaded SiteConfig.");
            }
            int length = countries.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = countries.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                if (StringsKt.equals$default(JSONExtensionsKt.getStringSafely(jSONObject, "code"), upperCase, false, 2, null)) {
                    z = true;
                }
            }
            if (!z) {
                throw new OneIDError("INVALID_VALUE", "Country is not a recognized country code", null, 4, null);
            }
            initialize(getConfigHandler().get(), upperCase, delegate, getAppContext$OneID_release(), null, stateCallback, oneIDShared.getHeadlessListenerHolder$OneID_release().getHeadlessListener());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initialize(Config config, String country, OneIDListener delegate, Context context, String externalRefreshToken, OneIDStateCallback stateCallback, OneIDHeadlessListener headlessListener) throws InterruptedException {
            BuildersKt.runBlocking(getDefaultScope().getCoroutineContext(), new OneID$Companion$initialize$1(config, country, delegate, context, externalRefreshToken, stateCallback, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void initialize(Config config, String country, OneIDListener delegate, Context context, String externalRefreshToken, OneIDStateCallback stateCallback) {
            Profile profile;
            Token token$OneID_release;
            try {
                OneID.appContext = context.getApplicationContext();
                getConfigHandler().set(config);
                OneIDDagger.resetComponent();
                OneID oneID = new OneID(OneIDDagger.getComponent());
                OneID.instance = oneID;
                TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(oneID.getTracker$OneID_release(), null, EventAction.EVENT_INITIALIZED, oneID.getSwid$OneID_release().get(), null, null, 25, null);
                oneID.getLogger$OneID_release().setLogLevel(config.getLogLevel());
                Companion companion = OneID.INSTANCE;
                BuildersKt__Builders_commonKt.launch$default(companion.getMainScope(), null, null, new OneID$Companion$initialize$2$1(config, oneID, null), 3, null);
                oneID.setDelegate(delegate);
                oneID.getInitializationCallbackHolder$OneID_release().setStateCallback(stateCallback);
                oneID.getInitializationCallbackHolder$OneID_release().reportState(OneIDState.Initializing);
                oneID.getInitializationCallbackHolder$OneID_release().setTrackerEventKey(trackerEventKeyStartConversationEvent$default);
                oneID.getSession$OneID_release().setOwner(oneID.sessionOwner);
                if (externalRefreshToken != null && externalRefreshToken.length() != 0) {
                    oneID.reloadGuest(externalRefreshToken);
                } else {
                    oneID.getSession$OneID_release().loadGuestFromStorage(trackerEventKeyStartConversationEvent$default);
                    oneID.notifyIfMigrationFailed();
                }
                oneID.getScalpController$OneID_release().setAssertedCountry(country);
                String string$default = ExposedStorage.DefaultImpls.getString$default(oneID.getOneIdStorage$OneID_release(), LightboxActivity.UI_VERSION_EXTRA, null, 2, null);
                if (string$default != null) {
                    oneID.getScalpController$OneID_release().setUiVersion(string$default);
                }
                if (oneID.getScalpController$OneID_release().getUiVersion() == null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                    SCALPController scalpController$OneID_release = oneID.getScalpController$OneID_release();
                    Bundle bundle = applicationInfo.metaData;
                    scalpController$OneID_release.setUiVersion(bundle != null ? bundle.getString("forceUIVersion") : null);
                }
                if (oneID.getScalpController$OneID_release().getUiVersion() != null) {
                    Logger logger$OneID_release = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release, str, "UI version has been overridden. \nPlease remove forceUIVersion metadata before shipping your app. \nforceUIVersion metadata can be found in app manifest xml.", null, 4, null);
                }
                oneID.getTracker$OneID_release().launchCheck(oneID.getScalpController$OneID_release().getUiVersion());
                LightboxWebView oneIDWebView = oneID.getOneIDWebView();
                if (oneIDWebView != null) {
                    oneIDWebView.setOwner(oneID.webViewOwner);
                }
                Logger logger$OneID_release2 = oneID.getLogger$OneID_release();
                String str2 = OneID.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                Logger.DefaultImpls.i$default(logger$OneID_release2, str2, "OneID SDK version: 4.12.5 250431538", null, 4, null);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                Guest guest = oneID.getGuestHandler$OneID_release().get();
                if (guest != null && (token$OneID_release = guest.getToken$OneID_release()) != null && token$OneID_release.getRefreshToken() != null && oneID.getSession$OneID_release().refreshTokenExpired(trackerEventKeyStartConversationEvent$default)) {
                    oneID.getInitializationCallbackHolder$OneID_release().setCurrentState(OneIDState.Renewing);
                    Profile profile2 = guest.getProfile();
                    String email = profile2 != null ? profile2.getEmail() : null;
                    Session.DefaultImpls.end$default(oneID.getSession$OneID_release(), null, null, 3, null);
                    booleanRef.element = true;
                    BuildersKt__Builders_commonKt.launch$default(companion.getIoScope(), null, null, new OneID$Companion$initialize$2$4$1(oneID, trackerEventKeyStartConversationEvent$default, context, email, delegate, booleanRef, null), 3, null);
                }
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                booleanRef2.element = true;
                String ageBand = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getAgeBand();
                String strHasCachedMobileConfig = oneID.getScalpController$OneID_release().hasCachedMobileConfig(ageBand, oneID.getScalpController$OneID_release().getUiVersion());
                if (strHasCachedMobileConfig != null) {
                    TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(oneID.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default.getId(), EventAction.LOG_GET_CONFIG_CACHED, oneID.getSwid$OneID_release().get(), null, null, 24, null);
                    oneID.getScalpController$OneID_release().loadFromCache(strHasCachedMobileConfig, ageBand);
                    BuildersKt__Builders_commonKt.launch$default(companion.getIoScope(), null, null, new OneID$Companion$initialize$2$5(oneID, trackerEventKeyStartTransactionEvent$default, trackerEventKeyStartConversationEvent$default, booleanRef2, null), 3, null);
                } else if (!booleanRef.element) {
                    BuildersKt__Builders_commonKt.launch$default(companion.getIoScope(), null, null, new OneID$Companion$initialize$2$6(oneID, trackerEventKeyStartConversationEvent$default, booleanRef2, null), 3, null);
                } else {
                    oneID.startPeriodicWorker$OneID_release(booleanRef2.element);
                }
                Logger logger$OneID_release3 = oneID.getLogger$OneID_release();
                String str3 = OneID.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                Logger.DefaultImpls.i$default(logger$OneID_release3, str3, "OneID initialization COMPLETE, config/bundle retrieval may still be in progress, Guest login status is: " + (oneID.getSession$OneID_release().isLoggedIn() ? "LOGGED-IN" : "NOT logged-in."), null, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }

        public static /* synthetic */ void initialize$default(Companion companion, Config config, OneIDListener oneIDListener, Context context, String str, OneIDStateCallback oneIDStateCallback, int i, Object obj) throws InterruptedException {
            companion.initialize(config, oneIDListener, context, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : oneIDStateCallback);
        }

        @JvmStatic
        @JvmOverloads
        public final void initialize(@NotNull Config config, @NotNull OneIDListener delegate, @NotNull Context context, @Nullable String refreshToken, @Nullable OneIDStateCallback stateCallback) throws InterruptedException {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(context, "context");
            BuildersKt.runBlocking(getDefaultScope().getCoroutineContext(), new OneID$Companion$initialize$3(config, delegate, context, refreshToken, stateCallback, null));
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
        @JvmStatic
        public final void initialize(@NotNull Config config, @NotNull OneIDListener delegate, @NotNull Context context, @Nullable String refreshToken, @Nullable OneIDStateCallback stateCallback, @Nullable OneIDHeadlessListener headlessListener) throws InterruptedException {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(context, "context");
            BuildersKt.runBlocking(getDefaultScope().getCoroutineContext(), new OneID$Companion$initialize$4(config, delegate, context, refreshToken, stateCallback, null));
        }

        @JvmStatic
        @NotNull
        public final OneID shared() throws NotInitialized {
            OneID oneID = OneID.instance;
            if (oneID != null) {
                return oneID;
            }
            throw new NotInitialized("OneID has not been initialized yet. No Instance");
        }
    }

    static /* synthetic */ void appContext$default(OneID oneID, TrackerEventKey trackerEventKey, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            trackerEventKey = null;
        }
        oneID.appContext(trackerEventKey, function1);
    }

    private final void appContext(TrackerEventKey trackerEventKey, Function1 block) {
        Context context = appContext;
        if (context != null) {
            block.invoke(context);
            return;
        }
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.wtf$default(logger$OneID_release, TAG2, "No appContext", null, 4, null);
        if (trackerEventKey != null) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, true, null, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "missing(appContext)", false, 36, null);
        }
    }

    public final void startPeriodicWorker$OneID_release(boolean delay) {
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        PeriodicWorkRequest.Builder constraints = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PeriodicSCALPBundlerWorker.class, 15L, timeUnit).setConstraints(constraintsBuild);
        if (delay) {
            constraints.setInitialDelay(15L, timeUnit);
        }
        final PeriodicWorkRequest periodicWorkRequestBuild = constraints.build();
        appContext$default(this, null, new Function1() { // from class: com.disney.id.android.OneID$startPeriodicWorker$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Context) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WorkManager.getInstance(it).enqueueUniquePeriodicWork("com.oneid.scalpPeriodicWorker", ExistingPeriodicWorkPolicy.REPLACE, periodicWorkRequestBuild);
            }
        }, 1, null);
    }

    public static /* synthetic */ Object resolveCallbackWeakReference$OneID_release$default(OneID oneID, WeakReference weakReference, TrackerEventKey trackerEventKey, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return oneID.resolveCallbackWeakReference$OneID_release(weakReference, trackerEventKey, z);
    }

    @Nullable
    public final <T> T resolveCallbackWeakReference$OneID_release(@NotNull WeakReference<T> weakRef, @NotNull TrackerEventKey trackerEventKey, boolean disableThrottling) {
        Intrinsics.checkNotNullParameter(weakRef, "weakRef");
        Intrinsics.checkNotNullParameter(trackerEventKey, "trackerEventKey");
        T t = weakRef.get();
        if (t == null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.w(TAG2, "Callback missing", new Throwable());
            getTracker$OneID_release().finishEvent(trackerEventKey, false, OneIDTrackerEvent.ERROR_CODE_WEAK_REFERENCE_MISSING, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(Callback)", disableThrottling);
        }
        return t;
    }

    public static /* synthetic */ OneIDError createAndLogMissingGuestError$OneID_release$default(OneID oneID, TrackerEventKey trackerEventKey, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oneID.createAndLogMissingGuestError$OneID_release(trackerEventKey, z);
    }

    @NotNull
    public final OneIDError createAndLogMissingGuestError$OneID_release(@Nullable TrackerEventKey trackerEventKey, boolean disableThrottling) {
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logger$OneID_release.wtf(TAG2, "Guest Handler not populated with Guest object", new Throwable());
        if (trackerEventKey != null) {
            getTracker$OneID_release().finishEvent(trackerEventKey, true, OneIDTrackerEvent.ERROR_CODE_GUEST_HANDLER_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "missing(guest)", disableThrottling);
        }
        return new OneIDError(OneIDError.GUEST_MISSING, "Guest Handler not populated with Guest object", null, 4, null);
    }

    private final class OneIDSessionOwner implements Session.Owner {
        private List callbackList;

        public OneIDSessionOwner() {
            List listSynchronizedList = Collections.synchronizedList(new ArrayList());
            Intrinsics.checkNotNullExpressionValue(listSynchronizedList, "synchronizedList(...)");
            this.callbackList = listSynchronizedList;
        }

        public final List getCallbackList() {
            return this.callbackList;
        }

        @Override // com.disney.id.android.Session.Owner
        public void tokenRefreshSuccess(JSONObject jSONObject, String str) {
            if (jSONObject != null) {
                OneID.this.launchPPU$OneID_release(jSONObject, str);
            }
            List list = this.callbackList;
            OneID oneID = OneID.this;
            synchronized (list) {
                try {
                    if (!this.callbackList.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (RefreshTokenCallback refreshTokenCallback : this.callbackList) {
                            refreshTokenCallback.onSuccess();
                            arrayList.add(refreshTokenCallback);
                        }
                        this.callbackList.removeAll(arrayList);
                    } else {
                        OneIDListener delegate = oneID.getDelegate();
                        if (delegate != null) {
                            delegate.onTokenRefreshSuccess();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.disney.id.android.Session.Owner
        public void tokenRefreshPPU(List ppus) {
            Intrinsics.checkNotNullParameter(ppus, "ppus");
            OneIDHeadlessListener headlessListener = OneID.this.getHeadlessListenerHolder$OneID_release().getHeadlessListener();
            if (headlessListener != null) {
                headlessListener.onTokenRefreshPPU(ppus);
            }
        }

        @Override // com.disney.id.android.Session.Owner
        public void tokenRefreshFailure(OneIDError oneIDError) {
            List list = this.callbackList;
            OneID oneID = OneID.this;
            synchronized (list) {
                try {
                    if (!this.callbackList.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (RefreshTokenCallback refreshTokenCallback : this.callbackList) {
                            refreshTokenCallback.onFailure(oneIDError);
                            arrayList.add(refreshTokenCallback);
                        }
                        this.callbackList.removeAll(arrayList);
                    } else {
                        OneIDListener delegate = oneID.getDelegate();
                        if (delegate != null) {
                            delegate.onTokenRefreshFailure();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.disney.id.android.Session.Owner
        public void notifyOfLogout() {
            OneIDListener delegate = OneID.this.getDelegate();
            if (delegate != null) {
                delegate.onLogout();
            }
        }
    }

    @NotNull
    public final Config getConfig() {
        return getConfigHandler$OneID_release().get();
    }

    @JvmName(name = "delegate")
    @Nullable
    /* renamed from: delegate, reason: from getter */
    public final OneIDListener getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(@Nullable OneIDListener oneIDListener) {
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.API_SET_DELEGATE, getSwid$OneID_release().get(), null, null, null, null, false, 499, null);
        this.delegate = oneIDListener;
    }

    @Nullable
    public final OptionalConfigs getInternalDefaultOptions$OneID_release() {
        return this.internalDefaultOptions;
    }

    public final void setInternalDefaultOptions$OneID_release(@Nullable OptionalConfigs optionalConfigs) {
        this.internalDefaultOptions = optionalConfigs;
    }

    @Nullable
    /* renamed from: getDefaultOptions, reason: from getter */
    public final OptionalConfigs getInternalDefaultOptions() {
        return this.internalDefaultOptions;
    }

    public final void setDefaultOptions(@Nullable OptionalConfigs optionalConfigs) {
        Tracker tracker$OneID_release = getTracker$OneID_release();
        EventAction eventAction = EventAction.API_SET_DEFAULT_OPTIONS;
        String str = getSwid$OneID_release().get();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("isNull(%s)", Arrays.copyOf(new Object[]{this.internalDefaultOptions != null ? "false" : Characteristics.TRUE}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        Tracker.DefaultImpls.trackInstantEvent$default(tracker$OneID_release, null, false, eventAction, str, null, null, str2, optionalConfigs, false, 307, null);
        this.internalDefaultOptions = optionalConfigs;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "UNID is no longer supported.")
    @NotNull
    public final Map<String, String> getUNID() {
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_UNID, getSwid$OneID_release().get(), null, null, 25, null);
        HashMap map = new HashMap(4);
        map.put(UNID, "UNID Deprecated");
        map.put(UNID_REASON, "UNID Deprecated");
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, "deprecatedMethod(getUNID)", false, 46, null);
        return map;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "UNID is no longer supported.")
    public final void getUNID(@NotNull OneIDCallback<UnidCallbackData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_UNID_ASYNC, getSwid$OneID_release().get(), null, null, 25, null);
        HashMap map = new HashMap(4);
        map.put(UNID, "UNID Deprecated");
        map.put(UNID_REASON, "UNID Deprecated");
        callback.onSuccess(new UnidCallbackData(true, null, map));
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, "deprecatedMethod(getUNID)", false, 46, null);
    }

    public final boolean isLoggedIn() {
        boolean zIsLoggedIn = getSession$OneID_release().isLoggedIn();
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.API_GET_LOGGED_IN_STATUS, getSwid$OneID_release().get(), null, null, null, null, false, 499, null);
        return zIsLoggedIn;
    }

    @NotNull
    public final String getSWID() {
        String str = getSwid$OneID_release().get();
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.API_GET_SWID, str, null, null, null, null, false, 499, null);
        return str;
    }

    static /* synthetic */ void launchLightbox$default(OneID oneID, Context context, LightboxWebView.LightboxPage lightboxPage, OptionalConfigs optionalConfigs, TrackerEventKey trackerEventKey, OneIDCallback oneIDCallback, CallbackType callbackType, JSONObject jSONObject, int i, Object obj) {
        oneID.launchLightbox(context, lightboxPage, (i & 4) != 0 ? null : optionalConfigs, trackerEventKey, oneIDCallback, callbackType, (i & 64) != 0 ? null : jSONObject);
    }

    private final void launchLightbox(Context context, LightboxWebView.LightboxPage page, OptionalConfigs mergedOptionalConfigs, TrackerEventKey trackerEventKey, OneIDCallback callback, CallbackType callbackType, JSONObject params) {
        if (!getConnectivity$OneID_release().isConnected()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "No connectivity when attempting to launch OneID UI", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, "NO_CONNECTION", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            OneIDError oneIDError = new OneIDError("NO_CONNECTION", null, null, 6, null);
            switch (WhenMappings.$EnumSwitchMapping$0[callbackType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if (callback != null) {
                        callback.onFailure(new GuestCallbackData(false, oneIDError, null, null, null, null, 60, null));
                        break;
                    }
                    break;
                case 5:
                    if (callback != null) {
                        callback.onFailure(new UpdateProfileCallbackData(false, oneIDError, null, null, null, Boolean.FALSE, 28, null));
                        break;
                    }
                    break;
                case 6:
                    if (callback != null) {
                        callback.onFailure(new NewslettersCallbackData(false, oneIDError, null, 4, null));
                        break;
                    }
                    break;
                case 7:
                    if (callback != null) {
                        callback.onFailure(new EmailVerificationCallbackData(false, oneIDError));
                        break;
                    }
                    break;
            }
            return;
        }
        if (this.oneIDWebView == null) {
            OneIDWebViewFactory oneIDWebViewFactory$OneID_release = getOneIDWebViewFactory$OneID_release();
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
            LightboxWebView oneIDWebView = oneIDWebViewFactory$OneID_release.getOneIDWebView(event != null ? event.getConversationId$OneID_release() : null);
            if (oneIDWebView == null) {
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "Unable to get webView", null, 4, null);
                oneIDWebView = null;
            }
            this.oneIDWebView = oneIDWebView;
            if (oneIDWebView == null) {
                OneIDError oneIDError2 = new OneIDError(OneIDError.INVALID_STATE, "Webview not available", null, 4, null);
                switch (WhenMappings.$EnumSwitchMapping$0[callbackType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        if (callback != null) {
                            callback.onFailure(new GuestCallbackData(false, oneIDError2, null, null, null, null, 60, null));
                            break;
                        }
                        break;
                    case 5:
                        if (callback != null) {
                            callback.onFailure(new UpdateProfileCallbackData(false, oneIDError2, null, null, null, Boolean.FALSE, 28, null));
                            break;
                        }
                        break;
                    case 6:
                        if (callback != null) {
                            callback.onFailure(new NewslettersCallbackData(false, oneIDError2, null, 4, null));
                            break;
                        }
                        break;
                    case 7:
                        if (callback != null) {
                            callback.onFailure(new EmailVerificationCallbackData(false, oneIDError2));
                            break;
                        }
                        break;
                }
                return;
            }
            if (oneIDWebView != null) {
                oneIDWebView.setOwner(this.webViewOwner);
            }
            startPeriodicWorker$OneID_release(false);
        }
        if (!LightboxActivity.INSTANCE.isPresenting$OneID_release().compareAndSet(false, true)) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release3, TAG4, "Lightbox activity/webview still in use. Due to thread timing, ensure any launch API calls are done outside of any callback handlers.", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, OneIDTrackerEvent.ERROR_CODE_LIGHTBOX_ALREADY_IN_USE, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            OneIDError oneIDError3 = new OneIDError(OneIDError.INVALID_STATE, "Lightbox activity/webview still in use. Due to thread timing, ensure any launch API calls are done outside of any callback handlers.", null, 4, null);
            switch (WhenMappings.$EnumSwitchMapping$0[callbackType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if (callback != null) {
                        callback.onFailure(new GuestCallbackData(false, oneIDError3, null, null, null, null, 60, null));
                        break;
                    }
                    break;
                case 5:
                    if (callback != null) {
                        callback.onFailure(new UpdateProfileCallbackData(false, oneIDError3, null, null, null, Boolean.FALSE, 28, null));
                        break;
                    }
                    break;
                case 6:
                    if (callback != null) {
                        callback.onFailure(new NewslettersCallbackData(false, oneIDError3, null, 4, null));
                        break;
                    }
                    break;
                case 7:
                    if (callback != null) {
                        callback.onFailure(new EmailVerificationCallbackData(false, oneIDError3));
                        break;
                    }
                    break;
            }
            return;
        }
        this.webViewOwner.setPageLaunchData(trackerEventKey, callback, callbackType);
        if (params != null) {
            page.setInputData(params);
        }
        page.setOptionalConfigs(mergedOptionalConfigs);
        Intent intent = new Intent(context, (Class<?>) LightboxActivity.class);
        intent.putExtra("page", page);
        OptionalConfigs optionalConfigs = page.getOptionalConfigs();
        if (optionalConfigs != null) {
            intent.putExtra(LightboxActivity.CONFIGS_EXTRA, optionalConfigs.toJSON$OneID_release().toString());
        }
        intent.putExtra(LightboxActivity.EVENT_ID_EXTRA, trackerEventKey.getId());
        intent.putExtra(LightboxActivity.ACTION_NAME_EXTRA, trackerEventKey.getActionName());
        String uiVersion = getScalpController$OneID_release().getUiVersion();
        if (uiVersion != null) {
            intent.putExtra(LightboxActivity.UI_VERSION_EXTRA, uiVersion);
        }
        Integer overrideActivityFlagValue = mergedOptionalConfigs != null ? mergedOptionalConfigs.getOverrideActivityFlagValue() : null;
        if (overrideActivityFlagValue != null) {
            intent.addFlags(overrideActivityFlagValue.intValue());
            String activityFlags = new ActivityFlagParser().getActivityFlags(intent.getFlags());
            Logger logger$OneID_release4 = getLogger$OneID_release();
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release4, TAG5, "added activity flags " + activityFlags, null, 4, null);
            OneIDTrackerEvent event2 = getTracker$OneID_release().getEvent(trackerEventKey);
            if (event2 != null) {
                OneIDTrackerEvent.appendCodes$OneID_release$default(event2, null, null, "overrideActivityFlags(" + overrideActivityFlagValue + "), flagNames(" + activityFlags + ")", 3, null);
            }
        } else {
            intent.addFlags(268435456);
            Logger logger$OneID_release5 = getLogger$OneID_release();
            String TAG6 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release5, TAG6, "activity flag new task", null, 4, null);
        }
        context.startActivity(intent);
    }

    public static /* synthetic */ void launchPPU$OneID_release$default(OneID oneID, JSONObject jSONObject, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        oneID.launchPPU$OneID_release(jSONObject, str);
    }

    public final void launchPPU$OneID_release(@NotNull JSONObject params, @Nullable String conversationId) {
        Intrinsics.checkNotNullParameter(params, "params");
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), conversationId, EventAction.EVENT_LAUNCH_PPU, getSwid$OneID_release().get(), null, null, 24, null);
        final LightboxWebView.LightboxPage lightboxPage = LightboxWebView.LightboxPage.PPU;
        lightboxPage.setInputData(params);
        appContext(trackerEventKeyStartConversationEvent$default, new Function1() { // from class: com.disney.id.android.OneID$launchPPU$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Context) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                OneID oneID = this.this$0;
                OneID.launchLightbox$default(oneID, it, lightboxPage, oneID.getInternalDefaultOptions$OneID_release(), trackerEventKeyStartConversationEvent$default, null, CallbackType.PPU, null, 64, null);
            }
        });
    }

    public static /* synthetic */ void launchLogin$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.launchLogin(context, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchLogin(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) != null) {
            optionalConfigs = optionalConfigsMerge$OneID_release;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_LOGIN, getSwid$OneID_release().get(), null, optionalConfigs, 9, null);
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigs, event != null ? event.getConversationId$OneID_release() : null);
        launchLightbox$default(this, activityContext, LightboxWebView.LightboxPage.LOGIN, optionalConfigs, trackerEventKeyStartConversationEvent$default, callback, CallbackType.LOGIN, null, 64, null);
    }

    public static /* synthetic */ void launchRegistration$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.launchRegistration(context, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchRegistration(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) != null) {
            optionalConfigs = optionalConfigsMerge$OneID_release;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_REGISTRATION, getSwid$OneID_release().get(), null, optionalConfigs, 9, null);
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigs, event != null ? event.getConversationId$OneID_release() : null);
        launchLightbox$default(this, activityContext, LightboxWebView.LightboxPage.REGISTER, optionalConfigs, trackerEventKeyStartConversationEvent$default, callback, CallbackType.REGISTER, null, 64, null);
    }

    public static /* synthetic */ void logout$default(OneID oneID, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 1) != 0) {
            optionalConfigs = null;
        }
        oneID.logout(optionalConfigs);
    }

    @JvmOverloads
    public final void logout(@Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LOGOUT, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigsMerge$OneID_release, event != null ? event.getConversationId$OneID_release() : null);
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
    }

    public final boolean isLowTrust() {
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.API_GET_TRUST_STATE_STATUS, getSwid$OneID_release().get(), null, null, null, null, false, 499, null);
        return !getSession$OneID_release().highTrust();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J0\u0010\u000b\u001a\u00020\u0007\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001c\u0010\u0003\u001a\u0010\u0012\u0002\b\u0003\u0018\u00010\u0004R\u00060\u0000R\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/disney/id/android/OneID$OneIDWebViewOwner;", "Lcom/disney/id/android/lightbox/LightboxWebView$WebViewOwner;", "(Lcom/disney/id/android/OneID;)V", "pageLaunchData", "Lcom/disney/id/android/OneID$OneIDWebViewOwner$PageLaunchData;", "Lcom/disney/id/android/OneID;", "lightboxComplete", "", "lightboxData", "Lcom/disney/id/android/LightboxData;", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "setPageLaunchData", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/disney/id/android/OneIDCallbackData;", "trackerEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "callback", "Lcom/disney/id/android/OneIDCallback;", "callbackType", "Lcom/disney/id/android/CallbackType;", "PageLaunchData", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nOneID.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneID.kt\ncom/disney/id/android/OneID$OneIDWebViewOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,4484:1\n1#2:4485\n*E\n"})
    public final class OneIDWebViewOwner implements LightboxWebView.WebViewOwner {
        private PageLaunchData pageLaunchData;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackType.values().length];
                try {
                    iArr[CallbackType.PROFILE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackType.LOGIN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackType.PPU.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackType.REGISTER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackType.EXPIRED_SESSION.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[CallbackType.EMAIL_VERIFICATION.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[CallbackType.NEWSLETTERS.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public OneIDWebViewOwner() {
        }

        private final class PageLaunchData {
            private final OneIDCallback callback;
            private final CallbackType callbackType;
            final /* synthetic */ OneIDWebViewOwner this$0;
            private final TrackerEventKey trackerEventKey;

            public PageLaunchData(OneIDWebViewOwner oneIDWebViewOwner, TrackerEventKey trackerEventKey, OneIDCallback oneIDCallback, CallbackType callbackType) {
                Intrinsics.checkNotNullParameter(trackerEventKey, "trackerEventKey");
                Intrinsics.checkNotNullParameter(callbackType, "callbackType");
                this.this$0 = oneIDWebViewOwner;
                this.trackerEventKey = trackerEventKey;
                this.callback = oneIDCallback;
                this.callbackType = callbackType;
            }

            public final TrackerEventKey getTrackerEventKey() {
                return this.trackerEventKey;
            }

            public final OneIDCallback getCallback() {
                return this.callback;
            }

            public final CallbackType getCallbackType() {
                return this.callbackType;
            }
        }

        public final <T extends OneIDCallbackData> void setPageLaunchData(@NotNull TrackerEventKey trackerEventKey, @Nullable OneIDCallback<T> callback, @NotNull CallbackType callbackType) {
            Intrinsics.checkNotNullParameter(trackerEventKey, "trackerEventKey");
            Intrinsics.checkNotNullParameter(callbackType, "callbackType");
            this.pageLaunchData = new PageLaunchData(this, trackerEventKey, callback, callbackType);
        }

        @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewOwner
        public void logout() {
            TrackerEventKey trackerEventKey;
            OneIDTrackerEvent event;
            Session session$OneID_release = OneID.this.getSession$OneID_release();
            OptionalConfigs internalDefaultOptions$OneID_release = OneID.this.getInternalDefaultOptions$OneID_release();
            PageLaunchData pageLaunchData = this.pageLaunchData;
            String conversationId$OneID_release = null;
            if (pageLaunchData != null && (trackerEventKey = pageLaunchData.getTrackerEventKey()) != null && (event = OneID.this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                conversationId$OneID_release = event.getConversationId$OneID_release();
            }
            session$OneID_release.end(internalDefaultOptions$OneID_release, conversationId$OneID_release);
        }

        @Override // com.disney.id.android.lightbox.LightboxWebView.WebViewOwner
        public void lightboxComplete(@NotNull LightboxData lightboxData) {
            OneIDCallback oneIDCallback;
            TrackerEventKey trackerEventKey;
            OneIDTrackerEvent event;
            OneIDError oneIDError;
            TrackerEventKey trackerEventKey2;
            Intrinsics.checkNotNullParameter(lightboxData, "lightboxData");
            if (lightboxData.getCancelled()) {
                if (lightboxData.getDidLogout()) {
                    oneIDError = new OneIDError(OneIDError.USER_LOGGED_OUT, null, null, 6, null);
                } else {
                    oneIDError = new OneIDError("USER_CANCELLED", null, null, 6, null);
                }
                PageLaunchData pageLaunchData = this.pageLaunchData;
                if (pageLaunchData != null && (trackerEventKey2 = pageLaunchData.getTrackerEventKey()) != null) {
                    OneID oneID = OneID.this;
                    if (lightboxData.getDidLogout()) {
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey2, false, null, null, "guest(loggedOut)", false, 44, null);
                    } else {
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey2, false, null, null, "guest(cancelled)", false, 44, null);
                    }
                }
                PageLaunchData pageLaunchData2 = this.pageLaunchData;
                if (pageLaunchData2 != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[pageLaunchData2.getCallbackType().ordinal()]) {
                        case 1:
                            OneIDCallback callback = pageLaunchData2.getCallback();
                            oneIDCallback = callback != null ? callback : null;
                            if (oneIDCallback != null) {
                                oneIDCallback.onFailure(new UpdateProfileCallbackData(false, oneIDError, null, null, Boolean.valueOf(lightboxData.getDidReauth()), Boolean.valueOf(lightboxData.getAccountDeleted()), 8, null));
                                return;
                            }
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            OneIDCallback callback2 = pageLaunchData2.getCallback();
                            oneIDCallback = callback2 != null ? callback2 : null;
                            if (oneIDCallback != null) {
                                oneIDCallback.onFailure(new GuestCallbackData(false, oneIDError, null, Boolean.valueOf(lightboxData.getAccountCreated()), null, Boolean.valueOf(lightboxData.getDidReauth()), 16, null));
                                return;
                            }
                            return;
                        case 6:
                            OneIDCallback callback3 = pageLaunchData2.getCallback();
                            oneIDCallback = callback3 != null ? callback3 : null;
                            if (oneIDCallback != null) {
                                oneIDCallback.onFailure(new EmailVerificationCallbackData(false, oneIDError));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                return;
            }
            Session session$OneID_release = OneID.this.getSession$OneID_release();
            PageLaunchData pageLaunchData3 = this.pageLaunchData;
            session$OneID_release.loadGuestFromStorage(pageLaunchData3 != null ? pageLaunchData3.getTrackerEventKey() : null);
            Guest guest = OneID.this.getGuestHandler$OneID_release().get();
            OneID oneID2 = OneID.this;
            NewslettersResult newslettersResult = lightboxData.getNewslettersResult();
            String emailVerificationErrorCode = lightboxData.getEmailVerificationErrorCode();
            PageLaunchData pageLaunchData4 = this.pageLaunchData;
            boolean zIsSuccess = oneID2.isSuccess(guest, newslettersResult, emailVerificationErrorCode, pageLaunchData4 != null ? pageLaunchData4.getCallbackType() : null);
            PageLaunchData pageLaunchData5 = this.pageLaunchData;
            if (pageLaunchData5 != null && (trackerEventKey = pageLaunchData5.getTrackerEventKey()) != null) {
                Tracker tracker$OneID_release = OneID.this.getTracker$OneID_release();
                if (!zIsSuccess && (event = tracker$OneID_release.getEvent(trackerEventKey)) != null) {
                    event.appendCodes$OneID_release(null, null, "guest(invalid)");
                }
                Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, null, null, null, false, 62, null);
            }
            if (zIsSuccess) {
                PageLaunchData pageLaunchData6 = this.pageLaunchData;
                if (pageLaunchData6 != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[pageLaunchData6.getCallbackType().ordinal()]) {
                        case 1:
                            OneIDCallback callback4 = pageLaunchData6.getCallback();
                            oneIDCallback = callback4 != null ? callback4 : null;
                            if (oneIDCallback != null) {
                                oneIDCallback.onSuccess(new UpdateProfileCallbackData(true, null, guest, lightboxData.getUpdateProfileDelta(), Boolean.valueOf(lightboxData.getDidReauth()), Boolean.valueOf(lightboxData.getAccountDeleted())));
                                return;
                            }
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            OneIDCallback callback5 = pageLaunchData6.getCallback();
                            oneIDCallback = callback5 != null ? callback5 : null;
                            if (oneIDCallback != null) {
                                oneIDCallback.onSuccess(new GuestCallbackData(true, null, guest, Boolean.valueOf(lightboxData.getAccountCreated()), null, Boolean.valueOf(lightboxData.getDidReauth()), 16, null));
                                return;
                            }
                            return;
                        case 6:
                            OneIDCallback callback6 = pageLaunchData6.getCallback();
                            if (callback6 == null) {
                                callback6 = null;
                            }
                            if (callback6 != null) {
                                callback6.onSuccess(new EmailVerificationCallbackData(true, null));
                                return;
                            }
                            return;
                        case 7:
                            OneIDCallback callback7 = pageLaunchData6.getCallback();
                            if (callback7 == null) {
                                callback7 = null;
                            }
                            if (callback7 != null) {
                                callback7.onSuccess(new NewslettersCallbackData(true, null, lightboxData.getNewslettersResult()));
                                return;
                            }
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                return;
            }
            PageLaunchData pageLaunchData7 = this.pageLaunchData;
            if (pageLaunchData7 != null) {
                OneID oneID3 = OneID.this;
                switch (WhenMappings.$EnumSwitchMapping$0[pageLaunchData7.getCallbackType().ordinal()]) {
                    case 1:
                        OneIDCallback callback8 = pageLaunchData7.getCallback();
                        if (callback8 == null) {
                            callback8 = null;
                        }
                        if (callback8 != null) {
                            PageLaunchData pageLaunchData8 = this.pageLaunchData;
                            callback8.onFailure(new UpdateProfileCallbackData(false, OneID.createAndLogMissingGuestError$OneID_release$default(oneID3, pageLaunchData8 != null ? pageLaunchData8.getTrackerEventKey() : null, false, 2, null), null, null, Boolean.valueOf(lightboxData.getDidReauth()), Boolean.valueOf(lightboxData.getAccountDeleted()), 8, null));
                            return;
                        }
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        OneIDCallback callback9 = pageLaunchData7.getCallback();
                        if (callback9 == null) {
                            callback9 = null;
                        }
                        if (callback9 != null) {
                            PageLaunchData pageLaunchData9 = this.pageLaunchData;
                            callback9.onFailure(new GuestCallbackData(false, OneID.createAndLogMissingGuestError$OneID_release$default(oneID3, pageLaunchData9 != null ? pageLaunchData9.getTrackerEventKey() : null, false, 2, null), null, Boolean.valueOf(lightboxData.getAccountCreated()), null, Boolean.valueOf(lightboxData.getDidReauth()), 16, null));
                            return;
                        }
                        return;
                    case 6:
                        Logger logger$OneID_release = oneID3.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        logger$OneID_release.wtf(str, "Email Verification Error", new Throwable());
                        String emailVerificationErrorCode2 = lightboxData.getEmailVerificationErrorCode();
                        Tracker.DefaultImpls.finishEvent$default(oneID3.getTracker$OneID_release(), pageLaunchData7.getTrackerEventKey(), false, OneIDTrackerEvent.ERROR_CODE_EMAIL_VERIFY_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "errorcode(" + emailVerificationErrorCode2 + ")", false, 32, null);
                        OneIDError oneIDError2 = new OneIDError(OneIDError.EMAIL_VERIFICATION_FAILURE, String.valueOf(emailVerificationErrorCode2), null, 4, null);
                        OneIDCallback callback10 = pageLaunchData7.getCallback();
                        oneIDCallback = callback10 != null ? callback10 : null;
                        if (oneIDCallback != null) {
                            oneIDCallback.onFailure(new EmailVerificationCallbackData(false, oneIDError2));
                            return;
                        }
                        return;
                    case 7:
                        Logger logger$OneID_release2 = oneID3.getLogger$OneID_release();
                        String str2 = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                        logger$OneID_release2.wtf(str2, "The client config does not contain the provided promotion id", new Throwable());
                        Tracker.DefaultImpls.finishEvent$default(oneID3.getTracker$OneID_release(), pageLaunchData7.getTrackerEventKey(), false, "INVALID_PROMOTION_ID", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "mismatch(promotionid)", false, 32, null);
                        OneIDError oneIDError3 = new OneIDError("INVALID_PROMOTION_ID", "The client config does not contain the provided promotion id", null, 4, null);
                        OneIDCallback callback11 = pageLaunchData7.getCallback();
                        if (callback11 == null) {
                            callback11 = null;
                        }
                        if (callback11 != null) {
                            callback11.onFailure(new NewslettersCallbackData(false, oneIDError3, null));
                            return;
                        }
                        return;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSuccess(Guest guest, NewslettersResult newslettersResult, String emailVerificationErrorCode, CallbackType callbackType) {
        if (CallbackType.PROFILE == callbackType || CallbackType.LOGIN == callbackType || CallbackType.PPU == callbackType || (CallbackType.REGISTER == callbackType && guest != null)) {
            return true;
        }
        if (CallbackType.NEWSLETTERS != callbackType || newslettersResult == null) {
            return (CallbackType.EMAIL_VERIFICATION == callbackType && emailVerificationErrorCode == null) || CallbackType.EXPIRED_SESSION == callbackType;
        }
        return true;
    }

    public static /* synthetic */ void getEditableProfileFields$default(OneID oneID, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 2) != 0) {
            optionalConfigs = null;
        }
        oneID.getEditableProfileFields(oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void getEditableProfileFields(@NotNull OneIDCallback<EditFieldsCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        OptionalConfigs optionalConfigs3 = (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_EDITABLE_PROFILE_FIELDS, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Attempt to get editable fields when not logged in", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            DefaultConstructorMarker defaultConstructorMarker = null;
            callback.onFailure(new EditFieldsCallbackData(false, new OneIDError("NOT_LOGGED_IN", null, null, 6, defaultConstructorMarker), 0 == true ? 1 : 0, 4, defaultConstructorMarker));
            return;
        }
        final WeakReference weakReference = new WeakReference(callback);
        final Function1 function1 = new Function1() { // from class: com.disney.id.android.OneID$getEditableProfileFields$handleSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List fields) {
                Intrinsics.checkNotNullParameter(fields, "fields");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    Logger logger$OneID_release2 = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, str, "getEditableProfileFields succeeded; invoking success callback", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                    oneIDCallback.onSuccess(new EditFieldsCallbackData(true, null, fields, 2, null));
                }
            }
        };
        final Function1 function12 = new Function1() { // from class: com.disney.id.android.OneID$getEditableProfileFields$handleFailure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OneIDError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OneIDError oneIDError) {
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    Logger logger$OneID_release2 = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release2, str, "getEditableProfileFields failed; invoking failure callback", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                    oneIDCallback.onFailure(new EditFieldsCallbackData(false, oneIDError, null, 4, null));
                }
            }
        };
        getGuestInternal(new OneIDCallback<GuestCallbackData>() { // from class: com.disney.id.android.OneID$getEditableProfileFields$guestCallback$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v11, types: [kotlin.Unit] */
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull GuestCallbackData data) {
                OneIDError oneIDError;
                Map<String, Object> editableConfigFields;
                JsonElement rawGuest$OneID_release;
                JsonObject asJsonObject;
                Profile profile;
                Intrinsics.checkNotNullParameter(data, "data");
                Guest guest = data.getGuest();
                OneIDError oneIDError2 = null;
                String ageBand = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getAgeBand();
                Guest guest2 = data.getGuest();
                JsonElement jsonElement = (guest2 == null || (rawGuest$OneID_release = guest2.getRawGuest$OneID_release()) == null || (asJsonObject = rawGuest$OneID_release.getAsJsonObject()) == null) ? null : asJsonObject.get("profile");
                SCALPController scalpController$OneID_release = this.this$0.getScalpController$OneID_release();
                OneIDSCALPController oneIDSCALPController = scalpController$OneID_release instanceof OneIDSCALPController ? (OneIDSCALPController) scalpController$OneID_release : null;
                if (jsonElement == null || ageBand == null) {
                    oneIDError = new OneIDError("INVALID_JSON", "Unable to extract guest profile.", null, 4, null);
                } else {
                    if (oneIDSCALPController == null || (editableConfigFields = EditableFieldExtensionsKt.getEditableConfigFields(oneIDSCALPController, ageBand)) == null) {
                        oneIDError = null;
                    } else {
                        OneID oneID = this.this$0;
                        Function1 function13 = function1;
                        List<EditableField> profileFields = EditableFieldExtensionsKt.getProfileFields(oneID, new JSONObject(jsonElement.toString()), editableConfigFields);
                        if (!profileFields.isEmpty()) {
                            function13.invoke(profileFields);
                        } else {
                            oneIDError2 = new OneIDError("UNKNOWN_ERROR", "Unable to extract editable profile fields.", null, 4, null);
                        }
                        OneIDError oneIDError3 = oneIDError2;
                        oneIDError2 = Unit.INSTANCE;
                        oneIDError = oneIDError3;
                    }
                    if (oneIDError2 == null) {
                        oneIDError = new OneIDError(OneIDError.INVALID_CONFIG, "Unable to extract configuration for current age band.", null, 4, null);
                    }
                }
                if (oneIDError != null) {
                    function12.invoke(oneIDError);
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                function12.invoke(data.getError());
            }
        }, true, false, trackerEventKeyStartConversationEvent$default, optionalConfigs3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setEditableProfileFields$default(OneID oneID, List list, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) throws JsonSyntaxException, JsonIOException {
        if ((i & 2) != 0) {
            oneIDCallback = null;
        }
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.setEditableProfileFields((List<EditableField>) list, (OneIDCallback<GuestCallbackData>) oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull List<EditableField> fields, @Nullable OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) throws JsonSyntaxException, JsonIOException {
        Intrinsics.checkNotNullParameter(fields, "fields");
        JsonElement jsonTree = new GsonBuilder().serializeNulls().create().toJsonTree(EditableFieldExtensionsKt.toProfileMap(fields), new TypeToken<Map<String, ? extends Object>>() { // from class: com.disney.id.android.OneID$setEditableProfileFields$mapType$1
        }.getType());
        Intrinsics.checkNotNull(jsonTree);
        setEditableProfileFields(jsonTree, callback, optionalConfigs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setEditableProfileFields$default(OneID oneID, JsonElement jsonElement, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) throws JsonSyntaxException {
        if ((i & 2) != 0) {
            oneIDCallback = null;
        }
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.setEditableProfileFields(jsonElement, (OneIDCallback<GuestCallbackData>) oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void setEditableProfileFields(@NotNull JsonElement jsonProfile, @Nullable final OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) throws JsonSyntaxException {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(jsonProfile, "jsonProfile");
        JsonObject jsonObject = new JsonObject();
        Guest guest = getGuestHandler$OneID_release().get();
        String etag = guest != null ? guest.getEtag() : null;
        JsonElement string = JsonParser.parseString(jsonProfile.toString());
        if (etag == null) {
            etag = "";
        }
        jsonObject.addProperty(Guest.ETAG, etag);
        jsonObject.add("profile", string);
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_SET_EDITABLE_PROFILE_FIELDS, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Attempt to set editable profile fields when not logged in", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            OneIDError oneIDError = new OneIDError("NOT_LOGGED_IN", null, null, 6, null);
            if (callback != null) {
                callback.onFailure(new GuestCallbackData(false, oneIDError, null, null, null, null, 60, null));
                return;
            }
            return;
        }
        if (!getSession$OneID_release().highTrust()) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "Attempt to set editable profile fields when in low trust", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, OneIDTrackerEvent.ERROR_CODE_HIGH_TRUST_REQUIRED, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            OneIDError oneIDError2 = new OneIDError(OneIDError.LOW_TRUST, null, null, 6, null);
            if (callback != null) {
                callback.onFailure(new GuestCallbackData(false, oneIDError2, null, null, null, null, 60, null));
                return;
            }
            return;
        }
        getSession$OneID_release().updateGuest(jsonObject, optionalConfigsMerge$OneID_release, trackerEventKeyStartConversationEvent$default.getId(), new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.setEditableProfileFields.1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                OneIDCallback oneIDCallback = callback;
                if (oneIDCallback != null) {
                    oneIDCallback.onSuccess(new GuestCallbackData(true, null, OneID.this.getGuestHandler$OneID_release().get(), null, null, null, 58, null));
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Tracker tracker$OneID_release = OneID.this.getTracker$OneID_release();
                TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                OneIDError error = data.getError();
                Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                OneIDCallback oneIDCallback = callback;
                if (oneIDCallback != null) {
                    oneIDCallback.onFailure(new GuestCallbackData(false, data.getError(), null, null, null, null, 60, null));
                }
            }
        });
    }

    public static /* synthetic */ Guest getGuest$default(OneID oneID, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 1) != 0) {
            optionalConfigs = null;
        }
        return oneID.getGuest(optionalConfigs);
    }

    @JvmOverloads
    @Nullable
    public final Guest getGuest(@Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_GUEST_SYNC, getSwid$OneID_release().get(), null, (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Attempt to get guest when not logged in", null, 4, null);
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
            if (event != null) {
                event.appendCodes$OneID_release("NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null);
            }
        }
        Guest guest = getGuestHandler$OneID_release().get();
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
        return guest;
    }

    public static /* synthetic */ void getGuest$default(OneID oneID, Context context, OneIDCallback oneIDCallback, boolean z, boolean z2, OptionalConfigs optionalConfigs, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? false : z;
        boolean z4 = (i & 8) != 0 ? false : z2;
        if ((i & 16) != 0) {
            optionalConfigs = null;
        }
        oneID.getGuest(context, oneIDCallback, z3, z4, optionalConfigs);
    }

    @JvmOverloads
    public final void getGuest(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, boolean fullPayload, boolean forceRefresh, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_GUEST, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        final boolean z = fullPayload || forceRefresh;
        final WeakReference weakReference = new WeakReference(callback);
        getGuestInternal(new OneIDCallback<GuestCallbackData>() { // from class: com.disney.id.android.OneID$getGuest$innerCallback$1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) this.this$0.resolveCallbackWeakReference$OneID_release(weakReference, trackerEventKeyStartConversationEvent$default, z);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    boolean z2 = z;
                    Logger logger$OneID_release = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuest succeeded; invoking success callback", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, z2, 30, null);
                    oneIDCallback.onSuccess(data);
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) this.this$0.resolveCallbackWeakReference$OneID_release(weakReference, trackerEventKeyStartConversationEvent$default, z);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    boolean z2 = z;
                    Logger logger$OneID_release = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuest failed; invoking failure callback", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, z2, 30, null);
                    oneIDCallback.onFailure(data);
                }
            }
        }, fullPayload, forceRefresh, trackerEventKeyStartConversationEvent$default, optionalConfigsMerge$OneID_release);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c4, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r8 != null ? r8.getPayload() : null, com.disney.id.android.Guest.PAYLOAD_FULL) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getGuestInternal(final com.disney.id.android.OneIDCallback r19, boolean r20, boolean r21, final com.disney.id.android.tracker.TrackerEventKey r22, com.disney.id.android.OptionalConfigs r23) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneID.getGuestInternal(com.disney.id.android.OneIDCallback, boolean, boolean, com.disney.id.android.tracker.TrackerEventKey, com.disney.id.android.OptionalConfigs):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadGuest(String refreshToken) {
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.LOG_EXTERNAL_REFRESH, getSwid$OneID_release().get(), null, null, 25, null);
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        String conversationId$OneID_release = event != null ? event.getConversationId$OneID_release() : null;
        getGuestHandler$OneID_release().setExternalRefreshToken(refreshToken);
        Session.DefaultImpls.end$default(getSession$OneID_release(), null, conversationId$OneID_release, 1, null);
        this.sessionOwner.getCallbackList().add(new RefreshTokenCallback() { // from class: com.disney.id.android.OneID$reloadGuest$refreshTokenCallback$1
            @Override // com.disney.id.android.OneID.RefreshTokenCallback
            public void onSuccess() {
                JsonObject asJsonObject;
                JsonElement jsonElement;
                String asString;
                final OneID oneID = this.this$0;
                final TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                Session.ResultCallback resultCallback = new Session.ResultCallback() { // from class: com.disney.id.android.OneID$reloadGuest$refreshTokenCallback$1$onSuccess$refreshGuestCallback$1
                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onSuccess() {
                        Logger logger$OneID_release = oneID.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuest completed successfully", null, 4, null);
                        oneID.getGuestHandler$OneID_release().clearTransientValues();
                        OneIDListener delegate = oneID.getDelegate();
                        if (delegate != null) {
                            delegate.onTokenRefreshSuccess();
                        }
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                    }

                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onFailure(@NotNull OneIDError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Logger logger$OneID_release = oneID.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuest failed", null, 4, null);
                        oneID.getGuestHandler$OneID_release().clearTransientValues();
                        OneIDListener delegate = oneID.getDelegate();
                        if (delegate != null) {
                            delegate.onTokenRefreshFailure();
                        }
                        OneIDTrackerEvent event2 = oneID.getTracker$OneID_release().getEvent(trackerEventKey);
                        if (event2 != null) {
                            event2.appendCodes$OneID_release(error.getCode(), OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null);
                        }
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                    }
                };
                JsonElement transientToken = this.this$0.getGuestHandler$OneID_release().getTransientToken();
                if (transientToken != null && (asJsonObject = transientToken.getAsJsonObject()) != null && (jsonElement = asJsonObject.get("swid")) != null && (asString = jsonElement.getAsString()) != null) {
                    OneID oneID2 = this.this$0;
                    TrackerEventKey trackerEventKey2 = trackerEventKeyStartConversationEvent$default;
                    oneID2.getSwid$OneID_release().set(asString);
                    Session session$OneID_release = oneID2.getSession$OneID_release();
                    OneIDTrackerEvent event2 = oneID2.getTracker$OneID_release().getEvent(trackerEventKey2);
                    session$OneID_release.refreshGuest(resultCallback, null, event2 != null ? event2.getConversationId$OneID_release() : null);
                    return;
                }
                OneID oneID3 = this.this$0;
                TrackerEventKey trackerEventKey3 = trackerEventKeyStartConversationEvent$default;
                Logger logger$OneID_release = oneID3.getLogger$OneID_release();
                String str = OneID.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Unable to extract swid from refreshToken callback", null, 4, null);
                oneID3.getGuestHandler$OneID_release().clearTransientValues();
                OneIDListener delegate = oneID3.getDelegate();
                if (delegate != null) {
                    delegate.onTokenRefreshFailure();
                }
                OneIDTrackerEvent event3 = oneID3.getTracker$OneID_release().getEvent(trackerEventKey3);
                if (event3 != null) {
                    event3.appendCodes$OneID_release(null, "UNKNOWN_ERROR", null);
                }
                Tracker.DefaultImpls.finishEvent$default(oneID3.getTracker$OneID_release(), trackerEventKey3, false, null, null, null, false, 62, null);
            }

            @Override // com.disney.id.android.OneID.RefreshTokenCallback
            public void onFailure(@Nullable OneIDError error) {
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneID.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.w$default(logger$OneID_release, str, "refreshToken with externalToken failed", null, 4, null);
                this.this$0.getGuestHandler$OneID_release().clearTransientValues();
                OneIDListener delegate = this.this$0.getDelegate();
                if (delegate != null) {
                    delegate.onTokenRefreshFailure();
                }
                OneIDTrackerEvent event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                if (event2 != null) {
                    event2.appendCodes$OneID_release(error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null);
                }
                Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            }
        });
        getSession$OneID_release().scheduleTokenRefresh(0L, conversationId$OneID_release, "source(reloadGuest)");
    }

    public static /* synthetic */ void getToken$default(OneID oneID, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            optionalConfigs = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        oneID.getToken(oneIDCallback, optionalConfigs, z);
    }

    @JvmOverloads
    public final void getToken(@NotNull OneIDCallback<TokenCallbackData> callback, @Nullable OptionalConfigs optionalConfigs, final boolean serverUpdate) {
        Token token$OneID_release;
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "getToken // serverUpdate = " + serverUpdate, null, 4, null);
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_TOKEN, getSwid$OneID_release().get(), null, (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release, 9, null);
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        if (event != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("serverUpdate(%b)", Arrays.copyOf(new Object[]{Boolean.valueOf(serverUpdate)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            event.appendCodes$OneID_release(null, null, str);
        }
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG2, "getToken failed - Not logged in", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, serverUpdate, 16, null);
            callback.onFailure(new TokenCallbackData(null, false, new OneIDError("NOT_LOGGED_IN", null, null, 6, null)));
            return;
        }
        if (!serverUpdate) {
            Guest guest = getGuestHandler$OneID_release().get();
            if (guest != null && (token$OneID_release = guest.getToken$OneID_release()) != null) {
                Long accessExp = token$OneID_release.getAccessExp();
                long jLongValue = ((accessExp != null ? accessExp.longValue() : 0L) - System.currentTimeMillis()) / 1000;
                if (jLongValue >= (token$OneID_release.getAccessTokenTTL() != null ? r6.longValue() * 0.1d : jLongValue + 1.0d) || jLongValue > 600) {
                    Logger logger$OneID_release3 = getLogger$OneID_release();
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    Logger.DefaultImpls.d$default(logger$OneID_release3, TAG2, "getToken complete with local token", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                    callback.onSuccess(new TokenCallbackData(token$OneID_release.exposedCopy$OneID_release(), true, null, 4, null));
                    return;
                }
            }
            Logger logger$OneID_release4 = getLogger$OneID_release();
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release4, TAG2, "getToken going to server", null, 4, null);
        }
        final WeakReference weakReference = new WeakReference(callback);
        this.sessionOwner.getCallbackList().add(new RefreshTokenCallback() { // from class: com.disney.id.android.OneID$getToken$refreshTokenCallback$1
            @Override // com.disney.id.android.OneID.RefreshTokenCallback
            public void onSuccess() {
                OneIDCallback oneIDCallback = (OneIDCallback) this.this$0.resolveCallbackWeakReference$OneID_release(weakReference, trackerEventKeyStartConversationEvent$default, serverUpdate);
                if (oneIDCallback != null) {
                    Guest guest2 = this.this$0.getGuestHandler$OneID_release().get();
                    if (guest2 != null) {
                        Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, serverUpdate, 30, null);
                        Token token$OneID_release2 = guest2.getToken$OneID_release();
                        oneIDCallback.onSuccess(new TokenCallbackData(token$OneID_release2 != null ? token$OneID_release2.exposedCopy$OneID_release() : null, true, null, 4, null));
                        return;
                    }
                    oneIDCallback.onFailure(new TokenCallbackData(null, false, OneID.createAndLogMissingGuestError$OneID_release$default(this.this$0, trackerEventKeyStartConversationEvent$default, false, 2, null)));
                }
            }

            @Override // com.disney.id.android.OneID.RefreshTokenCallback
            public void onFailure(@Nullable OneIDError error) {
                OneIDTrackerEvent event2;
                Throwable throwable;
                OneIDCallback oneIDCallback = (OneIDCallback) this.this$0.resolveCallbackWeakReference$OneID_release(weakReference, trackerEventKeyStartConversationEvent$default, serverUpdate);
                if (oneIDCallback != null) {
                    Logger logger$OneID_release5 = this.this$0.getLogger$OneID_release();
                    String str2 = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release5, str2, "getToken failed; invoking callback", null, 4, null);
                    if (Intrinsics.areEqual((error == null || (throwable = error.getThrowable()) == null) ? null : throwable.getLocalizedMessage(), "timeout") && (event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default)) != null) {
                        event2.appendCodes$OneID_release(null, "TIMED_OUT", null);
                    }
                    Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, serverUpdate, 30, null);
                    oneIDCallback.onFailure(new TokenCallbackData(null, false, error));
                }
            }
        });
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event2 = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.scheduleTokenRefresh(0L, event2 != null ? event2.getConversationId$OneID_release() : null, "source(getToken)");
    }

    public static /* synthetic */ void getInlineNewsletters$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.getInlineNewsletters(context, str, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void getInlineNewsletters(@NotNull Context activityContext, @NotNull final String campaignId, @NotNull OneIDCallback<GetInlineNewslettersCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) != null) {
            optionalConfigs = optionalConfigsMerge$OneID_release;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_INLINE_NEWSLETTERS, getSwid$OneID_release().get(), null, optionalConfigs, 9, null);
        if (getSession$OneID_release().isLoggedIn()) {
            Guest guest = getGuestHandler$OneID_release().get();
            if (!StringsKt.equals$default(guest != null ? guest.getPayload() : null, Guest.PAYLOAD_FULL, false, 2, null)) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Need full guest for getInlineNewsletters, refreshing", null, 4, null);
                final WeakReference weakReference = new WeakReference(callback);
                Session.ResultCallback resultCallback = new Session.ResultCallback() { // from class: com.disney.id.android.OneID$getInlineNewsletters$refreshGuestCallback$1
                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onSuccess() {
                        OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                        if (oneIDCallback != null) {
                            Guest guest2 = this.this$0.getGuestHandler$OneID_release().get();
                            if (StringsKt.equals$default(guest2 != null ? guest2.getPayload() : null, Guest.PAYLOAD_FULL, false, 2, null)) {
                                Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                                String str = OneID.TAG;
                                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                                Logger.DefaultImpls.d$default(logger$OneID_release2, str, "refreshGuest completed successfully", null, 4, null);
                                this.this$0.getInlineNewslettersHelper(campaignId, trackerEventKeyStartConversationEvent$default, oneIDCallback);
                                return;
                            }
                            oneIDCallback.onFailure(new GetInlineNewslettersCallbackData(null, false, OneID.createAndLogMissingGuestError$OneID_release$default(this.this$0, trackerEventKeyStartConversationEvent$default, false, 2, null)));
                        }
                    }

                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onFailure(@NotNull OneIDError error) {
                        OneIDTrackerEvent event;
                        Intrinsics.checkNotNullParameter(error, "error");
                        OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                        if (oneIDCallback != null) {
                            Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                            String str = OneID.TAG;
                            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                            Logger.DefaultImpls.d$default(logger$OneID_release2, str, "refreshGuest failed; invoking callback", null, 4, null);
                            Throwable throwable = error.getThrowable();
                            if (Intrinsics.areEqual(throwable != null ? throwable.getLocalizedMessage() : null, "timeout") && (event = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default)) != null) {
                                event.appendCodes$OneID_release(null, "TIMED_OUT", null);
                            }
                            Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                            oneIDCallback.onFailure(new GetInlineNewslettersCallbackData(null, false, error));
                        }
                    }
                };
                Session session$OneID_release = getSession$OneID_release();
                OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                session$OneID_release.refreshGuest(resultCallback, optionalConfigs, event != null ? event.getConversationId$OneID_release() : null);
                return;
            }
        }
        getInlineNewslettersHelper(campaignId, trackerEventKeyStartConversationEvent$default, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getInlineNewslettersHelper(String campaignId, TrackerEventKey trackerEventKey, OneIDCallback callback) {
        JSONObject jSONObjectOptJSONObject;
        Guest guest = getGuestHandler$OneID_release().get();
        List legalDetails = null;
        Profile profile = guest != null ? guest.getProfile() : null;
        if (StringsKt.equals$default(profile != null ? profile.getAgeBand() : null, "CHILD", false, 2, null)) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Guest was a CHILD in getInlineNewsletters", null, 4, null);
            OneIDError oneIDError = new OneIDError("AGE_GATED", null, null, 6, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, "AGE_GATED", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            callback.onFailure(new GetInlineNewslettersCallbackData(null, false, oneIDError));
            return;
        }
        if (!StringsKt.equals(Locale.US.getCountry(), getSession$OneID_release().getCountryCode(), true)) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG3, "Country was not US in getInlineNewsletters", null, 4, null);
            OneIDError oneIDError2 = new OneIDError("INVALID_LOCATION", null, null, 6, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, "INVALID_LOCATION", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            callback.onFailure(new GetInlineNewslettersCallbackData(null, false, oneIDError2));
            return;
        }
        JSONArray newslettersForCampaignId = getScalpController$OneID_release().getNewslettersForCampaignId(campaignId);
        if (newslettersForCampaignId == null) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release3, TAG4, "Campaign does not exist in getInlineNewsletters", null, 4, null);
            OneIDError oneIDError3 = new OneIDError("NO_VALID_CAMPAIGN", null, null, 6, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, "NO_VALID_CAMPAIGN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            callback.onFailure(new GetInlineNewslettersCallbackData(null, false, oneIDError3));
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = newslettersForCampaignId.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject2 = newslettersForCampaignId.optJSONObject(i);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONArray("lists") : null;
            int length2 = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
            for (int i2 = 0; i2 < length2; i2++) {
                if (jSONArrayOptJSONArray != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2)) != null) {
                    arrayList.add(jSONObjectOptJSONObject);
                }
            }
        }
        List<Marketing> marketing = guest != null ? guest.getMarketing() : null;
        String email = profile != null ? profile.getEmail() : null;
        if (getSession$OneID_release().isLoggedIn()) {
            if (marketing != null ? isAllOptedIn(marketing, arrayList) : false) {
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release4, TAG5, "User was opted in to all in getInlineNewsletters", null, 4, null);
                Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, "ALREADY_OPT_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
                callback.onFailure(new GetInlineNewslettersCallbackData(null, false, OneIDError.INSTANCE.buildAlreadyOptIn$OneID_release()));
                return;
            }
        } else {
            legalDetails = getLegalDetails();
        }
        List marketingDetails = getMarketingDetails(arrayList, getSession$OneID_release().isLoggedIn(), marketing);
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
        callback.onSuccess(new GetInlineNewslettersCallbackData(new NewsletterDetails(campaignId, email, legalDetails, marketingDetails), true, null, 4, null));
    }

    private final boolean isAllOptedIn(List guestMarketingArray, List newslettersList) {
        Iterator it = newslettersList.iterator();
        while (it.hasNext()) {
            String strOptString = ((JSONObject) it.next()).optString("name");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            if (!isOptedIn(guestMarketingArray, strOptString)) {
                return false;
            }
        }
        return true;
    }

    private final boolean isOptedIn(List guestMarketingArray, String newsletterName) {
        Iterator it = guestMarketingArray.iterator();
        while (it.hasNext()) {
            Marketing marketing = (Marketing) it.next();
            if (Intrinsics.areEqual(marketing.getCode(), newsletterName)) {
                Boolean subscribed = marketing.getSubscribed();
                if (subscribed != null) {
                    return subscribed.booleanValue();
                }
                return false;
            }
        }
        return false;
    }

    private final List getLegalDetails() {
        JSONObject jSONObjectOptJSONObject;
        String stringSafely;
        ArrayList arrayList = new ArrayList();
        JSONArray legalDisclosures = getScalpController$OneID_release().getLegalDisclosures();
        int length = legalDisclosures != null ? legalDisclosures.length() : 0;
        for (int i = 0; i < length; i++) {
            if (legalDisclosures != null && (jSONObjectOptJSONObject = legalDisclosures.optJSONObject(i)) != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("content");
                String stringSafely2 = JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject, "disclosureCode");
                Boolean boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optBoolean("requiresActiveConsent"));
                if (jSONObjectOptJSONObject2 != null) {
                    Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
                    stringSafely = JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject2, "text");
                } else {
                    stringSafely = null;
                }
                arrayList.add(new LegalDetail(stringSafely2, boolValueOf, false, stringSafely, createPlainTextLinks(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONArray("links") : null)));
            }
        }
        return arrayList;
    }

    private final List getMarketingDetails(List newslettersList, boolean loggedIn, List guestMarketingArray) {
        boolean zIsOptedIn;
        ArrayList arrayList = new ArrayList();
        Iterator it = newslettersList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            String strOptString = jSONObject.optString("name");
            if (!loggedIn || guestMarketingArray == null) {
                zIsOptedIn = false;
            } else {
                Intrinsics.checkNotNull(strOptString);
                zIsOptedIn = isOptedIn(guestMarketingArray, strOptString);
            }
            boolean z = zIsOptedIn;
            Intrinsics.checkNotNull(strOptString);
            boolean zOptBoolean = jSONObject.optBoolean("checked");
            String strOptString2 = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            String strOptString3 = jSONObject.optString("textId");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            arrayList.add(new MarketingDetail(strOptString, true, zOptBoolean, z, strOptString2, strOptString3, createPlainTextLinks(jSONObject.optJSONArray("links"))));
        }
        return arrayList;
    }

    private final List getRegisterFields() {
        Iterator<String> itKeys;
        ArrayList arrayList = new ArrayList();
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"firstName", "lastName", "middleName", "suffix", "prefix", "pronunciationName", "username", "email", "displayName", HintConstants.AUTOFILL_HINT_PASSWORD, "gender", "dateOfBirth", "languagePreference"});
        JSONObject registerFields = getScalpController$OneID_release().getRegisterFields();
        JSONObject jSONObjectOptJSONObject = registerFields != null ? registerFields.optJSONObject("email") : null;
        if (registerFields != null && (itKeys = registerFields.keys()) != null) {
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = registerFields.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
                    boolean zOptBoolean = jSONObjectOptJSONObject2.optBoolean("required");
                    if (!Intrinsics.areEqual(jSONObjectOptJSONObject2.optString("editable"), "NOT_ALLOWED")) {
                        if (!Intrinsics.areEqual(next, "username") && listListOf.contains(next)) {
                            Intrinsics.checkNotNull(next);
                            arrayList.add(new Field(next, zOptBoolean, null));
                        } else if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.optBoolean("required") && Intrinsics.areEqual(jSONObjectOptJSONObject.optString("editable"), "NOT_ALLOWED")) {
                            Intrinsics.checkNotNull(next);
                            arrayList.add(new Field(next, zOptBoolean, null));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final List createPlainTextLinks(JSONArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new PlainTextLink(Integer.valueOf(jSONObjectOptJSONObject.optInt(ViewProps.START)), JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject, "label"), JSONExtensionsKt.getStringSafely(jSONObjectOptJSONObject, "href")));
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void setInlineNewsletters$default(OneID oneID, Context context, NewsletterDetails newsletterDetails, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.setInlineNewsletters(context, newsletterDetails, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void setInlineNewsletters(@NotNull Context activityContext, @NotNull final NewsletterDetails newsletterDetails, @NotNull final OneIDCallback<SetInlineNewslettersCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(newsletterDetails, "newsletterDetails");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        final OptionalConfigs optionalConfigs3 = (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_SET_INLINE_NEWSLETTERS, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        String email = newsletterDetails.getEmail();
        if (email == null || StringsKt.isBlank(email)) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "newsletter details email was missing", null, 4, null);
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
            if (event != null) {
                event.appendCodes$OneID_release("INVALID_EMAIL", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(email)");
            }
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            callback.onFailure(new SetInlineNewslettersCallbackData(false, new OneIDError("INVALID_EMAIL", "Missing email.", null, 4, null)));
            return;
        }
        if (!StringsKt.equals(Locale.US.getCountry(), getSession$OneID_release().getCountryCode(), true)) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "Country was not US in setInlineNewsletters", null, 4, null);
            OneIDTrackerEvent event2 = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
            if (event2 != null) {
                event2.appendCodes$OneID_release("INVALID_LOCATION", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null);
            }
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            callback.onFailure(new SetInlineNewslettersCallbackData(false, new OneIDError("INVALID_LOCATION", null, null, 6, null)));
            return;
        }
        if (getSession$OneID_release().isLoggedIn()) {
            ensureGuestHasEmailBefore(trackerEventKeyStartConversationEvent$default, optionalConfigs3, new Function0() { // from class: com.disney.id.android.OneID.setInlineNewsletters.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1827invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1827invoke() {
                    Profile profile;
                    Guest guest = OneID.this.getGuestHandler$OneID_release().get();
                    String email2 = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getEmail();
                    if (!StringsKt.equals(newsletterDetails.getEmail(), email2, true)) {
                        OneIDTrackerEvent event3 = OneID.this.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                        if (event3 != null) {
                            event3.appendCodes$OneID_release("EMAIL_MISMATCH", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "email(mismatch)");
                        }
                        Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                        callback.onFailure(new SetInlineNewslettersCallbackData(false, new OneIDError("EMAIL_MISMATCH", "Email: " + newsletterDetails.getEmail() + " does not match guest email: " + email2, null, 4, null)));
                    }
                    Session session$OneID_release = OneID.this.getSession$OneID_release();
                    JsonObject guestUpdateBody = OneID.this.getGuestUpdateBody(newsletterDetails, optionalConfigs3);
                    OptionalConfigs optionalConfigs4 = optionalConfigs3;
                    String id = trackerEventKeyStartConversationEvent$default.getId();
                    final OneID oneID = OneID.this;
                    final TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    final OneIDCallback oneIDCallback = callback;
                    session$OneID_release.updateGuest(guestUpdateBody, optionalConfigs4, id, new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.setInlineNewsletters.1.1
                        @Override // com.disney.id.android.OneIDCallback
                        public void onSuccess(@NotNull OneIDCallbackData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 62, null);
                            oneIDCallback.onSuccess(new SetInlineNewslettersCallbackData(data));
                        }

                        @Override // com.disney.id.android.OneIDCallback
                        public void onFailure(@NotNull OneIDCallbackData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            Tracker tracker$OneID_release = oneID.getTracker$OneID_release();
                            TrackerEventKey trackerEventKey2 = trackerEventKey;
                            OneIDError error = data.getError();
                            Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey2, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                            oneIDCallback.onFailure(new SetInlineNewslettersCallbackData(data));
                        }
                    });
                }
            }, new Function1() { // from class: com.disney.id.android.OneID.setInlineNewsletters.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OneIDError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(OneIDError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, error.getCode(), OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    callback.onFailure(new SetInlineNewslettersCallbackData(false, error));
                }
            });
        } else {
            getSession$OneID_release().updateMarketing(newsletterDetails, optionalConfigs3, trackerEventKeyStartConversationEvent$default.getId(), new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.setInlineNewsletters.3
                @Override // com.disney.id.android.OneIDCallback
                public void onSuccess(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                    callback.onSuccess(new SetInlineNewslettersCallbackData(data));
                }

                @Override // com.disney.id.android.OneIDCallback
                public void onFailure(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Tracker tracker$OneID_release = OneID.this.getTracker$OneID_release();
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    OneIDError error = data.getError();
                    Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    callback.onFailure(new SetInlineNewslettersCallbackData(data));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject getGuestUpdateBody(NewsletterDetails newsletter, OptionalConfigs options) {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (MarketingDetail marketingDetail : newsletter.getMarketing()) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("code", marketingDetail.getCode());
            jsonObject2.addProperty("subscribed", Boolean.valueOf(marketingDetail.getSubscribed()));
            jsonObject2.addProperty("textID", marketingDetail.getTextId());
            jsonArray.add(jsonObject2);
        }
        jsonObject.add("marketing", jsonArray);
        jsonObject.addProperty("marketingSource", options != null ? options.getReportingSource() : null);
        return jsonObject;
    }

    private final void ensureGuestHasEmailBefore(TrackerEventKey trackerEventKey, OptionalConfigs optionalConfigs, final Function0 success, final Function1 failure) {
        Profile profile;
        Guest guest = getGuestHandler$OneID_release().get();
        if (((guest == null || (profile = guest.getProfile()) == null) ? null : profile.getEmail()) == null) {
            if (!Intrinsics.areEqual(guest != null ? guest.getPayload() : null, Guest.PAYLOAD_FULL)) {
                Session session$OneID_release = getSession$OneID_release();
                Session.ResultCallback resultCallback = new Session.ResultCallback() { // from class: com.disney.id.android.OneID.ensureGuestHasEmailBefore.1
                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onSuccess() {
                        success.invoke();
                    }

                    @Override // com.disney.id.android.Session.ResultCallback
                    public void onFailure(@NotNull OneIDError error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        failure.invoke(error);
                    }
                };
                OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKey);
                session$OneID_release.refreshGuest(resultCallback, optionalConfigs, event != null ? event.getConversationId$OneID_release() : null);
                return;
            }
        }
        success.invoke();
    }

    public static /* synthetic */ PasswordScore getPasswordScore$default(OneID oneID, Context context, String str, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        return oneID.getPasswordScore(context, str, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    @NotNull
    public final PasswordScore getPasswordScore(@NotNull Context activityContext, @NotNull String password, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(password, "password");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_PASSWORD_SCORE, getSwid$OneID_release().get(), null, (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            return new PasswordScore(OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release());
        }
        PasswordScore score = PasswordValidation.INSTANCE.getScore(password);
        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
        return score;
    }

    public static /* synthetic */ void login$default(OneID oneID, String str, String str2, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.login(str, str2, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void login(@NotNull String loginValue, @NotNull String password, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        final OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LOGIN, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            callback.onFailure(new GuestCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release(), null, null, null, null, 60, null));
            return;
        }
        if (StringsKt.isBlank(loginValue)) {
            OneIDError oneIDError = new OneIDError("INVALID_LOGIN_VALUE", "missing(loginValue)", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "MISSING_VALUE", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(loginValue)", false, 32, null);
            callback.onFailure(new GuestCallbackData(false, oneIDError, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, null, 60, null));
            return;
        }
        if (StringsKt.isBlank(password)) {
            OneIDError oneIDError2 = new OneIDError(OneIDError.INVALID_PASSWORD, "missing(password)", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "MISSING_VALUE", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(password)", false, 32, null);
            callback.onFailure(new GuestCallbackData(false, oneIDError2, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, null, 60, null));
            return;
        }
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigsMerge$OneID_release, event != null ? event.getConversationId$OneID_release() : null);
        final WeakReference weakReference = new WeakReference(callback);
        getSession$OneID_release().login(loginValue, password, new OneIDCallback<GuestCallbackData>() { // from class: com.disney.id.android.OneID$login$loginCallback$1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "login completed successfully and returning callback", null, 4, null);
                    Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                    OneIDTrackerEvent event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                    Tracker.DefaultImpls.trackInstantEvent$default(tracker$OneID_release, event2 != null ? event2.getConversationId$OneID_release() : null, false, EventAction.EVENT_LOGIN, this.this$0.getSwid$OneID_release().get(), null, null, null, optionalConfigsMerge$OneID_release, false, 370, null);
                    Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
                    oneIDCallback.onSuccess(data);
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "login failed; invoking callback", null, 4, null);
                    Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    OneIDError error = data.getError();
                    Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    oneIDCallback.onFailure(data);
                }
            }
        }, trackerEventKeyStartConversationEvent$default.getId(), optionalConfigsMerge$OneID_release);
    }

    public static /* synthetic */ void getGuestFlow$default(OneID oneID, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.getGuestFlow(str, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getGuestFlow(@NotNull String loginValue, @NotNull OneIDCallback<GuestFlowCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(loginValue, "loginValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_GUESTFLOW, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            callback.onFailure(new GuestFlowCallbackData(null, false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
        } else if (StringsKt.isBlank(loginValue)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "INVALID_LOGIN_VALUE", OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, "email(invalid)", false, 32, null);
            callback.onFailure(new GuestFlowCallbackData(null, false, new OneIDError("INVALID_LOGIN_VALUE", "login value cannot be empty", null, 4, null)));
        } else {
            final WeakReference weakReference = new WeakReference(callback);
            getSession$OneID_release().getGuestFlow(loginValue, new OneIDCallback<GuestFlowCallbackData>() { // from class: com.disney.id.android.OneID$getGuestFlow$getGuestflowCallback$1
                @Override // com.disney.id.android.OneIDCallback
                public void onSuccess(@NotNull GuestFlowCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, "flow(" + data.getGuestFlow() + ")", false, 44, null);
                        oneIDCallback.onSuccess(new GuestFlowCallbackData(data.getGuestFlow(), true, null, 4, null));
                    }
                }

                @Override // com.disney.id.android.OneIDCallback
                public void onFailure(@NotNull GuestFlowCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "getGuestFlow failed.", null, 4, null);
                        Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                        TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                        OneIDError error = data.getError();
                        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                        oneIDCallback.onFailure(new GuestFlowCallbackData(null, false, data.getError()));
                    }
                }
            }, trackerEventKeyStartConversationEvent$default.getId(), optionalConfigsMerge$OneID_release);
        }
    }

    public static /* synthetic */ void getIdentityFlowConfig$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.getIdentityFlowConfig(context, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getIdentityFlowConfig(@NotNull Context activityContext, @NotNull OneIDCallback<IdentityConfigCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OneIDCallback oneIDCallback;
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_IDENTITYFLOWCONFIG, getSwid$OneID_release().get(), null, (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new IdentityConfigCallbackData(null, false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
            return;
        }
        final WeakReference weakReference = new WeakReference(callback);
        getScalpController$OneID_release().setOnLoadedChanged(new Function2() { // from class: com.disney.id.android.OneID.getIdentityFlowConfig.1

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.disney.id.android.OneID$getIdentityFlowConfig$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SCALPController.SiteConfigDownloadStatus.values().length];
                    try {
                        iArr[SCALPController.SiteConfigDownloadStatus.Downloaded.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SCALPController.SiteConfigDownloadStatus.FailedToDownload.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((SCALPController.SiteConfigDownloadStatus) obj, (SCALPController.SiteConfigDownloadStatus) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus, SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus2) {
                OneIDCallback oneIDCallback2 = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback2 == null || siteConfigDownloadStatus != null) {
                    return;
                }
                int i = siteConfigDownloadStatus2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[siteConfigDownloadStatus2.ordinal()];
                if (i == 1) {
                    ComplianceDetails complianceDetails = OneID.this.getComplianceDetails();
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                    oneIDCallback2.onSuccess(new IdentityConfigCallbackData(complianceDetails, true, null));
                } else if (i == 2) {
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                    oneIDCallback2.onFailure(new IdentityConfigCallbackData(null, false, new OneIDError(OneIDError.INVALID_CONFIG, "Could not load site config", null, 4, null)));
                } else {
                    Logger logger$OneID_release = OneID.this.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "getIdentityFlowConfig:ScalpController.onLoadedChanged no handler found", null, 4, null);
                }
            }
        });
        if (getScalpController$OneID_release().isLoaded() == null || (oneIDCallback = (OneIDCallback) resolveCallbackWeakReference$OneID_release$default(this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null)) == null) {
            return;
        }
        if (getScalpController$OneID_release().isLoaded() == SCALPController.SiteConfigDownloadStatus.Downloaded) {
            ComplianceDetails complianceDetails = getComplianceDetails();
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            oneIDCallback.onSuccess(new IdentityConfigCallbackData(complianceDetails, true, null));
        } else {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            oneIDCallback.onFailure(new IdentityConfigCallbackData(null, false, new OneIDError(OneIDError.INVALID_CONFIG, "Could not load site config", null, 4, null)));
        }
    }

    public static /* synthetic */ void beginRecoveryWithEmail$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.beginRecoveryWithEmail(context, str, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void beginRecoveryWithEmail(@NotNull Context activityContext, @NotNull String email, @NotNull OneIDCallback<OneIDCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_BEGIN_RECOVERY, getSwid$OneID_release().get(), "type(email)", optionalConfigsMerge$OneID_release, 1, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new OneIDCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
        } else if (StringsKt.isBlank(email)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "INVALID_EMAIL", OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, "email(invalid)", false, 32, null);
            callback.onFailure(new OneIDCallbackData(false, new OneIDError("INVALID_EMAIL", "Missing email.", null, 4, null)));
        } else {
            final WeakReference weakReference = new WeakReference(callback);
            getSession$OneID_release().beginRecovery(new LookupValue.Email(email), trackerEventKeyStartConversationEvent$default.getId(), optionalConfigsMerge$OneID_release, new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.beginRecoveryWithEmail.1
                @Override // com.disney.id.android.OneIDCallback
                public void onSuccess(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = OneID.this;
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        oneIDCallback.onSuccess(data);
                    }
                }

                @Override // com.disney.id.android.OneIDCallback
                public void onFailure(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = OneID.this;
                        TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                        Tracker tracker$OneID_release = oneID.getTracker$OneID_release();
                        OneIDError error = data.getError();
                        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                        oneIDCallback.onFailure(data);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComplianceDetails getComplianceDetails() {
        return new ComplianceDetails(getLegalDetails(), getMarketingDetails(), getCountries(), getDefaultCountry(), true);
    }

    private final List getMarketingDetails() {
        JSONObject jSONObjectOptJSONObject;
        ArrayList arrayList = new ArrayList();
        JSONArray marketingEntities = getScalpController$OneID_release().getMarketingEntities();
        int length = marketingEntities != null ? marketingEntities.length() : 0;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, length + " marketing entities retrieved from site config", null, 4, null);
        for (int i = 0; i < length; i++) {
            if (marketingEntities != null && (jSONObjectOptJSONObject = marketingEntities.optJSONObject(i)) != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("content");
                String strOptString = jSONObjectOptJSONObject.optString("code");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("displayCheckbox");
                boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("preselected");
                String strOptString2 = jSONObjectOptJSONObject.optString("text");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strOptString3 = jSONObjectOptJSONObject.optString("textId");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                arrayList.add(new MarketingDetail(strOptString, zOptBoolean, zOptBoolean2, false, strOptString2, strOptString3, createPlainTextLinks(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONArray("links") : null)));
            }
        }
        return arrayList;
    }

    private final List getCountries() {
        JSONObject jSONObjectOptJSONObject;
        ArrayList arrayList = new ArrayList();
        JSONArray countries = getScalpController$OneID_release().getCountries();
        int length = countries != null ? countries.length() : 0;
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, length + " countries retrieved from site config", null, 4, null);
        for (int i = 0; i < length; i++) {
            if (countries != null && (jSONObjectOptJSONObject = countries.optJSONObject(i)) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("code");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = jSONObjectOptJSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                arrayList.add(new Country(strOptString, strOptString2));
            }
        }
        return arrayList;
    }

    private final String getDefaultCountry() {
        String countryCode = getScalpController$OneID_release().getCountryCode();
        return countryCode == null ? AirshipConfigOptions.SITE_US : countryCode;
    }

    public static /* synthetic */ void register$default(OneID oneID, Context context, List list, List list2, List list3, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        oneID.register(context, list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3, oneIDCallback, (i & 32) != 0 ? null : optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void register(@NotNull Context activityContext, @NotNull List<Field> fields, @Nullable List<MarketingDetail> marketing, @Nullable List<LegalDetail> legal, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        final OptionalConfigs optionalConfigsMerge$OneID_release;
        String value;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_REGISTER, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new GuestCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release(), null, null, null, null, 60, null));
            return;
        }
        for (Field field : fields) {
            if (field.getRequired() && ((value = field.getValue()) == null || StringsKt.isBlank(value))) {
                if (!Intrinsics.areEqual(field.getName(), "username") || !getScalpController$OneID_release().canAutogenerateUsername()) {
                    OneIDError oneIDError = new OneIDError("MISSING_VALUE", "missing(" + field.getName() + ")", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "MISSING_VALUE", OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, "missing(" + field.getName() + ")", false, 32, null);
                    callback.onFailure(new GuestCallbackData(false, oneIDError, null, Boolean.FALSE, null, null, 48, null));
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList(fields);
        String assertedCountry = getScalpController$OneID_release().getAssertedCountry();
        if (assertedCountry != null) {
            arrayList.add(new Field("region", false, assertedCountry));
        } else {
            arrayList.add(new Field("region", false, getScalpController$OneID_release().getCountryCode()));
        }
        if (legal != null) {
            for (LegalDetail legalDetail : legal) {
                if (!legalDetail.getAccepted()) {
                    OneIDError oneIDError2 = new OneIDError("MISSING_VALUE", "missing agreement(" + legalDetail.getCode() + ")", null, 4, null);
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "MISSING_VALUE", OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, "missing(" + legalDetail.getCode() + ")", false, 32, null);
                    callback.onFailure(new GuestCallbackData(false, oneIDError2, null, Boolean.FALSE, null, null, 48, null));
                    return;
                }
            }
        }
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigsMerge$OneID_release, event != null ? event.getConversationId$OneID_release() : null);
        final WeakReference weakReference = new WeakReference(callback);
        getSession$OneID_release().register(arrayList, marketing, legal, new OneIDCallback<GuestCallbackData>() { // from class: com.disney.id.android.OneID$register$registerCallback$1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                    OneIDTrackerEvent event2 = this.this$0.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                    Tracker.DefaultImpls.trackInstantEvent$default(tracker$OneID_release, event2 != null ? event2.getConversationId$OneID_release() : null, false, EventAction.EVENT_CREATE, this.this$0.getSwid$OneID_release().get(), null, null, null, optionalConfigsMerge$OneID_release, false, 370, null);
                    Tracker.DefaultImpls.finishEvent$default(this.this$0.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                    oneIDCallback.onSuccess(data);
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull GuestCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "register failed; invoking callback", null, 4, null);
                    Tracker tracker$OneID_release = this.this$0.getTracker$OneID_release();
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    OneIDError error = data.getError();
                    Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    oneIDCallback.onFailure(data);
                }
            }
        }, trackerEventKeyStartConversationEvent$default.getId(), optionalConfigsMerge$OneID_release);
    }

    public static /* synthetic */ void updateMarketing$default(OneID oneID, Context context, String str, List list, List list2, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        oneID.updateMarketing(context, str, list, (i & 8) != 0 ? null : list2, oneIDCallback, (i & 32) != 0 ? null : optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void updateMarketing(@NotNull Context activityContext, @NotNull String email, @NotNull List<MarketingDetail> marketing, @Nullable List<LegalDetail> legal, @NotNull final OneIDCallback<OneIDCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(marketing, "marketing");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        OptionalConfigs optionalConfigs3 = (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_UPDATE_MARKETING, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new OneIDCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
            return;
        }
        if (StringsKt.isBlank(email)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "INVALID_EMAIL", OneIDTrackerEvent.ERROR_CATEGORY_ACTIONABLE_INPUT, "email(invalid)", false, 32, null);
            callback.onFailure(new OneIDCallbackData(false, new OneIDError("INVALID_EMAIL", "Missing email.", null, 4, null)));
            return;
        }
        final NewsletterDetails newsletterDetails = new NewsletterDetails(null, email, legal, marketing, 1, null);
        final WeakReference weakReference = new WeakReference(callback);
        if (getSession$OneID_release().isLoggedIn()) {
            final OptionalConfigs optionalConfigs4 = optionalConfigs3;
            ensureGuestHasEmailBefore(trackerEventKeyStartConversationEvent$default, optionalConfigs3, new Function0() { // from class: com.disney.id.android.OneID.updateMarketing.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1828invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1828invoke() {
                    Profile profile;
                    Guest guest = OneID.this.getGuestHandler$OneID_release().get();
                    String email2 = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getEmail();
                    if (!StringsKt.equals(newsletterDetails.getEmail(), email2, true)) {
                        OneIDTrackerEvent event = OneID.this.getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
                        if (event != null) {
                            event.appendCodes$OneID_release("EMAIL_MISMATCH", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "email(mismatch)");
                        }
                        Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        callback.onFailure(new SetInlineNewslettersCallbackData(false, new OneIDError("EMAIL_MISMATCH", "Email: " + newsletterDetails.getEmail() + " does not match guest email: " + email2, null, 4, null)));
                    }
                    Session session$OneID_release = OneID.this.getSession$OneID_release();
                    JsonObject guestUpdateBody = OneID.this.getGuestUpdateBody(newsletterDetails, optionalConfigs4);
                    OptionalConfigs optionalConfigs5 = optionalConfigs4;
                    String id = trackerEventKeyStartConversationEvent$default.getId();
                    final OneID oneID = OneID.this;
                    final WeakReference weakReference2 = weakReference;
                    final TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    session$OneID_release.updateGuest(guestUpdateBody, optionalConfigs5, id, new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.updateMarketing.1.1
                        @Override // com.disney.id.android.OneIDCallback
                        public void onSuccess(@NotNull OneIDCallbackData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(oneID, weakReference2, trackerEventKey, false, 4, null);
                            if (oneIDCallback != null) {
                                OneID oneID2 = oneID;
                                Tracker.DefaultImpls.finishEvent$default(oneID2.getTracker$OneID_release(), trackerEventKey, false, null, null, null, false, 60, null);
                                oneIDCallback.onSuccess(data);
                            }
                        }

                        @Override // com.disney.id.android.OneIDCallback
                        public void onFailure(@NotNull OneIDCallbackData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(oneID, weakReference2, trackerEventKey, false, 4, null);
                            if (oneIDCallback != null) {
                                OneID oneID2 = oneID;
                                TrackerEventKey trackerEventKey2 = trackerEventKey;
                                Tracker tracker$OneID_release = oneID2.getTracker$OneID_release();
                                OneIDError error = data.getError();
                                Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey2, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                                oneIDCallback.onFailure(data);
                            }
                        }
                    });
                }
            }, new Function1() { // from class: com.disney.id.android.OneID.updateMarketing.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OneIDError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(OneIDError error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, error.getCode(), OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    callback.onFailure(new SetInlineNewslettersCallbackData(false, error));
                }
            });
        } else {
            getSession$OneID_release().updateMarketing(newsletterDetails, optionalConfigs3, trackerEventKeyStartConversationEvent$default.getId(), new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.updateMarketing.3
                @Override // com.disney.id.android.OneIDCallback
                public void onSuccess(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = OneID.this;
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        oneIDCallback.onSuccess(data);
                    }
                }

                @Override // com.disney.id.android.OneIDCallback
                public void onFailure(@NotNull OneIDCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = OneID.this;
                        TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                        Tracker tracker$OneID_release = oneID.getTracker$OneID_release();
                        OneIDError error = data.getError();
                        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                        oneIDCallback.onFailure(data);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void validateOTP$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.validateOTP(context, str, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void validateOTP(@NotNull Context activityContext, @NotNull String otp, @NotNull OneIDCallback<OneIDCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(otp, "otp");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_VALIDATE_OTP, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new OneIDCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
            return;
        }
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigsMerge$OneID_release, event != null ? event.getConversationId$OneID_release() : null);
        final WeakReference weakReference = new WeakReference(callback);
        getSession$OneID_release().validateOTP(otp, new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID$validateOTP$validateCallback$1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                    oneIDCallback.onSuccess(data);
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback != null) {
                    OneID oneID = this.this$0;
                    TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                    Logger logger$OneID_release = oneID.getLogger$OneID_release();
                    String str = OneID.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.d$default(logger$OneID_release, str, "validate otp failed; invoking callback", null, 4, null);
                    Tracker tracker$OneID_release = oneID.getTracker$OneID_release();
                    OneIDError error = data.getError();
                    Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                    oneIDCallback.onFailure(data);
                }
            }
        }, trackerEventKeyStartConversationEvent$default.getId(), optionalConfigs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resolvePPU$default(OneID oneID, Context context, List list, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            oneIDCallback = null;
        }
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.resolvePPU(context, list, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void resolvePPU(@NotNull Context activityContext, @Nullable List<? extends PPU> resolvedPPUs, @Nullable final OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_RESOLVE_PPU, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            if (callback != null) {
                callback.onFailure(new GuestCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release(), null, null, null, null, 60, null));
                return;
            }
            return;
        }
        if (resolvedPPUs == null) {
            getGuestHandler$OneID_release().setStashed(null, null);
            Session session$OneID_release = getSession$OneID_release();
            OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
            session$OneID_release.end(optionalConfigsMerge$OneID_release, event != null ? event.getConversationId$OneID_release() : null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, "resolution(cancelled)", false, 44, null);
            if (callback != null) {
                callback.onSuccess(new GuestCallbackData(true, null, null, null, null, null, 62, null));
                return;
            }
            return;
        }
        if (callback == null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "Attempting to resolve PPUs but no callback provided.  Response will not be returned.", null, 4, null);
        }
        getSession$OneID_release().updateGuest(getGuestUpdateBody(resolvedPPUs), optionalConfigsMerge$OneID_release, trackerEventKeyStartConversationEvent$default.getId(), new OneIDCallback<OneIDCallbackData>() { // from class: com.disney.id.android.OneID.resolvePPU.1
            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                OneIDCallback oneIDCallback = callback;
                if (oneIDCallback != null) {
                    oneIDCallback.onSuccess(new GuestCallbackData(true, null, OneID.this.getGuestHandler$OneID_release().get(), null, null, null, 58, null));
                }
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(@NotNull OneIDCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Tracker tracker$OneID_release = OneID.this.getTracker$OneID_release();
                TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                OneIDError error = data.getError();
                Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                OneIDCallback oneIDCallback = callback;
                if (oneIDCallback != null) {
                    oneIDCallback.onFailure(new GuestCallbackData(false, data.getError(), null, null, null, null, 60, null));
                }
            }
        });
    }

    private final JsonObject getGuestUpdateBody(List ppus) {
        JsonArray asJsonArray;
        JsonObject asJsonObject;
        JsonElement first;
        JsonElement jsonElement;
        JsonObject jsonObject = new JsonObject();
        Pair<JsonElement, JsonElement> stashed = getGuestHandler$OneID_release().getStashed();
        if (stashed != null && (first = stashed.getFirst()) != null) {
            JsonObject asJsonObject2 = first.getAsJsonObject().getAsJsonObject("data");
            jsonObject.addProperty(Guest.ETAG, (asJsonObject2 == null || (jsonElement = asJsonObject2.get(Guest.ETAG)) == null) ? null : jsonElement.getAsString());
        }
        Iterator it = ppus.iterator();
        while (it.hasNext()) {
            PPU ppu = (PPU) it.next();
            if (ppu instanceof LegalPPU) {
                if (jsonObject.has("legalAssertions")) {
                    asJsonArray = jsonObject.getAsJsonArray("legalAssertions");
                } else {
                    JsonArray jsonArray = new JsonArray();
                    jsonObject.add("legalAssertions", jsonArray);
                    asJsonArray = jsonArray;
                }
                for (LegalDetail legalDetail : ((LegalPPU) ppu).getLegal()) {
                    if (legalDetail.getAccepted()) {
                        asJsonArray.add(legalDetail.getCode());
                    }
                }
            } else if (ppu instanceof ProfileChangePPU) {
                if (jsonObject.has("profile")) {
                    asJsonObject = jsonObject.getAsJsonObject("profile");
                } else {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject.add("profile", jsonObject2);
                    asJsonObject = jsonObject2;
                }
                for (Field field : ((ProfileChangePPU) ppu).getFields()) {
                    if (StringsKt.startsWith$default(field.getName(), "profile.", false, 2, (Object) null)) {
                        String strSubstringAfter$default = StringsKt.substringAfter$default(field.getName(), '.', (String) null, 2, (Object) null);
                        if (!Intrinsics.areEqual(strSubstringAfter$default, Profile.ADDRESSES) && !Intrinsics.areEqual(strSubstringAfter$default, Profile.PHONES)) {
                            asJsonObject.addProperty(strSubstringAfter$default, field.getValue());
                        } else {
                            Logger logger$OneID_release = getLogger$OneID_release();
                            String TAG2 = TAG;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "PPU for " + strSubstringAfter$default + " are not supported yet", null, 4, null);
                        }
                    } else {
                        Logger logger$OneID_release2 = getLogger$OneID_release();
                        String TAG3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        Logger.DefaultImpls.d$default(logger$OneID_release2, TAG3, "PPU field that is not in profile.  Dropping " + field.getName(), null, 4, null);
                    }
                }
            }
        }
        return jsonObject;
    }

    public static /* synthetic */ void completeRecovery$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.completeRecovery(context, str, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void completeRecovery(@NotNull Context activityContext, @Nullable String password, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_COMPLETE_RECOVERY, getSwid$OneID_release().get(), "type(email)", optionalConfigsMerge$OneID_release, 1, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new GuestCallbackData(false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release(), null, null, null, null, 60, null));
        } else {
            final WeakReference weakReference = new WeakReference(callback);
            getSession$OneID_release().completeRecovery(password, new OneIDCallback<GuestCallbackData>() { // from class: com.disney.id.android.OneID$completeRecovery$completeCallback$1
                @Override // com.disney.id.android.OneIDCallback
                public void onSuccess(@NotNull GuestCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = this.this$0;
                        Tracker.DefaultImpls.finishEvent$default(oneID.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        oneIDCallback.onSuccess(data);
                    }
                }

                @Override // com.disney.id.android.OneIDCallback
                public void onFailure(@NotNull GuestCallbackData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    OneIDCallback oneIDCallback = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(this.this$0, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                    if (oneIDCallback != null) {
                        OneID oneID = this.this$0;
                        TrackerEventKey trackerEventKey = trackerEventKeyStartConversationEvent$default;
                        Logger logger$OneID_release = oneID.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "complete recovery failed; invoking callback", null, 4, null);
                        Tracker tracker$OneID_release = oneID.getTracker$OneID_release();
                        OneIDError error = data.getError();
                        Tracker.DefaultImpls.finishEvent$default(tracker$OneID_release, trackerEventKey, false, error != null ? error.getCode() : null, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, null, false, 48, null);
                        oneIDCallback.onFailure(data);
                    }
                }
            }, trackerEventKeyStartConversationEvent$default.getId(), optionalConfigsMerge$OneID_release);
        }
    }

    public static /* synthetic */ void getRegisterFlowConfig$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.getRegisterFlowConfig(context, oneIDCallback, optionalConfigs);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
    @JvmOverloads
    public final void getRegisterFlowConfig(@NotNull Context activityContext, @NotNull OneIDCallback<RegisterConfigCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OneIDCallback oneIDCallback;
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        final TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_GET_REGISTER_FLOW_CONFIG, getSwid$OneID_release().get(), null, (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) ? optionalConfigs : optionalConfigsMerge$OneID_release, 9, null);
        if (!getScalpController$OneID_release().isHeadlessAllowed(trackerEventKeyStartConversationEvent$default)) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            callback.onFailure(new RegisterConfigCallbackData(null, CollectionsKt.emptyList(), false, OneIDError.INSTANCE.buildHeadlessDisallowed$OneID_release()));
            return;
        }
        final WeakReference weakReference = new WeakReference(callback);
        getScalpController$OneID_release().setOnLoadedChanged(new Function2() { // from class: com.disney.id.android.OneID.getRegisterFlowConfig.1

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.disney.id.android.OneID$getRegisterFlowConfig$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SCALPController.SiteConfigDownloadStatus.values().length];
                    try {
                        iArr[SCALPController.SiteConfigDownloadStatus.Downloaded.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SCALPController.SiteConfigDownloadStatus.FailedToDownload.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((SCALPController.SiteConfigDownloadStatus) obj, (SCALPController.SiteConfigDownloadStatus) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus, SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus2) {
                OneIDCallback oneIDCallback2 = (OneIDCallback) OneID.resolveCallbackWeakReference$OneID_release$default(OneID.this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null);
                if (oneIDCallback2 == null) {
                    Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, "missing(callback)", false, 44, null);
                    return;
                }
                if (siteConfigDownloadStatus == null) {
                    int i = siteConfigDownloadStatus2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[siteConfigDownloadStatus2.ordinal()];
                    if (i == 1) {
                        RegisterConfigCallbackData registerConfig = OneID.this.getRegisterConfig();
                        Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        oneIDCallback2.onSuccess(registerConfig);
                    } else if (i == 2) {
                        Tracker.DefaultImpls.finishEvent$default(OneID.this.getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
                        oneIDCallback2.onFailure(new RegisterConfigCallbackData(null, CollectionsKt.emptyList(), false, new OneIDError(OneIDError.INVALID_CONFIG, "Could not load site config", null, 4, null)));
                    } else {
                        Logger logger$OneID_release = OneID.this.getLogger$OneID_release();
                        String str = OneID.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.d$default(logger$OneID_release, str, "getRegisterFlowConfig: ScalpController.onLoadedChanged no handler found", null, 4, null);
                    }
                }
            }
        });
        if (getScalpController$OneID_release().isLoaded() == null || (oneIDCallback = (OneIDCallback) resolveCallbackWeakReference$OneID_release$default(this, weakReference, trackerEventKeyStartConversationEvent$default, false, 4, null)) == null) {
            return;
        }
        if (getScalpController$OneID_release().isLoaded() == SCALPController.SiteConfigDownloadStatus.Downloaded) {
            RegisterConfigCallbackData registerConfig = getRegisterConfig();
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            oneIDCallback.onSuccess(registerConfig);
        } else {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 60, null);
            oneIDCallback.onFailure(new RegisterConfigCallbackData(null, CollectionsKt.emptyList(), false, new OneIDError(OneIDError.INVALID_CONFIG, "Could not load site config", null, 4, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RegisterConfigCallbackData getRegisterConfig() {
        return new RegisterConfigCallbackData(getComplianceDetails(), getRegisterFields(), true, null);
    }

    public static /* synthetic */ void launchProfile$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.launchProfile(context, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchProfile(@NotNull Context activityContext, @NotNull OneIDCallback<UpdateProfileCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        OptionalConfigs optionalConfigs3 = optionalConfigs;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs3)) != null) {
            optionalConfigs3 = optionalConfigsMerge$OneID_release;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_PROFILE, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Trying to launch profile when user is not logged in", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            boolean z = false;
            Guest guest = null;
            Map map = null;
            Boolean bool = null;
            callback.onFailure(new UpdateProfileCallbackData(z, new OneIDError("NOT_LOGGED_IN", "Trying to launch profile when user is not logged in", null, 4, null), guest, map, bool, Boolean.FALSE, 28, null));
            return;
        }
        launchLightbox$default(this, activityContext, LightboxWebView.LightboxPage.UPDATE_PROFILE, optionalConfigs3, trackerEventKeyStartConversationEvent$default, callback, CallbackType.PROFILE, null, 64, null);
    }

    public static /* synthetic */ void launchIdentityFlow$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.launchIdentityFlow(context, str, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchIdentityFlow(@NotNull Context activityContext, @Nullable String loginValue, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) throws JSONException {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) != null) {
            optionalConfigs = optionalConfigsMerge$OneID_release;
        }
        Tracker tracker$OneID_release = getTracker$OneID_release();
        EventAction eventAction = EventAction.API_LAUNCH_IDENTITYFLOW;
        String str = getSwid$OneID_release().get();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("loginvalueprovided(%s)", Arrays.copyOf(new Object[]{(loginValue == null || loginValue.length() == 0) ? "false" : Characteristics.TRUE}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        JSONObject jSONObjectPut = null;
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(tracker$OneID_release, null, eventAction, str, str2, optionalConfigs, 1, null);
        Session session$OneID_release = getSession$OneID_release();
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartConversationEvent$default);
        session$OneID_release.end(optionalConfigs, event != null ? event.getConversationId$OneID_release() : null);
        LightboxWebView.LightboxPage lightboxPage = LightboxWebView.LightboxPage.IDENTITYFLOW;
        lightboxPage.setInputData(null);
        if (loginValue != null && loginValue.length() > 0) {
            jSONObjectPut = new JSONObject().put("loginValue", loginValue);
        }
        launchLightbox(activityContext, lightboxPage, optionalConfigs, trackerEventKeyStartConversationEvent$default, callback, CallbackType.LOGIN, jSONObjectPut);
    }

    public static /* synthetic */ void launchReauth$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.launchReauth(context, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchReauth(@NotNull Context activityContext, @NotNull OneIDCallback<GuestCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        OptionalConfigs optionalConfigs3 = optionalConfigs;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs3)) != null) {
            optionalConfigs3 = optionalConfigsMerge$OneID_release;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_REAUTH, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Trying to reauth when user is not logged in", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            boolean z = false;
            Guest guest = null;
            Boolean bool = null;
            List list = null;
            Boolean bool2 = null;
            callback.onFailure(new GuestCallbackData(z, new OneIDError("NOT_LOGGED_IN", "Trying to launch reauth when user is not logged in", null, 4, null), guest, bool, list, bool2, 60, null));
            return;
        }
        launchLightbox$default(this, activityContext, LightboxWebView.LightboxPage.REAUTH, optionalConfigs3, trackerEventKeyStartConversationEvent$default, callback, CallbackType.LOGIN, null, 64, null);
    }

    public static /* synthetic */ void launchNewsletters$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.launchNewsletters(context, str, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchNewsletters(@NotNull Context activityContext, @NotNull String promotionId, @NotNull OneIDCallback<NewslettersCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        String ageBand;
        Profile profile;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(promotionId, "promotionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 == null || (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) == null) {
            optionalConfigsMerge$OneID_release = optionalConfigs;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_NEWSLETTERS, getSwid$OneID_release().get(), null, optionalConfigsMerge$OneID_release, 9, null);
        if (promotionId.length() == 0) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            DefaultConstructorMarker defaultConstructorMarker = null;
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Missing promotion id", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "INVALID_PROMOTION_ID", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(promotionid)", false, 32, null);
            int i = 4;
            callback.onFailure(new NewslettersCallbackData(false, new OneIDError("INVALID_PROMOTION_ID", "Missing promotion id", null, i, defaultConstructorMarker), 0 == true ? 1 : 0, i, defaultConstructorMarker));
            return;
        }
        Guest guest = getGuestHandler$OneID_release().get();
        if (guest == null || (profile = guest.getProfile()) == null || (ageBand = profile.getAgeBand()) == null) {
            ageBand = "ADULT";
        }
        if (!getScalpController$OneID_release().hasPromotionId(ageBand, promotionId)) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "The client config does not contain the provided promotion id", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "INVALID_PROMOTION_ID", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "invalid(promotionid)", false, 32, null);
            int i2 = 4;
            callback.onFailure(new NewslettersCallbackData(false, new OneIDError("INVALID_PROMOTION_ID", "The client config does not contain the provided promotion id", null, i2, defaultConstructorMarker2), 0 == true ? 1 : 0, i2, defaultConstructorMarker2));
            return;
        }
        launchLightbox(activityContext, LightboxWebView.LightboxPage.NEWSLETTERS, optionalConfigsMerge$OneID_release, trackerEventKeyStartConversationEvent$default, callback, CallbackType.NEWSLETTERS, new JSONObject().put("promotionId", promotionId));
    }

    public static /* synthetic */ void launchEmailVerification$default(OneID oneID, Context context, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 4) != 0) {
            optionalConfigs = null;
        }
        oneID.launchEmailVerification(context, oneIDCallback, optionalConfigs);
    }

    @JvmOverloads
    public final void launchEmailVerification(@NotNull Context activityContext, @NotNull OneIDCallback<EmailVerificationCallbackData> callback, @Nullable OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        OptionalConfigs optionalConfigs3 = optionalConfigs;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs3)) != null) {
            optionalConfigs3 = optionalConfigsMerge$OneID_release;
        }
        TrackerEventKey trackerEventKeyStartConversationEvent$default = Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.API_LAUNCH_EMAIL_VERIFICATION, getSwid$OneID_release().get(), null, optionalConfigs3, 9, null);
        if (!getSession$OneID_release().isLoggedIn()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Guest is not logged in, can't launch email verification", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "NOT_LOGGED_IN", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
            callback.onFailure(new EmailVerificationCallbackData(false, new OneIDError("NOT_LOGGED_IN", "Guest is not logged in, can't launch email verification", null, 4, null)));
            return;
        }
        Guest guest = getGuestHandler$OneID_release().get();
        Profile profile = guest != null ? guest.getProfile() : null;
        if (profile == null) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "Guest object doesn't have a profile field", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, OneIDTrackerEvent.ERROR_CODE_GUEST_HANDLER_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(profile)", false, 32, null);
            callback.onFailure(new EmailVerificationCallbackData(false, new OneIDError(OneIDError.GUEST_MISSING, "Guest object doesn't have a profile field", null, 4, null)));
            return;
        }
        Boolean emailVerified = profile.getEmailVerified();
        if (emailVerified == null) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            Logger.DefaultImpls.wtf$default(logger$OneID_release3, TAG4, "Guest profile object doesn't have an emailVerified field", null, 4, null);
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, OneIDTrackerEvent.ERROR_CODE_GUEST_HANDLER_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, "missing(emailverified)", false, 32, null);
            callback.onFailure(new EmailVerificationCallbackData(false, new OneIDError(OneIDError.GUEST_MISSING, "Guest profile object doesn't have an emailVerified field", null, 4, null)));
            return;
        }
        if (emailVerified.booleanValue()) {
            Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, null, null, null, false, 62, null);
            callback.onSuccess(new EmailVerificationCallbackData(true, null));
        } else {
            if (StringsKt.equals$default(profile.getAgeBand(), "CHILD", false, 2, null)) {
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release4, TAG5, "Guest's age band is CHILD, terminating email verification", null, 4, null);
                OneIDError oneIDError = new OneIDError("AGE_GATED", null, null, 6, null);
                Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), trackerEventKeyStartConversationEvent$default, false, "AGE_GATED", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, false, 48, null);
                callback.onFailure(new EmailVerificationCallbackData(false, oneIDError));
                return;
            }
            launchLightbox$default(this, activityContext, LightboxWebView.LightboxPage.EMAIL_VERIFICATION, optionalConfigs3, trackerEventKeyStartConversationEvent$default, callback, CallbackType.EMAIL_VERIFICATION, null, 64, null);
        }
    }

    static /* synthetic */ void launchExpiredSessionFlow$default(OneID oneID, Context context, String str, OneIDCallback oneIDCallback, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 8) != 0) {
            optionalConfigs = null;
        }
        oneID.launchExpiredSessionFlow(context, str, oneIDCallback, optionalConfigs);
    }

    private final void launchExpiredSessionFlow(Context activityContext, String guestEmail, OneIDCallback callback, OptionalConfigs optionalConfigs) {
        OptionalConfigs optionalConfigsMerge$OneID_release;
        OptionalConfigs optionalConfigs2 = this.internalDefaultOptions;
        if (optionalConfigs2 != null && (optionalConfigsMerge$OneID_release = optionalConfigs2.merge$OneID_release(optionalConfigs)) != null) {
            optionalConfigs = optionalConfigsMerge$OneID_release;
        }
        OptionalConfigs optionalConfigs3 = optionalConfigs;
        launchLightbox(activityContext, LightboxWebView.LightboxPage.EXPIRED_SESSION, optionalConfigs3, Tracker.DefaultImpls.startConversationEvent$default(getTracker$OneID_release(), null, EventAction.EVENT_LAUNCH_EXPIRED_SESSION, getSwid$OneID_release().get(), null, optionalConfigs, 9, null), callback, CallbackType.EXPIRED_SESSION, new JSONObject().put("email", guestEmail));
    }

    @Nullable
    public final JSONObject getSiteConfig() {
        Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), null, false, EventAction.API_GET_SITECONFIG, getSwid$OneID_release().get(), null, null, null, null, false, 499, null);
        return getScalpController$OneID_release().getSiteConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyIfMigrationFailed() {
        if (getMigrationHandler$OneID_release().getShouldNotifyOfLogout()) {
            getSession$OneID_release().notifyOwnerOfLogout();
        }
        getMigrationHandler$OneID_release().clearState();
    }
}
