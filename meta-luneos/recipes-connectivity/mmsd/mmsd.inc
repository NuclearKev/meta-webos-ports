HOMEPAGE = "http://www.ofono.org"
SUMMARY  = "Open Source MMS management daemon "
LICENSE  = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit autotools pkgconfig

DEPENDS  = "dbus glib-2.0"

PACKAGES =+ "${PN}-tests"

RDEPENDS:${PN} += "dbus"
RRECOMMENDS:${PN} += "ofono"

FILES:${PN} += "${base_libdir}/udev ${systemd_unitdir}"
FILES:${PN}-tests = "${libdir}/${BPN}/test"
RDEPENDS:${PN}-tests = "python3 python3-dbus"
