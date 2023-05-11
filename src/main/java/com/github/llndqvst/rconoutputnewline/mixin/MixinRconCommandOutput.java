package com.github.llndqvst.rconoutputnewline.mixin;

import net.minecraft.server.rcon.RconCommandOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RconCommandOutput.class)
public class MixinRconCommandOutput {
	@Inject(
		at = @At("TAIL"),
		method = "sendMessage"
	)
	private void onSendMessage(net.minecraft.text.Text message, CallbackInfo info) {
		var b = ((com.github.llndqvst.rconoutputnewline.mixin.RconCommandOutputAccessor) this).getBuffer();
		b.append('\n');
	}
}
