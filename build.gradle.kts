import dev.deftu.gradle.utils.GameSide

plugins {
    java
    val dgtVersion = "1.22.4"
    id("dev.deftu.gradle.tools") version(dgtVersion)
    id("dev.deftu.gradle.tools.shadow") version(dgtVersion)
    id("dev.deftu.gradle.tools.blossom") version(dgtVersion)
    id("dev.deftu.gradle.tools.minecraft.loom") version(dgtVersion)
    id("dev.deftu.gradle.tools.resources") version(dgtVersion)
}

toolkit.useDevAuth()

toolkitLoomHelper  {
    useForgeMixin(modData.id)
    useMixinRefMap(modData.id)
    useTweaker("org.spongepowered.asm.launch.MixinTweaker")
    useProperty("mixin.debug.export", "true", GameSide.CLIENT)
    disableRunConfigs(GameSide.SERVER)
}

repositories {
    maven("https://repo.spongepowered.org/maven/")
    maven("https://maven.deftu.dev/releases")
    mavenCentral()
}

dependencies {
    implementation(shade("org.spongepowered:mixin:0.7.11-SNAPSHOT") {
        isTransitive = false
    })
}