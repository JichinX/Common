package me.xujichang.lib.common.system;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class SystemUtil {
    private static final String TAG = "SystemUtil";

    public static String getImei(Application pApp) {
        String deviceId = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deviceId = Settings.System.getString(
                    pApp.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) pApp.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = telephonyManager.getDeviceId();
        }
        Log.i(TAG, "getIMEI: " + deviceId);
        return deviceId;
    }

    public static ZoneOffset getZoneOffset() {
        Instant instant = Instant.now();
        ZoneId systemZone = ZoneId.systemDefault();
        return systemZone.getRules().getOffset(instant);
    }
}
