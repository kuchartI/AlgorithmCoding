package leetcode.hard

//224. Basic Calculator

fun main() {
    println(calculate("1231 + ((1  - 15) +124124124) "))
}

fun calculate(s: String): Int {
    val deleteSpaceString = s.replace(" ", "")
    var counter = 0
    fun recursion(s: String): Int {
        var tempResult = 0
        var sign = '+'
        while (counter < deleteSpaceString.length) {
            var number = 0
            while (counter < deleteSpaceString.length && s[counter].isDigit()) {
                number = number * 10 + (s[counter] - '0')
                counter++
            }
            if (sign == '-') {
                tempResult -= number
            } else {
                tempResult += number
            }
            if (counter == deleteSpaceString.length) {
                return tempResult
            }
            if (s[counter] == '-') {
                sign = '-'
            } else if (s[counter] == '+') {
                sign = '+'
            } else if (s[counter] == '(') {
                counter++
                if (sign == '-') {
                    tempResult -= recursion(s)
                } else {
                    tempResult += recursion(s)
                }
            } else if (s[counter] == ')') {
                return tempResult
            }
            counter++
        }
        return tempResult
    }
    return recursion(deleteSpaceString)
}