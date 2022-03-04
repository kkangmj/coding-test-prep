## **01 기본 알고리즘**

### **01-1 입출력**

```
// Scanner 사용

import java.util.*

fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)
    val name: String = scanner.nextLine()
    val age: Int = scanner.nextInt()
    println("name: $name")
    println("age: $age")
}


// BufferedReader 사용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val tokenizedInput = StringTokenizer(bufferedReader.readLine())

    val name: String = tokenizedInput.nextToken()
    val age: Int = Integer.parseInt(tokenizedInput.nextToken())

    println("name: $name")
    println("age: $age")
}
```

- Scanner 객체의 메서드

  |    메서드     | 자료형  |            입력값의 범위             |
  | :-----------: | :-----: | :----------------------------------: |
  | nextBoolean() | boolean |           true 또는 false            |
  |  nextByte()   |  byte   |             -128 ~ +127              |
  |  nextShort()  |  short  |           -32768 ~ +32767            |
  |   nextInt()   |   int   |                  .                   |
  |  nextLong()   |  long   |                  .                   |
  |  nextFloat()  |  float  |                  .                   |
  | nextDouble()  | double  |                  .                   |
  |    next()     | string  | 문자열(스페이스, 줄바꿈 문자로 구분) |
  |  nextLine()   | string  |              문자열 1줄              |

<br>
<br>

## **02 기본 자료구조**

### **02-1 배열**

```
// 배열의 복제

int[] a = {1, 2, 3, 4, 5};
int[] b = a.clone();
```

- 배열을 복제한 뒤, 복제한 배열에 대한 참조를 생성함.
- 따라서, b를 변경하더라도 a에는 영향이 없음.

```
// 배열 요소가 n개인 배열의 최댓값 구하기

max = a[0]
for (i = 1; i < n; i++) {
    if (a[i] > max) max = a[i]
}
```

- 스캔
  - 배열의 요소를 하나씩 차례로 살펴보는 과정

```
// 배열 요소를 역순으로 정렬하기

static void swap(int[] a, int idx1, int idx2) {
    int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
}
```

- 소수는 아래의 조건을 만족해야 함.
  - 2부터 n-1까지의 어떤 정수로도 나누어떨어지지 않는다.
  - 2부터 n-1까지의 어떤 소수로도 나누어떨어지지 않는다.
  - n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않는다.
    - 25의 제곱근은 5

```
// 1000 이하의 소수를 열거 (ver 1)

for (int n = 2; n <= 1000; n++) {
    int i;
    for (i = 2; i < n; i++) {
        if (n % i == 0) break;
    }
    if (n == i) System.out.println(n);
}
```

```
// 1000 이하의 소수를 열거 (ver 2)

int ptr = 0;    // 찾은 소수의 개수
int[] prime = new int[500];

prime[ptr++] = 2;    // prime[0] = 2 & ptr = 1

for (int n = 3; n <= 1000; n += 2) {
    int i;
    for (int i = 1; i < ptr; i++) {
        if (n % prime[i] == 0) break;
    }
    if (i == ptr) prime[ptr++] = n;
}
```

```
// 1000 이하의 소수를 열거 (ver 3)

int ptr = 0;    // 찾은 소수의 개수
int[] prime = new int[500];

prime[ptr++] = 2;    // prime[0] = 2 & ptr = 1
prime[ptr++] = 3;    // prime[1] = 3 & ptr = 2

for (int n = 5; n <= 1000; n +=2) {
    boolean flag = false;
    for (i = 1; prime[i]*prime[i] <= n; i++) {
        if (n % prime[i] == 0) {
            flag = true;
            break;
        }
    }
    if (!flag) {
        prime[ptr++] = n;
    }
}
```

- 39의 경우, 약수는 1, 3, 13, 39로 1x3, 3x13, 13x3, 39x1로 표현할 수 있음. 양쪽 대칭적이기 때문에 한 쪽만 검사해도 됨.

```
// 다차원 배열

int[][] x = new int[2][3];
```

- 2행 3열의 2차원 배열

```
// 다차원 배열의 복제

int[][] a = {{1, 2, 3, 4}, {5, 6, 7}};
int[][] b = a.clone();
```

- 일차원 배열과는 다르게, 다차원 배열은 복제되지 않고 공유됨.

<br>
<br>

## **02 기본 자료구조**

### **02-1 배열**
