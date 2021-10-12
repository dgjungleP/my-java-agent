package com.jungle;

import com.jungle.util.ByteCodeUtils;
import javafx.scene.control.cell.PropertyValueFactory;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyMethodAdapter extends MethodVisitor {
    private String className;
    private boolean isStaticMethod = false;
    private String methodName;
    private String descriptor;
    private String[] paramDescriptions;
    private Label from = new Label();
    private Label to = new Label();
    private Label target = new Label();

    public MyMethodAdapter(String className, int access, String name, String descriptor, MethodVisitor methodVisitor) {
        super(Opcodes.ASM6, methodVisitor);
        this.isStaticMethod = (access & Opcodes.ACC_STATIC) == Opcodes.ACC_STATIC;
        this.className = className;
        this.methodName = name;
        this.descriptor = descriptor;
        this.paramDescriptions = ByteCodeUtils.getParamDescriptors(descriptor);
    }
}
