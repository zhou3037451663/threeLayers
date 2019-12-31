package org.student.entity;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public class Student {
    private String sno;//学号
    private String sname;//姓名
    private int sage;//年龄
    private String saddress;//住址

    public Student() {
    }

    public Student(String sname, int sage, String saddress) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public Student(String sno, String sname, int sage, String saddress) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
