package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.urbanairship.channel.AttributeMutation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzfo {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzfm zzfmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfmVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzgq.zza(new zzde(((String) obj).getBytes(zzep.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdf) {
            sb.append(": \"");
            sb.append(zzgq.zza((zzdf) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzeh) {
            sb.append(" {");
            zzd((zzeh) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, "key", entry.getKey());
        zzb(sb, i3, "value", entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    private static void zzd(zzfm zzfmVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfmVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith(AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzeh.zzR(method2, zzfmVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzeh.zzR(method, zzfmVar, new Object[0]));
            } else if (hashSet.contains(AttributeMutation.ATTRIBUTE_ACTION_SET.concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZzR = zzeh.zzR(method4, zzfmVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzR instanceof Boolean) {
                            if (((Boolean) objZzR).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzR);
                            }
                        } else if (objZzR instanceof Integer) {
                            if (((Integer) objZzR).intValue() != 0) {
                                zzb(sb, i, strSubstring, objZzR);
                            }
                        } else if (objZzR instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzR).floatValue()) != 0) {
                                zzb(sb, i, strSubstring, objZzR);
                            }
                        } else if (!(objZzR instanceof Double)) {
                            if (objZzR instanceof String) {
                                zEquals = objZzR.equals("");
                            } else if (objZzR instanceof zzdf) {
                                zEquals = objZzR.equals(zzdf.zzb);
                            } else if (objZzR instanceof zzfm) {
                                if (objZzR != ((zzfm) objZzR).zzac()) {
                                    zzb(sb, i, strSubstring, objZzR);
                                }
                            } else if (!(objZzR instanceof Enum) || ((Enum) objZzR).ordinal() != 0) {
                                zzb(sb, i, strSubstring, objZzR);
                            }
                            if (!zEquals) {
                                zzb(sb, i, strSubstring, objZzR);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzR).doubleValue()) != 0) {
                            zzb(sb, i, strSubstring, objZzR);
                        }
                    } else if (((Boolean) zzeh.zzR(method5, zzfmVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, strSubstring, objZzR);
                    }
                }
            }
            i2 = 3;
        }
        if (zzfmVar instanceof zzed) {
            Iterator itZzf = ((zzed) zzfmVar).zzb.zzf();
            while (itZzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZzf.next();
                zzb(sb, i, "[" + ((zzee) entry2.getKey()).zza + "]", entry2.getValue());
            }
        }
        zzgt zzgtVar = ((zzeh) zzfmVar).zzc;
        if (zzgtVar != null) {
            zzgtVar.zzi(sb, i);
        }
    }
}
