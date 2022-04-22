## 정렬
### 선택 정렬
- 로직
  1. 정렬되지 않은 배열의 첫 인덱스부터 그 이후의 배열값 중 가장 작은 값을 찾음.
  2. 가장 작은 값을 찾으면 그 값을 현재 인덱스와 바꿔줌. 
  3. 다음 인덱스에서 1, 2번 계속 반복함. 
```
fun selectionSort(array: ArrayList<Int>) {
  var min: Int
  for (i in array.indices) {
    min = i
    for (j in i+1 until array.size) {
      if (array[i] < array[min]) {
        min = j
      }
    }
    swap(array, min, i)
  }
}

fun swap(array: ArrayList<Int>, min: Int, i: Int) {
  var temp = array[min]
  array[min] = array[i]
  array[i] = temp
}
```
- 시간복잡도: O(n^2)
- 안정 정렬이 아님.
  - 안정 정렬: 도일한 값에 대해 기존의 순서가 유지되는 정렬
  - ex) 3 3 1 5


### 삽입 정렬
- 배열의 두 번째 요소부터 시작해 그 앞의 요소들과 대소 비교하여 삽입할 위치를 지정한 후, 삽입 위치 이후의 요소들을 한 칸씩 뒤로 미루면서 삽입
```
fun insertSort(array: ArrayList<Int>) {
  for (i in 1..array.size) {
    val key = array[i]
    val index = i
    
    while ((index > 0) && (array[index] > key)) {
      array[index] = array[index-1]
      index--
    }
    array[index] = key
  }
}
```
- 시간복잡도: O(n^2)
  - 단, 정렬된 배열에서는 O(n)의 시간복잡도를 가짐.
- 안정 정렬임.


### 버블 정렬


- 인접한 2개의 레코드의 키를 비교하여 순서대로 되어 있지 않으면 교환
- 이러한 비교-교환 과정을 리스트의 왼쪽 끝에서 오른쪽의 끝까지 반복

  <img src="https://user-images.githubusercontent.com/52561963/164128849-6414a7e9-b837-424e-86e8-b03e1cb85c8c.jpg" width="400" >

```
fun bubbleSort(array: Array<Int>) {
  for (i in 1..array.size) {
    for (j in 0 until array.size-1) {
      if (array[j] > array[j+1]) {
        var temp = array[j]
        array[j] = array[j+1]
        array[j+1] = temp
      }
    }
  }
}
```

- 시간복잡도: O(n^2)
- 완전 탐색
- 안정 정렬임.


### 병합 정렬
- 분할: 리스트를 두 개의 균등한 크기의 배열로 분할
- 정복: 각 부분 배열을 재귀적으로 정렬, 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용해 다시 분할 정복 방법 적용
- 결합: 2개의 정렬된 부분배열을 하나의 배열에 병합

  <img src="https://user-images.githubusercontent.com/52561963/164129316-438549fd-4174-44d0-9b47-e3cf4960fd48.png" width="400" >

```
fun mergeSort(array: IntArray, left: Int, right: Int) {
  if (left < right) {
      val mid = (left + right) / 2
    mergeSort(array, left, mid)
    mergeSort(array, mid + 1, right)
    merge(array, left, mid, right)
  }
}

fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
  var leftArrayIndex = left    // 정렬된 왼쪽 리스트에 대한 인덱스
  var rightArrayIndex = mid + 1    // 정렬된 오른쪽 리스트에 대한 인덱스
  var sortedArrayIndex = left    // 정렬될 리스트에 대한 인덱스
  
  val sortedArray = IntArray(array.size)
  
  while (leftArrayIndex <= mid && rightArrayIndex <= right) {
    if (array[leftArrayIndex] <= array[rightArrayIndex]) {
      sortedArray[sortedArrayIndex] = array[leftArrayIndex]
      sortedArrayIndex += 1
      leftArrayIndex += 1
    } else {
      sortedArray[sortedArrayIndex] = array[rightArrayIndex]
      sortedArrayIndex += 1
      rightArrayIndex += 1
    }
  }
  
  if (leftArrayIndex > mid) {
    // 정렬된 오른쪽 리스트에 값이 남아 있는 경우
    for (i in rightArrayIndex..right) {
      sortedArray[sortedArrayIndex] = array[i]
      sortedArrayIndex += 1
    }
  } else {
    // 정렬된 왼쪽 리스트에 값이 남아 있는 경우
    for (i in leftArrayIndex..mid) {
      sortedArray[sortedArrayIndex] = array[i]
      sortedArrayIndex += 1
    }
  }
  
  // 값을 원래 리스트로 복사하기
  for (i in left..right) {
    array[i] = sortedArray[i]
  }
}
```
- REFERENCE
  - https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html
  - https://cocoon1787.tistory.com/779
```
fun split(array: ArrayList<Int>) {
  if (arr.size <= 1) return array
  val middle = arr.size / 2
  val left = split(ArrayList(array.subList(0, middle)))
  val right = split(ArrayList(array.subList(middle, arr.size)))
  
  return merge(left, right)
}

fun merge(left: ArrayList<Int>, right: ArrayList<Int>) {
  val mergedArray = arrayListOf<Int>()
  var leftIndex = 0
  var rightIndex = 0
  
  // left, right 모두 존재
  while (leftIndex < left.size && rightIndex < right.size) {
    if (left[leftIndex] < right[rightIndex]) {
        mergedList.add(left[leftIndex])
        leftIndex++
    } else {
        mergedList.add(right[rightIndex])
        rightIndex++
    }
  }
  
  // right만 존재
  while (rightIndex < right.size) {
      mergedList.add(right[rightIndex])
      rightIndex++
  }

  // left만 존재
  while (leftIndex < left.size) {
      mergedList.add(left[leftIndex])
      leftIndex++
  }
  return mergedList
}
```
- 시간복잡도: O(nlogn)
- 분할 정복 방식
- 안정 정렬임. 

### 퀵 정렬
- 리스트 안에 있는 한 요소(피벗)을 선택함.
- 피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮기고 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮김.
- 피벗을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬함. 
- 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복함. 

```
fun qSort1(array: IntArray, left: Int = 0, right: Int = array.size - 1) { 
  val index = partition(array, left, right)
  if (left < index - 1) {
    qSort1(array, left, index - 1)
  }
  if (index < right) {
    qSort1(array, index, right)
  }
} 

fun partition(array: IntArray, start: Int, end: Int): Int {
  var left = start
  var right = end
  val pivot = array[(left + right) / 2]

  while (left <= right) {
      while (array[left] < pivot) {
          left++
      }

      while (array[right] > pivot) {
          right--
      }

      if (left <= right) {
          val temp = array[left]
          array[left] = array[right]
          array[right] = temp
          left++
          right--
      }
  }
  return left
}
```
```
fun qSort2(arr: ArrayList<Int>): ArrayList<Int> {

  if (arr.size <= 1) return arr

  val pivot = arr.removeFirst()

  val left = arrayListOf<Int>()
  val right = arrayListOf<Int>()

  for (i in arr.indices) {

      if (arr[i] > pivot) {
          right.add(arr[i])
      } else {
          left.add(arr[i])
      }
  }

  val mergedList = arrayListOf<Int>()

  mergedList.addAll(quickMerge(left))
  mergedList.add(pivot)
  mergedList.addAll(quickMerge(right))
  return mergedList
}
```

- 시간복잡도:
  - 최선의 경우 O(nlogn)
  - 최악의 경우 O(n^2)
- 분할 정복 방식

### 힙 정렬
- 최대힙을 만드는 과정 
  - 최대힙: 부모 노드의 값이 자식 노드의 값보다 같거나 큰 힙
- 만들어진 최대힙을 정렬하는 과정
```
fun heapSort(array: ArrayList<Int>) {
  
  // (1) 최대힙 만들기
  for (i in (array.size/2-1) downTo 0) {
    heapify(array, array.size, i)
  }
  
  // (2) 최대힙 정렬하기
  for (i in (array.size-1) downTo 0) {
    // 최상단 노드와 최하단 노드의 값 교환
    swap(array, i, 0)
    // 루트 노드를 기준으로 최대힙 만들기 
    heapify(array, i, 0)  
  }
}

fun heapify(array: ArrayList<Int>, size: Int, pNode: Int) {
  var parent = pNode
  val lChild = pNode * 2 + 1
  val rChild = pNode * 2 + 2
  var child = 0
  
  if (size > lChild && size > rChild) {
    child = if (array[lChild] > array[rChild]) lChild else rChild
  } else if (size > lChild && size <= rChild) {
    child = lChild
  } else if (size <= lChild && size > rChild) {
    child = rChild
  } else {
    return -1
  }
  
  if (array[parent] < array[child]) {
    parent = child
  }
  
  if (parent != pNode) {
    swap(array, pNode, parent)
    heapify(array, size, parent)  
  }

}
```


### Ref
- https://week-year.tistory.com/201 (퀵 정렬)
- https://hungseong.tistory.com/43 (퀵 정렬, 병합 정렬)
- https://hmkim829.tistory.com/9 (힙 정렬)


<br>

## What I've learned
### 퀵 정렬, 힙 정렬이 모든 경우에 답은 아니다.
- 2751번 문제에서 퀵 정렬로 문제를 풀었을 때 시간초과
- 힙 정렬로 문제를 풀었을 때는 1644ms...
- 그런데 알고리즘 없이 간단하게 배열로 풀었을 때(other-1) 실행시간은 676ms

<br>

### 두 객체 비교 시 Comparable의 compareTo를 구현하는 것보다 비교 메서드를 따로 구현하는 것이 빠르다.
- 'Kotlin in Action' 공부하며 코틀린에서는 비교 연산자(<, > 등)가 compareTo 호출로 컴파일됨을 배움. 이러한 코틀린의 관례에 따라 compareTo를 직접 사용하는 것보다 비교 연산자를 사용하면 코드를 훨씬 간결하게 작성할 수 있다는 것을 배움. 
- 따라서, 이를 11651번 문제에 적용해봄. 그러나 Comparable을 구현한 코드(11651-comparable.kt)와 비교 메서드를 따로 구현한 코드(11651_좌표 정렬하기_2.kt)의 실행 시간을 비교해본 결과, Comparable을 구현하는 것보다 비교 메서드를 직접 구현하는 것이 빠르다는 것을 알게 됨. 

  <img src="https://user-images.githubusercontent.com/52561963/162363269-a07661fe-70ac-4243-8ef3-f334d19ab0dd.png" width="400" >

<br>

## ETC
- 11651번 문제 코틀린 기준 3등!
  <img src="https://user-images.githubusercontent.com/52561963/162118316-e57b0517-7033-4660-93fe-ef128bf376a2.png" width="400" />