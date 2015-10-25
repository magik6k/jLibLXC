package net.magik6k.jliblxc;

/**
 * Flags to use in lxc functions
 */
public class LxcFlags {
    /**
     * Do not edit the rootfs to change the hostname
     */
    public static final int LXC_CLONE_KEEPNAME =              1;

    /**
     * Do not change the MAC address on network interfaces
     */
    public static final int LXC_CLONE_KEEPMACADDR =    (1 << 1);

    /**
     * Snapshot the original filesystem(s)
     */
    public static final int LXC_CLONE_SNAPSHOT =       (1 << 2);

    /**
     * Use the same bdev type
     */
    public static final int LXC_CLONE_KEEPBDEVTYPE =   (1 << 3);

    /**
     * Snapshot only if bdev supports it, else copy
     */
    public static final int LXC_CLONE_MAYBE_SNAPSHOT = (1 << 4);

    /**
     * Number of LXC_CLONE_* flags
     */
    public static final int LXC_CLONE_MAXFLAGS =       (1 << 5);

    /**
     * Redirect stdin to /dev/zero and stdout and stderr to /dev/null
     */
    public static final int LXC_CREATE_QUIET =                1;

    /**
     * Number of LXC_CREATE* flags
     */
    public static final int LXC_CREATE_MAXFLAGS =      (1 << 1);
}
