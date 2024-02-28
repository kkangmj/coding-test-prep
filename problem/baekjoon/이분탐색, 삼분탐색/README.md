## 이분탐색 (이진탐색)
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

### N의 제곱근 구하기
- 양의 정수 N이 주어졌을 때 N의 제곱근을 구하는 소스코드 작성. 단, 제곱근 값이 정수일 경우에만 출력.
  - N이 100인 경우 제곱근은 10
  - N이 25인 경우 제곱근은 5
  - N이 10인 경우 제곱근은 -1
```
// 시간복잡도가 O(n)

fun squareRootLoop(n: Int) {
  for (i in 1 until n) {
    if (i * i == n) return i
  }
  return -1
}
```
```
// 시간복잡도가 O(logn)

fun squreRootBSearch(n: Int) {
  var pl = 0
  var pr = n-1
  
  while (pl <= pr) {
    var pc = (pl + pr) / 2
    if (pc * pc == n) return pc
    else if (pc * pc < n) pl = pc + 1
    else pr = pc - 1
  }
  return -1
}
```

### Lower Bound & Upper Bound
<img width="300" alt="image" src="https://user-images.githubusercontent.com/52561963/159408435-b1a50616-afee-4546-b33e-203fc8929cc2.png">

- Lower Bound
  - 특정 key 값과 같거나 key 값보다 큰 값이 처음 나오는 위치 찾기
  ```
  fun binarySearchLowerBound(a: Array<Int>, n: Int, key: Int) {
    var pl = 0
    var pr = n-1
  
    while (pl < pr) {
      var pc = (key + pr) / 2 
      if (key <= a[pc]) {
        pr = pc
      } else {
        pl = pc + 1
      }
    }
    return pl   
  }
    ```

- Upper Bound
  - 특정 key 값보다 처음으로 큰 값이 나오는 위치 찾기
  ```
  fun binarySearchUpperBound(a: Array<Int>, n: Int, key: Int) {
    var pl = 0
    var pr = n-1
  
    while (pl < pr) {
      var pc = (key + pr) / 2 
      if (key < a[pc]) {
        pr = pc
      } else {
        pl = pc + 1
      }
    }
    return pl   
  }
  ```


<br>

## ETC
- 2110번 문제 코틀린 기준 3등!
  <img src="https://user-images.githubusercontent.com/52561963/163559870-37b885fb-0373-4382-adc1-f1f70b501ac1.png" width="400">