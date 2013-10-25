require u-boot-ti.inc

PR = "r8"

SPL_BINARY = "MLO"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard)"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git \
		   file://0001-am335x_evm-uEnv.txt-bootz-n-fixes.patch \
		   file://stef_fix_bootm_with_device_tree.patch \
           file://fw_env.config \
          "

SRCREV = "62c175fbb8a0f9a926c88294ea9f7e88eb898f6c"
