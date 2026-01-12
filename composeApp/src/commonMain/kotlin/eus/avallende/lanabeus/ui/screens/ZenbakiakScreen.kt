package eus.avallende.lanabeus.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.composeunstyled.Button
import com.composeunstyled.Text
import com.composeunstyled.theme.buildTheme

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ZenbakiakScreen() {
    @Suppress("LocalVariableName")
    val MyTheme = buildTheme { }

    MyTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Button(
                onClick = {  },
                backgroundColor = Color(0xFF000000),
                contentColor = Color(0xFFFFFFFF),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Zenbakiak")
            }

            Button(
                onClick = {  },
                backgroundColor = Color(0xFF000000),
                contentColor = Color(0xFFFFFFFF),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Aditzak")
            }
        }
    }
}
