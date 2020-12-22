SUMMARY = "Sound server for Linux and Unix-like operating systems"
HOMEPAGE = "http://www.pulseaudio.org"
AUTHOR = "Lennart Poettering"
SECTION = "libs/multimedia"

LICENSE = "LGPLv2.1+ & MIT & BSD-3-Clause"

LIC_FILES_CHKSUM = "file://LICENSE;md5=0e5cd938de1a7a53ea5adac38cc10c39 \
                    file://GPL;md5=4325afd396febcb659c36b49533135d4 \
                    file://LGPL;md5=2d5025d4aa3495befef8f17206a5b0a1 \
                    file://src/pulsecore/filter/biquad.h;beginline=1;endline=4;md5=6d46d1365206528a20137355924233c1 \
"

SRC_URI = "http://freedesktop.org/software/pulseaudio/releases/pulseaudio-${PV}.tar.xz \
    file://pulsecore.pc \
"
SRC_URI[md5sum] = "84a7776e63dd55c40db8fbd7c7e2e18e"
SRC_URI[sha256sum] = "a834775d9382b055504e5ee7625dc50768daac29329531deb6597bf05e06c261"

S = "${WORKDIR}/pulseaudio-${PV}"

do_install() {
    install -Dm644 ${WORKDIR}/pulsecore.pc ${D}${libdir}/pkgconfig/pulsecore.pc
    sed -i 's/@PA_MAJORMINOR@/${PV}/g' ${D}${libdir}/pkgconfig/pulsecore.pc

    install -d ${D}${includedir}/pulsecore/filter
    install -m644 ${S}/src/pulsecore/*.h ${D}${includedir}/pulsecore/
    install -m644 ${S}/src/pulsecore/filter/*.h ${D}${includedir}/pulsecore/filter/
}
