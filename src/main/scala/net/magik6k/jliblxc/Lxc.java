package net.magik6k.jliblxc;

import net.magik6k.jliblxc.natives.NativeLxcContainer$;

public class Lxc {
    static {
        NativeLoader$.MODULE$.init();
    }

    public static String[] getContainers(String lxcPath) {
        return NativeLxcContainer$.MODULE$.list(lxcPath);
    }

    public static String[] getContainers() {
        return getContainers("/var/lib/lxc");
    }

    public static String[] getActiveContainers(String lxcPath) {
        return NativeLxcContainer$.MODULE$.listActive(lxcPath);
    }

    public static String[] getActiveContainers() {
        return getActiveContainers("/var/lib/lxc");
    }
}
