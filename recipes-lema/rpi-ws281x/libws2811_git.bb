# Copyright (C) 2023 Denis Schoener <denis@schoner-one.de>

SUMMARY = "Userspace Raspberry Pi PWM/PCM/SPI library for SK6812 and WS281X LEDs."
DESCRIPTION = "Userspace Raspberry Pi library for controlling WS281X LEDs. This includes \
WS2812 and SK6812RGB RGB LEDs Preliminary support is now included for SK6812RGBW LEDs. \
The LEDs can be controlled by either the PWM (2 independent channels) or PCM controller (1 channel) \
or the SPI interface (1 channel)."
SECTION = "libs"
HOMEPAGE = "https://github.com/jgarff/rpi_ws281x"

LICENSE = "BSD-2-Clause | BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9dcf340793a1d73c5211edc8238767dc"

SRC_URI = " \
    git://github.com/jgarff/rpi_ws281x.git;branch=master;protocol=https \
    "
SRCREV = "1ba8e385708fb7802b09c0177a7ea4293948e25c"
PV = "0.0+git${SRCPV}"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED=ON -DBUILD_TEST=OFF"

S = "${WORKDIR}/git"

INSANE_SKIP:${PN}-dev = "dev-elf"
PACKAGES =+ "${PN}-lib"
FILES:${PN}-lib = "${libdir}/libws2811.so"
ALLOW_EMPTY:${PN} = "1"
