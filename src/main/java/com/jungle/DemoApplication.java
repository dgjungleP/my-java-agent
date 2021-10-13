package com.jungle;

import java.util.Map;

public class DemoApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main function runing...");
        UserService userService = new UserService();
        while (!Thread.interrupted()) {
            Map<String, Object> user = userService.queryUser("wujiuye", 25);
            System.out.println(user);
            Thread.sleep(10000);
        }
    }
}
