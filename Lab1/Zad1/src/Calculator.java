/**
 * Created by Hunter on 2015-03-08.
 */
    public class Calculator implements CalculatorImp {
        @Override
        public int add(int a, int b) {
            return a+b;
        }
        @Override
        public int sub(int a, int b) {
            return a-b;
        }
        @Override
        public int multi(int a, int b) {
            return a*b;
        }
        @Override
        public int div(int a, int b) {
            return a/b;
        }
        @Override
        public boolean greater(int a, int b) {
            if(a>b) return true;
            else return false;
        }
    }
