package me.xujichang.lib.common.nav;

import androidx.navigation.NavOptions;

import me.xujichang.lib.common.R;

/**
 * me.xujichang.lib.commons.nav in common
 * description:
 * 处理Navigation
 * <p>
 *
 * @author xujichang at 2020/5/7 4:14 PM
 */
public class NavigationHelper {

    public static NavOptions.Builder defaultOptionsBuilder() {
        return (new NavOptions.Builder())
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
    }
}
