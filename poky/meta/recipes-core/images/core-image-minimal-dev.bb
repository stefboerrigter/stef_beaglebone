require core-image-minimal.bb

DESCRIPTION = "A small image just capable of allowing a device to boot and \
is suitable for development work."

IMAGE_INSTALL_append += " openssh"

IMAGE_FEATURES += "dev-pkgs"
