package eus.avallende.lanabeus.model.zenbaki

// static : object
object Zenbaki {
    const val ZIFRAK_LETRETAN_BIHURTZEKO_ZENBAKIRIK_ALTUENA = 1000000000

    fun zifrakLetretan(zenbakiaZifretan: Int): String {
        return zifrakLetretanMilaMilioiBainoGutxiago(zenbakiaZifretan);
    }

    fun zifrakLetretanHamarBainoGutxiago(zenbakiaZifretan: Int): String {
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

    fun zifrakLetretanEhunBainoGutxiago(zenbakiaZifretan: Int): String {
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

                zenbakiaLetretan += zifrakLetretanHamarBainoGutxiago(hogeikoHondarra % 10)
            }
        }

        return zenbakiaLetretan
    }

    fun zifrakLetretanMilaBainoGutxiago(zenbakiaZifretan: Int): String {
        var ehunekoak: Int = zenbakiaZifretan / 100
        var ehunekoenHondarra: Int = zenbakiaZifretan % 100
        var zenbakiaLetretan: String = ""

        if (ehunekoak != 0) {
            zenbakiaLetretan = when (ehunekoak) {
                2 -> "berr"
                1 -> ""
                else -> zifrakLetretanHamarBainoGutxiago(ehunekoak)
            }

            zenbakiaLetretan += when (ehunekoak) {
                3, 4 -> "r"
                else -> ""
            }

            zenbakiaLetretan += "ehun"

            if (ehunekoenHondarra != 0) {
                zenbakiaLetretan += " eta"
            }
        }

        if (ehunekoak == 0 || ehunekoenHondarra != 0) {
            if (ehunekoak != 0) {
                zenbakiaLetretan += " "
            }

            zenbakiaLetretan += zifrakLetretanEhunBainoGutxiago(ehunekoenHondarra)
        }

        return zenbakiaLetretan
    }

    fun zifrakLetretanMilioiBainoGutxiago(zenbakiaZifretan: Int): String {
        var milakoak: Int = zenbakiaZifretan / 1000
        var milakoenHondarra: Int = zenbakiaZifretan % 1000
        var zenbakiaLetretan: String = ""

        if (milakoak != 0) {
            zenbakiaLetretan = when (milakoak) {
                1 -> ""
                else -> zifrakLetretanMilaBainoGutxiago(milakoak) + " "
            }

            zenbakiaLetretan += "mila"

            if (bakarrikEhunekoakEdoBatekoakDitu(milakoenHondarra)) {
                zenbakiaLetretan += " eta"
            }
        }

        if (milakoak == 0 || milakoenHondarra != 0) {
            if (milakoak != 0) {
                zenbakiaLetretan += " "
            }

            zenbakiaLetretan +=  zifrakLetretanMilaBainoGutxiago(milakoenHondarra)
        }

        return zenbakiaLetretan
    }

    fun zifrakLetretanMilaMilioiBainoGutxiago(zenbakiaZifretan: Int): String {
        var milioikoak: Int = zenbakiaZifretan / 1000000
        var milioikoenHondarra: Int = zenbakiaZifretan % 1000000
        var zenbakiaLetretan: String = ""

        if (milioikoak != 0) {
            zenbakiaLetretan = when (milioikoak) {
                1 -> ""
                else -> zifrakLetretanMilaBainoGutxiago(milioikoak) + " "
            }

            zenbakiaLetretan += "milioi"

            if (milioikoak == 1) {
                zenbakiaLetretan += " bat"
            }

            zenbakiaLetretan += when (zenbatMultzoFaltaDiraMilioikoenHondarrean(milioikoenHondarra)) {
                2 -> ","
                1 -> " eta"
                else -> ""
            }
        }

        if (milioikoak == 0 || milioikoenHondarra != 0) {
            if (milioikoak != 0) {
                zenbakiaLetretan += " "
            }

            zenbakiaLetretan +=  zifrakLetretanMilioiBainoGutxiago(milioikoenHondarra)
        }

        return zenbakiaLetretan
    }

    // Hondarrak lortu

    fun ehunekoenHondarraLortu(zenbakia: Int): Int {
        return zenbakia % 100
    }

    fun batekoMilakoenHondarraLortu(zenbakia: Int): Int {
        return zenbakia % 1000
    }

    fun ehunekoMilakoenHondarraLortu(zenbakia: Int): Int {
        return zenbakia % 100000
    }

    fun batekoMilioikoenHondarraLortu(zenbakia: Int): Int {
        return zenbakia % 1000000
    }

    fun ehunekoMilioikoenHondarraLortu(zenbakia: Int): Int {
        return zenbakia % 100000000
    }

    fun batekoMilaMilioienHondarra(zenbakia: Int): Int {
        return zenbakia % 1000000000
    }

    // Zatiak lortu

    fun batekoakLortu(zenbakia: Int): Int {
        return ehunekoenHondarraLortu(zenbakia)
    }

    fun ehunekoakLortu(zenbakia: Int): Int {
        return batekoMilakoenHondarraLortu(zenbakia) - ehunekoenHondarraLortu(zenbakia)
    }

    fun batekoMilakoakLortu(zenbakia: Int): Int {
        return ehunekoMilakoenHondarraLortu(zenbakia) - batekoMilakoenHondarraLortu(zenbakia)
    }

    fun ehunekoMilakoakLortu(zenbakia: Int): Int {
        return batekoMilioikoenHondarraLortu(zenbakia) - ehunekoMilakoenHondarraLortu(zenbakia)
    }

    fun batekoMilioiakLortu(zenbakia: Int): Int {
        return ehunekoMilioikoenHondarraLortu(zenbakia) - batekoMilioikoenHondarraLortu(zenbakia)
    }

    fun ehunekoMilioiakLortu(zenbakia: Int): Int {
        return batekoMilaMilioienHondarra(zenbakia) - ehunekoMilioikoenHondarraLortu(zenbakia)
    }

    // Zatiak ditu

    fun batekoakDitu(zenbakia: Int): Boolean {
        return (ehunekoenHondarraLortu(zenbakia) != 0)
    }

    fun ehunekoakDitu(zenbakia: Int): Boolean {
        return (ehunekoakLortu(zenbakia) != 0)
    }

    fun batekoMilakoakDitu(zenbakia: Int): Boolean {
        return (batekoMilakoakLortu(zenbakia) != 0)
    }

    fun ehunekoMilakoakDitu(zenbakia: Int): Boolean {
        return (ehunekoMilakoakLortu(zenbakia) != 0)
    }

    fun batekoMilioiakDitu(zenbakia: Int): Boolean {
        return (batekoMilioiakLortu(zenbakia) != 0)
    }

    fun ehunekoMilioiakDitu(zenbakia: Int): Boolean {
        return (ehunekoMilioiakLortu(zenbakia) != 0)
    }

    // Bakarrik X ditu

    fun ehunekoakDituBatekorikGabe(zenbakia: Int): Boolean {
        return (ehunekoakDitu(zenbakia) && !batekoakDitu(zenbakia))
    }

    fun batekoakDituEhunekorikGabe(zenbakia: Int): Boolean {
        return (batekoakDitu(zenbakia) && !ehunekoakDitu(zenbakia))
    }

    fun bakarrikEhunekoakEdoBatekoakDitu(zenbakia: Int): Boolean {
        return (ehunekoakDituBatekorikGabe(zenbakia) || batekoakDituEhunekorikGabe(zenbakia))
    }

    fun zenbatMultzoFaltaDiraMilioikoenHondarrean(hondarra: Int): Int {
        var faltaDirenMultzoak: Int = 0

        if (batekoakDitu(hondarra)) {
            faltaDirenMultzoak++
        }

        if (ehunekoakDitu(hondarra)) {
            faltaDirenMultzoak++
        }

        if (batekoMilakoakDitu(hondarra)) {
            faltaDirenMultzoak++
        }

        if (ehunekoMilakoakDitu(hondarra)) {
            faltaDirenMultzoak++
        }

        return faltaDirenMultzoak
    }
}