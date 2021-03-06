package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for com.keithwedinger.Day1
 *
 * @author Keith Wedinger <br>
 * Created On: 12/1/17
 */

class Day1Test {
    private val day1 = Day1()
    private val puzzleInput =
        "367436765224262147416876392821832169781285655941123648172835986213848397566284" +
        "241467793119283183835972359686446876651595915734132336167171121577524691918457" +
        "577129283476247264385162111539468922414495231484194262592917889386218863347344" +
        "978231632813893898536759322467341535638612338949526576258684154323161554872428" +
        "137984257797435619875637349449628468652637227127686748382444443857685684898429" +
        "898781636557718473626561533722659454641286684124392489669393987654461718551445" +
        "442854635172587498137313143659473725488114346463815952731729824661422484742387" +
        "625548586546794154186934785126418641683987221996387756677449779411837724945386" +
        "853988623441645214461159255285344917887284486684553495889724432953913853895517" +
        "832894173498233833247484116891982193299966667522518155625227593745426529691476" +
        "964196699145345867324369127985196977225867957463716973384167168422143133932285" +
        "874133995347163949841839431233755178196228379727964311662646464328934785576593" +
        "877955732348891418973131584576371422383153278774939949335141126455863511271394" +
        "292816759123666694759317119743322713682874139856823749431958864559278395739864" +
        "645551416792919986459366836391625883759745494677676234639355618478695273833952" +
        "782489523147921121131262312467427531197481138288439178125472244983198499475177" +
        "456258448191759739868436366284149656644665821724191972276953684924333531992335" +
        "588723195296268257882881762755465664748242573368639775743473284691533194288837" +
        "486963995449741333925898233437738973131733365688833853641663363623986366844598" +
        "862839642422492289383832192555139964685869535196381115999352291152288375592427" +
        "529259436536236829855763239294154454433781894727824549582323419866267911828616" +
        "441129744182392864867226544421448511735387568596472187681345728583318495432661" +
        "696727452213916593636749214694811436869524787717145857933229268246234829235799" +
        "864347417141671343463845513626641778654528953489489534723289669957311696725735" +
        "556219395848721879993253223278933367366119297526132419352116642489615276877783" +
        "71971259654541239471766714469122213793348414477789271187324629397292446879752673"

    @Test
    internal fun `sumUsingNextDigit with empty string throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sumUsingNextDigit("")
        }
    }

    @Test
    internal fun `sumUsingNextDigit with non-numeric input throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sumUsingNextDigit("123ABC456")
        }
    }

    @Test
    internal fun `sumUsingNextDigit test using puzzle example 1 value of 1122`() {
        Assertions.assertEquals(3, day1.sumUsingNextDigit("1122"))
    }

    @Test
    internal fun `sumUsingNextDigit test using puzzle example 2 value of 1111`() {
        Assertions.assertEquals(4, day1.sumUsingNextDigit("1111"))
    }

    @Test
    internal fun `sumUsingNextDigit test using puzzle example 3 value of 1234`() {
        Assertions.assertEquals(4, day1.sumUsingNextDigit("1111"))
    }

    @Test
    internal fun `sumUsingNextDigit test using puzzle example 3 value of 91212129`() {
        Assertions.assertEquals(9, day1.sumUsingNextDigit("91212129"))
    }

    @Test
    internal fun `sumUsingNextDigit test using puzzle input`() {
        Assertions.assertEquals(1069, day1.sumUsingNextDigit(puzzleInput))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward with empty string throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sumUsingNextDigit("")
        }
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward with non-numeric input throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sumUsingNextDigit("123ABC456")
        }
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle example 1 value of 1212`() {
        Assertions.assertEquals(6, day1.sumUsingDigitHalfwayForward("1212"))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle example 2 value of 1221`() {
        Assertions.assertEquals(0, day1.sumUsingDigitHalfwayForward("1221"))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle example 3 value of 123425`() {
        Assertions.assertEquals(4, day1.sumUsingDigitHalfwayForward("123425"))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle example 4 value of 123123`() {
        Assertions.assertEquals(12, day1.sumUsingDigitHalfwayForward("123123"))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle example 5 value of 12131415`() {
        Assertions.assertEquals(4, day1.sumUsingDigitHalfwayForward("12131415"))
    }

    @Test
    internal fun `sumUsingDigitHalfwayForward test using puzzle input`() {
        Assertions.assertEquals(1268, day1.sumUsingDigitHalfwayForward(puzzleInput))
    }
}