package com.appdynamics.eumagent.runtime.p000private;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class af {
    public final c a;
    public final AtomicLong b;
    public final AtomicLong c;

    public interface c {
        void a(String str);

        void a(String str, long j);

        void a(String str, String str2);

        long b(String str, long j);

        String b(String str, String str2);

        boolean b(String str);
    }

    public af(Context context) {
        this(new a(context));
        if (!this.a.b("is_migrated")) {
            b bVar = new b(context);
            ADLog.logVerbose("Migrating AgentMetaData from SharedPreferences to SQL");
            this.a.a("mobileAgentToken", bVar.b("mobileAgentToken", "-1"));
            this.a.a("agentIdentifier", bVar.b("agentIdentifier", (String) null));
            this.a.a("event_counter", bVar.b("event_counter", 0L));
            this.a.a("disable_agent_till", bVar.b("disable_agent_till", -1L));
            this.a.a("is_migrated");
        }
        this.b.set(this.a.b("event_counter", 0L));
        this.b.addAndGet(100L);
        this.b.incrementAndGet();
        this.a.a("event_counter", this.b.get());
        this.c.set(this.a.b("session_counter", -1L));
    }

    private af(c cVar) {
        this.b = new AtomicLong();
        this.c = new AtomicLong();
        this.a = cVar;
    }

    public final String a() {
        String strB = this.a.b("agentIdentifier", (String) null);
        if (strB != null) {
            return strB;
        }
        String string = UUID.randomUUID().toString();
        this.a.a("agentIdentifier", string);
        return string;
    }

    static class a implements c {
        private final SQLiteDatabase a;
        private final ae b;

        public a(Context context) {
            ae aeVar = new ae(context);
            this.b = aeVar;
            this.a = aeVar.getWritableDatabase();
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str) {
            ae aeVar = this.b;
            SQLiteDatabase sQLiteDatabase = this.a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Boolean.TRUE);
            aeVar.a(sQLiteDatabase, "booleans", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final boolean b(String str) {
            Boolean boolC = ae.c(this.a, str);
            if (boolC != null) {
                return boolC.booleanValue();
            }
            return false;
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str, long j) {
            ae aeVar = this.b;
            SQLiteDatabase sQLiteDatabase = this.a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", Long.valueOf(j));
            aeVar.a(sQLiteDatabase, "longs", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final long b(String str, long j) {
            Long lB = ae.b(this.a, str);
            return lB != null ? lB.longValue() : j;
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str, String str2) {
            ae aeVar = this.b;
            SQLiteDatabase sQLiteDatabase = this.a;
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            aeVar.a(sQLiteDatabase, "strings", contentValues, "key", str);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final String b(String str, String str2) {
            String strA = ae.a(this.a, str);
            return strA != null ? strA : str2;
        }
    }

    @Deprecated
    static class b implements c {
        private final SharedPreferences a;

        b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null!");
            }
            this.a = context.getApplicationContext().getSharedPreferences("com.appdynamics.eumagent.runtime.agentState", 0);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str) {
            this.a.edit().putBoolean(str, true).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final boolean b(String str) {
            return this.a.getBoolean(str, false);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str, long j) {
            this.a.edit().putLong(str, j).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final long b(String str, long j) {
            return this.a.getLong(str, j);
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final void a(String str, String str2) {
            this.a.edit().putString(str, str2).commit();
        }

        @Override // com.appdynamics.eumagent.runtime.private.af.c
        public final String b(String str, String str2) {
            return this.a.getString(str, str2);
        }
    }
}
