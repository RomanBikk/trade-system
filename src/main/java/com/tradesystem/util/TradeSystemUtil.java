package com.tradesystem.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TradeSystemUtil<T> {

    public static <T> Class<T> getGenericTypeClassFromObjectByIndex(Object obj, int genericTypeIndex) {
        Type genericSuperClass = obj.getClass().getGenericSuperclass();
        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if (genericSuperClass instanceof ParameterizedType) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<T>) genericSuperClass).getGenericSuperclass();
            }
        }
        return  (Class<T>) parametrizedType.getActualTypeArguments()[genericTypeIndex];
    }

    public static String getPath(HttpServletRequest rq) {
        String[] urlParts = rq.getRequestURI().split("/");
        String path = urlParts[urlParts.length - 1];
        return path;
    }
}
