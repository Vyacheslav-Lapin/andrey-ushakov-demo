package ru.vlapin.demo.andreyushakovdemo.config;

import static java.lang.System.out;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import ru.vlapin.demo.andreyushakovdemo.model.Drink;
import ru.vlapin.demo.andreyushakovdemo.model.Person;

@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Polite {
}

@Aspect
final class PoliteAspect {

  @Pointcut("@annotation(Polite) || within(@Polite *)")
  private void pointcut() {
  }

  @Before("pointcut() && args(person)")
  void sayHello(Person person) {
    out.printf("Hello %s. How are you doing?\n", person.getName());
  }

  @AfterReturning(pointcut = "pointcut()", returning = "drink")
  void askOpinion(Drink drink) {
    out.printf("Is %s Good Enough?\n", drink.getName());
  }

  @AfterThrowing("pointcut()")
  void sayYouAreNotAllowed() {
    out.println("Hmmm...");
  }

  @After("pointcut()")
  void sayGoodBye() {
    out.println("Good Bye!");
  }

  @Around("pointcut()")
  Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
    out.println(("Hi!"));
    Object retVal = pjp.proceed();
    out.println(("See you!"));
    return retVal;
  }
}
