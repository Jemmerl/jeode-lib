package com.jemmerl.jeodelib.machine.util.blockprops;

import net.minecraft.util.IStringSerializable;

public enum ActiveStatus implements IStringSerializable {
    OFF("off"),
    ON("on"),
    ACTIVE("active");

    private final String name;

    private ActiveStatus(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getString();
    }

    public String getString() {
        return this.name;
    }
}
