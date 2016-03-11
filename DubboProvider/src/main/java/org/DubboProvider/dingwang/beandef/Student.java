package org.DubboProvider.dingwang.beandef;

/**
 * 类Student.java的实现描述：TODO 类实现描述
 * 
 * @author wangding_91@163.com 2016年3月11日 上午11:05:59
 */
public class Student {

    private int    age;

    private String name;

    public void selfDescription() {
        System.out.println("my name is " + name + " and my age is " + age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
