package cib.erpipa.imcjetpack.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00F0FF),     // Neon Cyan
    onPrimary = Color(0xFF000000),
    secondary = Color(0xFFFF007F),   // Neon Pink
    onSecondary = Color(0xFF000000),
    tertiary = Color(0xFF39FF14),    // Neon Lime
    background = Color(0xFF0A0A0F),
    surface = Color(0xFF161622),
    onBackground = Color(0xFFE0E0E8),
    onSurface = Color(0xFFE0E0E8)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun IMCJetPackTheme(
    darkTheme: Boolean = true,       // Default to dark mode for neon aesthetic
    dynamicColor: Boolean = false,   // Disable dynamic color to preserve custom neon theme
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}