KERNEL_MODULE_AUTOLOAD += "i2c-dev"
# Remove snd module to not interfere with the PWM control
KERNEL_MODULE_PROBECONF += "snd_bcm2835"
module_conf_snd_bcm2835 = "blacklist snd_bcm2835"