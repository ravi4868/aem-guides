package learning;

import java.util.*;
import java.util.stream.Collectors;

public class javaLearning {
    public static void main(String[] args) {

        String name="Ravi Rajamani";
        System.out.println(name);

        //reverse the string
        char[] names=name.toCharArray();
        StringBuilder sb= new StringBuilder();
        for(int i=names.length-1;i>=0;i--){
            sb.append(names[i]);
            System.out.println(names[i]);
        }
        System.out.println(sb);

        System.out.println( sb.reverse());

        String paragraph="ravi Rajamani";
        Map<Character,Integer> map=new HashMap<>();
        for(char c:paragraph.toLowerCase().toCharArray()){

            if(c !=' ')
                map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Character in:map.keySet()){
            System.out.println("number"+in+"values"+ map.get(in));
        }

        List<String> stringList =new ArrayList<>(); //it will preseve the insertion order
        stringList.add("ravi");
        stringList.add("kamala");
        stringList.add("arpana");
        stringList.add("abi");
        stringList.add("uma");
        stringList.add("");
        stringList.add("tanvi");
        stringList.add("sanvika");
        stringList.add("mitra");
        stringList.add("sanvika");
        System.out.println(stringList);
        //Filter Stream Filter
        System.out.println(stringList.stream().collect(Collectors.joining(",")));
        System.out.println(stringList.stream().findFirst());
        //insertion order will be maintained in list
        System.out.println(stringList.stream().filter(s->!s.equalsIgnoreCase("abi")).collect(Collectors.toList()));
        System.out.println(stringList.stream().filter(s->!s.equalsIgnoreCase("abi")&& !s.isEmpty()).collect(Collectors.toList()));
        //set will no t main the insertion order
        System.out.println(stringList.stream().filter(f->!f.equalsIgnoreCase("ravi") && !f.isEmpty()).collect(Collectors.toSet()));
        System.out.println(stringList.stream().filter(du->!du.isEmpty()).findFirst());
        Optional<String> opt=stringList.stream().filter(du->!du.isEmpty()).findFirst();
        System.out.println(opt.isPresent()?opt.get():"");

        //Stream map Intermediate Operations (Transformations like filter(), map(), sorted())

        System.out.println(stringList.stream().distinct().collect(Collectors.toList()));
        System.out.println(stringList.stream().anyMatch(s->s.equalsIgnoreCase("rr")));
        System.out.println(stringList.stream().allMatch(s->s.equalsIgnoreCase("ravi")));
        //Terminal Operations (End operations like collect(), forEach(), reduce())

        System.out.println(stringList.stream().count());
        //System.out.println(stringList.stream().map(p->p.equalsIgnoreCase("abi")).to);


        //For each
        //Conclusion
        //      - Use map() when transforming elements individually (one-to-one mapping).
        //- Use flatMap() when working with collections where each element contains multiple elements (one-to-many mapping).
        //- Both are powerful tools for handling complex data structures efficiently
          List<Employee> listEmpl = new ArrayList<>();

        for(int i=0;i<10;i++){
            listEmpl.add(new Employee(i+"Ravi ",i+"gmail.com",Arrays.asList("9916855705"+i,i+"72288")));
        }
        System.out.println("list of employee"+listEmpl.stream().count());
      //use of fliters
        System.out.println(listEmpl.stream().filter(s->!s.getName().equalsIgnoreCase("Ravi")).collect(Collectors.toList()));
    //use map.
        //get all employee names using map
        System.out.println(listEmpl.stream().map(Employee::getName).collect(Collectors.toList()));
        //use flat map -flatMap() is helpful when dealing with nested lists or data structures that need to be flattened into a single stream
        System.out.println(listEmpl.stream().flatMap(e->e.getPh().stream()).collect(Collectors.toList()));
        //use of sorted list
        System.out.println(listEmpl.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()));

        /*
        What is ‘stream’ in Java ? What was the purpose of introducing it ? How does it differ from a collection?
Ans: java.util.stream is a package introduced in jdk 1.8. It has several interfaces & classes to work on streams(flow of data). Classes under stream package introduced to support functional-style operations on the stream of elements. However, please note that Stream is not a collection rather it is a technique to make processing of collection’s data easy by supporting functional-style operations. Furthermore, Streams differs from a collection in several ways.

♠ A stream is not a data structure that stores elements.
♦ An operation on a stream produces a result, but does not modify its source.
♥ While collections have a finite size, streams need not.
♣ The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new stream must be generated to revisit the same elements of the source.
         */


    }
}
