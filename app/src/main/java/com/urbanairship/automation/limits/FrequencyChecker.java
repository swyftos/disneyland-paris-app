package com.urbanairship.automation.limits;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/automation/limits/FrequencyChecker;", "", "checkAndIncrement", "", "isOverLimit", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface FrequencyChecker {
    boolean checkAndIncrement();

    boolean isOverLimit();
}
