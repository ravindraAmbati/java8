![Java CI with Gradle](https://github.com/ravindraAmbati/java8/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)
# java8
<h2>New Functional Interfaces in Java 8</h2>
<ul>
    <li>Lambda = (method parameters)->{method definition}</li>
    <li>Method Reference - a shorcut to Lambdas = className::methodName</li>
</ul> 
<h4>java.util.functions</h4>
    <ul>
        <li>Consumer, BiConsumer</li>
        <li>Function, BiFunction, UnaryOperator, BinaryOperator</li>
        <li>Predicate, BiPredicate</li>
        <li>Supplier</li>
    </ul>
<h4>java.util.streams</h4>
    <ol>
        <li> add or remove operations can be done on collections only </li>
        <li> add or remove operations cannot be done on streams
                 students.stream().add 
                 students.stream().re 
        </li>
        <li> Collections can get particular object </li>
        <li> Streams cannot get any particular object 
                log.info(students.stream().get); 
        </li>
        <li> Streams are lazy performed - intermediate operations cannot be performed if terminal operations are not performed </li>
        <li> intermediate operations are filters </li>
        <li> terminal operations are collect </li>
        <li> Collections are eagerly construct </li>
        <li> Stream are lazy construct only invoke if terminal operations </li>
        <li> Collections are travers multiple times </li>
        <li> Stream are travers only once </li>
        <li> Collections iterate external </li>
        <li> Stream iterate internal </li>
        <li> studentGradeGreaterThan3Stream.collect(Collectors.toList()).forEach(s->log.info(s.toString())); </li>
        <li> it has been closed or stopped </li>
    </ol> 
    
<h4><b>operations</b> java.util.streams</h4>
    <ol>
    <li>map - convert one collections to another collection</li>
    <li>flatMap - convert map into flatMap i.e., Stream&lt;List&lt;String&gt;&gt; into Stream&lt;String&gt; - remove List into single group</li>
    <li>peek - returns the current Stream</li>
    <li>max - return max object by Comparator</li>
    <li>min - return max object by Comparator</li>
    <li>collect - convert stream into collections</li>
    <li>reduce - reduce the stream into single object by BinaryOperator</li>
    <li>allMatch - all objects should match in given stream for given predicate</li>
    <li>anyMatch - any objects should match in given stream for given predicate</li>
    <li>noneMatch - none objects should match in given stream for given predicate</li>
    <li>findAny - return first enumerated object, can also provide sorting</li>
    <li>findFirst - return first object, can also provide sorting</li>
    <li>limit - stream objects have been limited of given number </li>
    <li>skip - rest of stream objects have been skipped of given number</li>
    <li>count - return the objs count in current stream</li>
    <li>sorted - return the objs in sorting order by Comparator in current stream</li>
    <li>distinct - returns stream of distinct objects by Comparator</li>
    <li>filter - filter stream by Predicate</li>
    </ol>
<h4>short-circuiting</h4>
<p>
if(boolean1 && boolean2) // boolean2 will not be evaluated if boolean1 is false
if(boolean1 || boolean2) // boolean2 will not be evaluated if boolean1 is true
in Streams limit(), skip(), findAny(), findFirst(), anyMatch(), allMatch(), noneMatch() are short-circuiting operations
these are not operated on each object in the stream
</p> 
<h4>Stream static methods - create</h4>
    <ol>
        <li>Stream.of(var args of Objects)</li>
        <li>Stream.iterate(seed,unaryOperator)</li>
        <li>Stream.generate(supplier) </li>
    </ol>

<h4>Numeric Streams</h4>
    <ol>
        <li>IntStream - range,rangeClosed,sum,count,min,max,average,asDoubleStream,summaryStatistics,boxed,mapToObj</li>
        <li>LongStream - range,rangeClosed,sum,count,min,max,average,asDoubleStream,summaryStatistics,boxed,mapToObj</li>
        <li>DoubleStream - sum,count,min,max,average,summaryStatistics,boxed,mapToObj</li>
    </ol>
   
<h4>Terminal Operations</h4>
    <ul>
        <li>joining</li>
        <li>counting</li>
        <li>mapping</li>
    </ul>