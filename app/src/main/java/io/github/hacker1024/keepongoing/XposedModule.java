package io.github.hacker1024.keepongoing;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedModule implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals("com.android.systemui")) return;

        Object flag = findAllowDismissOngoingFlag(lpparam.classLoader);
        if (flag != null) {
            XposedHelpers.setObjectField(flag, "mDefaultValue", false);
        } else {
            XposedBridge.log("Could not find the ALLOW_DISMISS_ONGOING flag. This version of Android is probably too new!");
        }
    }

    private static Object findAllowDismissOngoingFlag(ClassLoader classLoader) {
        try {
            final Class<?> flags = XposedHelpers.findClass("com.android.internal.config.sysui.SystemUiSystemPropertiesFlags$NotificationFlags", classLoader);
            return XposedHelpers.getStaticObjectField(flags, "ALLOW_DISMISS_ONGOING");
        } catch (XposedHelpers.ClassNotFoundError | NoSuchFieldError e) {
            return null;
        }
    }
}
