do_compile:append() {
    sed "s/serial0/serial1/" -i "${WORKDIR}/cmdline.txt"
}
