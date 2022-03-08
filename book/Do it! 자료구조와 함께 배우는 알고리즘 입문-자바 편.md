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

## **03 검색**

### **03-1 검색 알고리즘**

- 배열 검색을 위한 알고리즘
  - 선형 검색
    - 무작위로 늘어놓은 데이터 모임에서 검색 수행
  - 이진 검색
    - 일정한 규칙으로 늘어놓은 데이터 모임에서 빠른 검색 수행
  - 해시법
    - 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색 수행

<br>

### **03-2 선형 검색**

- 선형 검색(순차 검색)
  - 원하는 키 값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 요소검색

```
static int seqSearch(int[] a, int n, int key) {
    for (int i = 0; i < n; i++) {
        if (a[i] == key) {
            return i;
        }
    }
    return -1;
}
```

<br>

### **03-3 이진 검색**

- 이진 검색
  - 요소가 오름차순 또는 내림차순으로 정렬된 배열에서 검색하는 알고리즘

```
static int binSearch(int[] a, int n, int key) {
    int pl = 0;
    int pr = n-1;

    do {
        int pc = (pl + pr) / 2;
        if (a[pc] == key) {
            return pc;
        } else if (a[pc] < key) {
            pl = pc + 1;
        } else {
            pr = pc - 1;
        }
    } while(pl <= pr);

    return -1;
}
```

- 복잡도: 알고리즘의 성능을 객관적으로 평가하는 기준
  - 시간 복잡도
    - 실행에 필요한 시간을 평가한 것
  - 공간 복잡도
    - 기억 영역과 파일 공간이 얼마나 필요한가를 평가한 것

<br>

- 선형 검색 VS 이진 검색 시간 복잡도
  - 선형 검색의 시간 복잡도 ➡️ O(n)
  - 이진 검색의 시간 복잡도 ➡️ O(log n)

<br>

- java.util.Arrays 클래스의 binarySearch 메서드

  - 오름차순으로 정렬된 배열 a를 가정하고, 키 값이 key인 요소를 이진 검색하는 메서드

    ```
    // 자료형에 따라 9가지 방법으로 오버로딩 되어 있음.

    static int binarySearch(byte[] a, byte key)
    static int binarySearch(char[] a, char key)
    static int binarySearch(double[] a, double key)
    ...
    ```

  - 반환값
    - 검색에 성공했을 때 key와 일치하는 요소의 인덱스를 반환
    - 검색에 실패했을 때 음수값을 반환

<br>

- 객체의 배열에서 검색하기
  - static int binarySearch(Object[] a, Object key)
    - 자연 정렬된 배열에서 대소 관계를 판단함.
    - 정수 배열, 문자열 배열 검색 시 적절함.
  - static <T> int binarySearh(T[] a, T key, Comparator<? super T> c)
    - Comparator 인터페이스를 구현해 인자로 전달해줘야 함. 호출된 binarySearch 메서드는 전달받은 comparator를 기준으로 배열의 대소 관계를 판단하여 이진 검색을 수행함.

<br>
<br>

## **04 스택과 큐**

### **04-1 스택**

- 스택
  - 데이터의 입력과 출력 순서는 후입선출(LIFO)

```
// 스택 구현 프로그램

public class IntStack {
    private int max;    // 스택 용량
    private int ptr;    // 스택에 새로운 데이터 삽입할 인덱스
    private int[] stk;    // 스택 본체

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }
}
```

- push 메서드
  - 전달 받은 데이터 x를 배열에 저장하고 ptr을 증가시킴.
