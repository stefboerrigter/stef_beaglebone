require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

LIC_FILES_CHKSUM = "file://README;md5=5cd42e3eba510b8261cc0106256c77bb"

#PV = "2013.10"
PR = "r1+gitr${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git \
		   file://0001-am335x_evm-uEnv.txt-bootz-n-fixes.patch \
           file://fw_env.config \
          "

SRCREV = "62c175fbb8a0f9a926c88294ea9f7e88eb898f6c"

#SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

#BRANCH ?= "ti-u-boot-2013.10"

# Corresponds to 2013.10
#SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
