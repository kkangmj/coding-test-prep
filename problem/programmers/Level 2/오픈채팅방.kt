import java.util.*

fun main() {

    val record: Array<String> = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )

    val tokenizedRecord = ArrayList<ArrayList<String>>()

    for (i in record) {
        tokenizedRecord.add(tokenizeRecord(i))
    }

    val user = updateUserNickname(tokenizedRecord)
    val answer = recordToKorean(tokenizedRecord, user)

    // return answer
}

fun tokenizeRecord(recordItem: String): ArrayList<String> {
    val st = StringTokenizer(recordItem)
    val tokenizedRecordItem = ArrayList<String>()

    while (st.hasMoreTokens()) {
        val token = st.nextToken()
        tokenizedRecordItem.add(token)
    }
    return tokenizedRecordItem
}

fun updateUserNickname(tokenizedRecord: ArrayList<ArrayList<String>>): MutableMap<String, String> {
    val userNickname = mutableMapOf<String, String>()
    for (i in tokenizedRecord) {
        if (i[0] != "Leave")
            userNickname.put(i[1], i[2])
    }
    return userNickname
}

fun recordToKorean(
    tokenizedRecord: ArrayList<ArrayList<String>>,
    user: Map<String, String>
): Array<String> {

    val result = ArrayList<String>()

    for (i in tokenizedRecord) {
        val sb = StringBuilder()
        sb.append("\"")
        sb.append(user[i[1]])
        sb.append("님이")
        if (i[0] != "Change") {
            sb.append(
                when (i[0]) {
                    "Enter" -> "들어왔습니다.\""
                    "Leave" -> "나갔습니다.\""
                    else -> ""
                }
            )
            result.add(sb.toString())
        }
    }
    return result.toArray(arrayOfNulls(result.size))
}