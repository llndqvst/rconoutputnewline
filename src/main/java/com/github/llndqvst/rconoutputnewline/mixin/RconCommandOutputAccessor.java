package com.github.llndqvst.rconoutputnewline.mixin;

import net.minecraft.server.rcon.RconCommandOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RconCommandOutput.class)
public interface RconCommandOutputAccessor {
    @Accessor
    java.lang.StringBuffer getBuffer();
}
