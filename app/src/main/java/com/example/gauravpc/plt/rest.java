package com.example.gauravpc.plt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.SoftReference;

public class rest extends AppCompatActivity {

    TextView threeaddress,quadruple,triple,indirecttriple,code,gCode;
    Button back;
    static String mainq="";
    static String maint="";
    static String mainit="";
    String g="";
    private static final int[] hashMemory=new int[100];

    public static void indirectTripleHashMemory(){
        int k=0;
        for(int i=0;i<100;i++){
            hashMemory[i]=(k+101);
            k++;
        }
    }

    private static final char[][] precedence = {
            {'/', '1'},
            {'*', '1'},
            {'+', '2'},
            {'-', '2'},
//			{'=', '3'}
    };
    private static int precedenceOf(String t)
    {
        char token = t.charAt(0);
        for (int i=0; i < precedence.length; i++)
        {
            if (token == precedence[i][0])
            {
                return Integer.parseInt(precedence[i][1]+"");
            }
        }
        return -1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);



        threeaddress=(TextView)findViewById(R.id.threeAddressCode);
        quadruple=(TextView)findViewById(R.id.qudrapleCode);
        triple=(TextView)findViewById(R.id.tripleCode);
        indirecttriple=(TextView)findViewById(R.id.indirectTripleCode);

       code=(TextView)findViewById(R.id.code);
        code.setText("import java.io.*;\n" +
                "import java.util.*;\n" +
                "\n" +
                "public class plt1 {\n" +
                "\t\n" +
                "\tstatic String mainq=\"\";\n" +
                "\tstatic String maint=\"\";\n" +
                "\tstatic String mainit=\"\";\n" +
                "\n" +
                "\tprivate static final char[][] precedence = {\n" +
                "\t\t\t{'/', '1'},\n" +
                "\t\t\t{'*', '1'},\n" +
                "\t\t\t{'+', '2'},\n" +
                "\t\t\t{'-', '2'},\n" +
                "//\t\t\t{'=', '3'}\n" +
                "\t\t};\n" +
                "\tprivate static final int[] hashMemory=new int[100];\n" +
                "\t\n" +
                "\tpublic static void indirectTripleHashMemory(){\n" +
                "\t\tint k=0;\n" +
                "\t\tfor(int i=0;i<100;i++){\n" +
                "\t\t\thashMemory[i]=(k+101);\n" +
                "\t\t\tk++;\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\t\n" +
                "\t\tprivate static int precedenceOf(String t)\n" +
                "\t\t{\n" +
                "\t\t\tchar token = t.charAt(0);\n" +
                "\t\t\tfor (int i=0; i < precedence.length; i++)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tif (token == precedence[i][0])\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\treturn Integer.parseInt(precedence[i][1]+\"\");\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t\treturn -1;\n" +
                "\t\t}\n" +
                "\n" +
                "\tpublic static void main(String[] args) throws Exception {\n" +
                "\t\t// TODO Auto-generated method stub\n" +
                "\t\t\n" +
                "\t\tindirectTripleHashMemory();\n" +
                "\t\tint i, j, opc=0;\n" +
                "\t\tchar token;\n" +
                "\t\tboolean processed[];\n" +
                "\t\tString[][] operators = new String[10][2];\n" +
                "\t\tString expr=\"\", temp;\n" +
                "\t\tBufferedReader in = new BufferedReader(new InputStreamReader(System.in));\n" +
                "\t\t//Scanner in=new Scanner(System.in);\n" +
                "\t\tSystem.out.print(\"\\nEnter an expression: \");\n" +
                "\t\texpr = in.readLine();\n" +
                "\t\tprocessed = new boolean[expr.length()];\n" +
                "//\t\tSystem.out.println(processed.length);\n" +
                "\t\tfor (i=0; i < processed.length; i++)\n" +
                "\t\t{\n" +
                "\t\t\tprocessed[i] = false;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\t//Location tracker\n" +
                "\t\tfor (i=0; i < expr.length(); i++)\n" +
                "\t\t{\n" +
                "\t\t\ttoken = expr.charAt(i);\n" +
                "\t\t\tfor (j=0; j < precedence.length; j++)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tif (token==precedence[j][0])\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\toperators[opc][0] = token+\"\";\n" +
                "\t\t\t\t\toperators[opc][1] = i+\"\";\n" +
                "\t\t\t\t\topc++;\n" +
                "\t\t\t\t\tbreak;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\tSystem.out.println(\"\\nOperators:\\nOperator\\tLocation\");\n" +
                "\t\tfor (i=0; i < opc; i++)\n" +
                "\t\t{\n" +
                "\t\t\tSystem.out.println(operators[i][0] + \"\\t\\t\" + operators[i][1]);\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\t//sorting based on precedence\n" +
                "\t\t//opc=total number of operators\n" +
                "\t\tfor (i=opc-1; i >= 0; i--)\n" +
                "\t\t{\n" +
                "\t\t\tfor (j=0; j < i; j++)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tif (precedenceOf(operators[j][0]) > precedenceOf(operators[j+1][0]))\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t//swapping the operator\n" +
                "\t\t\t\t\ttemp = operators[j][0];\n" +
                "\t\t\t\t\toperators[j][0] = operators[j+1][0];\n" +
                "\t\t\t\t\toperators[j+1][0] = temp;\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t//swaping the location\n" +
                "\t\t\t\t\ttemp = operators[j][1];\n" +
                "\t\t\t\t\toperators[j][1] = operators[j+1][1];\n" +
                "\t\t\t\t\toperators[j+1][1] = temp;\n" +
                "\t\t\t\t}\t\t\t\t\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tSystem.out.println(\"\\nOperators sorted in their precedence:\\nOperator\\tLocation\");\n" +
                "\t\tfor (i=0; i < opc; i++)\n" +
                "\t\t{\n" +
                "\t\t\tSystem.out.println(operators[i][0] + \"\\t\\t\" + operators[i][1]);\n" +
                "\t\t}\n" +
                "\t\tSystem.out.println();\n" +
                "\t\tString answer=\"\",a=\"\";\n" +
                "\t\tfor (i=0; i < opc; i++)\n" +
                "\t\t{\n" +
                "\t\t\tj = Integer.parseInt(operators[i][1]+\"\");\n" +
                "\t\t\t//System.out.println(j);\n" +
                "\t\t\tString op1=\"\", op2=\"\";\n" +
                "\t\t\tif (processed[j-1]==true)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tif (precedenceOf(operators[i-1][0]) == precedenceOf(operators[i][0]))\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t//System.out.println(\"con1 true\");\n" +
                "\t\t\t\t\top1 = \"t\"+i;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\telse\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t//System.out.println(\"con2 true\");\n" +
                "\t\t\t\t\tfor (int x=0; x < opc; x++)\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\tif ((j-2) == Integer.parseInt(operators[x][1]))\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\top1 = \"t\"+(x+1)+\"\";\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t\telse\n" +
                "\t\t\t{\n" +
                "\t\t\t\top1 = expr.charAt(j-1)+\"\";\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\tif (processed[j+1]==true)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tfor (int x=0; x < opc; x++)\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\tif ((j+2) == Integer.parseInt(operators[x][1]))\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\top2 = \"t\"+(x+1)+\"\";\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t\telse\n" +
                "\t\t\t{\n" +
                "\t\t\t\top2 = expr.charAt(j+1)+\"\";\n" +
                "\t\t\t}\n" +
                "\t\t\t//System.out.println(\"t\"+(i+1)+\" = \"+op1+operators[i][0]+op2);\n" +
                "\t\t\tanswer=\"t\"+(i+1)+\" = \"+op1+operators[i][0]+op2+\"\";\n" +
                "\t\t\ta+=answer+\"\\n\";\n" +
                "\t\t\tquadruple(answer);\n" +
                "//\t\t\tSystem.out.println(answer);\n" +
                "\t\t\tprocessed[j] = processed[j-1] = processed[j+1] = true;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "//\t\tquadruple(a);\n" +
                "\t\t\n" +
                "\t\tSystem.out.println();\n" +
                "\t\tSystem.out.println(\"3-Address Code : \\n\");\n" +
                "\t\tSystem.out.println(a);\n" +
                "\t\tSystem.out.println();\n" +
                "\t\tSystem.out.println(\"Quadruple : \\n\");\n" +
                "\t\tSystem.out.println(mainq);\n" +
                "\t\tSystem.out.println();\n" +
                "\t\tSystem.out.println(\"Triple : \\n\");\n" +
                "\t\tSystem.out.println(maint);\n" +
                "\t\tSystem.out.println();\n" +
                "\t\tSystem.out.println(\"Indirect Triple : \\n\");\n" +
                "\t\tSystem.out.println(mainit);\n" +
                "\n" +
                "\t}\n" +
                "\tpublic static void quadruple(String a){\n" +
                "\t\t\n" +
                "\t\n" +
                "//\t\tfor(int i=0;i<c.length;i++){\n" +
                "//\t\t\tSystem.out.print(c[i]);\n" +
                "//\t\t}\n" +
                "\t\t\n" +
                "\t\tchar[] c=a.toCharArray();\n" +
                "\t\tString[][] val=new String[20][20];\n" +
                "\t\n" +
                "\t\t\t\n" +
                "\t\t\tif(String.valueOf(c[6]).equals(\"+\")\n" +
                "\t\t\t\t|| String.valueOf(c[6]).equals(\"-\")\n" +
                "\t\t\t\t||String.valueOf(c[6]).equals(\"*\")\n" +
                "\t\t\t\t||String.valueOf(c[6]).equals(\"/\")){\n" +
                "\t\t\t\t\n" +
                "\t\t\t\tval[0][0]=String.valueOf(c[6]);\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\tval[0][0]=String.valueOf(c[7]);\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\tif(String.valueOf(c[5]).equals(\"t\")){\n" +
                "\t\t\t\tval[0][1]=String.valueOf(c[5])+String.valueOf(c[6]);\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\tval[0][1]=String.valueOf(c[5]);\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\tif(String.valueOf(c[7]).equals(\"+\")\n" +
                "\t\t\t\t\t|| String.valueOf(c[7]).equals(\"-\")\n" +
                "\t\t\t\t\t||String.valueOf(c[7]).equals(\"*\")\n" +
                "\t\t\t\t\t||String.valueOf(c[7]).equals(\"/\")){\n" +
                "\t\t\t\t\n" +
                "\t\t\t\tif(String.valueOf(c[8]).equals(\"t\")){\n" +
                "\t\t\t\t\tval[0][2]=String.valueOf(c[8])+String.valueOf(c[9]);\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\telse{\n" +
                "\t\t\t\t\tval[0][2]=String.valueOf(c[8]);\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\tval[0][2]=String.valueOf(c[7]);\n" +
                "\t\t\t}\n" +
                "\t\t\tval[0][3]=String.valueOf(c[0])+String.valueOf(c[1]);\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\tmainq+=val[0][0]+\"    \"+val[0][1]+\"   \"+val[0][2]+\"   \"+val[0][3]+\"\\n\";\n" +
                "\t\tString value=val[0][0]+\"\"+val[0][1]+\"\"+val[0][2]+\"\"+val[0][3];\n" +
                "//\t\tSystem.out.println(value);\n" +
                "\t\ttriple(value);\n" +
                "\t}\n" +
                "\tpublic static void triple(String a){\n" +
                "//\t\tSystem.out.println(a);\n" +
                "\t\tchar[] c=a.toCharArray();\n" +
                "\t\tString[][] triple=new String[20][20];\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\ttriple[0][0]=String.valueOf(c[0]);\n" +
                "\t\t\t\n" +
                "\t\t\tif(String.valueOf(c[1]).equals(\"t\")){\n" +
                "\t\t\t\tString temp=String.valueOf(c[2]);\n" +
                "\t\t\t\ttriple[0][1]=\"\"+(Integer.parseInt(temp)-1);\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\ttriple[0][1]=String.valueOf(c[1]);\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\tif(String.valueOf(c[1]).equals(\"t\")){\n" +
                "\t\t\t\t\n" +
                "\t\t\t\tif(String.valueOf(c[3]).equals(\"t\")){\n" +
                "\t\t\t\t\tString temp=String.valueOf(c[4]);\n" +
                "\t\t\t\t\ttriple[0][2]=\"\"+(Integer.parseInt(temp)-1);\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\telse{\n" +
                "\t\t\t\t\ttriple[0][2]=String.valueOf(c[3]);\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\ttriple[0][2]=String.valueOf(c[2]);\n" +
                "\t\t\t}\n" +
                "\t\tmaint+=triple[0][0]+\"   \"+triple[0][1]+\"   \"+triple[0][2]+\"\\n\";\n" +
                "\t\tString value=triple[0][0]+\"\"+triple[0][1]+\"\"+triple[0][2];\n" +
                "\t\tindirectTriple(value);\n" +
                "\t}\n" +
                "\tpublic static void indirectTriple(String a){\n" +
                "\t\tchar[] c=a.toCharArray();\n" +
                "\t\tString val=\"\";\n" +
                "\t\tfor(int i=0;i<c.length;i++){\n" +
                "\t\t\tif(Character.isDigit(c[i])){\n" +
                "\t\t\t\tval+=\"(\"+hashMemory[Integer.parseInt(String.valueOf(c[i]))]+\")  \";\n" +
                "\t\t\t}\n" +
                "\t\t\telse{\n" +
                "\t\t\t\t\tval+=String.valueOf(c[i])+\"      \";\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\tmainit+=val+\"\\n\";\n" +
                "//\t\tSystem.out.println(val);\n" +
                "\t}\n" +
                "//\t*abt1\n" +
                "//\t/t1ct2\n" +
                "//\t*eft3\n" +
                "//\t+t2dt4\n" +
                "//\t-t4t3t5\t\n" +
                "\n" +
                "//\ta*b/c+d-e*f\n" +
                "}");
        back=(Button)findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(rest.this,a1.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String expr = intent.getStringExtra(a1.INP);

        indirectTripleHashMemory();
        int len = expr.length();
        int i, j, opc=0;
        char token;
        boolean processed[];
        String temp;
        String[][] operators = new String[10][2];
        processed = new boolean[expr.length()];

        for (i=0; i < processed.length; i++)
        {
            processed[i] = false;
        }


        //Location tracker
        for (i=0; i < expr.length(); i++)
        {
            token = expr.charAt(i);
            for (j=0; j < precedence.length; j++)
            {
                if (token==precedence[j][0])
                {
                    operators[opc][0] = token+"";
                    operators[opc][1] = i+"";
                    opc++;
                    break;
                }
            }
        }
		System.out.println("\nOperators:\nOperator\tLocation");
        g+="\nOperator\t\t\t\tLocation\n";
		for (i=0; i < opc; i++)
		{
//			System.out.println(operators[i][0] + "\t\t" + operators[i][1]);
            g+=operators[i][0] + "\t\t\t\t\t\t\t\t\t\t\t" + operators[i][1]+"\n";
		}
        gCode=(TextView)findViewById(R.id.gcode);
        gCode.setText(g);

        //sorting based on precedence
        //opc=total number of operators
        for (i=opc-1; i >= 0; i--)
        {
            for (j=0; j < i; j++)
            {
                if (precedenceOf(operators[j][0]) > precedenceOf(operators[j+1][0]))
                {
                    //swapping the operator
                    temp = operators[j][0];
                    operators[j][0] = operators[j+1][0];
                    operators[j+1][0] = temp;

                    //swaping the location
                    temp = operators[j][1];
                    operators[j][1] = operators[j+1][1];
                    operators[j+1][1] = temp;
                }
            }
        }
        //		System.out.println("\nOperators sorted in their precedence:\nOperator\tLocation");
//		for (i=0; i < opc; i++)
//		{
//			System.out.println(operators[i][0] + "\t\t" + operators[i][1]);
//		}
        String answer="",a="";
        for (i=0; i < opc; i++)
        {
            j = Integer.parseInt(operators[i][1]+"");
            //System.out.println(j);
            String op1="", op2="";
            if (processed[j-1]==true)
            {
                if (precedenceOf(operators[i-1][0]) == precedenceOf(operators[i][0]))
                {
                    //System.out.println("con1 true");
                    op1 = "t"+i;
                }
                else
                {
                    //System.out.println("con2 true");
                    for (int x=0; x < opc; x++)
                    {
                        if ((j-2) == Integer.parseInt(operators[x][1]))
                        {
                            op1 = "t"+(x+1)+"";
                        }
                    }
                }
            }
            else
            {
                op1 = expr.charAt(j-1)+"";
            }

            if (processed[j+1]==true)
            {
                for (int x=0; x < opc; x++)
                {
                    if ((j+2) == Integer.parseInt(operators[x][1]))
                    {
                        op2 = "t"+(x+1)+"";
                    }
                }
            }
            else
            {
                op2 = expr.charAt(j+1)+"";
            }
            //System.out.println("t"+(i+1)+" = "+op1+operators[i][0]+op2);
            answer="t"+(i+1)+" = "+op1+operators[i][0]+op2+"";
            a+=answer+"\n";
            quadruple(answer);
//			System.out.println(answer);
            processed[j] = processed[j-1] = processed[j+1] = true;
        }
        threeaddress.setText(a);
        quadruple.setText(mainq);
        triple.setText(maint);
        indirecttriple.setText(mainit);
    }

    public static void quadruple(String a){


//		for(int i=0;i<c.length;i++){
//			System.out.print(c[i]);
//		}

        char[] c=a.toCharArray();
        String[][] val=new String[20][20];


        if(String.valueOf(c[6]).equals("+")
                || String.valueOf(c[6]).equals("-")
                ||String.valueOf(c[6]).equals("*")
                ||String.valueOf(c[6]).equals("/")){

            val[0][0]=String.valueOf(c[6]);
        }
        else{
            val[0][0]=String.valueOf(c[7]);
        }

        if(String.valueOf(c[5]).equals("t")){
            val[0][1]=String.valueOf(c[5])+String.valueOf(c[6]);
        }
        else{
            val[0][1]=String.valueOf(c[5]);
        }

        if(String.valueOf(c[7]).equals("+")
                || String.valueOf(c[7]).equals("-")
                ||String.valueOf(c[7]).equals("*")
                ||String.valueOf(c[7]).equals("/")){

            if(String.valueOf(c[8]).equals("t")){
                val[0][2]=String.valueOf(c[8])+String.valueOf(c[9]);
            }
            else{
                val[0][2]=String.valueOf(c[8]);
            }
        }
        else{
            val[0][2]=String.valueOf(c[7]);
        }
        val[0][3]=String.valueOf(c[0])+String.valueOf(c[1]);


        mainq+=val[0][0]+"       "+val[0][1]+"      "+val[0][2]+"      "+val[0][3]+"\n";
        String value=val[0][0]+""+val[0][1]+""+val[0][2]+""+val[0][3];
//		System.out.println(value);
        triple(value);
    }
    public static void triple(String a){
//		System.out.println(a);
        char[] c=a.toCharArray();
        String[][] triple=new String[20][20];


        triple[0][0]=String.valueOf(c[0]);

        if(String.valueOf(c[1]).equals("t")){
            String temp=String.valueOf(c[2]);
            triple[0][1]=""+(Integer.parseInt(temp)-1);
        }
        else{
            triple[0][1]=String.valueOf(c[1]);
        }


        if(String.valueOf(c[1]).equals("t")){

            if(String.valueOf(c[3]).equals("t")){
                String temp=String.valueOf(c[4]);
                triple[0][2]=""+(Integer.parseInt(temp)-1);
            }
            else{
                triple[0][2]=String.valueOf(c[3]);
            }

        }
        else{
            triple[0][2]=String.valueOf(c[2]);
        }
        maint+=triple[0][0]+"       "+triple[0][1]+"       "+triple[0][2]+"\n";
        String value=triple[0][0]+""+triple[0][1]+""+triple[0][2];
        indirectTriple(value);
    }
    public static void indirectTriple(String a){
        char[] c=a.toCharArray();
        String val="";
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i])){
                val+="("+hashMemory[Integer.parseInt(String.valueOf(c[i]))]+")       ";
            }
            else{
                val+=String.valueOf(c[i])+"           ";
            }
        }
        mainit+=val+"\n";
//		System.out.println(val);
    }

}