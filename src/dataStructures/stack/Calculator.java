package dataStructures.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "31+2*6-8/2+5";
        ArrayStack2 numStuck = new ArrayStack2(10);
        ArrayStack2 operStuck = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        //check expression
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStuck.isOper(ch)) {
                if (!operStuck.isEmpty()) {
                    if (operStuck.priority(ch) <= operStuck.priority(operStuck.peek())) {
                        num1 = numStuck.pop();
                        num2 = numStuck.pop();
                        oper = operStuck.pop();
                        res = numStuck.cal(num1, num2, oper);
                        numStuck.push(res);
                        operStuck.push(ch);
                    } else {
                        operStuck.push(ch);
                    }
                } else {
                    operStuck.push(ch);
                }
            } else {
//                numStuck.push( ch - 48);//char => int
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStuck.push(Integer.parseInt(keepNum));
                } else {
                    if (operStuck.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStuck.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //
        while (true) {
            if (operStuck.isEmpty()) {
                break;
            } else {
                num1 = numStuck.pop();
                num2 = numStuck.pop();
                oper = operStuck.pop();
                res = numStuck.cal(num1, num2, oper);
                numStuck.push(res);

            }
        }
        System.out.printf("expression : %s = %d", expression, res);

    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int topIndex = -1; //游标

    protected ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    protected boolean isFull() {
        return topIndex == (this.maxSize - 1);
    }

    protected boolean isEmpty() {
        return topIndex == -1;
    }

    protected void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            topIndex++;
            stack[topIndex] = value;
        }
    }

    protected int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            int result = stack[topIndex];
            topIndex--;
            return result;
        }
    }

    protected int peek() {
        return this.stack[topIndex];
    }

    protected void list() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        } else {
            for (int i = topIndex; i >= 0; i--) {
                System.out.printf("stack[%d] = %d\n", i, stack[i]);
            }
        }
    }

    protected int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    protected boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    protected int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
