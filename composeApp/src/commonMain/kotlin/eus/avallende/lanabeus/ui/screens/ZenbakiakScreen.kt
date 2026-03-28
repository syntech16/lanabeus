package eus.avallende.lanabeus.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import eus.avallende.lanabeus.utils.Zenbaki
import lanabeus.composeapp.generated.resources.Res
import lanabeus.composeapp.generated.resources.zenbakiak_topbar
import lanabeus.composeapp.generated.resources.zenbakiak_zifretatik_letretara_txt
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ZenbakiakScreen() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ), title = {
                        Text(stringResource(Res.string.zenbakiak_topbar))
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                var zenbakiaZifrekinStringean by rememberSaveable { mutableStateOf("") }
                var zenbakiaLetrekin by rememberSaveable { mutableStateOf("") }

                Text(style = MaterialTheme.typography.headlineMedium
                    , text = stringResource(Res.string.zenbakiak_zifretatik_letretara_txt))

                TextField(
                    value = zenbakiaZifrekinStringean,
                    onValueChange = {
                        zenbakiaZifrekinStringean = it

                        if (zenbakiaZifrekinStringean.isNotEmpty()) {
                            val zenbakiaZifrekin : Int
                            try {
                                zenbakiaZifrekin = zenbakiaZifrekinStringean.toInt()
                                if (zenbakiaZifrekin < 1000) {
                                    zenbakiaLetrekin = Zenbaki.letretan1000BainoGutxiago(zenbakiaZifrekin)
                                } else {
                                    zenbakiaLetrekin = "[Zenbakia 1000 edo haundiagoa da. Aplikazioa horretarako oraindik ez dago prest.]"
                                }
                            } catch (numberFormatException: NumberFormatException) {
                                // TODO: not a number
                            }
                        } else {
                            zenbakiaZifrekinStringean = ""
                            zenbakiaLetrekin = ""
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(style = MaterialTheme.typography.bodyMedium
                    , text = zenbakiaLetrekin)
            }
        }
    }
}
