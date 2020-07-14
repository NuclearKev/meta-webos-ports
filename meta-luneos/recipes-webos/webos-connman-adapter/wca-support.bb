# Copyright (c) 2017-2019 LG Electronics, Inc.

SUMMARY = "webOS connman adapter support library"
AUTHOR = "Seokhee Lee <seokhee.lee@lge.com>"
SECTION = "webos/libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "glib-2.0 luna-service2 libpbnjson pmloglib luna-prefs wca-support-api"

RDEPENDS_${PN} = "iw"

inherit webos_cmake
inherit webos_ports_ose_repo

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
SRCREV = "084bf16087be3eb55f81999224ae93d9f4f3515c"

S = "${WORKDIR}/git"
