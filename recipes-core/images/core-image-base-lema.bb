SUMMARY = "A console-only image that fully supports the target device \
hardware (lema)."

LICENSE = "CLOSED"

inherit core-image
require conf/lema-version.inc
inherit extrausers

COMPATIBLE_MACHINE = "^rpi$"
#PREFERRED_PROVIDER_virtual/kernel ?= "linux-raspberrypi-rt"
#PREFERRED_VERSION_linux-raspberrypi ?= "4.19.%"

# Root password has to be set on image build!
# If the image feature 'debug-tweaks' is set the root password
# will be deactivated anyway!
# Set unknown password as default!
ROOT_PASSWORD ?= "lema-123"
SERVICE_USER_PASSWORD ?= "slema"
SERVICE_USER ?= "slema"
EXTRA_USERS_PARAMS += " \
    usermod -p '$(openssl passwd '${ROOT_PASSWORD}')' root; \
"
# groupadd '${SERVICE_USER}'; 
# useradd -p '${SERVICE_USER_PASSWORD}' -g '${SERVICE_USER}'; 

IMAGE_FEATURES += "splash ssh-server-openssh"
IMAGE_INSTALL:append = " \
    i2c-tools \
    rpio \
    rpi-gpio \
    python3 \
    python3-misc \
    python3-pip \
    zeromq \
    userland \
    protobuf \
    libgpiod \
    libgpiod-tools \
    lema-service \
"

fakeroot do_image() {
    echo "LEMA_SYSTEM_VERSION:  ${LEMA_SYSTEM_VERSION}"
    echo "# lema system version" > ${IMAGE_ROOTFS}/version
    echo "VERSION=${LEMA_SYSTEM_VERSION}" >>  ${IMAGE_ROOTFS}/version
    echo "REVISION=${LEMA_BUILD_REVISION}" >>  ${IMAGE_ROOTFS}/version
    chmod 0644 ${IMAGE_ROOTFS}/version
}

