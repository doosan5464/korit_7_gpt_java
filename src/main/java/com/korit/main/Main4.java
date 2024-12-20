package com.korit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main4 {

    public static List<Integer> createListWithForLoop() {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tempList.add(i);
        }
        return tempList;
    }

    public static List<Integer> multiplyListWithForLoop(List<Integer> list) {
        List<Integer> tempList = new ArrayList<>();
        for (int num : list) {
            tempList.add(num * 10);
        }
        return tempList;
    }

    // null값을 대체하기 위해 stream으로 1부터 10까지의 숫자를 만들어줌
    public static List<Integer> createListWithStream() {
        return IntStream.rangeClosed(1, 10) // stream 타입의 시작~끝까지의 숫자 지정
                .boxed()    // 기본형에서 참조형으로
                .collect(Collectors.toList());
    }

    public static List<Integer> multiplyListWithStream(List<Integer> list) {
        return list.stream()
                .map(num -> num * 10)
                .collect(Collectors.toList());
    }
    /*
    null - 주소할당 x

     List<Integer> numbers = new ArrayList<>();
     list.forEach(temp -> numbers.add(temp*10))

     - 강사님 stream 버전
     Stream<Integer> stream. stream도 타입개념
     return numbers.stream().map(num->num*10).collect(Collectors.toList());

    map 은 중간 가공. map도 결국 ()로 함수 호출. 그러므로 변수. 값이 들어가야 함 함수대신 람다?
    기존 스트림을 기반으로 새로운 변환된 스트림을 생성한다
     */


    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list2 = null;
        List<Integer> list3 = null;

        System.out.println("list: " + list);

        list2 = createListWithForLoop();
        list2 = multiplyListWithForLoop(list2);
        System.out.println("list2: " + list2);


        list3 = createListWithStream();
        list3 = multiplyListWithStream(list3);
        System.out.println("list3: " + list3);
    }
}
