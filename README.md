# GPIO Platform Driver for Raspberry Pi 3

## Overview

This repository hosts a GPIO platform driver for Raspberry Pi 3, facilitating the control of GPIO pins' direction and value. Additionally, the driver provides read-only attributes displaying labels for each GPIO pin.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Building and Installing](#building-and-installing)
- [Usage](#usage)
- [Module Attributes](#module-attributes)
- [Yocto Recipe](#yocto-recipe)
- [Device Tree Modification](#device-tree-modification)

## Features

- Comprehensive control over GPIO pins, including direction and value.
- Informative read-only attributes with labels for each GPIO pin.



https://github.com/MohamedSa3eed/yocto-gpio_kernel_module/assets/88633195/d51ef9e4-eac3-4566-a831-28972eff7d05



## Getting Started

### Prerequisites

Before proceeding with the driver, ensure you have the following prerequisites:

- Raspberry Pi 3 board
- Yocto Project environment configured
- Raspberry Pi 3 Kernel source code

### Building and Installing

1. Clone this repository to your local machine:

    ```bash
    $ git clone https://github.com/MohamedSa3eed/yocto-gpio_kernel_module.git
    ```

2. Move the `meta-rpi` layer to your Yocto environment:

    ```bash
    $ bitbake-layers add-layer meta-rpi
    ```

3. Build the GPIO module:

    ```bash
    $ bitbake gpio-mod
    ```

4. Add the module to your distribution:

    ```bitbake
    DISTRO_FEATURES_append = " kernel-module-gpio"
    ```

5. Create the image:

    ```bash
    $ bitbake <your-image-name>
    ```

## Usage

Follow the steps outlined in the [Getting Started](#getting-started) section to build and integrate the GPIO module into your Yocto image. After successful integration, interact with the GPIO pins through sysfs entries or device nodes as needed.

### Module Attributes

The GPIO platform driver exposes the following attributes for each GPIO pin under the `/sys/class/gpio_drv/GPIO*` directory:

1. **Direction:**
   - **Path:** `/sys/class/gpio_drv/GPIO*/direction`
   - **Description:** This attribute dictates the direction of the GPIO pin, specifying whether it should be an input or an output.

2. **Value:**
   - **Path:** `/sys/class/gpio_drv/GPIO*/value`
   - **Description:** This attribute represents the value of the GPIO pin. For output pins, users can set the value to either "1" (high) or "0" (low). For input pins, reading this file provides the current logical level on the pin.

3. **Label (Read-only):**
   - **Path:** `/sys/class/gpio_drv/GPIO*/label`
   - **Description:** This read-only attribute provides a label or identifier for each GPIO pin.

For example, to set the direction or value of GPIO 17, users would access `/sys/class/gpio_drv/GPIO17/direction` or `/sys/class/gpio_drv/GPIO17/value`, respectively.

Ensure that users have the necessary permissions to read from and write to these attributes, typically requiring superuser (root) privileges or appropriate permissions for the user.

### Modifying Values

To set the direction or value of a GPIO pin, use the `echo` command and `cat` for reading:

```bash
# Set GPIO 17 as an output
echo "out" > /sys/class/gpio_drv/GPIO17/direction

# Set GPIO 17 to high
echo 1 > /sys/class/gpio_drv/GPIO17/value

# Read the value of GPIO 22
cat /sys/class/gpio_drv/GPIO22/value

# Read the label of GPIO 2
cat /sys/class/gpio_drv/GPIO2/label
```

## Yocto Recipe

Ensure that the `meta-rpi` layer is correctly added to your Yocto environment. This layer provides essential configurations for the Raspberry Pi board, ensuring seamless integration of the GPIO platform driver into your image.

## Device Tree Modification

The GPIO platform driver relies on modifications to the Raspberry Pi 3 Device Tree Source (DTS) file for proper pin matching. Adjust the compatible string and properties in the DTS file according to your GPIO platform driver specifications.
