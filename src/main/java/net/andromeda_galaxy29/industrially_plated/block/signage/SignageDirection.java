package net.andromeda_galaxy29.industrially_plated.block.signage;

import net.minecraft.util.StringRepresentable;

public enum SignageDirection implements StringRepresentable {
    LEFT("left"),
    UP_LEFT("up_left"),
    UP("up"),
    UP_RIGHT("up_right"),
    RIGHT("right"),
    DOWN_RIGHT("down_right"),
    DOWN("down"),
    DOWN_LEFT("down_left");

    private final String name;

    SignageDirection(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
