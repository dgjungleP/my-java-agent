package com.jungle;

import java.util.Map;

public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("Main function run...");
        Map<String, Object> map = new UserService().queryUser("jungle", 12);
        System.out.println(map);
    }
}
