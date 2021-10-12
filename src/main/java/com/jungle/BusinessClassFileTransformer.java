package com.jungle;

import jdk.internal.instrumentation.ClassInstrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class BusinessClassFileTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.startsWith("java") || className.startsWith("sun")) {
            return null;
        }
        if (classBeingRedefined.isInterface()) {
            return null;
        }
        return ClassInstrumentationFactory.modifyClass(classfileBuffer);
    }
}
