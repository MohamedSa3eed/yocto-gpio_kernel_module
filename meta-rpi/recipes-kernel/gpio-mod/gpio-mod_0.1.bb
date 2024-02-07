SUMMARY = "an external GPIO Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "file://Makefile \
           file://gpio.c \
           file://gpio_syscalls.c \
           file://gpio.h \
           file://gpio_syscalls.h \
           file://COPYING \
          "

S = "${WORKDIR}"


RPROVIDES:${PN} += "kernel-module-gpio"
