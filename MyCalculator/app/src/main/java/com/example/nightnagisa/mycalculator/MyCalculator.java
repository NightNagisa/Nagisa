package com.example.nightnagisa.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MyCalculator extends Activity {

    private EditText edit;
    private TextView result,showM;
    private Button[] number;
    private Button[] commandCompute;
    private Button btnPoint;
    private Button btnCE,btnC,btnBackspace,btnSign,btnSqrt,btnReciprocal;
    private Button btnMC,btnMR,btnMS,btnM;
    private double resultContinues;//判定是否进行连加连减等操作
    private boolean flagCommand;//判定运算符的连续输入并发出错误提示
    private boolean flagReciprocal;
    private boolean flagMemory=false;
    private double Memory;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);
        //实例化编辑框和结果显示框
        edit = (EditText) findViewById(R.id.edtTxtEdit);
        edit.setInputType(InputType.TYPE_NULL);
        result = (TextView) findViewById(R.id.txtResult);
        showM = (TextView) findViewById(R.id.showM);
        //实例化按钮
        number = new Button[10];
        number[0] = (Button) findViewById(R.id.btn_num0);
        number[1] = (Button) findViewById(R.id.btn_num1);
        number[2] = (Button) findViewById(R.id.btn_num2);
        number[3] = (Button) findViewById(R.id.btn_num3);
        number[4] = (Button) findViewById(R.id.btn_num4);
        number[5] = (Button) findViewById(R.id.btn_num5);
        number[6] = (Button) findViewById(R.id.btn_num6);
        number[7] = (Button) findViewById(R.id.btn_num7);
        number[8] = (Button) findViewById(R.id.btn_num8);
        number[9] = (Button) findViewById(R.id.btn_num9);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        commandCompute = new Button[5];
        commandCompute[0] = (Button) findViewById(R.id.btnEqu);
        commandCompute[1] = (Button) findViewById(R.id.btnAdd);
        commandCompute[2] = (Button) findViewById(R.id.btnSub);
        commandCompute[3] = (Button) findViewById(R.id.btnMul);
        commandCompute[4] = (Button) findViewById(R.id.btnDiv);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnC = (Button) findViewById(R.id.btnC);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnReciprocal = (Button) findViewById(R.id.btnReciprocal);
        btnMC = (Button) findViewById(R.id.btnMC);
        btnMR = (Button) findViewById(R.id.btnMR);
        btnMS = (Button) findViewById(R.id.btnMS);
        btnM = (Button) findViewById(R.id.btnM);
        //小数点的监听器事件
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                String input = edit.getText().toString();
                boolean flagPoint = false;//判定存在多个小数点的处理方式
                flagCommand = false;
                for (int search = input.length() - 1; search >= 0; search--) {
                    flagPoint = true;
                    for (int num = 0; num < 10; num++) {
                        if (String.valueOf(input.charAt(search)).equals(String.valueOf(num))) {
                            flagPoint = false;
                            break;
                        }
                    }
                    if (flagPoint) {
                        if (input.charAt(search) == '.') {
                            result.setText("" + search);
                            break;
                        } else {
                            flagPoint = false;
                            break;
                        }
                    }
                }
                //若正输入的数字已包含小数点则发出错误提示
                if (flagPoint) {
                    Toast.makeText(MyCalculator.this, "Can't use one more point", Toast.LENGTH_SHORT).show();
                } else {
                    //直接输入小数点时默认整数部分为0
                    if (input.equals("") || input.charAt(input.length() - 1) == '+' || input.charAt(input.length() - 1) == '-' || input.charAt(input.length() - 1) == '*' || input.charAt(input.length() - 1) == '/') {
                        edit.setText(input + "0.");
                    } else {
                        edit.setText(input + btnPoint.getText().toString());
                    }
                }
                flagPoint = true;
                flagReciprocal = false;
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        //0-9的监听器事件，均包含一段用于消除连续输入运算符flag的代码
        number[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[0].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[1].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[2].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[3].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[4].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[5].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[6].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[7].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[8].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        number[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagMemory) {
                    edit.setText("");
                    result.setText("");
                    flagMemory = false;
                }
                flagCommand = false;
                flagReciprocal = false;
                String input = edit.getText().toString();
                edit.setText(input + number[9].getText().toString());
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        //“=”的监听器事件，包含除数为零的判定策略以及错误提示
        commandCompute[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edit.getText().toString();
                if (input.equals("")) {

                } else if (Errordivide.errorDivide(input)) {
                    Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                } else {
                    result.setText(Equal.equal(input, resultContinues));
                }
            }
        });
        //运算符的监听器事件，均包含除数为零的判定策略以及错误提示、对连续输入运算符的限制
        commandCompute[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagReciprocal = false;
                if (flagCommand) {
                    Toast.makeText(MyCalculator.this, "Wrong operation", Toast.LENGTH_SHORT).show();
                } else {
                    flagCommand = true;
                    String input = edit.getText().toString();
                    if (input.equals("")) {

                    } else {
                        if (Errordivide.errorDivide(input)) {
                            Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                        } else {
                            if (input.equals("")) {
                                edit.setText("");
                            } else {
                                edit.setText(input + commandCompute[1].getText().toString());
                            }
                        }
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        commandCompute[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagReciprocal = false;
                flagCommand = true;
                String input = edit.getText().toString();
                if (!input.equals("")) {
                    if (Errordivide.errorDivide(input)) {
                        Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        if (input.length() > 1) {
                            if (input.charAt(input.length() - 2) == '+' || input.charAt(input.length() - 2) == '-' || input.charAt(input.length() - 2) == '*' || input.charAt(input.length() - 2) == '/') {
                                if (input.charAt(input.length() - 1) == '-')
                                    Toast.makeText(MyCalculator.this, "Wrong operation", Toast.LENGTH_SHORT).show();
                            } else {
                                edit.setText(input + commandCompute[2].getText().toString());
                            }
                        } else {
                            edit.setText(input + commandCompute[2].getText().toString());
                        }
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        commandCompute[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagReciprocal = false;
                if (flagCommand) {
                    Toast.makeText(MyCalculator.this, "Wrong operation", Toast.LENGTH_SHORT).show();
                } else {
                    flagCommand = true;
                    String input = edit.getText().toString();
                    if (input.equals("")) {

                    } else {
                        if (Errordivide.errorDivide(input)) {
                            Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                        } else {
                            if (input.equals("")) {
                                edit.setText("");
                            } else {
                                edit.setText(input + commandCompute[3].getText().toString());
                            }
                        }
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        commandCompute[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagReciprocal = false;
                if (flagCommand) {
                    Toast.makeText(MyCalculator.this, "Wrong operation", Toast.LENGTH_SHORT).show();
                } else {
                    flagCommand = true;
                    String input = edit.getText().toString();
                    if (input.equals("")) {

                    } else {
                        if (Errordivide.errorDivide(input)) {
                            Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                        } else {
                            if (input.equals("")) {
                                edit.setText("");
                            } else {
                                edit.setText(input + commandCompute[4].getText().toString());
                            }
                        }
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        //CE的监听器事件
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagReciprocal = false;
                boolean flagNum = false;
                String input = edit.getText().toString();
                if (!input.equals("")) {
                    for (int search = input.length() - 1; search >= 0; search--) {
                        for (int number = 0; number < 10; number++) {
                            flagNum = false;
                            if (String.valueOf(input.charAt(search)).equals(String.valueOf(number)) || String.valueOf(input.charAt(search)).equals(String.valueOf('.'))) {
                                flagNum = true;
                                break;
                            }
                        }
                        if (search == 0) {
                            edit.setText("");
                            break;
                        }
                        if (!flagNum) {
                            if (search != input.length() - 1) {
                                if (String.valueOf(input.charAt(search)).equals(String.valueOf('-'))) {
                                    if (input.charAt(search - 1) == '+' || input.charAt(search - 1) == '-' || input.charAt(search - 1) == '*' || input.charAt(search - 1) == '/') {
                                        search--;
                                    }
                                }
                                edit.setText(input.substring(0, search + 1));
                            }
                            break;
                        }
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        //C的监听器事件
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清屏，初始化
                flagCommand = false;
                edit.setText("");
                result.setText("");
                resultContinues = 0;
            }
        });
        //Backspace的监听器事件
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edit.getText().toString();
                if (!input.equals("")) {//计算式不为空，执行退格操作
                    edit.setText(input.substring(0, input.length() - 1));
                    input = edit.getText().toString();//获取进行了退格操作后的计算式，若不为空则从后向前判断是否限制运算符的输入
                    if (input.length() != 0) {
                        if (input.charAt(input.length() - 1) == '+' || input.charAt(input.length() - 1) == '-' || input.charAt(input.length() - 1) == '*' || input.charAt(input.length() - 1) == '/') {
                            flagCommand = true;
                        }
                    } else {//若退格操作后为空，消除对运算符的输入限制
                        flagCommand = false;
                    }
                }
                if (!result.getText().equals("")) {
                    result.setText("");
                }
            }
        });
        //±的监听器事件
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edit.getText().toString();
                boolean flagNum = false;//标记检索处字符是否为数字
                int search;//用于遍历输入字符串
                if (!input.equals("")) {
                    if (result.getText().equals("")) {
                        for (search = input.length() - 1; search >= 0; search--) {
                            flagNum = false;
                            for (int number = 0; number < 10; number++) {
                                if (String.valueOf(input.charAt(search)).equals(String.valueOf(number)) || String.valueOf(input.charAt(search)).equals(String.valueOf('.'))) {
                                    flagNum = true;
                                    break;
                                }
                            }
                            if (flagNum) {//检索处字符为数字，不操作

                            } else if (!flagNum && search == input.length() - 1) {
                                break;
                            } else if (String.valueOf(input.charAt(search)).equals(String.valueOf('-'))) {//检索到当前字符为负/减号，改为正/加号
                                if (search == 0) {
                                    edit.setText(input.substring(search + 1, input.length()));
                                    break;
                                } else if (input.charAt(search - 1) == '+' || input.charAt(search - 1) == '-' || input.charAt(search - 1) == '*' || input.charAt(search - 1) == '/') {
                                    edit.setText(input.substring(0, search) + input.substring(search + 1, input.length()));
                                    break;
                                } else {
                                    edit.setText(input.substring(0, search) + "+" + input.substring(search + 1, input.length()));
                                    break;
                                }
                            } else if (String.valueOf(input.charAt(search)).equals(String.valueOf('+'))) {//检索到当前字符为正/加号，改为负/减号
                                edit.setText(input.substring(0, search) + "-" + input.substring(search + 1, input.length()));
                                break;
                            } else {//检索到当前字符为乘/除号，在其后添加负号
                                edit.setText(input.substring(0, search + 1) + '-' + input.substring(search + 1, input.length()));
                                break;
                            }
                        }
                        if (search == -1) {
                            edit.setText("-" + input);
                        }
                    }
                }
            }
        });
        //Sqrt的监听器事件
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用Equal方法得出计算式的值后进行开方运算并直接显示结果
                String input = edit.getText().toString();
                double sqrt;
                if (input.equals("")) {

                } else if (Errordivide.errorDivide(input)) {
                    Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                } else {
                    if (Double.parseDouble(Equal.equal(input, resultContinues)) < 0) {
                        Toast.makeText(MyCalculator.this, "Wrong operation", Toast.LENGTH_SHORT).show();
                    } else {
                        flagReciprocal = false;
                        sqrt = Math.sqrt(Double.parseDouble(Equal.equal(input, resultContinues)));
                        edit.setText("" + sqrt);
                        result.setText("Sqrt(" + input + ")=" + String.valueOf(sqrt));
                    }
                }
            }
        });
        btnReciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用Equal方法得出计算式的值后进行取倒数运算并直接显示结果
                String input = edit.getText().toString();
                if (flagReciprocal) {
                    edit.setText(result.getText());
                    result.setText(input);
                } else {
                    double reciprocal;
                    if (input.equals("")) {

                    } else if (Errordivide.errorDivide(input) || Double.parseDouble(Equal.equal(input, resultContinues)) == 0) {
                        Toast.makeText(MyCalculator.this, "Can't divide by zero", Toast.LENGTH_SHORT).show();
                    } else {
                        reciprocal = Compute.div(1, Double.parseDouble(Equal.equal(input, resultContinues)));
                        edit.setText("" + Double.parseDouble(Equal.equal(input, resultContinues)));
                        result.setText("" + reciprocal);
                        flagReciprocal = true;
                    }
                }
            }
        });
        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showM.setText("");
                Memory = 0;
            }
        });
        btnMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String showMemory = showM.getText().toString();
                if (!showMemory.equals("")) {
                    String input = edit.getText().toString();
                    if (input.charAt(input.length() - 1) == '+' || input.charAt(input.length() - 1) == '-' || input.charAt(input.length() - 1) == '*' || input.charAt(input.length() - 1) == '/') {
                        if (Memory % 1.0 == 0) {
                            edit.setText(input + (long) Memory);
                        } else {
                            edit.setText(input + Memory);
                        }
                    } else {
                        if (Memory % 1.0 == 0) {
                            edit.setText(input + (long) Memory);
                        } else {
                            edit.setText("" + Memory);
                        }
                    }
                    flagCommand = false;
                }
            }
        });
        btnMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = result.getText().toString();
                if (!input.equals("")) {
                    if (input.charAt(0) == 'S') {
                        Memory = Double.parseDouble(input.substring(Checksqrt.checkSqrt(input)));
                        showM.setText("M");
                    } else {
                        Memory = Double.parseDouble(input);
                        showM.setText("M");
                    }
                }
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = result.getText().toString();
                if (!input.equals("") && showM.getText().equals("")) {
                    if (input.charAt(0) == 'S') {
                        Memory = Double.parseDouble(input.substring(Checksqrt.checkSqrt(input)));
                        showM.setText("M");
                    } else {
                        Memory = Double.parseDouble(input);
                        showM.setText("M");
                    }
                    flagMemory = true;
                } else if (!showM.getText().equals("") && !input.equals("")) {
                    if (input.charAt(0) == 'S') {
                        Memory += Double.parseDouble(input.substring(Checksqrt.checkSqrt(input)));
                        if (Memory % 1.0 == 0) {
                            result.setText("" + (long) Memory);
                        } else {
                            result.setText("" + Memory);
                        }
                    } else {
                        Memory += Double.parseDouble(input);
                        if (Memory % 1.0 == 0) {
                            result.setText("" + (long) Memory);
                        } else {
                            result.setText("" + Memory);
                        }
                    }
                    flagReciprocal = false;
                    flagMemory = true;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
