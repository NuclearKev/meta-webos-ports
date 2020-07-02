FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "luna-service2 pmloglib"

# Enable proprietary codecs (for MP3 etc), pepper-plugins (Flash & WideVine), Print to PDF, spellchecke
PACKAGECONFIG += "proprietary-codecs pepper-plugins printing-and-pdf spellchecker webrtc"
# Activate some more detailed debug info
# EXTRA_QMAKEVARS_PRE += " CONFIG+=force_debug_info CONFIG+=webcore_debug "

inherit webos_ports_fork_repo

SRC_URI = " \
    ${WEBOS_PORTS_GIT_REPO}/qtwebengine;name=qtwebengine;branch=herrie/debug; \
    ${WEBOS_PORTS_GIT_REPO}/qtwebengine-chromium;branch=herrie/debug;name=chromium;destsuffix=git/src/3rdparty \
    file://qtwebengine.conf \
"
# webOS-ports/master-20200527
SRCREV_qtwebengine = "a30c712b4dbb02ba8d72b8e7a3a5ff3aebfec581"
# webOS-ports/master-20200527
SRCREV_chromium = "4ca6f1013477753e4abd5d003e81791380917cca"

do_install_append() {
    #Create the chromium folder already so users can right away push the required plugins there
    mkdir -p ${D}${libdir}/chromium

    #Install qtwebengine.conf, which contains all the environment variables needed to start qtwebengine
    install -d ${D}${sysconfdir}/luna-next
    install -m 0644 ${WORKDIR}/qtwebengine.conf ${D}${sysconfdir}/luna-next/
}

FILES_${PN} += "${libdir}/chromium ${sysconfdir}/luna-next/"
