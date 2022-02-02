package com.github.llndqvst.rconoutputnewline.mixin;

import net.minecraft.server.rcon.RconCommandOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RconCommandOutput.class)
public class RconCommandOutputMixin {
	@Inject(
		at = @At("TAIL"),
		method = "sendSystemMessage(Lnet/minecraft/text/Text;Ljava/util/UUID;)V"
	)
	private void appendNewline(net.minecraft.text.Text message, java.util.UUID uuid, CallbackInfo info) {
		var b = ((com.github.llndqvst.rconoutputnewline.mixin.RconCommandOutputAccessor) this).getBuffer();
		b.append('\n');
	}
}
