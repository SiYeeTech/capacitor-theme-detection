package com.siyee.plugins.themedetection;

import android.content.res.Configuration;
import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "ThemeDetection")
public class ThemeDetectionPlugin extends Plugin {

    /**
     * Android 9 (API 28) is needed for dark theme availability
     */
    private static final int SUPPORT_MINIMUM_VERSION = 28;

    @PluginMethod
    public void isDarkModeActive(PluginCall call) {
        boolean isDark = false;
        if (Build.VERSION.SDK_INT >= SUPPORT_MINIMUM_VERSION) {
            int uiMode = getActivity().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            isDark = uiMode == Configuration.UI_MODE_NIGHT_YES;
        }

        JSObject ret = new JSObject();
        ret.put("active", isDark);
        call.resolve(ret);
    }

    @Override
    protected void handleOnConfigurationChanged(Configuration newConfig) {
        int currentNightMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        JSObject ret = new JSObject();
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're using the light theme
                triggerThemeModeChangeEvent("Light");
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're using dark theme
                triggerThemeModeChangeEvent("Dark");
                break;
        }
    }

    private void triggerThemeModeChangeEvent(String mode) {
        JSObject ret = new JSObject();
        ret.put("mode", mode);
        notifyListeners("themeModeChange", ret);
    }
}
