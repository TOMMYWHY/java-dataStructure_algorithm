package dataStructures.hashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:a");
            System.out.println("list:l");
            System.out.println("delete:d");
            System.out.println("find:f");
            System.out.println("exit:e");

            key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("input id:");
                    int id = scanner.nextInt();
                    System.out.println("input name:");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "l":
                    hashTable.list();
                    break;
                case "f":
                    System.out.println("input id:");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "e":
                    scanner.close();
                    System.exit(0);
            }
        }

    }

}

class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Employee emp) {
        int empLinkedListNo = hashFun(emp.id);
        this.empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Employee employee = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (employee != null) {
            System.out.println("location: list" + empLinkedListNo + " id = " + id);
        } else {
            System.out.println("cannot find it");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Employee head;

    public void add(Employee emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Employee curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int listNo) {
        if (this.head == null) {
            System.out.println("listNo:" + listNo + " ; list is empty");
            return;
        }
        System.out.print("listNo:" + listNo + " list: ");
        Employee curEmp = head;
        while (true) {
            System.out.printf("=>id = %d name= %s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Employee findEmpById(int id) {
        if (head == null) {
            System.out.println("list is empty");
            return null;
        }
        Employee curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
