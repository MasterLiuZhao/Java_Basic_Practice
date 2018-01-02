package com.liuzhao.lambda;

public class InterfaceLambdaTest1 {

    public static void main(String[] args) {

        InterfaceLambda1 sss = new InterfaceLambda1() {

            @Override
            public Integer convertFromString(String number) {
                return Integer.valueOf(number);
            }

        };

        int normalImplement = sss.convertFromString("13345");
        System.out.println(normalImplement);

        //String number;
        InterfaceLambda1 test1 = number -> Integer.valueOf(number);

        int lambdaImplement = test1.convertFromString("6789");
        System.out.println(lambdaImplement);



    }

}
