SUMMARY = "Extra modules and scripts for CMake"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

PV = "5.5.8+git${SRCPV}"
SRCREV = "307b36662ec9dcf125a589ca24dd69886698fd2b"

SRC_URI = " \
    git://invent.kde.org/framework/extra-cmake-modules;protocol=https;branch=master \
    file://0001-Search-within-OE_QMAKE_PATH_EXTERNAL_HOST_BINS-for-q.patch \
"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DBUILD_TESTING=off"

inherit cmake

FILES:${PN}-dev += "${datadir}/ECM"

# ${PN} package is empty
RDEPENDS:${PN}-dev = ""
