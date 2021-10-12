package com.jungle;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ClassInstrumentationFactory {

    public static byte[] modifyClass(byte[] classfileBuffer) {
        ClassReader classReader = new ClassReader(classfileBuffer);
        if ((classReader.getAccess() & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE) {
            return null;
        }
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        MyClassAdapter adapter = new MyClassAdapter(classReader.getClassName(), classWriter);
        classReader.accept(adapter, 0);
        return classWriter.toByteArray();
    }
}
