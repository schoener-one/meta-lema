SUMMARY = "LeMa system service which starts and runs the LeMa daemon"
SECTION = "base/shell"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

FILESEXTRAPATHS:prepend := "${THISDIR}:${THISDIR}/files:"
SRC_URI = " \
    file://lema.service \
    file://LICENSE \
"

inherit systemd

SYSTEMD_SERVICE:${PN} = "lema.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/lema.service ${D}${systemd_system_unitdir}/lema.service
}

FILES:${PN} = "\
    ${systemd_system_unitdir}/lema.service \
"

RDEPENDS:${PN} += " \
    lema-system-app \
"
