install all required packages.
Download this archive and run:

cd poky
source oe-init-build-env beaglebone

bitbake core-image-minimal-dev


steps:
add patch stef to meta-ti kernel layer
change config to include fdt
change config with: bitbake linux-ti-staging -c menuconfig

Add following to SD card:
/MLO
/u-boot.img
/zImage
/dtbs/am335x-bee.dtb

//Booting



sources:http://eewiki.net/display/linuxonarm/BeagleBone#BeagleBone-uEnv.txtbasedbootscript
http://u-boot.10912.n7.nabble.com/Booting-a-dt-zImage-kernel-td123599.html
https://www.yoctoproject.org/download/texas-instruments-arm-cortex-a8-development-board-beagleboard-0
http://www.jumpnowtek.com/index.php?option=com_content&view=article&id=85:yocto-gumstix&catid=35:gumstix&Itemid=67

