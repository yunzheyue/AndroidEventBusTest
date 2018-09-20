/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.app1.matchpolicy;

import com.example.app1.EventType;

import java.util.LinkedList;
import java.util.List;

public class DefaultMatchPolicy implements MatchPolicy {


    //获取类型的父类和实现的接口  比如是String类型，
    // 那么就会将String类型的父类 String  Serializable  Comparable  CharSequence Object 都会添加在里面
    @Override
    public List<EventType> findMatchEventTypes(EventType type, Object aEvent) {
        Class<?> eventClass = aEvent.getClass();
        List<EventType> result = new LinkedList<EventType>();
        while (eventClass != null) {
            result.add(new EventType(eventClass, type.tag));
            addInterfaces(result, eventClass, type.tag);
            eventClass = eventClass.getSuperclass();
        }

        return result;
    }

    /**
     * 获取该事件的所有接口类型
     */
    private void addInterfaces(List<EventType> eventTypes, Class<?> eventClass, String tag) {
        if (eventClass == null) {
            return;
        }
        Class<?>[] interfacesClasses = eventClass.getInterfaces();
        for (Class<?> interfaceClass : interfacesClasses) {
            if (!eventTypes.contains(interfaceClass)) {
                eventTypes.add(new EventType(interfaceClass, tag));
                addInterfaces(eventTypes, interfaceClass, tag);
            }
        }
    }

}
