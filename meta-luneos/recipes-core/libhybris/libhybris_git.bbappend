DEPENDS += "wayland"
EXTRA_OECONF += " \
    --enable-wayland \
    --with-default-egl-platform=wayland \
    --enable-trace \
    --enable-debug \
    --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib \
"

SRCREV = "d4741e6675582c248228a41f4c1616fbf39fd3e6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-compilation-with-gcc6.patch;patchdir=../"
