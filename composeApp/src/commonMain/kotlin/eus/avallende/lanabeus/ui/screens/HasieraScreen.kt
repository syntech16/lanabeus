package eus.avallende.lanabeus.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import lanabeus.composeapp.generated.resources.Res
import lanabeus.composeapp.generated.resources.app_name
import lanabeus.composeapp.generated.resources.hasiera_aditzak_btn
import lanabeus.composeapp.generated.resources.hasiera_zenbakiak_btn
import org.jetbrains.compose.resources.stringResource

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HasieraScreen(
    navController: NavController,
    onNavigateToAditzak: () -> Unit
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    //onNavigateToZenbakiak
                    navController.navigate("zenbakiak")
                          },
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(stringResource(Res.string.hasiera_zenbakiak_btn))
            }

            Button(
                onClick = { onNavigateToAditzak },
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(12.dp),
                enabled = false
            ) {
                Text(stringResource(Res.string.hasiera_aditzak_btn))
            }
        }
    }
}