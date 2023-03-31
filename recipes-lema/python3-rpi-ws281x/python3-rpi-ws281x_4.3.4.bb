# Copyright (C) 2023 Denis Schoener <denis@schoner-one.de>

SUMMARY = "Python wrapper for userspace Raspberry Pi PWM/PCM/SPI library for SK6812 and WS281X LEDs."
HOMEPAGE = "https://github.com/rpi-ws281x/rpi-ws281x-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9dcf340793a1d73c5211edc8238767dc"

PYPI_PACKAGE = "rpi_ws281x"

inherit pypi setuptools3

SRC_URI[md5sum] = "016e1f03f9168ef03d4baf074aa60f03"
SRC_URI[sha256sum] = "072eff1787e579d1710381b27c467709e3aab28ac579c7a47d7cc87398496f28"

RDEPENDS:${PN} += " \
    libws2811-lib \
"
