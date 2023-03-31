do_deploy:append() {
  echo "core_freq=500" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "core_freq_min=500" >>${DEPLOYDIR}/bootfiles/config.txt
}
