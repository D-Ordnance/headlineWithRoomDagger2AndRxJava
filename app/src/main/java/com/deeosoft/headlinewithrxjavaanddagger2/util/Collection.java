package com.deeosoft.headlinewithrxjavaanddagger2.util;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static <F, T> List<T> transform(List<F> list, ItemTransform<F, T> itemTransformer){
        if(list == null)
            throw new IllegalArgumentException("The list to be transformed can not be null");
        if(itemTransformer == null)
            throw new IllegalArgumentException("Item Transformer is not implemented");
        List<T> transformedList = new ArrayList<>();

        for(F f: list){
            T t = itemTransformer.execute(f);
            transformedList.add(t);
        }

        return transformedList;
    }

    public interface ItemTransform<F, T>{
        T execute(F f);
    }
}
