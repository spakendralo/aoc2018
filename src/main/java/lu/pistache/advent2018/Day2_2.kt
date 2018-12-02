package lu.pistache.advent2018

class Day2_2 : AbstractDay2() {

    val commonLetters: String
        get() {
            for (i in 0 until lines.size - 2) {
                for (j in i + 1 until lines.size - 1) {
                    var diffs = 0
                    val left = lines[i]
                    val right = lines[j]
                    for (k in 0 until left.length - 1) {
                        when {
                            left[k] != right[k] -> diffs++
                        }
                    }
                    if (diffs == 1) {
                        val retStr = StringBuffer()
                        for (k in 0 until left.length) {
                            if (left[k] == right[k]) {
                                retStr.append(left[k])
                            }

                        }
                        return retStr.toString()
                    }
                }

            }
            return ""
        }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Day2_2().commonLetters)
        }
    }
}
