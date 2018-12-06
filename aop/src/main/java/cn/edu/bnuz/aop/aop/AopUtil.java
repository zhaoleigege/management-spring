package cn.edu.bnuz.aop.aop;

import org.aspectj.lang.reflect.CodeSignature;

/**
 * 文件 AopUtil 创建于 2018/4/17
 *
 * @author 赵磊
 * @version 1.0
 */
public class AopUtil {
    public static String MethodString(Object[] objects, CodeSignature signature) {
        StringBuilder buffer = new StringBuilder(signature.getDeclaringTypeName() + "." + signature.getName() + "(");

        String[] names = signature.getParameterNames();
        if (names != null && names.length > 0) {
            for (int i = 0; i < names.length - 1; i++)
                buffer.append(" ").append(names[i]).append(" : ").append(objects[i]).append(",");

            buffer.append(" ").append(names[names.length - 1]).append(" : ").append(objects[names.length - 1]);
        }

        buffer.append(") ");

        return buffer.toString();
    }

}
