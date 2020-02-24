package com.eng.corso.util;

import com.eng.corso.interfaces.Mergeable;

import java.util.HashMap;
// estensione di hash map che gestisce gli inserimenti mergiando gli elemente anziche sostituirli
public class MergeableHashMap<K, T extends Mergeable> extends HashMap<String, T> {
    @Override
    public T put(String key, Mergeable value) {
        T curValue = super.get(key);
        if (curValue == null) {
            curValue = (T) value;
            super.put(key, curValue);
        } else {
            curValue.merge(value);
        }
        return curValue;
    }
}
