# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Palm's Better Native JSON library"
SECTION = "webos/libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "yajl glib-2.0 gperf-native lemon-native gmp uriparser boost"

PV = "2.9.0-38+git${SRCPV}"
SRCREV = "5ffe5674feabf4f5a36ad168230c567933cf6586"

inherit webos_public_repo
inherit webos_cmake
inherit pkgconfig

# Otherwise it fails with:
# libpbnjson/2.9.0-38+gitAUTOINC+5ffe5674fe-r0/git/src/pbnjson_c/validation/schema_builder.c:28:10: fatal error: schema_keywords.h: No such file or directory
OECMAKE_GENERATOR="Unix Makefiles"

# These are the defaults, but explicitly specify so that readers know they exist
EXTRA_OECMAKE += "-DWITH_DOCS:BOOL=FALSE -DWITH_TESTS:BOOL=FALSE -DNO_LOGGING:BOOL=TRUE"

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"
