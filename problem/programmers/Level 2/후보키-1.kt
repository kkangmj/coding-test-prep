class Solution3 {
    fun solution(relation: Array<Array<String>>): Int {
        val combinationOfKeys = getCombinationOfKeys(relation[0].size)
        return getNumberOfCandidateKey(relation, combinationOfKeys)
    }

    private fun getCombinationOfKeys(numberOfColumn: Int): MutableSet<MutableSet<Int>> {
        val listOfKey = IntArray(numberOfColumn)

        for (i in 0 until numberOfColumn) {
            listOfKey[i] = i
        }

        val combinationOfKeys = mutableSetOf<MutableSet<Int>>()

        for (r in 1..numberOfColumn) {
            combination(
                0,
                0,
                r,
                IntArray(r),
                listOfKey,
                BooleanArray(numberOfColumn),
                combinationOfKeys
            )
        }

        return combinationOfKeys
    }

    private fun combination(
        index: Int,
        start: Int,
        r: Int,
        combinationArray: IntArray,
        keyArray: IntArray,
        visited: BooleanArray,
        combinationOfKeys: MutableSet<MutableSet<Int>>
    ) {
        if (r == 0) {
            combinationOfKeys.add(combinationArray.toMutableSet())
            return
        }

        for (i in keyArray.indices) {
            if (!visited[i]) {
                visited[i] = true
                combinationArray[index] = keyArray[i]
                combination(
                    index + 1,
                    start + 1,
                    r - 1,
                    combinationArray,
                    keyArray,
                    visited,
                    combinationOfKeys
                )
                visited[i] = false
            }
        }
    }


    private fun getNumberOfCandidateKey(
        relation: Array<Array<String>>,
        combinationOfKeys: MutableSet<MutableSet<Int>>
    ): Int {
        val candidateKeys = mutableSetOf<MutableSet<Int>>()

        for (i in combinationOfKeys) {
            if (isUnique(relation, i) && isMinimal(i, candidateKeys)) {
                candidateKeys.add(i)
            }
        }

        return candidateKeys.size
    }

    private fun isUnique(relation: Array<Array<String>>, key: MutableSet<Int>): Boolean {
        val setOfRelation = mutableSetOf<MutableSet<String>>()

        for (i in relation) {
            val singleRelation = mutableSetOf<String>()
            for (j in key) {
                singleRelation.add(i[j])
            }
            setOfRelation.add(singleRelation)
        }

        if (setOfRelation.size != relation.size) return false

        return true
    }

    private fun isMinimal(
        key: MutableSet<Int>,
        candidateKeys: MutableSet<MutableSet<Int>>
    ): Boolean {

        for (i in candidateKeys) {
            if (key.containsAll(i)) return false
        }

        return true
    }
}


fun main() {
    val relation = arrayOf(
        arrayOf("aa", "a"),
        arrayOf("a", "aa"),
        arrayOf("a", "a")
    )

    val solution3 = Solution3()
    println(solution3.solution(relation))
}



