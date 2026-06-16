import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
}

// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    testImplementation(libs.junit)

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea("2025.3.5")
        testFramework(TestFrameworkType.Platform)
        zipSigner()

        // Add plugin dependencies for compilation here:
        bundledPlugin("com.intellij.java")
    }
}

intellijPlatform {
    pluginVerification {
        ides {
            current()
        }
    }

    signing {
        // Local signing material for the current learning flow. Move the private key
        // password out of source control before publishing a real plugin.
        certificateChainFile.set(layout.projectDirectory.file("signing/chain.crt"))
        privateKeyFile.set(layout.projectDirectory.file("signing/private.pem"))
        password.set("origin@2026")
    }
}

tasks.named("verifyPluginSignature") {
    dependsOn("signPlugin")
}
