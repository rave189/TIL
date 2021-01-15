<h1>Hash</h1>

Hash란 입력된 값을 Hash 알고리즘에 따라 다양한 hash값으로 변환 될 수 있다.

하나의 Hash 알고리즘을 선택하여 값을 변환 시킨다면 같은 입력에는 하나의 Hash 값으로 매칭되기 때문에

이분탐색과 같은 알고리즘에 적용할 수 있다.



<h3>HashMap</h3>

<h6>computeIfAbsent와 putIfAbsent의 차이</h6>

computeIfAbsent 메소드는 HashMap에서 key값에 해당하는 값을 찾아(없다면 null) 인자로 주어진 연산을 수행하는 메소드이다.

putIfAbsent 메소드는 HashMap에서 key값을 찾아보고 key가 없다면 입력된 key와 value를 입력하고 key가 존재한다면 key에 맞는 value 값을 반환한다.

여기서 putIfAbsent는 key가 없을 경우 null을 반환한다.

하지만 computeIfAbsent는 key가 없을 경우 key, value를 입력한 후 value를 반환한다.



