# Copyright (c) 2017-2019 LG Electronics, Inc.

SUMMARY = "webOS connman adapter support API"
AUTHOR = "Seokhee Lee <seokhee.lee@lge.com>"
SECTION = "webos/libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "libpbnjson luna-service2"

inherit pkgconfig
inherit webos_cmake
inherit webos_ports_ose_repo

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
SRCREV = "58320d03a44fdf7c11603425a1202092b7e48958"

S = "${WORKDIR}/git"
