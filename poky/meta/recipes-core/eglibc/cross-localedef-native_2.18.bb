DESCRIPTION = "Cross locale generation tool for eglibc"
HOMEPAGE = "http://www.eglibc.org/home"
SECTION = "libs"
LICENSE = "LGPL-2.1"

LIC_DIR = "${WORKDIR}/eglibc-${PV}/libc"
LIC_FILES_CHKSUM = "file://${LIC_DIR}/LICENSES;md5=e9a558e243b36d3209f380deb394b213 \
      file://${LIC_DIR}/COPYING;md5=393a5ca445f6965873eca0259a17f833 \
      file://${LIC_DIR}/posix/rxspencer/COPYRIGHT;md5=dc5485bb394a13b2332ec1c785f5d83a \
      file://${LIC_DIR}/COPYING.LIB;md5=bbb461211a33b134d42ed5ee802b37ff "


inherit native
inherit autotools

# pick up an eglibc patch
FILESPATH = "${FILE_DIRNAME}/eglibc-${PV}"

SRC_URI = "http://downloads.yoctoproject.org/releases/eglibc/eglibc-${PV}-svnr23787.tar.bz2 \
	   file://fix_for_centos_5.8.patch;patchdir=.. \
	  "
SRC_URI[md5sum] = "b395b021422a027d89884992e91734fc"
SRC_URI[sha256sum] = "15f564b45dc5dd65faf0875579e3447961ae61e876933384ae05d19328539ad4"

S = "${WORKDIR}/eglibc-${PV}/localedef"

do_unpack_append() {
    bb.build.exec_func('do_move_ports', d)
}

do_move_ports() {
        if test -d ${WORKDIR}/eglibc-${PV}/ports ; then
	    rm -rf ${WORKDIR}/libc/ports
	    mv ${WORKDIR}/eglibc-${PV}/ports ${WORKDIR}/libc/
	fi
}

EXTRA_OECONF = "--with-glibc=${WORKDIR}/eglibc-${PV}/libc"
CFLAGS += "-DNOT_IN_libc=1"

do_configure () {
	${S}/configure ${EXTRA_OECONF}
}


do_install() {
	install -d ${D}${bindir} 
	install -m 0755 ${B}/localedef ${D}${bindir}/cross-localedef
}
