package eus.avallende.lanabeus.model.zenbaki

import kotlin.test.Test
import kotlin.test.fail

class ZenbakiTest {

    @Test
    fun zenbakiTestGuztiakEgikaritu() {
        testZifrakLetretan()
        testZifrakLetretanHamarBainoGutxiago()
        testLetretanEhunBainoGutxiago()
        testZifrakLetretanMilaBainoGutxiago()
        testZifrakLetretanMilioiBainoGutxiago()
        testZifrakLetretanMilaMilioiBainoGutxiago()
    }

    private fun <T> testaEgikaritu(
        testarenIzena: String,
        datuak: List<Pair<T, String>>,
        testarenFuntzioa: (T) -> String
    ) {
        val akatsak = mutableListOf<String>()

        for ((sarrera, itxarotakoBalioa) in datuak) {
            try {
                val benetakoBalioa = testarenFuntzioa(sarrera)
                if (benetakoBalioa != itxarotakoBalioa) {
                    akatsak.add("Sarrera <$sarrera>: itxaropena bazen <$itxarotakoBalioa> izatea, baina ateratako balioa <$benetakoBalioa> da")
                }
            } catch (salb: Exception) {
                akatsak.add("Sarrera <$sarrera>: botatako salbuespena: ${salb.message}")
            }
        }

        if (akatsak.isNotEmpty()) {
            fail("[$testarenIzena] Akatsdun klaseak:\n${akatsak.joinToString("\n")}")
        }
    }

    @Test
    fun testZifrakLetretan() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_0 to ZenbakiConstants.LETRETAN_0,
            ZenbakiConstants.ZIFRETAN_1 to ZenbakiConstants.LETRETAN_1,
            ZenbakiConstants.ZIFRETAN_2 to ZenbakiConstants.LETRETAN_2,
            ZenbakiConstants.ZIFRETAN_3 to ZenbakiConstants.LETRETAN_3,
            ZenbakiConstants.ZIFRETAN_4 to ZenbakiConstants.LETRETAN_4,
            ZenbakiConstants.ZIFRETAN_5 to ZenbakiConstants.LETRETAN_5,
            ZenbakiConstants.ZIFRETAN_6 to ZenbakiConstants.LETRETAN_6,
            ZenbakiConstants.ZIFRETAN_7 to ZenbakiConstants.LETRETAN_7,
            ZenbakiConstants.ZIFRETAN_8 to ZenbakiConstants.LETRETAN_8,
            ZenbakiConstants.ZIFRETAN_9 to ZenbakiConstants.LETRETAN_9,
            ZenbakiConstants.ZIFRETAN_10 to ZenbakiConstants.LETRETAN_10,
            ZenbakiConstants.ZIFRETAN_11 to ZenbakiConstants.LETRETAN_11,
            ZenbakiConstants.ZIFRETAN_12 to ZenbakiConstants.LETRETAN_12,
            ZenbakiConstants.ZIFRETAN_13 to ZenbakiConstants.LETRETAN_13,
            ZenbakiConstants.ZIFRETAN_14 to ZenbakiConstants.LETRETAN_14,
            ZenbakiConstants.ZIFRETAN_15 to ZenbakiConstants.LETRETAN_15,
            ZenbakiConstants.ZIFRETAN_16 to ZenbakiConstants.LETRETAN_16,
            ZenbakiConstants.ZIFRETAN_17 to ZenbakiConstants.LETRETAN_17,
            ZenbakiConstants.ZIFRETAN_18 to ZenbakiConstants.LETRETAN_18,
            ZenbakiConstants.ZIFRETAN_19 to ZenbakiConstants.LETRETAN_19,
            ZenbakiConstants.ZIFRETAN_20 to ZenbakiConstants.LETRETAN_20,
            ZenbakiConstants.ZIFRETAN_21 to ZenbakiConstants.LETRETAN_21,
            ZenbakiConstants.ZIFRETAN_22 to ZenbakiConstants.LETRETAN_22,
            ZenbakiConstants.ZIFRETAN_30 to ZenbakiConstants.LETRETAN_30,
            ZenbakiConstants.ZIFRETAN_31 to ZenbakiConstants.LETRETAN_31,
            ZenbakiConstants.ZIFRETAN_32 to ZenbakiConstants.LETRETAN_32,
            ZenbakiConstants.ZIFRETAN_40 to ZenbakiConstants.LETRETAN_40,
            ZenbakiConstants.ZIFRETAN_47 to ZenbakiConstants.LETRETAN_47,
            ZenbakiConstants.ZIFRETAN_50 to ZenbakiConstants.LETRETAN_50,
            ZenbakiConstants.ZIFRETAN_58 to ZenbakiConstants.LETRETAN_58,
            ZenbakiConstants.ZIFRETAN_60 to ZenbakiConstants.LETRETAN_60,
            ZenbakiConstants.ZIFRETAN_70 to ZenbakiConstants.LETRETAN_70,
            ZenbakiConstants.ZIFRETAN_80 to ZenbakiConstants.LETRETAN_80,
            ZenbakiConstants.ZIFRETAN_90 to ZenbakiConstants.LETRETAN_90,
            ZenbakiConstants.ZIFRETAN_95 to ZenbakiConstants.LETRETAN_95,
            ZenbakiConstants.ZIFRETAN_100 to ZenbakiConstants.LETRETAN_100,
            ZenbakiConstants.ZIFRETAN_101 to ZenbakiConstants.LETRETAN_101,
            ZenbakiConstants.ZIFRETAN_127 to ZenbakiConstants.LETRETAN_127,
            ZenbakiConstants.ZIFRETAN_200 to ZenbakiConstants.LETRETAN_200,
            ZenbakiConstants.ZIFRETAN_240 to ZenbakiConstants.LETRETAN_240,
            ZenbakiConstants.ZIFRETAN_300 to ZenbakiConstants.LETRETAN_300,
            ZenbakiConstants.ZIFRETAN_400 to ZenbakiConstants.LETRETAN_400,
            ZenbakiConstants.ZIFRETAN_500 to ZenbakiConstants.LETRETAN_500,
            ZenbakiConstants.ZIFRETAN_600 to ZenbakiConstants.LETRETAN_600,
            ZenbakiConstants.ZIFRETAN_700 to ZenbakiConstants.LETRETAN_700,
            ZenbakiConstants.ZIFRETAN_731 to ZenbakiConstants.LETRETAN_731,
            ZenbakiConstants.ZIFRETAN_800 to ZenbakiConstants.LETRETAN_800,
            ZenbakiConstants.ZIFRETAN_881 to ZenbakiConstants.LETRETAN_881,
            ZenbakiConstants.ZIFRETAN_900 to ZenbakiConstants.LETRETAN_900
        )
        testaEgikaritu("zifrakLetretan", datuak) { Zenbaki.zifrakLetretan(it) }
    }

    @Test
    fun testZifrakLetretanHamarBainoGutxiago() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_1 to ZenbakiConstants.LETRETAN_1,
            ZenbakiConstants.ZIFRETAN_2 to ZenbakiConstants.LETRETAN_2,
            ZenbakiConstants.ZIFRETAN_3 to ZenbakiConstants.LETRETAN_3,
            ZenbakiConstants.ZIFRETAN_4 to ZenbakiConstants.LETRETAN_4,
            ZenbakiConstants.ZIFRETAN_5 to ZenbakiConstants.LETRETAN_5,
            ZenbakiConstants.ZIFRETAN_6 to ZenbakiConstants.LETRETAN_6,
            ZenbakiConstants.ZIFRETAN_7 to ZenbakiConstants.LETRETAN_7,
            ZenbakiConstants.ZIFRETAN_8 to ZenbakiConstants.LETRETAN_8,
            ZenbakiConstants.ZIFRETAN_9 to ZenbakiConstants.LETRETAN_9
        )
        testaEgikaritu("zifrakLetretanHamarBainoGutxiago", datuak) { Zenbaki.zifrakLetretanHamarBainoGutxiago(it) }
    }

    @Test
    fun testLetretanEhunBainoGutxiago() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_10 to ZenbakiConstants.LETRETAN_10,
            ZenbakiConstants.ZIFRETAN_11 to ZenbakiConstants.LETRETAN_11,
            ZenbakiConstants.ZIFRETAN_12 to ZenbakiConstants.LETRETAN_12,
            ZenbakiConstants.ZIFRETAN_13 to ZenbakiConstants.LETRETAN_13,
            ZenbakiConstants.ZIFRETAN_14 to ZenbakiConstants.LETRETAN_14,
            ZenbakiConstants.ZIFRETAN_15 to ZenbakiConstants.LETRETAN_15,
            ZenbakiConstants.ZIFRETAN_16 to ZenbakiConstants.LETRETAN_16,
            ZenbakiConstants.ZIFRETAN_17 to ZenbakiConstants.LETRETAN_17,
            ZenbakiConstants.ZIFRETAN_18 to ZenbakiConstants.LETRETAN_18,
            ZenbakiConstants.ZIFRETAN_19 to ZenbakiConstants.LETRETAN_19,
            ZenbakiConstants.ZIFRETAN_20 to ZenbakiConstants.LETRETAN_20,
            ZenbakiConstants.ZIFRETAN_21 to ZenbakiConstants.LETRETAN_21,
            ZenbakiConstants.ZIFRETAN_22 to ZenbakiConstants.LETRETAN_22,
            ZenbakiConstants.ZIFRETAN_30 to ZenbakiConstants.LETRETAN_30,
            ZenbakiConstants.ZIFRETAN_31 to ZenbakiConstants.LETRETAN_31,
            ZenbakiConstants.ZIFRETAN_32 to ZenbakiConstants.LETRETAN_32,
            ZenbakiConstants.ZIFRETAN_40 to ZenbakiConstants.LETRETAN_40,
            ZenbakiConstants.ZIFRETAN_47 to ZenbakiConstants.LETRETAN_47,
            ZenbakiConstants.ZIFRETAN_50 to ZenbakiConstants.LETRETAN_50,
            ZenbakiConstants.ZIFRETAN_58 to ZenbakiConstants.LETRETAN_58,
            ZenbakiConstants.ZIFRETAN_60 to ZenbakiConstants.LETRETAN_60,
            ZenbakiConstants.ZIFRETAN_70 to ZenbakiConstants.LETRETAN_70,
            ZenbakiConstants.ZIFRETAN_80 to ZenbakiConstants.LETRETAN_80,
            ZenbakiConstants.ZIFRETAN_90 to ZenbakiConstants.LETRETAN_90,
            ZenbakiConstants.ZIFRETAN_95 to ZenbakiConstants.LETRETAN_95
        )
        testaEgikaritu("zifrakLetretanEhunBainoGutxiago", datuak) { Zenbaki.zifrakLetretanEhunBainoGutxiago(it) }
    }

    @Test
    fun testZifrakLetretanMilaBainoGutxiago() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_100 to ZenbakiConstants.LETRETAN_100,
            ZenbakiConstants.ZIFRETAN_101 to ZenbakiConstants.LETRETAN_101,
            ZenbakiConstants.ZIFRETAN_127 to ZenbakiConstants.LETRETAN_127,
            ZenbakiConstants.ZIFRETAN_200 to ZenbakiConstants.LETRETAN_200,
            ZenbakiConstants.ZIFRETAN_240 to ZenbakiConstants.LETRETAN_240,
            ZenbakiConstants.ZIFRETAN_300 to ZenbakiConstants.LETRETAN_300,
            ZenbakiConstants.ZIFRETAN_400 to ZenbakiConstants.LETRETAN_400,
            ZenbakiConstants.ZIFRETAN_500 to ZenbakiConstants.LETRETAN_500,
            ZenbakiConstants.ZIFRETAN_600 to ZenbakiConstants.LETRETAN_600,
            ZenbakiConstants.ZIFRETAN_700 to ZenbakiConstants.LETRETAN_700,
            ZenbakiConstants.ZIFRETAN_731 to ZenbakiConstants.LETRETAN_731,
            ZenbakiConstants.ZIFRETAN_800 to ZenbakiConstants.LETRETAN_800,
            ZenbakiConstants.ZIFRETAN_881 to ZenbakiConstants.LETRETAN_881,
            ZenbakiConstants.ZIFRETAN_900 to ZenbakiConstants.LETRETAN_900
        )
        testaEgikaritu("zifrakLetretanMilaBainoGutxiago", datuak) { Zenbaki.zifrakLetretanMilaBainoGutxiago(it) }
    }

    @Test
    fun testZifrakLetretanMilioiBainoGutxiago() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_1000 to ZenbakiConstants.LETRETAN_1000,
            ZenbakiConstants.ZIFRETAN_1123 to ZenbakiConstants.LETRETAN_1123,
            ZenbakiConstants.ZIFRETAN_1200 to ZenbakiConstants.LETRETAN_1200,
            ZenbakiConstants.ZIFRETAN_2000 to ZenbakiConstants.LETRETAN_2000,
            ZenbakiConstants.ZIFRETAN_3000 to ZenbakiConstants.LETRETAN_3000,
            ZenbakiConstants.ZIFRETAN_5456 to ZenbakiConstants.LETRETAN_5456,
            ZenbakiConstants.ZIFRETAN_7020 to ZenbakiConstants.LETRETAN_7020,
            ZenbakiConstants.ZIFRETAN_22800 to ZenbakiConstants.LETRETAN_22800,
            ZenbakiConstants.ZIFRETAN_26671 to ZenbakiConstants.LETRETAN_26671,
            ZenbakiConstants.ZIFRETAN_100300 to ZenbakiConstants.LETRETAN_100300,
            ZenbakiConstants.ZIFRETAN_500000 to ZenbakiConstants.LETRETAN_500000,
            ZenbakiConstants.ZIFRETAN_521521 to ZenbakiConstants.LETRETAN_521521
        )
        testaEgikaritu("zifrakLetretanMilioiBainoGutxiago", datuak) { Zenbaki.zifrakLetretanMilioiBainoGutxiago(it) }
    }

    @Test
    fun testZifrakLetretanMilaMilioiBainoGutxiago() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_1100000 to ZenbakiConstants.LETRETAN_1100000,
            ZenbakiConstants.ZIFRETAN_5000001 to ZenbakiConstants.LETRETAN_5000001,
            ZenbakiConstants.ZIFRETAN_5000450 to ZenbakiConstants.LETRETAN_5000450,
            ZenbakiConstants.ZIFRETAN_7450000 to ZenbakiConstants.LETRETAN_7450000,
            ZenbakiConstants.ZIFRETAN_110200600 to ZenbakiConstants.LETRETAN_110200600
        )
        testaEgikaritu("zifrakLetretanMilaMilioiBainoGutxiago", datuak) { Zenbaki.zifrakLetretanMilaMilioiBainoGutxiago(it) }
    }

    @Test
    fun testBakarraEgikaritu() {
        val datuak = listOf(
            ZenbakiConstants.ZIFRETAN_7450000 to ZenbakiConstants.LETRETAN_7450000
        )
        testaEgikaritu("zifrakLetretanMilaMilioiBainoGutxiago", datuak) { Zenbaki.zifrakLetretanMilaMilioiBainoGutxiago(it) }
    }
}
