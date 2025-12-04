package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes2.dex */
public final class x {

    static class a {
        String a;
        String b;
        Integer c;
        String d;
        Integer e;
        Long f;
        String g;
        String h;

        a() {
        }
    }

    public final a a(String str) {
        a aVar = new a();
        aVar.a = str;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(aVar.a));
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                Long lValueOf = null;
                String strNextString = null;
                if (aVar.b != null || !"eid".equals(strNextName)) {
                    if (aVar.f != null || !"st".equals(strNextName)) {
                        if (aVar.g == null && "androidCrashReport".equals(strNextName)) {
                            aVar.e = 0;
                            a(aVar, jsonReader);
                        } else if (aVar.g == null && "clrCrashReport".equals(strNextName)) {
                            aVar.e = 1;
                            b(aVar, jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                        } else {
                            lValueOf = Long.valueOf(jsonReader.nextLong());
                        }
                        aVar.f = lValueOf;
                    }
                } else {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        strNextString = jsonReader.nextString();
                    }
                    aVar.b = strNextString;
                }
            }
            jsonReader.endObject();
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to parse crash summary from serialized crash report", th);
        }
        return aVar;
    }

    private void a(a aVar, JsonReader jsonReader) throws IOException {
        String strNextString;
        String strNextString2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String strNextString3 = null;
            if (aVar.g != null || !"stackTrace".equals(strNextName)) {
                if (aVar.d != null || !"thread".equals(strNextName)) {
                    jsonReader.skipValue();
                } else {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        strNextString3 = jsonReader.nextString();
                    }
                    aVar.d = strNextString3;
                }
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (aVar.g != null || !"exceptionClassName".equals(strNextName2)) {
                        if (aVar.h != null || !"message".equals(strNextName2)) {
                            jsonReader.skipValue();
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString = null;
                            } else {
                                strNextString = jsonReader.nextString();
                            }
                            aVar.h = strNextString;
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            strNextString2 = null;
                        } else {
                            strNextString2 = jsonReader.nextString();
                        }
                        aVar.g = strNextString2;
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
    }

    private void b(a aVar, JsonReader jsonReader) throws IOException {
        Integer numValueOf;
        String strNextString;
        String strNextString2;
        String strNextString3;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (aVar.g != null || !"stackTrace".equals(strNextName)) {
                if (aVar.c != null || !"thread".equals(strNextName)) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (aVar.d != null || !"name".equals(strNextName2)) {
                            if (aVar.c != null || !"id".equals(strNextName2)) {
                                jsonReader.skipValue();
                            } else {
                                if (jsonReader.peek() == JsonToken.NULL) {
                                    jsonReader.nextNull();
                                    numValueOf = null;
                                } else {
                                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                                }
                                aVar.c = numValueOf;
                            }
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString = null;
                            } else {
                                strNextString = jsonReader.nextString();
                            }
                            aVar.d = strNextString;
                        }
                    }
                    jsonReader.endObject();
                }
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName3 = jsonReader.nextName();
                    if (aVar.g != null || !"exceptionClassName".equals(strNextName3)) {
                        if (aVar.h != null || !"message".equals(strNextName3)) {
                            jsonReader.skipValue();
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString2 = null;
                            } else {
                                strNextString2 = jsonReader.nextString();
                            }
                            aVar.h = strNextString2;
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            strNextString3 = null;
                        } else {
                            strNextString3 = jsonReader.nextString();
                        }
                        aVar.g = strNextString3;
                    }
                }
                jsonReader.endObject();
            }
        }
    }
}
