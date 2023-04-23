package org.example.task;

public class Employee {
  private int eno;
  private String ename;
  private int esal;
  private String eaddr;

  public int getEno() {
    return eno;
  }

  public void setEno(int eno) {
    this.eno = eno;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public int getEsal() {
    return esal;
  }

  public void setEsal(int esal) {
    this.esal = esal;
  }

  public String getEaddr() {
    return eaddr;
  }

  public void setEaddr(String eaddr) {
    this.eaddr = eaddr;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "eno=" + eno +
            ", ename='" + ename + '\'' +
            ", esal=" + esal +
            ", eaddr='" + eaddr + '\'' +
            '}';
  }
}
