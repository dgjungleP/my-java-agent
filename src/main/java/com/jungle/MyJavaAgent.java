package com.jungle;

import java.lang.instrument.Instrumentation;

public class MyJavaAgent {
    public static void premain(String agentOpts, Instrumentation instrumentation) {
        System.out.println("Premain function run...");
        System.out.println("Opts is:" + agentOpts);
        instrumentation.addTransformer(new BusinessClassFileTransformer());
    }
}
