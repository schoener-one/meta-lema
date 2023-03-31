DESCRIPTION = "LeMa system daemon application to control the LEDs"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742"

FILESEXTRAPATHS:prepend := "${THISDIR}:${THISDIR}/conf:${THISDIR}/scripts:"
SRC_URI = "\
    file://config.json \
    file://lema-app.py \
    file://LICENSE \
"

do_install() {
    install -d ${D}${sysconfdir}/lema
    install -m 0644 ${WORKDIR}/config.json ${D}${sysconfdir}/lema

    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/lema-app.py ${D}${libexecdir}/lema-app.py
}

FILES:${PN} += "\
  ${sysconfdir}/lema/* \
  ${libexecdir}/lema-app.py \
"
RDEPENDS:${PN} += " \
    python3-rpi-ws281x \
    python3-pymodbus (>= 3.1.3) \
    python3-requests \
"