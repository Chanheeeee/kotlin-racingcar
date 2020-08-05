package racingCar.view

object InputView {

    private const val PARTICIPANT_NAME_DELIMITER = ","

    fun getCarName(): List<String> {
        println("경주에 참여할 자동차의 이름은?")
        return checkUserInputNames(readLine())
    }

    fun getTrialCount(): Int {
        println("경주를 시도할 횟수는?")
        return checkUserInputCount(readLine())
    }

    private fun checkUserInputNames(names: String?): List<String> {
        if (names.isNullOrBlank()) throw IllegalArgumentException("값을 입력해주세요.")
        return splitNames(names)
    }

    private fun splitNames(names: String): List<String> {
        return names.split(PARTICIPANT_NAME_DELIMITER)
            .filter { !it.isNullOrBlank() }
            .map { it }
    }

    private fun checkUserInputCount(count: String?): Int {
        try {
            if (count.isNullOrBlank()) throw IllegalArgumentException("값을 입력해주세요.")
            if (count.toInt() < 1) throw IllegalArgumentException("0보다 큰 값만 입력할 수 있습니다.")

            return count.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력가능합니다.")
        }
    }
}
