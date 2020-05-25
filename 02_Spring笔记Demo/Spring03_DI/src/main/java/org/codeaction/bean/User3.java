package org.codeaction.bean;

import java.util.*;

public class User3 {
    private String[] hobbies1;
    private List<String> hobbies2;
    private Set<String> hobbies3;
    private Map<String, String> idInfo1;
    private Properties idInfo2;

    public void setHobbies1(String[] hobbies1) {
        this.hobbies1 = hobbies1;
    }

    public void setHobbies2(List<String> hobbies2) {
        this.hobbies2 = hobbies2;
    }

    public void setHobbies3(Set<String> hobbies3) {
        this.hobbies3 = hobbies3;
    }

    public void setIdInfo1(Map<String, String> idInfo1) {
        this.idInfo1 = idInfo1;
    }

    public void setIdInfo2(Properties idInfo2) {
        this.idInfo2 = idInfo2;
    }

    public void show() {
        System.out.println("array----" + Arrays.toString(hobbies1));
        System.out.println("list----" + hobbies2);
        System.out.println("set----" + hobbies3);
        System.out.println("map----" + idInfo1);
        System.out.println("properties----" + idInfo2);
    }
}
