package com.java8.stream;

import com.bean.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class SortedDemo {

    /**
     * naturalOrder()表示自然排序(一般是升序)，
     * Comparator.reverseOrder()表示 降序。
     *
     * nullsLast()表示如果属性为null，就放到最后面。
     * nullsFirst()表示如果属性为null，就放到最前面。
     *
     */
    public static void order() {
        //设置 order对象属性，以下是lombok的写法，相当于 setter
        Order order1=Order.builder().dateStr("2021-10-01 00:00:00").price(33.3).build();
        Order order2=Order.builder().dateStr("2021-10-01 00:00:00").price(1.3).build();
        Order order3=Order.builder().dateStr("2021-10-01 00:00:00").price(55.3).build();
        Order order4=Order.builder().dateStr("2021-12-01 00:00:00").price(55.3).build();
        Order order5=Order.builder().dateStr(null).price(null).build();

        List<Order> list= new ArrayList<>();
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);


        // ==========================================================================

        //naturalOrder()表示自然排序(一般是升序)，Comparator.nullsLast表示如果属性为null，就放到最后面
        Comparator<Order> comparator =  Comparator.comparing(Order::getDateStr, Comparator.nullsLast(naturalOrder()) );
        List<Order> orderList = list.stream().sorted(comparator).collect(Collectors.toList());
//        System.out.println("orderList："+orderList);

        // ==========================================================================

        //Comparator.reverseOrder表示 降序，nullsFirst表示如果属性为null，就放到最前面。
        Comparator<Order> comparator2 = Comparator.comparing(Order::getDateStr, Comparator.nullsFirst(Comparator.reverseOrder()));
        List<Order> orderList2 = list.stream().sorted(comparator2).collect(Collectors.toList());
//        System.out.println("orderList2："+ orderList2);

        // ==========================================================================

        //先按第一个字段降序，再按第二个字段降序，如果属性为null，就放到最后面。
        //输出： [Order(price=55.3, dateStr=2021-12-01 00:00:00),
        //Order( price=55.3, dateStr=2021-10-01 00:00:00),
        //Order(price=33.3, dateStr=2021-10-01 00:00:00),
        //Order(price=1.3, dateStr=2021-10-01 00:00:00)]

        Comparator<Order> comparator3 = Comparator.comparing(Order::getDateStr, Comparator.nullsLast(Comparator.reverseOrder()))
                .thenComparing(Order::getPrice, Comparator.nullsLast(Comparator.reverseOrder()));
        List<Order> orderList3 = list.parallelStream().sorted(comparator3).collect(Collectors.toList());
        System.out.println("orderList3："+ orderList3);


    }


}
