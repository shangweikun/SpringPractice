package test.world.spring.hello.springtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        System.out.println(s.add(new String("1")));
        System.out.println(s.add(new String("1")));

        String SL = "你好,我去,哈哈哈";
        String S2 = "1,2,2";
        System.out.println(SL.split(",").length == S2.split(",").length);
        for(String one:SL.split(",")){
            System.out.println(one);
        }
        List<String> list2 = Arrays.asList("文学","小说","历史","言情","科幻","悬疑");

        String string2 = list2.stream().collect(Collectors.joining("\n"));
        System.out.println(string2);
    }
}
