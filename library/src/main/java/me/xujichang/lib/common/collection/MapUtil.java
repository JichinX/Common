package me.xujichang.lib.common.collection;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class MapUtil {
    public static Map<String, String> clearNull(Map<String, String> pMap) {
        return Maps.filterValues(pMap, new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {
                return !Strings.isNullOrEmpty(input);
            }
        });
    }
}
