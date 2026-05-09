package eus.avallende.lanabeus.model.zenbaki

// static : object
object Zenbaki {
    fun zifrakLetretan(zenbakiaZifretan: Int): String {
        return letretan1000BainoGutxiago(zenbakiaZifretan);
    }

    fun letretan10BainoGutxiago(zenbakiaZifretan: Int): String {
        var zenbakiaLetretan: String

        zenbakiaLetretan = when (zenbakiaZifretan) {
            9 -> "bederatzi"
            8 -> "zortzi"
            7 -> "zazpi"
            6 -> "sei"
            5 -> "bost"
            4 -> "lau"
            3 -> "hiru"
            2 -> "bi"
            1 -> "bat"
            else -> ""
        }

        return zenbakiaLetretan
    }

    fun letretan100BainoGutxiago(zenbakiaZifretan: Int): String {
        val hasierakoHogeikoMultzoak = zenbakiaZifretan / 20
        var hogeikoMultzoak = hasierakoHogeikoMultzoak
        val hasierakoHogeikoHondarra = zenbakiaZifretan % 20
        var hogeikoHondarra = hasierakoHogeikoHondarra
        var zenbakiaLetretan: String = ""

        if (hogeikoMultzoak == 0 && hogeikoHondarra == 0) {
            return "zero"
        }

        if (hogeikoMultzoak != 0) {
            zenbakiaLetretan = when (hogeikoMultzoak) {
                1 -> "h"
                2 -> "berr"
                3 -> "hirur"
                4 -> "laur"
                else -> ""
            }

            zenbakiaLetretan += "ogei"

            if (hogeikoHondarra != 0) {
                zenbakiaLetretan += "ta "
            }
        }

        if (hogeikoHondarra != 0) {
            if (hogeikoHondarra == 19) {
                zenbakiaLetretan += "hemeretzi"
            } else {
                if (hogeikoHondarra >= 10) {
                    zenbakiaLetretan += "hama"

                    if (hogeikoHondarra == 11) {
                        zenbakiaLetretan += "ika"
                        hogeikoHondarra = 0
                    } else if (hogeikoHondarra == 10) {
                        zenbakiaLetretan += "r"
                    }
                }

                zenbakiaLetretan += letretan10BainoGutxiago(hogeikoHondarra % 10)
            }
        }

        return zenbakiaLetretan
    }

    fun letretan1000BainoGutxiago(zenbakiaZifretan: Int): String {
        var ehunekoak: Int = zenbakiaZifretan / 100
        var ehunekoenHondarra: Int = zenbakiaZifretan % 100
        var zenbakiaLetretan: String = ""

        if (ehunekoak != 0) {
            zenbakiaLetretan = when (ehunekoak) {
                2 -> "berr"
                1 -> ""
                else -> letretan10BainoGutxiago(ehunekoak)
            }

            zenbakiaLetretan += when (ehunekoak) {
                3, 4 -> "r"
                else -> ""
            }

            zenbakiaLetretan += "ehun"

            if (ehunekoenHondarra != 0) {
                zenbakiaLetretan += " eta "
            }
        }

        if (!(ehunekoak != 0 && ehunekoenHondarra == 0)) {
            zenbakiaLetretan += letretan100BainoGutxiago(ehunekoenHondarra)
        }

        return zenbakiaLetretan
    }
}