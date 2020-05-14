package jvm.finalize;

public class FinalizeEscapeGC {
        public static FinalizeEscapeGC SAVE_HOOK = null;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize method Test");
//            FinalizeEscapeGC2.SAVE_HOOK = this;
            SAVE_HOOK = this;
        }
    }