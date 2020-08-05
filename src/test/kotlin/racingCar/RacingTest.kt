package racingCar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCar.domain.RacingCars
import racingCar.domain.RacingCars.Companion.participant

class RacingTest {

    private var racingCarNames = listOf<String>()
    private lateinit var racingCarResult: RacingCars

    private fun setup() {
        racingCarNames = mutableListOf("찬희", "코틀린")
        racingCarResult = RacingCars(racingCarNames)
    }

    @Test
    fun `check input randomNumber over 4`() {
        setup()
        participant[0].changeStateRacingCar(8)
        assertTrue(participant[0].distance == 1)
    }

    @Test
    fun `check input randomNumber below 4`() {
        setup()
        participant[0].changeStateRacingCar(3)
        assertTrue(participant[0].distance == 0)
    }
}
