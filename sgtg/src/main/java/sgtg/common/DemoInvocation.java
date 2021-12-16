package sgtg.common;

import org.apache.commons.logging.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoInvocation {
    // ログ出力のためのクラス
    private static Log log = LogFactory.getLog(DemoInvocation.class);

    /**
     * Beforeアノテーションにより、指定したメソッドの前に処理を追加する
     * Beforeアノテーションの引数には、Pointcut式 execution(戻り値 パッケージ.クラス.メソッド(引数))
     * を指定し、ここではControllerクラスの全メソッドの実行前にログ出力するようにしている
     *
     * @param jp 横断的な処理を挿入する場所
     */
    @Before("execution(* sgtg.controller.*Controller.*(..))")
    public void startLog(JoinPoint jp) {
        // 開始ログを出力
        log.info("Starting " + jp.getThis());
    }

    /**
     * Afterアノテーションにより、指定したメソッドの後に処理を追加する
     * Afterアノテーションの引数には、Pointcut式を指定
     *
     * @param jp 横断的な処理を挿入する場所
     */
    @After("execution(* sgtg.controller.*Controller.*(..))")
    public void endLog(JoinPoint jp) {
        // 終了ログを出力
        // 開始ログを出力
        log.info("End " + jp.getThis());
    }

    /**
     * Aroundアノテーションにより、指定したメソッドの前後に処理を追加する
     * Aroundアノテーションの引数には、Pointcut式を指定
     *
     * @param jp 横断的な処理を挿入する場所
     * @return 指定したメソッドの戻り値
     */
    @Around("execution(* sgtg.controller.*Controller.*(..))")
    public Object writeLog(ProceedingJoinPoint jp) {
        log.info(jp.getThis());
        // 返却オブジェクトを定義
        Object returnObj = null;
        // 指定したクラスの指定したメソッド名・戻り値を取得
        String signature = jp.getSignature().toString();
        // 開始ログを出力
        log.info("start writeLog : " + signature);
        try {
            // 指定したクラスの指定したメソッドを実行
            returnObj = jp.proceed();
        } catch (Throwable t) {
            log.error("error writeLog : ", t);
        }
        // 終了ログを出力
        log.debug("end writeLog : " + signature);
        // 指定したクラスの指定したメソッドの戻り値を返却
        // このように実行しないと、Controllerクラスの場合、次画面遷移が行えない
        return returnObj;
    }

}
