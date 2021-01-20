public class test {
    public static void main(String[] args) {
        ContextStateProject testCtx = new ContextStateProject();
        System.out.println(testCtx.getCurrentState());

        testCtx.goNextState();
        System.out.println(testCtx.getCurrentState());

        testCtx.goNextState();
        System.out.println(testCtx.getCurrentState());

        testCtx.goNextState();
        System.out.println(testCtx.getCurrentState());
    }
}
