package com.example.examplemod.mixin;

import com.example.examplemod.ExampleMod;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Mixins can't be written in Kotlin, see: https://github.com/SpongePowered/Mixin/issues/245
@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
  @Inject(method = "loadLevel", at = @At("TAIL"))
  private void examplemod$onLoadLevel(CallbackInfo ci) {
    // Code here will be executed after a level was loaded.
    // This can also be done via Event, which should be used, but this
    // is an example mixin
    ExampleMod.Companion.getLOGGER().debug("Hello from an Example Mixin");
  }
}
