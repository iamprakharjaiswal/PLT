package com.example.gauravpc.plt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class SyntaxTree extends AppCompatActivity {
    char[] input;
    char[] s;
    char[] temp;
    int top=-1;
    static TextView syntaxTreeText;
    TextView code;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syntax_tree);

        Intent i = getIntent();
        String input1 = i.getStringExtra(a1.INP);

//        syntaxTreeText=(TextView)findViewById(R.id.syntaxTreeText);
//        syntaxTreeText.setText("Tree printed in LogCat in Android Studio!");

        syntaxTreeText=(TextView)findViewById(R.id.syntaxTreeText);

        code=(TextView)findViewById(R.id.code);
        code.setText("import java.util.ArrayList;\n" +
                "import java.util.Collections;\n" +
                "import java.util.List;\n" +
                "import java.util.Stack;\n" +
                "\n" +
                "public class plt2 {\n" +
                "\t\n" +
                "\tstatic boolean isOperator(char c) {\n" +
                "        if (c == '+' || c == '-'\n" +
                "                || c == '*' || c == '/'\n" +
                "                || c == '^') {\n" +
                "            return true;\n" +
                "        }\n" +
                "        return false;\n" +
                "    }\n" +
                "\t\n" +
                "\tprivate static Node<String> test1(char postfix[]) {\n" +
                "\t\t\n" +
                "\t\tStack<Node<String>>s=new Stack<Node<String>>();\n" +
                "\t\tNode<String> t,t1,t2;\n" +
                "\t\t\n" +
                "\t\tfor(int i=0;i<postfix.length;i++){\n" +
                "\t\t\t\n" +
                "\t\t\t if (!isOperator(postfix[i])) {\n" +
                "\t                t = new Node<String>(String.valueOf(postfix[i]));\n" +
                "\t                s.push(t);\n" +
                "\t         }\n" +
                "\t\t\t else{\n" +
                "\t\t\t\t t = new Node<String>(String.valueOf(postfix[i]));\n" +
                "\t\t\t\t \n" +
                "\t                // Pop two top nodes\n" +
                "\t                // Store top\n" +
                "\t                t1 = s.pop();      // Remove top\n" +
                "\t                t2 = s.pop();\n" +
                "\t \n" +
                "\t                //  make them children\n" +
                "\t                t.right = t1;\n" +
                "\t                t.left = t2;\n" +
                "\t \n" +
                "\t                // System.out.println(t1 + \"\" + t2);\n" +
                "\t                // Add this subexpression to stack\n" +
                "\t                s.push(t);\n" +
                "\t\t\t }\n" +
                "\t\t}\n" +
                "\t\tt = s.peek();\n" +
                "\t     s.pop();\n" +
                "\t\treturn t;\n" +
                "    }\n" +
                "\n" +
                "   \n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\t// TODO Auto-generated method stub\n" +
                "\t\tString postfix = \"ab*c/d+ef*-\";\n" +
                "        char[] charArray = postfix.toCharArray();\n" +
                "\t\tNode<String> root=plt2.test1(charArray);\n" +
                "        BTreePrinter.printNode(root);\n" +
                "\t}\n" +
                "\n" +
                "}\n" +
                "\n" +
                "class Node<T extends Comparable<?>> {\n" +
                "    Node<T> left, right;\n" +
                "    T data;\n" +
                "\n" +
                "    \n" +
                "    public Node(T data) {\n" +
                "        this.data = data;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class BTreePrinter {\n" +
                "\n" +
                "    public static <T extends Comparable<?>> void printNode(Node<T> root) {\n" +
                "        int maxLevel = BTreePrinter.maxLevel(root);\n" +
                "\n" +
                "        printNodeInternal(Collections.singletonList(root), 1, maxLevel);\n" +
                "    }\n" +
                "\n" +
                "    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {\n" +
                "        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))\n" +
                "            return;\n" +
                "\n" +
                "        int floor = maxLevel - level;\n" +
                "        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));\n" +
                "        int firstSpaces = (int) Math.pow(2, (floor)) - 1;\n" +
                "        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;\n" +
                "\n" +
                "        BTreePrinter.printWhitespaces(firstSpaces);\n" +
                "\n" +
                "        List<Node<T>> newNodes = new ArrayList<Node<T>>();\n" +
                "        for (Node<T> node : nodes) {\n" +
                "            if (node != null) {\n" +
                "                System.out.print(node.data);\n" +
                "                newNodes.add(node.left);\n" +
                "                newNodes.add(node.right);\n" +
                "            } else {\n" +
                "                newNodes.add(null);\n" +
                "                newNodes.add(null);\n" +
                "                System.out.print(\" \");\n" +
                "            }\n" +
                "\n" +
                "            BTreePrinter.printWhitespaces(betweenSpaces);\n" +
                "        }\n" +
                "        System.out.println(\"\");\n" +
                "\n" +
                "        for (int i = 1; i <= endgeLines; i++) {\n" +
                "            for (int j = 0; j < nodes.size(); j++) {\n" +
                "                BTreePrinter.printWhitespaces(firstSpaces - i);\n" +
                "                if (nodes.get(j) == null) {\n" +
                "                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);\n" +
                "                    continue;\n" +
                "                }\n" +
                "\n" +
                "                if (nodes.get(j).left != null){\n" +
                "                \tSystem.out.print(\"/\");\n" +
                "                }\n" +
                "                else\n" +
                "                    BTreePrinter.printWhitespaces(1);\n" +
                "\n" +
                "                BTreePrinter.printWhitespaces(i + i - 1);\n" +
                "\n" +
                "                if (nodes.get(j).right != null){\n" +
                "                \tSystem.out.print(\"\\\\\");\n" +
                "                }\n" +
                "                    \n" +
                "                else\n" +
                "                    BTreePrinter.printWhitespaces(1);\n" +
                "\n" +
                "                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);\n" +
                "            }\n" +
                "\n" +
                "            System.out.println(\"\");\n" +
                "        }\n" +
                "\n" +
                "        printNodeInternal(newNodes, level + 1, maxLevel);\n" +
                "    }\n" +
                "\n" +
                "    private static void printWhitespaces(int count) {\n" +
                "        for (int i = 0; i < count; i++){\n" +
                "        \t   System.out.print(\" \");\n" +
                "        }\n" +
                "         \n" +
                "    }\n" +
                "\n" +
                "    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {\n" +
                "        if (node == null)\n" +
                "            return 0;\n" +
                "\n" +
                "        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;\n" +
                "    }\n" +
                "\n" +
                "    private static <T> boolean isAllElementsNull(List<T> list) {\n" +
                "        for (Object object : list) {\n" +
                "            if (object != null)\n" +
                "                return false;\n" +
                "        }\n" +
                "\n" +
                "        return true;\n" +
                "    }\n" +
                "\n" +
                "}");

        button=(Button)findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SyntaxTree.this,a1.class);
                startActivity(intent);

            }
        });
        int len = input1.length();
        input = new char[100];
        s= new char[100];
        temp = new char[len];

        input = input1.toCharArray();

        push('#');
        char c,x;
        int l=0,k=0;
        while(l<len)
        {c=input[l++];
            if(c=='(')
                push(c);
            else if(alphanum(c))
                temp[k++]=c;
            else if(c==')')
            {
                while(s[top]!='(')
                    temp[k++]=pop();
                x=pop();
            }
            else
            {
                while(precede(s[top])>=precede(c))
                    temp[k++]=pop();
                push(c);
            }
        }
        while(s[top]!='#')
            temp[k++]=pop();

        Log.e("values",temp.toString());
        char[] charArray = temp;
        Node<String> root=SyntaxTree.test1(charArray);
        syntaxTreeText.setText("");
        BTreePrinter.printNode(root);

    }
    static boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    private static Node<String> test1(char postfix[]) {

        Stack<Node<String>>s=new Stack<Node<String>>();
        Node<String> t,t1,t2;

        for(int i=0;i<postfix.length;i++){

            if (!isOperator(postfix[i])) {
                t = new Node<String>(String.valueOf(postfix[i]));
                s.push(t);
            }
            else{
                t = new Node<String>(String.valueOf(postfix[i]));

                // Pop two top nodes
                // Store top
                t1 = s.pop();      // Remove top
                t2 = s.pop();

                //  make them children
                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                s.push(t);
            }
        }
        t = s.peek();
        s.pop();
        return t;
    }
    void push(char c)
    {
        s[++top]=c;
    }
    char pop()
    {
        return s[top--];
    }
    int precede( char c)
    {
        switch(c)
        {
            case '#':return 0;
            case '(': return 1;
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 3;
        }
        return 0;
    }
    boolean alphanum(char c)
    {
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
            return true;
        return false;
    }
    static class Node<T extends Comparable<?>> {
        Node<T> left, right;
        T data;


        public Node(T data) {
            this.data = data;
        }
    }

    static class BTreePrinter {

        private static String tree="";


        public static <T extends Comparable<?>> void printNode(Node<T> root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
            Log.e("tree", tree);

//            Intent intent=new Intent(SyntaxTree.this,tree.class);
            syntaxTreeText.setText(tree);


        }

        private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<Node<T>> newNodes = new ArrayList<Node<T>>();
            for (Node<T> node : nodes) {
                if (node != null) {
                    tree+=node.data;
                    System.out.print(node.data);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    tree+=" ";
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            tree+="\n";
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null){
                        tree+="/";
                        System.out.print("/");
                    }
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null){
                        tree+="\\";
                        System.out.print("\\");
                    }

                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }
                tree+="\n";
                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++){
                tree+=" ";
                System.out.print(" ");
            }

        }

        private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }

}

