package com.study.library.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ParamsPrintAop {

    // Aspect 를 적용할 포인트컷을 정의합니다.
    @Pointcut("@annotation(com.study.library.aop.annotation.ParamsPrintAspect)")
    private void pointCut() {}

    // 포인트컷 주변에 적용할 어드바이스를 정의합니다.
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 호출되는 메서드의 시그니처를 가져와서 분석합니다.
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        // 클래스 이름을 가져옵니다.
        String className = codeSignature.getDeclaringTypeName();
        // 메서드 이름을 가져옵니다.
        String methodName = codeSignature.getName();
        // 메서드의 파라미터 이름들을 가져옵니다.
        String[] argNames = codeSignature.getParameterNames();
        // 메서드에 전달된 인자들을 가져옵니다.
        Object[] args = proceedingJoinPoint.getArgs();

        // 로깅을 통해 파라미터들을 출력합니다.
        for (int i = 0; i < argNames.length; i++) {
            log.info("{}: {} ({}.{})", argNames[i], args[i], className, methodName);
        }

        // 원래의 메서드 호출을 수행하고 결과를 반환합니다.
        return proceedingJoinPoint.proceed();
    }
}