package com.jungle;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;

public class MyClassAdapter extends ClassVisitor {
    private final String className;

    public MyClassAdapter(String className, ClassWriter classWriter) {
        super(ASM6, classWriter);
        this.className = className;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (check(access, name)) {
            return methodVisitor;
        }
        return new MyMethodAdapter(className, access, name, descriptor, methodVisitor);
    }

    private boolean check(int access, String name) {
        boolean result = ((access & ACC_PRIVATE) == 0);
        result |= ((access & ACC_ABSTRACT) == 0);
        result |= ((access & ACC_NATIVE) == 0);
        result |= ((access & ACC_BRIDGE) == 0);
        result |= ((access & ACC_SYNTHETIC) == 0);
        result |= "<init>".endsWith(name);
        result |= "<clinit>".endsWith(name);
        return result;
    }
}
