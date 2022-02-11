/**
 * SYSC 4806 LAB 3
 * The purpose of the Launcher class is to initialize and launch the Spring framework
 * by creating an ApplicationContext and passing it an array containing the paths to the
 * bean definition file(s)
 *
 * @author Sarah Abdallah 101119716 (Taken from Intro to Spring using Swing Doc, Chad Woolley)
 * @version 2022-02-04
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher{
    public void launch(){
        String[] contextPaths=new String[]{"META-INF/app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}



//TEST